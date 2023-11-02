package logik;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ShifrUrl implements Shifrator{
    @Override
    public String shifrator(String planeText) {
            try {
                return URLEncoder.encode(planeText, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex.getCause());
            }
    }

    @Override
    public String deshifrator(String codeText) {
        return URLDecoder.decode(codeText, StandardCharsets.UTF_8);
    }
}
