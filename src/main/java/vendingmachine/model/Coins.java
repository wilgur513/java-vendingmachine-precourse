package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.Comparator.comparingInt;

public class Coins {
	private Map<Coin, Integer> coins;

	public Coins() {
		coins = new HashMap<>();
		coins.put(Coin.COIN_500, 0);
		coins.put(Coin.COIN_100, 0);
		coins.put(Coin.COIN_50, 0);
		coins.put(Coin.COIN_10, 0);
	}

	public void put(Coin coin) {
		coins.put(coin, getNumberOf(coin) + 1);
	}

	public Stream<Coin> sortedStream() {
		return coins.keySet().stream().sorted(comparingInt(Coin::getAmount));
	}

	@Override
	public String toString() {
		return "Coins{" +
			"map=" + coins +
			'}';
	}

	public int getNumberOf(Coin coin) {
		return coins.get(coin);
	}
}
