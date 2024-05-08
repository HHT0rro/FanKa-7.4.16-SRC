package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Months extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380867L;
    public static final Months ZERO = new Months(0);
    public static final Months ONE = new Months(1);
    public static final Months TWO = new Months(2);
    public static final Months THREE = new Months(3);
    public static final Months FOUR = new Months(4);
    public static final Months FIVE = new Months(5);
    public static final Months SIX = new Months(6);
    public static final Months SEVEN = new Months(7);
    public static final Months EIGHT = new Months(8);
    public static final Months NINE = new Months(9);
    public static final Months TEN = new Months(10);
    public static final Months ELEVEN = new Months(11);
    public static final Months TWELVE = new Months(12);
    public static final Months MAX_VALUE = new Months(Integer.MAX_VALUE);
    public static final Months MIN_VALUE = new Months(Integer.MIN_VALUE);
    private static final n PARSER = org.joda.time.format.j.a().j(PeriodType.months());

    private Months(int i10) {
        super(i10);
    }

    public static Months months(int i10) {
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
                case 9:
                    return NINE;
                case 10:
                    return TEN;
                case 11:
                    return ELEVEN;
                case 12:
                    return TWELVE;
                default:
                    return new Months(i10);
            }
        }
        return MAX_VALUE;
    }

    public static Months monthsBetween(i iVar, i iVar2) {
        return months(BaseSingleFieldPeriod.between(iVar, iVar2, DurationFieldType.months()));
    }

    public static Months monthsIn(j jVar) {
        if (jVar == null) {
            return ZERO;
        }
        return months(BaseSingleFieldPeriod.between(jVar.getStart(), jVar.getEnd(), DurationFieldType.months()));
    }

    @FromString
    public static Months parseMonths(String str) {
        if (str == null) {
            return ZERO;
        }
        return months(PARSER.h(str).getMonths());
    }

    private Object readResolve() {
        return months(getValue());
    }

    public Months dividedBy(int i10) {
        return i10 == 1 ? this : months(getValue() / i10);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.months();
    }

    public int getMonths() {
        return getValue();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.l
    public PeriodType getPeriodType() {
        return PeriodType.months();
    }

    public boolean isGreaterThan(Months months) {
        return months == null ? getValue() > 0 : getValue() > months.getValue();
    }

    public boolean isLessThan(Months months) {
        return months == null ? getValue() < 0 : getValue() < months.getValue();
    }

    public Months minus(int i10) {
        return plus(org.joda.time.field.e.k(i10));
    }

    public Months multipliedBy(int i10) {
        return months(org.joda.time.field.e.h(getValue(), i10));
    }

    public Months negated() {
        return months(org.joda.time.field.e.k(getValue()));
    }

    public Months plus(int i10) {
        return i10 == 0 ? this : months(org.joda.time.field.e.d(getValue(), i10));
    }

    @ToString
    public String toString() {
        return "P" + String.valueOf(getValue()) + "M";
    }

    public Months minus(Months months) {
        return months == null ? this : minus(months.getValue());
    }

    public Months plus(Months months) {
        return months == null ? this : plus(months.getValue());
    }

    public static Months monthsBetween(k kVar, k kVar2) {
        if ((kVar instanceof LocalDate) && (kVar2 instanceof LocalDate)) {
            return months(c.c(kVar.getChronology()).months().getDifference(((LocalDate) kVar2).getLocalMillis(), ((LocalDate) kVar).getLocalMillis()));
        }
        return months(BaseSingleFieldPeriod.between(kVar, kVar2, ZERO));
    }
}
