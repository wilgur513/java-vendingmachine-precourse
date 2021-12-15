package vendingmachine;

import java.util.List;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
	public static void main(String[] args) {
		VendingMachineController controller = new VendingMachineController();
		controller.service();
	}
}
