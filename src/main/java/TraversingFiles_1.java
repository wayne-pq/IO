import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 系统目录的遍历
 * Created by panqian on 2017/1/18.
 */
public class TraversingFiles_1 {

    public static void main(String[] args) {
        Path path = Paths.get("E:\\angularjs");

        if (path.toFile().isDirectory()) {
            TraversingFiles_1.walkFileTreeForJDK8(path);
        }
//        TraversingFiles_1.directoryStreamForJDK8(path);

//        TraversingFiles_1.directoryStream(path);

//          TraversingFiles_1.walkFileTree(path);

        ;
    }


    /**
     * 遍历本目录底下所有文件和文件夹
     */
    public static void directoryStream(Path path) {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path)) {
            Iterator<Path> iterator = paths.iterator();

            while (iterator.hasNext())
                System.out.println(iterator.next().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历本目录底下所有文件和文件夹 jdk8
     */
    public static void directoryStreamForJDK8(Path path) {
        try (Stream<Path> list = Files.list(path)) {
            Iterator<Path> iterator = list.iterator();

            while (iterator.hasNext())
                System.out.println(iterator.next().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 遍历所有子孙目录和文件
     */
    public static void walkFileTree(final Path path) {
        try {
            Path path1 = Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

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

    /**
     * 遍历所有子孙目录和文件
     */
    public static void walkFileTreeForJDK8(final Path path) {
        try {
            try (Stream<Path> walk = Files.walk(path)) {
                Iterator<Path> iterator = walk.iterator();

                while (iterator.hasNext())
                    System.out.println(iterator.next().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
