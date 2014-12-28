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

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.image.MemoryImageSource;
import java.util.Random;

/**
 * <b>Class:</b> Storage<br>
 * <b>Version:</b> 1.9 - Dec 2014<br>
 * <b>Date:</b> 27 December 2014<br>
 * <b>Overview:</b> The Storage class provides the data storage object and methods required for the Dispersal Modeller
 *
 * @author Student 200825599 <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.9 - 27 Dec 2014
 */

public class Storage {
    //define a 300 x 300 array of type integer.
    double data[][] = new double[300][300];

    /**
     * Mutator method to populate array with data.
     * Returns nothing because we are modifying the object and not a reference to it.
     * @param dataIn The label used to modify the 2D data array though pass-by-reference
     */
    public void setData(double[][] dataIn) {
        data = dataIn;
    }
    

    /**
     * Method to return the double data of the object on which the method is executed
     * @return data Returns the object on which this method is executed.
     */
    public double[][] getData() {
        return data;
    }

    /**
     * Accessor method to print out a specific segment of the object's data. 
     * Returns nothing as we print out the values to the console.
     * @param startRow  integer specifying the start row for the method
     * @param startCol  integer specifying the start column for the method
     * @param endRow    integer specifying the end row for the method
     * @param endCol    integer specifying the end column for the method
     */
    public void printData(int startRow, int startCol, int endRow, int endCol) {
        //print out array (to verify cell contents)
        //outer loop for rows
        for (int i = startRow; i <= endRow; i++) {
            //inner loop for columns
            for (int j = startCol; j <= endCol; j++) {
                //print the columnar data on one line
                System.out.print(data[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Mutator method to convert the source object values from double to integer data type
     * @param srcArray Source data object containing data of type <b>double</b>
     * @return intArray Target data object containing data of type <b>integer</b>
     */
    public int[][] castDoubleToInt(double srcArray[][]) {
        //Create a label with method scope, to store the integer values temporarily
        int[][] intArray = new int[srcArray.length][srcArray[0].length];

        //Loop through the source object to parse and convert the data from double to integer primitive data type
        //outer loop for rows
        for (int i = 0; i < srcArray.length; i++) {
            //inner loop for columns
            for (int j = 0; j < srcArray[i].length; j++) {
                //Convert from double to integer data type by casting (explicit conversion)
                intArray[i][j] = (int) srcArray[i][j];
            }
        }
        //Return the integer data object
        return intArray;
    }

     /**
     * Accessor method to print out the full object contents to the console.
     */
    public void printArray() {
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                //print the columnar data on one line
                System.out.print(data[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Method to calculate and return the maximum value stored in the array
     * @return maximum A double containing the maximum value found in the array
     */
    public double getMaximum() {
        //calculate the maximum value contained by the array
        //Set the maximum to a negative value in order to ensure that it does 
        //not exceed the potentially largest positive value produced by Math.random()
        double maximum = -1;
        //Loop through the object rows and columns to parse the cell values
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > maximum) {
                    maximum = data[i][j];
                }
            }
        }
        //Return the maximum value
        return maximum;
    }

    /**
     * Method to calculate and return the minimum value in array
     * @return minimum A double containing the minimum value found in the array
     */
    public double getMinimum() {
        //calculate the minimum value contained by the array
        //Set the minimum to use the first cell in the array as the initial value. 
        //See http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part3/Analyst.java
        double minimum = data[0][0];
        //Loop through the object rows and columns to parse the cell values
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < minimum) {
                    minimum = data[i][j];
                }
            }
        }
        //Return the minimum value
        return minimum;
    }

    // Images are based on arrays containing values between 0 and 255. 
    // To convert our data into an image, we need to re-range it between these two values. 
    // We need a method that will take the data in our array, and stretch or compress the 
    // numbers across a given range, that is, the minimum value matches a new minimum, 
    // the maximum a new maximum, and the rest of the data is spread between them, 
    // proportional to the values in the original dataset. 
    
    /**
     * Method to re-range array values to a new minimum and maximum value
     * @param newMinimum A double defining the new minimum value limit
     * @param newMaximum A double defining the new maximum value limit
     * @return tempArray A 2D double array with the re-ranged values
     */
    public double[][] getRerangedData(double newMinimum, double newMaximum) {
        // Set up double variables containing currentMaximum and currentMinimum
        double currentMinimum = this.getMinimum();
        double currentMaximum = this.getMaximum();

        // Instantiate a double[][] array called tempArray, and size [data.length][data[0].length]
        double[][] tempArray = new double[data.length][data[0].length];

        //Loop through the object rows and columns to parse the cell values
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //outer loop for columns
            for (int j = 0; j < data[i].length; j++) {
                // tempArray[i][j] = data[i][j]
                tempArray[i][j] = data[i][j];

                // tempArray[i][j] = tempArray[i][j] - currentMinimum (so values between 0 and currentMaximum - currentMinimum)
                tempArray[i][j] -= currentMinimum;

                // tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum) (so values between 0 and 1)
                tempArray[i][j] /= (currentMaximum - currentMinimum);

                // tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum) (so values between 0 and newMaximum - newMinimum)
                tempArray[i][j] *= (newMaximum - newMinimum);

                // tempArray[i][j] = tempArray[i][j] + newMinimum (so values between newMinimum and newMaximum)
                tempArray[i][j] += newMinimum;
            }
        }
        //Return the tempArray 
        return tempArray;
    }

    /**
     * Mutator method to convert the 2D array object this is applied to, into a 1D array object.
     * @return tempArray A 1D array of type double
     */
    public double[] get1DArray() {
        //create a reranged array with values between 0.0 and 255.0
        double[][] reranged = getRerangedData(0.0, 255.0);

        //Convert 2D array into 1D array:
        int arraySize = reranged.length * reranged[0].length;
        double[] tempArray = new double[arraySize];

        //Loop through the object rows and columns to parse the cell values
        // Outer loop for rows
        for (int i = 0; i < reranged.length; i++) {
            // Inner loop for the columns
            // We would need a different algorithm for varying columnar dimensions.
            // Images are square or rectangular, most of the time, so we will use the following:
            for (int j = 0; j < reranged[0].length; j++) {
                //Assign the reranged values to the 1D array
                tempArray[(reranged[0].length * i) + j] = reranged[i][j];
            }
        }
        // return the 1D double tempArray 
        return tempArray;

    }

    /**
     * Method to convert a 2D array object into a grayscale image
     * @return image An image constructed from the "pixel" values
     */
    public Image getDataAsImage() {
        //Convert 2D image data array to 1D, reranged array with values between 0.0 and 255.0
        double[] data1Dreranged = get1DArray();

        //Instantiate an integer array with dimension equal to data1Dreranged.length
        int[] pixels = new int[data1Dreranged.length];
        //Loop through the object to parse the cell values
        for (int i = 0; i < pixels.length; i++) {
            //Get value of 1D array and cast as integer
            int value = (int) data1Dreranged[i];
            //Generate a grayscale cell by setting all 3 values the same
            Color pixel = new Color(value, value, value);
            pixels[i] = pixel.getRGB();
        }

        // Make a MemoryImageSource, remembering that data.length and
        // data[0].length give you the height and width of the data.
        MemoryImageSource memImage = new MemoryImageSource(data.length, data[0].length, pixels, 0, data.length);
        // Make an Image object.
        Panel panel = new Panel();
        Image image = panel.createImage(memImage);
        // Return the Image object. 
        return image;
    }

    /**
     * Method to locate the detonation point in a 2D array object. In this instance, the detonation point is indicated 
     * by a cell with a value of 255, while all the other cells have a value of 0. Only one detonation point will be 
     * located; as soon as the detonation point is located, the process is stopped to improve application performance.
     * @param srcArray The source object containing the single detonation point
     * @return detonationPoint A string containing the detonation point coordinates
     */
    public String locateDetonationPoint(double srcArray[][]) {
        //label for our detonation point 
        String detonationPoint = null;

        //outer loop for rows
        for (int i = 0; i <= srcArray.length - 1; i++) {
            //inner loop for columns
            for (int j = 0; j <= srcArray[0].length - 1; j++) {
                if (srcArray[i][j] == 255) {
                    detonationPoint = "{" + i + "," + j + "}";
                    //Stop processing here. No need to continue, unless we are looking for more than 1 detonation point
                    break;
                }

            }
        }
        //Return the string containing the detonation point coordinate pair value
        return detonationPoint;
    }

    /**
     * Method to create a random detonation point anywhere within the area of the source array. We determine the size of
     * the source array to ensure that we stay within its bounds, by subtracting 10% of the array size to implement as a
     * buffer zone on all four boundaries.
     * @param srcArray The source object used to define the boundaries and buffer zone sizes.
     * @return detonationPoint A string containing the randomly generated detonation point coordinates
     */
    public String setRandomDetonationPoint(double srcArray[][]) {

        //Calculate the boundary buffer size as an integer value at 10% of width and height of data source.
        //Find the data set boundaries by obtaining the maximum width and height and deducting the buffer area size
        int maxX = (int)(srcArray.length * 0.9);
        int maxY = (int)(srcArray[0].length * 0.9);

        //Use the Math.random() function to generate a pseudorandom double value between 0 and 1.0
        //Multiply the double by the maximum X and Y value and cast to integer
        int randomX = (int) (Math.random() * maxX);
        int randomY = (int) (Math.random() * maxY);

        //Build the detonation point array and return it to the caller
        String detonationPoint = "{" + randomX + "," + randomY + "}";
        
        //Return the string containing the randomly generated detonation point coordinate pair value
        return detonationPoint;
    }

    /**
     * Method to calculate the dispersal of the supplied number of bacteria, using the settings defined by the parameters 
     * supplied to the method. The method runs a sanity check on the parameters to check whether they fall within 
     * acceptable value ranges and satisfy logical conditions. If the sanity test fails, a warning message is displayed 
     * to the user.
     * @param bacteriaCount The integer number of particles to process
     * @param srcArrayRows The number of rows in the detonation point (source data) array
     * @param srcArrayCols The number of columns in the detonation point (source data) array
     * @param xPos The X coordinate value of the detonation point
     * @param yPos The Y coordinate value of the detonation point
     * @param changeNorthProbability The probability value for change in a <b>Northern</b> direction, expressed as an integer value
     *  out of 100. 
     * @param changeEastProbability The probability value for change in an <b>Eastern</b> direction, expressed as an integer value
     *  out of 100. 
     * @param changeSouthProbability The probability value for change in a <b>Southern</b> direction, expressed as an integer value
     *  out of 100. 
     * @param changeWestProbability The probability value for change in a <b>Western</b> direction, expressed as an integer value
     *  out of 100. 
     * @return dispersalArray An array containing the dispersal map, with the cell values representing the number of 
     * particles that landed in that cell.
     */
    public double[][] calculateDispersal(int startHeight, int bacteriaCount, int srcArrayRows, int srcArrayCols, int xPos, int yPos,
            int changeNorthProbability, int changeEastProbability, int changeSouthProbability, int changeWestProbability) {

        //Instantiate label for dispersal array, with size of the source array; initialised with all cell values at 0.0
        double[][] dispersalArray = new double[srcArrayRows][srcArrayCols];

        //Instantiate our local label for the detonation point coordinates, which is also each particles' start position
        int startbacteriumPosRow = xPos;
        int startbacteriumPosCol = yPos;
        
        //Define the labels to store the maximum row and column count
        final int maxRows = srcArrayRows - 1;
        final int maxColums = srcArrayCols - 1;

        // Default calculation approach; assuming that none of the parameters were modified:
        // From a given location, there is a 5% chance that in any given minute, given the current wind, that a particle
        // will blow west, a 10% chance of blowing north or south, and a 75% chance of blowing east. Calculate using
        // Math.Random with 0.0 – 0.05 as West, 0.05 – 0.8 as East, 0.8 – 0.9 as North and 0.9 upwards as South. One model iteration
        // is one second, and in each model iteration the longest potential movement is one pixel on screen, which is 1
        // metre's length. 
        // The building is 75m high. If the particle is above the height of the building there is a 20% chance each second
        // it will rise by a metre in turbulence, a 10% chance it will stay at the same level, and a 70% chance it will
        // fall. Below the height of the building the air is still, and the particles will drop by a metre a second.
        // Boundary issue: if particles make it to boundary and exceed it, cap to boundary value, e.g. (0,15) and move 1
        // meter North will be kept at (0,15).

        //Loop through the specified number of particles
        for (int b = 1; b <= bacteriaCount; b++) {
            //Local variables to use for processing. Reset them on each run, otherwise we drift off the map
            int height = startHeight; //initial height of the detonation; by default above the building, i.e. over 75m

            int bacteriumPosRow = startbacteriumPosRow;
            int bacteriumPosCol = startbacteriumPosCol;

            //The iterations stop when the particle lands on the ground (height == 0), or when it reaches the boundary.

            //Height component
            while (height > 0) {
                //if bacterium is higher than 75m, it loses 1m in height
                if (height < 75) {
                    height--;
                } else {
                    //At or below 75m height, there is a random chance of staying in place, move up or down
                    //Instantiate a new random generator
                    Random rd = new Random();
                    //Use nextDouble to obtain a more random distribution of pseudorandom values
                    double heightChange = rd.nextDouble();

                    //If less than 0.1, particle stays where it is, if > 0.1 and < 0.3, rise 1m, else fall 1m
                    if ((heightChange > 0.1) & (heightChange <= 0.3)) {
                        height++;
                    } else if (heightChange > 0.3) {
                        height--;
                    }
                }

                //Directional change component

                //Instantiate new random generator
                Random rd2 = new Random();
                //Use nextDouble for a more random distribution
                //Multiply by 100 and cast to integer in order to fall in the same order of magnitude and 
                //primitive type as the probability values
                int directionChange = (int) (rd2.nextDouble() * 100);

                //Switching to CASE control loop doesn't work with numbers like this really, so we stick with an if-else-if ladder
                //See http://stackoverflow.com/questions/10873590/in-java-using-switch-statement-with-a-range-of-value-in-each-case
                
                //Build up the break points to use for the direction change by cumulatively adding the probabilities 
                //for the different directions, i.e 
                //0 - changeNorthProbability => go North 
                //changeNorthProbability < directionChange <= (changeNorthProbability + changeEastProbability) => go East
                //(changeNorthProbability + changeEastProbability) < directionChange <= (changeNorthProbability + changeEastProbability + changeSouthProbability) => go South
                //(changeNorthProbability + changeEastProbability + changeSouthProbability) < directionChange <= (changeNorthProbability + changeEastProbability + changeSouthProbability + changeWestProbability) => go West
                // e.g for changeNorthProbability 10%, changeEastProbability 65%, changeSouthProbability 20%, changeWestProbability 5%
                //0 - 10 => North
                //10 < directionChange <= (10 + 65) => go East
                //(10 + 65) < directionChange <= (10 + 65 + 20) => go South
                //(10 + 65 + 20) < directionChange <= (10 + 65 + 20 + 5) => go West
                //Error checking on the total probability before submission to this method ensures that we do not exceed 100%
                if ((directionChange >= 0) && (directionChange <= changeNorthProbability)) {
                    //Go North
                    //location j-1 one row up
                    bacteriumPosRow--;
                } else if ((directionChange > changeNorthProbability) & (directionChange <= (changeNorthProbability + changeEastProbability))) {
                    //Go East
                    //location i+1 one column right
                    bacteriumPosCol++;
                } else if ((directionChange > (changeNorthProbability + changeEastProbability))
                        & (directionChange <= (changeNorthProbability + changeEastProbability + changeSouthProbability))) {
                    //Go South
                    //location j+1 one row down 
                    bacteriumPosRow++;
                } else if ((directionChange > (changeNorthProbability + changeEastProbability + changeSouthProbability))
                        & (directionChange <= (changeNorthProbability + changeEastProbability + changeSouthProbability + changeWestProbability))) {
                    //Go West
                    //location i-1 one column left
                    bacteriumPosCol--;
                } 

                //Height is now 0, step to the next particle and repeat the process
            }
            
            //Assign the particle position to the density map, with constraints to keep inside source array surface area. 
            //If it exceeds the upper boundary, assign it the value of the upper boundary. If it exceeds the lower boundary, 
            //assign it the value of the lower boundary.
            if (bacteriumPosRow > maxRows) {
                bacteriumPosRow = maxRows;
            } else if (bacteriumPosRow < 0) {
                bacteriumPosRow = 0;
            }

            if (bacteriumPosCol >= maxColums) {
                bacteriumPosCol = maxColums;
            } else if (bacteriumPosCol < 0) {
                bacteriumPosCol = 0;
            }
            //Increase the value of the resting position cell to indicate that another particle landed on this cell
            dispersalArray[bacteriumPosRow][bacteriumPosCol] += 1;

        }
        // return the density map array
        return dispersalArray;
    }

}
