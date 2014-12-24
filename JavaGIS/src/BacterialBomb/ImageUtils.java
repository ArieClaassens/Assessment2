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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 *
 * Sourced from http://www.rgagnon.com/javadetails/java-0601.html in December 2014
 */
public class ImageUtils {

    /**
     *
     * @param im
     * @return
     */
    public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }

    /**
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static BufferedImage readImageFromFile(File file)
            throws IOException {
        return ImageIO.read(file);
    }

    /**
     *
     * @param file
     * @param bufferedImage
     * @throws IOException
     */
    public static void writeImageToPNG(File file, BufferedImage bufferedImage)
            throws IOException {
        ImageIO.write(bufferedImage, "png", file);
    }

    /**
     *
     * @param file
     * @param bufferedImage
     * @throws IOException
     */
    public static void writeImageToJPG(File file, BufferedImage bufferedImage)
            throws IOException {
        ImageIO.write(bufferedImage, "jpg", file);
    }

    //Method to create buffered image from Toolkit image
    //http://stackoverflow.com/questions/22426040/error-sun-awt-image-toolkitimage-cannot-be-cast-to-java-awt-image-bufferedimage

    /**
     *
     * @param image
     * @return
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
