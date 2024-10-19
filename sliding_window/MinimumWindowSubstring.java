package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int[] indices = new int[2];
        Map<Character, Integer> tMap = new HashMap<>();
        for(Character ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        //unique elements current window have
        int uniqueElements_have = 0;
        //unique elements needed = unique elements of t
        int uniqueElements_needed = tMap.size();
        Map<Character, Integer> currentWindowMap = new HashMap<>();
        int left = 0, right = 0;
        for(Character ch : s.toCharArray()) {
            currentWindowMap.put(ch, currentWindowMap.getOrDefault(ch, 0) + 1);

            //if the current character is in tMap and
            // count of current character in current window is equal to count of current character in tMap
            //increment unique elements we have by 1
            if(tMap.containsKey(ch) && currentWindowMap.get(ch).equals(tMap.get(ch))) {
                uniqueElements_have++;
            }

            //as we need to find the minimum length of the window
            //if uniqueElements_have == uniqueElements_needed, then it means the current window is one of the answer
            //to check whether the current window length is minimum,
            // we shrink the current window size by 1 by removing the each element from current window from left side
            while(uniqueElements_have == uniqueElements_needed) {
                //check if the current window length is minimum
                if((right - left + 1) < minLen) {
                    minLen = right  - left + 1;
                    indices[0] = left;
                    indices[1] = right;
                }

                //removing characters from left side
                currentWindowMap.put(s.charAt(left), currentWindowMap.get(s.charAt(left)) - 1);
                //if the removed character in tMap and
                //if the count of removed character in current window < count of removed character in tMap
                //then decrement uniqueElements_have by 1
                if(tMap.containsKey(s.charAt(left)) && currentWindowMap.get(s.charAt(left)) < tMap.get(s.charAt(left))) {
                    uniqueElements_have--;
                }
                left++;
            }
            right++;

        }
        System.out.println("Min Length : " + minLen);
        if (minLen == Integer.MAX_VALUE) {
            return "";  // No valid window was found
        }
        return s.substring(indices[0], indices[1] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "BANC";
        String result = minWindow(s, t);
        System.out.println(result);
    }
}
