import java.util.*;

import static java.lang.System.*;

public class PhoneNumLetter {
    Map<String, String> mapNumLetter;
    List<String> combLetterList;

    public PhoneNumLetter() {
        combLetterList = new ArrayList<String>();
        mapNumLetter = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "123");
            put("9", "wxyzv");
        }};
    }
    public void backtrack(String combination, String[] nextNum) {
        if (nextNum.length == 0) {
            combLetterList.add(combination);
        }
        else {
            String digit = nextNum[0];
            String letters = mapNumLetter.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = mapNumLetter.get(digit).substring(i, i + 1);
                backtrack(combination + letter,deleteArray(nextNum) );
            }
        }
    }

    public String[] deleteArray(String array[]) {
        String[] arrNew = new String[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            arrNew[i]=array[i+1];
        }
        return arrNew;
    }

    public List<String> letterCombinations(String[] digits) {
        if (digits.length != 0)
            backtrack("", digits);
        return combLetterList;
    }

    public static void main(String[] args) {
        PhoneNumLetter phoneNumLetter=new PhoneNumLetter();
        String[] inputStr = {"2","3","4"};
        phoneNumLetter.letterCombinations(inputStr);
        for (String letter:phoneNumLetter.combLetterList){
            out.println(letter);
        }
    }
}
