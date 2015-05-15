package org.hadoop.example.login.avg.calc;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class DriverLoginAvgCalc {

	public static void main(String[] args) {

		JobConf conf = new JobConf(DriverLoginAvgCalc.class);
		 	     conf.setJobName("LoginAvgCal");
		 	
		 	 
		 	     
		 	     conf.setMapOutputKeyClass(Text.class);
		 	    conf.setMapOutputValueClass(Text.class);
		 	     
		 	    conf.setOutputKeyClass(Text.class);
		 	     conf.setOutputValueClass(LongWritable.class);
		 	
		 	     conf.setMapperClass(LoginMapper.class);
		 	     //conf.setCombinerClass(LoginReducer.class);
		 	     conf.setReducerClass(LoginReducer.class);
		 	
		 	     conf.setInputFormat(TextInputFormat.class);
		 	     conf.setOutputFormat(TextOutputFormat.class);
		 	     //conf.setOutputKeyComparatorClass(MapOutputKeyValuesComparator.class);
		 	    //conf.setOutputValueGroupingComparator(MapOutputKeyValuesComparator.class);
		 	     conf.set("seperator", ",");
		 	
		 	     FileInputFormat.setInputPaths(conf, new Path(args[0]));
		 	     FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		 	
		 	     try {
					JobClient.runJob(conf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
