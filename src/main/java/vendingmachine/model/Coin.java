package vendingmachine.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public static Coin valueOf(Integer amount) {
		if (amount == 500) {
			return COIN_500;
		} else if (amount == 100) {
			return COIN_100;
		} else if (amount == 50) {
			return COIN_50;
		}
		return COIN_10;
	}

	public static List<Coin> sortedValues() {
		return Arrays.stream(values())
			.sorted(Comparator.comparingInt(Coin::getAmount).reversed())
			.collect(Collectors.toList());
	}

	public boolean isLessAndEqual(int amount) {
		return this.amount <= amount;
	}

	public int getAmount() {
		return amount;
	}
}
