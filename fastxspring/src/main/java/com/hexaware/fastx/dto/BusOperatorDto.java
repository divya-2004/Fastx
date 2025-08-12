package com.hexaware.fastx.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class BusOperatorDto {
	
	private int operatorId;
	
	@NotBlank(message="Name cannot be empty")
	@Size(min=3, max=20)
	private String name;
	
	@NotBlank(message="Email cannot be empty")
	@Email(message="Invalid email format")
	private String email;
	
	@NotBlank(message="Password cannot be empty")
	private String password;
	
	@NotBlank(message="Number cannot be empty")
	@Pattern(regexp="^[0-9]{10}$")
	private String contactNumber;
	
}
