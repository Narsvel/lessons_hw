package org.example.Lesson4hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        StringsLinkedList list = new StringsLinkedList();
        list.add("My");
        list.add("String");
        list.add("Linked");
        list.add("List");

        System.out.println(list.size());
        list.printAll();

        list.sortByLineLength();
        list.printAll();

        list.sortByFirstLetter();
        list.printAll();

        System.out.println(list.get(3));
        System.out.println(list.remove(1));
        list.printAll();

        List<String> listString = Arrays.asList("One", "Two", "Three");
        StringsLinkedList listTest = new StringsLinkedList(listString);
        listTest.printAll();

        Set<Number> setNumber = new HashSet<>(Arrays.asList(1, 2, 3, 3.14, 4, 5, 999L));
        StringsLinkedList setTest = new StringsLinkedList(setNumber);
        setTest.printAll();

    }

}
