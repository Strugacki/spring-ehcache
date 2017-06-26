package com.pgs.mhallman;

import com.pgs.mhallman.config.AppConfig;
import com.pgs.mhallman.dao.MovieDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class EhchacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhchacheDemoApplication.class, args);
    }

}
