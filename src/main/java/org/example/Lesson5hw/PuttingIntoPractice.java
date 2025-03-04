package org.example.Lesson5hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        1.
        List<Transaction> hw1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println(hw1);

//        2.
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

//        3.
        List<Trader> hw3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .toList();
        System.out.println(hw3);

//        4.
        String hw4 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println(hw4);

//        5.
        Boolean hw5 = transactions.stream()
                .map(Transaction::getTrader)   //это можно пропустить transaction.getTrader.getCity().equals("Milan")
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println(hw5);

//        6.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

//        7.
        int hw7 = transactions.stream()
                .max((t1,t2)-> Integer.compare(t1.getValue(), t2.getValue()))
                .get().getValue();
        System.out.println("Максимальная сумма: " + hw7);

//        8.
        int hw8 = transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .get().getValue();
        System.out.println("Минимальная сумма: " + hw8);

    }
}
