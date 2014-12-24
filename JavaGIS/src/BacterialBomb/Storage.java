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
 import java.awt.image.*; 
 */
import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.image.MemoryImageSource;
import java.util.Random;

/**
 * Class: Storage.java<br>
 * Version: 1.8 - Nov 2014<br>
 * Overview: The Storage class provides the storage object and its methods that are required for a basic GIS application
 * utilized in the GEOG5561M course
 *
 * @author Student 200825599
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.8 - 30 Nov 2014
 */
public class Storage {

    //define a 300 x 300 array of type int (300 rows by 300 columns)
    double data[][] = new double[300][300];

    /*
     * Mutator method to populate array with data.
     * Returns nothing because we are modifying the object and not a reference to it.
     * @param newData   The placeholder variable used to modify the data[][] array
     */
    /*
     public void setData(double[][] newData) {
     //outer loop for rows
     for (int i = 0; i < newData.length; i++) {
     //inner loop for columns
     for (int j = 0; j < newData[i].length; j++) {
     data[i][j] = newData[i][j];
     }
     }
     }
     */
    //from practical notes - > http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part5/2.html

    /**
     *
     * @param dataIn
     */
        public void setData(double[][] dataIn) {
        data = dataIn;
    }

    /*
     * Accessor method to return storage object contents
     * Returns a 2D array of double primitive type
     * Accepts integers to define the startRow, startCol*umn), endRow and endCol(umn) parameters of the method
     * @param startRow  integer specifying the start row for the method
     * @param startCol  integer specifying the start column for the method
     * @param endRow    integer specifying the end row for the method
     * @param endCol    integer specifying the end column for the method
     * @return myArray  2D array consisting of double primitive type data
     */
    /*
     public double[][] getData(int startRow, int startCol, int endRow, int endCol) {
     //calculate dimensions of the array to return
     int myrows = endRow - startRow + 1;
     int mycolumns = endCol - startCol + 1;
     double[][] myArray = new double[myrows][mycolumns];
     //outer loop for rows
     for (int i = startRow; i <= endRow; i++) {
     //inner loop for columns
     for (int j = startCol; j <= endCol; j++) {
     myArray[i][j] = data[i][j];
     }
     }
     return myArray;
     }
     */
    //From Practical -> http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part5/2.html

    /**
     *
     * @return
     */
        public double[][] getData() {
        return data;
    }

    /*
     * Additional Accessor method to obtain data from array elements.
     * Returns nothing as we print out the value to console from this method.
     * @param startRow  integer specifying the start row for the method
     * @param startCol  integer specifying the start column for the method
     * @param endRow    integer specifying the end row for the method
     * @param endCol    integer specifying the end column for the method
     */

    /**
     *
     * @param startRow
     * @param startCol
     * @param endRow
     * @param endCol
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

    
    //Convert the source object values from double to integer data type

    /**
     *
     * @param srcArray
     * @return
     */
        public int[][] castDoubleToInt(double srcArray[][]) {
        
        //Create a label with scope restricted to this method, where we can store the integer values temporarily
        int[][] intArray = new int[srcArray.length][srcArray[0].length];

        //outer loop for rows
        for (int i = 0; i < srcArray.length; i++) {
            //inner loop for columns
            for (int j = 0; j < srcArray[i].length; j++) {
                //Convert from double to integer data type by casting (explicit conversion)
                intArray[i][j] = (int)srcArray[i][j];
                //System.out.println("We're on i: " + i + "  j: " +  j);
            }
        }
        return intArray;
    }

    /*
     * Method to print out the object (array) contents
     * Accepts and returns nothing
     */

    /**
     *
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

    /*
     * Method to calculate and return the maximum value contained in the array
     * @return A double containing the maximum value found in the array
     */

    /**
     *
     * @return
     */
    
    public double getMaximum() {
        //calculate the maximum value contained by the array
        //Set the maximum to a negative value in order to ensure that it does 
        //not exceed the potentially largest positive value produced by Math.random()
        double maximum = -1;
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > maximum) {
                    maximum = data[i][j];
                }
            }
        }
        return maximum;
    }
    /*
     * Method to calculate and return the minimum value in array
     * @return A double containing the minimum value found in the array
     */

    /**
     *
     * @return
     */
    public double getMinimum() {
        //calculate the minimum value contained by the array
        //Set the minimum to use the first cell in the array as the initial value. 
        //See http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part3/Analyst.java
        double minimum = data[0][0];

        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < minimum) {
                    minimum = data[i][j];
                }
            }
        }
        return minimum;
    }

    /*
     * Method to re-range array values to a new minimum and maximum value
     * @param newMinimum A double defining the new minimum value limit
     * @param newMaximum A double defining the new maximum value limit
     * @return 2D double array with the re-ranged values
     */
    // Images are based on arrays containing values between 0 and 255. 
    // To convert our data into an image, we need to re-range it between these two values. 
    // We need a method that will take the data in our array, and stretch or compress the 
    // numbers across a given range, that is, the minimum value matches a new minimum, 
    // the maximum a new maximum, and the rest of the data is spread between them, 
    // proportional to the values in the original dataset. 

    /**
     *
     * @param newMinimum
     * @param newMaximum
     * @return
     */
        public double[][] getRerangedData(double newMinimum, double newMaximum) {
        // Set up double variables containing currentMaximum and currentMinimum
        double currentMinimum = this.getMinimum();
        double currentMaximum = this.getMaximum();

        // Instantiate a double[][] array called tempArray, and size [data.length][data[0].length]
        double[][] tempArray = new double[data.length][data[0].length];

        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //outer loop for columns
            for (int j = 0; j < data[i].length; j++) {
                // tempArray[i][j] = data[i][j]
                tempArray[i][j] = data[i][j];

                // tempArray[i][j] = tempArray[i][j] - currentMinimum (so values between 0 and currentMaximum - currentMinimum)
                tempArray[i][j] = tempArray[i][j] - currentMinimum;

                // tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum) (so values between 0 and 1)
                tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum);

                // tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum) (so values between 0 and newMaximum - newMinimum)
                tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum);

                // tempArray[i][j] = tempArray[i][j] + newMinimum (so values between newMinimum and newMaximum)
                tempArray[i][j] = tempArray[i][j] + newMinimum;
            }
        }
        // return double [][] tempArray 
        return tempArray;
    }

    /*
     * Mutator method to save our object (2D array) data into a 1D array.
     * Accepts a 2D array of type double and retuns a 1D array of the same type
     * @param 2D array of type double
     * @return 1D array of type double
     */

    /**
     *
     * @return
     */
    
    public double[] get1DArray() {
        //create a reranged array
        double[][] reranged = getRerangedData(0.0, 255.0);

        //Convert 2D array into 1D array:
        int arraySize = reranged.length * reranged[0].length;
        double[] tempArray = new double[arraySize];

        // Outer loop for rows
        for (int i = 0; i < reranged.length; i++) {

            // Inner loop for the columns
            // We would need a different algorithm for varying columnar dimensions.
            // Images are square or rectangular, most of the time, so we will use the following:
            for (int j = 0; j < reranged[0].length; j++) {
                // tempArray[counter] = reranged[i][j];
                // Won't work because array counters start at zero and 0 x any number is zero
                //(reranged[0].length * i) = number of columns processed times the current row counter, e.g. 10 columns x row 2 = 20
                //j = current column
                tempArray[(reranged[0].length * i) + j] = reranged[i][j];
            }
        }
        // return double[] tempArray 
        return tempArray;

    }

    /**
     *
     * @return
     */
    public Image getDataAsImage() {
        // Our Storage code this practical will go here.

        //Convert 2D image data array to 1D, reranged array with values between
        //0 and 255
        // Use the methods from this practical
        //http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part4/index.html
        //to get the data in a 1D double array
        // re-ranged between 0 and 255 (we'll call it 'data1Dreranged').
        double[] data1Dreranged = get1DArray();

        // Make a int array called "pixels" [data1Dreranged.length]
        int[] pixels = new int[data1Dreranged.length];
        // loop i = 0 to pixels.length
        // int value = (int) data1Dreranged[i]
        // Use value to make a new greyscale Color
        // pixel[i] = greyscale Colors compressed int
        // end loop
        for (int i = 0; i < pixels.length; i++) {
            //Get value of 1D array and cast as int
            int value = (int) data1Dreranged[i];
            //generate grayscale cell (all 3 values the same)
            Color pixel = new Color(value, value, value);
            pixels[i] = pixel.getRGB();
            //System.out.println(i + " -> " + value + " ---> " + pixel);
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
     *
     * @param srcArray
     * @return
     */
    public String locateDetonationPoint(double srcArray[][]) {
        //label for our detonation point 
        String detonationPoint = null;

        //outer loop for rows
        for (int i = 0; i <= srcArray.length - 1; i++) {
            //inner loop for columns
            for (int j = 0; j <= srcArray[0].length - 1; j++) {
                //print the columnar data on one line
                //System.out.print(srcArray[i][j] + " ");
                if (srcArray[i][j] == 255) {
                    detonationPoint = "{" + i + "," + j + "}";
                    //System.out.println("Found the detonation point marked. " + detonationPoint + " at position i: " + i + ", j: " + j + " . Stop the clock!");
                    //Stop processing here. No need to continue, unless we have more than 1 detonation point?
                    break;
                }

            }
            //System.out.println(" ");
        }
        return detonationPoint;
    }

    //Create a random detonation point anywhere within the area of the source array
    //Determine the size of the source array to ensure that we stay within its bounds
    //subtract height of the detonation to keep the dispersal within the boundaries if oarticles fall at constant rate
    //of 1m/s, where 1 iteration of the direction and height change process equals 1 second

    /**
     *
     * @param srcArray
     * @param detonationHeight
     * @return
     */
        public String setRandomDetonationPoint(double srcArray[][], int detonationHeight) {
        
        //Calculate the boundary buffer size as an integer value
        //int boundaryBuffer = (int)(detonationHeight * 1.5);
        
        //Find the data set boundaries by obtaining the maximum width and height and deducting the buffer area size
        int maxX = srcArray.length - detonationHeight;
        int maxY = srcArray[0].length - detonationHeight;
        
        //Use the Math.random() function to generate a pseudorandom double value between 0 and 1.0
        //Multiply the double by the maximum X and Y value and cast to integer
        int randomX = (int)(Math.random() * maxX);
        int randomY = (int)(Math.random() * maxY);
        
        //Check if the point coordinates are buffer distance away from the originating borders (top and left)
        //If not, add the buffer distance to the randomX and/or randomY values to enforce the buffer zone
        if (randomX < detonationHeight) {
            randomX = randomX + detonationHeight;
        }
        if (randomY < detonationHeight) {
            randomY = randomY + detonationHeight;
        }
        
        //Build the detonation point array and return it to the caller
        String detonationPoint = "{" + randomX + "," + randomY + "}";
        return detonationPoint;
    }
    
    //Calculate the dispersal of the supplied number of bacteria
    //Pass in the number of rows and columns in the source array so that we have dimensions

    /**
     *
     * @param bacteriaCount
     * @param srcArrayRows
     * @param srcArrayCols
     * @param xPos
     * @param yPos
     * @param changeNorthProbability
     * @param changeEastProbability
     * @param changeSouthProbability
     * @param changeWestProbability
     * @return
     */
        public double[][] calculateDispersal(int bacteriaCount, int srcArrayRows, int srcArrayCols, int xPos, int yPos,
            int changeNorthProbability, int changeEastProbability, int changeSouthProbability, int changeWestProbability) {

        //instantiate label for dispersal array, with size of the source array; initialised with all cell values at 0.0
        double[][] dispersalArray = new double[srcArrayRows][srcArrayCols];

        //instantiate our method label for the detonation point and each bacterium's initial position
        //final int[][] startPosition = detonationPoint;
        //get substring and convert to integer
        //String startPositionRowTxt = detonationPoint.substring(detonationPoint.indexOf('{') + 1, detonationPoint.indexOf(','));
        int startbacteriumPosRow = xPos;

        //String startPositionColumnTxt = detonationPoint.substring(detonationPoint.indexOf(',') + 1, detonationPoint.indexOf('}'));
        int startbacteriumPosCol = yPos;

        //Instantiate method variable to store particle count
        //int bacteriaCount = Integer.parseInt(strBacteriaCount);
        //System.out.println("startbacteriumPosRow: " + startbacteriumPosRow);
        //System.out.println("startbacteriumPosCol: " + startbacteriumPosCol);
        //Stop the bus here for now
        //System.exit(0);

        //instantiate the final label for the starting height for each bacterium
        //Update this to allow setting the height via the GUI
        final int startheight = 75;
        //limit the extent of the looping
        final int maxRows = srcArrayRows - 1;
        final int maxColums = srcArrayCols - 1;

        /**
         * From a given location, there is a 5% chance that in any given minute, given the current wind, that a particle
         * will blow west, a 10% chance of blowing north or south, and a 75% chance of blowing east. Calculate using
         * Math.Random with 0.0 – 0.05 as W, 0.05 – 0.8 as E, 0.8 – 0.9 as N and 0.9 upwards as S? One model iteration
         * is one second, and each model iteration the longest potential movement is one pixel on screen, which is 1
         * metre's length. (maybe track time with each particle, by assigning time taken to an additional array?) The
         * building is 75m high. If the particle is above the height of the building there is a 20% chance each second
         * it will rise by a metre in turbulence, a 10% chance it will stay at the same level, and a 70% chance it will
         * fall. Below the height of the building the air is still, and the particles will drop by a metre a second.
         *
         * Boundary issue: if particles make it to boundary and exceed it, cap to boundary value, e.g. (0,15) and move 1
         * meter North will be kept at (0,15). Restrict iterations to 1,1 -> 298,298 so that last step will see them at
         * boundary.
         */
        //Loop through 5000 bacteria - INITIALLY SET TO 5 FOR TESTING!!!!
        for (int b = 1; b <= bacteriaCount; b++) {
            //for (int b = 1; b <= 15; b++) {
            //Local variables to use for processing. Reinitialise on each run, otherwise we drift off the map!!!
            int height = startheight; //initial height of bacterium
            //int[][] endPosition = startPosition;
            int bacteriumPosRow = startbacteriumPosRow;
            int bacteriumPosCol = startbacteriumPosCol;

            //The loop ends when the bacterium lands on the ground (height == 0), or when it reaches the boundary.
            //need to finetune the boundary check component
            //Height component
            //while ((height > 0) || (location[i] > 0) || (location[i] < srcArrayCols -1)) {
            while (height > 0) {
                //System.out.println("START LOOP: " + b + " START POSITION is (Row,Col) -> (" + bacteriumPosRow + "," + bacteriumPosCol + ") + height " + height);

                //if bacterium is higher than 75m, it loses 1m in height
                if (height < 75) {
                    //System.out.println("Matched: Under 75m, decreasing by 1m");
                    height--;
                } else {
                    //under or equal to 75m height, random chance to stay in place, move up or down
                    //Use Math.random() to decide what happens to bacterium
                    //double heightChange = Math.random();
                    //Instantiate new random generator
                    Random rd = new Random();
                    //use nextDouble for a more random distribution???
                    double heightChange = rd.nextDouble();

                    //if less than 0.1, stays where it is, if > 0.1 and < 0.3, rise 1m, else fall 1m
                    if (heightChange <= 0.1) {
                        //nothing happens
                        //System.out.println("Matched: 10% chance of nothing happening");
                    } else if ((heightChange < 0.1) & (heightChange <= 0.3)) {
                        //System.out.println("Matched: 20% chance of height increase taking place");
                        height++;
                    } else {
                        //System.out.println("Matched: 70% chance of height decrease taking place");
                        height--;
                    }
                }
                //System.out.println("HEIGHT is now: " + height);

                //Directional component
                //double directionChange = Math.random();
                //Instantiate new random generator
                Random rd2 = new Random();
                //use nextDouble for a more random distribution???
                //double directionChange = rd2.nextDouble();
                //Multiply by 100 and cast to integer in order to fall in same order of magnitude and primitive type as probability values
                int directionChange = (int)(rd2.nextDouble()*100);
                //int directionChange = (int)(Math.random()*100);
                //System.out.println("Dir change is: " + directionChange);

                //Switch to CASE control loop? doesn't work with numbers like this really.
                //See http://stackoverflow.com/questions/10873590/in-java-using-switch-statement-with-a-range-of-value-in-each-case
                //changeNorthProbability, changeEastProbability, changeSouthProbability, changeWestProbability
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
                    //System.out.println("Matched: probability of going NORTH");
                    //location j-1 one row up
                    bacteriumPosRow--;
                } else if ((directionChange > changeNorthProbability) & (directionChange <= (changeNorthProbability + changeEastProbability))) {
                    //Go East
                    //System.out.println("Matched: probability of going EAST");
                    //location i+1 one column right
                    bacteriumPosCol++;
                } else if ((directionChange > (changeNorthProbability + changeEastProbability))
                        & (directionChange <= (changeNorthProbability + changeEastProbability + changeSouthProbability))) {
                    //Go South
                    //System.out.println("Matched: probability of going SOUTH");
                    //location j+1 one row down 
                    bacteriumPosRow++;
                } else if ((directionChange > (changeNorthProbability + changeEastProbability + changeSouthProbability))
                        & (directionChange <= (changeNorthProbability + changeEastProbability + changeSouthProbability + changeWestProbability))) {
                    //Go West
                    //System.out.println("Matched: probability of going WEST");
                    //location i-1 one column left
                    bacteriumPosCol--;
                } else {
                    System.out.println("This is messed up, we couln't find a real direction to change to. Fix it, Felix!");

                }

                //System.out.println("POSITION is now bacteriumPosRow -> " + bacteriumPosRow + ", bacteriumPosCol -> " + bacteriumPosCol);
                //Height is now 0.0
            }
            //Assign position to density map, with constraints to keep inside source array surface area. CHECK NOTES!!
            //System.out.println("LOOP: " + b + " OLD POSITION is (Row,Col) -> (" + bacteriumPosRow + "," + bacteriumPosCol + ") + height " + height);
            if (bacteriumPosRow > maxRows) {
                bacteriumPosRow = maxRows;
            }
            if (bacteriumPosCol >= maxColums) {
                bacteriumPosCol = maxColums;
            }
            //System.out.println("LOOP: " + b + " NEW POSITION is (Row,Col) -> (" + bacteriumPosRow + "," + bacteriumPosCol + ") + height " + height);
            dispersalArray[bacteriumPosRow][bacteriumPosCol] = dispersalArray[bacteriumPosRow][bacteriumPosCol] + 1;

            //END LOOP FOR 5000 BACTERIA    
        }
        // return the density map array
        return dispersalArray;
    }

}
