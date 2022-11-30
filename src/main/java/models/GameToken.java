package models;

import interfaces.IGameTokenExecutor;

public enum GameToken implements IGameTokenExecutor {
	ROCK {
		@Override
		public GameResult getResult(GameToken playerTwoToken) {
			if (playerTwoToken.equals(SCISSOR)) {
				return GameResult.WON;
			} else if (playerTwoToken.equals(ROCK)) {
				return GameResult.TIE;
			} else {
				return GameResult.LOST;
			}
		}
	},

	PAPER {
		@Override
		public GameResult getResult(GameToken playerTwoToken) {
			if (playerTwoToken.equals(ROCK)) {
				return GameResult.WON;
			} else if (playerTwoToken.equals(PAPER)) {
				return GameResult.TIE;
			} else {
				return GameResult.LOST;
			}
		}
	},

	SCISSOR {
		@Override
		public GameResult getResult(GameToken playerTwoToken) {
			if (playerTwoToken.equals(PAPER)) {
				return GameResult.WON;
			} else if (playerTwoToken.equals(SCISSOR)) {
				return GameResult.TIE;
			} else {
				return GameResult.LOST;
			}
		}
	};
}
