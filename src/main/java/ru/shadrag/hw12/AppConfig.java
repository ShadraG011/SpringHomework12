package ru.shadrag.hw12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.shadrag.hw12.domain.MyTaskFactory;

@Configuration
public class AppConfig {
    @Bean
    public MyTaskFactory productFactory(){
        return new MyTaskFactory();
    }
}
