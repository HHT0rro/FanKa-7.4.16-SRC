package org.joda.time;

import com.android.internal.logging.nano.MetricsProto;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Minutes extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380863L;
    public static final Minutes ZERO = new Minutes(0);
    public static final Minutes ONE = new Minutes(1);
    public static final Minutes TWO = new Minutes(2);
    public static final Minutes THREE = new Minutes(3);
    public static final Minutes MAX_VALUE = new Minutes(Integer.MAX_VALUE);
    public static final Minutes MIN_VALUE = new Minutes(Integer.MIN_VALUE);
    private static final n PARSER = org.joda.time.format.j.a().j(PeriodType.minutes());

    private Minutes(int i10) {
        super(i10);
    }

    public static Minutes minutes(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            return MIN_VALUE;
        }
        if (i10 == Integer.MAX_VALUE) {
            return MAX_VALUE;
        }
        if (i10 == 0) {
            return ZERO;
        }
        if (i10 == 1) {
            return ONE;
        }
        if (i10 == 2) {
            return TWO;
        }
        if (i10 != 3) {
            return new Minutes(i10);
        }
        return THREE;
    }

    public static Minutes minutesBetween(i iVar, i iVar2) {
        return minutes(BaseSingleFieldPeriod.between(iVar, iVar2, DurationFieldType.minutes()));
    }

    public static Minutes minutesIn(j jVar) {
        if (jVar == null) {
            return ZERO;
        }
        return minutes(BaseSingleFieldPeriod.between(jVar.getStart(), jVar.getEnd(), DurationFieldType.minutes()));
    }

    @FromString
    public static Minutes parseMinutes(String str) {
        if (str == null) {
            return ZERO;
        }
        return minutes(PARSER.h(str).getMinutes());
    }

    private Object readResolve() {
        return minutes(getValue());
    }

    public static Minutes standardMinutesIn(l lVar) {
        return minutes(BaseSingleFieldPeriod.standardPeriodIn(lVar, 60000L));
    }

    public Minutes dividedBy(int i10) {
        return i10 == 1 ? this : minutes(getValue() / i10);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.minutes();
    }

    public int getMinutes() {
        return getValue();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.l
    public PeriodType getPeriodType() {
        return PeriodType.minutes();
    }

    public boolean isGreaterThan(Minutes minutes) {
        return minutes == null ? getValue() > 0 : getValue() > minutes.getValue();
    }

    public boolean isLessThan(Minutes minutes) {
        return minutes == null ? getValue() < 0 : getValue() < minutes.getValue();
    }

    public Minutes minus(int i10) {
        return plus(org.joda.time.field.e.k(i10));
    }

    public Minutes multipliedBy(int i10) {
        return minutes(org.joda.time.field.e.h(getValue(), i10));
    }

    public Minutes negated() {
        return minutes(org.joda.time.field.e.k(getValue()));
    }

    public Minutes plus(int i10) {
        return i10 == 0 ? this : minutes(org.joda.time.field.e.d(getValue(), i10));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE);
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 60000);
    }

    public Hours toStandardHours() {
        return Hours.hours(getValue() / 60);
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(org.joda.time.field.e.h(getValue(), 60));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 10080);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "M";
    }

    public Minutes minus(Minutes minutes) {
        return minutes == null ? this : minus(minutes.getValue());
    }

    public Minutes plus(Minutes minutes) {
        return minutes == null ? this : plus(minutes.getValue());
    }

    public static Minutes minutesBetween(k kVar, k kVar2) {
        if ((kVar instanceof LocalTime) && (kVar2 instanceof LocalTime)) {
            return minutes(c.c(kVar.getChronology()).minutes().getDifference(((LocalTime) kVar2).getLocalMillis(), ((LocalTime) kVar).getLocalMillis()));
        }
        return minutes(BaseSingleFieldPeriod.between(kVar, kVar2, ZERO));
    }
}
