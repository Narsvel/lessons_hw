package org.example.Lesson4hw;

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

    }

}
