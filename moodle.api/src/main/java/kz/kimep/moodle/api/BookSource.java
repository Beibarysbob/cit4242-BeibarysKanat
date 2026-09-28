package kz.kimep.moodle.api.catalogue;

import java.util.List;

public interface BookSource {
    List<Book> load();
}

