package domain.exceptions;

public class DbException extends Exception {
    public DbException() {
        super();
    }

    public DbException(String errorMessage) {
        super(errorMessage);
    }
}
