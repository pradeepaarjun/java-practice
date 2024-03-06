package fr.epita.practice.test;

import fr.epita.practice.datamodel.Person;
import fr.epita.practice.datamodel.Sex;

public class TestDMO2{
    public static void test() {
        // Creating an instance of Person
        Person person = new Person("Alex", 25, Sex.M, 180, 150);

        // Calling toString() method
        System.out.println(person.toString());
    }

}