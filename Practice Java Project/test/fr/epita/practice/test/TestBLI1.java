package fr.epita.practice.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import fr.epita.practice.datamodel.Person;
import fr.epita.practice.datamodel.Sex;


import fr.epita.practice.services.PersonDataService;
public class TestBLI1 {
    public static void test() throws IOException{
        PersonDataService persondata = new PersonDataService();
        List<Person> persons = new ArrayList<>();
        Path currentFilePath = Path.of("data/data.csv"); 
        List<String> lines = Files.readAllLines(currentFilePath);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);

            String[] parts = line.split(",");
            for (int j = 0; j < parts.length; j++) {
                parts[j] = parts[j].trim();
            }
            Person person = new Person(parts[0], Integer.parseInt(parts[2]), parts[1] == "M" ? Sex.M : Sex.F, Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
            persons.add(person);
        }
        int averageAge = persondata.averageAge(persons);
        System.out.println("Average Age:" + averageAge);

        List<Person> filteredPersons = persondata.filter(persons, 32);
        System.out.println("Number of persons above the age of 32: " + filteredPersons.size());


        int yearOfBirth = persondata.calculateYearOfBirth(persons.get(0));
        System.out.println("Year of Birth for Alex: " + yearOfBirth);
    }
}
