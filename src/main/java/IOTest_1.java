

import java.io.*;
import java.nio.charset.Charset;

/**
 * 在控制台上输入字符   然后写入到文件  exit则退出
 * Created by panqian on 2017/1/1.
 */
public class IOTest_1 {
    public static void main(String[] str) {

        // 用户空间的根目录
        System.out.println(System.getProperty("user.dir"));

        //读取控制台字符
        InputStreamReader in = new InputStreamReader(System.in, Charset.forName("UTF-8"));

        BufferedReader read = new BufferedReader(in);

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new File("IOTest_1.txt"),"UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            String string;
            //输入exit则停止程序
            while (!"exit".equals(string = read.readLine())) {
                IOTest_1.writeFile(printWriter, string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }


        //读取文件
        IOTest_1.readFile(new File("IOTest_1.txt"));


    }

    /**
     * 写文件
     * @param printWriter
     * @param str
     */
    public static void writeFile(PrintWriter printWriter, String str) {
        try {
            if (null == printWriter)
                printWriter = new PrintWriter(new File("IOTest_1.txt"),"UTF-8");

            printWriter.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件
     * @param file
     */
    public static void readFile(File file)  {

        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader reader1 = new BufferedReader(reader);

        String str = null;
        try {
            while((str=reader1.readLine())!=null)
                System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
