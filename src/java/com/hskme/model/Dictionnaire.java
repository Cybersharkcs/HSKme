package com.hskme.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.event.EventListenerList;

/**
 * 
 */

/**
 * @author Maxime
 *
 */
public class Dictionnaire {
	
	private List<Caractere> vocab;
	
	public Dictionnaire(){
		this.vocab = new ArrayList<Caractere>();
	}
	
	public List<Caractere> getListVocab(){
		return this.vocab;
	}
	
	public void loadVocab(File file) throws IOException{
		String line = " " ;
		String[] bf = new String[3] ;
		FileReader fr = new FileReader(file) ;
		BufferedReader bfr = new BufferedReader (fr) ;
		while( (line = bfr.readLine()) != null ){
			//System.out.println("DEBUG loadVocab String line: " + line) ;
			bf = line.split(",") ;
			//System.out.println("DEBUG loadVocab String[] bf 0 : " + bf[0] + " 1 : " + bf[1] + " 2 : " + bf[2]) ;
			this.vocab.add(new Caractere(bf[0],bf[1],bf[2]));
		}
		bfr.close();
                Collections.shuffle(vocab);
		//Collections.sort(vocab); //vocab sorted by pinyin
		System.out.println("DEBUG : Dico hsk2 cree, nombre entrees : " + this.getVocabSize()) ;
	}
	
	public void searchVocab(String pinyin){
		Arrays.binarySearch(vocab.toArray(), pinyin);
	}

	public void afficheVocab(){
		Iterator<Caractere> it = vocab.iterator();
		while(it.hasNext()){
			Caractere obj = it.next();
			System.out.println(obj.getPinyin());
		}
	}
	
	public int getVocabSize(){
		return vocab.size() ;
	}
	
	public Caractere getVocabAlea(){
		int i = (int) ( Math.random() * vocab.size() ) ;
		return vocab.get(i) ;
	}

	public Caractere getVocab (int i){
		return vocab.get(i) ;
	}
	
	public void clearVocab(){
		vocab.clear() ;
	}
}
