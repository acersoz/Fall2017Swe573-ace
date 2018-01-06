package com.bookstore.datalayer.config;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.bookstore" })
@ComponentScan({"com.bookstore" })
public class RepositorySpringConfiguration extends WebMvcConfigurerAdapter {

//	@Autowired
//    private Environment env;

	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
       
//        user name:  b751ec1ce23d32
//        password:  35be6493
//        domain:  us-cdbr-iron-east-05.cleardb.net
//        database name: heroku_9fccd1b9bcb04b3
        
        // Remote icin database ayarları
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //Db ismi de�i�tir!
        dataSource.setUrl("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net:3306/heroku_9fccd1b9bcb04b3");
        dataSource.setUsername("b751ec1ce23d32");
        //Password de�i�tir!
        dataSource.setPassword("35be6493");
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException {
       
    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
       
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.bookstore");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
	
}

/*package com.bookstore.datalayer.config;

public class RepositorySpringConfiguration {

}*/
