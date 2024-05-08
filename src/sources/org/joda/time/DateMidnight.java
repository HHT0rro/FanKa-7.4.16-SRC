package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDateTime;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DateMidnight extends BaseDateTime {
    private static final long serialVersionUID = 156371964018738L;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = 257629620;
        private b iField;
        private DateMidnight iInstant;

        public Property(DateMidnight dateMidnight, b bVar) {
            this.iInstant = dateMidnight;
            this.iField = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (DateMidnight) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public DateMidnight addToCopy(int i10) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.add(dateMidnight.getMillis(), i10));
        }

        public DateMidnight addWrapFieldToCopy(int i10) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.addWrapField(dateMidnight.getMillis(), i10));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.iInstant.getChronology();
        }

        public DateMidnight getDateMidnight() {
            return this.iInstant;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.iField;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.iInstant.getMillis();
        }

        public DateMidnight roundCeilingCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundCeiling(dateMidnight.getMillis()));
        }

        public DateMidnight roundFloorCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundFloor(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfCeilingCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfCeiling(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfEvenCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfEven(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfFloorCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfFloor(dateMidnight.getMillis()));
        }

        public DateMidnight setCopy(int i10) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.set(dateMidnight.getMillis(), i10));
        }

        public DateMidnight withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public DateMidnight withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public DateMidnight addToCopy(long j10) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.add(dateMidnight.getMillis(), j10));
        }

        public DateMidnight setCopy(String str, Locale locale) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.set(dateMidnight.getMillis(), str, locale));
        }

        public DateMidnight setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public DateMidnight() {
    }

    public static DateMidnight now() {
        return new DateMidnight();
    }

    @FromString
    public static DateMidnight parse(String str) {
        return parse(str, org.joda.time.format.i.i().w());
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    @Override // org.joda.time.base.BaseDateTime
    public long checkInstant(long j10, a aVar) {
        return aVar.dayOfMonth().roundFloor(j10);
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

    public Property era() {
        return new Property(this, getChronology().era());
    }

    public DateMidnight minus(long j10) {
        return withDurationAdded(j10, -1);
    }

    public DateMidnight minusDays(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().days().subtract(getMillis(), i10));
    }

    public DateMidnight minusMonths(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().months().subtract(getMillis(), i10));
    }

    public DateMidnight minusWeeks(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().weeks().subtract(getMillis(), i10));
    }

    public DateMidnight minusYears(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().years().subtract(getMillis(), i10));
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public DateMidnight plus(long j10) {
        return withDurationAdded(j10, 1);
    }

    public DateMidnight plusDays(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().days().add(getMillis(), i10));
    }

    public DateMidnight plusMonths(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().months().add(getMillis(), i10));
    }

    public DateMidnight plusWeeks(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().weeks().add(getMillis(), i10));
    }

    public DateMidnight plusYears(int i10) {
        return i10 == 0 ? this : withMillis(getChronology().years().add(getMillis(), i10));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            b field = dateTimeFieldType.getField(getChronology());
            if (field.isSupported()) {
                return new Property(this, field);
            }
            throw new IllegalArgumentException("Field '" + ((Object) dateTimeFieldType) + "' is not supported");
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public Interval toInterval() {
        a chronology = getChronology();
        long millis = getMillis();
        return new Interval(millis, DurationFieldType.days().getField(chronology).add(millis, 1), chronology);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getMillis(), getChronology());
    }

    @Deprecated
    public YearMonthDay toYearMonthDay() {
        return new YearMonthDay(getMillis(), getChronology());
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public DateMidnight withCenturyOfEra(int i10) {
        return withMillis(getChronology().centuryOfEra().set(getMillis(), i10));
    }

    public DateMidnight withChronology(a aVar) {
        return aVar == getChronology() ? this : new DateMidnight(getMillis(), aVar);
    }

    public DateMidnight withDayOfMonth(int i10) {
        return withMillis(getChronology().dayOfMonth().set(getMillis(), i10));
    }

    public DateMidnight withDayOfWeek(int i10) {
        return withMillis(getChronology().dayOfWeek().set(getMillis(), i10));
    }

    public DateMidnight withDayOfYear(int i10) {
        return withMillis(getChronology().dayOfYear().set(getMillis(), i10));
    }

    public DateMidnight withDurationAdded(long j10, int i10) {
        return (j10 == 0 || i10 == 0) ? this : withMillis(getChronology().add(getMillis(), j10, i10));
    }

    public DateMidnight withEra(int i10) {
        return withMillis(getChronology().era().set(getMillis(), i10));
    }

    public DateMidnight withField(DateTimeFieldType dateTimeFieldType, int i10) {
        if (dateTimeFieldType != null) {
            return withMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i10));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateMidnight withFieldAdded(DurationFieldType durationFieldType, int i10) {
        if (durationFieldType != null) {
            return i10 == 0 ? this : withMillis(durationFieldType.getField(getChronology()).add(getMillis(), i10));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateMidnight withFields(k kVar) {
        return kVar == null ? this : withMillis(getChronology().set(kVar, getMillis()));
    }

    public DateMidnight withMillis(long j10) {
        a chronology = getChronology();
        long checkInstant = checkInstant(j10, chronology);
        return checkInstant == getMillis() ? this : new DateMidnight(checkInstant, chronology);
    }

    public DateMidnight withMonthOfYear(int i10) {
        return withMillis(getChronology().monthOfYear().set(getMillis(), i10));
    }

    public DateMidnight withPeriodAdded(l lVar, int i10) {
        return (lVar == null || i10 == 0) ? this : withMillis(getChronology().add(lVar, getMillis(), i10));
    }

    public DateMidnight withWeekOfWeekyear(int i10) {
        return withMillis(getChronology().weekOfWeekyear().set(getMillis(), i10));
    }

    public DateMidnight withWeekyear(int i10) {
        return withMillis(getChronology().weekyear().set(getMillis(), i10));
    }

    public DateMidnight withYear(int i10) {
        return withMillis(getChronology().year().set(getMillis(), i10));
    }

    public DateMidnight withYearOfCentury(int i10) {
        return withMillis(getChronology().yearOfCentury().set(getMillis(), i10));
    }

    public DateMidnight withYearOfEra(int i10) {
        return withMillis(getChronology().yearOfEra().set(getMillis(), i10));
    }

    public DateMidnight withZoneRetainFields(DateTimeZone dateTimeZone) {
        DateTimeZone m10 = c.m(dateTimeZone);
        DateTimeZone m11 = c.m(getZone());
        return m10 == m11 ? this : new DateMidnight(m11.getMillisKeepLocal(m10, getMillis()), getChronology().withZone(m10));
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

    public DateMidnight(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static DateMidnight now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new DateMidnight(dateTimeZone);
    }

    public static DateMidnight parse(String str, org.joda.time.format.b bVar) {
        return bVar.f(str).toDateMidnight();
    }

    public DateMidnight minus(h hVar) {
        return withDurationAdded(hVar, -1);
    }

    public DateMidnight plus(h hVar) {
        return withDurationAdded(hVar, 1);
    }

    public DateMidnight(a aVar) {
        super(aVar);
    }

    public DateMidnight minus(l lVar) {
        return withPeriodAdded(lVar, -1);
    }

    public DateMidnight plus(l lVar) {
        return withPeriodAdded(lVar, 1);
    }

    public DateMidnight withDurationAdded(h hVar, int i10) {
        return (hVar == null || i10 == 0) ? this : withDurationAdded(hVar.getMillis(), i10);
    }

    public DateMidnight(long j10) {
        super(j10);
    }

    public static DateMidnight now(a aVar) {
        Objects.requireNonNull(aVar, "Chronology must not be null");
        return new DateMidnight(aVar);
    }

    public DateMidnight(long j10, DateTimeZone dateTimeZone) {
        super(j10, dateTimeZone);
    }

    public DateMidnight(long j10, a aVar) {
        super(j10, aVar);
    }

    public DateMidnight(Object obj) {
        super(obj, (a) null);
    }

    public DateMidnight(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    public DateMidnight(Object obj, a aVar) {
        super(obj, c.c(aVar));
    }

    public DateMidnight(int i10, int i11, int i12) {
        super(i10, i11, i12, 0, 0, 0, 0);
    }

    public DateMidnight(int i10, int i11, int i12, DateTimeZone dateTimeZone) {
        super(i10, i11, i12, 0, 0, 0, 0, dateTimeZone);
    }

    public DateMidnight(int i10, int i11, int i12, a aVar) {
        super(i10, i11, i12, 0, 0, 0, 0, aVar);
    }
}
