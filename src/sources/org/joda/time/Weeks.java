package org.joda.time;

import com.baidu.mobads.sdk.internal.bk;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Weeks extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380866L;
    public static final Weeks ZERO = new Weeks(0);
    public static final Weeks ONE = new Weeks(1);
    public static final Weeks TWO = new Weeks(2);
    public static final Weeks THREE = new Weeks(3);
    public static final Weeks MAX_VALUE = new Weeks(Integer.MAX_VALUE);
    public static final Weeks MIN_VALUE = new Weeks(Integer.MIN_VALUE);
    private static final n PARSER = org.joda.time.format.j.a().j(PeriodType.weeks());

    private Weeks(int i10) {
        super(i10);
    }

    @FromString
    public static Weeks parseWeeks(String str) {
        if (str == null) {
            return ZERO;
        }
        return weeks(PARSER.h(str).getWeeks());
    }

    private Object readResolve() {
        return weeks(getValue());
    }

    public static Weeks standardWeeksIn(l lVar) {
        return weeks(BaseSingleFieldPeriod.standardPeriodIn(lVar, bk.f9895d));
    }

    public static Weeks weeks(int i10) {
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
            return new Weeks(i10);
        }
        return THREE;
    }

    public static Weeks weeksBetween(i iVar, i iVar2) {
        return weeks(BaseSingleFieldPeriod.between(iVar, iVar2, DurationFieldType.weeks()));
    }

    public static Weeks weeksIn(j jVar) {
        if (jVar == null) {
            return ZERO;
        }
        return weeks(BaseSingleFieldPeriod.between(jVar.getStart(), jVar.getEnd(), DurationFieldType.weeks()));
    }

    public Weeks dividedBy(int i10) {
        return i10 == 1 ? this : weeks(getValue() / i10);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.weeks();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.l
    public PeriodType getPeriodType() {
        return PeriodType.weeks();
    }

    public int getWeeks() {
        return getValue();
    }

    public boolean isGreaterThan(Weeks weeks) {
        return weeks == null ? getValue() > 0 : getValue() > weeks.getValue();
    }

    public boolean isLessThan(Weeks weeks) {
        return weeks == null ? getValue() < 0 : getValue() < weeks.getValue();
    }

    public Weeks minus(int i10) {
        return plus(org.joda.time.field.e.k(i10));
    }

    public Weeks multipliedBy(int i10) {
        return weeks(org.joda.time.field.e.h(getValue(), i10));
    }

    public Weeks negated() {
        return weeks(org.joda.time.field.e.k(getValue()));
    }

    public Weeks plus(int i10) {
        return i10 == 0 ? this : weeks(org.joda.time.field.e.d(getValue(), i10));
    }

    public Days toStandardDays() {
        return Days.days(org.joda.time.field.e.h(getValue(), 7));
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * bk.f9895d);
    }

    public Hours toStandardHours() {
        return Hours.hours(org.joda.time.field.e.h(getValue(), 168));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(org.joda.time.field.e.h(getValue(), 10080));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(org.joda.time.field.e.h(getValue(), 604800));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "W";
    }

    public Weeks minus(Weeks weeks) {
        return weeks == null ? this : minus(weeks.getValue());
    }

    public Weeks plus(Weeks weeks) {
        return weeks == null ? this : plus(weeks.getValue());
    }

    public static Weeks weeksBetween(k kVar, k kVar2) {
        if ((kVar instanceof LocalDate) && (kVar2 instanceof LocalDate)) {
            return weeks(c.c(kVar.getChronology()).weeks().getDifference(((LocalDate) kVar2).getLocalMillis(), ((LocalDate) kVar).getLocalMillis()));
        }
        return weeks(BaseSingleFieldPeriod.between(kVar, kVar2, ZERO));
    }
}
