package hw03.exception;

public class TroopStrengthOutOfBoundsException extends RuntimeException{

	public TroopStrengthOutOfBoundsException() {
		super();
	}

	public TroopStrengthOutOfBoundsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TroopStrengthOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public TroopStrengthOutOfBoundsException(String message) {
		super(message);
	}

	public TroopStrengthOutOfBoundsException(Throwable cause) {
		super(cause);
	}

	
}
