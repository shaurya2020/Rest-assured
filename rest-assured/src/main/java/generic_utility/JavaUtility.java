package generic_utility;

import java.util.Random;

public class JavaUtility {
	public static int generateRanNum() {
		return (int) (Math.random() * 1000);
	}

	public static int generateRandomNumber(int max) {
		return new Random().nextInt(max);
	}

}