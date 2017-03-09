import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 以“?<number>”开头，number可以自己随意命名。
 * Created by panqian on 2017/1/19.
 */
public class Regex_2 {

    public static void main(String[] args) {

        Pattern compile = Pattern.compile("(?<number>.+)@.+");
        Matcher matcher = compile.matcher("455234037@qq.com");
        System.out.println(matcher.matches());

        //群组数
        int count;
        System.out.println(count = matcher.groupCount());

        //0是整个匹配结果  真正组匹配从1开始  从外到里   从左到右
        for (int i = 0; i <= count; i++)
            System.out.println(matcher.group(i) + " 从索引 " + matcher.start(i) + " 开始,从 " + (matcher.end(i) - 1) + " 结束");

        String number = matcher.group("number");
        System.out.println("命名捕获组：" + number);

    }
}
