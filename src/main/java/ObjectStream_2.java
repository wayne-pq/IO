
import bean.MyObject_2;

import java.io.*;

/**
 * Created by panqian on 2017/1/4.
 */
public class ObjectStream_2 {
    public static void main(String[] args) {
        MyObject_2 myObject1_2 = new MyObject_2("你好");

        ObjectStream_2.writeObject(myObject1_2,"myObject2_1.txt");

        ObjectStream_2.readObject("myObject2_1.txt");

    }

    public static void writeObject(Object object,String fileName) {
        try {
            ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(object);
            System.out.println("对象序列化完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readObject(String fileName) {
        try {
            ObjectInputStream in  = new ObjectInputStream(new FileInputStream(fileName));
            try {
                MyObject_2 myObject_2 = (MyObject_2)in.readObject();
                System.out.println(myObject_2.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
