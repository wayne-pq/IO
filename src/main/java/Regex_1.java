import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by panqian on 2017/1/19.
 */
public class Regex_1 {

    public static void main(String[] args) {
//        Pattern compile = Pattern.compile("[a-z]+");
        Pattern compile = Pattern.compile("((1?[0-9]):([0-5][0-9]))[ap]m");
        Matcher matcher = compile.matcher("11:59am");
//        Matcher matcher = compile.matcher("vv");
        System.out.println(matcher.matches());

        //群组数
        int count;
        System.out.println(count=matcher.groupCount());

        //0是整个匹配结果  真正组匹配从1开始  从外到里   从左到右
        for(int i=0;i<=count;i++)
            System.out.println(matcher.group(i)+" 从索引 "+matcher.start(i)+" 开始,从 "+(matcher.end(i)-1)+" 结束");





    }
}
