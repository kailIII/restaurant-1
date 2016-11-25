package com.caramel.restaurant.security;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan(value="com.caramel.restaurant.security")
public class SecurityConfig
				extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().  //login configuration
                loginPage("/login").
                loginProcessingUrl("/applogin").
                usernameParameter("username").
                passwordParameter("password").
                defaultSuccessUrl("/secure/admin")	
        .and().logout()
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login.xhtml?error=logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
        .and().csrf();
		
                
//		and().logout().    //logout configuration
//		logoutUrl("/appLogout"). 
//		logoutSuccessUrl("/customLogin.xhtml");
		
		//uncomment to disable csrf
		//http.csrf().disable();

	} 

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("root").password("123").roles("ADMIN");
		
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(
				"SELECT username, password, enabled FROM users WHERE enabled = true and username = ?;")
		.authoritiesByUsernameQuery(
				"SELECT u.username, auth.authority FROM users u, authorities auth WHERE u.username = auth.username AND u.username = ?;");
	}
	
	@Bean
	public DriverManagerDataSource dataSource() throws SQLException {
	    
	    //postgres
		DriverManagerDataSource driverManagerDataSource1 = new DriverManagerDataSource();
	    driverManagerDataSource1.setDriverClassName("org.postgresql.Driver");
	    driverManagerDataSource1.setUsername("root");
	    driverManagerDataSource1.setPassword("12345");
	    driverManagerDataSource1.setUrl("jdbc:postgresql://192.168.3.19:5432/restaurantdb");
	    
	    //mysql
	    DriverManagerDataSource driverManagerDataSource2 = new DriverManagerDataSource();
	    driverManagerDataSource2.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    driverManagerDataSource2.setUsername("root");
	    driverManagerDataSource2.setPassword("");
	    driverManagerDataSource2.setUrl("jdbc:mysql://localhost:3306/restaurantdb?serverTimezone=UTC");
	    
	    return driverManagerDataSource2;
	}
	
	//query for postgresql
//	    CREATE TABLE users
//	    (
//	      username character varying(50) NOT NULL,
//	      "password" character varying(50) NOT NULL,
//	      enabled boolean NOT NULL,
//	      CONSTRAINT users_pkey PRIMARY KEY (username)
//	    );
//	    CREATE TABLE authorities
//	    (
//	      username character varying(50) NOT NULL,
//	      authority character varying(50) NOT NULL,
//	      CONSTRAINT fk_authorities_users FOREIGN KEY (username)
//	          REFERENCES users (username) MATCH SIMPLE
//	          ON UPDATE NO ACTION ON DELETE NO ACTION
//	    );
	
	//query for mysql
//	    create table users(
//	    		username varchar(50) not null primary key,
//	    		password varchar(50) not null,
//	    		enabled boolean not null
//	    	) ENGINE=INNODB;
//	    CREATE TABLE authorities
//	    (
//	      username varchar(50) NOT NULL,
//	      authority varchar(50) NOT NULL,
//	      CONSTRAINT fk_authorities_users FOREIGN KEY (username)
//	          REFERENCES users (username) MATCH SIMPLE
//	          ON UPDATE NO ACTION ON DELETE NO ACTION
//	    ) ENGINE=INNODB;
	
	//for both
	//INSERT INTO users(username,password,enabled) VALUES ("root","123", true);
	//INSERT INTO authorities(username,authority) VALUES ("root", "ROLE_ADMIN");
	
}