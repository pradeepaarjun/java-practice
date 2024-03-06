package fr.epita.practice.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.practice.datamodel.Person;
import fr.epita.practice.datamodel.Sex;

public class PersonJDBCDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/club_data";
    private static String MYSQL_DB_USER = "root";
    private static String MYSQL_DB_USER_PASSWORD = "pradeepa";
    private static final String CREATE_QUERY = "INSERT INTO persons(name, sex, age, height, weight) VALUES (?, ?, ?, ?, ?)";
    private static final String SEARCH_QUERY = "SELECT * FROM persons";
    public void create(Person person){
    try (Connection connection = DriverManager.getConnection(JDBC_URL,MYSQL_DB_USER, MYSQL_DB_USER_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY)) {

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, String.valueOf(person.getSex()));
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setInt(4, person.getHeight());
            preparedStatement.setInt(5, person.getWeight());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
public List<Person> search(){
    List<Person> persons = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(JDBC_URL,MYSQL_DB_USER, MYSQL_DB_USER_PASSWORD);
         PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            Person person = new Person(
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    Sex.valueOf(resultSet.getString("sex")),
                    resultSet.getInt("height"),
                    resultSet.getInt("weight")
            );
            persons.add(person);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return persons;
}
}