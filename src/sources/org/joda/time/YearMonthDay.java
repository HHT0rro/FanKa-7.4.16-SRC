package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class YearMonthDay extends BasePartial {
    public static final int DAY_OF_MONTH = 2;
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
    public static final int MONTH_OF_YEAR = 1;
    public static final int YEAR = 0;
    private static final long serialVersionUID = 797544782896179L;

    public YearMonthDay() {
    }

    public static YearMonthDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new YearMonthDay(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static YearMonthDay fromDateFields(Date date) {
        if (date != null) {
            return new YearMonthDay(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public Property dayOfMonth() {
        return new Property(this, 2);
    }

    public int getDayOfMonth() {
        return getValue(2);
    }

    @Override // je.e
    public b getField(int i10, a aVar) {
        if (i10 == 0) {
            return aVar.year();
        }
        if (i10 == 1) {
            return aVar.monthOfYear();
        }
        if (i10 == 2) {
            return aVar.dayOfMonth();
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

    public int getMonthOfYear() {
        return getValue(1);
    }

    public int getYear() {
        return getValue(0);
    }

    public YearMonthDay minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public YearMonthDay minusDays(int i10) {
        return withFieldAdded(DurationFieldType.days(), org.joda.time.field.e.k(i10));
    }

    public YearMonthDay minusMonths(int i10) {
        return withFieldAdded(DurationFieldType.months(), org.joda.time.field.e.k(i10));
    }

    public YearMonthDay minusYears(int i10) {
        return withFieldAdded(DurationFieldType.years(), org.joda.time.field.e.k(i10));
    }

    public Property monthOfYear() {
        return new Property(this, 1);
    }

    public YearMonthDay plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public YearMonthDay plusDays(int i10) {
        return withFieldAdded(DurationFieldType.days(), i10);
    }

    public YearMonthDay plusMonths(int i10) {
        return withFieldAdded(DurationFieldType.months(), i10);
    }

    public YearMonthDay plusYears(int i10) {
        return withFieldAdded(DurationFieldType.years(), i10);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    @Override // org.joda.time.base.BasePartial, org.joda.time.k
    public int size() {
        return 3;
    }

    public DateMidnight toDateMidnight() {
        return toDateMidnight(null);
    }

    public DateTime toDateTime(TimeOfDay timeOfDay) {
        return toDateTime(timeOfDay, null);
    }

    public DateTime toDateTimeAtCurrentTime() {
        return toDateTimeAtCurrentTime(null);
    }

    public DateTime toDateTimeAtMidnight() {
        return toDateTimeAtMidnight(null);
    }

    public Interval toInterval() {
        return toInterval(null);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology());
    }

    public String toString() {
        return org.joda.time.format.i.u().l(this);
    }

    public YearMonthDay withChronologyRetainFields(a aVar) {
        a withUTC = c.c(aVar).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        YearMonthDay yearMonthDay = new YearMonthDay(this, withUTC);
        withUTC.validate(yearMonthDay, getValues());
        return yearMonthDay;
    }

    public YearMonthDay withDayOfMonth(int i10) {
        return new YearMonthDay(this, getChronology().dayOfMonth().set(this, 2, getValues(), i10));
    }

    public YearMonthDay withField(DateTimeFieldType dateTimeFieldType, int i10) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i10 == getValue(indexOfSupported)) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i10));
    }

    public YearMonthDay withFieldAdded(DurationFieldType durationFieldType, int i10) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i10 == 0) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i10));
    }

    public YearMonthDay withMonthOfYear(int i10) {
        return new YearMonthDay(this, getChronology().monthOfYear().set(this, 1, getValues(), i10));
    }

    public YearMonthDay withPeriodAdded(l lVar, int i10) {
        if (lVar == null || i10 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i11 = 0; i11 < lVar.size(); i11++) {
            int indexOf = indexOf(lVar.getFieldType(i11));
            if (indexOf >= 0) {
                values = getField(indexOf).add(this, indexOf, values, org.joda.time.field.e.h(lVar.getValue(i11), i10));
            }
        }
        return new YearMonthDay(this, values);
    }

    public YearMonthDay withYear(int i10) {
        return new YearMonthDay(this, getChronology().year().set(this, 0, getValues(), i10));
    }

    public Property year() {
        return new Property(this, 0);
    }

    public YearMonthDay(DateTimeZone dateTimeZone) {
        super(ISOChronology.getInstance(dateTimeZone));
    }

    public DateMidnight toDateMidnight(DateTimeZone dateTimeZone) {
        return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology().withZone(dateTimeZone));
    }

    public DateTime toDateTime(TimeOfDay timeOfDay, DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        long j10 = withZone.set(this, c.b());
        if (timeOfDay != null) {
            j10 = withZone.set(timeOfDay, j10);
        }
        return new DateTime(j10, withZone);
    }

    public DateTime toDateTimeAtCurrentTime(DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, c.b()), withZone);
    }

    public DateTime toDateTimeAtMidnight(DateTimeZone dateTimeZone) {
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, getChronology().withZone(dateTimeZone));
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        return toDateMidnight(c.m(dateTimeZone)).toInterval();
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final int iFieldIndex;
        private final YearMonthDay iYearMonthDay;

        public Property(YearMonthDay yearMonthDay, int i10) {
            this.iYearMonthDay = yearMonthDay;
            this.iFieldIndex = i10;
        }

        public YearMonthDay addToCopy(int i10) {
            return new YearMonthDay(this.iYearMonthDay, getField().add(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i10));
        }

        public YearMonthDay addWrapFieldToCopy(int i10) {
            return new YearMonthDay(this.iYearMonthDay, getField().addWrapField(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i10));
        }

        @Override // org.joda.time.field.a
        public int get() {
            return this.iYearMonthDay.getValue(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public b getField() {
            return this.iYearMonthDay.getField(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public k getReadablePartial() {
            return this.iYearMonthDay;
        }

        public YearMonthDay getYearMonthDay() {
            return this.iYearMonthDay;
        }

        public YearMonthDay setCopy(int i10) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i10));
        }

        public YearMonthDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public YearMonthDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public YearMonthDay setCopy(String str, Locale locale) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), str, locale));
        }

        public YearMonthDay setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public YearMonthDay(a aVar) {
        super(aVar);
    }

    public YearMonthDay(long j10) {
        super(j10);
    }

    public YearMonthDay(long j10, a aVar) {
        super(j10, aVar);
    }

    public YearMonthDay(Object obj) {
        super(obj, null, org.joda.time.format.i.g());
    }

    public YearMonthDay(Object obj, a aVar) {
        super(obj, c.c(aVar), org.joda.time.format.i.g());
    }

    public YearMonthDay(int i10, int i11, int i12) {
        this(i10, i11, i12, null);
    }

    public YearMonthDay(int i10, int i11, int i12, a aVar) {
        super(new int[]{i10, i11, i12}, aVar);
    }

    public YearMonthDay(YearMonthDay yearMonthDay, int[] iArr) {
        super(yearMonthDay, iArr);
    }

    public YearMonthDay(YearMonthDay yearMonthDay, a aVar) {
        super((BasePartial) yearMonthDay, aVar);
    }
}
