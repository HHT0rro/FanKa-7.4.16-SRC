package org.joda.time;

import java.math.RoundingMode;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDuration;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Duration extends BaseDuration {
    public static final Duration ZERO = new Duration(0);
    private static final long serialVersionUID = 2471658376918L;

    public Duration(long j10) {
        super(j10);
    }

    public static Duration millis(long j10) {
        if (j10 == 0) {
            return ZERO;
        }
        return new Duration(j10);
    }

    @FromString
    public static Duration parse(String str) {
        return new Duration(str);
    }

    public static Duration standardDays(long j10) {
        if (j10 == 0) {
            return ZERO;
        }
        return new Duration(org.joda.time.field.e.i(j10, 86400000));
    }

    public static Duration standardHours(long j10) {
        if (j10 == 0) {
            return ZERO;
        }
        return new Duration(org.joda.time.field.e.i(j10, 3600000));
    }

    public static Duration standardMinutes(long j10) {
        if (j10 == 0) {
            return ZERO;
        }
        return new Duration(org.joda.time.field.e.i(j10, 60000));
    }

    public static Duration standardSeconds(long j10) {
        if (j10 == 0) {
            return ZERO;
        }
        return new Duration(org.joda.time.field.e.i(j10, 1000));
    }

    public Duration abs() {
        return getMillis() < 0 ? negated() : this;
    }

    public Duration dividedBy(long j10) {
        return j10 == 1 ? this : new Duration(org.joda.time.field.e.f(getMillis(), j10));
    }

    public long getStandardDays() {
        return getMillis() / 86400000;
    }

    public long getStandardHours() {
        return getMillis() / 3600000;
    }

    public long getStandardMinutes() {
        return getMillis() / 60000;
    }

    public long getStandardSeconds() {
        return getMillis() / 1000;
    }

    public Duration minus(long j10) {
        return withDurationAdded(j10, -1);
    }

    public Duration multipliedBy(long j10) {
        return j10 == 1 ? this : new Duration(org.joda.time.field.e.j(getMillis(), j10));
    }

    public Duration negated() {
        if (getMillis() != Long.MIN_VALUE) {
            return new Duration(-getMillis());
        }
        throw new ArithmeticException("Negation of this duration would overflow");
    }

    public Duration plus(long j10) {
        return withDurationAdded(j10, 1);
    }

    @Override // je.b
    public Duration toDuration() {
        return this;
    }

    public Days toStandardDays() {
        return Days.days(org.joda.time.field.e.m(getStandardDays()));
    }

    public Hours toStandardHours() {
        return Hours.hours(org.joda.time.field.e.m(getStandardHours()));
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(org.joda.time.field.e.m(getStandardMinutes()));
    }

    public Seconds toStandardSeconds() {
        return Seconds.seconds(org.joda.time.field.e.m(getStandardSeconds()));
    }

    public Duration withDurationAdded(long j10, int i10) {
        if (j10 == 0 || i10 == 0) {
            return this;
        }
        return new Duration(org.joda.time.field.e.e(getMillis(), org.joda.time.field.e.i(j10, i10)));
    }

    public Duration withMillis(long j10) {
        return j10 == getMillis() ? this : new Duration(j10);
    }

    public Duration(long j10, long j11) {
        super(j10, j11);
    }

    public Duration dividedBy(long j10, RoundingMode roundingMode) {
        return j10 == 1 ? this : new Duration(org.joda.time.field.e.g(getMillis(), j10, roundingMode));
    }

    public Duration minus(h hVar) {
        return hVar == null ? this : withDurationAdded(hVar.getMillis(), -1);
    }

    public Duration plus(h hVar) {
        return hVar == null ? this : withDurationAdded(hVar.getMillis(), 1);
    }

    public Duration(i iVar, i iVar2) {
        super(iVar, iVar2);
    }

    public Duration(Object obj) {
        super(obj);
    }

    public Duration withDurationAdded(h hVar, int i10) {
        return (hVar == null || i10 == 0) ? this : withDurationAdded(hVar.getMillis(), i10);
    }
}
