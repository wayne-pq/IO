import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by panqian on 2017/1/2.
 */
public class Charset_1 {

    public static void main(String[] args) {
        byte[] bytes = Charset_1.encode("你好", "UTF-8");
        String decode = Charset_1.decode(bytes, "UTF-8");

        bytes = Charset_1.encode(decode, "GBK");
        decode = Charset_1.decode(bytes, "GBK");
        System.out.println(decode);
    }

    /**
     * 编码
     */
    public static byte[] encode(String str,String charset){
        Charset charset1 = Charset.forName(charset);
        ByteBuffer encode = charset1.encode(str);
        return encode.array();
    }

    /**
     * 解码
     */
    public static String decode(byte[] bytes,String charset){
        Charset charset1 = Charset.forName(charset);
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        CharBuffer decode = charset1.decode(wrap);
        return decode.toString();
    }
}
