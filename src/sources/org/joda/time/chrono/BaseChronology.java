package org.joda.time.chrono;

import java.io.Serializable;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseChronology extends org.joda.time.a implements Serializable {
    private static final long serialVersionUID = -7310865996721419676L;

    @Override // org.joda.time.a
    public long add(org.joda.time.l lVar, long j10, int i10) {
        if (i10 != 0 && lVar != null) {
            int size = lVar.size();
            for (int i11 = 0; i11 < size; i11++) {
                long value = lVar.getValue(i11);
                if (value != 0) {
                    j10 = lVar.getFieldType(i11).getField(this).add(j10, value * i10);
                }
            }
        }
        return j10;
    }

    @Override // org.joda.time.a
    public org.joda.time.d centuries() {
        return UnsupportedDurationField.getInstance(DurationFieldType.centuries());
    }

    @Override // org.joda.time.a
    public org.joda.time.b centuryOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.centuryOfEra(), centuries());
    }

    @Override // org.joda.time.a
    public org.joda.time.b clockhourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfDay(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.b clockhourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfHalfday(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.b dayOfMonth() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfMonth(), days());
    }

    @Override // org.joda.time.a
    public org.joda.time.b dayOfWeek() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfWeek(), days());
    }

    @Override // org.joda.time.a
    public org.joda.time.b dayOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfYear(), days());
    }

    @Override // org.joda.time.a
    public org.joda.time.d days() {
        return UnsupportedDurationField.getInstance(DurationFieldType.days());
    }

    @Override // org.joda.time.a
    public org.joda.time.b era() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.era(), eras());
    }

    @Override // org.joda.time.a
    public org.joda.time.d eras() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    @Override // org.joda.time.a
    public int[] get(org.joda.time.k kVar, long j10) {
        int size = kVar.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = kVar.getFieldType(i10).getField(this).get(j10);
        }
        return iArr;
    }

    @Override // org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        return millisOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0L, i10), i11), i12), i13);
    }

    @Override // org.joda.time.a
    public abstract DateTimeZone getZone();

    @Override // org.joda.time.a
    public org.joda.time.b halfdayOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.halfdayOfDay(), halfdays());
    }

    @Override // org.joda.time.a
    public org.joda.time.d halfdays() {
        return UnsupportedDurationField.getInstance(DurationFieldType.halfdays());
    }

    @Override // org.joda.time.a
    public org.joda.time.b hourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfDay(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.b hourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfHalfday(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.d hours() {
        return UnsupportedDurationField.getInstance(DurationFieldType.hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.d millis() {
        return UnsupportedDurationField.getInstance(DurationFieldType.millis());
    }

    @Override // org.joda.time.a
    public org.joda.time.b millisOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfDay(), millis());
    }

    @Override // org.joda.time.a
    public org.joda.time.b millisOfSecond() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfSecond(), millis());
    }

    @Override // org.joda.time.a
    public org.joda.time.b minuteOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfDay(), minutes());
    }

    @Override // org.joda.time.a
    public org.joda.time.b minuteOfHour() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfHour(), minutes());
    }

    @Override // org.joda.time.a
    public org.joda.time.d minutes() {
        return UnsupportedDurationField.getInstance(DurationFieldType.minutes());
    }

    @Override // org.joda.time.a
    public org.joda.time.b monthOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.monthOfYear(), months());
    }

    @Override // org.joda.time.a
    public org.joda.time.d months() {
        return UnsupportedDurationField.getInstance(DurationFieldType.months());
    }

    @Override // org.joda.time.a
    public org.joda.time.b secondOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfDay(), seconds());
    }

    @Override // org.joda.time.a
    public org.joda.time.b secondOfMinute() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfMinute(), seconds());
    }

    @Override // org.joda.time.a
    public org.joda.time.d seconds() {
        return UnsupportedDurationField.getInstance(DurationFieldType.seconds());
    }

    @Override // org.joda.time.a
    public long set(org.joda.time.k kVar, long j10) {
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            j10 = kVar.getFieldType(i10).getField(this).set(j10, kVar.getValue(i10));
        }
        return j10;
    }

    @Override // org.joda.time.a
    public abstract String toString();

    @Override // org.joda.time.a
    public void validate(org.joda.time.k kVar, int[] iArr) {
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            int i11 = iArr[i10];
            org.joda.time.b field = kVar.getField(i10);
            if (i11 >= field.getMinimumValue()) {
                if (i11 > field.getMaximumValue()) {
                    throw new IllegalFieldValueException(field.getType(), Integer.valueOf(i11), (Number) null, Integer.valueOf(field.getMaximumValue()));
                }
            } else {
                throw new IllegalFieldValueException(field.getType(), Integer.valueOf(i11), Integer.valueOf(field.getMinimumValue()), (Number) null);
            }
        }
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            org.joda.time.b field2 = kVar.getField(i12);
            if (i13 >= field2.getMinimumValue(kVar, iArr)) {
                if (i13 > field2.getMaximumValue(kVar, iArr)) {
                    throw new IllegalFieldValueException(field2.getType(), Integer.valueOf(i13), (Number) null, Integer.valueOf(field2.getMaximumValue(kVar, iArr)));
                }
            } else {
                throw new IllegalFieldValueException(field2.getType(), Integer.valueOf(i13), Integer.valueOf(field2.getMinimumValue(kVar, iArr)), (Number) null);
            }
        }
    }

    @Override // org.joda.time.a
    public org.joda.time.b weekOfWeekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekOfWeekyear(), weeks());
    }

    @Override // org.joda.time.a
    public org.joda.time.d weeks() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weeks());
    }

    @Override // org.joda.time.a
    public org.joda.time.b weekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyear(), weekyears());
    }

    @Override // org.joda.time.a
    public org.joda.time.b weekyearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyearOfCentury(), weekyears());
    }

    @Override // org.joda.time.a
    public org.joda.time.d weekyears() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weekyears());
    }

    @Override // org.joda.time.a
    public abstract org.joda.time.a withUTC();

    @Override // org.joda.time.a
    public abstract org.joda.time.a withZone(DateTimeZone dateTimeZone);

    @Override // org.joda.time.a
    public org.joda.time.b year() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.year(), years());
    }

    @Override // org.joda.time.a
    public org.joda.time.b yearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfCentury(), years());
    }

    @Override // org.joda.time.a
    public org.joda.time.b yearOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfEra(), years());
    }

    @Override // org.joda.time.a
    public org.joda.time.d years() {
        return UnsupportedDurationField.getInstance(DurationFieldType.years());
    }

    @Override // org.joda.time.a
    public long add(long j10, long j11, int i10) {
        return (j11 == 0 || i10 == 0) ? j10 : org.joda.time.field.e.e(j10, org.joda.time.field.e.i(j11, i10));
    }

    @Override // org.joda.time.a
    public int[] get(org.joda.time.l lVar, long j10, long j11) {
        int size = lVar.size();
        int[] iArr = new int[size];
        if (j10 != j11) {
            for (int i10 = 0; i10 < size; i10++) {
                org.joda.time.d field = lVar.getFieldType(i10).getField(this);
                int difference = field.getDifference(j11, j10);
                if (difference != 0) {
                    j10 = field.add(j10, difference);
                }
                iArr[i10] = difference;
            }
        }
        return iArr;
    }

    @Override // org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13, int i14, int i15, int i16) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0L, i10), i11), i12), i13), i14), i15), i16);
    }

    @Override // org.joda.time.a
    public int[] get(org.joda.time.l lVar, long j10) {
        int size = lVar.size();
        int[] iArr = new int[size];
        long j11 = 0;
        if (j10 != 0) {
            for (int i10 = 0; i10 < size; i10++) {
                org.joda.time.d field = lVar.getFieldType(i10).getField(this);
                if (field.isPrecise()) {
                    int difference = field.getDifference(j10, j11);
                    j11 = field.add(j11, difference);
                    iArr[i10] = difference;
                }
            }
        }
        return iArr;
    }

    @Override // org.joda.time.a
    public long getDateTimeMillis(long j10, int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(j10, i10), i11), i12), i13);
    }
}
