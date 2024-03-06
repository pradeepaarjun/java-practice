package fr.epita.practice.test;

import java.io.IOException;
import java.util.List;

import fr.epita.practice.datamodel.Person;
import fr.epita.practice.launcher.PersonCSVDAO;
import fr.epita.practice.services.PersonJDBCDAO;

public class TestJDB2 {
 public static void test() {
        List<Person> persons = readPersonsFromCSV();

        PersonJDBCDAO personJDBCDAO = new PersonJDBCDAO();
        for (Person person : persons) {
            personJDBCDAO.create(person);
        }

        List<Person> result = personJDBCDAO.search();

        for (Person person : result) {
            System.out.println(person.toString());
        }
    }
    private static List<Person> readPersonsFromCSV() {
        try {
            return new PersonCSVDAO().readAll();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
