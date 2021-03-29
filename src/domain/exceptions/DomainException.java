package domain.exceptions;

public class DomainException extends Exception {
    public DomainException(String errorMessage) {
        super(errorMessage);
    }
}
