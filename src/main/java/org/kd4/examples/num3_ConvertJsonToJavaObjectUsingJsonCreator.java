package org.kd4.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.kd4.model.Person;
import org.kd4.model.User;

public class num3_ConvertJsonToJavaObjectUsingJsonCreator {

  public static void main(String[] args) {
    String json = "{\"name\":\"kumar\",\"age\":25}";
    ObjectMapper om = new ObjectMapper();
    try {
      User user = om.readValue(json, User.class);
      System.out.println(user);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
