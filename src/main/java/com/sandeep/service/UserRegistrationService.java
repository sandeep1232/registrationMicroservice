package com.sandeep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.entity.UserEntity;
import com.sandeep.repository.UserRepository;

@Service
public class UserRegistrationService {
	@Autowired
	private UserRepository userRepo;
	
	public UserEntity registerUser(UserEntity userEntity) {
		return userRepo.save(userEntity);
	}
	
	public List<UserEntity> getAllUser() {
		return userRepo.findAll();
	}
	
	public UserEntity getUserByUserId(long id) {
		Optional<UserEntity> optional = userRepo.findById(id);
		UserEntity user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException("User Not Found For ID ::" + id);
		}
		
		return user;
	}
	
	public void deleteUserById(long id) {
		this.userRepo.deleteById(id);
	}
}
