
import bean.MyObject_3;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 为克隆使用序列化   深拷贝
 *
 *浅复制（浅克隆）
 *被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。换言之，浅复制仅仅复制所考虑的对象，而不复制它所引用的对象。
 *
 *深复制（深克隆）
 *被复制对象的所有变量都含有与原来的对象相同的值，除去那些引用其他对象的变量。那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。换言之，深复制把要复制的对象所引用的对象都复制了一遍。
 *
 * Created by panqian on 2017/1/15.
 */
public class SerialClone_1 {

    public static void main(String[] args) {
        MyObject_3 myObject_3 = new MyObject_3("myObject_3");

        try {
            MyObject_3 clone = (MyObject_3)myObject_3.clone();

            System.out.println("old : " + myObject_3.toString() + "--- myObject_3.name:" + myObject_3.getName());
            System.out.println("clone : " + clone.toString() + "--- myObject_3.name:"+ clone.getName());


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test(){


    }
}
