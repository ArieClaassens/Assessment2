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

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 */
public class Analyst extends Frame {

    public Analyst() {
        //PopUp frame = new PopUp();
        Frame frame = new Frame("Bacterial Bomb Dispersal Modeller");

        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        System.exit(0);
                    }
                }
        );

        //Add new menubar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.add(fileMenu);

        //Add MenuItem to Open file
        MenuItem openMenuItem = new MenuItem("Open...");
        fileMenu.add(openMenuItem);
        //Add Listener
        //openMenuItem.addActionListener(this);

        //Add MenuItem to Save file
        MenuItem saveMenuItem = new MenuItem("Save...");
        fileMenu.add(saveMenuItem);
        //Add Listener
        //saveMenuItem.addActionListener(this);

        //Add MenuItem to Exit app
        MenuItem exitMenuItem = new MenuItem("Exit");
        fileMenu.add(exitMenuItem);
        //Add Listener
        //exitMenuItem.addActionListener(this);

        //Process menu list
        Menu processMenu = new Menu("Process");
        menuBar.add(processMenu);
        //Add Randomise to Process file
        MenuItem randomDataMenuItem = new MenuItem("Generate Random Data");
        processMenu.add(randomDataMenuItem);
        //Add Listener
        //randomDataMenuItem.addActionListener(this);

        //Process menu list
        Menu helpMenu = new Menu("Help");
        menuBar.add(helpMenu);
        //Add About Item
        MenuItem aboutMenuItem = new MenuItem("About");
        helpMenu.add(aboutMenuItem);
        //Add Listener
        //aboutMenuItem.addActionListener(this);
        //Add Overview Item
        MenuItem overviewMenuItem = new MenuItem("Overview");
        helpMenu.add(overviewMenuItem);
        //Add Listener
        //overviewMenuItem.addActionListener(this);

        //Set the menu bar
        frame.setMenuBar(menuBar);

        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.BLUE);

        //frame.addNotify();
        frame.setBackground(Color.white);
        //frame.setForeground(Color.white);
        //Set frame to middle of screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.repaint();

        //Create a new panel
        Panel panel = new Panel();

        // Set panel background
        panel.setBackground(Color.green);

        // Create buttons
        Button b1 = new Button(); // Create a button with default constructor
        b1.setLabel("I am button 1"); // Set the text for button

        Button b2 = new Button("Button 2"); // Create a button with sample text
        b2.setBackground(Color.lightGray); // Set the background to the button

        // Add the buttons to the panel
        panel.add(b1);
        panel.add(b2);

        // Add the panel to the frame
        add(panel);

    }

    public static void main(String args[]) {
        new Analyst();

    }

}
