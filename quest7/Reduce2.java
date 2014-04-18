package quest7;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// ----------------------------------------------------
public class Reduce2 extends
		Reducer<Text, WordFreq, Text, WordsList> {

	public void reduce(Text key, Iterable<WordFreq> values,
			Context context) throws IOException, InterruptedException {
		
		WordsList words = new WordsList(WordFreq.class);
		ListImpl l = new ListImpl();
		for (WordFreq val : values) {
			l.addWord(new WordFreq(val.getWord().toString(), val.getFrequency().get()));			
		}
		words.set(l.toArray());
		context.write(key, words);
		
	}
}