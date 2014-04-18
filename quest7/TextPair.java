package quest7;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements WritableComparable<TextPair> {
	private Text mot_1;
	private Text mot_2;

	public TextPair(String w1, String w2) {

		this.mot_1 = new Text(w1);
		this.mot_2 = new Text(w2);
	}

	public TextPair() {
		this.mot_1 = new Text();
		this.mot_2 = new Text();
	}

	public void setMot1(Text w1) {
		this.mot_1 = w1;
	}

	public void setMot2(Text w2) {
		this.mot_2 = w2;
	}

	public Text getMot1() {
		return this.mot_1;
	}

	public Text getMot2() {
		return this.mot_2;
	}

	public void write(DataOutput out) throws IOException {
		mot_1.write(out);
		mot_2.write(out);
	}

	public void readFields(DataInput in) throws IOException {
		mot_1.readFields(in);
		mot_2.readFields(in);
	}

	public int compareTo(TextPair o) {
		int value = this.mot_1.compareTo(o.mot_1);
		if (value != 0) {
			return value;
		}
		return this.mot_2.compareTo(o.mot_2);
	}
	
	public String toString(){
		return this.mot_1+"\t"+this.mot_2;
	}
}