package org.hadoop.example.login.avg.calc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class LoginReducer extends MapReduceBase implements Reducer<Text, Text, Text, LongWritable> {

	@Override
	public void reduce(Text arg0, Iterator<Text> arg1,
			OutputCollector<Text, LongWritable> arg2, Reporter arg3) throws IOException {

		Map<Long,UserData> userLogin=new HashMap<Long, UserData>();

		long totalLoginTime=0l;

		while(arg1.hasNext())
		{
			String[] data=arg1.next().toString().split("<marker>");			
			long sessionId=Long.valueOf(data[1]);
			long timestamp=Long.valueOf(data[0]);
			String event=data[2];
			
			System.out.println("Reducer lines "+arg0+"-"+timestamp+" "+sessionId+" "+event);

			UserData value=userLogin.get(sessionId);
			if(value==null){

				UserData userData=new UserData();
				if(event.equalsIgnoreCase("login"))
				{
					userData.setLoginTime(timestamp);
				}
				else
					userData.setLogOutTime(timestamp);

				userLogin.put(sessionId, userData);
			}
			else{
				if(event.equalsIgnoreCase("login"))
				{
					value.setLoginTime(timestamp);
				}
				else
					value.setLogOutTime(timestamp);

				userLogin.put(sessionId, value);
			}			
			
			

		}

		for(Entry<Long, UserData> e:userLogin.entrySet())
		{
			System.out.println("Test sessionId "+e.getKey());
			System.out.println("Test login "+e.getValue().getLoginTime());
			System.out.println("Test logout "+e.getValue().getLogOutTime());
		}


		for(UserData d:userLogin.values())
		{
			totalLoginTime+=d.getLogOutTime()-d.getLoginTime();
			
			System.out.println("totalLoginTime "+totalLoginTime);
		}


		long avgTimeLogin=	totalLoginTime/userLogin.size();
		arg2.collect(new Text(arg0),new  LongWritable(avgTimeLogin/ 1000));


	}

}
