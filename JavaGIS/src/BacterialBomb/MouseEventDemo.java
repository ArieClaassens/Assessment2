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

/**
 *
 * @author Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 */
//http://www.ntu.edu.sg/home/ehchua/programming/java/j4a_gui.html

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
public class MouseEventDemo extends Frame implements MouseListener {
 
   // Private variables
   private TextField tfMouseX; // to display mouse-click-x
   private TextField tfMouseY; // to display mouse-click-y
 
   // Constructor - Setup the UI
   public MouseEventDemo() {
      setLayout(new FlowLayout()); // "super" frame sets layout
 
      // Label
      add(new Label("Manually specify a detonation point for the modeller by clicking on the map ")); // "super" frame adds component
      add(new Label("or entering the coordinate values and then clicking the Start modelling button"));  
      
      // Label
      add(new Label("X position: ")); // "super" frame adds component
 
      // TextField
      tfMouseX = new TextField(5); // 10 columns
      //tfMouseX.setEditable(false);  // read-only
      add(tfMouseX);                // "super" frame adds component
 
      // Label
      add(new Label("Y position: ")); // "super" frame adds component
 
      // TextField
      tfMouseY = new TextField(5);
      //tfMouseY.setEditable(false);  // read-only
      add(tfMouseY);                // "super" frame adds component
 
      addMouseListener(this);
          // "super" frame fires the MouseEvent
          // "super" frame adds "this" object as MouseEvent listener
      
      // Label for process button
      Button btn1 = new Button("Start modelling");
      add(btn1);
 
      setTitle("MouseEvent Demo"); // "super" Frame sets title
      setSize(450, 450);           // "super" Frame sets initial size
      setVisible(true);            // "super" Frame shows
   }
 
   public static void main(String[] args) {
      new MouseEventDemo();  // Let the constructor do the job
   }
 
   // MouseEvent handlers
   @Override
   public void mouseClicked(MouseEvent e) {
      tfMouseX.setText(e.getX() + "");
      tfMouseY.setText(e.getY() + "");
   }
 
   @Override
   public void mousePressed(MouseEvent e) { }
   @Override
   public void mouseReleased(MouseEvent e) { }
   @Override
   public void mouseEntered(MouseEvent e) { }
   @Override
   public void mouseExited(MouseEvent e) { }
}