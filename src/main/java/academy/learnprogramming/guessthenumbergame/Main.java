package academy.learnprogramming.guessthenumbergame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import academy.learnprogramming.guessthenumbergame.config.GameConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		log.info("Guess The Number Game");
		
		SpringApplication.run(Main.class, args);
	}

}
