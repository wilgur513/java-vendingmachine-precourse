package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import vendingmachine.view.InputView;

public class Application {
	public static void main(String[] args) {
		String money = inputMoney();
		Coins coins = generateCoins(money);
		System.out.println(coins);
	}

	private static Coins generateCoins(String money) {
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

	private static Coin pickRandomCoin() {
		Integer value = Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10));
		return Coin.valueOf(value);
	}

	private static String inputMoney() {
		try {
			return InputView.inputMoney();
		} catch(IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			System.out.println();
			return inputMoney();
		}
	}
}
