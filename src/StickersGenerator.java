import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class StickersGenerator {
    
    public void create() throws Exception {
        BufferedImage original = ImageIO.read(new File("/entrada/filme.jpg"));

        int width = original.getWidth();
        int height = original.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        ImageIO.write(newImage, "png", new File("saida/stickre.png"));
        }

        public static void main(String[] args) throws Exception{
            var generate = new StickersGenerator();
            generate.create();
        }

}
