package com.y3wegy.web.provider.config.database.helper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.y3wegy.web.provider.config.prop.MyBatisProp;

/**
 * @author y3wegy
 */
public class MyBatiesConfigHelper {

    public static SqlSessionFactory config(SqlSessionFactoryBean sqlSessionFactoryBean, MyBatisProp myBatisProp) throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResources(myBatisProp.getConfigLocation())[0]);
        sqlSessionFactoryBean.setTypeAliasesPackage(myBatisProp.getTypeAliasesPackage());
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(myBatisProp.getMapperLocations()));
        return sqlSessionFactoryBean.getObject();
    }
}
