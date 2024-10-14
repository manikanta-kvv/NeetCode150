package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        //use left and right pointers to find the length between the substring(left, right)
        int left = 0;
        int right = 0;
        //store char and its last appeared index in map
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            //if the current char is already in the map, means we found the repeating character
            //so we fetch the last appeared index of that element from map, and increment it by 1
            //to make sure we are skipping the repeating characters
            //if the current left index > current element's last appeared index, then take max of both, and store in left
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1 );
            }
            //putting the current char to the map,
            //if current char exists then its value updated by the last appeared index
            //else add current char and its index into the map
            map.put(s.charAt(right), right);
            //right - left + 1 => gives the length of the substring
            //update maxLen value by taking max of maxLen and (right - left) + 1
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String st = "";
        int result = lengthOfLongestSubstring(st);
        System.out.println(result);

    }
}
