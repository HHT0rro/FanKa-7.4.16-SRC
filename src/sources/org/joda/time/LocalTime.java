package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LocalTime extends je.g implements Serializable {
    private static final int HOUR_OF_DAY = 0;
    public static final LocalTime MIDNIGHT = new LocalTime(0, 0, 0, 0);
    private static final int MILLIS_OF_SECOND = 3;
    private static final int MINUTE_OF_HOUR = 1;
    private static final int SECOND_OF_MINUTE = 2;
    private static final Set<DurationFieldType> TIME_DURATION_TYPES;
    private static final long serialVersionUID = -12873158713873L;
    private final a iChronology;
    private final long iLocalMillis;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -325842547277223L;
        private transient b iField;
        private transient LocalTime iInstant;

        public Property(LocalTime localTime, b bVar) {
            this.iInstant = localTime;
            this.iField = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (LocalTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public LocalTime addCopy(int i10) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.add(localTime.getLocalMillis(), i10));
        }

        public LocalTime addNoWrapToCopy(int i10) {
            long add = this.iField.add(this.iInstant.getLocalMillis(), i10);
            if (this.iInstant.getChronology().millisOfDay().get(add) == add) {
                return this.iInstant.withLocalMillis(add);
            }
            throw new IllegalArgumentException("The addition exceeded the boundaries of LocalTime");
        }

        public LocalTime addWrapFieldToCopy(int i10) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.addWrapField(localTime.getLocalMillis(), i10));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.iInstant.getChronology();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.iField;
        }

        public LocalTime getLocalTime() {
            return this.iInstant;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.iInstant.getLocalMillis();
        }

        public LocalTime roundCeilingCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundFloorCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundFloor(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfCeilingCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfEvenCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfEven(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfFloorCopy() {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.roundHalfFloor(localTime.getLocalMillis()));
        }

        public LocalTime setCopy(int i10) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.set(localTime.getLocalMillis(), i10));
        }

        public LocalTime withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalTime withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalTime addCopy(long j10) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.add(localTime.getLocalMillis(), j10));
        }

        public LocalTime setCopy(String str, Locale locale) {
            LocalTime localTime = this.iInstant;
            return localTime.withLocalMillis(this.iField.set(localTime.getLocalMillis(), str, locale));
        }

        public LocalTime setCopy(String str) {
            return setCopy(str, null);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        TIME_DURATION_TYPES = hashSet;
        hashSet.add(DurationFieldType.millis());
        hashSet.add(DurationFieldType.seconds());
        hashSet.add(DurationFieldType.minutes());
        hashSet.add(DurationFieldType.hours());
    }

    public LocalTime() {
        this(c.b(), ISOChronology.getInstance());
    }

    public static LocalTime fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new LocalTime(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalTime fromDateFields(Date date) {
        if (date != null) {
            return new LocalTime(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static LocalTime fromMillisOfDay(long j10) {
        return fromMillisOfDay(j10, null);
    }

    public static LocalTime now() {
        return new LocalTime();
    }

    @FromString
    public static LocalTime parse(String str) {
        return parse(str, org.joda.time.format.i.n());
    }

    private Object readResolve() {
        a aVar = this.iChronology;
        if (aVar == null) {
            return new LocalTime(this.iLocalMillis, ISOChronology.getInstanceUTC());
        }
        return !DateTimeZone.UTC.equals(aVar.getZone()) ? new LocalTime(this.iLocalMillis, this.iChronology.withUTC()) : this;
    }

    @Override // je.e
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.iChronology.equals(localTime.iChronology)) {
                return this.iLocalMillis == localTime.iLocalMillis;
            }
        }
        return super.equals(obj);
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

    @Override // org.joda.time.k
    public a getChronology() {
        return this.iChronology;
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

    public int getHourOfDay() {
        return getChronology().hourOfDay().get(getLocalMillis());
    }

    @Override // je.g
    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public int getMillisOfDay() {
        return getChronology().millisOfDay().get(getLocalMillis());
    }

    public int getMillisOfSecond() {
        return getChronology().millisOfSecond().get(getLocalMillis());
    }

    public int getMinuteOfHour() {
        return getChronology().minuteOfHour().get(getLocalMillis());
    }

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getLocalMillis());
    }

    @Override // org.joda.time.k
    public int getValue(int i10) {
        if (i10 == 0) {
            return getChronology().hourOfDay().get(getLocalMillis());
        }
        if (i10 == 1) {
            return getChronology().minuteOfHour().get(getLocalMillis());
        }
        if (i10 == 2) {
            return getChronology().secondOfMinute().get(getLocalMillis());
        }
        if (i10 == 3) {
            return getChronology().millisOfSecond().get(getLocalMillis());
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i10);
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    @Override // je.e, org.joda.time.k
    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null || !isSupported(dateTimeFieldType.getDurationType())) {
            return false;
        }
        DurationFieldType rangeDurationType = dateTimeFieldType.getRangeDurationType();
        return isSupported(rangeDurationType) || rangeDurationType == DurationFieldType.days();
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public LocalTime minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public LocalTime minusHours(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().hours().subtract(getLocalMillis(), i10));
    }

    public LocalTime minusMillis(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().millis().subtract(getLocalMillis(), i10));
    }

    public LocalTime minusMinutes(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().minutes().subtract(getLocalMillis(), i10));
    }

    public LocalTime minusSeconds(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().seconds().subtract(getLocalMillis(), i10));
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public LocalTime plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public LocalTime plusHours(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().hours().add(getLocalMillis(), i10));
    }

    public LocalTime plusMillis(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().millis().add(getLocalMillis(), i10));
    }

    public LocalTime plusMinutes(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().minutes().add(getLocalMillis(), i10));
    }

    public LocalTime plusSeconds(int i10) {
        return i10 == 0 ? this : withLocalMillis(getChronology().seconds().add(getLocalMillis(), i10));
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

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    @Override // org.joda.time.k
    public int size() {
        return 4;
    }

    public DateTime toDateTimeToday() {
        return toDateTimeToday(null);
    }

    @ToString
    public String toString() {
        return org.joda.time.format.i.p().l(this);
    }

    public LocalTime withField(DateTimeFieldType dateTimeFieldType, int i10) {
        if (dateTimeFieldType != null) {
            if (isSupported(dateTimeFieldType)) {
                return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i10));
            }
            throw new IllegalArgumentException("Field '" + ((Object) dateTimeFieldType) + "' is not supported");
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalTime withFieldAdded(DurationFieldType durationFieldType, int i10) {
        if (durationFieldType != null) {
            if (isSupported(durationFieldType)) {
                return i10 == 0 ? this : withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i10));
            }
            throw new IllegalArgumentException("Field '" + ((Object) durationFieldType) + "' is not supported");
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalTime withFields(k kVar) {
        return kVar == null ? this : withLocalMillis(getChronology().set(kVar, getLocalMillis()));
    }

    public LocalTime withHourOfDay(int i10) {
        return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), i10));
    }

    public LocalTime withLocalMillis(long j10) {
        return j10 == getLocalMillis() ? this : new LocalTime(j10, getChronology());
    }

    public LocalTime withMillisOfDay(int i10) {
        return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), i10));
    }

    public LocalTime withMillisOfSecond(int i10) {
        return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), i10));
    }

    public LocalTime withMinuteOfHour(int i10) {
        return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), i10));
    }

    public LocalTime withPeriodAdded(l lVar, int i10) {
        return (lVar == null || i10 == 0) ? this : withLocalMillis(getChronology().add(lVar, getLocalMillis(), i10));
    }

    public LocalTime withSecondOfMinute(int i10) {
        return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), i10));
    }

    public LocalTime(DateTimeZone dateTimeZone) {
        this(c.b(), ISOChronology.getInstance(dateTimeZone));
    }

    public static LocalTime fromMillisOfDay(long j10, a aVar) {
        return new LocalTime(j10, c.c(aVar).withUTC());
    }

    public static LocalTime now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new LocalTime(dateTimeZone);
    }

    public static LocalTime parse(String str, org.joda.time.format.b bVar) {
        return bVar.i(str);
    }

    @Override // je.e, java.lang.Comparable
    public int compareTo(k kVar) {
        if (this == kVar) {
            return 0;
        }
        if (kVar instanceof LocalTime) {
            LocalTime localTime = (LocalTime) kVar;
            if (this.iChronology.equals(localTime.iChronology)) {
                long j10 = this.iLocalMillis;
                long j11 = localTime.iLocalMillis;
                if (j10 < j11) {
                    return -1;
                }
                return j10 == j11 ? 0 : 1;
            }
        }
        return super.compareTo(kVar);
    }

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, c.b()), withZone);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).l(this);
    }

    public LocalTime(a aVar) {
        this(c.b(), aVar);
    }

    public LocalTime(long j10) {
        this(j10, ISOChronology.getInstance());
    }

    public static LocalTime now(a aVar) {
        Objects.requireNonNull(aVar, "Chronology must not be null");
        return new LocalTime(aVar);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        d field = durationFieldType.getField(getChronology());
        if (TIME_DURATION_TYPES.contains(durationFieldType) || field.getUnitMillis() < getChronology().days().getUnitMillis()) {
            return field.isSupported();
        }
        return false;
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).l(this);
    }

    public LocalTime(long j10, DateTimeZone dateTimeZone) {
        this(j10, ISOChronology.getInstance(dateTimeZone));
    }

    public LocalTime(long j10, a aVar) {
        a c4 = c.c(aVar);
        long millisKeepLocal = c4.getZone().getMillisKeepLocal(DateTimeZone.UTC, j10);
        a withUTC = c4.withUTC();
        this.iLocalMillis = withUTC.millisOfDay().get(millisKeepLocal);
        this.iChronology = withUTC;
    }

    public LocalTime(Object obj) {
        this(obj, (a) null);
    }

    public LocalTime(Object obj, DateTimeZone dateTimeZone) {
        ke.l e2 = ke.d.b().e(obj);
        a c4 = c.c(e2.b(obj, dateTimeZone));
        a withUTC = c4.withUTC();
        this.iChronology = withUTC;
        int[] f10 = e2.f(this, obj, c4, org.joda.time.format.i.n());
        this.iLocalMillis = withUTC.getDateTimeMillis(0L, f10[0], f10[1], f10[2], f10[3]);
    }

    public LocalTime(Object obj, a aVar) {
        ke.l e2 = ke.d.b().e(obj);
        a c4 = c.c(e2.a(obj, aVar));
        a withUTC = c4.withUTC();
        this.iChronology = withUTC;
        int[] f10 = e2.f(this, obj, c4, org.joda.time.format.i.n());
        this.iLocalMillis = withUTC.getDateTimeMillis(0L, f10[0], f10[1], f10[2], f10[3]);
    }

    public LocalTime(int i10, int i11) {
        this(i10, i11, 0, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i10, int i11, int i12) {
        this(i10, i11, i12, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i10, int i11, int i12, int i13, a aVar) {
        a withUTC = c.c(aVar).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(0L, i10, i11, i12, i13);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }
}
