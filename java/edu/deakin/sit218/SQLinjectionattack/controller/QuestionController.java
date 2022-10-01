package edu.deakin.sit218.SQLinjectionattack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.SQLinjectionattack.entity.Question;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		Question question = new Question();
		
		model.addAttribute("question",question);
		return "question-form";
	}
}
