package org.kd4.examples;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kd4.model.Person;

public class num1_ConvertObjectToJson {
  public static void main(String[] args) {
    Person person = new Person("d eepak", 24);
    System.out.println(person);

    ObjectMapper om = new ObjectMapper();
    try {
      String json = om.writeValueAsString(person);
      System.out.println("JSON : ");
      System.out.println(json);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    System.out.println("---");

    Person1 person1 = new Person1("surya kumar yadav", 34);
    System.out.println(person1);
    try {
      String json = om.writeValueAsString(person1);
      System.out.println("JSON : ");
      System.out.println(json);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    System.out.println("---");

    Person2 person2 = new Person2("joe root", 35);
    System.out.println(person2);
    try {
      String json = om.writeValueAsString(person2);
      System.out.println("JSON : ");
      System.out.println(json);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    System.out.println("---");

    Person3 person3 = new Person3("steve smith", 36);
    System.out.println(person3);
    try {
      String json = om.writeValueAsString(person3);
      System.out.println("JSON : ");
      System.out.println(json);
    } catch (JsonProcessingException e) {
      System.out.println("exception occured : " + e.getMessage());;
    }

    System.out.println("---");

    Person4 person4 = new Person4("virat kohli", 36);
    System.out.println(person4);
    try {
      String json = om.writeValueAsString(person4);
      System.out.println("JSON : ");
      System.out.println(json);
    } catch (JsonProcessingException e) {
      System.out.println("exception occured : " + e.getMessage());;
    }

    System.out.println("---");

    Person5 person5 = new Person5("kane williamson", 34);
    System.out.println(person5);
    try {
      String json = om.writeValueAsString(person5);
      System.out.println("JSON : ");
      System.out.println(json);
    } catch (JsonProcessingException e) {
      System.out.println("exception occured : " + e.getMessage());;
    }

  }
}


class Person1 {
  public String name;
  public int age;

  public Person1(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person1 : " + name + " : " + age;
  }
}

class Person2 {
  public String name;
  private int age;

  public Person2(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person2 : " + name + " : " + age;
  }
}

class Person3 {
  private String name;
  private int age;

  public Person3(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person3 : " + name + " : " + age;
  }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Person4 {
  private String naMe;
  private int age;

  public Person4(String name, int age) {
    this.naMe = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person4 : " + naMe + " : " + age;
  }
}


class Person5 {
  @JsonProperty("user_name")
  private String name;
  @JsonProperty("user_age")
  private int age;

  public Person5(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person5 : " + name + " : " + age;
  }
}