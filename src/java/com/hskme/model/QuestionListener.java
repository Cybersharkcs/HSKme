package com.hskme.model;

import java.util.EventListener;
import java.util.List;

public interface QuestionListener extends EventListener {
	void listQuestionChange(QuestionEvent q);
	void reponseQuestionChange(String anciennerep, String nouvellerep);
	void nbQuestionChange(int ancienb, int nouvnb);
}