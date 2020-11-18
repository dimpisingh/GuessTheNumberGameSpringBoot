package academy.learnprogramming.guessthenumbergame.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academy.learnprogramming.guessthenumbergame.Game;
import academy.learnprogramming.guessthenumbergame.MessageGenerator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GameServiceImpl implements GameService {
	
	private final Game game;
	private final MessageGenerator messageGenerator;
	
	
	@Autowired
	public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
		super();
		this.game = game;
		this.messageGenerator = messageGenerator;
	}
	
	@PostConstruct
	public void init() {
		log.info("number = {}", game.getNumber());
		log.info("mainMessage = {}", messageGenerator.getMainMessage());
	}

	@Override
	public boolean isGameOver() {
		return game.isGameLost() || game.isGameWon();
	}

	@Override
	public String getMainMessage() {
		return messageGenerator.getMainMessage();
	}

	@Override
	public String getResultMessage() {
		return messageGenerator.getResultMessage();
	}

	@Override
	public void checkGuess(int guess) {
		game.setGuess(guess);
		game.check();	
	}

	@Override
	public void reset() {
		game.reset();

	}

}
