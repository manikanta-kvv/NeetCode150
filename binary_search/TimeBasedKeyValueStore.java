package binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    Map<String, List<Pair<Integer, String>>> keyStore;
    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String >> list;
        if(keyStore.containsKey(key)) {
            list = keyStore.get(key);
        }
        else{
            list = new ArrayList<>();
        }
        list.add(new Pair<>(timestamp, value));
        keyStore.put(key, list);

    }
    //as timestamp values are inserted at increasing order
    //using binary search, will look for timestamps <= given timestamp
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        System.out.println("Values list for key '" + key + "': " + values.toString());

        if (values.isEmpty()) {
            return "";
        }

        // Binary search to find the value at the timestamp
        int left = 0;
        int right = values.size() - 1;
        String result = "";

        System.out.println("Looking for timestamp <= " + timestamp);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentTimestamp = values.get(mid).getKey();
            String currentValue = values.get(mid).getValue();

            System.out.println("\nCurrent search window:");
            System.out.println("Left index: " + left + ", Right index: " + right + ", Mid index: " + mid);
            System.out.println("Comparing timestamp " + timestamp + " with " + currentTimestamp);

            if (currentTimestamp <= timestamp) {
                System.out.println("Current timestamp " + currentTimestamp + " <= target " + timestamp);
                System.out.println("Updating result to: " + currentValue);
                result = currentValue;
                left = mid + 1;

            } else {
                System.out.println("Current timestamp " + currentTimestamp + " > target " + timestamp);
                right = mid - 1;

            }
        }
        return result;
    }

}

class Pair<I extends Number, S> {
    Integer key;
    String value;
    Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "{timestamp=" + key + ", value='" + value + "'}";
    }
}

public class TimeBasedKeyValueStore {


    public static void main(String[] args) {
        // Create TimeMap instance
        TimeMap timeMap = new TimeMap();

        // Test Case 1
        System.out.println("\n=== Test Case 1 ===");
        timeMap.set("foo", "bar", 1);    // store the key "foo" and value "bar" along with timestamp = 1

        // Test Case 2
        System.out.println("\n=== Test Case 2 ===");
        String result1 = timeMap.get("foo", 1);  // return "bar" since there's only one value
        System.out.println("Result for get(foo, 1): " + result1);

        // Test Case 3
        System.out.println("\n=== Test Case 3 ===");
        String result2 = timeMap.get("foo", 3);  // return "bar" since it's the latest value for timestamp <= 3
        System.out.println("Result for get(foo, 3): " + result2);

        // Test Case 4
        System.out.println("\n=== Test Case 4 ===");
        timeMap.set("foo", "bar2", 4);   // store the key "foo" and value "bar2" along with timestamp = 4

        // Test Case 5
        System.out.println("\n=== Test Case 5 ===");
        String result3 = timeMap.get("foo", 4);  // return "bar2" since it's the value at timestamp 4
        System.out.println("Result for get(foo, 4): " + result3);

        // Test Case 6
        System.out.println("\n=== Test Case 6 ===");
        String result4 = timeMap.get("foo", 5);  // return "bar2" since it's the latest value for timestamp <= 5
        System.out.println("Result for get(foo, 5): " + result4);
    }
}
