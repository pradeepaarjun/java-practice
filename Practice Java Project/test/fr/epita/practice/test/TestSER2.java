package fr.epita.practice.test;

import java.io.IOException;
import java.util.List;

import fr.epita.practice.datamodel.Person;
import fr.epita.practice.launcher.PersonCSVDAO;

public class TestSER2 {
    public static void test() {
         PersonCSVDAO personCSVDAO = new PersonCSVDAO();

        try {
            List<Person> persons = personCSVDAO.readAll();

            for (Person person : persons) {
                System.out.println(person.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
