package org.kd4.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.kd4.model.Staff;

public class num8_convertComplexJavaObjectToString {
  public static void main(String[] args) {
    ObjectMapper om = new ObjectMapper();

    Staff staff = createStaff();
    System.out.println(staff.toString());

    // 1. Compact Print
    try {
      om.writeValue(new File("compactPrint.json"), staff);
    } catch (IOException e){
      throw new RuntimeException(e);
    }

    // 2. Pretty Print
    try {
      om.writerWithDefaultPrettyPrinter().writeValue(new File("prettyPrint.json"), staff);
    } catch (IOException e){
      throw new RuntimeException(e);
    }


    // 3. Write as JSON String
    try {
      String jsonStaff = om.writeValueAsString(staff);
      System.out.println("Compact JSON : ");
      System.out.println(jsonStaff);
    } catch (IOException e){
      throw new RuntimeException(e);
    }

    // 4. Write as Pretty JSON String
    try {
      String jsonStaff = om.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
      System.out.println("Pretty JSON : ");
      System.out.println(jsonStaff);
    } catch (IOException e){
      throw new RuntimeException(e);
    }

  }

  static Staff createStaff() {
    Staff staff = new Staff();
    staff.setName("Deepak");
    staff.setAge(24);

    staff.setPosition(new String[]{"Software Developer 2", "Assistant Manager 1"});

    staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

    Map<String, BigDecimal> salary = new HashMap<>();
    salary.put("2010", new BigDecimal(20000));
    salary.put("2012", new BigDecimal(12000));
    salary.put("2018", new BigDecimal(14000));

    staff.setSalary(salary);
    staff.setActive(true);
    return staff;
  }
}

