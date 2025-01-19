package org.kd4.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class num7_convertJsonArrayToArrayNode {
  public static void main(String[] args) {
    try {
      String jsonArray = "["
          + "{\"name\":\"deepak\",\"age\":20},"
          + "{\"name\":\"kumar\",\"age\":30},"
          + "{\"name\":\"yadav\",\"age\":40}"
          + "]";

      ObjectMapper objectMapper = new ObjectMapper();

      JsonNode arrayNode = objectMapper.readTree(jsonArray);

      if(arrayNode.isArray()) {
        for (int i = 0; i < arrayNode.size(); i++) {
          JsonNode jsonNode = arrayNode.get(i);
          System.out.println(i+1 + ". Name : " + jsonNode.get("name").asText());
          System.out.println(i+1 + ". Age : " + jsonNode.get("age").asInt());
          System.out.println();
        }
      }

      System.out.print(
          "----------------------------------------------------------------------------------");
      System.out.println();

      if(arrayNode.isArray()) {
        for(JsonNode jsonNode : arrayNode) {
          System.out.println("Name : " + jsonNode.get("name").asText());
          System.out.println("Age : " + jsonNode.get("age").asInt());
          System.out.println();
        }
      }

    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
