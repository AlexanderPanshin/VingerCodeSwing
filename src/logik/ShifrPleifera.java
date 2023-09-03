package logik;

import gui.PanelKey;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class ShifrPleifera implements Shifrator{
    public Character[] alphabetEng = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p','q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z' };//delete charter j
    public Character[] alphabetRus= {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ','ъ','ы','ь','э','ю', 'я'}; //delete charter 'ё'
    private String key;

    public ShifrPleifera(String key) {
        key = key.toLowerCase().replace(" ","");
        StringBuilder sb = new StringBuilder();
        key.chars().distinct().forEach(s -> sb.append((char) s));
        key = sb.toString();
        this.key = key;
    }

    public Character [] [] cratePleiferMtrix(String key){
        key = key.toLowerCase().replace(" ","");
        int keyLenght = key.length();
        char[] massKey = key.toCharArray();
        int matrixCounter = 0;
        int alphabitCounter = 0;
        Character [] [] matrix = new Character[4][8];
        for (int i = 0;i < 4; i++){
            for (int a = 0; a< 8; a++){
                if(matrixCounter < keyLenght){
                    matrix[i][a] = massKey[matrixCounter];
                    matrixCounter++;
                }else {
                    while (alphabitCounter<alphabetRus.length) {
                        if (key.indexOf(alphabetRus[alphabitCounter]) != -1) {
                            alphabitCounter++;
                        } else {
                            matrix[i][a] = alphabetRus[alphabitCounter];
                            alphabitCounter++;
                            break;
                        }
                    }
                }
            }
        }
        printMatrix(matrix);
        return matrix;
    }
    @Override
    public String shifrator(String planeText) {
        return makePair(planeText.toLowerCase(),key);
    }

    @Override
    public String deshifrator(String codeText) {
        if (Objects.equals(PanelKey.getComboBox().getSelectedItem(), "Ru")) {
            return deshifratorRu(codeText);
        }else {
            return deshifratorEn(codeText);
        }
    }

    public String deshifratorRu(String codeText) {
        String pt = codeText;

        char[] ch = pt.toCharArray();

        int[] a = new int[4];

        Character[][] x = cratePleiferMtrix(key);

        for (int i = 0; i < pt.length(); i += 2) {

            if (i < pt.length() - 1) {

                a = findReversIJ(pt.charAt(i), pt.charAt(i + 1),
                        x);
                System.out.println(Arrays.toString(a));

                if (a[0] == a[2]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[0]][a[3]];
                }

                else if (a[1] == a[3]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[2]][a[1]];
                }

                else {

                    ch[i] = x[a[0]][a[3]];

                    ch[i + 1] = x[a[2]][a[1]];
                }
            }
        }

        pt = new String(ch);

        return pt;
    }
    public void printMatrix(Character[] [] arr){
        for (Character[] characters : arr) {
            for (int j = 0; (characters != null && j < characters.length); j++) {
                System.out.print(characters[j] + " ");
            }

            System.out.println();
        }
    }

    public String makePair(String pt,String key)
    {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < pt.length(); i++) {

            if (pt.charAt(i) == ' ')

                continue;

            else {

                s.append(pt.charAt(i));
            }

            if (i < pt.length() - 1)

                if (pt.charAt(i) == pt.charAt(i + 1))

                    s.append("x");
        }

        if (s.length() % 2 != 0)

            s.append("x");


        if (Objects.equals(PanelKey.getComboBox().getSelectedItem(), "Ru")) {
            return encrypt(s.toString(), cratePleiferMtrix(key));
        }else {
            return encryptEn(s.toString(),cratePleiferMtrixEn(key));
        }
    }
    public String encrypt(String pt, Character[][] x)
    {

        char[] ch = pt.toCharArray();

        int[] a = new int[4];

        for (int i = 0; i < pt.length(); i += 2) {

            if (i < pt.length() - 1) {

                a = findIJ(pt.charAt(i), pt.charAt(i + 1),
                        x);
                System.out.println(Arrays.toString(a));

                if (a[0] == a[2]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[0]][a[3]];
                }

                else if (a[1] == a[3]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[2]][a[1]];
                }

                else {

                    ch[i] = x[a[0]][a[3]];

                    ch[i + 1] = x[a[2]][a[1]];
                }
            }
        }

        pt = new String(ch);

        return pt;
    }
    static int[] findIJ(char a, char b, Character[][] x)
    {

        int[] y = new int[4];

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 8; j++) {

                if (x[i][j] == a) {

                    y[0] = i;

                    y[1] = j;
                }

                else if (x[i][j] == b) {

                    y[2] = i;

                    y[3] = j;
                }
            }
        }

        if (y[0] == y[2]) {

            y[1] += 1;

            y[3] += 1;
        }

        else if (y[1] == y[3]) {

            y[0] += 1;

            y[2] += 1;
        }

        for (int i = 0; i < 4; i++) {
            if(i == 0 || i == 2){
                y[i] %= 4;
            }else {
                y[i] %= 8;
            }

        }

        return y;
    }
    static int[] findReversIJ(char a, char b, Character[][] x)
    {

        int[] y = new int[4];

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 8; j++) {

                if (x[i][j] == a) {

                    y[0] = i;

                    y[1] = j;
                }

                else if (x[i][j] == b) {

                    y[2] = i;

                    y[3] = j;
                }
            }
        }

        if (y[0] == y[2]) {

            y[1] -= 1;

            y[3] -= 1;
        }

        else if (y[1] == y[3]) {

            y[0] -= 1;

            y[2] -= 1;
        }

        for (int i = 0; i < 4; i++) {
            if(i == 0 || i == 2){
                y[i] %= 4;
            }else {
                y[i] %= 8;
                if(y[i]<0){
                    y[i] = 8 + y[i];
                }
            }

        }

        return y;
    }

    //Английски шифратор дешифратор
    public String deshifratorEn(String codeText){
        String pt = codeText;

        char ch[] = pt.toCharArray();

        int a[] = new int[4];
//TODO Написать новый метод создания матрицы для анлиского дешифратора
        Character x[][] = cratePleiferMtrixEn(key);

        for (int i = 0; i < pt.length(); i += 2) {

            if (i < pt.length() - 1) {

                a = findReversIJ(pt.charAt(i), pt.charAt(i + 1),
                        x);
                System.out.println(Arrays.toString(a));

                if (a[0] == a[2]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[0]][a[3]];
                }

                else if (a[1] == a[3]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[2]][a[1]];
                }

                else {

                    ch[i] = x[a[0]][a[3]];

                    ch[i + 1] = x[a[2]][a[1]];
                }
            }
        }

        pt = new String(ch);

        return pt;
    }
    public Character [] [] cratePleiferMtrixEn(String key){
        key = key.toLowerCase().replace(" ","");
        int keyLenght = key.length();
        char[] massKey = key.toCharArray();
        int matrixCounter = 0;
        int alphabitCounter = 0;
        Character [] [] matrix = new Character[5][5];
        for (int i = 0;i < 5; i++){
            for (int a = 0; a< 5; a++){
                if(matrixCounter < keyLenght){
                    matrix[i][a] = massKey[matrixCounter];
                    matrixCounter++;
                }else {
                    while (alphabitCounter<alphabetEng.length) {
                        if (key.indexOf(alphabetEng[alphabitCounter]) != -1) {
                            alphabitCounter++;
                        } else {
                            matrix[i][a] = alphabetEng[alphabitCounter];
                            alphabitCounter++;
                            break;
                        }
                    }
                }
            }
        }
        printMatrix(matrix);
        return matrix;
    }
    static int[] findIJEn(char a, char b, Character[][] x)
    {

        int[] y = new int[4];

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (x[i][j] == a) {

                    y[0] = i;

                    y[1] = j;
                }

                else if (x[i][j] == b) {

                    y[2] = i;

                    y[3] = j;
                }
            }
        }

        if (y[0] == y[2]) {

            y[1] += 1;

            y[3] += 1;
        }

        else if (y[1] == y[3]) {

            y[0] += 1;

            y[2] += 1;
        }

        for (int i = 0; i < 4; i++) {
                y[i] %= 5;
        }

        return y;
    }
    public String encryptEn(String pt, Character[][] x)
    {

        char[] ch = pt.toCharArray();

        int[] a = new int[4];

        for (int i = 0; i < pt.length(); i += 2) {

            if (i < pt.length() - 1) {

                a = findIJEn(pt.charAt(i), pt.charAt(i + 1),
                        x);
                System.out.println(Arrays.toString(a));

                if (a[0] == a[2]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[0]][a[3]];
                }

                else if (a[1] == a[3]) {

                    ch[i] = x[a[0]][a[1]];

                    ch[i + 1] = x[a[2]][a[1]];
                }

                else {

                    ch[i] = x[a[0]][a[3]];

                    ch[i + 1] = x[a[2]][a[1]];
                }
            }
        }

        pt = new String(ch);

        return pt;
    }
}
