package quest7;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map2 extends Mapper<LongWritable, Text, Text, WordFreq> 
{	

	// -----------------------------------------------------
	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] requete = value.toString().split("\t");
		
		context.write(new Text(requete[0]), new WordFreq(requete[1], Integer.parseInt(requete[2])));
		//context.write(new Text(requete[1]), new WordFreq(requete[0], Integer.parseInt(requete[2])));
	}
}