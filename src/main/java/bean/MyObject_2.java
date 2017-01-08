package bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by panqian on 2017/1/4.
 */
public class MyObject_2 implements Serializable {
    String name;

    public MyObject_2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 自定义序列化规则
     * @param s
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream s)
            throws IOException
    {
        s.writeUTF(UUID.randomUUID().toString());
    }

    /**
     * 自定义序列化规则
     * @param s
     * @throws IOException
     */
    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException
    {
        name = s.readUTF();
    }
}
