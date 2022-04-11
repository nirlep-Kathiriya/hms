package com.hms;

import java.util.Properties;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration 
{
	@Value("${db.driver}")
	private String driver;

	@Value("${db.password}")
	private String password;

	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String userName;

	@Value("${hibernate.dialect}")
	private String dialect;

	@Value("${hibernate.show_sql}")
	private String showSql;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;

	@Value("${entitymanager.packagesToScan}")
	private String packagesToScan;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	
		sessionFactory.setDataSource(dataSource());
		
		sessionFactory.setPackagesToScan(packagesToScan);	//only map classes that include @Entity annotation
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", dialect);
		hibernateProperties.put("hibernate.show_sql", showSql);
		hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		
		sessionFactory.setHibernateProperties(hibernateProperties);

		
		return sessionFactory;
	}

	@Bean					//ensure transaction's acid properties(like rollback) In hibernate we manage transaction in DAO layer to manage transaction in controller is not possible(controller do only request and response)
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}	
	
	//all data from controller pass into service layer and service layer perform some operation and then transfer data to DAO layer.
	//DAO manage only database
	//Service layer manage transaction so perform this in service layer we make hibernatetransactionmanager bean(no use extra logic) so 
	//we can use @Transactional annotation and file which inclue this annotation is capable to handle transaction.
}
