import org.junit.Test;
import sun.nio.cs.ext.GBK;

import java.io.*;

/**
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
    public void readTxT(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("PrintWrite_1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //带有中文，要带上编码，否则乱码
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream,new GBK()));

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
