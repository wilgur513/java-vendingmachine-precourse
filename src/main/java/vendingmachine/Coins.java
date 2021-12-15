package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Coins {
	private Map<Coin, Integer> map;

	public Coins() {
		map = new HashMap<>();
		map.put(Coin.COIN_500, 0);
		map.put(Coin.COIN_100, 0);
		map.put(Coin.COIN_50, 0);
		map.put(Coin.COIN_10, 0);
	}

	public void put(Coin coin) {
		map.put(coin, map.get(coin) + 1);
	}

	@Override
	public String toString() {
		return "Coins{" +
			"map=" + map +
			'}';
	}
}
