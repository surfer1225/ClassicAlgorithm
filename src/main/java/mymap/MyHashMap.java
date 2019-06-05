package main.java.mymap;

import java.util.LinkedList;
import java.util.List;

/*
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap.
If the value already exists in the HashMap, update the value.

get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)

 */
public class MyHashMap {

    class Pair {
        int key;
        int val;

        public Pair(int key, int val) {
            this.val = val;
            this.key = key;
        }

        @Override
        public boolean equals(Object p) {
            if (!(p instanceof Pair)) return false;
            return key == ((Pair) p).key;
        }
    }

    private int max_size;
    private List<Pair>[] arr;

    /** Initialize your data structure here. */
    public MyHashMap() {
        max_size = 1000;
        arr = new List[max_size];
        for (int i=0;i<max_size;++i) arr[i] = new LinkedList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        List<Pair> list = arr[key%max_size];
        boolean found = false;
        for (Pair p:list) {
            if (p.key == key) {
                p.val = value;
                found = true;
            }
        }
        if (!found) list.add(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        List<Pair> list = arr[key%max_size];
        for (Pair p:list) {
            if (p.key == key) return p.val;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key%max_size].remove(new Pair(key, 0));
    }
}
