package logik;

import java.util.ArrayList;
import java.util.Locale;

public class ShifrVinigira {
    private char[] alphabetEng = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z' };
    private char[] alphabetRus= {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ','ъ','ы','ь','э', 'ю', 'я'};
    private ArrayList<Integer> intKey = new ArrayList<>();
    private ArrayList<String> oterKey = new ArrayList<>();
    public  StringBuilder sbshifr;

    public StringBuilder rashifr;

    private String key;

    private String shifText;

    public ShifrVinigira(String key) {
        this.key = key;
        sbshifr = new StringBuilder();
        rashifr = new StringBuilder();
        getNumberKey(key);
    }

    public String getShifText() {
        return shifText;
    }

    public ArrayList<Integer> getNumberKey(String key){
        key = key.toLowerCase();
        boolean iter = true;
        for (char a : key.toCharArray()){
            for (int i = 0; i < alphabetRus.length;i++){
                if(a == alphabetRus[i]){
                    intKey.add(i+1);
                    iter = false;
                    break;
                }
            }
            if(iter) {
                for (int b = 0; b < alphabetEng.length; b++) {
                    if (a == alphabetEng[b]) {
                        intKey.add(b + 1);
                        iter = false;
                    }
                }
            }
            if(iter){
                intKey.add(0);
                oterKey.add(String.valueOf(a));
            }
        }
        return intKey;
    }
    public String shifrator(String planeText){
        planeText = planeText.toLowerCase();
        int temp = 0;
        int countOverKey = 0;

        for (char a : planeText.toCharArray()){
            boolean iter1 = true;
            for (int i = 0; i < alphabetRus.length;i++){
                if(a == alphabetRus[i]){
                   if((i+intKey.get(temp))<alphabetRus.length){
                       sbshifr.append(alphabetRus[i+intKey.get(temp)]);
                   }else{
                       int offset = (i+intKey.get(temp))-alphabetRus.length;
                       sbshifr.append(alphabetRus[offset]);
                   }
                   iter1 = false;
                }
            }
            for (int b = 0; b < alphabetEng.length;b++){
                if(a == alphabetEng[b]){
                    if((b+intKey.get(temp))<alphabetEng.length){
                        sbshifr.append(alphabetEng[b+intKey.get(temp)]);
                    }else{
                        int offset = (b+intKey.get(temp))-alphabetEng.length;
                        sbshifr.append(alphabetEng[offset]);
                    }
                    iter1= false;
                }
            }


            if (iter1){
                sbshifr.append(a);
                countOverKey++;
            }else{
                temp++;
                if(temp == intKey.size()) {
                    temp = 0;
                }
            }
        }
        return sbshifr.toString();
    }
    public String deshifrator(String shifrText){
        shifrText = shifrText.toLowerCase();
        int temp = 0;
        int countOverKey = 0;

        for (char a : shifrText.toCharArray()){
            boolean iter1 = true;
            for (int i = 0; i < alphabetRus.length;i++){
                if(a == alphabetRus[i]){
                    if((i-intKey.get(temp))>=0){
                        rashifr.append(alphabetRus[i-intKey.get(temp)]);
                    }else{
                        int offset = alphabetRus.length - (intKey.get(temp)-i);
                        rashifr.append(alphabetRus[offset]);
                    }
                    iter1 = false;
                }
            }
            for (int b = 0; b < alphabetEng.length;b++){
                if(a == alphabetEng[b]){
                    if((b-intKey.get(temp))>=0){
                        rashifr.append(alphabetEng[b-intKey.get(temp)]);
                    }else{
                        int offset = alphabetEng.length - (intKey.get(temp)-b);
                        rashifr.append(alphabetEng[offset]);
                    }
                    iter1= false;
                }
            }

            if (iter1){
                rashifr.append(a);
                countOverKey++;
            }else{
                temp++;
                if(temp == intKey.size()) {
                    temp = 0;
                }
            }
        }
        return rashifr.toString();
    }
}
