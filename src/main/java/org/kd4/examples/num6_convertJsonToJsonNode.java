package org.kd4.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class num6_convertJsonToJsonNode {

  public static void main(String[] args) {
    try {
      String json = "{\"name\":\"mkyong\",\"age\":20}";
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode node = objectMapper.readTree(json);
      System.out.println("Name : " + node.get("name").toString());
      System.out.println("Name : " + node.get("name").asText());
      System.out.println("Age : " + node.get("age").asInt());
    } catch (JsonProcessingException e ) {
      throw new RuntimeException(e);
    }
  }
}
