package org.kd4.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.kd4.model.Person;

public class num5_ConvertJsonFileToJavaObject {

  public static void main(String[] args) {
    ObjectMapper om = new ObjectMapper();
    try {
      Person person = om.readValue(new File("person.json"), Person.class);
      System.out.println("Person : " + person);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
