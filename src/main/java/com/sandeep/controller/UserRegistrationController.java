package com.sandeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sandeep.entity.UserEntity;
import com.sandeep.service.UserRegistrationService;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userService;
	
	@GetMapping("/allUser")
	public String getAllUser(Model model) {
		model.addAttribute("listOfUser", userService.getAllUser());
		return "allUser";
	}
	
	
	@GetMapping("/register")
	public String getRegistrationPage(Model model) {
		UserEntity userEntity = new UserEntity();
		model.addAttribute("user", userEntity);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(UserEntity userEntity, Model model) {
		userService.registerUser(userEntity);
		model.addAttribute("message", "Registration Successful");
		return "registerSuccess";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id, Model model) {
		UserEntity userEntity = userService.getUserByUserId(id);
		model.addAttribute("user", userEntity);
		return "updateUser";
	}
	
	@GetMapping("/showFormForDelete/{id}")
	public String showFormForDelete(@PathVariable(value="id") long id) {
		this.userService.deleteUserById(id);
		return "redirect:/allUser";
	}
	
}
