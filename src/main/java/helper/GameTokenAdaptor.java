package helper;

import exceptions.InvalidArgumentException;
import lombok.extern.slf4j.Slf4j;
import models.GameToken;

@Slf4j
public class GameTokenAdaptor {
	private GameTokenAdaptor() {}

    public static GameToken adaptToGameTokenFromNumber(Integer playerInput) {
		switch (playerInput) {
			case 0:
				return GameToken.ROCK;
			case 1:
				return GameToken.PAPER;
			case 2:
				return GameToken.SCISSOR;
			default:
				log.error("Invalid playerInput it should be either [0, 1, 2]");
				throw new InvalidArgumentException("Invalid playerInput it should be either [0, 1, 2]");

		}
    }
}
