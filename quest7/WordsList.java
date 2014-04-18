package quest7;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Writable;


public class WordsList extends ArrayWritable{
		
	public WordsList(Class<? extends Writable> valueClass) {
		super(valueClass);		
	}
	
	public String toString(){
		String s = "";		
		for(WordFreq w : (WordFreq[])this.get()){
			if(w != null)
				s += w.toString()+",";
		}
		return s;
	}
}
