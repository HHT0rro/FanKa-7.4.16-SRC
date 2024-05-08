package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnsupportedDateTimeField extends org.joda.time.b implements Serializable {
    private static HashMap<DateTimeFieldType, UnsupportedDateTimeField> cCache = null;
    private static final long serialVersionUID = -1934618396111902255L;
    private final org.joda.time.d iDurationField;
    private final DateTimeFieldType iType;

    private UnsupportedDateTimeField(DateTimeFieldType dateTimeFieldType, org.joda.time.d dVar) {
        if (dateTimeFieldType != null && dVar != null) {
            this.iType = dateTimeFieldType;
            this.iDurationField = dVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static synchronized UnsupportedDateTimeField getInstance(DateTimeFieldType dateTimeFieldType, org.joda.time.d dVar) {
        UnsupportedDateTimeField unsupportedDateTimeField;
        synchronized (UnsupportedDateTimeField.class) {
            HashMap<DateTimeFieldType, UnsupportedDateTimeField> hashMap = cCache;
            unsupportedDateTimeField = null;
            if (hashMap == null) {
                cCache = new HashMap<>(7);
            } else {
                UnsupportedDateTimeField unsupportedDateTimeField2 = hashMap.get(dateTimeFieldType);
                if (unsupportedDateTimeField2 == null || unsupportedDateTimeField2.getDurationField() == dVar) {
                    unsupportedDateTimeField = unsupportedDateTimeField2;
                }
            }
            if (unsupportedDateTimeField == null) {
                unsupportedDateTimeField = new UnsupportedDateTimeField(dateTimeFieldType, dVar);
                cCache.put(dateTimeFieldType, unsupportedDateTimeField);
            }
        }
        return unsupportedDateTimeField;
    }

    private Object readResolve() {
        return getInstance(this.iType, this.iDurationField);
    }

    private UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException(((Object) this.iType) + " field is unsupported");
    }

    @Override // org.joda.time.b
    public long add(long j10, int i10) {
        return getDurationField().add(j10, i10);
    }

    @Override // org.joda.time.b
    public long addWrapField(long j10, int i10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int[] addWrapPartial(k kVar, int i10, int[] iArr, int i11) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int get(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j10, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsText(long j10, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getDifference(long j10, long j11) {
        return getDurationField().getDifference(j10, j11);
    }

    @Override // org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        return getDurationField().getDifferenceAsLong(j10, j11);
    }

    @Override // org.joda.time.b
    public org.joda.time.d getDurationField() {
        return this.iDurationField;
    }

    @Override // org.joda.time.b
    public int getLeapAmount(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public org.joda.time.d getLeapDurationField() {
        return null;
    }

    @Override // org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMaximumValue() {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMinimumValue() {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return null;
    }

    @Override // org.joda.time.b
    public DateTimeFieldType getType() {
        return this.iType;
    }

    @Override // org.joda.time.b
    public boolean isLeap(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.b
    public boolean isSupported() {
        return false;
    }

    @Override // org.joda.time.b
    public long remainder(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long roundCeiling(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long roundFloor(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long roundHalfCeiling(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long roundHalfEven(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long roundHalfFloor(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long set(long j10, int i10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String toString() {
        return "UnsupportedDateTimeField";
    }

    @Override // org.joda.time.b
    public long add(long j10, long j11) {
        return getDurationField().add(j10, j11);
    }

    @Override // org.joda.time.b
    public int[] addWrapField(k kVar, int i10, int[] iArr, int i11) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsText(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMaximumValue(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(long j10) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int[] set(k kVar, int i10, int[] iArr, int i11) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int[] add(k kVar, int i10, int[] iArr, int i11) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsShortText(k kVar, int i10, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsText(k kVar, int i10, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMaximumValue(k kVar) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(k kVar) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long set(long j10, String str, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsShortText(k kVar, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsText(k kVar, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMaximumValue(k kVar, int[] iArr) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(k kVar, int[] iArr) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public long set(long j10, String str) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsShortText(int i10, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public String getAsText(int i10, Locale locale) {
        throw unsupported();
    }

    @Override // org.joda.time.b
    public int[] set(k kVar, int i10, int[] iArr, String str, Locale locale) {
        throw unsupported();
    }
}
