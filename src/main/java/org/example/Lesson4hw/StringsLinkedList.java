package org.example.Lesson4hw;

import java.util.List;
import java.util.Set;

public class StringsLinkedList {

    private final Node first = new Node();
    private final Node last = new Node();

    public StringsLinkedList(){}    //Пустой конструктор

    public StringsLinkedList(List<String> list){  //Конструктор добавляет типизированный List String
        addAll(list);
    }

        /*Конструктор добавляет Set типа Number и его наследников
        используется <? extends Number> т.к. нам нужно чтобы множество предоставляло элементы типа Number и
        его наследников, принимать какие либо значение не требуется*/
    public StringsLinkedList(Set<? extends Number> list){
        for (Number number : list) {      //Перебираем множество
            add(String.valueOf(number.intValue()));   //Добавляем значение в наш StringsLinkedList
        }
    }

    public void add(String value) {  //Добавляет String в Node и в наш StringsLinkedList
        if (first.next == null) {    //Проверяем что в StringsLinkedList есть элементы
            Node node = new Node();  //Первый нод надо связать с first и last нодами
            node.value = value;
            first.next = node;
            node.prev = first;
            node.next = last;
            last.prev = node;
            return;
        }

        Node node = new Node();     //Создаем нод
        node.value = value;         //Записываем значение String value в нод

        Node lastNode = last.prev;  //Добавляем нод в StringsLinkedList с конца
        lastNode.next = node;
        node.prev = lastNode;
        node.next = last;
        last.prev = node;
    }

    public void addAll(List<String> list) {  //Добавляем все элементы List<String> в наш StringsLinkedList
        for (String s : list) {
            add(s);
        }
    }

    public String get(int index) {         //Возвращает значение String по index
        Node node = first.next;
        for (int i = 0; i < index; i++) {
            if (node == last){
                return null;
            }
            node = node.next;
        }
        return node.value;
    }

    public void printAll() {              //Выводит все элементы StringsLinkedList в консоль
        if (first.next == null) {         //Проверяем что в StringsLinkedList есть элементы
            System.out.println("В StringsLinkedList нет элементов");
            return;
        }
        Node node = first.next;
        StringBuilder stringBuilder = new StringBuilder();
        while (node != last) {
            stringBuilder.append(node.value).append(" ");
            node = node.next;
        }
        System.out.println(stringBuilder);
    }

    public String remove(int index) {   //Удаляем Node index и возвращаем его значение String
        Node node = first.next;
        for (int i = 0; i < index; i++) {
            if (node == last){
                return null;
            }
            node = node.next;
        }
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        return node.value;
    }

    public int size() {          //Возвращает количество нодов, не считая first и last
        if (first.next == null)
            return 0;
        Node node = first.next;
        int count = 0;
        while (node != last) {
            ++count;
            node = node.next;
        }
        return count;
    }

    private void swap(int index) {      //Меняет местами Node index и следущий за ним, используется в методах sort
        Node node = first.next;

        for (int k = 0; k < index; k++) {   //Получаем Node по его индексу
            node = node.next;
        }

        Node nodePrev = node.prev;          //Получаем Node перед Node index
        Node nodePlusOne = node.next;       //Получаем Node с которым будем менять местами Node index
        Node nodeNext = nodePlusOne.next;   //Получаем Node идущий после Node с которым будем менять местами Node index

        nodePrev.next = nodePlusOne;
        nodeNext.prev = node;
        nodePlusOne.prev = nodePrev;
        nodePlusOne.next = node;
        node.prev = nodePlusOne;
        node.next = nodeNext;
    }

    public void sortByLineLength() {   //Сортировка по длинне строки
        boolean flag = true;
        int i = 0;
            /*Значение i используется для уменьшения размера сортируемого массива, после каждого цикла
            наибольшее значение занимает последнее место в массиве, а значит после каждого цикла можно уменьшать
            размер сортируемого массива с конца*/
        //Код пузырьковой сортировки с флажком
        while (flag)
        {
            flag = false;
            for (int j = 0; j < size() - i - 1; j++)
            {
                if (get(j).length() > get(j + 1).length())
                {
                   swap(j);   //Меняет местами Node j и следущий за ним
                    flag = true;
                }
            }
            i = i + 1; //Уменьшаем размер сортируемого массива
        }
    }

    public void sortByFirstLetter() {   //Сортировка по первой букве
        boolean flag = true;
        int i = 0;
            /*Значение i используется для уменьшения размера сортируемого массива, после каждого цикла
            наибольшее значение занимает последнее место в массиве, а значит после каждого цикла можно уменьшать
            размер сортируемого массива с конца */
        //Код пузырьковой сортировки с флажком
        while (flag)
        {
            flag = false;
            for (int j = 0; j < size() - i - 1; j++)
            {
                if (get(j).charAt(0) > get(j + 1).charAt(0))
                {
                    swap(j);        //Меняет местами Node j и следущий за ним
                    flag = true;    //Пока в массиве происходят изменения цикл не прекратится
                }
            }
            i = i + 1; //Уменьшаем размер сортируемого массива
        }
    }

    private static class Node {
        private Node prev;
        private String value;
        private Node next;
    }

}
