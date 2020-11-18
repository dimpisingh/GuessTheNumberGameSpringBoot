package academy.learnprogramming.guessthenumbergame;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {
	
	@Getter(AccessLevel.NONE)
	private final NumberGenerator numberGenerator;
	
	
	private final int guessCount;
	
	@Autowired
	public GameImpl(NumberGenerator numberGenerator, int guessCount) {
		super();
		this.numberGenerator = numberGenerator;
		this.guessCount = guessCount;
	}

	private int number;
	private int guess;
	private int smallest;
	private int largest;
	private int remainingGuesses;
	private boolean validNumberRange = true;
	
	@PostConstruct
	@Override
	public void reset() {
		smallest = 0;
		guess = 0;
		remainingGuesses = guessCount;
		largest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();
		log.debug("the number is = " + number);
	}
	
	@PreDestroy
	public void preDestroy() {
		log.info("in Game preDestroy()");
	}


	@Override
	public void setGuess(int guess) {
		this.guess = guess;
	}

	@Override
	public int getBiggest() {
		return largest;
	}

	@Override
	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	@Override
	public void check() {
		
		checkValidNumberRange();
		
		if(validNumberRange) {
			if(guess > number) {
				largest = guess -1;
			}
			
			if(guess < number) {
				smallest = guess +1;
			}
		}
		
		remainingGuesses--;

	}

	@Override
	public boolean isValidNumberRange() {
		return validNumberRange;
	}

	@Override
	public boolean isGameWon() {
		return guess == number;
	}

	@Override
	public boolean isGameLost() {
		return !isGameWon() && remainingGuesses <= 0;
	}
	
	private void checkValidNumberRange() {
		validNumberRange = (guess >= smallest) && (guess <= largest);
	}

}
