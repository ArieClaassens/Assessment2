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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * <b>Class:</b> IO<br>
 * <b>Version:</b> 1.8 - Dec 2014<br>
 * <b>Date:</b> 27 December 2014<br>
 * <b>Overview:</b> The IO class provides the data I/O (Input/Output) methods required by the Dispersal Modeller, based
 * on code from <a href="http://alvinalexander.com/java/edu/qanda/pjqa00009.shtml" target="_blank">alvinalexander.com</a>
 * @author Student 200825599 <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.8 - 27 Dec 2014
 */
public class IO {

    /**
     * Method to read data in from the supplied file
     * @param f File to parse
     * @return data Data parsed from the input file
     */
    public double[][] readData(File f) {

        // Set up a FileReader
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        //Catch any File not found exceptions
        } catch (FileNotFoundException fnfe) {
            //Print the stack trace for the exception
            fnfe.printStackTrace();
        }

        //Wrap this in a BufferedReader
        BufferedReader br = new BufferedReader(fr);

        // Declare labels to hold a line counter, text to read in and the file name.
        int lines = -1;
        String textIn = " ";
        String[] file = null;

        // Open a try block to read the file
        try {  
            // Read through, counting the lines in the file.
            while (textIn != null) {
                textIn = br.readLine();
                lines++;
            }
        } catch (IOException ioe) { //catch any errors
            ioe.printStackTrace();  //print a stacktrace if it bombs out
        } finally { //do this in the end, to play nice and close the file
            {
                try { //try to close the file/buffer
                    br.close();
                } catch (IOException e2) { //catch any errors
                    e2.printStackTrace(); //print the stacktrace
                }
            }
        }

        // Close the buffer and make a new FileReader and BufferedReader
        // (you can use the same labels).
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Make an appropriately sized 1D String array.
        file = new String[lines];

        // Loop, copying file lines into the array, one line per cell.
        try {
            for (int i = 0; i < lines; i++) {
                file[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {  // Close the Buffer (and thus the Reader as well).
                br.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } // Close try-catch block.

        // Run through the array and use a StringTokenizer 
        // to parse the data into a double[][] array.
        double[][] data = new double[lines][];

        for (int i = 0; i < lines; i++) {
            StringTokenizer st = new StringTokenizer(file[i], ", "); //split on , and space combo
            data[i] = new double[st.countTokens()];
            int j = 0;
            while (st.hasMoreTokens()) {
                data[i][j] = Double.parseDouble(st.nextToken());
                //data[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        // return the full double[][] array rather than an empty one.
        return data;
    }

    /**
     * Method to write a double data type object to a file
     * @param dataIn Data object containing <b>double</b> values, which will be written to file
     * @param f File to which the data will be written. If the file exists, its contents will be discarded 
     */
    public void writeData(double[][] dataIn, File f) {
        //Instantiate a BufferedWriter 
        BufferedWriter bw = null;

        //try creating the BufferedWriter using a FileWriter on the supplied file, catching any exceptions that may occur
        try {
            bw = new BufferedWriter(new FileWriter(f));
        } catch (IOException e) {
            //Print the stack trace in case of an exception
            e.printStackTrace();
        }

        String tempStr = "";

        //Try looping through the data object to build up the BufferedWriter contents
        try {
            for (int i = 0; i < dataIn.length; i++) {
                for (int j = 0; j < dataIn[i].length; j++) {
                    tempStr = String.valueOf(dataIn[i][j]);
                    bw.write(tempStr + ", ");

                }
                //Add a new line
                bw.newLine();
            }
            //Flush the BufferedWriter contents
            bw.flush();
        //Catch the IO exception and print the stack trace
        } catch (IOException e) {
            e.printStackTrace();
        //At the end, try closing the file; catch IO exceptions and print the stack trace for the exception
        } finally {
            try {
                bw.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    /**
     * Method to write an integer data object to a file
     * @param dataIn Data object containing <b>integer</b> values, which will be written to file
     * @param f File to which the data will be written. If the file exists, its contents will be discarded 
     */
    public void writeIntData(int[][] dataIn, File f) {
        //Instantiate a BufferedWriter 
        BufferedWriter bw = null;

        //try creating the BufferedWriter using a FileWriter on the supplied file, catching any exceptions that may occur
        try {
            bw = new BufferedWriter(new FileWriter(f));
        } catch (IOException e) {
            //Print the stack trace in case of an exception
            e.printStackTrace();
        }

        String tempStr = "";

        //Try looping through the data object to build up the BufferedWriter contents
        try {
            for (int i = 0; i < dataIn.length; i++) {
                for (int j = 0; j < dataIn[i].length; j++) {
                    tempStr = String.valueOf(dataIn[i][j]);
                    bw.write(tempStr + ", ");

                }
                //Add a new line
                bw.newLine();
            }
            //Flush the BufferedWriter contents
            bw.flush();
        //Catch the IO exception and print the stack trace
        } catch (IOException e) {
            e.printStackTrace();
        //At the end, try closing the file; catch IO exceptions and print the stack trace for the exception
        } finally {
            try {
                bw.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}


