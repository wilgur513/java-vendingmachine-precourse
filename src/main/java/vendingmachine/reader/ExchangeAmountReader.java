package vendingmachine.reader;

import vendingmachine.reader.validator.CompositeValidator;
import vendingmachine.reader.validator.number.NumberFormatValidator;
import vendingmachine.reader.validator.number.TenTimesNumberValidator;
import vendingmachine.reader.validator.Validator;

public class ExchangeAmountReader extends Reader<Integer> {
	public ExchangeAmountReader(Validator validator) {
		super(validator);
	}

	@Override
	protected void printInputMessage() {
		System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
	}

	@Override
	protected Integer parse(String value) {
		return Integer.valueOf(value);
	}

	@Override
	protected String getInputValueName() {
		return "금액";
	}

	public static RecursiveReader<Integer> recursiveReader() {
		return new RecursiveReader<>(
			new ExchangeAmountReader(
				new CompositeValidator(
					new NumberFormatValidator(),
					new TenTimesNumberValidator())));
	}
}
