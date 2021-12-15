package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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
		return false;
	}

	public void inputMoney(String inputMoney) {
		this.inputMoney = Integer.valueOf(inputMoney);
		setChanged();
		notifyObservers(new Event(EventType.CHANGE_REMAIN_MONEY, inputMoney));
	}
}
