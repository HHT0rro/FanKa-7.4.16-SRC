package org.joda.time;

import com.kwad.sdk.core.response.model.SdkConfigData;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Hours extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380864L;
    public static final Hours ZERO = new Hours(0);
    public static final Hours ONE = new Hours(1);
    public static final Hours TWO = new Hours(2);
    public static final Hours THREE = new Hours(3);
    public static final Hours FOUR = new Hours(4);
    public static final Hours FIVE = new Hours(5);
    public static final Hours SIX = new Hours(6);
    public static final Hours SEVEN = new Hours(7);
    public static final Hours EIGHT = new Hours(8);
    public static final Hours MAX_VALUE = new Hours(Integer.MAX_VALUE);
    public static final Hours MIN_VALUE = new Hours(Integer.MIN_VALUE);
    private static final n PARSER = org.joda.time.format.j.a().j(PeriodType.hours());

    private Hours(int i10) {
        super(i10);
    }

    public static Hours hours(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            return MIN_VALUE;
        }
        if (i10 != Integer.MAX_VALUE) {
            switch (i10) {
                case 0:
                    return ZERO;
                case 1:
                    return ONE;
                case 2:
                    return TWO;
                case 3:
                    return THREE;
                case 4:
                    return FOUR;
                case 5:
                    return FIVE;
                case 6:
                    return SIX;
                case 7:
                    return SEVEN;
                case 8:
                    return EIGHT;
                default:
                    return new Hours(i10);
            }
        }
        return MAX_VALUE;
    }

    public static Hours hoursBetween(i iVar, i iVar2) {
        return hours(BaseSingleFieldPeriod.between(iVar, iVar2, DurationFieldType.hours()));
    }

    public static Hours hoursIn(j jVar) {
        if (jVar == null) {
            return ZERO;
        }
        return hours(BaseSingleFieldPeriod.between(jVar.getStart(), jVar.getEnd(), DurationFieldType.hours()));
    }

    @FromString
    public static Hours parseHours(String str) {
        if (str == null) {
            return ZERO;
        }
        return hours(PARSER.h(str).getHours());
    }

    private Object readResolve() {
        return hours(getValue());
    }

    public static Hours standardHoursIn(l lVar) {
        return hours(BaseSingleFieldPeriod.standardPeriodIn(lVar, 3600000L));
    }

    public Hours dividedBy(int i10) {
        return i10 == 1 ? this : hours(getValue() / i10);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.hours();
    }

    public int getHours() {
        return getValue();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.l
    public PeriodType getPeriodType() {
        return PeriodType.hours();
    }

    public boolean isGreaterThan(Hours hours) {
        return hours == null ? getValue() > 0 : getValue() > hours.getValue();
    }

    public boolean isLessThan(Hours hours) {
        return hours == null ? getValue() < 0 : getValue() < hours.getValue();
    }

    public Hours minus(int i10) {
        return plus(org.joda.time.field.e.k(i10));
    }

    public Hours multipliedBy(int i10) {
        return hours(org.joda.time.field.e.h(getValue(), i10));
    }

    public Hours negated() {
        return hours(org.joda.time.field.e.k(getValue()));
    }

    public Hours plus(int i10) {
        return i10 == 0 ? this : hours(org.joda.time.field.e.d(getValue(), i10));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / 24);
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 3600000);
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(org.joda.time.field.e.h(getValue(), 60));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(org.joda.time.field.e.h(getValue(), SdkConfigData.DEFAULT_REQUEST_INTERVAL));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 168);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + "H";
    }

    public Hours minus(Hours hours) {
        return hours == null ? this : minus(hours.getValue());
    }

    public Hours plus(Hours hours) {
        return hours == null ? this : plus(hours.getValue());
    }

    public static Hours hoursBetween(k kVar, k kVar2) {
        if ((kVar instanceof LocalTime) && (kVar2 instanceof LocalTime)) {
            return hours(c.c(kVar.getChronology()).hours().getDifference(((LocalTime) kVar2).getLocalMillis(), ((LocalTime) kVar).getLocalMillis()));
        }
        return hours(BaseSingleFieldPeriod.between(kVar, kVar2, ZERO));
    }
}
