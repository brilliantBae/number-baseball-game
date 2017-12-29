package com.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.User;

@Controller
public class UserController {
	List<User> users = new ArrayList<>();
	@GetMapping("/signUp")
	public String show() {
		return "user/form";
	}
	
	@GetMapping("/users")
	public String showList(Model model) {
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@PostMapping("/user/create")
	public String create(User user) {
		users.add(user);
		return "redirect:/users";
	}
	
	@GetMapping("/user/{userId}")
	public String showProfile(@PathVariable String userId, Model model) {
		for(User user : users) {
			if(user.getUserId().equals(userId)) {
				model.addAttribute("user", user);
			}
		}
		return "user/profile";
	}
	
}
