package bean;

import java.io.Serializable;

/**
 * Created by panqian on 2017/1/4.
 */
public class MyObject_1 implements Serializable {
    String name;

    public MyObject_1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
