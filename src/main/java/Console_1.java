import java.io.Console;
import java.util.Arrays;

/** Console  跟 Scanner 不同,前者readPassword输入是不可见的，适合密码输入，但是在 IDE 中使用会报错，请在Windows下的cmd或者Linux下的Terminal交互
 * Created by panqian on 2017/2/16.
 */
public class Console_1 {
    public static void main(String[] args) {
        Console console = System.console();
        String line = console.readLine("your name ： ");

        System.out.println(line);

        char[] chars = console.readPassword("your password ： ");

        System.out.println(Arrays.toString(chars));

    }
}
