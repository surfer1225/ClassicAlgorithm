package main.java.list_design;

import java.util.*;

public class ListRemoval {

    public void removeFromList(LinkedList<Integer> l) {
        Iterator<Integer> it = l.iterator();

        while (it.hasNext()) {
            if (it.next() == 2) {
                it.remove();
            }
        }

        for (int i:l) System.out.println(i);
    }

    public void removeFromList(ArrayList<Integer> l) {
        Iterator<Integer> it = l.iterator();

        while (it.hasNext()) {
            if (it.next() == 2) {
                it.remove();
            }
        }

        for (int i:l) System.out.println(i);
    }

    public static void main(String[] args) {
        ListRemoval lr = new ListRemoval();
        lr.removeFromList(new LinkedList<Integer>() {
            {
                add(1);
                add(2);
                add(7);
                add(2);
                add(2);
                add(3);
                add(6);
            }
        });

        lr.removeFromList(new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(7);
                add(2);
                add(2);
                add(3);
                add(6);
            }
        });
    }
}
