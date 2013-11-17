package com.hskme.model;

public abstract class QuestionAdapter implements QuestionListener{
	public void listQuestionChange(QuestionEvent q){};
	public void reponseQuestionChange(String anciennerep, String nouvellerep){};
	public void nbQuestionChange(int ancienb, int nouvnb){};
}
