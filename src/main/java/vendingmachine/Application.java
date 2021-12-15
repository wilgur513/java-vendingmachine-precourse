package vendingmachine;

import java.util.List;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
	public static void main(String[] args) {
		String money = inputMoney();
		Coins coins = new CoinsGenerator().generate(money);
		OutputView.printChangeCoins(coins);

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

	private static List<Item> inputItemList() {
		try {
			return InputView.inputItemList();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			System.out.println();
			return inputItemList();
		}
	}
}
