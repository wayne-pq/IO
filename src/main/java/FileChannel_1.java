import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

/**
 * 介绍 内存映射文件 nio ，且与其他io进行性能测试
 * Created by panqian on 2017/1/18.
 */
public class FileChannel_1 {
    public static void main(String[] args) {
        Path path = Paths.get("农门长姐.txt");
        FileChannel_1.fileInputStreamRead(path);
        FileChannel_1.fileChannelMapRead(path);
        FileChannel_1.fileBufferedInputStreamRead(path);
        FileChannel_1.fileRandomAccessRead(path);

    }

    /**
     * 文件通道（内存映射文件）
     *
     * @param path
     */
    public static void fileChannelMapRead(Path path) {

        System.out.println("fileChannelMapRead : ");

        long start = System.currentTimeMillis();

        if (path.toFile().exists()) {
            try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
                long size = channel.size();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, size);

                for (int i = 0; i < size; i++)
                    map.get(i);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("run " + (end - start) + " milliseconds");
    }

    /**
     * 普通输入流
     *
     * @param path
     */
    public static void fileInputStreamRead(Path path) {

        System.out.println("fileInputStreamRead : ");

        long start = System.currentTimeMillis();

        if (path.toFile().exists()) {
            try (InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ)) {
                int c;
                while ((c = inputStream.read()) != -1) {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("run " + (end - start) + " milliseconds");
    }

    /**
     * 带缓冲区的输入流
     *
     * @param path
     */
    public static void fileBufferedInputStreamRead(Path path) {

        System.out.println("fileBufferedInputStreamRead : ");

        long start = System.currentTimeMillis();
        if (path.toFile().exists()) {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                int c;
                while ((c = bufferedInputStream.read()) != -1) {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            long end = System.currentTimeMillis();

            System.out.println("run " + (end - start) + " milliseconds");
        }
    }

    /**
     * 随机访问文件（RandomAccessFile的绝大多数功能，但不是全部，已经被JDK 1.4的nio的"内存映射文件(memory-mapped files)"给取代）
     *
     * @param path
     */
    public static void fileRandomAccessRead(Path path) {

        System.out.println("fileRandomAccessRead : ");

        long start = System.currentTimeMillis();

        if (path.toFile().exists()) {
            try (RandomAccessFile accessFile = new RandomAccessFile(path.toFile(), "r")) {
                int c;
                while ((c = accessFile.read()) != -1) {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("run " + (end - start) + " milliseconds");
    }
}
