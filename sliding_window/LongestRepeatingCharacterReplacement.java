package sliding_window;

public class LongestRepeatingCharacterReplacement {

    /* Slinding window:
    i sits at the top of the slinding window
    j tries to expand the sliding window
    if the condition doesn't meet, i moves further
     */

    public static int characterReplacement(String s, int k) {
        int len = 0;
        int[] visited = new int[26];
        int maxElementCount = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            //currentCharCount in array
            visited[s.charAt(j) - 'A']++;

            //if the current char count > set maxElement count to current char count
            maxElementCount = Math.max(maxElementCount, visited[s.charAt(j) - 'A']);

            //if we delete the max element count from the current window(j-i+1), which gives
            // the no of the different elements those can be replaced if their count <= k
            //if the no of different elements > k,
            // then the current window is not suitable to consider,
            // so increment i by 1 and decrement char count of i from array by 1 as we are moving i out of the window
            int currentWindowLength = j - i + 1;
            if(currentWindowLength - maxElementCount > k) {
                visited[s.charAt(i) - 'A']--;
                i++;
            }
            //update length of the valid sliding window
            len = Math.max(len, j - i + 1);
        }
        return  len;
    }


    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int result = characterReplacement(s, k);
        System.out.println(result);

    }
}
