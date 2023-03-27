import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class AssertTest {
    public static void main(String args[]) throws Exception {
        String path=AssertTest.class.getResource("bigmap.bmp").getPath();
        // 读入 文件
        File file234 = new File(path);
        FileInputStream file = new FileInputStream(file234);


          //该方法会将图片加载到内存中   vm 设置 -Xmx50m 加载100兆的图片会报错
//        BufferedImage bImg = ImageIO.read(file);

        try (ImageInputStream stream = ImageIO.createImageInputStream(file)) {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();
                reader.setInput(stream, true, true);
                int width = reader.getWidth(reader.getMinIndex());
                System.out.println(width);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }



}