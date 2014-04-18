package quest7;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class WordFreq implements WritableComparable<WordFreq>{
	
	private Text word;
	private IntWritable frequency;
	
	public WordFreq(){
		this.word = new Text();
		this.frequency = new IntWritable();
	}
	
	public WordFreq(String w, int f){
		this.word = new Text(w);
		this.frequency = new IntWritable(f);
	}
	
	public WordFreq(String w, IntWritable f){
		this.word = new Text(w);
		this.frequency = f;
	}
	
	public WordFreq(Text w, IntWritable f){
		this.word = w;
		this.frequency = f;
	}
	
	public Text getWord(){
		return this.word;	
	}
	
	public IntWritable getFrequency(){
		return this.frequency;
	}
	
	public void setWord(Text w){
		this.word = w;
	}
	
	public void setFrequency(IntWritable f){
		this.frequency = f;
	}
	
	public String toString(){
		return this.word.toString()+"["+this.frequency.get()+"]";
	}
	
	@Override
	public int compareTo(WordFreq w){
		return (w.getFrequency().get() == this.frequency.get()) ? 0 : ((w.getFrequency().get() < this.frequency.get()) ? -1 : 1 );
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.word.readFields(in);
		this.frequency.readFields(in);		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		this.word.write(out);
		this.frequency.write(out);		
	}
	

}
