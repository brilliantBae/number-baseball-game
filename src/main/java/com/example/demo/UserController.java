package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import user.User;

@Controller
public class UserController {
	List<User> users = new ArrayList<>();
	@GetMapping("/users")
	public String choose() {
		return "users/index";
	}
	@GetMapping("/users/signUp")
	public String write() {
		return "users/form";
	}
	@PostMapping("/users/create")
	public String create(User user) {
		users.add(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users/list")
	public String showList(Model model) {
		model.addAttribute("users", users);
		return "users/userList";
	}
	
	@GetMapping("/users/{userId}")
	public String showProfile(@PathVariable String userId, Model model) {
		for(User user : users) {
			if(user.getUserId().equals(userId)) {
				model.addAttribute("user", user);
			}
		}
		return "users/profile";
	}
	
}
