import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;

/**
 * 系统目录的遍历
 * Created by panqian on 2017/1/18.
 */
public class TraversingFiles_1 {

    public static void main(String[] args) {
        Path path = Paths.get("E:\\angularjs");

//        TraversingFiles_1.directoryStream(path);

          TraversingFiles_1.walkFileTree(path);

        ;
    }


    /**
     * 遍历本目录底下所有文件和文件夹
     */
    public static void directoryStream(Path path){
        try(DirectoryStream<Path> paths = Files.newDirectoryStream(path)){
            Iterator<Path> iterator = paths.iterator();

            while(iterator.hasNext())
                System.out.println(iterator.next().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历所有子孙目录和文件
     */
    public static void walkFileTree(final Path path){
        try {
            Path path1 = Files.walkFileTree(path, new SimpleFileVisitor<Path>(){

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println(dir.toString());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {


                        System.out.println(file.toString());

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
