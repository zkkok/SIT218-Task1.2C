package edu.deakin.sit218.SQLinjectionattack.dao;

import edu.deakin.sit218.SQLinjectionattack.entity.Question;

public interface QuestionDAO {
	
	public void insertQuestion(Question question);
	
	public boolean existsQuestion(Question question);

	public Question retrieveQuestion(Question question);

	public void updateQuestion(Question question);
}
