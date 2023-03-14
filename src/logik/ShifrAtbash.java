package logik;

public class ShifrAtbash extends ShifrAlphabet implements Shifrator{

    @Override
    public String shifrator(String planeText) {
        StringBuilder sb = new StringBuilder();
        for(char a: planeText.toCharArray()){
            if(getRusArray().contains(a)){
                sb.append(alphabetRus[alphabetRus.length - getRusArray().indexOf(a) -1]);
                continue;
            }
            if (getEngArray().contains(a)){
                sb.append(alphabetEng[alphabetEng.length - getEngArray().indexOf(a) -1]);
                continue;
            }
            if(arrayUpRus.contains(a)){
                sb.append(arrayUpRus.get(arrayUpRus.size() - arrayUpRus.indexOf(a) - 1));
                continue;
            }
            if (arrayUpEng.contains(a)){
                sb.append(arrayUpEng.get(arrayUpEng.size() - arrayUpEng.indexOf(a) - 1));
                continue;
            } else {
                sb.append(a);
            }
        }
        return sb.toString();
    }

    @Override
    public String deshifrator(String codeText) {
        StringBuilder sb = new StringBuilder();
        for(char a: codeText.toCharArray()){
            if(getRusArray().contains(a)){
                sb.append(alphabetRus[alphabetRus.length - getRusArray().indexOf(a) -1]);
                continue;
            }
            if (getEngArray().contains(a)){
                sb.append(alphabetEng[alphabetEng.length - getEngArray().indexOf(a) -1]);
                continue;
            }
            if(arrayUpRus.contains(a)){
                sb.append(arrayUpRus.get(arrayUpRus.size() - arrayUpRus.indexOf(a) - 1));
                continue;
            }
            if (arrayUpEng.contains(a)){
                sb.append(arrayUpEng.get(arrayUpEng.size() - arrayUpEng.indexOf(a) - 1));
                continue;
            } else {
                sb.append(a);
            }
        }
        return sb.toString();
    }
}
