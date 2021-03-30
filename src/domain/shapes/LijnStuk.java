package domain.shapes;

import domain.exceptions.DomainException;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class LijnStuk extends Vorm {

    Punt start;
    Punt end;

    public LijnStuk(Punt start, Punt end) throws DomainException {
        if (start == end) {
            throw new DomainException("Start can't be the same as the end.");
        } else if (start == null || end == null) {
            throw new DomainException("Start and end can't be null.");
        } else {
            setEndPunts(start,end);
        }
    }

    private void setEndPunts(Punt start, Punt end) throws DomainException {
        if(start==null||end==null) throw new DomainException("Start of einde was null.");
        this.start = start;
        this.end = end;
    }

    public Punt getStart() {
        return this.start;
    }

    public Punt getEnd() {
        return this.end;
    }

    public boolean equals(LijnStuk line) {
        if (line == null) return false;
        Punt oStart = line.getStart();
        Punt oEnd = line.getEnd();
        //return (this.getStart() == oStart && this.getEnd() == oEnd) || (this.getStart() == oEnd && this.getEnd() == oStart);
        return this.getStart().equals(oStart) && this.getEnd().equals(oEnd);
    }
    @Override
    public Omhullende omhullende() throws DomainException {
        Punt boxPos = new Punt(min(this.getEnd().getX(), this.getEnd().getX()), min(this.getEnd().getY(), this.getEnd().getY()));
        int width = max(this.start.getX(), this.end.getX()) - boxPos.getX();
        int height = max(this.start.getY(), this.end.getY()) - boxPos.getY();
        return new Omhullende(boxPos, width, height);
    }

    @Override
    public String toString() {
        return String.format("Lijn: startpunt: %s - eindpunt: %s", this.getStart().toString(), this.getEnd().toString());
    }
}
