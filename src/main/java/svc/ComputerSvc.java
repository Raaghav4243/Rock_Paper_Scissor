package svc;

import helper.GameTokenAdaptor;
import models.GameToken;

import java.util.Random;

public class ComputerSvc {
	private static final Random random = new Random();

	private ComputerSvc() {}

	public static GameToken generateRandomGameToken() {
		return GameTokenAdaptor.adaptToGameTokenFromNumber(random.nextInt(3));
	}
}
