import bean.MyObject_3;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * Path 基本操作
 *
 * Created by panqian on 2017/1/16.
 */
public class Paths_1 {

    public static void main(String[] args) {
        String baseDir = System.getProperty("user.dir");

        Path path = Paths.get(baseDir);
        System.out.println("path: "+path.toString());

        // 1.如果参数是绝对路径  则返回绝对路径
        // 2.否则 则在path后面加上 参数
        Path resolve = path.resolve("resolve");
        System.out.println("resolve: "+resolve.toString());

        //解析path的父路径
        Path resolveSibling = path.resolveSibling("resolveSibling");
        System.out.println("resolveSibling: "+resolveSibling.toString());

        //resolve 的对立面是 relativize  前面是往后加 后者是往前减
        Path relativize = resolve.relativize(path);
        System.out.println("relativize: "+relativize.toString());

        //清除路径冗余
        Path path1 = Paths.get("a","..","b",".","c");
        System.out.println("path1: "+path1.toString());
        Path normalize = path1.normalize();
        System.out.println("normalize: "+normalize.toString());

        //获取绝对路径
        Path absolutePath = path1.toAbsolutePath();
        System.out.println("absolutePath: "+absolutePath.toString());


    }


    @Test
    public void test(){


    }
}
