package java.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.util.zip.ZipUtils;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    public static ValueRange of(long min, long max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        return new ValueRange(min, min, max, max);
    }

    public static ValueRange of(long min, long maxSmallest, long maxLargest) {
        if (min > maxSmallest) {
            throw new IllegalArgumentException("Minimum value must be less than smallest maximum value");
        }
        return of(min, min, maxSmallest, maxLargest);
    }

    public static ValueRange of(long minSmallest, long minLargest, long maxSmallest, long maxLargest) {
        if (minSmallest > minLargest) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        }
        if (maxSmallest > maxLargest) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        }
        if (minLargest > maxLargest) {
            throw new IllegalArgumentException("Largest minimum value must be less than largest maximum value");
        }
        if (minSmallest > maxSmallest) {
            throw new IllegalArgumentException("Smallest minimum value must be less than smallest maximum value");
        }
        return new ValueRange(minSmallest, minLargest, maxSmallest, maxLargest);
    }

    private ValueRange(long minSmallest, long minLargest, long maxSmallest, long maxLargest) {
        this.minSmallest = minSmallest;
        this.minLargest = minLargest;
        this.maxSmallest = maxSmallest;
        this.maxLargest = maxLargest;
    }

    public boolean isFixed() {
        return this.minSmallest == this.minLargest && this.maxSmallest == this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getLargestMinimum() {
        return this.minLargest;
    }

    public long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public boolean isIntValue() {
        return getMinimum() >= -2147483648L && getMaximum() <= ZipUtils.UPPER_UNIXTIME_BOUND;
    }

    public boolean isValidValue(long value) {
        return value >= getMinimum() && value <= getMaximum();
    }

    public boolean isValidIntValue(long value) {
        return isIntValue() && isValidValue(value);
    }

    public long checkValidValue(long value, TemporalField field) {
        if (!isValidValue(value)) {
            throw new DateTimeException(genInvalidFieldMessage(field, value));
        }
        return value;
    }

    public int checkValidIntValue(long value, TemporalField field) {
        if (!isValidIntValue(value)) {
            throw new DateTimeException(genInvalidFieldMessage(field, value));
        }
        return (int) value;
    }

    private String genInvalidFieldMessage(TemporalField field, long value) {
        return field != null ? "Invalid value for " + ((Object) field) + " (valid values " + ((Object) this) + "): " + value : "Invalid value (valid values " + ((Object) this) + "): " + value;
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException, InvalidObjectException {
        s2.defaultReadObject();
        long j10 = this.minSmallest;
        long j11 = this.minLargest;
        if (j10 > j11) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j12 = this.maxSmallest;
        long j13 = this.maxLargest;
        if (j12 > j13) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j11 > j13) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ValueRange) {
            ValueRange other = (ValueRange) obj;
            if (this.minSmallest == other.minSmallest && this.minLargest == other.minLargest && this.maxSmallest == other.maxSmallest && this.maxLargest == other.maxLargest) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.minSmallest;
        long j11 = this.minLargest;
        long j12 = j10 + (j11 << 16) + (j11 >> 48);
        long j13 = this.maxSmallest;
        long j14 = j12 + (j13 << 32) + (j13 >> 32);
        long j15 = this.maxLargest;
        long hash = j14 + (j15 << 48) + (j15 >> 16);
        return (int) ((hash >>> 32) ^ hash);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(this.minSmallest);
        if (this.minSmallest != this.minLargest) {
            buf.append(IOUtils.DIR_SEPARATOR_UNIX).append(this.minLargest);
        }
        buf.append(" - ").append(this.maxSmallest);
        if (this.maxSmallest != this.maxLargest) {
            buf.append(IOUtils.DIR_SEPARATOR_UNIX).append(this.maxLargest);
        }
        return buf.toString();
    }
}
