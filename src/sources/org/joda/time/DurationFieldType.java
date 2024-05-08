package org.joda.time;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class DurationFieldType implements Serializable {
    public static final byte CENTURIES = 2;
    public static final byte DAYS = 7;
    public static final byte ERAS = 1;
    public static final byte HALFDAYS = 8;
    public static final byte HOURS = 9;
    public static final byte MILLIS = 12;
    public static final byte MINUTES = 10;
    public static final byte MONTHS = 5;
    public static final byte SECONDS = 11;
    public static final byte WEEKS = 6;
    public static final byte WEEKYEARS = 3;
    public static final byte YEARS = 4;
    private static final long serialVersionUID = 8765135187319L;
    private final String iName;
    public static final DurationFieldType ERAS_TYPE = new StandardDurationFieldType("eras", (byte) 1);
    public static final DurationFieldType CENTURIES_TYPE = new StandardDurationFieldType("centuries", (byte) 2);
    public static final DurationFieldType WEEKYEARS_TYPE = new StandardDurationFieldType("weekyears", (byte) 3);
    public static final DurationFieldType YEARS_TYPE = new StandardDurationFieldType("years", (byte) 4);
    public static final DurationFieldType MONTHS_TYPE = new StandardDurationFieldType("months", (byte) 5);
    public static final DurationFieldType WEEKS_TYPE = new StandardDurationFieldType("weeks", (byte) 6);
    public static final DurationFieldType DAYS_TYPE = new StandardDurationFieldType("days", (byte) 7);
    public static final DurationFieldType HALFDAYS_TYPE = new StandardDurationFieldType("halfdays", (byte) 8);
    public static final DurationFieldType HOURS_TYPE = new StandardDurationFieldType("hours", (byte) 9);
    public static final DurationFieldType MINUTES_TYPE = new StandardDurationFieldType("minutes", (byte) 10);
    public static final DurationFieldType SECONDS_TYPE = new StandardDurationFieldType("seconds", (byte) 11);
    public static final DurationFieldType MILLIS_TYPE = new StandardDurationFieldType("millis", (byte) 12);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class StandardDurationFieldType extends DurationFieldType {
        private static final long serialVersionUID = 31156755687123L;
        private final byte iOrdinal;

        public StandardDurationFieldType(String str, byte b4) {
            super(str);
            this.iOrdinal = b4;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return DurationFieldType.ERAS_TYPE;
                case 2:
                    return DurationFieldType.CENTURIES_TYPE;
                case 3:
                    return DurationFieldType.WEEKYEARS_TYPE;
                case 4:
                    return DurationFieldType.YEARS_TYPE;
                case 5:
                    return DurationFieldType.MONTHS_TYPE;
                case 6:
                    return DurationFieldType.WEEKS_TYPE;
                case 7:
                    return DurationFieldType.DAYS_TYPE;
                case 8:
                    return DurationFieldType.HALFDAYS_TYPE;
                case 9:
                    return DurationFieldType.HOURS_TYPE;
                case 10:
                    return DurationFieldType.MINUTES_TYPE;
                case 11:
                    return DurationFieldType.SECONDS_TYPE;
                case 12:
                    return DurationFieldType.MILLIS_TYPE;
                default:
                    return this;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StandardDurationFieldType) && this.iOrdinal == ((StandardDurationFieldType) obj).iOrdinal;
        }

        @Override // org.joda.time.DurationFieldType
        public d getField(a aVar) {
            a c4 = c.c(aVar);
            switch (this.iOrdinal) {
                case 1:
                    return c4.eras();
                case 2:
                    return c4.centuries();
                case 3:
                    return c4.weekyears();
                case 4:
                    return c4.years();
                case 5:
                    return c4.months();
                case 6:
                    return c4.weeks();
                case 7:
                    return c4.days();
                case 8:
                    return c4.halfdays();
                case 9:
                    return c4.hours();
                case 10:
                    return c4.minutes();
                case 11:
                    return c4.seconds();
                case 12:
                    return c4.millis();
                default:
                    throw new InternalError();
            }
        }

        public int hashCode() {
            return 1 << this.iOrdinal;
        }
    }

    public DurationFieldType(String str) {
        this.iName = str;
    }

    public static DurationFieldType centuries() {
        return CENTURIES_TYPE;
    }

    public static DurationFieldType days() {
        return DAYS_TYPE;
    }

    public static DurationFieldType eras() {
        return ERAS_TYPE;
    }

    public static DurationFieldType halfdays() {
        return HALFDAYS_TYPE;
    }

    public static DurationFieldType hours() {
        return HOURS_TYPE;
    }

    public static DurationFieldType millis() {
        return MILLIS_TYPE;
    }

    public static DurationFieldType minutes() {
        return MINUTES_TYPE;
    }

    public static DurationFieldType months() {
        return MONTHS_TYPE;
    }

    public static DurationFieldType seconds() {
        return SECONDS_TYPE;
    }

    public static DurationFieldType weeks() {
        return WEEKS_TYPE;
    }

    public static DurationFieldType weekyears() {
        return WEEKYEARS_TYPE;
    }

    public static DurationFieldType years() {
        return YEARS_TYPE;
    }

    public abstract d getField(a aVar);

    public String getName() {
        return this.iName;
    }

    public boolean isSupported(a aVar) {
        return getField(aVar).isSupported();
    }

    public String toString() {
        return getName();
    }
}
