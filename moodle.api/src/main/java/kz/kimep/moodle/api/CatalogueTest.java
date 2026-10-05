package kz.kimep.moodle.api.catalogue;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalogueTest {

    @Test
    void unknownAuthorReturnsEmptyList() {
        Catalogue catalogue = Catalogue.from(new InMemoryBookSource());

        assertEquals(List.of(), catalogue.titlesBy("Unknown Author"));
    }

    @Test
    void titlesByReturnsSortedTitles() {
        Catalogue catalogue = Catalogue.from(new InMemoryBookSource());

        assertEquals(
                List.of("Clean Architecture", "Clean Code"),
                catalogue.titlesBy("Robert C. Martin")
        );
    }
}