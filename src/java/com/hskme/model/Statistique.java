/**
 * 
 */
package com.hskme.model;

/**
 * @author Maxime
 *
 */

public class Statistique extends Thread {
	
	Questionnaire q ;
	boolean state ;
	private float nbbonnereponses, percmauvrep, percbonrep, nbmauvreponses, nbtotalquest ;
	public Statistique(Questionnaire q){
		this.q = q ;
                this.setNbtotalquest(q.serie.size()) ;
		this.state = true ;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(state){
			try{
				this.nbbonnereponses = calculNbBonneReponses() ;
				this.setPercmauvrep(calculPercentageMauvReponses());
				this.nbmauvreponses = calculNbMauvReponses();
				Thread.sleep(5*100); //every ten sec stats are updated
			} catch (InterruptedException ex) { }
		}
	}
	
	public float calculNbBonneReponses(){
		int result = 0 ;
		for (int i = 0 ; i < getNbtotalquest() ; i++ ) {
			if ( q.serie.get(i).isValid() ) nbbonnereponses = ++result ;
		}
		return nbbonnereponses ;
	}
	
	private float calculNbMauvReponses(){
		int result = 0 ;
		for (int i = 0 ; i < getNbtotalquest() ; i++ ) {
			if ( !q.serie.get(i).isValid() && q.serie.get(i).isAnswered()) nbmauvreponses = ++result ;
		}
		return nbmauvreponses ;
	}
	
	private float calculPercentageMauvReponses(){
		if ( getNbtotalquest() != 0 ) setPercmauvrep((nbmauvreponses/getNbtotalquest())*100) ;
		return (getPercmauvrep()) ;
	}

	public int calculPercentageBonReponses(float nbbonnereponses){ 
		if ( getNbtotalquest() != 0 ) setPercbonrep((nbbonnereponses/getNbtotalquest())*100) ;
		return (int)(getPercbonrep()) ;
	}
	
	/**
	 * @return the nbbonnereponses
	 */
	public float getNbbonnereponses() {
		return nbbonnereponses;
	}

	/**
	 * @param nbbonnereponses the nbbonnereponses to set
	 */
	public void setNbbonnereponses(int nbbonnereponses) {
		this.nbbonnereponses = nbbonnereponses;
	}

	/**
	 * @return the nbmauvreponses
	 */
	public float getNbmauvreponses() {
		return nbmauvreponses;
	}
	
	/**
	 * @param nbmauvreponses the nbmauvreponses to set
	 */
	public void setNbmauvreponses(int nbmauvreponses) {
		this.nbmauvreponses = nbmauvreponses;
	}

	public float getNbtotalquest() {
		return nbtotalquest;
	}

	public void setNbtotalquest(float nbtotalquest) {
		this.nbtotalquest = nbtotalquest;
	}

	public float getPercmauvrep() {
		return percmauvrep;
	}

	public void setPercmauvrep(float percmauvrep) {
		this.percmauvrep = percmauvrep;
	}

	public float getPercbonrep() {
		return percbonrep;
	}

	public void setPercbonrep(float percbonrep) {
		this.percbonrep = percbonrep;
	}
}
