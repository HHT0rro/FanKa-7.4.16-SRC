package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Years extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380868L;
    public static final Years ZERO = new Years(0);
    public static final Years ONE = new Years(1);
    public static final Years TWO = new Years(2);
    public static final Years THREE = new Years(3);
    public static final Years MAX_VALUE = new Years(Integer.MAX_VALUE);
    public static final Years MIN_VALUE = new Years(Integer.MIN_VALUE);
    private static final n PARSER = org.joda.time.format.j.a().j(PeriodType.years());

    private Years(int i10) {
        super(i10);
    }

    @FromString
    public static Years parseYears(String str) {
        if (str == null) {
            return ZERO;
        }
        return years(PARSER.h(str).getYears());
    }

    private Object readResolve() {
        return years(getValue());
    }

    public static Years years(int i10) {
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
            return new Years(i10);
        }
        return THREE;
    }

    public static Years yearsBetween(i iVar, i iVar2) {
        return years(BaseSingleFieldPeriod.between(iVar, iVar2, DurationFieldType.years()));
    }

    public static Years yearsIn(j jVar) {
        if (jVar == null) {
            return ZERO;
        }
        return years(BaseSingleFieldPeriod.between(jVar.getStart(), jVar.getEnd(), DurationFieldType.years()));
    }

    public Years dividedBy(int i10) {
        return i10 == 1 ? this : years(getValue() / i10);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.years();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.l
    public PeriodType getPeriodType() {
        return PeriodType.years();
    }

    public int getYears() {
        return getValue();
    }

    public boolean isGreaterThan(Years years) {
        return years == null ? getValue() > 0 : getValue() > years.getValue();
    }

    public boolean isLessThan(Years years) {
        return years == null ? getValue() < 0 : getValue() < years.getValue();
    }

    public Years minus(int i10) {
        return plus(org.joda.time.field.e.k(i10));
    }

    public Years multipliedBy(int i10) {
        return years(org.joda.time.field.e.h(getValue(), i10));
    }

    public Years negated() {
        return years(org.joda.time.field.e.k(getValue()));
    }

    public Years plus(int i10) {
        return i10 == 0 ? this : years(org.joda.time.field.e.d(getValue(), i10));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "Y";
    }

    public Years minus(Years years) {
        return years == null ? this : minus(years.getValue());
    }

    public Years plus(Years years) {
        return years == null ? this : plus(years.getValue());
    }

    public static Years yearsBetween(k kVar, k kVar2) {
        if ((kVar instanceof LocalDate) && (kVar2 instanceof LocalDate)) {
            return years(c.c(kVar.getChronology()).years().getDifference(((LocalDate) kVar2).getLocalMillis(), ((LocalDate) kVar).getLocalMillis()));
        }
        return years(BaseSingleFieldPeriod.between(kVar, kVar2, ZERO));
    }
}
