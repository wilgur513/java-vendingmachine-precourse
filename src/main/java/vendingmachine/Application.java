package vendingmachine;

import vendingmachine.view.InputView;

public class Application {
	public static void main(String[] args) {
		String money = inputMoney();
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
