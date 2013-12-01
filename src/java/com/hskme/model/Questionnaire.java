package com.hskme.model;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.EventListenerList;

/**
 * 
 */

/**
 * @author Maxime
 *
 */
public class Questionnaire implements Runnable{

	/**
	 * @param args
	 */
	public List<Question> serie ;
	private final EventListenerList listeners ;
	private boolean state ; //questionnaire en cours ou pas
	private int nbquest;
        private int count;
	public Questionnaire(){
		this.serie = new ArrayList<Question>() ;
		listeners = new EventListenerList();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	public void setQuestion(int nb, Dictionnaire dico, String from, String to){
		List<Question> serieold = this.serie;
		int ancienb = this.nbquest;
		this.nbquest = nb;
		this.state = true ;
                String question="",solution="";
		for (int i =0 ; i<nb ; i++){
                        if(from.equals("caractere")) {
                            question=dico.getVocab(i).getCaractere();
                            if(to.equals("pinyin")) solution=dico.getVocab(i).getPinyin();
                            else if(to.equals("francais")) solution=dico.getVocab(i).getTraduction();
                        } else if(from.equals("pinyin")) {
                            question=dico.getVocab(i).getPinyin();
                            if(to.equals("caractere")) solution=dico.getVocab(i).getCaractere();
                            else if(to.equals("francais")) solution=dico.getVocab(i).getTraduction();
                        } else if(from.equals("francais")) {
                            question=dico.getVocab(i).getTraduction();
                            if(to.equals("caractere")) solution=dico.getVocab(i).getCaractere();
                            else if(to.equals("pinyin")) solution=dico.getVocab(i).getPinyin();
                        }
			this.serie.add(new Question(question, solution));
		}
		QuestionEvent q = new QuestionEvent(serieold,this.serie);
		System.out.println("DEBUG : Questionnaire rempli, nombre questions : " + this.serie.size()) ;
		
		fireListQuestionChange(q);
		fireNbQuestionChange(ancienb, this.nbquest);
	}
        
    public QuestionListener[] getQuestionListeners() {
        return listeners.getListeners(QuestionListener.class);
    }

	public Question getQuestion(int i){
			return serie.get(i);
		}
        
    public List<Question> getSerie() {
        return serie;
    }
	
	public String getSolution(int i){
		return serie.get(i).getSolution() ;
	}

	public void setSolution(int i, String solution){
		serie.get(i).setSolution(solution) ;
	}

	public String getReponse(int i){
		return serie.get(i).getReponse() ;
	}

	public void setReponse(int i, String reponse){
		String reponseold = this.serie.get(i).getReponse();
		//on verifie si la reponse est bonne ou pas
		serie.get(i).setReponse(reponse) ;
		if ( serie.get(i).getReponse().equals(serie.get(i).getSolution()) ){
			serie.get(i).setValid(true) ;
		} else serie.get(i).setValid(false);
		
		fireReponseQuestionChange(reponseold,serie.get(i).getReponse());
	}
	
    public void addQuestionListener(QuestionListener listener) {
        listeners.add(QuestionListener.class, listener);
    }
 
    public void removeQuestionListener(QuestionListener listener) {
        listeners.remove(QuestionListener.class, listener);
    }
	
	private void fireReponseQuestionChange(String reponseold, String reponse) {
		// TODO Auto-generated method stub
        for(QuestionListener listener : getQuestionListeners()) {
            listener.reponseQuestionChange(reponseold, reponse);
        }		
	}
	
	private void fireNbQuestionChange(int ancienb, int nouvnb) {
		// TODO Auto-generated method stub
        for(QuestionListener listener : getQuestionListeners()) {
            listener.nbQuestionChange(ancienb, nouvnb);
        }
	}

	private void fireListQuestionChange(QuestionEvent q) {
		// TODO Auto-generated method stub
        for(QuestionListener listener : getQuestionListeners()) {
            listener.listQuestionChange(q);
        }
	}

	public void clearSerie(){
		serie.clear() ;
	}

	public String askQuestion(int i){
		try {
			return serie.get(i).getQuestion();
		}catch (IndexOutOfBoundsException e) { return null ; }
	}	
}
