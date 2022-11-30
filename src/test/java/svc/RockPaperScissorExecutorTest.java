package svc;

import interfaces.IGameExecutor;
import models.GameResult;
import models.GameToken;
import models.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RockPaperScissorExecutorTest {
	private IGameExecutor gameExecutor;

	@Before
	public void setUp() throws Exception {
		gameExecutor = new RockPaperScissorExecutor();
	}

	@Test
	public void testExecuteGameWhenPlayerPlayedROCK() {
		Player playerOne = generatePlayerInfo("Player1", GameToken.ROCK);
		Player playerTwo = generatePlayerInfo("Player2", GameToken.SCISSOR);

		Assert.assertEquals(GameResult.WON, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.ROCK);
		Assert.assertEquals(GameResult.TIE, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.PAPER);
		Assert.assertEquals(GameResult.LOST, gameExecutor.executeGame(playerOne, playerTwo));
	}

	@Test
	public void testExecuteGameWhenPlayerPlayedPAPER() {
		Player playerOne = generatePlayerInfo("Player1", GameToken.PAPER);
		Player playerTwo = generatePlayerInfo("Player2", GameToken.ROCK);

		Assert.assertEquals(GameResult.WON, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.PAPER);
		Assert.assertEquals(GameResult.TIE, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.SCISSOR);
		Assert.assertEquals(GameResult.LOST, gameExecutor.executeGame(playerOne, playerTwo));
	}

	@Test
	public void testExecuteGameWhenPlayerPlayedSCISSOR() {
		Player playerOne = generatePlayerInfo("Player1", GameToken.SCISSOR);
		Player playerTwo = generatePlayerInfo("Player2", GameToken.PAPER);

		Assert.assertEquals(GameResult.WON, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.SCISSOR);
		Assert.assertEquals(GameResult.TIE, gameExecutor.executeGame(playerOne, playerTwo));

		playerTwo.setToken(GameToken.ROCK);
		Assert.assertEquals(GameResult.LOST, gameExecutor.executeGame(playerOne, playerTwo));
	}

	private Player generatePlayerInfo(String playerName, GameToken gameToken) {
		Player player = new Player(playerName);
		player.setToken(gameToken);
		return player;
	}
}
