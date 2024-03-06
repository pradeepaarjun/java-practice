package fr.epita.practice.launcher;

import fr.epita.practice.datamodel.Person;
import fr.epita.practice.datamodel.Sex;
import fr.epita.practice.test.TestBLI1;
import fr.epita.practice.test.TestDMO2;
import fr.epita.practice.test.TestJDB2;
import fr.epita.practice.test.TestSER1;
import fr.epita.practice.test.TestSER2;
import fr.epita.practice.test.TestSER3;

public class Launcher {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Pradeepa", 25, Sex.F, 180, 60);
        System.out.println(person.toString());
        TestDMO2.test();
        TestSER1.test();
        TestSER2.test();
        TestSER3.test();
        TestBLI1.test();
        TestJDB2.test();
    }
}
