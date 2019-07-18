package com.tanis138.book;

import java.util.Random;

public class BookAction {

    public static final int YEAR_FROM = 1950;
    public static final int YEAR_TO = 2019;
    public static final int PAGE_COUNT_FROM = 50;
    public static final int PAGE_COUNT_TO = 1000;
    public static final int PRICE_FROM = 20;
    public static final int PRICE_TO = 100;

    public static final String[] AUTHORS = {"Ivanov", "Petrov", "Sidorov"};
    public static final String[] PUBLISHERS = {"Dialektika", "Svet v Massi", "Roga i Kopita", "Trudnij Put"};
    private static final String TITLE = "A Title ";


    private static int id = 0;

    public static void printAuthors() {
        System.out.printf("Available authors (%d): ", AUTHORS.length);
        for (String author : AUTHORS) {
            System.out.print(author + ", ");
        }
        System.out.println();
    }

    public static void printPublishers() {
        System.out.printf("Available publishers (%d): ", PUBLISHERS.length);
        for (String publisher : PUBLISHERS) {
            System.out.printf("\"%s\", ", publisher);
        }
        System.out.println();
    }

    public static void printBooks(Book[] books) {
        if (books == null) {
            System.out.println("Books collection is empty!");
            return;
        }
        System.out.printf("Available books (%d): \n", books.length);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void printBooksByAuthor(Book[] books, int authorId) {
        if (books == null) {
            System.out.println("Books collection is empty!");
            return;
        }
        if (authorId < 0 || authorId >= AUTHORS.length) {
            System.out.println("Wrong author id!");
            return;
        }
        System.out.printf("Books written by %s: \n", AUTHORS[authorId]);
        for (Book book : books) {
            if (book.getAuthor().equals(AUTHORS[authorId])) {
                System.out.println(book);
            }
        }
    }

    public static void printBooksByPublisher(Book[] books, int publisherId) {
        if (books == null) {
            System.out.println("Books collection is empty!");
            return;
        }
        if (publisherId < 0 || publisherId >= PUBLISHERS.length) {
            System.out.println("Wrong publisher id!");
            return;
        }
        System.out.printf("Books printed by \"%s\": \n", PUBLISHERS[publisherId]);
        for (Book book : books) {
            if (book.getPublisher().equals(PUBLISHERS[publisherId])) {
                System.out.println(book);
            }
        }
    }

    public static void printBooksAfterYear(Book[] books, int year) {
        if (books == null) {
            System.out.println("Books collection is empty!");
            return;
        }
        System.out.printf("Books printed after %d: \n", year);
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book);
            }
        }
    }

    public static Book[] generateBooks(final int BOOKS_COUNT) {
        Book[] books = new Book[BOOKS_COUNT];

        for (int i = 0; i < BOOKS_COUNT; i++) {
            String name = TITLE + ++id;
            String author = AUTHORS[generateNumber(AUTHORS.length)];
            String publisher = PUBLISHERS[generateNumber(PUBLISHERS.length)];
            int year = generateNumber(YEAR_FROM, YEAR_TO);
            int pageCount = generateNumber(PAGE_COUNT_FROM, PAGE_COUNT_TO);
            int price = generateNumber(PRICE_FROM, PRICE_TO);
            Cover cover = Cover.values()[generateNumber(Cover.values().length - 1)];

            books[i] = new Book(id, name, author, publisher, year, pageCount, price, cover);
        }

        return books;
    }

    private static int generateNumber(int bound) {
        return new Random().nextInt(bound);
    }

    private static int generateNumber(int from, int to) {
        if (from > to) {
            from = to;
        }
        return from + new Random().nextInt(to - from);
    }

}
