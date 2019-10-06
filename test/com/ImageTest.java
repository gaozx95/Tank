package test.com;

import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImageTest {
    @Test
    void test(){
        try {
//            BufferedImage image = ImageIO.read(new File("D:\\javaProject\\Tank\\src\\images\\BadTank1.png"));
//            assertNotNull(image);
//
            BufferedImage image = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
