package interfaces;

import models.GameResult;
import models.GameToken;

public interface IGameTokenExecutor {

   GameResult getResult(GameToken playerTwoToken);
}
