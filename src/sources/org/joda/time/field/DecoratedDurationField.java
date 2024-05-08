package org.joda.time.field;

import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DecoratedDurationField extends BaseDurationField {
    private static final long serialVersionUID = 8019982251647420015L;
    private final org.joda.time.d iField;

    public DecoratedDurationField(org.joda.time.d dVar, DurationFieldType durationFieldType) {
        super(durationFieldType);
        if (dVar != null) {
            if (dVar.isSupported()) {
                this.iField = dVar;
                return;
            }
            throw new IllegalArgumentException("The field must be supported");
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    @Override // org.joda.time.d
    public long add(long j10, int i10) {
        return this.iField.add(j10, i10);
    }

    @Override // org.joda.time.d
    public long getDifferenceAsLong(long j10, long j11) {
        return this.iField.getDifferenceAsLong(j10, j11);
    }

    @Override // org.joda.time.d
    public long getMillis(int i10, long j10) {
        return this.iField.getMillis(i10, j10);
    }

    @Override // org.joda.time.d
    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10, long j11) {
        return this.iField.getValueAsLong(j10, j11);
    }

    public final org.joda.time.d getWrappedField() {
        return this.iField;
    }

    @Override // org.joda.time.d
    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    @Override // org.joda.time.d
    public long add(long j10, long j11) {
        return this.iField.add(j10, j11);
    }

    @Override // org.joda.time.d
    public long getMillis(long j10, long j11) {
        return this.iField.getMillis(j10, j11);
    }
}
