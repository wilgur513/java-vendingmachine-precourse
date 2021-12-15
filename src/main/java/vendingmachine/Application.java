package vendingmachine;

import java.util.List;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
	public static void main(String[] args) {
		String coinsAmount = inputMoney("자판기가 보유하고 있는 금액을 입력해 주세요.");
		Coins coins = new CoinsGenerator().generate(coinsAmount);
		OutputView.printChangeCoins(coins);
		List<Item> itemList = inputItemList();
		String inputMoney = inputMoney("투입 금액을 입력해 주세요.");
	}

	private static String inputMoney(String message) {
		try {
			return InputView.inputMoney(message);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			System.out.println();
			return inputMoney(message);
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
