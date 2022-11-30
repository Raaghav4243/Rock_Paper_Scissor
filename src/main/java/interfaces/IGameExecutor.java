package interfaces;

import models.GameResult;
import models.Player;

public interface IGameExecutor {

    GameResult executeGame(Player playerOne, Player playerTwo);
}
