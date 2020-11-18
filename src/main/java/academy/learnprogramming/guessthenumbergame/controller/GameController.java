package academy.learnprogramming.guessthenumbergame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import academy.learnprogramming.guessthenumbergame.service.GameService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GameController {
	
	private final GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}
	
	@GetMapping("play")
	public String play(Model model) {
		model.addAttribute("mainMessage", gameService.getMainMessage());
		model.addAttribute("resultMessage", gameService.getResultMessage());
		log.info("model= {}", model);
		
		if(gameService.isGameOver()) {
			return "game-over";
		} else {
		return "play";
		}
	}
	
	@PostMapping("play")
	public String processMessage(@RequestParam int guess) {
		log.info("guess = {}", guess);
		gameService.checkGuess(guess);
		return "redirect:/" + "play";
	}
	
	@GetMapping("restart")
	public String restart(){
		gameService.reset();
		return "redirect:/" + "play";
	}


}
