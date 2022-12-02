package by.mopahta.laba.task121415;

import java.util.Objects;

public class Book implements Cloneable, Comparable<Book> {
    private String title;
    private String author;
    private int price;
    private static int edition = 1;
    private int isbn;

    public Book() {
    }


    public Book(String title, String author, int price, int isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getEdition() {
        return edition;
    }

    public static void setEdition(int edition) {
        Book.edition = edition;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setBn(int bn) {
        isbn = bn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && isbn == book.isbn && title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, isbn);
    }

    @Override
    public Book clone() {
        try {
            Book clone = (Book) super.clone();
            clone.author = author;
            clone.price = price;
            clone.title = title;
            clone.isbn = isbn;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", edition=" + edition +
                ", isbn=" + isbn +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(isbn, o.isbn);
    }
}