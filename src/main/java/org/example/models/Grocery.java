package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press: 0 --> exit \n 1 --> add items \n 2 --> remove items");
            String giris = scanner.nextLine();

            if (giris.equals("0")) {
                System.out.println("exiting...");
                break;
            } else if (giris.equals("1")) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                addItems(input);
            } else if (giris.equals("2")) {
                System.out.println("Cıkarılmaısnı istediğiniz elemanları giriniz.");
                String input = scanner.nextLine();
                removeItems(input);
            }
        }
    }
    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            } else {
                System.out.println("this item already exists");
            }
        }
        printSorted();
    }
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item: items) {
            if (groceryList.contains(item)) {
                groceryList.remove(item);
            } else {
                System.out.println("this item does not exist");
            }
        }
        printSorted();
    }
    public static void checkItemsIsInList(String product) {
        if (groceryList.contains(product)) {
            System.out.println(product + "exists");
        } else {
            System.out.println(product + "does not exists");
        }
    }
    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("updated sorted list" + groceryList);

    }

}
