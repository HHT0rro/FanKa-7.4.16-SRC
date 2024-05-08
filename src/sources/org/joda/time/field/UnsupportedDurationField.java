package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnsupportedDurationField extends org.joda.time.d implements Serializable {
    private static HashMap<DurationFieldType, UnsupportedDurationField> cCache = null;
    private static final long serialVersionUID = -6390301302770925357L;
    private final DurationFieldType iType;

    private UnsupportedDurationField(DurationFieldType durationFieldType) {
        this.iType = durationFieldType;
    }

    public static synchronized UnsupportedDurationField getInstance(DurationFieldType durationFieldType) {
        UnsupportedDurationField unsupportedDurationField;
        synchronized (UnsupportedDurationField.class) {
            HashMap<DurationFieldType, UnsupportedDurationField> hashMap = cCache;
            if (hashMap == null) {
                cCache = new HashMap<>(7);
                unsupportedDurationField = null;
            } else {
                unsupportedDurationField = hashMap.get(durationFieldType);
            }
            if (unsupportedDurationField == null) {
                unsupportedDurationField = new UnsupportedDurationField(durationFieldType);
                cCache.put(durationFieldType, unsupportedDurationField);
            }
        }
        return unsupportedDurationField;
    }

    private Object readResolve() {
        return getInstance(this.iType);
    }

    private UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException(((Object) this.iType) + " field is unsupported");
    }

    @Override // org.joda.time.d
    public long add(long j10, int i10) {
        throw unsupported();
    }

    @Override // java.lang.Comparable
    public int compareTo(org.joda.time.d dVar) {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnsupportedDurationField)) {
            return false;
        }
        UnsupportedDurationField unsupportedDurationField = (UnsupportedDurationField) obj;
        if (unsupportedDurationField.getName() == null) {
            return getName() == null;
        }
        return unsupportedDurationField.getName().equals(getName());
    }

    @Override // org.joda.time.d
    public int getDifference(long j10, long j11) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public long getDifferenceAsLong(long j10, long j11) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public long getMillis(int i10) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.d
    public final DurationFieldType getType() {
        return this.iType;
    }

    @Override // org.joda.time.d
    public long getUnitMillis() {
        return 0L;
    }

    @Override // org.joda.time.d
    public int getValue(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10) {
        throw unsupported();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // org.joda.time.d
    public boolean isPrecise() {
        return true;
    }

    @Override // org.joda.time.d
    public boolean isSupported() {
        return false;
    }

    @Override // org.joda.time.d
    public String toString() {
        return "UnsupportedDurationField[" + getName() + ']';
    }

    @Override // org.joda.time.d
    public long add(long j10, long j11) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public long getMillis(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public int getValue(long j10, long j11) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10, long j11) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public long getMillis(int i10, long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.d
    public long getMillis(long j10, long j11) {
        throw unsupported();
    }
}
