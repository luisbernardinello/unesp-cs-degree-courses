package leetcode.binarysearch.timebasedkeyvaluestore;
import java.util.*;
//https://leetcode.com/problems/time-based-key-value-store/
public class Solution {

    // TreeMap solution
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }

        TreeMap<Integer, String> treeMap = map.get(key);
        treeMap.put(timestamp, value);
    }

    public String get (String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        TreeMap<Integer, String> treeMap = map.get(key);

        //greatest key less than or equal to the given key

        Integer smallTimeStamp = treeMap.floorKey(timestamp);
        if(smallTimeStamp == null) return "";

        return treeMap.get(smallTimeStamp);
    }


    public static void main(String[] args) {

    }
}
