package kz.kimep.moodle.api.catalogue;

public record Book(String title, String author, int pages) {
    public boolean isLong() {
        return pages > 300;
    }
}