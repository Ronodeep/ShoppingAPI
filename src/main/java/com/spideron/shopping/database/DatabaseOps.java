package com.spideron.shopping.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.spideron.shopping.constant.EnvironmentConstants;

public class DatabaseOps {
	public static Connection dbConnection=null;
	
	public Connection getConnection() {
		final String connectionPrefix="jdbc:mysql://";
		try {
			Properties properties = readProperties(EnvironmentConstants.DB_CONFIG_FILE);
			if(properties!=null) {
				String  dbHost= properties.getProperty(EnvironmentConstants.DB_HOST);
				String  dbName= properties.getProperty(EnvironmentConstants.DB_NAME);
				String  dbPort= properties.getProperty(EnvironmentConstants.DB_PORT);
				String dbUser = properties.getProperty(EnvironmentConstants.DB_USER);
				String dbPassword = properties.getProperty(EnvironmentConstants.DB_PASSWORD);
				
				final String connectionDBUrl=connectionPrefix+dbHost+":"+dbPort+"/"+dbName;
				System.out.println("Connection URL:"+ connectionDBUrl);
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConnection=DriverManager.getConnection(connectionDBUrl,dbUser,dbPassword);
				System.out.println("Connection Established");
			}
			else {
				System.out.println("Error while loading properties file");
			}
			
		} catch (IOException | SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return dbConnection;
	}
	public void closeDBConnection(Connection connection) throws SQLException {
		if(connection!=null) {
			connection.close();
		}
	}
	private  Properties readProperties(String fileName) throws IOException {
		
		System.out.println("File Name:"+fileName);
		ClassLoader classLoader = getClass().getClassLoader();
		Properties properties=null;
		InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);
		if(resourceAsStream!=null) {
			properties= new Properties();
			properties.load(resourceAsStream);
			
		}
		return properties;
	}
}
