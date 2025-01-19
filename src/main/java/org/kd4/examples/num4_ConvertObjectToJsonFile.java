package org.kd4.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.kd4.model.Person;

public class num4_ConvertObjectToJsonFile {
  public static void main(String[] args) {
    Person person = new Person("deepak-kumar", 24);
    System.out.println(person);

    ObjectMapper om = new ObjectMapper();
    try {
      om.writeValue(new File("person.json"), person);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
