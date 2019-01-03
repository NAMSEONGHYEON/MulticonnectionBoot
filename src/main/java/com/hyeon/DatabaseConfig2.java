package com.hyeon;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@MapperScan(basePackages="com.hyeon.dao2", sqlSessionFactoryRef="SqlSessionFactory2")
@EnableTransactionManagement
public class DatabaseConfig2 {
 
	@Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }
	
    @Bean(name = "SqlSessionFactory2")
    public  SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DataSource dataSource2, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource2);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:com/hyeon/dao2/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean(name = "SqlSessionTemplate2")
    public SqlSessionTemplate sqlSessionTemplate2(SqlSessionFactory sqlSessionFactory2) throws Exception {
      return new SqlSessionTemplate(sqlSessionFactory2);
    }
}