# 📘 Jackson Serialization (Java ➝ JSON)

---

## 🧠 How Jackson Works (Default Behavior)

- ✅ By default, Jackson only serializes fields with **public getters**.
- ❌ **Private fields** without public getters are ignored, unless explicitly configured.
- ✅ If fields are **public**, getters are **not required**.
- ❌ Fields marked `transient` or `static` are **ignored** during serialization.

---

## ⚙️ Ways to Make Fields Serializable

| Method | Description |
|--------|-------------|
| **Public fields** | Jackson can access them directly |
| **Public getters** | Standard method, used by default |
| `@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)` | Tells Jackson to access all fields, regardless of visibility |
| `@JsonProperty` | Makes private fields accessible and optionally renames them |
| `ObjectMapper.setVisibility(...)` | Global config alternative to annotations |

```java
// Global visibility config alternative (no annotations needed)
ObjectMapper om = new ObjectMapper();
om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
```

---

## 🧪 Example Recap: `num1_ConvertObjectToJson.java`

| Class    | Field Visibility | Public Getters | Annotations Used         | Behavior                        |
|----------|------------------|---------------|-------------------------|----------------------------------|
| Person   | Private          | ✅ Yes        | ❌ None                 | ✅ Fully serialized              |
| Person1  | Public           | ❌ No         | ❌ None                 | ✅ Fully serialized              |
| Person2  | name → Public<br>age → Private | ❌ No | ❌ None | ⚠️ Only `name` serialized         |
| Person3  | Private          | ❌ No         | ❌ None                 | ❌ Exception thrown              |
| Person4  | Private          | ❌ No         | ✅ `@JsonAutoDetect(...)`| ✅ Fully serialized              |
| Person5  | Private          | ❌ No         | ✅ `@JsonProperty`       | ✅ Fully serialized, renamed     |

---

## ✨ Special Notes

- 🔍 `toString()` is only for logging/debugging; it has **no impact** on serialization.
- 🔄 `@JsonProperty("custom_name")` both:
    - Makes private fields visible
    - Allows you to **rename fields** in the JSON
    - **Example:**
      ```java
      @JsonProperty("user_name")
      private String name;
      ```
      **JSON Output:**
      ```json
      { "user_name": "example" }
      ```
- 🧹 To exclude `null` or default values, use:
  ```java
  @JsonInclude(JsonInclude.Include.NON_NULL)
  ```
- ⚠️ **Static and transient fields** are never serialized, even with visibility annotations.
- ⚠️ If Jackson cannot access any fields (all are private, no getters/annotations), it may throw an exception (as with `Person3`).
- ℹ️ **Default constructor** is not required for serialization, but is needed for deserialization.



---

## 📝 Summary

- For serialization, you need **public fields**, **public getters**, or the right **annotation/configuration**.
- If fields are private and have no public getters, use:
    - `@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)`
    - or `@JsonProperty`
    - or configure the `ObjectMapper` globally
- **Static** and **transient** fields are always ignored.
- If Jackson cannot access any fields, serialization will fail with an exception.
