package logik;

import java.util.Base64;

public class ShifrBase64 implements Shifrator{
    Base64.Decoder decoder;
    Base64.Encoder encoder;
    public ShifrBase64() {
        decoder = Base64.getDecoder();
        encoder = Base64.getEncoder();
    }

    @Override
    public String shifrator(String planeText) {
        String encodedString = encoder.encodeToString(planeText.getBytes());
        return encodedString;
    }

    @Override
    public String deshifrator(String codeText) {
        byte[] bytes = decoder.decode(codeText);
        return new String(bytes);
    }
}
