package org.joda.time;

import com.android.internal.logging.nano.MetricsProto;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Days extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380865L;
    public static final Days ZERO = new Days(0);
    public static final Days ONE = new Days(1);
    public static final Days TWO = new Days(2);
    public static final Days THREE = new Days(3);
    public static final Days FOUR = new Days(4);
    public static final Days FIVE = new Days(5);
    public static final Days SIX = new Days(6);
    public static final Days SEVEN = new Days(7);
    public static final Days MAX_VALUE = new Days(Integer.MAX_VALUE);
    public static final Days MIN_VALUE = new Days(Integer.MIN_VALUE);
    private static final n PARSER = org.joda.time.format.j.a().j(PeriodType.days());

    private Days(int i10) {
        super(i10);
    }

    public static Days days(int i10) {
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
                default:
                    return new Days(i10);
            }
        }
        return MAX_VALUE;
    }

    public static Days daysBetween(i iVar, i iVar2) {
        return days(BaseSingleFieldPeriod.between(iVar, iVar2, DurationFieldType.days()));
    }

    public static Days daysIn(j jVar) {
        if (jVar == null) {
            return ZERO;
        }
        return days(BaseSingleFieldPeriod.between(jVar.getStart(), jVar.getEnd(), DurationFieldType.days()));
    }

    @FromString
    public static Days parseDays(String str) {
        if (str == null) {
            return ZERO;
        }
        return days(PARSER.h(str).getDays());
    }

    private Object readResolve() {
        return days(getValue());
    }

    public static Days standardDaysIn(l lVar) {
        return days(BaseSingleFieldPeriod.standardPeriodIn(lVar, 86400000L));
    }

    public Days dividedBy(int i10) {
        return i10 == 1 ? this : days(getValue() / i10);
    }

    public int getDays() {
        return getValue();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.days();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.l
    public PeriodType getPeriodType() {
        return PeriodType.days();
    }

    public boolean isGreaterThan(Days days) {
        return days == null ? getValue() > 0 : getValue() > days.getValue();
    }

    public boolean isLessThan(Days days) {
        return days == null ? getValue() < 0 : getValue() < days.getValue();
    }

    public Days minus(int i10) {
        return plus(org.joda.time.field.e.k(i10));
    }

    public Days multipliedBy(int i10) {
        return days(org.joda.time.field.e.h(getValue(), i10));
    }

    public Days negated() {
        return days(org.joda.time.field.e.k(getValue()));
    }

    public Days plus(int i10) {
        return i10 == 0 ? this : days(org.joda.time.field.e.d(getValue(), i10));
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 86400000);
    }

    public Hours toStandardHours() {
        return Hours.hours(org.joda.time.field.e.h(getValue(), 24));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(org.joda.time.field.e.h(getValue(), MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(org.joda.time.field.e.h(getValue(), RemoteMessageConst.DEFAULT_TTL));
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 7);
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "D";
    }

    public Days minus(Days days) {
        return days == null ? this : minus(days.getValue());
    }

    public Days plus(Days days) {
        return days == null ? this : plus(days.getValue());
    }

    public static Days daysBetween(k kVar, k kVar2) {
        if ((kVar instanceof LocalDate) && (kVar2 instanceof LocalDate)) {
            return days(c.c(kVar.getChronology()).days().getDifference(((LocalDate) kVar2).getLocalMillis(), ((LocalDate) kVar).getLocalMillis()));
        }
        return days(BaseSingleFieldPeriod.between(kVar, kVar2, ZERO));
    }
}
