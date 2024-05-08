package org.joda.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormatterBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MonthDay extends BasePartial {
    public static final int DAY_OF_MONTH = 1;
    public static final int MONTH_OF_YEAR = 0;
    private static final long serialVersionUID = 2954560699050434609L;
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
    private static final org.joda.time.format.b PARSER = new DateTimeFormatterBuilder().E(org.joda.time.format.i.m().b()).E(org.joda.time.format.a.b("--MM-dd").b()).e0();

    public MonthDay() {
    }

    public static MonthDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new MonthDay(calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static MonthDay fromDateFields(Date date) {
        if (date != null) {
            return new MonthDay(date.getMonth() + 1, date.getDate());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static MonthDay now() {
        return new MonthDay();
    }

    @FromString
    public static MonthDay parse(String str) {
        return parse(str, PARSER);
    }

    private Object readResolve() {
        return !DateTimeZone.UTC.equals(getChronology().getZone()) ? new MonthDay(this, getChronology().withUTC()) : this;
    }

    public Property dayOfMonth() {
        return new Property(this, 1);
    }

    public int getDayOfMonth() {
        return getValue(1);
    }

    @Override // je.e
    public b getField(int i10, a aVar) {
        if (i10 == 0) {
            return aVar.monthOfYear();
        }
        if (i10 == 1) {
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
        return getValue(0);
    }

    public MonthDay minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public MonthDay minusDays(int i10) {
        return withFieldAdded(DurationFieldType.days(), org.joda.time.field.e.k(i10));
    }

    public MonthDay minusMonths(int i10) {
        return withFieldAdded(DurationFieldType.months(), org.joda.time.field.e.k(i10));
    }

    public Property monthOfYear() {
        return new Property(this, 0);
    }

    public MonthDay plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public MonthDay plusDays(int i10) {
        return withFieldAdded(DurationFieldType.days(), i10);
    }

    public MonthDay plusMonths(int i10) {
        return withFieldAdded(DurationFieldType.months(), i10);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    @Override // org.joda.time.base.BasePartial, org.joda.time.k
    public int size() {
        return 2;
    }

    public LocalDate toLocalDate(int i10) {
        return new LocalDate(i10, getMonthOfYear(), getDayOfMonth(), getChronology());
    }

    @ToString
    public String toString() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DateTimeFieldType.monthOfYear());
        arrayList.add(DateTimeFieldType.dayOfMonth());
        return org.joda.time.format.i.j(arrayList, true, true).l(this);
    }

    public MonthDay withChronologyRetainFields(a aVar) {
        a withUTC = c.c(aVar).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        MonthDay monthDay = new MonthDay(this, withUTC);
        withUTC.validate(monthDay, getValues());
        return monthDay;
    }

    public MonthDay withDayOfMonth(int i10) {
        return new MonthDay(this, getChronology().dayOfMonth().set(this, 1, getValues(), i10));
    }

    public MonthDay withField(DateTimeFieldType dateTimeFieldType, int i10) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i10 == getValue(indexOfSupported)) {
            return this;
        }
        return new MonthDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i10));
    }

    public MonthDay withFieldAdded(DurationFieldType durationFieldType, int i10) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i10 == 0) {
            return this;
        }
        return new MonthDay(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i10));
    }

    public MonthDay withMonthOfYear(int i10) {
        return new MonthDay(this, getChronology().monthOfYear().set(this, 0, getValues(), i10));
    }

    public MonthDay withPeriodAdded(l lVar, int i10) {
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
        return new MonthDay(this, values);
    }

    public MonthDay(DateTimeZone dateTimeZone) {
        super(ISOChronology.getInstance(dateTimeZone));
    }

    public static MonthDay now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new MonthDay(dateTimeZone);
    }

    public static MonthDay parse(String str, org.joda.time.format.b bVar) {
        LocalDate g3 = bVar.g(str);
        return new MonthDay(g3.getMonthOfYear(), g3.getDayOfMonth());
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final MonthDay iBase;
        private final int iFieldIndex;

        public Property(MonthDay monthDay, int i10) {
            this.iBase = monthDay;
            this.iFieldIndex = i10;
        }

        public MonthDay addToCopy(int i10) {
            return new MonthDay(this.iBase, getField().add(this.iBase, this.iFieldIndex, this.iBase.getValues(), i10));
        }

        public MonthDay addWrapFieldToCopy(int i10) {
            return new MonthDay(this.iBase, getField().addWrapField(this.iBase, this.iFieldIndex, this.iBase.getValues(), i10));
        }

        @Override // org.joda.time.field.a
        public int get() {
            return this.iBase.getValue(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public b getField() {
            return this.iBase.getField(this.iFieldIndex);
        }

        public MonthDay getMonthDay() {
            return this.iBase;
        }

        @Override // org.joda.time.field.a
        public k getReadablePartial() {
            return this.iBase;
        }

        public MonthDay setCopy(int i10) {
            return new MonthDay(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), i10));
        }

        public MonthDay setCopy(String str, Locale locale) {
            return new MonthDay(this.iBase, getField().set(this.iBase, this.iFieldIndex, this.iBase.getValues(), str, locale));
        }

        public MonthDay setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public MonthDay(a aVar) {
        super(aVar);
    }

    public MonthDay(long j10) {
        super(j10);
    }

    public static MonthDay now(a aVar) {
        Objects.requireNonNull(aVar, "Chronology must not be null");
        return new MonthDay(aVar);
    }

    public MonthDay(long j10, a aVar) {
        super(j10, aVar);
    }

    @Override // org.joda.time.base.BasePartial
    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    public MonthDay(Object obj) {
        super(obj, null, org.joda.time.format.i.m());
    }

    public MonthDay(Object obj, a aVar) {
        super(obj, c.c(aVar), org.joda.time.format.i.m());
    }

    @Override // org.joda.time.base.BasePartial
    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public MonthDay(int i10, int i11) {
        this(i10, i11, null);
    }

    public MonthDay(int i10, int i11, a aVar) {
        super(new int[]{i10, i11}, aVar);
    }

    public MonthDay(MonthDay monthDay, int[] iArr) {
        super(monthDay, iArr);
    }

    public MonthDay(MonthDay monthDay, a aVar) {
        super((BasePartial) monthDay, aVar);
    }
}
