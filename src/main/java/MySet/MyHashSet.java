package main.java.MySet;

import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

    private int max_size;
    private List<Integer>[] arr;

    /** Initialize your data structure here. */
    public MyHashSet() {
        max_size = 1000;
        arr = new List[max_size];
        for (int i=0;i<max_size;++i) arr[i] = new LinkedList<>();
    }

    public void add(int key) {
        List<Integer> list = arr[hash(key)];
        if (!list.contains(key)) list.add(key);
    }

    public void remove(int key) {
        List<Integer> list = arr[hash(key)];
        list.remove(Integer.valueOf(key));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return arr[hash(key)].contains(key);
    }

    private int hash(int key) { return key%max_size; }
}
