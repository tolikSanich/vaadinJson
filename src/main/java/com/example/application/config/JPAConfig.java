package com.example.application.config;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        value = {
                "com.example.application"
        },
        repositoryBaseClass = BaseJpaRepositoryImpl.class
)
public class JPAConfig {
}
