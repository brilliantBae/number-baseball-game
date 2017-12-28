package com.example.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import question.Question;

@Controller
public class QuestionController {
	List<Question> questions = new ArrayList<>();
	@GetMapping("/qna")
	public String show() {
		return "qna/form";
	}
	@GetMapping("/")
	public String showQuestions(Model model) {
		model.addAttribute("questions", questions);
		return "index";
	}
	@PostMapping("/questions")
	public String ask(Question question) {
		questions.add(question);
		return "redirect:/";
	}
	@GetMapping("/qna/{id}")
	public String showDetails(@PathVariable int id, Model model) {
		Question question = questions.get(id);
		model.addAttribute("question", question);
		return "qna/show";
	}
}
