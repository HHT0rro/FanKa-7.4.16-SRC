package org.joda.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Objects;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableDateTime extends BaseDateTime implements Cloneable {
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_FLOOR = 1;
    public static final int ROUND_HALF_CEILING = 4;
    public static final int ROUND_HALF_EVEN = 5;
    public static final int ROUND_HALF_FLOOR = 3;
    public static final int ROUND_NONE = 0;
    private static final long serialVersionUID = 2852608688135209575L;
    private b iRoundingField;
    private int iRoundingMode;

    public MutableDateTime() {
    }

    public static MutableDateTime now() {
        return new MutableDateTime();
    }

    @FromString
    public static MutableDateTime parse(String str) {
        return parse(str, org.joda.time.format.i.i().w());
    }

    public void add(long j10) {
        setMillis(org.joda.time.field.e.e(getMillis(), j10));
    }

    public void addDays(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().days().add(getMillis(), i10));
        }
    }

    public void addHours(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().hours().add(getMillis(), i10));
        }
    }

    public void addMillis(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().millis().add(getMillis(), i10));
        }
    }

    public void addMinutes(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().minutes().add(getMillis(), i10));
        }
    }

    public void addMonths(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().months().add(getMillis(), i10));
        }
    }

    public void addSeconds(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().seconds().add(getMillis(), i10));
        }
    }

    public void addWeeks(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().weeks().add(getMillis(), i10));
        }
    }

    public void addWeekyears(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().weekyears().add(getMillis(), i10));
        }
    }

    public void addYears(int i10) {
        if (i10 != 0) {
            setMillis(getChronology().years().add(getMillis(), i10));
        }
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableDateTime copy() {
        return (MutableDateTime) clone();
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

    public b getRoundingField() {
        return this.iRoundingField;
    }

    public int getRoundingMode() {
        return this.iRoundingMode;
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public Property minuteOfDay() {
        return new Property(this, getChronology().minuteOfDay());
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
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

    public Property secondOfDay() {
        return new Property(this, getChronology().secondOfDay());
    }

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    public void set(DateTimeFieldType dateTimeFieldType, int i10) {
        if (dateTimeFieldType != null) {
            setMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i10));
            return;
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    @Override // org.joda.time.base.BaseDateTime
    public void setChronology(a aVar) {
        super.setChronology(aVar);
    }

    public void setDate(long j10) {
        setMillis(getChronology().millisOfDay().set(j10, getMillisOfDay()));
    }

    public void setDateTime(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        setMillis(getChronology().getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16));
    }

    public void setDayOfMonth(int i10) {
        setMillis(getChronology().dayOfMonth().set(getMillis(), i10));
    }

    public void setDayOfWeek(int i10) {
        setMillis(getChronology().dayOfWeek().set(getMillis(), i10));
    }

    public void setDayOfYear(int i10) {
        setMillis(getChronology().dayOfYear().set(getMillis(), i10));
    }

    public void setHourOfDay(int i10) {
        setMillis(getChronology().hourOfDay().set(getMillis(), i10));
    }

    @Override // org.joda.time.base.BaseDateTime
    public void setMillis(long j10) {
        int i10 = this.iRoundingMode;
        if (i10 == 1) {
            j10 = this.iRoundingField.roundFloor(j10);
        } else if (i10 == 2) {
            j10 = this.iRoundingField.roundCeiling(j10);
        } else if (i10 == 3) {
            j10 = this.iRoundingField.roundHalfFloor(j10);
        } else if (i10 == 4) {
            j10 = this.iRoundingField.roundHalfCeiling(j10);
        } else if (i10 == 5) {
            j10 = this.iRoundingField.roundHalfEven(j10);
        }
        super.setMillis(j10);
    }

    public void setMillisOfDay(int i10) {
        setMillis(getChronology().millisOfDay().set(getMillis(), i10));
    }

    public void setMillisOfSecond(int i10) {
        setMillis(getChronology().millisOfSecond().set(getMillis(), i10));
    }

    public void setMinuteOfDay(int i10) {
        setMillis(getChronology().minuteOfDay().set(getMillis(), i10));
    }

    public void setMinuteOfHour(int i10) {
        setMillis(getChronology().minuteOfHour().set(getMillis(), i10));
    }

    public void setMonthOfYear(int i10) {
        setMillis(getChronology().monthOfYear().set(getMillis(), i10));
    }

    public void setRounding(b bVar) {
        setRounding(bVar, 1);
    }

    public void setSecondOfDay(int i10) {
        setMillis(getChronology().secondOfDay().set(getMillis(), i10));
    }

    public void setSecondOfMinute(int i10) {
        setMillis(getChronology().secondOfMinute().set(getMillis(), i10));
    }

    public void setTime(long j10) {
        setMillis(getChronology().millisOfDay().set(getMillis(), ISOChronology.getInstanceUTC().millisOfDay().get(j10)));
    }

    public void setWeekOfWeekyear(int i10) {
        setMillis(getChronology().weekOfWeekyear().set(getMillis(), i10));
    }

    public void setWeekyear(int i10) {
        setMillis(getChronology().weekyear().set(getMillis(), i10));
    }

    public void setYear(int i10) {
        setMillis(getChronology().year().set(getMillis(), i10));
    }

    public void setZone(DateTimeZone dateTimeZone) {
        DateTimeZone m10 = c.m(dateTimeZone);
        a chronology = getChronology();
        if (chronology.getZone() != m10) {
            setChronology(chronology.withZone(m10));
        }
    }

    public void setZoneRetainFields(DateTimeZone dateTimeZone) {
        DateTimeZone m10 = c.m(dateTimeZone);
        DateTimeZone m11 = c.m(getZone());
        if (m10 == m11) {
            return;
        }
        long millisKeepLocal = m11.getMillisKeepLocal(m10, getMillis());
        setChronology(getChronology().withZone(m10));
        setMillis(millisKeepLocal);
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
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

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -4481126543819298617L;
        private b iField;
        private MutableDateTime iInstant;

        public Property(MutableDateTime mutableDateTime, b bVar) {
            this.iInstant = mutableDateTime;
            this.iField = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (MutableDateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public MutableDateTime add(int i10) {
            this.iInstant.setMillis(getField().add(this.iInstant.getMillis(), i10));
            return this.iInstant;
        }

        public MutableDateTime addWrapField(int i10) {
            this.iInstant.setMillis(getField().addWrapField(this.iInstant.getMillis(), i10));
            return this.iInstant;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.iInstant.getChronology();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.iField;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.iInstant.getMillis();
        }

        public MutableDateTime getMutableDateTime() {
            return this.iInstant;
        }

        public MutableDateTime roundCeiling() {
            this.iInstant.setMillis(getField().roundCeiling(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundFloor() {
            this.iInstant.setMillis(getField().roundFloor(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfCeiling() {
            this.iInstant.setMillis(getField().roundHalfCeiling(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfEven() {
            this.iInstant.setMillis(getField().roundHalfEven(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfFloor() {
            this.iInstant.setMillis(getField().roundHalfFloor(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime set(int i10) {
            this.iInstant.setMillis(getField().set(this.iInstant.getMillis(), i10));
            return this.iInstant;
        }

        public MutableDateTime add(long j10) {
            this.iInstant.setMillis(getField().add(this.iInstant.getMillis(), j10));
            return this.iInstant;
        }

        public MutableDateTime set(String str, Locale locale) {
            this.iInstant.setMillis(getField().set(this.iInstant.getMillis(), str, locale));
            return this.iInstant;
        }

        public MutableDateTime set(String str) {
            set(str, null);
            return this.iInstant;
        }
    }

    public MutableDateTime(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static MutableDateTime now(DateTimeZone dateTimeZone) {
        Objects.requireNonNull(dateTimeZone, "Zone must not be null");
        return new MutableDateTime(dateTimeZone);
    }

    public static MutableDateTime parse(String str, org.joda.time.format.b bVar) {
        return bVar.f(str).toMutableDateTime();
    }

    public void add(h hVar) {
        add(hVar, 1);
    }

    public void setDate(i iVar) {
        DateTimeZone zone;
        long h10 = c.h(iVar);
        if ((iVar instanceof g) && (zone = c.c(((g) iVar).getChronology()).getZone()) != null) {
            h10 = zone.getMillisKeepLocal(getZone(), h10);
        }
        setDate(h10);
    }

    public void setRounding(b bVar, int i10) {
        if (bVar != null && (i10 < 0 || i10 > 5)) {
            throw new IllegalArgumentException("Illegal rounding mode: " + i10);
        }
        this.iRoundingField = i10 == 0 ? null : bVar;
        if (bVar == null) {
            i10 = 0;
        }
        this.iRoundingMode = i10;
        setMillis(getMillis());
    }

    public MutableDateTime(a aVar) {
        super(aVar);
    }

    public void add(h hVar, int i10) {
        if (hVar != null) {
            add(org.joda.time.field.e.i(hVar.getMillis(), i10));
        }
    }

    public void setTime(i iVar) {
        long h10 = c.h(iVar);
        DateTimeZone zone = c.g(iVar).getZone();
        if (zone != null) {
            h10 = zone.getMillisKeepLocal(DateTimeZone.UTC, h10);
        }
        setTime(h10);
    }

    public MutableDateTime(long j10) {
        super(j10);
    }

    public static MutableDateTime now(a aVar) {
        Objects.requireNonNull(aVar, "Chronology must not be null");
        return new MutableDateTime(aVar);
    }

    public void add(l lVar) {
        add(lVar, 1);
    }

    public MutableDateTime(long j10, DateTimeZone dateTimeZone) {
        super(j10, dateTimeZone);
    }

    public void add(l lVar, int i10) {
        if (lVar != null) {
            setMillis(getChronology().add(lVar, getMillis(), i10));
        }
    }

    public MutableDateTime(long j10, a aVar) {
        super(j10, aVar);
    }

    public void add(DurationFieldType durationFieldType, int i10) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (i10 != 0) {
            setMillis(durationFieldType.getField(getChronology()).add(getMillis(), i10));
        }
    }

    public MutableDateTime(Object obj) {
        super(obj, (a) null);
    }

    public MutableDateTime(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    public void setMillis(i iVar) {
        setMillis(c.h(iVar));
    }

    public void setTime(int i10, int i11, int i12, int i13) {
        setMillis(getChronology().getDateTimeMillis(getMillis(), i10, i11, i12, i13));
    }

    public MutableDateTime(Object obj, a aVar) {
        super(obj, c.c(aVar));
    }

    public void setDate(int i10, int i11, int i12) {
        setDate(getChronology().getDateTimeMillis(i10, i11, i12, 0));
    }

    public MutableDateTime(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        super(i10, i11, i12, i13, i14, i15, i16);
    }

    public MutableDateTime(int i10, int i11, int i12, int i13, int i14, int i15, int i16, DateTimeZone dateTimeZone) {
        super(i10, i11, i12, i13, i14, i15, i16, dateTimeZone);
    }

    public MutableDateTime(int i10, int i11, int i12, int i13, int i14, int i15, int i16, a aVar) {
        super(i10, i11, i12, i13, i14, i15, i16, aVar);
    }
}
