package com.hexaware.fastx.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
	@Id
	private int userId;
	private String name;
	private String email;
	private String password;
	private Gender gender;
	private String contactNumber;
	private String role = "User";
	public enum Gender{
		Male, Female, Other;
		public static Gender fromString(String gender) {
            for (Gender g : Gender.values()) {
                if (g.name().equalsIgnoreCase(gender)) {
                    return g;
                }
            }
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
	}	
}
