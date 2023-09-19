package logik;

public class ShifrBin implements Shifrator {



    @Override
    public String shifrator(String planeText) {
        String binaryText = "";
        for (int i = 0; i < planeText.length(); i++) {
            char currentChar = planeText.charAt(i);
            int ascii = (int) currentChar;
            String binary = decimalToBinary(ascii);
            binaryText += binary + " ";
        }
        return binaryText;
    }
    public static String decimalToBinary(int decimal) {
        if (decimal <= 0) {
            return "0";
        }
        String binary = "";
        while (decimal > 0) {
            short remainder = (short) (decimal % 2);
            decimal = decimal / 2;
            binary = String.valueOf(remainder) + binary;
        }
        return binary;
    }
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int position = 0;
        for (int x = binary.length() - 1; x >= 0; x--) {
            // Saber si es 1 o 0; primero asumimos que es 1 y abajo comprobamos
            short digit = 1;
            if (binary.charAt(x) == '0') {
                digit = 0;
            }
            double multiplier = Math.pow(2, position);
            decimal += digit * multiplier;
            position++;
        }
        return decimal;
    }


    @Override
    public String deshifrator(String codeText) {

            String[] binaryNumbers = codeText.split(" ");
            String text = "";

            for (String currentBinary : binaryNumbers) {
                int decimal = binaryToDecimal(currentBinary);
                char letra = (char) decimal;
                text += letra;
            }
            return text;

    }

}
