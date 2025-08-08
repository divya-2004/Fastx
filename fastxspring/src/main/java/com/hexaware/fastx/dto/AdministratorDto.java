package com.hexaware.fastx.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class AdministratorDto {
	
	@NotNull
	private int adminId;
	
	@NotBlank(message="Name cannot be empty")
	@Size(min=3, max=20)
	private String name;
	
	@NotBlank(message="Email cannot be empty")
	@Email
	private String email;
	
	@NotBlank(message="Password cannot be empty")
	@Size(min=8, max=20)
	private String password;
}
