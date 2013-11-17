package com.hskme.model;
/**
 * 
 */

/**
 * @author Maxime
 *
 */
public class Caractere implements Comparable<Caractere>{

	/**
	 * 
	 */
	private String traduction;
	private String pinyin;
	private String caractere;
	
	public Caractere(String caractere, String pinyin, String traduction) {
		// TODO Auto-generated constructor stub
		this.caractere = caractere;
		this.pinyin = pinyin;
		this.traduction = traduction;
	}

	/**
	 * @return the traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/**
	 * @param traduction the traduction to set
	 */
	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	/**
	 * @return the pinyin
	 */
	public String getPinyin() {
		return pinyin;
	}

	/**
	 * @param pinyin the pinyin to set
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	/**
	 * @return the caractere
	 */
	public String getCaractere() {
		return caractere;
	}

	/**
	 * @param caractere the caractere to set
	 */
	public void setCaractere(String caractere) {
		this.caractere = caractere;
	}

	@Override
	public int compareTo(Caractere c) {
		// TODO Auto-generated method stub
		return pinyin.compareTo(c.pinyin);
	}

}
