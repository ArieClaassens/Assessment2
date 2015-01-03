/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK.
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

//Define this class to be part of the BacterialBomb package
package BacterialBomb;

//Import the required standard Java classes. 
//NetBeans automatically converts wildcard imports to select only the required classes.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

/**
 * <b>Class:</b> HTMLHelp<br>
 * <b>Version:</b> 1.0 - Dec 2014<br>
 * <b>Date:</b> 27 December 2014<br>
 * <b>Overview:</b> The HTMLhelp class provides a complete Java class that creates an HTML viewer 
 * with styles, using the JEditorPane, HTMLEditorKit, StyleSheet, and JFrame. Removed the styles section in favor of using 
 * inline CSS styles inside the HTML file. Based on code from 
 * <a href="http://alvinalexander.com/blog/post/jfc-swing/how-create-simple-swing-html-viewer-browser-java" target="_blank">
 * alvinalexander.com</a>
 *
 * @author alvin alexander, devdaily.com.
 * @author Student 200825599 <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.1 - 27 Dec 2014
 */
public class HTMLHelp {

    /**
     * Method to construct a read-only jEditorPane inside a jFrame and embed HTML content in the jEditorPane. Provides a
     * pop-up window displaying the help file contents; as a single purpose class, it requires no parameters. The relative 
     * location of the help file is hardwired into the class code.
     */
    public HTMLHelp() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Create a jEditorPane
                JEditorPane jEditorPane = new JEditorPane();

                //Make it read-only
                jEditorPane.setEditable(false);

                //Create a jScrollPane; modify its attributes as desired
                JScrollPane scrollPane = new JScrollPane(jEditorPane);

                //Add an HTML Editor Kit
                HTMLEditorKit kit = new HTMLEditorKit();
                jEditorPane.setEditorKit(kit);
                
                //From http://www.avajava.com/tutorials/lessons/how-do-i-convert-a-web-page-to-a-string.html and
                //http://www.java2s.com/Code/JavaAPI/java.lang/ClassgetResourceStringnamerelativetotheclasslocation.htm
                //Set up the label that will hold our HTML content
                String htmlString = "";
                
                try {
                        //Set up the URL to the help file
			URL url = DispersalModeller.class.getResource("help.html");
                        //Open the URL connection to the help file
			URLConnection urlConnection = url.openConnection();
                        //Create the InputStream and InputStreamReader and ingest the help file contents
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

                        //Parse the InputStreamReader contents and push it into the StringBuffer
			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
                        //Convert the StringBuffer into a String and pass its contents to the htmlString label
			String result = sb.toString();
                        htmlString = result;

                //Catch errors related to URL construction
		} catch (MalformedURLException e) {
			e.printStackTrace();
                //Catch I/O errors when attempting to read the help file contents
		} catch (IOException e) {
			e.printStackTrace();
		}

                // Create a document, set it on the jEditorPane, then add the HTML content
                Document doc = kit.createDefaultDocument();
                jEditorPane.setDocument(doc);
                jEditorPane.setText(htmlString);

                //Add it all to a jFrame
                JFrame j = new JFrame("BADdm Help File");
                j.getContentPane().add(scrollPane, BorderLayout.CENTER);

                //Disable this action to prevent the Kit from closing the whole application
                //Make it easy to close the application
                //j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //Display the Frame
                //Set the Frame dimensions
                j.setSize(new Dimension(600, 400));
                
                //Center the jFrame
                j.setLocationRelativeTo(null);
                
                //Make the Frame visible
                j.setVisible(true);
            }
        });
    }
}
