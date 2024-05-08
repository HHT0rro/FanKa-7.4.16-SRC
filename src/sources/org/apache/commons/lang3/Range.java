package org.apache.commons.lang3;

import com.android.internal.logging.nano.MetricsProto;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum ComparableComparator implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    private Range(T t2, T t10, Comparator<T> comparator) {
        if (t2 != null && t10 != null) {
            if (comparator == null) {
                this.comparator = ComparableComparator.INSTANCE;
            } else {
                this.comparator = comparator;
            }
            if (this.comparator.compare(t2, t10) < 1) {
                this.minimum = t2;
                this.maximum = t10;
                return;
            } else {
                this.minimum = t10;
                this.maximum = t2;
                return;
            }
        }
        throw new IllegalArgumentException("Elements in a range must not be null: element1=" + ((Object) t2) + ", element2=" + ((Object) t10));
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range between(Comparable comparable, Comparable comparable2) {
        return between(comparable, comparable2, null);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range is(Comparable comparable) {
        return between(comparable, comparable, null);
    }

    public boolean contains(T t2) {
        return t2 != null && this.comparator.compare(t2, this.minimum) > -1 && this.comparator.compare(t2, this.maximum) < 1;
    }

    public boolean containsRange(Range<T> range) {
        return range != null && contains(range.minimum) && contains(range.maximum);
    }

    public int elementCompareTo(T t2) {
        Validate.notNull(t2, "Element is null", new Object[0]);
        if (isAfter(t2)) {
            return -1;
        }
        return isBefore(t2) ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        Range range = (Range) obj;
        return this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum);
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public T getMaximum() {
        return this.maximum;
    }

    public T getMinimum() {
        return this.minimum;
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((MetricsProto.MetricsEvent.TEXT_LONGPRESS + Range.class.hashCode()) * 37) + this.minimum.hashCode()) * 37) + this.maximum.hashCode();
        this.hashCode = hashCode;
        return hashCode;
    }

    public Range<T> intersectionWith(Range<T> range) {
        if (isOverlappedBy(range)) {
            if (equals(range)) {
                return this;
            }
            return between(getComparator().compare(this.minimum, range.minimum) < 0 ? range.minimum : this.minimum, getComparator().compare(this.maximum, range.maximum) < 0 ? this.maximum : range.maximum, getComparator());
        }
        throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
    }

    public boolean isAfter(T t2) {
        return t2 != null && this.comparator.compare(t2, this.minimum) < 0;
    }

    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    public boolean isBefore(T t2) {
        return t2 != null && this.comparator.compare(t2, this.maximum) > 0;
    }

    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    public boolean isEndedBy(T t2) {
        return t2 != null && this.comparator.compare(t2, this.maximum) == 0;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        return range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum);
    }

    public boolean isStartedBy(T t2) {
        return t2 != null && this.comparator.compare(t2, this.minimum) == 0;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = "[" + ((Object) this.minimum) + ".." + ((Object) this.maximum) + "]";
        }
        return this.toString;
    }

    public static <T> Range<T> between(T t2, T t10, Comparator<T> comparator) {
        return new Range<>(t2, t10, comparator);
    }

    public static <T> Range<T> is(T t2, Comparator<T> comparator) {
        return between(t2, t2, comparator);
    }

    public String toString(String str) {
        return String.format(str, this.minimum, this.maximum, this.comparator);
    }
}
