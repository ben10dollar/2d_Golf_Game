package dev.ben10dollar.golfgame.utils;

import dev.ben10dollar.golfgame.graphics.Assets;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String loadFileAsString(String path) {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        }
        catch(IOException e) {e.printStackTrace();}

        return sb.toString();
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        }
        catch(NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static void drawRotatedImage(double angle, int x, int y, int anchorX, int anchorY, double scaleX, double scaleY, BufferedImage image, Graphics g) {

        AffineTransform transform = new AffineTransform();

        //transformations are reverse order
        transform.translate(x, y);  //4: translate anchor pts to intended coordinates
        transform.rotate(angle);  //3: rotate
        transform.translate(-scaleX, -scaleY);  //2.5: shift middle point (now translated due to scale) back to center
        transform.scale(scaleX, scaleY);  //2: scale
        transform.translate(-anchorX, -anchorY);  //1 :translate anchor pts to origin

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, transform, null);
    }

}
