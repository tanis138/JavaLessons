package com.tanis138.book;

import java.util.Scanner;

public class BookRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // generate and print books
        Book[] books = BookAction.generateBooks(10);
        BookAction.printBooks(books);
        System.out.println();

        // print books by author
        BookAction.printAuthors();
        int nMax = BookAction.AUTHORS.length;
        int n;
        do {
            System.out.printf("Input author num (1..%d): ", nMax);
            n = sc.nextInt();
        } while (n < 1 || n > nMax);
        BookAction.printBooksByAuthor(books, n - 1);
        System.out.println();

        // print books by publisher
        BookAction.printPublishers();
        nMax = BookAction.PUBLISHERS.length;
        do {
            System.out.printf("Input publisher num (1..%d): ", nMax);
            n = sc.nextInt();
        } while (n < 1 || n > nMax);
        BookAction.printBooksByPublisher(books, n - 1);
        System.out.println();

        // print books after year
        System.out.print("Input year: ");
        int year = sc.nextInt();
        BookAction.printBooksAfterYear(books, year);
        System.out.println();

        sc.close();
    }
}
