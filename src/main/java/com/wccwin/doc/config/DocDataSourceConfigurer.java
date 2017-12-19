package com.wccwin.doc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="docEntityManagerFactory",
        transactionManagerRef="docTransactionManager",
        basePackages= { "com.wccwin.doc" }) //设置Repository所在位置
public class DocDataSourceConfigurer {

    @Autowired
    private JpaProperties jpaProperties;


    @Autowired
    @Qualifier("docDataSource")
    private DataSource docDataSource;


    @Bean(name = "docEntityManagerFactoryBean")
    //@Primary
    public LocalContainerEntityManagerFactoryBean docEntityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(docDataSource)
                .properties(getVendorProperties(docDataSource))
                .packages("com.wccwin.doc") //设置实体类所在位置
                .persistenceUnit("docPersistenceUnit")
                .build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }


    @Bean(name = "docEntityManagerFactory")
    @Primary
    public EntityManagerFactory docEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return this.docEntityManagerFactoryBean(builder).getObject();
    }


    @Bean(name = "docTransactionManager")
    @Primary
    public PlatformTransactionManager writeTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(docEntityManagerFactory(builder));
    }
}
