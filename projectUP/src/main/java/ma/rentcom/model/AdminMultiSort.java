package ma.rentcom.model;

import java.util.Objects;

public class AdminMultiSort {
    
    private final AdminSort adminSort;
    private final String sortField;

    public AdminMultiSort(AdminSort adminSort, String sortField) {
        this.adminSort = adminSort;
        this.sortField = sortField;
    }

    public AdminSort getAdminSort() {
        return adminSort;
    }

    public String getSortField() {
        return sortField;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdminMultiSort other = (AdminMultiSort) obj;
        if (!Objects.equals(this.sortField, other.sortField)) {
            return false;
        }
        if (this.adminSort != other.adminSort) {
            return false;
        }
        return true;
    }
    
    
    
}
