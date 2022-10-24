package by.mopahta.laba.task13;

import by.mopahta.laba.task121415.Book;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    public ProgrammerBook(String title, String author, int price, int isBn, String language, int level) {
        super(title, author, price, isBn);
        this.language = language;
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "ProgrammerBook{" +
                "language='" + language + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) {
            return false;
        }
        ProgrammerBook programmerBook = (ProgrammerBook) o;
        return level == programmerBook.level && programmerBook.language.equals(language);
    }

    @Override
    public int hashCode() {
        return language.hashCode() + level * 883 + super.hashCode();
    }
}
