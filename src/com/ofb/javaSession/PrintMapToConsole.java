package com.ofb.javaSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class PrintMapToConsole {
	final static Logger logger = Logger.getLogger(PrintMapToConsole.class);


	public static void ToConsole(ConcurrentHashMap<String, Integer> map) {


	    	  for (Map.Entry<String, Integer> entry : map.entrySet()) {
	    	      String key = entry.getKey().toString();
	    	      Integer value = entry.getValue();
			logger.info("key, " + key + " value " + value);
		}
	  }
}



	        
