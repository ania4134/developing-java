package developing.tasks.string.challenge;

public class StringChallenge {

    private String str;
    private int count;
    char deletedChar;
    String deletedChars = "";
    String newStr = "";

    public void stringChallenge(String str) {
        count = str.length();
        if(isPalindrome(str) && hasMinThreeChar(str) && isLowerCase(str))
            System.out.println(str);
        else {
            while (!isPalindrome(str)) {
                if (hasMinFourChar(str) && isLowerCase(str)) {
                    removeChar(str);
                    str = newStr;
                    deletedChars += deletedChar;
                } else {
                    System.out.println("not possible");
                }
            }
            System.out.println(deletedChars);
        }
    }

    public void removeChar(String str) {
        for(int j = 0; j < count; j++) {
            if (str.charAt(j) != str.charAt(count -1 - j)) {
                newStr = str.substring(0, j) + str.substring(j + 1, count);
                deletedChar = str.charAt(j);
                break;
            }
        }
    }

    public boolean isPalindrome(String str) {
        String strRev = "";

        for (int i = count -1 ; i >= 0; i--) {
            char c = str.charAt(i);
            strRev = strRev + c;
        }
        if(str.equals(strRev))
            return true;
        else
            return false;
    }

    public boolean hasMinThreeChar(String str) {
        if(count >= 3)
            return true;
        else
            return false;
    }

    public boolean hasMinFourChar(String str) {
        if(count > 3)
            return true;
        else
            return false;
    }

    public boolean isLowerCase(String str) {
        String lowerCaseString = str.toLowerCase();
        if(str.equals(lowerCaseString))
            return true;
        else
            return false;
    }
}
