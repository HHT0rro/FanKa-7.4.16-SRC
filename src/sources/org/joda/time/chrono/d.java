package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.UnsupportedDurationField;

/* compiled from: BasicSingleEraDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d extends org.joda.time.field.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f52500b;

    public d(String str) {
        super(DateTimeFieldType.era());
        this.f52500b = str;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public String getAsText(int i10, Locale locale) {
        return this.f52500b;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getDurationField() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        return this.f52500b.length();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
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
        return Long.MAX_VALUE;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundFloor(long j10) {
        return Long.MIN_VALUE;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfCeiling(long j10) {
        return Long.MIN_VALUE;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfEven(long j10) {
        return Long.MIN_VALUE;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfFloor(long j10) {
        return Long.MIN_VALUE;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        org.joda.time.field.e.n(this, i10, 1, 1);
        return j10;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, String str, Locale locale) {
        if (this.f52500b.equals(str) || "1".equals(str)) {
            return j10;
        }
        throw new IllegalFieldValueException(DateTimeFieldType.era(), str);
    }
}
