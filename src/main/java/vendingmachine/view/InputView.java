package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String inputMoney() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
		String money = Console.readLine();
		System.out.println();

		if (!money.matches("[0-9]+")) {
			throw new IllegalArgumentException("금액은 숫자여야 합니다.");
		}

		return money;
	}
}
