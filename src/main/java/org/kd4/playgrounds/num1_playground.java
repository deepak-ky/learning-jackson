package org.kd4.playgrounds;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class num1_playground {

  public static void main(String[] args) {

    try {
      String json = "{\"name\":\"mkyong\",\"age\":20}";
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode node = objectMapper.readTree(json);
      System.out.println("Name : " + node.get("name").toString());
      System.out.println("Name : " + node.get("name").asText());
      System.out.println("Age : " + node.get("age").asInt());

//      for(JsonNode jsonNode : node) {
//        System.out.println("Name : " + jsonNode.get("name").asText());
//        System.out.println("Age : " + jsonNode.get("age").asInt());
//        System.out.println();
//      }
//
//      for (int i = 0; i < node.size(); i++) {
//        JsonNode jsonNode = node.get(i);
//        System.out.println(i+1 + ". Name : " + jsonNode.get("name").asText());
//        System.out.println(i+1 + ". Age : " + jsonNode.get("age").asInt());
//        System.out.println();
//      }
//
     System.out.println(node.get(0));

    } catch (JsonProcessingException e ) {
      throw new RuntimeException(e);
    }


  }
}
