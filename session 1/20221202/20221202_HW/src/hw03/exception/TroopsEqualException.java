package hw03.exception;

public class TroopsEqualException extends RuntimeException{

	public TroopsEqualException() {
		super();
	}
	public TroopsEqualException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public TroopsEqualException(String message, Throwable cause) {
		super(message, cause);
	}
	public TroopsEqualException(String message) {
		super(message);
	}
	public TroopsEqualException(Throwable cause) {
		super(cause);
	}
}
