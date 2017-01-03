import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * RandomAccessFile操作
 * 同时继承了 DataOutput和DataInput
 * 可以 根据文件指针（seek方法）随机访问文件  修改时不需要事先 文件内容 都读入内存
 * seek()   绝对定位
 * skipBytes()   相对定位
 * Created by panqian on 2017/1/3.
 */
public class RandomAccess_1 {
    public static void main(String[] args) {
        RandomAccessFile inout = null;
        try {
            inout = new RandomAccessFile("IOTest_1.txt","rw");
            RandomAccess_1.readFile(inout);
            RandomAccess_1.writeFile(inout,"你好");
            System.out.println("------------------------------");
            inout = new RandomAccessFile("IOTest_1.txt","rw");
            RandomAccess_1.readFile(inout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写文件
     * @param file
     * @param str
     */
    public static void writeFile(RandomAccessFile file, String str) {
        try {
            file.seek(file.length());

            ByteBuffer encode = Charset.forName("UTF-8").encode(str);
            byte[] array = encode.array();

            file.write(array);

            file.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件
     * @param file
     */
    public static void readFile(RandomAccessFile file)  {

        try {
            System.out.println("在什么位置"+file.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int length = 0;
        try {
            length = (int) file.length();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;

        byte[] bytes = new byte[length];

        while(i<length) {
            try {
                bytes[i++] = (byte)file.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        String string = Charset.forName("UTF-8").decode(wrap).toString();
        System.out.println(string);

    }
}
