// https://leetcode.com/problems/valid-palindrome/description/

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String s1="";
        for(Character ch : s.toCharArray()){
            if( (ch >= 97 && ch <= (97+25)) || (ch >= 65 && ch <= (65+25) ) || Character.isDigit(ch)){
                s1+=ch;
            }
        }
        return isPalindromeHelper(s1.toLowerCase(),0,s1.length()-1);
    }

    private boolean isPalindromeHelper(String s, int i, int j) {
         if (i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (left == right) {
                return isPalindromeHelper(s, ++i, --j);
            }
            return false;
        }
        return true;
    }
}
