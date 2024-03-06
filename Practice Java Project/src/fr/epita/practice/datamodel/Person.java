package fr.epita.practice.datamodel;
public class Person {
    private String name;
    private int age;
    private Sex sex;
    private int height;
    private int weight;
    // constructor
    public Person(String name, int age,Sex sex, int height, int weight)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }
    // encapsulation 
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    // overriding to string() method
    @Override
    public String toString() {
        return "Person [name=" + name + ", weight=" + weight + "]";
    }
}
