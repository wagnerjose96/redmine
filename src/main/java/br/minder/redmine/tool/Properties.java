package br.minder.redmine.tool;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class Properties {

	public static String uriRedmine() {
		return configuration().getString("uriRedmine");
	}
	
	public static String apiAccessKey() {
		return configuration().getString("apiAccessKey");
	}
	
	public static String projectKey() {
		return configuration().getString("projectKey");
	}

	private static CompositeConfiguration configuration() {
		CompositeConfiguration config = new CompositeConfiguration();
		try {
			config.addConfiguration(new SystemConfiguration());
			config.addConfiguration(new PropertiesConfiguration("application.properties"));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return config;
	}

}
