package vendingmachine.view;

import vendingmachine.model.Coins;

public class OutputView {
	public static void printChangeCoins(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		coins.sortedStream()
			.forEach(c -> System.out.println(c.getAmount()+"원 - " + coins.getNumberOf(c)));
		System.out.println();
	}
}
