package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.field.UnsupportedDurationField;

/* compiled from: GJEraDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j extends org.joda.time.field.b {

    /* renamed from: b, reason: collision with root package name */
    public final BasicChronology f52508b;

    public j(BasicChronology basicChronology) {
        super(DateTimeFieldType.era());
        this.f52508b = basicChronology;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52508b.getYear(j10) <= 0 ? 0 : 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsText(int i10, Locale locale) {
        return k.h(locale).g(i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getDurationField() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        return k.h(locale).k();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 0;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return null;
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j10) {
        if (get(j10) == 0) {
            return this.f52508b.setYear(0L, 1);
        }
        return Long.MAX_VALUE;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundFloor(long j10) {
        if (get(j10) == 1) {
            return this.f52508b.setYear(0L, 1);
        }
        return Long.MIN_VALUE;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfCeiling(long j10) {
        return roundFloor(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfEven(long j10) {
        return roundFloor(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfFloor(long j10) {
        return roundFloor(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        org.joda.time.field.e.n(this, i10, 0, 1);
        if (get(j10) == i10) {
            return j10;
        }
        return this.f52508b.setYear(j10, -this.f52508b.getYear(j10));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, String str, Locale locale) {
        return set(j10, k.h(locale).f(str));
    }
}
