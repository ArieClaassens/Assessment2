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
package BacterialBomb;

/*
 import java.awt.*;
 import java.awt.event.*; 
 */

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;



/**
 * Class: Analyst.java <br>
 * Version: 1.8 <br>
 * Date: 29 Nov 2014<br>
 * Overview:The Analyst class provides the framework for a basic GIS application utilized in the GEOG5561M course<br>
 * The application loads a dataset containing a bacterial bomb detonation point and calculates the dispersal of 5000 bacteria.
 *
 * @author Student 200825599
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.8 - 29 Nov 2014
 * @since 29 November 2014
 */
public class Analyst extends Frame implements ActionListener {

    /**/
    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(Color.red);
        ga.drawLine(200, 100, 200, 300);
    }

    //put storage and io objects in here
    //Instantiate new Storage object
    Storage store = new Storage();
    //Instantiate new IO object
    IO io = new IO();

    public Analyst() {
        // Our Analyst code this practical will go here.
        //Instantiate new frame, define properties and set to visible
        Frame frame = new Frame("Bacterial Bomb Dispersal Modelling");

        //Add listener to catch windowClosing events
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        System.exit(0);
                    }
                }
        );

        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        //frame.setBackground(Color.BLUE);
        //frame.setBackground(Color.white);
        //frame.setForeground(Color.white);

        //Add new menubar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.add(fileMenu);

        //Add MenuItem to Open file
        MenuItem openMenuItem = new MenuItem("Open...");
        fileMenu.add(openMenuItem);
        //Add Listener
        openMenuItem.addActionListener(this);

        //Add MenuItem to Save file
        MenuItem saveMenuItem = new MenuItem("Save...");
        fileMenu.add(saveMenuItem);
        //Add Listener
        saveMenuItem.addActionListener(this);

        //Add MenuItem to Exit app
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.add(exitMenuItem);
        //Add Listener
        exitMenuItem.addActionListener(this);

        //Process menu list
        Menu processMenu = new Menu("Process");
        menuBar.add(processMenu);
        //Add Randomise to Process file
        MenuItem randomDataMenuItem = new MenuItem("Generate Random Data");
        processMenu.add(randomDataMenuItem);
        //Add Listener
        randomDataMenuItem.addActionListener(this);
        
        //Process menu list
        Menu helpMenu = new Menu("Help");
        menuBar.add(helpMenu);
        //Add About Item
        MenuItem aboutMenuItem = new MenuItem("About");
        helpMenu.add(aboutMenuItem);
        //Add Listener
        aboutMenuItem.addActionListener(this);
        //Add Overview Item
        MenuItem overviewMenuItem = new MenuItem("Overview");
        helpMenu.add(overviewMenuItem);
        //Add Listener
        overviewMenuItem.addActionListener(this);

        //Set the menu bar
        frame.setMenuBar(menuBar);

        //Set frame to middle of screen
        frame.setLocationRelativeTo(null);

        //Activate frame
        frame.setVisible(true);

        //Call repaint to manually run the overridden paint method of object
        frame.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        MenuItem clickedMenuItem = (MenuItem) e.getSource();
        //Migrate to a case statement to switch between choices more efficiently
        String name = clickedMenuItem.getLabel();

        switch (name) {
            case "Open...":
                //Pull in the data file and find out the bombing point.

                //Open the file with the input data
                FileDialog fd = new FileDialog(this, "Open File", FileDialog.LOAD);
                fd.setVisible(true);
                File f = null;
                if ((fd.getDirectory() != null) || (fd.getFile() != null)) {
                    f = new File(fd.getDirectory() + fd.getFile());
                    store.setData(io.readData(f));
                    repaint();

                    //Find the detonation point
                    String detonationPoint = store.locateDetonationPoint(store.data);
                    System.out.println("detpoint is: " +detonationPoint);
                    
                    //Calculate where 5000 bacteria will end up.
                    
                    
                    
                    //Draws a density map of where all the bacteria end up as an image and displays it on the screen.
                    
                    
                    break;
                }

            case "Save...":
                //Save the density map to a file as text.
                //Save the file with the input data
                FileDialog fw = new FileDialog(this, "Save File", FileDialog.SAVE);
                fw.setVisible(true);
                File f2 = null;
                if ((fw.getDirectory() != null) || (fw.getFile() != null)) {
                    f2 = new File(fw.getDirectory() + fw.getFile());
                    io.writeData(store.data, f2);
                    break;
                }

            case "Generate Random Data":
                store.setRandomData();
                break;

            case "Exit":
                dispose();
                System.exit(0);
                break;
                
            case "About":
                System.out.println("ABOOT");
                break;
                
            case "Overview":
                System.out.println("OVERVIEW");
                break;

            default:
                System.out.println("You broke it.....");
                System.exit(500);
        }

        //repaint();
    }

    
    /*
    public void paint(Graphics g) {

        g.drawString("Hello World", 100, 100);
        Image image = store.getDataAsImage(); // or equivalent
        g.drawImage(image, getInsets().left, getInsets().top, this);
        g.setColor(Color.red);
        g.drawLine(10, 10, 300, 200); 	// x1, y1, x2, y2
        g.drawString("hello World", 50, 50);
    }
    */
    
    public static void main(String args[]) {
        new Analyst();
    }

}
