package domain.shapes;

import domain.exceptions.DomainException;

abstract class Shape {
    public abstract Omhullende omhullende() throws DomainException;

    public abstract String toString();
}
