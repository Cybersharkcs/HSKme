package com.hskme.model;

/**
 * @author Maxime
 *	
 */
public class Question {
	
	private String question;
	private String reponse ;
	private String solution ;
	
        private boolean valid ;
	private boolean answered ;
        
	public Question(String question, String reponse, String solution){
		this.question = question;
                this.reponse = reponse;
                this.solution = solution;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}
	
}
