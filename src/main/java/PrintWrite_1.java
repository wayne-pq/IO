import org.junit.Test;
import sun.nio.cs.ext.GBK;

import java.io.*;
import java.util.Arrays;

/**
 * 练习 PrintWrite的用法   完整事例在IOTest_1中
 * Created by panqian on 2017/1/1.
 */
public class PrintWrite_1 {

    public static void main(String[] args) {
        PrintWriter out = null;
        try {
            out = new PrintWriter("PrintWrite_1.txt");
            out.println("abc");
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test(){
        String s = "abcd";

        char[] chars = new char[s.length()];
        for(int i = 0;i<s.length();i++){
            chars[i] = s.charAt(i);
        }

        System.out.println(Arrays.toString(chars));
    }

    @Test
    public void readTxT(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("IOTest_1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //带有中文，要带上编码，否则乱码
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        String line;
        try {
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
