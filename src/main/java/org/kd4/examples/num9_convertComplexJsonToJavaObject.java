package org.kd4.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.kd4.model.Staff;

public class num9_convertComplexJsonToJavaObject {

  public static void main(String[] args) {
    ObjectMapper om = new ObjectMapper();

    try {
      Staff staff = om.readValue(new File("compactPrint.json"), Staff.class);
      System.out.println(staff);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      Staff staff = om.readValue(new File("prettyPrint.json"), Staff.class);
      System.out.println(staff);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    String jsonStaff = "{\"name\":\"Kumar\",\"age\":24,\"skills\":[\"java\",\"go\",\"c++\"],\"active\":true}";
    try {
      Staff staff = om.readValue(jsonStaff, Staff.class);
      System.out.println(staff);
      System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(staff));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
