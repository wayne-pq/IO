import bean.MyObject_1;

import java.io.*;

/**
 * Created by panqian on 2017/1/4.
 */
public class ObjectStream_1 {
    public static void main(String[] args) {
        MyObject_1 myObject1_1 = new MyObject_1("你好");

        ObjectStream_1.writeObject(myObject1_1,"myObject1_1.txt");

        ObjectStream_1.readObject("myObject1_1.txt");

    }

    public static void writeObject(Object object,String fileName) {

        try {
            ObjectOutputStream out  = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("对象序列化完成");

    }

    public static void readObject(String fileName) {
        try {
            ObjectInputStream in  = new ObjectInputStream(new FileInputStream(fileName));
            try {
                MyObject_1 myObject_1 = (MyObject_1)in.readObject();
                System.out.println(myObject_1.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
