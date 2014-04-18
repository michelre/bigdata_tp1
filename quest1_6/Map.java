package quest1_6;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, TextPair, IntWritable> 
{
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();
	private TextPair wordPair = new TextPair();
	
	static enum RequestsNature {REQUETE_LONGUE}; 

	// -----------------------------------------------------
	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		String[] requete = value.toString().split("\t")[1].split("\\s");
		Arrays.sort(requete);

		while (tokenizer.hasMoreTokens()) {				
			word.set(tokenizer.nextToken());
			context.write(wordPair, one);
		}
		int i, j = 0;
		for (i = 0; i < requete.length; i++) {
			for (j = i + 1; j < requete.length; j++) {
				context.write(new TextPair(requete[i], requete[j]),
						new IntWritable(1));
			}
		}
		
		//Gestion du compteur REQUETE_LONGUE
		if(requete.length >= 4){
			context.getCounter(RequestsNature.REQUETE_LONGUE).increment(1);
		}
	}
}