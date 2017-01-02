import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Scanner 不仅可以读取文本格式   还可以读取数字等基本类型
 * Created by panqian on 2017/1/2.
 */
public class Scanner_1 {

    public static void main(String[] args) {
//        Scanner in = new Scanner(new InputStreamReader(System.in));
        Scanner in = null;
        try {
            in = new Scanner(new File("Scanner_1.txt"),"UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = null;

        int i = in.nextInt();
        System.out.println(i);
        String s1 = in.nextLine();
        System.out.println(s1.trim());
    }


    @Test
    public void test(){


    }
}
