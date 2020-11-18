package academy.learnprogramming.guessthenumbergame;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberGeneratorImpl implements NumberGenerator {
	
	private final Random random = new Random();
	
	@Autowired
	private int maxNumber;

	@Override
	public int next() {
		return random.nextInt(maxNumber);
	}

	@Override
	public int getMaxNumber() {
		return maxNumber;
	}

}
