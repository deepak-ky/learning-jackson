package org.kd4.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
  private String name;
  private int age;

  /*public User(String name, int age) {
    this.name = name;
    this.age = age;
  }*/

  @JsonCreator
  public User(@JsonProperty("name") String name, @JsonProperty("age") int age) {
    this.name = "JsonCreator : " + name;
    this.age = age;
  }

  /*The annotation doesn't need to include all the class' fields,
  but only a few of them, just so that Jackson is able to create an instance of object
  and then set the remaining fields.*/
  /*@JsonCreator
  public User(@JsonProperty("name") String name) {
    this.name = "JsonCreator 2 : " + name;
  }*/

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

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
