package kz.kimep.moodle.api.catalogue;

import java.util.List;

public final class Catalogue {
    private final List<Book> books;

    public Catalogue(List<Book> books) {
        this.books = List.copyOf(books);
    }

    public static Catalogue from(BookSource source) {
        return new Catalogue(source.load());
    }

    public List<Book> books() {
        return books;
    }

    public long countLongBooks() {
        return books.stream().filter(Book::isLong).count();
    }
}
