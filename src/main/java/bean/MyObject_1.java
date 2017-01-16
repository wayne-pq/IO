package bean;

import java.io.Serializable;

/**
 * Created by panqian on 2017/1/4.
 */
public class MyObject_1 implements Serializable {

    private static final long serialVersionUID = -7934323975621081635L;

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
