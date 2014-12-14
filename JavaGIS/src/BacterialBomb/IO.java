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
 *
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.7 - 24 Nov 2014
 */
public class IO {

    public double[][] readData(File f) {
        // Our reading code will go here.
        //File f = new File("in.txt");
        //File f = new File("C:\\Git\\GEOG5561M\\src\\unpackaged\\framework6\\in.txt");

        // Set up a FileReader (must be in a try-catch block).
        FileReader fr = null;
        try {
            fr = new FileReader(f);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        // Wrap this in a BufferedReader
        BufferedReader br = new BufferedReader(fr);
        // Remember fr is a FileReader not a File.

        // Declare any variables needed below, including the two arrays.
        int lines = -1;
        String textIn = " ";
        String[] file = null;

        // Open a try block
        try {  //try to read the file
            // Read though counting the lines in the file.
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

        //TEST by printing the file array
        //System.out.println("file length: " + file.length);
        //for (int i = 0; i < file.length; i++) {
        //    System.out.println(file[i]);
        //}
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

        //TEST Print out 2D array
        //for (int i = 0; i < data.length; i++) {
        //    for (int j = 0; j < data[i].length; j++) {
        //        System.out.print(data[i][j] + ", ");
        //        data[i][j]++;
        //    }
        //    System.out.println("");
        //}
        // return the full double[][] array rather than an empty one.
        return data;
    }

    public void writeData(double[][] dataIn, File f) {
        // Our writing code will go here.
        BufferedWriter bw = null;

        try {
            //bw = new BufferedWriter(new FileWriter(new File("C:\\Git\\GEOG5561M\\src\\unpackaged\\framework6\\out.txt")));
            bw = new BufferedWriter(new FileWriter(f));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String tempStr = "";

        try {
            for (int i = 0; i < dataIn.length; i++) {
                for (int j = 0; j < dataIn[i].length; j++) {
                    tempStr = String.valueOf(dataIn[i][j]);
                    //System.out.print(tempStr + ", ");
                    bw.write(tempStr + ", ");

                }
                //System.out.println("");
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        // Code to make a FileWriter (again, in a try-catch block).
        // Code to wrap it in a BufferedWriter.
        // Open a try block.
        // Start of loops.
        // Code to change the double to a String.
        // Write the String to the file.
        // End loops
        // Close Buffer (and thus the FileWriter as well)
        // Close try block.
    }
}
