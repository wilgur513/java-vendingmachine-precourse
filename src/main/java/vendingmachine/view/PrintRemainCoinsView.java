package vendingmachine.view;

import static vendingmachine.model.EventType.CLOSE_VENDING_MACHINE;
import java.util.Observable;
import java.util.Observer;
import vendingmachine.model.Coin;
import vendingmachine.model.Coins;
import vendingmachine.model.Event;

public class PrintRemainCoinsView implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		Event<Coins> event = (Event) arg;

		if (event.isTypeOf(CLOSE_VENDING_MACHINE)) {
			printRemainCoins(event.getData());
		}
	}

	private void printRemainCoins(Coins coins) {
		coins.sortedStream()
			.filter(c -> coins.getNumberOf(c) > 0)
			.forEach(c -> printNumberOfCoin(c, coins.getNumberOf(c)));
	}

	private void printNumberOfCoin(Coin coin, int number) {
		System.out.println(coin.getAmount() + "원 - " + number + "개");
	}
}
