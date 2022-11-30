package svc;

import interfaces.IGameExecutor;
import lombok.extern.slf4j.Slf4j;
import models.GameResult;
import models.Player;

@Slf4j
public class RockPaperScissorExecutor implements IGameExecutor {

	@Override
	public GameResult executeGame(Player playerOne, Player playerTwo) {
		log.debug("Getting the Result for the Player: {} and Token: {}", playerOne.getName(), playerOne.getToken().name());
		return playerOne.getToken().getResult(playerTwo.getToken());
	}

}
