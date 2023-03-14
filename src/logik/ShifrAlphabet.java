package logik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShifrAlphabet {
    public Character[] alphabetEng = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z' };
    public Character[] alphabetRus= {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ','ъ','ы','ь','э', 'ю', 'я'};
    public List<Character> arrayUpRus = new ArrayList<>();
    public List<Character> arrayUpEng = new ArrayList<>();

    {
        for (char a :alphabetRus){
            arrayUpRus.add(Character.toUpperCase(a));
        }
        for (char a:alphabetEng){
            arrayUpEng.add(Character.toUpperCase(a));
        }
    }

    public List<Character> getRusArray(){
        return Arrays.asList(alphabetRus);
    }

    public List<Character> getEngArray(){
        return Arrays.asList(alphabetEng);
    }

}
