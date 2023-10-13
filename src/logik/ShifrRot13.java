package logik;

public class ShifrRot13 implements Shifrator{
    @Override
    public String shifrator(String planeText) {
        char [] chArr = planeText.toCharArray();
        ShifrAlphabet alphabet = new ShifrAlphabet();
        StringBuilder codeText = new StringBuilder();
        for(char a: chArr){
            if (alphabet.getEngArray().contains(a)||alphabet.arrayUpEng.contains(a)) {
                codeText.append(searchEng(a));
            }else {

                //Добавим символы не из алфавита
                codeText.append(a);
            }
        }
        return codeText.toString();
    }

    @Override
    public String deshifrator(String codeText) {
        char [] chArr = codeText.toCharArray();
        ShifrAlphabet alphabet = new ShifrAlphabet();
        StringBuilder planeText = new StringBuilder();
        for(char a: chArr){
            if (alphabet.getEngArray().contains(a)||alphabet.arrayUpEng.contains(a)) {
                planeText.append(searchEng(a));
            }else {

                //Добавим символы не из алфавита
                planeText.append(a);
            }
        }
        return planeText.toString();
    }
    private String searchEng(Character serchA){
        ShifrAlphabet alphabet = new ShifrAlphabet();
        StringBuilder codeText = new StringBuilder();
        for (int minEn = 0; minEn < alphabet.alphabetEng.length; minEn++) {
            if (serchA == alphabet.alphabetEng[minEn]) {
                if (minEn + 13 < alphabet.alphabetEng.length) {
                    codeText.append(alphabet.alphabetEng[minEn + 13]);
                } else {
                    codeText.append(alphabet.alphabetEng[13 - (alphabet.alphabetEng.length - minEn)]);
                }
            }
        }
        for (int maxEn = 0; maxEn < alphabet.arrayUpEng.size(); maxEn++) {
            if (serchA == alphabet.arrayUpEng.get(maxEn)) {
                if (maxEn + 13 < alphabet.arrayUpEng.size()) {
                    codeText.append(alphabet.arrayUpEng.get(maxEn + 13));
                } else {
                    codeText.append(alphabet.arrayUpEng.get(13 - (alphabet.arrayUpEng.size() - maxEn)));
                }
            }
        }
        return codeText.toString();
    }
}
