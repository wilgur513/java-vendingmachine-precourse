package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.Item;

public class InputView {
	public static String inputMoney() {
		String money = inputWithMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");

		if (!money.matches("[0-9]+")) {
			throw new IllegalArgumentException("금액은 숫자여야 합니다.");
		}

		return money;
	}

	public static List<Item> inputItemList() {
		String itemList = inputWithMessage("상품명과 가격, 수량을 입력해 주세요.");

		if (!itemList.matches("(\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])+(;\\[[a-zA-Z가-힣0-9]+,[0-9]+,[0-9]+\\])*")) {
			throw new IllegalArgumentException("상품 정보 양식이 잘못됐습니다.");
		}

		return parseItemList(itemList);
	}

	private static String inputWithMessage(String s) {
		System.out.println(s);
		String money = Console.readLine();
		System.out.println();
		return money;
	}

	private static List<Item> parseItemList(String itemLine) {
		return Arrays.stream(splitBySemiColon(itemLine))
			.map(InputView::removeBracket)
			.map(InputView::splitByComma)
			.map(InputView::parseToItem)
			.collect(Collectors.toList());
	}

	private static String[] splitBySemiColon(String itemList) {
		return itemList.split(";");
	}

	private static String removeBracket(String item) {
		return item.substring(1, item.length() - 1);
	}

	private static String[] splitByComma(String item) {
		return item.split(",");
	}

	private static Item parseToItem(String[] item) {
		if (!isValidItemPrice(item[1])) {
			throw new IllegalArgumentException("상품 가격이 잘못됐습니다.");
		}

		return new Item(item[0], Integer.valueOf(item[1]), Integer.valueOf(item[2]));
	}

	private static boolean isValidItemPrice(String s) {
		return Integer.valueOf(s) % 10 == 0 && Integer.valueOf(s) >= 100;
	}
}
