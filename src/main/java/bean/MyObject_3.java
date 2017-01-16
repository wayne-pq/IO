package bean;

import java.io.*;
import java.util.UUID;

/**
 * 为克隆使用序列化 深拷贝
 * Created by panqian on 2017/1/15.
 */
public class MyObject_3 implements Serializable,Cloneable{
    String name;

    public MyObject_3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object o = objectInputStream.readObject();
            objectInputStream.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
