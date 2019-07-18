package com.tanis138.book;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int year;
    private int pageCount;
    private int price;
    private Cover cover;

    Book() {
        setId(0);
        setName("Undefined");
        setAuthor("Undefined");
        setPublisher("Undefined");
        setYear(0);
        setPageCount(0);
        setPrice(0);
        setCover(Cover.UNDEFINED);
    }

    public Book(int id, String name, String author, String publisher, int year, int pageCount, int price, Cover cover) {
        setId(id);
        setName(name);
        setAuthor(author);
        setPublisher(publisher);
        setYear(year);
        setPageCount(pageCount);
        setPrice(price);
        setCover(cover);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            id = 0;
        }

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0) {
            year = 0;
        }
        this.year = year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 0) {
            pageCount = 0;
        }
        this.pageCount = pageCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            price = 0;
        }
        this.price = price;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                year == book.year &&
                pageCount == book.pageCount &&
                price == book.price &&
                name.equals(book.name) &&
                author.equals(book.author) &&
                publisher.equals(book.publisher) &&
                cover == book.cover;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, publisher, year, pageCount, price, cover);
    }

    @Override
    public String toString() {
        String res = String.format("[id:%d] - \"%s\" by %s (%d, %dp, %s cover, publ. \"%s\") - $%d",
                id, name, author, year, pageCount, cover.toString().toLowerCase(), publisher, price);
        return res;
//        return "Book{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", author='" + author + '\'' +
//                ", publisher='" + publisher + '\'' +
//                ", year=" + year +
//                ", pageCount=" + pageCount +
//                ", price=" + price +
//                ", cover=" + cover.toString().toLowerCase() +
//                '}';
    }
}
