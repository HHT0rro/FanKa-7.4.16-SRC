package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.k;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DelegatedDateTimeField extends org.joda.time.b implements Serializable {
    private static final long serialVersionUID = -4730164440214502503L;
    private final org.joda.time.b iField;
    private final org.joda.time.d iRangeDurationField;
    private final DateTimeFieldType iType;

    public DelegatedDateTimeField(org.joda.time.b bVar) {
        this(bVar, null);
    }

    @Override // org.joda.time.b
    public long add(long j10, int i10) {
        return this.iField.add(j10, i10);
    }

    @Override // org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return this.iField.addWrapField(j10, i10);
    }

    @Override // org.joda.time.b
    public int[] addWrapPartial(k kVar, int i10, int[] iArr, int i11) {
        return this.iField.addWrapPartial(kVar, i10, iArr, i11);
    }

    @Override // org.joda.time.b
    public int get(long j10) {
        return this.iField.get(j10);
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j10, Locale locale) {
        return this.iField.getAsShortText(j10, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(long j10, Locale locale) {
        return this.iField.getAsText(j10, locale);
    }

    @Override // org.joda.time.b
    public int getDifference(long j10, long j11) {
        return this.iField.getDifference(j10, j11);
    }

    @Override // org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        return this.iField.getDifferenceAsLong(j10, j11);
    }

    @Override // org.joda.time.b
    public org.joda.time.d getDurationField() {
        return this.iField.getDurationField();
    }

    @Override // org.joda.time.b
    public int getLeapAmount(long j10) {
        return this.iField.getLeapAmount(j10);
    }

    @Override // org.joda.time.b
    public org.joda.time.d getLeapDurationField() {
        return this.iField.getLeapDurationField();
    }

    @Override // org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        return this.iField.getMaximumShortTextLength(locale);
    }

    @Override // org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        return this.iField.getMaximumTextLength(locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    @Override // org.joda.time.b
    public int getMinimumValue() {
        return this.iField.getMinimumValue();
    }

    @Override // org.joda.time.b
    public String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        org.joda.time.d dVar = this.iRangeDurationField;
        return dVar != null ? dVar : this.iField.getRangeDurationField();
    }

    @Override // org.joda.time.b
    public DateTimeFieldType getType() {
        return this.iType;
    }

    public final org.joda.time.b getWrappedField() {
        return this.iField;
    }

    @Override // org.joda.time.b
    public boolean isLeap(long j10) {
        return this.iField.isLeap(j10);
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return this.iField.isLenient();
    }

    @Override // org.joda.time.b
    public boolean isSupported() {
        return this.iField.isSupported();
    }

    @Override // org.joda.time.b
    public long remainder(long j10) {
        return this.iField.remainder(j10);
    }

    @Override // org.joda.time.b
    public long roundCeiling(long j10) {
        return this.iField.roundCeiling(j10);
    }

    @Override // org.joda.time.b
    public long roundFloor(long j10) {
        return this.iField.roundFloor(j10);
    }

    @Override // org.joda.time.b
    public long roundHalfCeiling(long j10) {
        return this.iField.roundHalfCeiling(j10);
    }

    @Override // org.joda.time.b
    public long roundHalfEven(long j10) {
        return this.iField.roundHalfEven(j10);
    }

    @Override // org.joda.time.b
    public long roundHalfFloor(long j10) {
        return this.iField.roundHalfFloor(j10);
    }

    @Override // org.joda.time.b
    public long set(long j10, int i10) {
        return this.iField.set(j10, i10);
    }

    @Override // org.joda.time.b
    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }

    public DelegatedDateTimeField(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType) {
        this(bVar, null, dateTimeFieldType);
    }

    @Override // org.joda.time.b
    public long add(long j10, long j11) {
        return this.iField.add(j10, j11);
    }

    @Override // org.joda.time.b
    public int[] addWrapField(k kVar, int i10, int[] iArr, int i11) {
        return this.iField.addWrapField(kVar, i10, iArr, i11);
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j10) {
        return this.iField.getAsShortText(j10);
    }

    @Override // org.joda.time.b
    public String getAsText(long j10) {
        return this.iField.getAsText(j10);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(long j10) {
        return this.iField.getMaximumValue(j10);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(long j10) {
        return this.iField.getMinimumValue(j10);
    }

    @Override // org.joda.time.b
    public long set(long j10, String str, Locale locale) {
        return this.iField.set(j10, str, locale);
    }

    public DelegatedDateTimeField(org.joda.time.b bVar, org.joda.time.d dVar, DateTimeFieldType dateTimeFieldType) {
        if (bVar != null) {
            this.iField = bVar;
            this.iRangeDurationField = dVar;
            this.iType = dateTimeFieldType == null ? bVar.getType() : dateTimeFieldType;
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    @Override // org.joda.time.b
    public int[] add(k kVar, int i10, int[] iArr, int i11) {
        return this.iField.add(kVar, i10, iArr, i11);
    }

    @Override // org.joda.time.b
    public String getAsShortText(k kVar, int i10, Locale locale) {
        return this.iField.getAsShortText(kVar, i10, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(k kVar, int i10, Locale locale) {
        return this.iField.getAsText(kVar, i10, locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(k kVar) {
        return this.iField.getMaximumValue(kVar);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(k kVar) {
        return this.iField.getMinimumValue(kVar);
    }

    @Override // org.joda.time.b
    public long set(long j10, String str) {
        return this.iField.set(j10, str);
    }

    @Override // org.joda.time.b
    public String getAsShortText(k kVar, Locale locale) {
        return this.iField.getAsShortText(kVar, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(k kVar, Locale locale) {
        return this.iField.getAsText(kVar, locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(k kVar, int[] iArr) {
        return this.iField.getMaximumValue(kVar, iArr);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(k kVar, int[] iArr) {
        return this.iField.getMinimumValue(kVar, iArr);
    }

    @Override // org.joda.time.b
    public int[] set(k kVar, int i10, int[] iArr, int i11) {
        return this.iField.set(kVar, i10, iArr, i11);
    }

    @Override // org.joda.time.b
    public String getAsShortText(int i10, Locale locale) {
        return this.iField.getAsShortText(i10, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(int i10, Locale locale) {
        return this.iField.getAsText(i10, locale);
    }

    @Override // org.joda.time.b
    public int[] set(k kVar, int i10, int[] iArr, String str, Locale locale) {
        return this.iField.set(kVar, i10, iArr, str, locale);
    }
}
