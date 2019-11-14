package ma.rentcom.model;

public enum AdminSort {

    ASCENDING, DESCENDING, UNSORTED;

    public boolean isAscending() {
        return ASCENDING.equals(this);
    }
}
