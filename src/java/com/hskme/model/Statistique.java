/**
 * 
 */
package com.hskme.model;

/**
 * @author Maxime
 *
 */

public class Statistique implements Runnable {
	
	Questionnaire q ;
	boolean state ;
	private float nbbonnereponses, percmauvrep, percbonrep, nbmauvreponses, nbtotalquest ;
	public Statistique(Questionnaire q){
		this.setNbtotalquest(q.serie.size()) ;
		this.q = q ;
		this.state = true ;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(state){
			try{
				this.nbbonnereponses = calculNbBonneReponses() ;
				this.setPercmauvrep(calculPercentageMauvReponses());
				this.setPercbonrep(calculPercentageBonReponses());
				this.nbmauvreponses = calculNbMauvReponses();
				Thread.sleep(10*1000); //every ten sec stats are updated
			} catch (InterruptedException ex) { }
		}
	}
	
	private float calculNbBonneReponses(){
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

	private float calculPercentageBonReponses(){ 
		if ( getNbtotalquest() != 0 ) setPercbonrep((nbbonnereponses/getNbtotalquest())*100) ;
		return (getPercbonrep()) ;
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
