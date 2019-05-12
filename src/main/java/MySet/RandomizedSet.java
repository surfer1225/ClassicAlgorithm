package main.java.MySet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
    Set<Integer> set;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(set.size());
        Iterator<Integer> it = set.iterator();
        for (int i=0;i<index;i++) it.next();
        return it.next();
    }
}
