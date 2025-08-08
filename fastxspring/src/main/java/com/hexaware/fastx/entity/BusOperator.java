package com.hexaware.fastx.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Operator")
@Data
@NoArgsConstructor

public class BusOperator {
	@Id
	private int operatorId;
	private String name;
	private String email;
	private String password;
	private String contactNumber;
	private String address;

}
