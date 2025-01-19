package org.kd4.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kd4.model.Person;

public class num2_ConvertJsonToJavaObject {

  public static void main(String[] args) {
    String json = "{\"name\":\"kumar\",\"age\":25}";
    ObjectMapper om = new ObjectMapper();
    try {
      Person person = om.readValue(json, Person.class);
      System.out.println(person);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
