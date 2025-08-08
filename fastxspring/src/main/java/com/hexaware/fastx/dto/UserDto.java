package com.hexaware.fastx.dto;

import com.hexaware.fastx.entity.User.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class UserDto {
	@NotNull(message="Cannot be empty")
	private int userId;
	
	@NotBlank(message="Cannot be empty")
	private String name;
	
	@NotBlank(message="Cannot be empty")
	private String email;
	
	@NotBlank(message="Cannot be empty")
	private String password;

	@NotBlank(message="Cannot be empty")
	@Pattern(regexp="Male|Female|Other", message="Enter a valid option")
	private Gender gender;
	
	@NotBlank(message="Cannot be empty")
	@Pattern(regexp="\\d{10}", message="Enter a valid number")
	private String contactNumber;
	
	@NotBlank(message="Cannot be empty")
	@Size(min=10, max=50)
	private String address;
}
