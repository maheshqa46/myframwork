package com.tmb.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constant.FrameworkConstants;
import com.tmb.enums.ConfigProperties;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
 
public final class PropertyUtils {
	
	private PropertyUtils()
	{
		
	}
	
	private static Properties property = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap<String,String>();
	
	
	static {
		try {
			
		FileInputStream  fil = new FileInputStream (FrameworkConstants.getConfigFilePath());
		property.load(fil);
		
		//System.out.println(property.entrySet());
		for(Map.Entry<Object, Object> entry : property.entrySet())
		{
			CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
		}
		
		//Alternnative approach
		//property.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static String get(ConfigProperties key) throws Exception {
		//Objects.isNull(key) && Objects.isNull(CONFIGMAP.get(key))  this will work
		//Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new Exception("property name " + key  + " is not found in config.properties");
		}
		//System.out.println("I am in get value "+ CONFIGMAP.get(ConfigProperties.URL));
		return CONFIGMAP.get(key.name().toLowerCase());
	}
	
	  public static String getValue(String key) throws Exception {
	  
	  if(Objects.isNull(property.getProperty(key))|| Objects.isNull(key)) { throw
	  new Exception("property name " + key + " is not found in config.properties");
	  } return property.getProperty(key);
	  
	  
	  
	  }
	 
	
}
