import java.io.*;

/**
 * Created by panqian on 2017/1/1.
 */
public class IOTest_1 {
    public static void main(String[] str){

        // 用户空间的根目录
        System.out.println(System.getProperty("user.dir"));

        //读取控制台字符
        InputStreamReader in = new InputStreamReader(System.in);

        try {
            int read = in.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
