package dev.ben10dollar.golfgame.utils;

import dev.ben10dollar.golfgame.graphics.Assets;
import dev.ben10dollar.golfgame.physics.Physics;

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
    public static void drawRotatedImage(double angle, int x, int y, double scaleX, double scaleY, BufferedImage image, Graphics g) {

        AffineTransform transform = new AffineTransform();
        AffineTransform translate = AffineTransform.getTranslateInstance(x, y);
        AffineTransform scale = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransform rotation = AffineTransform.getRotateInstance(angle);


        transform.concatenate(translate);
        transform.concatenate(scale);
        transform.concatenate(rotation);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, transform, null);
    }

}
