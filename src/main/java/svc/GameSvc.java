package svc;

import helper.GameTokenAdaptor;
import interfaces.IGameExecutor;
import lombok.extern.slf4j.Slf4j;
import models.GameResult;
import models.GameToken;
import models.Player;

import java.util.function.Predicate;

@Slf4j
public class GameSvc {
	private static final String ROBOT = "Computer";

	private final Predicate<String> isValidNumber =
			(str -> (str.equals("0") || str.equals("1") || str.equals("2")));

	private IGameExecutor gameExecutor;
	private final Player player1;
	private final Player player2;

	private GameSvc(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		gameExecutor = new RockPaperScissorExecutor();

	}

	public Predicate<String> getIsValidNumber() {
		return isValidNumber;
	}

	public static GameSvc startGame(String playerOneName) {
		GameSvc gameSvc = new GameSvc(new Player(playerOneName), new Player(ROBOT));
		log.info("Started the Game Svc");
		return gameSvc;
	}

	public void setGameExecutor(IGameExecutor gameExecutor) {
		this.gameExecutor = gameExecutor;
	}

	public void play(String playerInput) {
		if (!isValidNumber.test(playerInput)) {
			log.warn("Invalid Input, Please try again, valid input are [0, 1, 2]");
			return;
		}

		GameToken playerOneToken = GameTokenAdaptor.adaptToGameTokenFromNumber(Integer.parseInt(playerInput));
		player1.setToken(playerOneToken);

		GameToken playerComputerToken = ComputerSvc.generateRandomGameToken();
		player2.setToken(playerComputerToken);

		log.info("You played: {} , Computer player played: {}", playerOneToken, playerComputerToken);

		log.debug("Calling the GameExecutor..");
		GameResult gameResult = gameExecutor.executeGame(player1, player2);

		if (gameResult.equals(GameResult.WON)) {
			System.out.println("CONGRATULATIONS !!, " + player1.getName() + " , You won!!");
		} else if (gameResult.equals(GameResult.LOST)) {
			System.out.println("OOPS !! You Lost :-(, Better Luck Next Time !!");
		} else {
			System.out.println("It's TIE !!. You can try again");
		}
	}
}
