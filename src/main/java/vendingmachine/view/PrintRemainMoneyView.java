package vendingmachine.view;

import static vendingmachine.model.EventType.CHANGE_REMAIN_MONEY;
import java.util.Observable;
import java.util.Observer;
import vendingmachine.model.Event;

public class PrintRemainMoneyView implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		Event<Integer> event = (Event) arg;

		if (event.isTypeOf(CHANGE_REMAIN_MONEY)) {
			printRemainMoney(event.getData());
		}
	}

	private void printRemainMoney(Integer money) {
		System.out.println("투입 금액: " + money + "원");
	}
}
