/** 
 * SAANVI
 * This source file is part of demo project 
 * Developer : Bharatkumar Patel (bharat_4u81@yahoo.co.in)
 * Date : 6 Nov 2014  : 12:10:35
 **/
package com.saanvi.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * @author Bharatkumar Patel
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.saanvi.entity", "com.saanvi.repository", "com.saanvi.service"})
@EnableJpaRepositories("com.saanvi.repository")
@PropertySource("classpath:application.properties")
public class JPAConfig {
	
	
	private static String DATABASE_DRIVER = "db.driver";
	private static String DATABASE_USERNAME = "db.username";
	private static String DATABASE_PASSWORD = "db.password";
	private static String DATABASE_URL = "db.url";

	@Resource
	private Environment environment;
	
	@Bean(name = "dataSource")
    public DataSource dataSource() {
       
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty(DATABASE_DRIVER));
		dataSource.setJdbcUrl(environment.getRequiredProperty(DATABASE_URL));
		dataSource.setUsername(environment.getRequiredProperty(DATABASE_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));
		return dataSource;
		
		
    }
 
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[] { "com.saanvi" });
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        return factoryBean;
    }
 
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }
 
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
 
    @Bean
    public DozerBeanMapper getMapper() {
        return new DozerBeanMapper();
    }
	
}
