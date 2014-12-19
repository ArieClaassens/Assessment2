package BacterialBomb;

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
 * A complete Java class that demonstrates how to create an HTML viewer with styles, using the JEditorPane,
 * HTMLEditorKit, StyleSheet, and JFrame.
 *
 * @author alvin alexander, devdaily.com.
 * http://alvinalexander.com/blog/post/jfc-swing/how-create-simple-swing-html-viewer-browser-java
 */
public class HTMLHelp {

    /*
     public static void main(String[] args)
     {
     new HtmlEditorKitTest();
     }
     */
    public HTMLHelp() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // create jeditorpane
                JEditorPane jEditorPane = new JEditorPane();

                // make it read-only
                jEditorPane.setEditable(false);

                // create a scrollpane; modify its attributes as desired
                JScrollPane scrollPane = new JScrollPane(jEditorPane);

                // add an html editor kit
                HTMLEditorKit kit = new HTMLEditorKit();
                jEditorPane.setEditorKit(kit);

                // add some styles to the html
                //StyleSheet styleSheet = kit.getStyleSheet();
                //styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
                //styleSheet.addRule("h1 {color: blue;}");
                //styleSheet.addRule("h2 {color: #ff0000;}");
                //styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");
                
                //From http://www.avajava.com/tutorials/lessons/how-do-i-convert-a-web-page-to-a-string.html and
                //http://www.java2s.com/Code/JavaAPI/java.lang/ClassgetResourceStringnamerelativetotheclasslocation.htm
                String htmlString = "";
                
                try {
			URL url = DispersalModeller.class.getResource("/bacterialbomb/help.html");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();
                        htmlString = result;

			//System.out.println("*** BEGIN ***");
			//System.out.println(result);
			//System.out.println("*** END ***");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

                // create a document, set it on the jeditorpane, then add the html
                Document doc = kit.createDefaultDocument();
                jEditorPane.setDocument(doc);
                jEditorPane.setText(htmlString);

                // now add it all to a frame
                JFrame j = new JFrame("BADdm Help File");
                j.getContentPane().add(scrollPane, BorderLayout.CENTER);

                // make it easy to close the application
                //Disable this action to prevent the Kit from killing the whole application NB!!!!!!
                //j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // display the frame
                j.setSize(new Dimension(600, 400));

                // pack it, if you prefer
                //j.pack();
                // center the jframe, then make it visible
                j.setLocationRelativeTo(null);
                j.setVisible(true);
            }
        });
    }
}
