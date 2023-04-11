package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {
    
    public void create() throws Exception {
        BufferedImage original = ImageIO.read(new File("./entrada/filme.jpg"));

        int width = original.getWidth();
        int height = original.getHeight();
        int newHeight = height + 50;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 33);
        graphics.setColor(Color.RED);
        graphics.setFont(font);

        graphics.drawString("TOPPERSON", 8, newHeight - 15);

        ImageIO.write(newImage, "png", new File("./saida/stickers.png"));

        }

         public static void main(String[] args) throws Exception{
             var generate = new StickersGenerator();
             generate.create();
         }

}
