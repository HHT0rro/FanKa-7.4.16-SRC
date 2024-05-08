package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LocalDate extends je.g implements Serializable {
    private static final Set<DurationFieldType> DATE_DURATION_TYPES;
    private static final int DAY_OF_MONTH = 2;
    private static final int MONTH_OF_YEAR = 1;
    private static final int YEAR = 0;
    private static final long serialVersionUID = -8775358157899L;
    private final a iChronology;
    private transient int iHash;
    private final long iLocalMillis;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -3193829732634L;
        private transient b iField;
        private transient LocalDate iInstant;

        public Property(LocalDate localDate, b bVar) {
            this.iInstant = localDate;
            this.iField = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (LocalDate) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public LocalDate addToCopy(int i10) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.add(localDate.getLocalMillis(), i10));
        }

        public LocalDate addWrapFieldToCopy(int i10) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.addWrapField(localDate.getLocalMillis(), i10));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.iInstant.getChronology();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.iField;
        }

        public LocalDate getLocalDate() {
            return this.iInstant;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.iInstant.getLocalMillis();
        }

        public LocalDate roundCeilingCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundCeiling(localDate.getLocalMillis()));
        }

        public LocalDate roundFloorCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundFloor(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfCeilingCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundHalfCeiling(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfEvenCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundHalfEven(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfFloorCopy() {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.roundHalfFloor(localDate.getLocalMillis()));
        }

        public LocalDate setCopy(int i10) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.set(localDate.getLocalMillis(), i10));
        }

        public LocalDate withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalDate withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalDate setCopy(String str, Locale locale) {
            LocalDate localDate = this.iInstant;
            return localDate.withLocalMillis(this.iField.set(localDate.getLocalMillis(), str, locale));
        }

        public LocalDate setCopy(String str) {
            return setCopy(str, null);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        DATE_DURATION_TYPES = hashSet;
        hashSet.add(DurationFieldType.days());
        hashSet.add(DurationFieldType.weeks());
        hashSet.add(DurationFieldType.months());
        hashSet.add(DurationFieldType.weekyears());
        hashSet.add(DurationFieldType.years());
        hashSet.add(DurationFieldType.centuries());
        hashSet.add(DurationFieldType.eras());
    }

    public LocalDate() {
        this(c.b(), ISOChronology.getInstance());
    }

    public static LocalDate fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            int i10 = calendar.get(0);
            int i11 = calendar.get(1);
            if (i10 != 1) {
                i11 = 1 - i11;
            }
            return new LocalDate(i11, calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalDate fromDateFields(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (date.getTime() < 0) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            return fromCalendarFields(gregorianCalendar);
        }
        return new LocalDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
    }

    public static LocalDate now() {
        return new LocalDate();
    }

    @FromString
    public static LocalDate parse(String str) {
        return parse(str, org.joda.time.format.i.m());
    }

    private Object readResolve() {
        a aVar = this.iChronology;
        if (aVar == null) {
            return new LocalDate(this.iLocalMillis, ISOChronology.getInstanceUTC());
        }
        return !DateTimeZone.UTC.equals(aVar.getZone()) ? new LocalDate(this.iLocalMillis, this.iChronology.withUTC()) : this;
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public Property dayOfMonth() {
        return new Property(this, getChronology().dayOfMonth());
    }

    public Property dayOfWeek() {
        return new Property(this, getChronology().dayOfWeek());
    }

    public Property dayOfYear() {
        return new Property(this, getChronology().dayOfYear());
    }

    @Override // je.e
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDate) {
            LocalDate localDate = (LocalDate) obj;
            if (this.iChronology.equals(localDate.iChronology)) {
                return this.iLocalMillis == localDate.iLocalMillis;
            }
        }
        return super.equals(obj);
    }

    public Property era() {
        return new Property(this, getChronology().era());
    }

    @Override // je.e, org.joda.time.k
    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            if (isSupported(dateTimeFieldType)) {
                return dateTimeFieldType.getField(getChronology()).get(getLocalMillis());
            }
            throw new IllegalArgumentException("Field '" + ((Object) dateTimeFieldType) + "' is not supported");
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public int getCenturyOfEra() {
        return getChronology().centuryOfEra().get(getLocalMillis());
    }

    @Override // org.joda.time.k
    public a getChronology() {
        return this.iChronology;
    }

    public int getDayOfMonth() {
        return getChronology().dayOfMonth().get(getLocalMillis());
    }

    public int getDayOfWeek() {
        return getChronology().dayOfWeek().get(getLocalMillis());
    }

    public int getDayOfYear() {
        return getChronology().dayOfYear().get(getLocalMillis());
    }

    public int getEra() {
        return getChronology().era().get(getLocalMillis());
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

    @Override // je.g
    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getLocalMillis());
    }

    @Override // org.joda.time.k
    public int getValue(int i10) {
        if (i10 == 0) {
            return getChronology().year().get(getLocalMillis());
        }
        if (i10 == 1) {
            return getChronology().monthOfYear().get(getLocalMillis());
        }
        if (i10 == 2) {
            return getChronology().dayOfMonth().get(getLocalMillis());
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i10);
    }

    public int getWeekOfWeekyear() {
        return getChronology().weekOfWeekyear().get(getLocalMillis());
    }

    public int getWeekyear() {
        return getChronology().weekyear().get(getLocalMillis());
    }

    public int getYear() {
        return getChronology().year().get(getLocalMillis());
    }

    public int getYearOfCentury() {
        return getChronology().yearOfCentury().get(getLocalMillis());
    }

    public int getYearOfEra() {
        return getChronology().yearOfEra().get(getLocalMillis());
    }

    @Override // je.e
    public int hashCode() {
        int i10 = this.iHash;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = super.hashCode();
        this.iHash = hashCode;
        return hashCode;
    }

    @Override // je.e, org.joda.time.k
    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        DurationFieldType durationType = dateTimeFieldType.getDurationType();
        if (DATE_DURATION_TYPES.contains(durationType) || durationType.getField(getChronology()).getUnitMillis() >= getChronology().days().getUnitMillis()) {
            return dateTimeFieldType.getField(getChronology()).isSupported();
        }
        return false;
    }

    public LocalDate minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public LocalDate minusDays(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().days().subtract(getLocalMillis(), i10));
    }

    public LocalDate minusMonths(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().months().subtract(getLocalMillis(), i10));
    }

    public LocalDate minusWeeks(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().weeks().subtract(getLocalMillis(), i10));
    }

    public LocalDate minusYears(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().years().subtract(getLocalMillis(), i10));
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public LocalDate plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public LocalDate plusDays(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().days().add(getLocalMillis(), i10));
    }

    public LocalDate plusMonths(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().months().add(getLocalMillis(), i10));
    }

    public LocalDate plusWeeks(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().weeks().add(getLocalMillis(), i10));
    }

    public LocalDate plusYears(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().years().add(getLocalMillis(), i10));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            if (isSupported(dateTimeFieldType)) {
                return new Property(this, dateTimeFieldType.getField(getChronology()));
            }
            throw new IllegalArgumentException("Field '" + ((Object) dateTimeFieldType) + "' is not supported");
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    @Override // org.joda.time.k
    public int size() {
        return 3;
    }

    public Date toDate() {
        int dayOfMonth = getDayOfMonth();
        Date date = new Date(getYear() - 1900, getMonthOfYear() - 1, dayOfMonth);
        LocalDate fromDateFields = fromDateFields(date);
        if (fromDateFields.isBefore(this)) {
            while (!fromDateFields.equals(this)) {
                date.setTime(date.getTime() + 3600000);
                fromDateFields = fromDateFields(date);
            }
            while (date.getDate() == dayOfMonth) {
                date.setTime(date.getTime() - 1000);
            }
            date.setTime(date.getTime() + 1000);
            return date;
        }
        if (!fromDateFields.equals(this)) {
            return date;
        }
        Date date2 = new Date(date.getTime() - TimeZone.getDefault().getDSTSavings());
        return date2.getDate() == dayOfMonth ? date2 : date;
    }

    @Deprecated
    public DateMidnight toDateMidnight() {
        return toDateMidnight(null);
    }

    public DateTime toDateTime(LocalTime localTime) {
        return toDateTime(localTime, null);
    }

    public DateTime toDateTimeAtCurrentTime() {
        return toDateTimeAtCurrentTime(null);
    }

    @Deprecated
    public DateTime toDateTimeAtMidnight() {
        return toDateTimeAtMidnight(null);
    }

    public DateTime toDateTimeAtStartOfDay() {
        return toDateTimeAtStartOfDay(null);
    }

    public Interval toInterval() {
        return toInterval(null);
    }

    public LocalDateTime toLocalDateTime(LocalTime localTime) {
        if (localTime != null) {
            if (getChronology() == localTime.getChronology()) {
                return new LocalDateTime(getLocalMillis() + localTime.getLocalMillis(), getChronology());
            }
            throw new IllegalArgumentException("The chronology of the time does not match");
        }
        throw new IllegalArgumentException("The time must not be null");
    }

    @ToString
    public String toString() {
        return org.joda.time.format.i.c().l(this);
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public LocalDate withCenturyOfEra(int i10) {
        return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), i10));
    }

    public LocalDate withDayOfMonth(int i10) {
        return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), i10));
    }

    public LocalDate withDayOfWeek(int i10) {
        return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), i10));
    }

    public LocalDate withDayOfYear(int i10) {
        return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), i10));
    }

    public LocalDate withEra(int i10) {
        return withLocalMillis(getChronology().era().set(getLocalMillis(), i10));
    }

    public LocalDate withField(DateTimeFieldType dateTimeFieldType, int i10) {
        if (dateTimeFieldType != null) {
            if (isSupported(dateTimeFieldType)) {
                return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i10));
            }
            throw new IllegalArgumentException("Field '" + ((Object) dateTimeFieldType) + "' is not supported");
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalDate withFieldAdded(DurationFieldType durationFieldType, int i10) {
        if (durationFieldType != null) {
            if (isSupported(durationFieldType)) {
                return i10 == 0 ? this : withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i10));
            }
            throw new IllegalArgumentException("Field '" + ((Object) durationFieldType) + "' is not supported");
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalDate withFields(k kVar) {
        return kVar == null ? this : withLocalMillis(getChronology().set(kVar, getLocalMillis()));
    }

    public LocalDate withLocalMillis(long j10) {
        long roundFloor = this.iChronology.dayOfMonth().roundFloor(j10);
        return roundFloor == getLocalMillis() ? this : new LocalDate(roundFloor, getChronology());
    }

    public LocalDate withMonthOfYear(int i10) {
        return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), i10));
    }

    public LocalDate withPeriodAdded(l lVar, int i10) {
        if (lVar == null || i10 == 0) {
            return this;
        }
        long localMillis = getLocalMillis();
        a chronology = getChronology();
        for (int i11 = 0; i11 < lVar.size(); i11++) {
            long h10 = org.joda.time.field.e.h(lVar.getValue(i11), i10);
            DurationFieldType fieldType = lVar.getFieldType(i11);
            if (isSupported(fieldType)) {
                localMillis = fieldType.getField(chronology).add(localMillis, h10);
            }
        }
        return withLocalMillis(localMillis);
    }

    public LocalDate withWeekOfWeekyear(int i10) {
        return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), i10));
    }

    public LocalDate withWeekyear(int i10) {
        return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), i10));
    }

    public LocalDate withYear(int i10) {
        return withLocalMillis(getChronology().year().set(getLocalMillis(), i10));
    }

    public LocalDate withYearOfCentury(int i10) {
        return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), i10));
    }

    public LocalDate withYearOfEra(int i10) {
        return withLocalMillis(getChronology().yearOfEra().set(getLocalMillis(), i10));
    }

    public Property year() {
        return new Property(this, getChronology().year());
    }

    public Property yearOfCentury() {
        return new Property(this, getChronology().yearOfCentury());
    }

    public Property yearOfEra() {
        return new Property(this, getChronology().yearOfEra());
    }

    public LocalDate(DateTimeZone dateTimeZone) {
        this(c.b(), ISOChronology.getInstance(dateTimeZone));
    }

    public static LocalDate now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new LocalDate(dateTimeZone);
    }

    public static LocalDate parse(String str, org.joda.time.format.b bVar) {
        return bVar.g(str);
    }

    @Override // je.e, java.lang.Comparable
    public int compareTo(k kVar) {
        if (this == kVar) {
            return 0;
        }
        if (kVar instanceof LocalDate) {
            LocalDate localDate = (LocalDate) kVar;
            if (this.iChronology.equals(localDate.iChronology)) {
                long j10 = this.iLocalMillis;
                long j11 = localDate.iLocalMillis;
                if (j10 < j11) {
                    return -1;
                }
                return j10 == j11 ? 0 : 1;
            }
        }
        return super.compareTo(kVar);
    }

    @Deprecated
    public DateMidnight toDateMidnight(DateTimeZone dateTimeZone) {
        return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology().withZone(c.m(dateTimeZone)));
    }

    public DateTime toDateTime(LocalTime localTime, DateTimeZone dateTimeZone) {
        if (localTime == null) {
            return toDateTimeAtCurrentTime(dateTimeZone);
        }
        if (getChronology() == localTime.getChronology()) {
            return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), localTime.getHourOfDay(), localTime.getMinuteOfHour(), localTime.getSecondOfMinute(), localTime.getMillisOfSecond(), getChronology().withZone(dateTimeZone));
        }
        throw new IllegalArgumentException("The chronology of the time does not match");
    }

    public DateTime toDateTimeAtCurrentTime(DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(c.m(dateTimeZone));
        return new DateTime(withZone.set(this, c.b()), withZone);
    }

    @Deprecated
    public DateTime toDateTimeAtMidnight(DateTimeZone dateTimeZone) {
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, getChronology().withZone(c.m(dateTimeZone)));
    }

    public DateTime toDateTimeAtStartOfDay(DateTimeZone dateTimeZone) {
        DateTimeZone m10 = c.m(dateTimeZone);
        a withZone = getChronology().withZone(m10);
        return new DateTime(withZone.dayOfMonth().roundFloor(m10.convertLocalToUTC(getLocalMillis() + 21600000, false)), withZone).withEarlierOffsetAtOverlap();
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        DateTimeZone m10 = c.m(dateTimeZone);
        return new Interval(toDateTimeAtStartOfDay(m10), plusDays(1).toDateTimeAtStartOfDay(m10));
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    public LocalDate(a aVar) {
        this(c.b(), aVar);
    }

    public LocalDate(long j10) {
        this(j10, ISOChronology.getInstance());
    }

    public static LocalDate now(a aVar) {
        Objects.requireNonNull(aVar, "Chronology must not be null");
        return new LocalDate(aVar);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public LocalDate(long j10, DateTimeZone dateTimeZone) {
        this(j10, ISOChronology.getInstance(dateTimeZone));
    }

    public LocalDate(long j10, a aVar) {
        a c4 = c.c(aVar);
        long millisKeepLocal = c4.getZone().getMillisKeepLocal(DateTimeZone.UTC, j10);
        a withUTC = c4.withUTC();
        this.iLocalMillis = withUTC.dayOfMonth().roundFloor(millisKeepLocal);
        this.iChronology = withUTC;
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        d field = durationFieldType.getField(getChronology());
        if (DATE_DURATION_TYPES.contains(durationFieldType) || field.getUnitMillis() >= getChronology().days().getUnitMillis()) {
            return field.isSupported();
        }
        return false;
    }

    public LocalDate(Object obj) {
        this(obj, (a) null);
    }

    public LocalDate(Object obj, DateTimeZone dateTimeZone) {
        ke.l e2 = ke.d.b().e(obj);
        a c4 = c.c(e2.b(obj, dateTimeZone));
        a withUTC = c4.withUTC();
        this.iChronology = withUTC;
        int[] f10 = e2.f(this, obj, c4, org.joda.time.format.i.m());
        this.iLocalMillis = withUTC.getDateTimeMillis(f10[0], f10[1], f10[2], 0);
    }

    public LocalDate(Object obj, a aVar) {
        ke.l e2 = ke.d.b().e(obj);
        a c4 = c.c(e2.a(obj, aVar));
        a withUTC = c4.withUTC();
        this.iChronology = withUTC;
        int[] f10 = e2.f(this, obj, c4, org.joda.time.format.i.m());
        this.iLocalMillis = withUTC.getDateTimeMillis(f10[0], f10[1], f10[2], 0);
    }

    public LocalDate(int i10, int i11, int i12) {
        this(i10, i11, i12, ISOChronology.getInstanceUTC());
    }

    public LocalDate(int i10, int i11, int i12, a aVar) {
        a withUTC = c.c(aVar).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(i10, i11, i12, 0);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }
}
