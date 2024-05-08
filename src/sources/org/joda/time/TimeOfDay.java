package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TimeOfDay extends BasePartial {
    public static final int HOUR_OF_DAY = 0;
    public static final int MILLIS_OF_SECOND = 3;
    public static final int MINUTE_OF_HOUR = 1;
    public static final int SECOND_OF_MINUTE = 2;
    private static final long serialVersionUID = 3633353405803318660L;
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(), DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond()};
    public static final TimeOfDay MIDNIGHT = new TimeOfDay(0, 0, 0, 0);

    public TimeOfDay() {
    }

    public static TimeOfDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new TimeOfDay(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static TimeOfDay fromDateFields(Date date) {
        if (date != null) {
            return new TimeOfDay(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static TimeOfDay fromMillisOfDay(long j10) {
        return fromMillisOfDay(j10, null);
    }

    @Override // je.e
    public b getField(int i10, a aVar) {
        if (i10 == 0) {
            return aVar.hourOfDay();
        }
        if (i10 == 1) {
            return aVar.minuteOfHour();
        }
        if (i10 == 2) {
            return aVar.secondOfMinute();
        }
        if (i10 == 3) {
            return aVar.millisOfSecond();
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i10);
    }

    @Override // je.e, org.joda.time.k
    public DateTimeFieldType getFieldType(int i10) {
        return FIELD_TYPES[i10];
    }

    @Override // je.e
    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) FIELD_TYPES.clone();
    }

    public int getHourOfDay() {
        return getValue(0);
    }

    public int getMillisOfSecond() {
        return getValue(3);
    }

    public int getMinuteOfHour() {
        return getValue(1);
    }

    public int getSecondOfMinute() {
        return getValue(2);
    }

    public Property hourOfDay() {
        return new Property(this, 0);
    }

    public Property millisOfSecond() {
        return new Property(this, 3);
    }

    public TimeOfDay minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public TimeOfDay minusHours(int i10) {
        return withFieldAdded(DurationFieldType.hours(), org.joda.time.field.e.k(i10));
    }

    public TimeOfDay minusMillis(int i10) {
        return withFieldAdded(DurationFieldType.millis(), org.joda.time.field.e.k(i10));
    }

    public TimeOfDay minusMinutes(int i10) {
        return withFieldAdded(DurationFieldType.minutes(), org.joda.time.field.e.k(i10));
    }

    public TimeOfDay minusSeconds(int i10) {
        return withFieldAdded(DurationFieldType.seconds(), org.joda.time.field.e.k(i10));
    }

    public Property minuteOfHour() {
        return new Property(this, 1);
    }

    public TimeOfDay plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public TimeOfDay plusHours(int i10) {
        return withFieldAdded(DurationFieldType.hours(), i10);
    }

    public TimeOfDay plusMillis(int i10) {
        return withFieldAdded(DurationFieldType.millis(), i10);
    }

    public TimeOfDay plusMinutes(int i10) {
        return withFieldAdded(DurationFieldType.minutes(), i10);
    }

    public TimeOfDay plusSeconds(int i10) {
        return withFieldAdded(DurationFieldType.seconds(), i10);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public Property secondOfMinute() {
        return new Property(this, 2);
    }

    @Override // org.joda.time.base.BasePartial, org.joda.time.k
    public int size() {
        return 4;
    }

    public DateTime toDateTimeToday() {
        return toDateTimeToday(null);
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), getChronology());
    }

    public String toString() {
        return org.joda.time.format.i.o().l(this);
    }

    public TimeOfDay withChronologyRetainFields(a aVar) {
        a withUTC = c.c(aVar).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        TimeOfDay timeOfDay = new TimeOfDay(this, withUTC);
        withUTC.validate(timeOfDay, getValues());
        return timeOfDay;
    }

    public TimeOfDay withField(DateTimeFieldType dateTimeFieldType, int i10) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i10 == getValue(indexOfSupported)) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i10));
    }

    public TimeOfDay withFieldAdded(DurationFieldType durationFieldType, int i10) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i10 == 0) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).addWrapPartial(this, indexOfSupported, getValues(), i10));
    }

    public TimeOfDay withHourOfDay(int i10) {
        return new TimeOfDay(this, getChronology().hourOfDay().set(this, 0, getValues(), i10));
    }

    public TimeOfDay withMillisOfSecond(int i10) {
        return new TimeOfDay(this, getChronology().millisOfSecond().set(this, 3, getValues(), i10));
    }

    public TimeOfDay withMinuteOfHour(int i10) {
        return new TimeOfDay(this, getChronology().minuteOfHour().set(this, 1, getValues(), i10));
    }

    public TimeOfDay withPeriodAdded(l lVar, int i10) {
        if (lVar == null || i10 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i11 = 0; i11 < lVar.size(); i11++) {
            int indexOf = indexOf(lVar.getFieldType(i11));
            if (indexOf >= 0) {
                values = getField(indexOf).addWrapPartial(this, indexOf, values, org.joda.time.field.e.h(lVar.getValue(i11), i10));
            }
        }
        return new TimeOfDay(this, values);
    }

    public TimeOfDay withSecondOfMinute(int i10) {
        return new TimeOfDay(this, getChronology().secondOfMinute().set(this, 2, getValues(), i10));
    }

    public TimeOfDay(DateTimeZone dateTimeZone) {
        super(ISOChronology.getInstance(dateTimeZone));
    }

    public static TimeOfDay fromMillisOfDay(long j10, a aVar) {
        return new TimeOfDay(j10, c.c(aVar).withUTC());
    }

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, c.b()), withZone);
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5598459141741063833L;
        private final int iFieldIndex;
        private final TimeOfDay iTimeOfDay;

        public Property(TimeOfDay timeOfDay, int i10) {
            this.iTimeOfDay = timeOfDay;
            this.iFieldIndex = i10;
        }

        public TimeOfDay addNoWrapToCopy(int i10) {
            return new TimeOfDay(this.iTimeOfDay, getField().add(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i10));
        }

        public TimeOfDay addToCopy(int i10) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapPartial(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i10));
        }

        public TimeOfDay addWrapFieldToCopy(int i10) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapField(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i10));
        }

        @Override // org.joda.time.field.a
        public int get() {
            return this.iTimeOfDay.getValue(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public b getField() {
            return this.iTimeOfDay.getField(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public k getReadablePartial() {
            return this.iTimeOfDay;
        }

        public TimeOfDay getTimeOfDay() {
            return this.iTimeOfDay;
        }

        public TimeOfDay setCopy(int i10) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i10));
        }

        public TimeOfDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public TimeOfDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public TimeOfDay setCopy(String str, Locale locale) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), str, locale));
        }

        public TimeOfDay setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public TimeOfDay(a aVar) {
        super(aVar);
    }

    public TimeOfDay(long j10) {
        super(j10);
    }

    public TimeOfDay(long j10, a aVar) {
        super(j10, aVar);
    }

    public TimeOfDay(Object obj) {
        super(obj, null, org.joda.time.format.i.r());
    }

    public TimeOfDay(Object obj, a aVar) {
        super(obj, c.c(aVar), org.joda.time.format.i.r());
    }

    public TimeOfDay(int i10, int i11) {
        this(i10, i11, 0, 0, null);
    }

    public TimeOfDay(int i10, int i11, a aVar) {
        this(i10, i11, 0, 0, aVar);
    }

    public TimeOfDay(int i10, int i11, int i12) {
        this(i10, i11, i12, 0, null);
    }

    public TimeOfDay(int i10, int i11, int i12, a aVar) {
        this(i10, i11, i12, 0, aVar);
    }

    public TimeOfDay(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, null);
    }

    public TimeOfDay(int i10, int i11, int i12, int i13, a aVar) {
        super(new int[]{i10, i11, i12, i13}, aVar);
    }

    public TimeOfDay(TimeOfDay timeOfDay, int[] iArr) {
        super(timeOfDay, iArr);
    }

    public TimeOfDay(TimeOfDay timeOfDay, a aVar) {
        super((BasePartial) timeOfDay, aVar);
    }
}
