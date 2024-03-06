package fr.epita.practice.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestSER1 {
    public static void test() throws IOException{
        Path currentFilePath = Path.of("data/data.csv");
        System.out.println("looking for file at this location:" + currentFilePath.toFile().getAbsolutePath());
        List<String> lines = Files.readAllLines(currentFilePath);
        if (lines.size() >= 2) {
            String secondLine = lines.get(2); // 0-based index, so getting the 2nd line
            String[] parts = secondLine.split(",");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }
            System.out.println("2nd Line: " + String.join(", ", parts));
        } else {
            System.out.println("File is empty or does not contain enough lines.");
        }
    }
}
