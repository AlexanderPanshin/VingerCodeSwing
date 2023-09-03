package logik;


public class ShifrHex implements Shifrator{

    @Override
    public String shifrator(String planeText) {
        byte[] byteArray = planeText.getBytes();
        StringBuilder hexBuilder = new StringBuilder();
        for (byte b : byteArray) {
            int intValue = b & 0xff;
            hexBuilder.append(Character.forDigit(intValue >> 4, 16));
            hexBuilder.append(Character.forDigit(intValue & 0xf, 16));
        }
        return hexBuilder.toString();
    }

    @Override
    public String deshifrator(String codeText) {
        int l = codeText.length();
        byte[] data = new byte[l / 2];
        for (int i = 0; i < l; i += 2) {
            data[i / 2] = (byte) ((Character.digit(codeText.charAt(i), 16) << 4)
                    + Character.digit(codeText.charAt(i + 1), 16));
        }
        return new String(data);
    }
}
