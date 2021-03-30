package domain.shapes;

import domain.exceptions.DomainException;

public abstract class Vorm {
    public abstract Omhullende omhullende() throws DomainException;

    public abstract String toString();
}
