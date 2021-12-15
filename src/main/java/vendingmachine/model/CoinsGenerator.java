package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class CoinsGenerator {
	public Coins generate(String money) {
		int moneyValue = Integer.parseInt(money);
		Coins coins = new Coins();

		while (moneyValue != 0) {
			Coin coin = pickRandomCoin();

			if(coin.isLessAndEqual(moneyValue)) {
				coins.put(coin);
				moneyValue -= coin.getAmount();
			}
		}

		return coins;
	}

	private Coin pickRandomCoin() {
		Integer value = Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10));
		return Coin.valueOf(value);
	}
}
