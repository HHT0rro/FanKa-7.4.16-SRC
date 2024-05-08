package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ImpreciseDateTimeField extends b {

    /* renamed from: b, reason: collision with root package name */
    public final long f52527b;

    /* renamed from: c, reason: collision with root package name */
    public final org.joda.time.d f52528c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class LinkedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -203813474600094134L;

        public LinkedDurationField(DurationFieldType durationFieldType) {
            super(durationFieldType);
        }

        @Override // org.joda.time.d
        public long add(long j10, int i10) {
            return ImpreciseDateTimeField.this.add(j10, i10);
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
        public int getDifference(long j10, long j11) {
            return ImpreciseDateTimeField.this.getDifference(j10, j11);
        }

        @Override // org.joda.time.d
        public long getDifferenceAsLong(long j10, long j11) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j10, j11);
        }

        @Override // org.joda.time.d
        public long getMillis(int i10, long j10) {
            return ImpreciseDateTimeField.this.add(j10, i10) - j10;
        }

        @Override // org.joda.time.d
        public long getUnitMillis() {
            return ImpreciseDateTimeField.this.f52527b;
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
        public int getValue(long j10, long j11) {
            return ImpreciseDateTimeField.this.getDifference(j10 + j11, j11);
        }

        @Override // org.joda.time.d
        public long getValueAsLong(long j10, long j11) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j10 + j11, j11);
        }

        @Override // org.joda.time.d
        public boolean isPrecise() {
            return false;
        }

        @Override // org.joda.time.d
        public long add(long j10, long j11) {
            return ImpreciseDateTimeField.this.add(j10, j11);
        }

        @Override // org.joda.time.d
        public long getMillis(long j10, long j11) {
            return ImpreciseDateTimeField.this.add(j11, j10) - j11;
        }
    }

    public ImpreciseDateTimeField(DateTimeFieldType dateTimeFieldType, long j10) {
        super(dateTimeFieldType);
        this.f52527b = j10;
        this.f52528c = new LinkedDurationField(dateTimeFieldType.getDurationType());
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public abstract long add(long j10, int i10);

    @Override // org.joda.time.field.b, org.joda.time.b
    public abstract long add(long j10, long j11);

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getDifference(long j10, long j11) {
        return e.m(getDifferenceAsLong(j10, j11));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public abstract long getDifferenceAsLong(long j10, long j11);

    @Override // org.joda.time.field.b, org.joda.time.b
    public final org.joda.time.d getDurationField() {
        return this.f52528c;
    }
}
