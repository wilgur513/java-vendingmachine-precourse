package vendingmachine.view;

import java.util.Observable;
import java.util.Observer;
import vendingmachine.model.Coins;
import vendingmachine.model.Event;
import static vendingmachine.model.EventType.INPUT_COINS;

public class PrintCoinsView implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		Event<Coins> event = (Event) arg;

		if (event.isTypeOf(INPUT_COINS)) {
			printChangeCoins(event.getData());
		}
	}

	public static void printChangeCoins(Coins coins) {
		System.out.println("자판기가 보유한 동전");
		coins.sortedStream()
			.forEach(c -> System.out.println(c.getAmount() + "원 - " + coins.getNumberOf(c) + "개"));
		System.out.println();
	}
}
