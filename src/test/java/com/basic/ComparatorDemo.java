package com.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    List<Integer> list;

    private void learn() {

        list = new ArrayList<>();
        list.add(23);
        list.add(389);
        list.add(210);
        list.add(389);

        Comparator<Integer> comparator = new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {

                return a - b;
            }
        };

        System.out.println("The unsorted list is : " + list);

        list.sort(comparator);

        System.out.println("This is sorted list : " + list);
    }

    public static void main(String[] args) {

        new ComparatorDemo().learn();

    }
}
