package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class YearMonth extends BasePartial {
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear()};
    public static final int MONTH_OF_YEAR = 1;
    public static final int YEAR = 0;
    private static final long serialVersionUID = 797544782896179L;

    public YearMonth() {
    }

    public static YearMonth fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new YearMonth(calendar.get(1), calendar.get(2) + 1);
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static YearMonth fromDateFields(Date date) {
        if (date != null) {
            return new YearMonth(date.getYear() + 1900, date.getMonth() + 1);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static YearMonth now() {
        return new YearMonth();
    }

    @FromString
    public static YearMonth parse(String str) {
        return parse(str, org.joda.time.format.i.m());
    }

    private Object readResolve() {
        return !DateTimeZone.UTC.equals(getChronology().getZone()) ? new YearMonth(this, getChronology().withUTC()) : this;
    }

    @Override // je.e
    public b getField(int i10, a aVar) {
        if (i10 == 0) {
            return aVar.year();
        }
        if (i10 == 1) {
            return aVar.monthOfYear();
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

    public YearMonth minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public YearMonth minusMonths(int i10) {
        return withFieldAdded(DurationFieldType.months(), org.joda.time.field.e.k(i10));
    }

    public YearMonth minusYears(int i10) {
        return withFieldAdded(DurationFieldType.years(), org.joda.time.field.e.k(i10));
    }

    public Property monthOfYear() {
        return new Property(this, 1);
    }

    public YearMonth plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public YearMonth plusMonths(int i10) {
        return withFieldAdded(DurationFieldType.months(), i10);
    }

    public YearMonth plusYears(int i10) {
        return withFieldAdded(DurationFieldType.years(), i10);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    @Override // org.joda.time.base.BasePartial, org.joda.time.k
    public int size() {
        return 2;
    }

    public Interval toInterval() {
        return toInterval(null);
    }

    public LocalDate toLocalDate(int i10) {
        return new LocalDate(getYear(), getMonthOfYear(), i10, getChronology());
    }

    @ToString
    public String toString() {
        return org.joda.time.format.i.t().l(this);
    }

    public YearMonth withChronologyRetainFields(a aVar) {
        a withUTC = c.c(aVar).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        YearMonth yearMonth = new YearMonth(this, withUTC);
        withUTC.validate(yearMonth, getValues());
        return yearMonth;
    }

    public YearMonth withField(DateTimeFieldType dateTimeFieldType, int i10) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i10 == getValue(indexOfSupported)) {
            return this;
        }
        return new YearMonth(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i10));
    }

    public YearMonth withFieldAdded(DurationFieldType durationFieldType, int i10) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i10 == 0) {
            return this;
        }
        return new YearMonth(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i10));
    }

    public YearMonth withMonthOfYear(int i10) {
        return new YearMonth(this, getChronology().monthOfYear().set(this, 1, getValues(), i10));
    }

    public YearMonth withPeriodAdded(l lVar, int i10) {
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
        return new YearMonth(this, values);
    }

    public YearMonth withYear(int i10) {
        return new YearMonth(this, getChronology().year().set(this, 0, getValues(), i10));
    }

    public Property year() {
        return new Property(this, 0);
    }

    public YearMonth(DateTimeZone dateTimeZone) {
        super(ISOChronology.getInstance(dateTimeZone));
    }

    public static YearMonth now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new YearMonth(dateTimeZone);
    }

    public static YearMonth parse(String str, org.joda.time.format.b bVar) {
        LocalDate g3 = bVar.g(str);
        return new YearMonth(g3.getYear(), g3.getMonthOfYear());
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        DateTimeZone m10 = c.m(dateTimeZone);
        return new Interval(toLocalDate(1).toDateTimeAtStartOfDay(m10), plusMonths(1).toLocalDate(1).toDateTimeAtStartOfDay(m10));
    }

    @Override // org.joda.time.base.BasePartial
    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final YearMonth iBase;
        private final int iFieldIndex;

        public Property(YearMonth yearMonth, int i10) {
            this.iBase = yearMonth;
            this.iFieldIndex = i10;
        }

        public YearMonth addToCopy(int i10) {
            return new YearMonth(this.iBase, getField().add(this.iBase, this.iFieldIndex, this.iBase.getValues(), i10));
        }

        public YearMonth addWrapFieldToCopy(int i10) {
            return new YearMonth(this.iBase, getField().addWrapField(this.iBase, this.iFieldIndex, this.iBase.getValues(), i10));
        }

        @Override // org.joda.time.field.a
        public int get() {
            return this.iBase.getValue(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public b getField() {
            return this.iBase.getField(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public k getReadablePartial() {
            return this.iBase;
        }

        public YearMonth getYearMonth() {
            return this.iBase;
        }

        public YearMonth setCopy(int i10) {
            return new YearMonth(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), i10));
        }

        public YearMonth setCopy(String str, Locale locale) {
            return new YearMonth(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), str, locale));
        }

        public YearMonth setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public YearMonth(a aVar) {
        super(aVar);
    }

    public YearMonth(long j10) {
        super(j10);
    }

    public static YearMonth now(a aVar) {
        Objects.requireNonNull(aVar, "Chronology must not be null");
        return new YearMonth(aVar);
    }

    @Override // org.joda.time.base.BasePartial
    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public YearMonth(long j10, a aVar) {
        super(j10, aVar);
    }

    public YearMonth(Object obj) {
        super(obj, null, org.joda.time.format.i.m());
    }

    public YearMonth(Object obj, a aVar) {
        super(obj, c.c(aVar), org.joda.time.format.i.m());
    }

    public YearMonth(int i10, int i11) {
        this(i10, i11, null);
    }

    public YearMonth(int i10, int i11, a aVar) {
        super(new int[]{i10, i11}, aVar);
    }

    public YearMonth(YearMonth yearMonth, int[] iArr) {
        super(yearMonth, iArr);
    }

    public YearMonth(YearMonth yearMonth, a aVar) {
        super((BasePartial) yearMonth, aVar);
    }
}
