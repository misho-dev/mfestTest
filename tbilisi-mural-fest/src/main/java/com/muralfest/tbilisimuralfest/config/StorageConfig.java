package com.muralfest.tbilisimuralfest.config;

import com.muralfest.tbilisimuralfest.service.StorageService;
import com.muralfest.tbilisimuralfest.service.impl.FileSystemStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageConfig {
    @Bean
    public StorageService storageService(StorageProperties properties) {
        return new FileSystemStorageService(properties);
    }

    @Bean
    public CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
