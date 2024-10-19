package sliding_window;

import java.util.Arrays;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1freq = new int[26];
        int[] s2freq = new int[26];
        int s1Len = s1.length();
        int s2Len = s2.length();
        for(int i = 0; i < s1Len; i++) {
            s1freq[s1.charAt(i) - 'a']++;
        }
        //sliding window length will be incremented till we hit the length of s1
        //sliding window length as winLen
        for(int winLen = 0; winLen < s2Len; winLen++) {
            //considering current char into the current window by adding
            s2freq[s2.charAt(winLen) - 'a']++;
            //if the current window length >= s1Len, means we are at current window size, else increment winLen till we hit s1Len
            // so slide the window by each index right side and decrement the value of each char in s2freq from left side
            if(winLen >= s1Len) {
                s2freq[s2.charAt(winLen - s1Len) - 'a']--;
            }
            //if frequencies of both arrays equal, means the current window has the required answer
            if(Arrays.equals(s1freq, s2freq)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "ab";
        boolean result = checkInclusion(s1, s2);
        System.out.println(result);
    }
}
