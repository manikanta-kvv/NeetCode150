package arrays_hashing;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] hashArray = new int[26];
        for(char ch : s.toCharArray()) {
            hashArray[ch - 97]++;
        }
        for(char ch : t.toCharArray()) {
            hashArray[ch - 97]--;
        }

        for(int num : hashArray) {
            if(num != 0) return  false;
        }
        return  true;

    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }
}
