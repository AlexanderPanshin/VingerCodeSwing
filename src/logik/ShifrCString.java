package logik;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ShifrCString implements Shifrator{
    @Override
    public String shifrator(String planeText) {
        StringBuilder output = new StringBuilder();
        Charset windows1251Charset = Charset.forName("Windows-1251");
        byte[] encodedBytes = planeText.getBytes(windows1251Charset);
        for (byte b : encodedBytes) {
           output.append("\\");
           output.append(String.format("%03o", b & 0xFF));
        }
        return output.toString();
    }

    @Override
    public String deshifrator(String codeText) {
        Charset windows1251Charset = Charset.forName("Windows-1251");
        String cleanedInput = codeText.replace("\\", "/");
        String[] byteStrings = cleanedInput.split("[/ ]");
        if(byteStrings.length != 0){
            if (byteStrings[0].equals("")){
                String[] finalByteStrings = byteStrings;
                byteStrings = IntStream.range(0, byteStrings.length)
                        .filter(i -> i != 0)
                        .mapToObj(i -> finalByteStrings[i])
                        .toArray(String[]::new);

            }
        }
        byte[] bytes = new byte[byteStrings.length];
        for (int i = 0; i < byteStrings.length; i++) {
            if (!byteStrings[i].equals("")) {
                bytes[i] = (byte) Integer.parseInt(byteStrings[i], 8);
            }else {
                bytes[i] = (byte) Integer.parseInt("040",8);
            }
        }
        return new String(bytes, windows1251Charset);
    }
}
