package two_pointers;

import java.util.Locale;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(start < end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }
}
