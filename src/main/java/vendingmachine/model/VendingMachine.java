package vendingmachine.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Optional;

public class VendingMachine extends Observable {
	private List<Item> itemList = new ArrayList<>();
	private Coins coins;
	private int inputMoney;

	public void inputCoins(Coins coins) {
		this.coins = coins;
		setChanged();
		notifyObservers(new Event(EventType.INPUT_COINS, coins));
	}

	public void addItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public boolean isClose() {
		return isAllSoldOut() || !hasEnoughMoney();
	}

	private boolean isAllSoldOut() {
		return itemList.stream().allMatch(Item::isSoldOut);
	}

	private boolean hasEnoughMoney() {
		Item lowestItem = itemList.stream().sorted(Comparator.comparingInt(Item::getPrice)).findFirst().get();
		return inputMoney >= lowestItem.getPrice();
	}

	public void inputMoney(String inputMoney) {
		this.inputMoney = Integer.valueOf(inputMoney);
		setChanged();
		notifyObservers(new Event(EventType.CHANGE_REMAIN_MONEY, this.inputMoney));
	}

	public void purchase(String itemName) {
		Optional<Item> optionalItem = findByName(itemName);

		if(!optionalItem.isPresent()) {
			throw new IllegalArgumentException("해당 상품이 없습니다.");
		}

		purchase(optionalItem.get());
	}

	private Optional<Item> findByName(String itemName) {
		return itemList.stream().filter(i -> i.getName().equals(itemName)).findFirst();
	}

	private void purchase(Item item) {
		if (!isSalable(item)) {
			throw new IllegalArgumentException("상품을 구매할 수 없습니다.");
		}
		inputMoney -= item.getPrice();
		item.sell();
		setChanged();
		notifyObservers(new Event(EventType.CHANGE_REMAIN_MONEY, inputMoney));
	}

	private boolean isSalable(Item item) {
		return !item.isSoldOut() && hasEnoughMoney(item);
	}

	private boolean hasEnoughMoney(Item item) {
		return inputMoney >= item.getPrice();
	}
}
