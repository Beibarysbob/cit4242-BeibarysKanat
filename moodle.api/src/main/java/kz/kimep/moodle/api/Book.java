package kz.kimep.moodle.api.catalogue;

public record Book(String title, int pages) {
    public boolean isLong() {
        return pages > 300;
    }
}
