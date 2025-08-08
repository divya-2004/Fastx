package com.hexaware.fastx.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Admin")
@Data
@NoArgsConstructor
public class Administrator {
	@Id
	private int adminId;
	private String name;
	private String email;
	private String password;
}
