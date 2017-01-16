import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

/**
 *
 * Files 基本操作
 *
 * Created by panqian on 2017/1/16.
 */
public class Files_1 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("IOTest_1.txt");
        if(path.toFile().exists()){
            //读取字节
            byte[] bytes = Files.readAllBytes(path);
            System.out.println("字节："+bytes);

            //读取字符串
            List<String> strings = Files.readAllLines(path, Charset.forName("UTF-8"));
            System.out.println("字符：");
            for(String s : strings){
                System.out.println(s);
            }

            //写文件
            String userDir = System.getProperty("user.dir");
            Path Files_1 = Paths.get(userDir).resolve("Files_1.txt");
            Files.write(Files_1, "明天去玩".getBytes(Charset.forName("UTF-8")));
            //追加
            Files.write(Files_1, ",因为有事".getBytes(Charset.forName("UTF-8")), StandardOpenOption.APPEND);

        }
    }


    @Test
    public void test(){


    }
}
