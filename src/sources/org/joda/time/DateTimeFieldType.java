package org.joda.time;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class DateTimeFieldType implements Serializable {
    public static final byte CENTURY_OF_ERA = 3;
    public static final byte CLOCKHOUR_OF_DAY = 16;
    public static final byte CLOCKHOUR_OF_HALFDAY = 15;
    public static final byte DAY_OF_MONTH = 8;
    public static final byte DAY_OF_WEEK = 12;
    public static final byte DAY_OF_YEAR = 6;
    public static final byte ERA = 1;
    public static final byte HALFDAY_OF_DAY = 13;
    public static final byte HOUR_OF_DAY = 17;
    public static final byte HOUR_OF_HALFDAY = 14;
    public static final byte MILLIS_OF_DAY = 22;
    public static final byte MILLIS_OF_SECOND = 23;
    public static final byte MINUTE_OF_DAY = 18;
    public static final byte MINUTE_OF_HOUR = 19;
    public static final byte MONTH_OF_YEAR = 7;
    public static final byte SECOND_OF_DAY = 20;
    public static final byte SECOND_OF_MINUTE = 21;
    public static final byte WEEKYEAR = 10;
    public static final byte WEEKYEAR_OF_CENTURY = 9;
    public static final byte WEEK_OF_WEEKYEAR = 11;
    public static final byte YEAR = 5;
    public static final byte YEAR_OF_CENTURY = 4;
    public static final byte YEAR_OF_ERA = 2;
    private static final long serialVersionUID = -42615285973990L;
    private final String iName;
    private static final DateTimeFieldType ERA_TYPE = new StandardDateTimeFieldType("era", (byte) 1, DurationFieldType.eras(), null);
    private static final DateTimeFieldType YEAR_OF_ERA_TYPE = new StandardDateTimeFieldType("yearOfEra", (byte) 2, DurationFieldType.years(), DurationFieldType.eras());
    private static final DateTimeFieldType CENTURY_OF_ERA_TYPE = new StandardDateTimeFieldType("centuryOfEra", (byte) 3, DurationFieldType.centuries(), DurationFieldType.eras());
    private static final DateTimeFieldType YEAR_OF_CENTURY_TYPE = new StandardDateTimeFieldType("yearOfCentury", (byte) 4, DurationFieldType.years(), DurationFieldType.centuries());
    private static final DateTimeFieldType YEAR_TYPE = new StandardDateTimeFieldType("year", (byte) 5, DurationFieldType.years(), null);
    private static final DateTimeFieldType DAY_OF_YEAR_TYPE = new StandardDateTimeFieldType("dayOfYear", (byte) 6, DurationFieldType.days(), DurationFieldType.years());
    private static final DateTimeFieldType MONTH_OF_YEAR_TYPE = new StandardDateTimeFieldType("monthOfYear", (byte) 7, DurationFieldType.months(), DurationFieldType.years());
    private static final DateTimeFieldType DAY_OF_MONTH_TYPE = new StandardDateTimeFieldType("dayOfMonth", (byte) 8, DurationFieldType.days(), DurationFieldType.months());
    private static final DateTimeFieldType WEEKYEAR_OF_CENTURY_TYPE = new StandardDateTimeFieldType("weekyearOfCentury", (byte) 9, DurationFieldType.weekyears(), DurationFieldType.centuries());
    private static final DateTimeFieldType WEEKYEAR_TYPE = new StandardDateTimeFieldType("weekyear", (byte) 10, DurationFieldType.weekyears(), null);
    private static final DateTimeFieldType WEEK_OF_WEEKYEAR_TYPE = new StandardDateTimeFieldType("weekOfWeekyear", (byte) 11, DurationFieldType.weeks(), DurationFieldType.weekyears());
    private static final DateTimeFieldType DAY_OF_WEEK_TYPE = new StandardDateTimeFieldType("dayOfWeek", (byte) 12, DurationFieldType.days(), DurationFieldType.weeks());
    private static final DateTimeFieldType HALFDAY_OF_DAY_TYPE = new StandardDateTimeFieldType("halfdayOfDay", (byte) 13, DurationFieldType.halfdays(), DurationFieldType.days());
    private static final DateTimeFieldType HOUR_OF_HALFDAY_TYPE = new StandardDateTimeFieldType("hourOfHalfday", (byte) 14, DurationFieldType.hours(), DurationFieldType.halfdays());
    private static final DateTimeFieldType CLOCKHOUR_OF_HALFDAY_TYPE = new StandardDateTimeFieldType("clockhourOfHalfday", (byte) 15, DurationFieldType.hours(), DurationFieldType.halfdays());
    private static final DateTimeFieldType CLOCKHOUR_OF_DAY_TYPE = new StandardDateTimeFieldType("clockhourOfDay", (byte) 16, DurationFieldType.hours(), DurationFieldType.days());
    private static final DateTimeFieldType HOUR_OF_DAY_TYPE = new StandardDateTimeFieldType("hourOfDay", (byte) 17, DurationFieldType.hours(), DurationFieldType.days());
    private static final DateTimeFieldType MINUTE_OF_DAY_TYPE = new StandardDateTimeFieldType("minuteOfDay", (byte) 18, DurationFieldType.minutes(), DurationFieldType.days());
    private static final DateTimeFieldType MINUTE_OF_HOUR_TYPE = new StandardDateTimeFieldType("minuteOfHour", (byte) 19, DurationFieldType.minutes(), DurationFieldType.hours());
    private static final DateTimeFieldType SECOND_OF_DAY_TYPE = new StandardDateTimeFieldType("secondOfDay", (byte) 20, DurationFieldType.seconds(), DurationFieldType.days());
    private static final DateTimeFieldType SECOND_OF_MINUTE_TYPE = new StandardDateTimeFieldType("secondOfMinute", (byte) 21, DurationFieldType.seconds(), DurationFieldType.minutes());
    private static final DateTimeFieldType MILLIS_OF_DAY_TYPE = new StandardDateTimeFieldType("millisOfDay", (byte) 22, DurationFieldType.millis(), DurationFieldType.days());
    private static final DateTimeFieldType MILLIS_OF_SECOND_TYPE = new StandardDateTimeFieldType("millisOfSecond", (byte) 23, DurationFieldType.millis(), DurationFieldType.seconds());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class StandardDateTimeFieldType extends DateTimeFieldType {
        private static final long serialVersionUID = -9937958251642L;
        private final byte iOrdinal;
        private final transient DurationFieldType iRangeType;
        private final transient DurationFieldType iUnitType;

        public StandardDateTimeFieldType(String str, byte b4, DurationFieldType durationFieldType, DurationFieldType durationFieldType2) {
            super(str);
            this.iOrdinal = b4;
            this.iUnitType = durationFieldType;
            this.iRangeType = durationFieldType2;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return DateTimeFieldType.ERA_TYPE;
                case 2:
                    return DateTimeFieldType.YEAR_OF_ERA_TYPE;
                case 3:
                    return DateTimeFieldType.CENTURY_OF_ERA_TYPE;
                case 4:
                    return DateTimeFieldType.YEAR_OF_CENTURY_TYPE;
                case 5:
                    return DateTimeFieldType.YEAR_TYPE;
                case 6:
                    return DateTimeFieldType.DAY_OF_YEAR_TYPE;
                case 7:
                    return DateTimeFieldType.MONTH_OF_YEAR_TYPE;
                case 8:
                    return DateTimeFieldType.DAY_OF_MONTH_TYPE;
                case 9:
                    return DateTimeFieldType.WEEKYEAR_OF_CENTURY_TYPE;
                case 10:
                    return DateTimeFieldType.WEEKYEAR_TYPE;
                case 11:
                    return DateTimeFieldType.WEEK_OF_WEEKYEAR_TYPE;
                case 12:
                    return DateTimeFieldType.DAY_OF_WEEK_TYPE;
                case 13:
                    return DateTimeFieldType.HALFDAY_OF_DAY_TYPE;
                case 14:
                    return DateTimeFieldType.HOUR_OF_HALFDAY_TYPE;
                case 15:
                    return DateTimeFieldType.CLOCKHOUR_OF_HALFDAY_TYPE;
                case 16:
                    return DateTimeFieldType.CLOCKHOUR_OF_DAY_TYPE;
                case 17:
                    return DateTimeFieldType.HOUR_OF_DAY_TYPE;
                case 18:
                    return DateTimeFieldType.MINUTE_OF_DAY_TYPE;
                case 19:
                    return DateTimeFieldType.MINUTE_OF_HOUR_TYPE;
                case 20:
                    return DateTimeFieldType.SECOND_OF_DAY_TYPE;
                case 21:
                    return DateTimeFieldType.SECOND_OF_MINUTE_TYPE;
                case 22:
                    return DateTimeFieldType.MILLIS_OF_DAY_TYPE;
                case 23:
                    return DateTimeFieldType.MILLIS_OF_SECOND_TYPE;
                default:
                    return this;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StandardDateTimeFieldType) && this.iOrdinal == ((StandardDateTimeFieldType) obj).iOrdinal;
        }

        @Override // org.joda.time.DateTimeFieldType
        public DurationFieldType getDurationType() {
            return this.iUnitType;
        }

        @Override // org.joda.time.DateTimeFieldType
        public b getField(a aVar) {
            a c4 = c.c(aVar);
            switch (this.iOrdinal) {
                case 1:
                    return c4.era();
                case 2:
                    return c4.yearOfEra();
                case 3:
                    return c4.centuryOfEra();
                case 4:
                    return c4.yearOfCentury();
                case 5:
                    return c4.year();
                case 6:
                    return c4.dayOfYear();
                case 7:
                    return c4.monthOfYear();
                case 8:
                    return c4.dayOfMonth();
                case 9:
                    return c4.weekyearOfCentury();
                case 10:
                    return c4.weekyear();
                case 11:
                    return c4.weekOfWeekyear();
                case 12:
                    return c4.dayOfWeek();
                case 13:
                    return c4.halfdayOfDay();
                case 14:
                    return c4.hourOfHalfday();
                case 15:
                    return c4.clockhourOfHalfday();
                case 16:
                    return c4.clockhourOfDay();
                case 17:
                    return c4.hourOfDay();
                case 18:
                    return c4.minuteOfDay();
                case 19:
                    return c4.minuteOfHour();
                case 20:
                    return c4.secondOfDay();
                case 21:
                    return c4.secondOfMinute();
                case 22:
                    return c4.millisOfDay();
                case 23:
                    return c4.millisOfSecond();
                default:
                    throw new InternalError();
            }
        }

        @Override // org.joda.time.DateTimeFieldType
        public DurationFieldType getRangeDurationType() {
            return this.iRangeType;
        }

        public int hashCode() {
            return 1 << this.iOrdinal;
        }
    }

    public DateTimeFieldType(String str) {
        this.iName = str;
    }

    public static DateTimeFieldType centuryOfEra() {
        return CENTURY_OF_ERA_TYPE;
    }

    public static DateTimeFieldType clockhourOfDay() {
        return CLOCKHOUR_OF_DAY_TYPE;
    }

    public static DateTimeFieldType clockhourOfHalfday() {
        return CLOCKHOUR_OF_HALFDAY_TYPE;
    }

    public static DateTimeFieldType dayOfMonth() {
        return DAY_OF_MONTH_TYPE;
    }

    public static DateTimeFieldType dayOfWeek() {
        return DAY_OF_WEEK_TYPE;
    }

    public static DateTimeFieldType dayOfYear() {
        return DAY_OF_YEAR_TYPE;
    }

    public static DateTimeFieldType era() {
        return ERA_TYPE;
    }

    public static DateTimeFieldType halfdayOfDay() {
        return HALFDAY_OF_DAY_TYPE;
    }

    public static DateTimeFieldType hourOfDay() {
        return HOUR_OF_DAY_TYPE;
    }

    public static DateTimeFieldType hourOfHalfday() {
        return HOUR_OF_HALFDAY_TYPE;
    }

    public static DateTimeFieldType millisOfDay() {
        return MILLIS_OF_DAY_TYPE;
    }

    public static DateTimeFieldType millisOfSecond() {
        return MILLIS_OF_SECOND_TYPE;
    }

    public static DateTimeFieldType minuteOfDay() {
        return MINUTE_OF_DAY_TYPE;
    }

    public static DateTimeFieldType minuteOfHour() {
        return MINUTE_OF_HOUR_TYPE;
    }

    public static DateTimeFieldType monthOfYear() {
        return MONTH_OF_YEAR_TYPE;
    }

    public static DateTimeFieldType secondOfDay() {
        return SECOND_OF_DAY_TYPE;
    }

    public static DateTimeFieldType secondOfMinute() {
        return SECOND_OF_MINUTE_TYPE;
    }

    public static DateTimeFieldType weekOfWeekyear() {
        return WEEK_OF_WEEKYEAR_TYPE;
    }

    public static DateTimeFieldType weekyear() {
        return WEEKYEAR_TYPE;
    }

    public static DateTimeFieldType weekyearOfCentury() {
        return WEEKYEAR_OF_CENTURY_TYPE;
    }

    public static DateTimeFieldType year() {
        return YEAR_TYPE;
    }

    public static DateTimeFieldType yearOfCentury() {
        return YEAR_OF_CENTURY_TYPE;
    }

    public static DateTimeFieldType yearOfEra() {
        return YEAR_OF_ERA_TYPE;
    }

    public abstract DurationFieldType getDurationType();

    public abstract b getField(a aVar);

    public String getName() {
        return this.iName;
    }

    public abstract DurationFieldType getRangeDurationType();

    public boolean isSupported(a aVar) {
        return getField(aVar).isSupported();
    }

    public String toString() {
        return getName();
    }
}
