package kz.kimep.moodle.api.catalogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvBookSource implements BookSource {
    private final String resource;

    public CsvBookSource(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Book> load() {
        InputStream input = CsvBookSource.class.getResourceAsStream(resource);
        if (input == null) {
            throw new IllegalArgumentException("Resource not found: " + resource);
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8))) {
            return reader.lines()
                    .filter(line -> !line.isBlank())
                    .map(line -> line.split(";"))
                    .map(parts -> new Book(parts[0], Integer.parseInt(parts[1])))
                    .toList();
        } catch (IOException e) {
            throw new IllegalStateException("Could not read resource: " + resource, e);
        }
    }
}
