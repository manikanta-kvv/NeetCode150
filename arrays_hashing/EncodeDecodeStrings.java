package arrays_hashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    public static String encodeString(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String st : strs) {
            sb.append(st.length()).append("#").append(st);
        }
        return  sb.toString();
    }

    public static List<String> decodeString(String str) {
        List<String> tempList = new ArrayList<>();
        //i is used to scrape the length of the string that is present before #
        int i = 0;
        while(i < str.length()) {
            //initialize j to i and increment by 1 if non-# found
            int j = i;
            //j pointer stops at index where # found
            while(str.charAt(j) != '#') j++;
            //to get the length of the string, parseInteger value from substring(i, j)
            int length = Integer.parseInt(str.substring(i,j));
            //now replace i value with (j + 1 + length) which is the start pointer for the next string
            i = j + 1 + length;
            //add substring(j + 1, i) which contains the required string, to the list
            tempList.add(str.substring(j + 1, i));
        }

        return  tempList;
    }

    public static void main(String[] args) {
        List<String> input = List.of("lint", "code", "problem", "solve");
        String encodedString = encodeString(input);
        System.out.println(encodedString);
        List<String> decodedString = decodeString(encodedString);
        System.out.println(decodedString);
    }
}
