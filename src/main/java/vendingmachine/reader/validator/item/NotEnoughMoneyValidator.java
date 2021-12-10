package vendingmachine.reader.validator.item;

import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
import vendingmachine.model.machine.VendingMachineRepository;
import vendingmachine.reader.validator.Validator;

public class NotEnoughMoneyValidator implements Validator {
	@Override
	public boolean validate(String value) {
		Item item = ItemRepository.findByName(value);
		VendingMachine vendingMachine = VendingMachineRepository.find();
		return vendingMachine.hasEnoughMoney(item.getPrice());
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + value + "를 구매하기에 돈이 부족합니다.";
	}
}
