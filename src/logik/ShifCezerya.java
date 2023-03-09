package logik;

public class ShifCezerya {
    private char[] alphabetEng = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z' };
    private char[] alphabetRus= {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ','ъ','ы','ь','э', 'ю', 'я'};
    private int sdvig;

    public ShifCezerya(int sdvig) {
        this.sdvig = sdvig;
    }
    public String shifrator(String planeText){
        planeText = planeText.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char a: planeText.toCharArray()) {
            boolean nosimvol = true;
            for (int i = 0; i < alphabetRus.length; i++){
                if (a ==alphabetRus[i]) {
                    if(i+sdvig<alphabetRus.length){
                        sb.append(alphabetRus[i+sdvig]);
                    }else {
                        sb.append(alphabetRus[(i+sdvig)- alphabetRus.length]);
                    }
                    nosimvol = false;
                }
            }
            for (int b = 0; b < alphabetEng.length; b++){
                if (a ==alphabetEng[b]) {
                    if(b+sdvig<alphabetEng.length){
                        sb.append(alphabetEng[b+sdvig]);
                    }else {
                        sb.append(alphabetEng[(b+sdvig)- alphabetEng.length]);
                    }
                    nosimvol = false;
                }
            }
            if(nosimvol){
                sb.append(a);
            }
        }
        return sb.toString();
    }
    public String deshifrator(String codeText){
        codeText = codeText.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char a: codeText.toCharArray()) {
            boolean nosimvol = true;
            for (int i = 0; i < alphabetRus.length; i++){
                if (a ==alphabetRus[i]) {
                    if(i-sdvig >= 0){
                        sb.append(alphabetRus[i - sdvig]);
                    }else {
                        sb.append(alphabetRus[(i-sdvig)+ alphabetRus.length]);
                    }
                    nosimvol = false;
                }
            }
            for (int b = 0; b < alphabetEng.length; b++){
                if (a ==alphabetEng[b]) {
                    if(b - sdvig < 0){
                        sb.append(alphabetEng[b - sdvig]);
                    }else {
                        sb.append(alphabetEng[(b - sdvig) + alphabetEng.length]);
                    }
                    nosimvol = false;
                }
            }
            if(nosimvol){
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
