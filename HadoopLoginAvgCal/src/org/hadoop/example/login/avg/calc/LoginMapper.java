package org.hadoop.example.login.avg.calc;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class LoginMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {

	String seperator;
	
	@Override
	public void configure(JobConf job) {
		super.configure(job);
		
		seperator=job.get("seperator");
	}

	@Override
	public void map(LongWritable arg0, Text arg1,
			OutputCollector<Text, Text> arg2, Reporter arg3) throws IOException {
		
		System.out.println("Line is "+arg1.toString());
		System.out.println("Seperator "+seperator);
		String[] data=arg1.toString().split(seperator);
		
		String name=data[0];
		System.out.println("0 "+name);
		String timestamp=data[1];
		System.out.println("1 "+timestamp);
		String sessionId=data[2];
		System.out.println("2 "+sessionId);
		String event=data[3];
		System.out.println("3 "+event);
		
		arg2.collect(new Text(name), new Text(timestamp+"<marker>"+sessionId+"<marker>"+event+"<marker>"));
		
	}

}
