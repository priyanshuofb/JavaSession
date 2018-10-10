package com.ofb.javaSession;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.PropertyConfigurator;

public class MapClass {

	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		PropertyConfigurator
				.configure("/home/ofb-140/workspace/JavaSession/src/config/log4j.properties");
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		Scanner input=new Scanner(System.in);
		String userInput=input.next();

		if (userInput.equals("file")) {
			// PrintMapToFile.ToFile(map);

			Class loadedMyClass = MapClass.class.getClassLoader().loadClass(
					"com.ofb.javaSession.PrintMapToFile");

			Constructor constructor = loadedMyClass.getConstructor();
			Object myClassObject = constructor.newInstance();
			for (Method m : loadedMyClass.getDeclaredMethods()) {
				m.invoke(myClassObject, map);
			}

		}

                    

		else if (userInput.equals("console")) {
			Class loadedMyClass = ClassLoader.getSystemClassLoader().loadClass(
					"com.ofb.javaSession.PrintMapToConsole");
			Constructor constructor = loadedMyClass.getConstructor();
			Object myClassObject = constructor.newInstance();
			for (Method m : loadedMyClass.getDeclaredMethods()) {
				m.invoke(myClassObject, map);


			}
		}

			
			
		}
}



