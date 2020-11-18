package academy.learnprogramming.guessthenumbergame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="academy.learnprogramming.guessthenumbergame")
public class GameConfig {
	
	private int maxNumber = 100;
	
	private int guessCount = 10;
	
	@Bean
	public int maxNumber() {
		return maxNumber;
	}
	
	@Bean
	public int guessCount() {
		return guessCount;
	}

}
