package quest7;

import java.util.ArrayList;
import java.util.Collections;

public class ListImpl {
	
	private ArrayList<WordFreq> words = new ArrayList<WordFreq>();
	private WordFreq lastFreq = null;
	
	public void addWord(WordFreq w){
		if(this.words.isEmpty()){
			this.words.add(w);
		}else{
			if(this.words.size() == 5){
				if(this.lastFreq.getFrequency().get() < w.getFrequency().get()){
					this.words.remove(4);
					this.words.add(w);					
				}
			}else{
				this.words.add(w);								
			}			
		}
		Collections.sort(this.words);
		this.lastFreq = w;
	}
	
	public WordFreq[] toArray(){
		WordFreq[] w = new WordFreq[5];		
		for(int i = 0; i < this.words.size(); i++){
			w[i] = this.words.get(i);
		}
		return w;
	}

}
