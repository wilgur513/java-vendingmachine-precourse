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

	public static String inputItemList() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		String itemList = Console.readLine();
		System.out.println();

		if (!itemList.matches("(\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])+(;\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])*")) {
			throw new IllegalArgumentException("상품 정보 양식이 잘못됐습니다.");
		}

		return itemList;
	}
}
