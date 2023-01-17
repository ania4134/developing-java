package developing.tasks.string.challenge;

//A string is called balanced when every letter occuring in the string, appears both in upper- and lowercase.
//For example, the string "CATattac" is blanced ('a', 'c' and 't' occur in both cases), but "Madam" is not
//        ('d' and 'a' appear only in lowercase). Note that the number of occurrences does not matter.
//Write function that, given  a string S of length N, returns the length of the shortest balanced fragment of S.
//If S does not contain any balanced fragments, the function should return -1.
//Example:
//1. Given S = "azABaabza", the function should return 5. The shortest balanced fragment of S is "ABaab".

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Solution {
    public int solution(String S) {
        List<Character> notCamelCharList = new ArrayList<>();
        List<Character> camelCharList = new ArrayList<>();
        List<String> balancedFragmentList = new ArrayList<>();
        String charsNotCamel = "[";
        char character;

        if (S.length() > 0 && S.length() <= 200) {
            for (int i = 0; i < S.length(); i++) {
                character = S.charAt(i);
                if (!isCamel(character, S))
                    charsNotCamel += character;
                else
                    camelCharList.add(character);
            }
            charsNotCamel += "]";

            if (notCamelCharList.size() == S.length())
                return -1;
            if (notCamelCharList.size() == 0 && isBalanced(S))
                return S.length();

            String[] fragments = S.split(charsNotCamel);

            for (int j = 0; j < fragments.length; j++) {
                if (isBalanced(fragments[j]))
                    balancedFragmentList.add(fragments[j]);
            }
            if (balancedFragmentList.size() == 0)
                return -1;

            int result = balancedFragmentList.stream().map(n -> n.length()).min(Integer::compare).get();
            return result;
        } else
            System.out.println("Wrong string length");
        return -1;
    }

    private boolean isCamel(char n, String S) {
        if (Character.isUpperCase(n) && S.contains(String.valueOf(n).toLowerCase(Locale.ROOT)) ||
                Character.isLowerCase(n) && S.contains(String.valueOf(n).toUpperCase(Locale.ROOT)))
            return true;
        else
            return false;
    }

    private boolean isBalanced(String fragment) {
        char character;
        boolean result = true;
        for (int i = 0; i < fragment.length(); i++) {
            character = fragment.charAt(i);
            if (!isCamel(character, fragment))
                result = false;
        }
        return result;
    }
}
