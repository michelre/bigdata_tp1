package quest1_6;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

// -----------------------------------------------------
public class Combiner extends
		Reducer<TextPair, IntWritable, TextPair, IntWritable> {

	public void reduce(TextPair key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable val : values) {
			sum += val.get();
		}
		context.write(key, new IntWritable(sum));
	}
}