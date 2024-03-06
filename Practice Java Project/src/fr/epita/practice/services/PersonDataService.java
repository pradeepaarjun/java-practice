package fr.epita.practice.services;
import java.util.ArrayList;
import java.util.List;

import fr.epita.practice.datamodel.Person;

public class PersonDataService {
    public int averageAge(List<Person> persons){
        if(persons.isEmpty()){
            return 0;
        }
        int totalAge =0;
        for(Person person: persons){
            totalAge += person.getAge();
        }
        return totalAge / persons.size();
    }
public List<Person> filter(List<Person> persons, int thresholdAge){
    List<Person> filteredPersons = new ArrayList<>();
    for(Person person: persons){
        if(person.getAge() > thresholdAge){
            filteredPersons.add(person);
        }
    }
    return filteredPersons;
}
public int calculateYearOfBirth(Person person){
    int currentYear = java.time.Year.now().getValue();
    return currentYear - person.getAge();
}

}
