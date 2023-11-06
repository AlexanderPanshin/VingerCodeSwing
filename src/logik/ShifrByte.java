package logik;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class ShifrByte implements Shifrator{
    @Override
    public String shifrator(String planeText) {
        StringBuilder sb = new StringBuilder();
        byte [] bytesPlaneText = planeText.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytesPlaneText){
            sb.append(b + " ");
        }
        return sb.toString();
    }

    @Override
    public String deshifrator(String codeText) {
        ArrayList<Byte> byteArrayList = new ArrayList<>();
        String [] stringByte = codeText.split(" ");
        for (String s : stringByte){
            byteArrayList.add(Byte.parseByte(s));
        }
        byte [] bytesMass = new byte[byteArrayList.size()];
        for(int b = 0; b < byteArrayList.size(); b++){
            bytesMass [b] = byteArrayList.get(b);
        }
        return new String(bytesMass,StandardCharsets.UTF_8);
    }
}
