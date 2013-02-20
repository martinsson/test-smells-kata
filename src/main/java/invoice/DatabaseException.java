package invoice;

public class DatabaseException extends RuntimeException {

	public DatabaseException() {
		super("temporary error");
	}
}
