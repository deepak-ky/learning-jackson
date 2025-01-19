package org.kd4.examples;

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
  }
}
