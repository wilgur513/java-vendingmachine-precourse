package vendingmachine;

import java.util.List;
import vendingmachine.model.Coins;
import vendingmachine.model.CoinsGenerator;
import vendingmachine.model.Item;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.PrintCoinsView;
import vendingmachine.view.PrintRemainCoinsView;
import vendingmachine.view.PrintRemainMoneyView;

public class VendingMachineController {
	private final VendingMachine vendingMachine;
	private final CoinsGenerator coinsGenerator = new CoinsGenerator();

	public VendingMachineController() {
		vendingMachine = new VendingMachine();
		vendingMachine.addObserver(new PrintCoinsView());
		vendingMachine.addObserver(new PrintRemainMoneyView());
		vendingMachine.addObserver(new PrintRemainCoinsView());
	}

	public void service() {
		initVendingMachine();
		while (!vendingMachine.isClose()) {
			purchaseItem();
		}
		vendingMachine.close();
	}

	private void initVendingMachine() {
		Coins coins = coinsGenerator.generate(inputMoneyWithMessage("자판기가 보유하고 있는 금액을 입력해 주세요."));
		vendingMachine.inputCoins(coins);
		vendingMachine.addItemList(inputItemList());
		vendingMachine.inputMoney(inputMoneyWithMessage("투입 금액을 입력해 주세요."));
	}

	private void purchaseItem() {
		try {
			vendingMachine.purchase(inputItem());
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
		}
	}

	private static String inputMoneyWithMessage(String message) {
		try {
			return InputView.inputMoney(message);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			return inputMoneyWithMessage(message);
		}
	}

	private static List<Item> inputItemList() {
		try {
			return InputView.inputItemList();
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			return inputItemList();
		}
	}

	private String inputItem() {
		try {
			return InputView.inputItem();
		} catch (IllegalArgumentException e) {
			printErrorMessage(e);
			return inputItem();
		}
	}

	private static void printErrorMessage(IllegalArgumentException e) {
		System.out.println("[ERROR] " + e.getMessage());
		System.out.println();
	}
}
