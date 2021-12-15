package vendingmachine;

import java.util.List;
import vendingmachine.model.Coins;
import vendingmachine.model.CoinsGenerator;
import vendingmachine.model.Item;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.PrintCoinsView;
import vendingmachine.view.PrintRemainMoneyView;

public class VendingMachineController {
	private final VendingMachine vendingMachine;
	private final CoinsGenerator coinsGenerator = new CoinsGenerator();

	public VendingMachineController() {
		vendingMachine = new VendingMachine();
		vendingMachine.addObserver(new PrintCoinsView());
		vendingMachine.addObserver(new PrintRemainMoneyView());
	}

	public void service() {
		Coins coins = coinsGenerator.generate(inputMoney("자판기가 보유하고 있는 금액을 입력해 주세요."));
		vendingMachine.inputCoins(coins);
		vendingMachine.addItemList(inputItemList());
		vendingMachine.inputMoney(inputMoney("투입 금액을 입력해 주세요."));

		while (!vendingMachine.isClose()) {
			try {
				vendingMachine.purchase(inputItem());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}
		}
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

	private String inputItem() {
		try {
			return InputView.inputItem();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			System.out.println();
			return inputItem();
		}
	}
}
