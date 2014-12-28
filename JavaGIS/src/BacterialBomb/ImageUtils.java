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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * <b>Class:</b> ImageUtils<br>
 * <b>Version:</b> 1.0 - Dec 2014<br>
 * <b>Date:</b> 27 December 2014<br>
 * <b>Overview:</b> The ImageUtils class provides the Image operation methods to convert an Image into a Buffered Image, read a
 * file into a Buffered Image and write a Buffered Image to a file in PNG or JPEG format. Based on code from
 * <a href="http://www.rgagnon.com/javadetails/java-0601.html" target="_blank">http://www.rgagnon.com/</a>.
 * @author Student 200825599 <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0 - Dec 2014
 */
public class ImageUtils {

    /**
     * Method to convert an Image into a Buffered Image
     * @param im Image to convert into buffered image
     * @return bi Buffered Image created from supplied Image
     */
    public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }

    /**
     * Method to create a Buffered Image from a file.
     * @param file File to parse as source for a Buffered Image
     * @return Buffered Image created from the source file
     * @throws IOException I/O errors that may be encountered in accessing the file
     */
    public static BufferedImage readImageFromFile(File file)
            throws IOException {
        return ImageIO.read(file);
    }

    /**
     * Method to create or overwrite image files in the specified format, using an arbitrary ImageWriter that supports 
     * the supplied format.
     * @param file File to create or overwrite with the supplied Buffered Image
     * @param format Format of the image data to write, e.g. "jpeg","tiff","gif", etc.
     * @param bufferedImage Buffered Image that will be written to the output file.
     * @throws IOException I/O errors that may be encountered in creating or overwriting the destination file
     */
    public static void writeImageToFile(File file, String format, BufferedImage bufferedImage)            
        throws IOException {
        ImageIO.write(bufferedImage, format, file);
    }

    
    //
    /**
     * Method to create buffered image from Toolkit image. Code obtained from 
     * <a href="http://stackoverflow.com/questions/22426040/error-sun-awt-image-toolkitimage-cannot-be-cast-to-java-awt-image-bufferedimage" target="_blank">
     * http://stackoverflow.com/questions/22426040/error-sun-awt-image-toolkitimage-cannot-be-cast-to-java-awt-image-bufferedimage</a>
     * @param image Image to convert into a Buffered Image
     * @return A Buffered Image created from the source Image
     */
    public static BufferedImage convertToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
