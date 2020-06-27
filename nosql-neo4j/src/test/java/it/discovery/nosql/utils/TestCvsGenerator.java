package it.discovery.nosql.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

/**
 * TODO
 *
 * @author dzmitry.marudau
 * @since 2020.3
 */
public class TestCvsGenerator {
    static int a = 0;

    @Test
    void test() throws FileNotFoundException {
        File csvOutputFile = new File("persons.cvs");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            Stream.generate(() -> "Name" + ++a + "," + (10 + (int)(Math.random() * 80)))
            .limit(1_000_000)
            .forEach(pw::println);
        }
        assertTrue(csvOutputFile.exists());

        csvOutputFile = new File("companies.cvs");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            Stream.generate(() -> "company" + ++a + ", city" +  (int)(Math.random() * 5))
                    .limit(1_000_000)
                    .forEach(pw::println);
        }
    }


}
