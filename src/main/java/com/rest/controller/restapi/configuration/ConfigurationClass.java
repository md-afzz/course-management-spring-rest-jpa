/*
 * package com.rest.controller.restapi.configuration;
 * 
 * import java.util.Properties;
 * 
 * import org.hibernate.SessionFactory; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.Scope; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.orm.hibernate5.HibernateTemplate; import
 * org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
 * 
 * import com.rest.controller.restapi.entity.Course;
 * 
 * @Configuration
 * 
 * @Scope("singleton")
 * 
 * @ComponentScan(basePackages = "com.rest.controller.restapi.") public class
 * ConfigurationClass {
 * 
 * @Bean public org.springframework.jdbc.datasource.DriverManagerDataSource
 * getDataSource(){ Properties prop=new Properties();
 * prop.setProperty("username", "root"); prop.setProperty("password",
 * "MDafjal22#"); prop.setProperty("driverClassName",
 * "com.mysql.cj.jdbc.Driver"); prop.setProperty("url",
 * "jdbc:mysql://localhost:3306/mdafjaldb"); // return new
 * DriverManagerDataSource("jdbc:mysql://localhost:3306/mdafjaldb", "root",
 * "MDafjal22#"); return new DriverManagerDataSource(prop.getProperty("url"),
 * prop); }
 * 
 * 
 * @Bean public SessionFactory getSessionFactory() { Properties prop=new
 * Properties(); prop.setProperty("hibernate.dialect",
 * "org.hibernate.dialect.MySQL8Dialect");
 * prop.setProperty("hibernate.show_sql", "true");
 * prop.setProperty("hibernate.hbm2ddl.auto","update");
 * 
 * return new
 * LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Course.class)
 * .addProperties(prop) .buildSessionFactory(); }
 * 
 * @Bean public HibernateTemplate getHIbernateTemplate() { return new
 * HibernateTemplate(getSessionFactory()); }
 * 
 * }
 */