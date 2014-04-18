package quest7;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

//----------------------------------------------------- 

public class WordCount {


	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		@SuppressWarnings("deprecation")
		Job job = new Job(conf, "wordcount");				
		
		/*------------ FIRST JOB -----------------*/
		job.setMapperClass(Map.class);
		//job.setCombinerClass(Combiner.class);
		job.setReducerClass(Reduce.class);
		job.setJarByClass(WordCount.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);		
		
		job.setMapOutputKeyClass(TextPair.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		//job.setOutputFormatClass(SequenceFileOutputFormat.class);		

		FileInputFormat.addInputPath(job, new Path(args[0]));				
		SequenceFileOutputFormat.setOutputPath(job, new Path(args[2]));
		
		job.waitForCompletion(true);
		
		/*------------ SECOND JOB -----------------*/
		if(job.isSuccessful()){
		  	Job job2 = new Job(conf, "classement");
			job2.setMapperClass(Map2.class);
			job2.setReducerClass(Reduce2.class);
			
			job2.setOutputKeyClass(Text.class);
			job2.setOutputValueClass(WordsList.class);
			job2.setJarByClass(WordCount.class);
			
			job2.setMapOutputKeyClass(Text.class);
			job2.setMapOutputValueClass(WordFreq.class);

			job2.setInputFormatClass(TextInputFormat.class);		
			job2.setOutputFormatClass(TextOutputFormat.class);
			
			FileInputFormat.addInputPath(job2, new Path(args[2]+"/part-r-00000"));
			FileOutputFormat.setOutputPath(job2, new Path(args[1]));
			
			job2.waitForCompletion(true);	
		}
		
	}

}