package logik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShifrA1Z26 extends ShifrAlphabet{
    private Character [] numberMass = {'0','1','2','3','4','5','6','7','8','9'};
    private ArrayList<Character> simvolMass = new ArrayList<>(Arrays.asList('!','?',',','.','-'));
    public String shifrator3(String planeText){
        planeText = planeText.toLowerCase();
        char [] planeMass = planeText.toCharArray();
        StringBuilder sb  = new StringBuilder();
        List<Character> rusList = Arrays.asList(alphabetRus);
        for (char mass : planeMass) {
            if (rusList.contains(mass)) {
                sb.append("&");
                sb.append(rusList.indexOf(mass) + 1);
                sb.append("&");
            } else {
                sb.append(mass);
            }
        }
        return sb.toString();
    }

    public String deshifrator3(String shifrText){
        shifrText = shifrText.toLowerCase();
        char [] shifrMass = shifrText.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<Character> rusList = Arrays.asList(alphabetRus);
        for(int i = 0; i < shifrMass.length; i++){
            if(shifrMass[i]=='&'){
                if(i+2 < shifrMass.length){
                    if(shifrMass[i+2]!='&'){
                        int one = Integer.parseInt(String.valueOf(shifrMass[i+1]));
                        int two = Integer.parseInt(String.valueOf(shifrMass[i+2]));
                        int decimal = (one * 10) + two;
                        sb.append(alphabetRus[decimal - 1]);
                        i = i + 3;
                    }else{
                        int bukva = Integer.parseInt(String.valueOf(shifrMass[i+1]));
                        sb.append(alphabetRus[bukva-1]);
                        i = i + 2;
                    }
                }else{
                    int bukva = Integer.parseInt(String.valueOf(shifrMass[i]));
                    sb.append(alphabetRus[bukva-1]);
                    i = i + 2;
                }
            }else{
                sb.append(shifrMass[i]);
            }
        }
        return sb.toString();
    }
}
