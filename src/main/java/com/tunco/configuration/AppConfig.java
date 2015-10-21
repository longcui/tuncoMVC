package com.tunco.configuration;

import com.tunco.configuration.hibernate.HibernateConfiguration;
import com.tunco.configuration.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.tunco" })
@PropertySource(value = {"classpath:application.properties"})
@Import({ SecurityConfig.class, HibernateConfiguration.class })
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

//	@Bean(name = "dataSource")
//    public DriverManagerDataSource dataSource() {
//	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test");
//	    driverManagerDataSource.setUsername("root");
//	    driverManagerDataSource.setPassword("password");
//	    return driverManagerDataSource;
//	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}