package com.wccwin.doc.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@RefreshScope
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean("wordDataSource")
    @Qualifier("wordDataSource")
    @ConfigurationProperties("spring.datasource.word")
    public DataSource wordDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("docDataSource")
    @Qualifier("docDataSource")
    @ConfigurationProperties("spring.datasource.doc")
    public DataSource docDataSource(){
        return DataSourceBuilder.create().build();
    }


}
