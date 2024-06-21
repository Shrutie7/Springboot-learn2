package com.shruticodes.tutorial.configuration;
import com.shruticodes.tutorial.DB;
import com.shruticodes.tutorial.DevDB;
import com.shruticodes.tutorial.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode",havingValue = "production")
    public DB getProdDBBean(){
        return new ProdDB();
    }
    @Bean
    @ConditionalOnProperty(name = "project.mode",havingValue = "development")
    public DB getDevDBBean(){
        return new DevDB();
    }


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
