package com.tanis138.cardealer;

import com.tanis138.cardealer.menu.Menu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);

        menu.run();

        scanner.close();
    }
}
