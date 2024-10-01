package com.sandeep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;


@Data
@Entity
@Table(name="user_registration_microservice")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailId;
	private String password;
}
