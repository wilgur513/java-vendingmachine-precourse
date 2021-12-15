package vendingmachine.model;

public class Event<T> {
	private EventType type;
	private T data;

	public Event(EventType type, T data) {
		this.type = type;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public boolean isTypeOf(EventType type) {
		return this.type == type;
	}
}
