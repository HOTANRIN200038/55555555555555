package com;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@SuppressWarnings("unused")
public class DBCconfig {
	


	@Bean (name= "dataSource")
			
	public DataSource getH2DataSource() 
	{
			DriverManagerDataSource dataSource  = new 	DriverManagerDataSource();
			
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("");
			dataSource.setUsername("");
			dataSource.setPassword("");
			
			System.out.println("----------DataSource Object is Created-------");
			
			return dataSource;
	}
	
	@Bean(name="sessionFactory")
	
	public SessionFactory getSessionFactory() {
		
		Properties hibernateProp = new Properties();
		
		hibernateProp.put("hibernate.hdm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder LocalFactory = new LocalSessionFactoryBuilder(getH2DataSource());
		LocalFactory.addProperties(hibernateProp);
		
		
		
		
		System.out.println("------SessionFactory Object is Created-----");
		
		return LocalFactory.buildSessionFactory();
	}
	
	
	

}
