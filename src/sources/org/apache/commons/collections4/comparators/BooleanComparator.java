package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BooleanComparator implements Comparator<Boolean>, Serializable {
    private static final long serialVersionUID = 1830042991606340609L;
    private boolean trueFirst;
    private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);
    private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);

    public BooleanComparator() {
        this(false);
    }

    public static BooleanComparator booleanComparator(boolean z10) {
        return z10 ? TRUE_FIRST : FALSE_FIRST;
    }

    public static BooleanComparator getFalseFirstComparator() {
        return FALSE_FIRST;
    }

    public static BooleanComparator getTrueFirstComparator() {
        return TRUE_FIRST;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BooleanComparator) && this.trueFirst == ((BooleanComparator) obj).trueFirst);
    }

    public int hashCode() {
        return this.trueFirst ? -478003966 : 478003966;
    }

    public boolean sortsTrueFirst() {
        return this.trueFirst;
    }

    public BooleanComparator(boolean z10) {
        this.trueFirst = z10;
    }

    @Override // java.util.Comparator
    public int compare(Boolean bool, Boolean bool2) {
        boolean booleanValue = bool.booleanValue();
        if (bool2.booleanValue() ^ booleanValue) {
            return booleanValue ^ this.trueFirst ? 1 : -1;
        }
        return 0;
    }
}
