package edu.deakin.sit218.SQLinjectionattack.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.deakin.sit218.SQLinjectionattack.dao.QuestionDAO;
import edu.deakin.sit218.SQLinjectionattack.dao.QuestionDAOImpl;
import edu.deakin.sit218.SQLinjectionattack.entity.Question;


@Controller
@RequestMapping("/question-answer")
public class LecturerController {
	
	@RequestMapping("/processForm")
	public String workout(@Valid @ModelAttribute("question") Question question, BindingResult validationErrors, Model model) {
		if(validationErrors.hasErrors())
			return "question-form";
		
		QuestionDAO dao = new QuestionDAOImpl();
		
		if(!dao.existsQuestion(question)) {
			dao.insertQuestion(question);
		}
		
		question = dao.retrieveQuestion(question);
		model.addAttribute("message", "Question Submitted successfully Area: " + question.getArea());
		dao.updateQuestion(question);

		return "question-answer";
		
	}
}
