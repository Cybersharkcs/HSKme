package com.hskme.model;

import java.util.List;

public class QuestionEvent {
	
	private List<Question> ancien;
	private List<Question> nouv;
	public QuestionEvent(List<Question> ancien, List<Question> nouv){
		this.setAncien(ancien);
		this.setNouv(nouv);
	}
	public List<Question> getAncien() {
		return ancien;
	}
	public void setAncien(List<Question> ancien) {
		this.ancien = ancien;
	}
	public List<Question> getNouv() {
		return nouv;
	}
	public void setNouv(List<Question> nouv) {
		this.nouv = nouv;
	}
	
}