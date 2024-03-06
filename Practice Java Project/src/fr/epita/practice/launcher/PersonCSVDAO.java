package fr.epita.practice.launcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.epita.practice.datamodel.Person;
import fr.epita.practice.datamodel.Sex;
public class PersonCSVDAO {
     public List<Person> readAll() throws IOException {
        List<Person> persons = new ArrayList<>();
        Path currentFilePath = Path.of("data/data.csv"); 

        List<String> lines = Files.readAllLines(currentFilePath);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);

            String[] parts = line.split(",");
            for (int j = 0; j < parts.length; j++) {
                parts[j] = parts[j].trim();
            }

            // Creating a Person instance and adding it to the list
            Person person = new Person(parts[0].replaceAll("\"", ""), Integer.parseInt(parts[2]), parts[1] == "M" ? Sex.M : Sex.F, Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
            persons.add(person);
        }

        // Sorting the list by height
        Collections.sort(persons, (p1, p2) -> Integer.compare(p1.getHeight(), p2.getHeight()));
        
        return persons;
    }

    public void writeAll(List<Person> persons) throws IOException {

        Path outputPath = Path.of("data/data_output.csv");
        List<String> outputLines = new ArrayList<>();

        // Adding the header line
        outputLines.add("\"Name \",\"Height (in) \",\"Weight (lbs) \",\"Age \",\"Sex \"");

        // Adding data lines with the new column order
        for (Person person : persons) {
            outputLines.add(String.format("\"%s \",%d,%d,%d,\"%s \"",
                person.getName(), person.getHeight(), person.getWeight(),person.getAge(),person.getSex()));
        }

        if (Files.exists(outputPath)) {
            Files.write(outputPath, outputLines, java.nio.file.StandardOpenOption.APPEND);
        } else {
            Files.write(outputPath, outputLines);
        }
    }
}
