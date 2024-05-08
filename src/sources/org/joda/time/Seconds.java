package org.joda.time;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.sdk.core.response.model.SdkConfigData;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Seconds extends BaseSingleFieldPeriod {
    private static final long serialVersionUID = 87525275727380862L;
    public static final Seconds ZERO = new Seconds(0);
    public static final Seconds ONE = new Seconds(1);
    public static final Seconds TWO = new Seconds(2);
    public static final Seconds THREE = new Seconds(3);
    public static final Seconds MAX_VALUE = new Seconds(Integer.MAX_VALUE);
    public static final Seconds MIN_VALUE = new Seconds(Integer.MIN_VALUE);
    private static final n PARSER = org.joda.time.format.j.a().j(PeriodType.seconds());

    private Seconds(int i10) {
        super(i10);
    }

    @FromString
    public static Seconds parseSeconds(String str) {
        if (str == null) {
            return ZERO;
        }
        return seconds(PARSER.h(str).getSeconds());
    }

    private Object readResolve() {
        return seconds(getValue());
    }

    public static Seconds seconds(int i10) {
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
            return new Seconds(i10);
        }
        return THREE;
    }

    public static Seconds secondsBetween(i iVar, i iVar2) {
        return seconds(BaseSingleFieldPeriod.between(iVar, iVar2, DurationFieldType.seconds()));
    }

    public static Seconds secondsIn(j jVar) {
        if (jVar == null) {
            return ZERO;
        }
        return seconds(BaseSingleFieldPeriod.between(jVar.getStart(), jVar.getEnd(), DurationFieldType.seconds()));
    }

    public static Seconds standardSecondsIn(l lVar) {
        return seconds(BaseSingleFieldPeriod.standardPeriodIn(lVar, 1000L));
    }

    public Seconds dividedBy(int i10) {
        return i10 == 1 ? this : seconds(getValue() / i10);
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod
    public DurationFieldType getFieldType() {
        return DurationFieldType.seconds();
    }

    @Override // org.joda.time.base.BaseSingleFieldPeriod, org.joda.time.l
    public PeriodType getPeriodType() {
        return PeriodType.seconds();
    }

    public int getSeconds() {
        return getValue();
    }

    public boolean isGreaterThan(Seconds seconds) {
        return seconds == null ? getValue() > 0 : getValue() > seconds.getValue();
    }

    public boolean isLessThan(Seconds seconds) {
        return seconds == null ? getValue() < 0 : getValue() < seconds.getValue();
    }

    public Seconds minus(int i10) {
        return plus(org.joda.time.field.e.k(i10));
    }

    public Seconds multipliedBy(int i10) {
        return seconds(org.joda.time.field.e.h(getValue(), i10));
    }

    public Seconds negated() {
        return seconds(org.joda.time.field.e.k(getValue()));
    }

    public Seconds plus(int i10) {
        return i10 == 0 ? this : seconds(org.joda.time.field.e.d(getValue(), i10));
    }

    public Days toStandardDays() {
        return Days.days(getValue() / RemoteMessageConst.DEFAULT_TTL);
    }

    public Duration toStandardDuration() {
        return new Duration(getValue() * 1000);
    }

    public Hours toStandardHours() {
        return Hours.hours(getValue() / SdkConfigData.DEFAULT_REQUEST_INTERVAL);
    }

    public Minutes toStandardMinutes() {
        return Minutes.minutes(getValue() / 60);
    }

    public Weeks toStandardWeeks() {
        return Weeks.weeks(getValue() / 604800);
    }

    @ToString
    public String toString() {
        return "PT" + String.valueOf(getValue()) + ExifInterface.LATITUDE_SOUTH;
    }

    public Seconds minus(Seconds seconds) {
        return seconds == null ? this : minus(seconds.getValue());
    }

    public Seconds plus(Seconds seconds) {
        return seconds == null ? this : plus(seconds.getValue());
    }

    public static Seconds secondsBetween(k kVar, k kVar2) {
        if ((kVar instanceof LocalTime) && (kVar2 instanceof LocalTime)) {
            return seconds(c.c(kVar.getChronology()).seconds().getDifference(((LocalTime) kVar2).getLocalMillis(), ((LocalTime) kVar).getLocalMillis()));
        }
        return seconds(BaseSingleFieldPeriod.between(kVar, kVar2, ZERO));
    }
}
