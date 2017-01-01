import sun.nio.cs.ext.GBK;

import java.io.*;

/**
 * 在控制台上输入字符   然后写入到文件  exit则退出
 * Created by panqian on 2017/1/1.
 */
public class IOTest_1 {
    public static void main(String[] str){

        // 用户空间的根目录
        System.out.println(System.getProperty("user.dir"));

        //读取控制台字符
        InputStreamReader in = new InputStreamReader(System.in);

        BufferedReader read = new BufferedReader(in);

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("IOTest_1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String string;
            //输入exit则停止程序
            while(!"exit".equals(string = read.readLine())) {
                IOTest_1.writeFile(printWriter,string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
        }


    }

    public static void writeFile(PrintWriter printWriter,String str){
        try {
            if(null == printWriter)
                printWriter = new PrintWriter("IOTest_1.txt");

                printWriter.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
