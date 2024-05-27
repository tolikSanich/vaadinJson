package com.example.application.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@ToString
@Accessors(fluent = true, chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@Entity(name = "Personal")
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    @Column(length = 6)
    private String personnelNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> personalInfo = new HashMap<>();


    public Personal addPersonalInfo(String key, String value) {
        personalInfo.put(key, value);
        return this;
    }
    public String getPersonalInfo(String key) {
        return  personalInfo.get(key);
    }
    public Personal setTeleponeNumber(String teleponeNumber){
        personalInfo.put("telephone", teleponeNumber);
        return this;
    }
    public Personal setEmail(String email){
        personalInfo.put("email", email);
        return this;
    }
}

//@Data

