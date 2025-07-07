1. requires defaultconstructor or JsonCreator
2. requires setters, if not present will work with getters, assuming private fields
3. if both not present deserialzition error
4. some notes - need to review

# 📘 Jackson Deserialization (JSON ➝ Java)

Deserialization is the process of converting JSON back into Java objects. Jackson provides flexible options, but it requires some minimal structure in the target Java classes.

---

## 🧠 How Jackson Works (Default Behavior)

- ✅ Jackson looks for:
    - A **default (no-arg) constructor** (required unless overridden)
    - **Public setters** or **fields** to map JSON properties
- ❌ If the class has no default constructor and no way to instantiate the object, deserialization will fail unless:
    - A constructor is annotated with `@JsonCreator`
    - You use custom deserializers

---

## ⚙️ Ways to Enable Deserialization

| Technique                        | When to Use                                                                 |
|-----------------------------------|-----------------------------------------------------------------------------|
| Default no-arg constructor        | Works with setters or public fields (Jackson instantiates and sets fields)  |
| Public fields                     | Jackson can set them directly without setters                               |
| `@JsonCreator` on constructor     | If you want to use a parameterized constructor                              |
| `@JsonProperty` on constructor args | Tells Jackson which JSON property maps to which constructor parameter      |
| `ObjectMapper.setVisibility(...)` | Makes private fields writable globally                                      |

---

### ✅ Example 1 – Default Constructor + Setters

```java
class Person {
  private String name;
  private int age;

  public Person() {} // Required for deserialization

  public void setName(String name) { this.name = name; }
  public void setAge(int age) { this.age = age; }
}
```

---

### ✅ Example 2 – Public Fields

```java
class Person {
  public String name;
  public int age;
}
```

---

### ✅ Example 3 – Constructor with @JsonCreator and @JsonProperty

```java
class Person {
  private final String name;
  private final int age;

  @JsonCreator
  public Person(@JsonProperty("name") String name,
                @JsonProperty("age") int age) {
    this.name = name;
    this.age = age;
  }
}
```
- 🔹 Required when no default constructor is present
- 🔹 Ensures Jackson knows how to map JSON properties to constructor parameters

---

### 🔄 ObjectMapper Configuration Alternative

You can globally configure Jackson to access private fields directly:

```java
ObjectMapper om = new ObjectMapper();
om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
```

---

## ⚠️ Common Errors

| Error                        | Cause                                               | Fix                                                                 |
|------------------------------|----------------------------------------------------|---------------------------------------------------------------------|
| `UnrecognizedPropertyException` | JSON contains a field not present in Java class     | Add matching property, or use `@JsonIgnoreProperties(ignoreUnknown = true)` |
| No suitable constructor      | No default constructor or `@JsonCreator` present   | Add one                                                            |
| `MismatchedInputException`   | JSON structure doesn’t match class fields           | Check JSON and class structure carefully                            |

---

## 🧪 Summary Table

| Requirement                       | Is It Mandatory? | Notes                                         |
|------------------------------------|------------------|-----------------------------------------------|
| Default constructor                | ✅ Yes (unless using `@JsonCreator`) | Required by default                |
| Setters or public fields           | ✅ Yes           | Jackson needs a way to populate fields        |
| `@JsonCreator` with `@JsonProperty`| ✅ Yes (if no default constructor) | Enables constructor-based mapping |
| `ObjectMapper.setVisibility(...)`  | Optional         | Bypasses visibility restrictions              |

---

## ✅ Summary

To deserialize JSON into Java objects, Jackson needs:

- A **default constructor** (unless using `@JsonCreator`)
- **Setters** or **public fields** to populate object data

Or alternatively:

- Use `@JsonCreator` + `@JsonProperty` for constructor-based binding
- Use `ObjectMapper` visibility config for accessing private fields directly


# Suggestions for Improvement

## 1. Clarify Setters vs. Fields

Explicitly state:  
If a class has **neither setters nor public fields**, and you don’t use visibility configuration (like `@JsonAutoDetect` or `ObjectMapper.setVisibility(...)`), **Jackson deserialization will fail** because it has no way to set the values.

**Is this true?**  
✅ **Yes, this is true.**  
Jackson needs either:
- Public setters, or
- Public fields, or
- Visibility configuration to access private fields, or
- A constructor annotated with `@JsonCreator` and parameters annotated with `@JsonProperty`.

If none of these are present, Jackson cannot populate the fields during deserialization.


not true
question

## `**_Why is deserialization working even though there are no setters?🤔_**`

check
---

## 2. Mention Lombok

If your audience uses [Lombok](https://projectlombok.org/), note that:
- `@Data` generates getters, setters, and a no-arg constructor (if used with `@NoArgsConstructor`).
- `@AllArgsConstructor` and `@NoArgsConstructor` generate the required constructors for Jackson.

---

## 3. Note on Immutability

For **immutable objects** (fields marked `final`), always use `@JsonCreator` on the constructor and `@JsonProperty` on each parameter to enable Jackson to map JSON properties to constructor arguments.

---

## 4. Add a Quick Tip on Ignoring Unknown Fields

To ignore unknown JSON fields during deserialization, annotate your class with:

```java
@JsonIgnoreProperties(ignoreUnknown = true)
```
This prevents errors if the JSON contains properties not present in your Java class.

---