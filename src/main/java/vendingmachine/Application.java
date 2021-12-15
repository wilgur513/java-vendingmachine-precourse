package vendingmachine;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
	public static void main(String[] args) {
		String money = inputMoney();
		Coins coins = new CoinsGenerator().generate(money);
		OutputView.printChangeCoins(coins);

		String itemList = inputItemList();
	}

	private static String inputMoney() {
		try {
			return InputView.inputMoney();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			System.out.println();
			return inputMoney();
		}
	}

	private static String inputItemList() {
		try {
			return InputView.inputItemList();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			System.out.println();
			return inputItemList();
		}
	}
}
