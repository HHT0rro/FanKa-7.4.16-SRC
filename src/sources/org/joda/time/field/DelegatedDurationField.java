package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DelegatedDurationField extends org.joda.time.d implements Serializable {
    private static final long serialVersionUID = -5576443481242007829L;
    private final org.joda.time.d iField;
    private final DurationFieldType iType;

    public DelegatedDurationField(org.joda.time.d dVar) {
        this(dVar, null);
    }

    @Override // org.joda.time.d
    public long add(long j10, int i10) {
        return this.iField.add(j10, i10);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DelegatedDurationField) {
            return this.iField.equals(((DelegatedDurationField) obj).iField);
        }
        return false;
    }

    @Override // org.joda.time.d
    public int getDifference(long j10, long j11) {
        return this.iField.getDifference(j10, j11);
    }

    @Override // org.joda.time.d
    public long getDifferenceAsLong(long j10, long j11) {
        return this.iField.getDifferenceAsLong(j10, j11);
    }

    @Override // org.joda.time.d
    public long getMillis(int i10) {
        return this.iField.getMillis(i10);
    }

    @Override // org.joda.time.d
    public String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.d
    public DurationFieldType getType() {
        return this.iType;
    }

    @Override // org.joda.time.d
    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    @Override // org.joda.time.d
    public int getValue(long j10) {
        return this.iField.getValue(j10);
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10) {
        return this.iField.getValueAsLong(j10);
    }

    public final org.joda.time.d getWrappedField() {
        return this.iField;
    }

    public int hashCode() {
        return this.iField.hashCode() ^ this.iType.hashCode();
    }

    @Override // org.joda.time.d
    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    @Override // org.joda.time.d
    public boolean isSupported() {
        return this.iField.isSupported();
    }

    @Override // org.joda.time.d
    public String toString() {
        if (this.iType == null) {
            return this.iField.toString();
        }
        return "DurationField[" + ((Object) this.iType) + ']';
    }

    public DelegatedDurationField(org.joda.time.d dVar, DurationFieldType durationFieldType) {
        if (dVar != null) {
            this.iField = dVar;
            this.iType = durationFieldType == null ? dVar.getType() : durationFieldType;
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    @Override // org.joda.time.d
    public long add(long j10, long j11) {
        return this.iField.add(j10, j11);
    }

    @Override // java.lang.Comparable
    public int compareTo(org.joda.time.d dVar) {
        return this.iField.compareTo(dVar);
    }

    @Override // org.joda.time.d
    public long getMillis(long j10) {
        return this.iField.getMillis(j10);
    }

    @Override // org.joda.time.d
    public int getValue(long j10, long j11) {
        return this.iField.getValue(j10, j11);
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10, long j11) {
        return this.iField.getValueAsLong(j10, j11);
    }

    @Override // org.joda.time.d
    public long getMillis(int i10, long j10) {
        return this.iField.getMillis(i10, j10);
    }

    @Override // org.joda.time.d
    public long getMillis(long j10, long j11) {
        return this.iField.getMillis(j10, j11);
    }
}
