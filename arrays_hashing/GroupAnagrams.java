package arrays_hashing;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String st : strs) {
            char[] charArr = st.toCharArray();
            Arrays.sort(charArr);
            String sortedString = String.valueOf(charArr);
            List<String> tempList;
            if(map.containsKey(sortedString)) {
                tempList = map.get(sortedString);
            }
            else{
                tempList = new ArrayList<>();
            }
            tempList.add(st);
            map.put(sortedString, tempList);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
}
