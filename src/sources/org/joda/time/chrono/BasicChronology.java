package org.joda.time.chrono;

import com.baidu.mobads.sdk.internal.bk;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.MillisDurationField;
import org.joda.time.field.PreciseDurationField;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BasicChronology extends AssembledChronology {
    private static final int CACHE_MASK = 1023;
    private static final int CACHE_SIZE = 1024;
    private static final org.joda.time.b cClockhourOfDayField;
    private static final org.joda.time.b cClockhourOfHalfdayField;
    private static final org.joda.time.d cDaysField;
    private static final org.joda.time.b cHalfdayOfDayField;
    private static final org.joda.time.d cHalfdaysField;
    private static final org.joda.time.b cHourOfDayField;
    private static final org.joda.time.b cHourOfHalfdayField;
    private static final org.joda.time.d cHoursField;
    private static final org.joda.time.d cMillisField;
    private static final org.joda.time.b cMillisOfDayField;
    private static final org.joda.time.b cMillisOfSecondField;
    private static final org.joda.time.b cMinuteOfDayField;
    private static final org.joda.time.b cMinuteOfHourField;
    private static final org.joda.time.d cMinutesField;
    private static final org.joda.time.b cSecondOfDayField;
    private static final org.joda.time.b cSecondOfMinuteField;
    private static final org.joda.time.d cSecondsField;
    private static final org.joda.time.d cWeeksField;
    private static final long serialVersionUID = 8283225332206808863L;
    private final int iMinDaysInFirstWeek;
    private final transient b[] iYearInfoCache;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends org.joda.time.field.g {
        public a() {
            super(DateTimeFieldType.halfdayOfDay(), BasicChronology.cHalfdaysField, BasicChronology.cDaysField);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsText(int i10, Locale locale) {
            return k.h(locale).p(i10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumTextLength(Locale locale) {
            return k.h(locale).l();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long set(long j10, String str, Locale locale) {
            return set(j10, k.h(locale).o(str));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f52475a;

        /* renamed from: b, reason: collision with root package name */
        public final long f52476b;

        public b(int i10, long j10) {
            this.f52475a = i10;
            this.f52476b = j10;
        }
    }

    static {
        org.joda.time.d dVar = MillisDurationField.INSTANCE;
        cMillisField = dVar;
        PreciseDurationField preciseDurationField = new PreciseDurationField(DurationFieldType.seconds(), 1000L);
        cSecondsField = preciseDurationField;
        PreciseDurationField preciseDurationField2 = new PreciseDurationField(DurationFieldType.minutes(), 60000L);
        cMinutesField = preciseDurationField2;
        PreciseDurationField preciseDurationField3 = new PreciseDurationField(DurationFieldType.hours(), 3600000L);
        cHoursField = preciseDurationField3;
        PreciseDurationField preciseDurationField4 = new PreciseDurationField(DurationFieldType.halfdays(), 43200000L);
        cHalfdaysField = preciseDurationField4;
        PreciseDurationField preciseDurationField5 = new PreciseDurationField(DurationFieldType.days(), 86400000L);
        cDaysField = preciseDurationField5;
        cWeeksField = new PreciseDurationField(DurationFieldType.weeks(), bk.f9895d);
        cMillisOfSecondField = new org.joda.time.field.g(DateTimeFieldType.millisOfSecond(), dVar, preciseDurationField);
        cMillisOfDayField = new org.joda.time.field.g(DateTimeFieldType.millisOfDay(), dVar, preciseDurationField5);
        cSecondOfMinuteField = new org.joda.time.field.g(DateTimeFieldType.secondOfMinute(), preciseDurationField, preciseDurationField2);
        cSecondOfDayField = new org.joda.time.field.g(DateTimeFieldType.secondOfDay(), preciseDurationField, preciseDurationField5);
        cMinuteOfHourField = new org.joda.time.field.g(DateTimeFieldType.minuteOfHour(), preciseDurationField2, preciseDurationField3);
        cMinuteOfDayField = new org.joda.time.field.g(DateTimeFieldType.minuteOfDay(), preciseDurationField2, preciseDurationField5);
        org.joda.time.field.g gVar = new org.joda.time.field.g(DateTimeFieldType.hourOfDay(), preciseDurationField3, preciseDurationField5);
        cHourOfDayField = gVar;
        org.joda.time.field.g gVar2 = new org.joda.time.field.g(DateTimeFieldType.hourOfHalfday(), preciseDurationField3, preciseDurationField4);
        cHourOfHalfdayField = gVar2;
        cClockhourOfDayField = new org.joda.time.field.j(gVar, DateTimeFieldType.clockhourOfDay());
        cClockhourOfHalfdayField = new org.joda.time.field.j(gVar2, DateTimeFieldType.clockhourOfHalfday());
        cHalfdayOfDayField = new a();
    }

    public BasicChronology(org.joda.time.a aVar, Object obj, int i10) {
        super(aVar, obj);
        this.iYearInfoCache = new b[1024];
        if (i10 >= 1 && i10 <= 7) {
            this.iMinDaysInFirstWeek = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid min days in first week: " + i10);
    }

    private long getDateTimeMillis0(int i10, int i11, int i12, int i13) {
        long dateMidnightMillis = getDateMidnightMillis(i10, i11, i12);
        if (dateMidnightMillis == Long.MIN_VALUE) {
            dateMidnightMillis = getDateMidnightMillis(i10, i11, i12 + 1);
            i13 -= 86400000;
        }
        long j10 = i13 + dateMidnightMillis;
        if (j10 < 0 && dateMidnightMillis > 0) {
            return Long.MAX_VALUE;
        }
        if (j10 <= 0 || dateMidnightMillis >= 0) {
            return j10;
        }
        return Long.MIN_VALUE;
    }

    private b getYearInfo(int i10) {
        int i11 = i10 & 1023;
        b bVar = this.iYearInfoCache[i11];
        if (bVar != null && bVar.f52475a == i10) {
            return bVar;
        }
        b bVar2 = new b(i10, calculateFirstDayOfYearMillis(i10));
        this.iYearInfoCache[i11] = bVar2;
        return bVar2;
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(AssembledChronology.a aVar) {
        aVar.f52449a = cMillisField;
        aVar.f52450b = cSecondsField;
        aVar.f52451c = cMinutesField;
        aVar.f52452d = cHoursField;
        aVar.f52453e = cHalfdaysField;
        aVar.f52454f = cDaysField;
        aVar.f52455g = cWeeksField;
        aVar.f52461m = cMillisOfSecondField;
        aVar.f52462n = cMillisOfDayField;
        aVar.f52463o = cSecondOfMinuteField;
        aVar.f52464p = cSecondOfDayField;
        aVar.f52465q = cMinuteOfHourField;
        aVar.f52466r = cMinuteOfDayField;
        aVar.f52467s = cHourOfDayField;
        aVar.f52469u = cHourOfHalfdayField;
        aVar.f52468t = cClockhourOfDayField;
        aVar.f52470v = cClockhourOfHalfdayField;
        aVar.f52471w = cHalfdayOfDayField;
        g gVar = new g(this);
        aVar.E = gVar;
        m mVar = new m(gVar, this);
        aVar.F = mVar;
        org.joda.time.field.d dVar = new org.joda.time.field.d(new org.joda.time.field.f(mVar, 99), DateTimeFieldType.centuryOfEra(), 100);
        aVar.H = dVar;
        aVar.f52459k = dVar.getDurationField();
        aVar.G = new org.joda.time.field.f(new org.joda.time.field.i((org.joda.time.field.d) aVar.H), DateTimeFieldType.yearOfCentury(), 1);
        aVar.I = new j(this);
        aVar.f52472x = new i(this, aVar.f52454f);
        aVar.f52473y = new org.joda.time.chrono.a(this, aVar.f52454f);
        aVar.f52474z = new org.joda.time.chrono.b(this, aVar.f52454f);
        aVar.D = new l(this);
        aVar.B = new f(this);
        aVar.A = new e(this, aVar.f52455g);
        aVar.C = new org.joda.time.field.f(new org.joda.time.field.i(aVar.B, aVar.f52459k, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
        aVar.f52458j = aVar.E.getDurationField();
        aVar.f52457i = aVar.D.getDurationField();
        aVar.f52456h = aVar.B.getDurationField();
    }

    public abstract long calculateFirstDayOfYearMillis(int i10);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicChronology basicChronology = (BasicChronology) obj;
        return getMinimumDaysInFirstWeek() == basicChronology.getMinimumDaysInFirstWeek() && getZone().equals(basicChronology.getZone());
    }

    public abstract long getApproxMillisAtEpochDividedByTwo();

    public abstract long getAverageMillisPerMonth();

    public abstract long getAverageMillisPerYear();

    public abstract long getAverageMillisPerYearDividedByTwo();

    public long getDateMidnightMillis(int i10, int i11, int i12) {
        org.joda.time.field.e.o(DateTimeFieldType.year(), i10, getMinYear() - 1, getMaxYear() + 1);
        org.joda.time.field.e.o(DateTimeFieldType.monthOfYear(), i11, 1, getMaxMonth(i10));
        org.joda.time.field.e.o(DateTimeFieldType.dayOfMonth(), i12, 1, getDaysInYearMonth(i10, i11));
        long yearMonthDayMillis = getYearMonthDayMillis(i10, i11, i12);
        if (yearMonthDayMillis < 0 && i10 == getMaxYear() + 1) {
            return Long.MAX_VALUE;
        }
        if (yearMonthDayMillis <= 0 || i10 != getMinYear() - 1) {
            return yearMonthDayMillis;
        }
        return Long.MIN_VALUE;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i10, i11, i12, i13);
        }
        org.joda.time.field.e.o(DateTimeFieldType.millisOfDay(), i13, 0, 86399999);
        return getDateTimeMillis0(i10, i11, i12, i13);
    }

    public int getDayOfMonth(long j10) {
        int year = getYear(j10);
        return getDayOfMonth(j10, year, getMonthOfYear(j10, year));
    }

    public int getDayOfWeek(long j10) {
        long j11;
        if (j10 >= 0) {
            j11 = j10 / 86400000;
        } else {
            j11 = (j10 - 86399999) / 86400000;
            if (j11 < -3) {
                return ((int) ((j11 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j11 + 3) % 7)) + 1;
    }

    public int getDayOfYear(long j10) {
        return getDayOfYear(j10, getYear(j10));
    }

    public int getDaysInMonthMax() {
        return 31;
    }

    public abstract int getDaysInMonthMax(int i10);

    public int getDaysInMonthMax(long j10) {
        int year = getYear(j10);
        return getDaysInYearMonth(year, getMonthOfYear(j10, year));
    }

    public int getDaysInMonthMaxForSet(long j10, int i10) {
        return getDaysInMonthMax(j10);
    }

    public int getDaysInYear(int i10) {
        return isLeapYear(i10) ? 366 : 365;
    }

    public int getDaysInYearMax() {
        return 366;
    }

    public abstract int getDaysInYearMonth(int i10, int i11);

    public long getFirstWeekOfYearMillis(int i10) {
        long yearMillis = getYearMillis(i10);
        return getDayOfWeek(yearMillis) > 8 - this.iMinDaysInFirstWeek ? yearMillis + ((8 - r8) * 86400000) : yearMillis - ((r8 - 1) * 86400000);
    }

    public int getMaxMonth() {
        return 12;
    }

    public int getMaxMonth(int i10) {
        return getMaxMonth();
    }

    public abstract int getMaxYear();

    public int getMillisOfDay(long j10) {
        if (j10 >= 0) {
            return (int) (j10 % 86400000);
        }
        return ((int) ((j10 + 1) % 86400000)) + 86399999;
    }

    public abstract int getMinYear();

    public int getMinimumDaysInFirstWeek() {
        return this.iMinDaysInFirstWeek;
    }

    public int getMonthOfYear(long j10) {
        return getMonthOfYear(j10, getYear(j10));
    }

    public abstract int getMonthOfYear(long j10, int i10);

    public abstract long getTotalMillisByYearMonth(int i10, int i11);

    public int getWeekOfWeekyear(long j10) {
        return getWeekOfWeekyear(j10, getYear(j10));
    }

    public int getWeeksInYear(int i10) {
        return (int) ((getFirstWeekOfYearMillis(i10 + 1) - getFirstWeekOfYearMillis(i10)) / bk.f9895d);
    }

    public int getWeekyear(long j10) {
        int year = getYear(j10);
        int weekOfWeekyear = getWeekOfWeekyear(j10, year);
        if (weekOfWeekyear == 1) {
            return getYear(j10 + bk.f9895d);
        }
        return weekOfWeekyear > 51 ? getYear(j10 - 1209600000) : year;
    }

    public int getYear(long j10) {
        long averageMillisPerYearDividedByTwo = getAverageMillisPerYearDividedByTwo();
        long approxMillisAtEpochDividedByTwo = (j10 >> 1) + getApproxMillisAtEpochDividedByTwo();
        if (approxMillisAtEpochDividedByTwo < 0) {
            approxMillisAtEpochDividedByTwo = (approxMillisAtEpochDividedByTwo - averageMillisPerYearDividedByTwo) + 1;
        }
        int i10 = (int) (approxMillisAtEpochDividedByTwo / averageMillisPerYearDividedByTwo);
        long yearMillis = getYearMillis(i10);
        long j11 = j10 - yearMillis;
        if (j11 < 0) {
            return i10 - 1;
        }
        if (j11 >= 31536000000L) {
            return yearMillis + (isLeapYear(i10) ? 31622400000L : 31536000000L) <= j10 ? i10 + 1 : i10;
        }
        return i10;
    }

    public abstract long getYearDifference(long j10, long j11);

    public long getYearMillis(int i10) {
        return getYearInfo(i10).f52476b;
    }

    public long getYearMonthDayMillis(int i10, int i11, int i12) {
        return getYearMillis(i10) + getTotalMillisByYearMonth(i10, i11) + ((i12 - 1) * 86400000);
    }

    public long getYearMonthMillis(int i10, int i11) {
        return getYearMillis(i10) + getTotalMillisByYearMonth(i10, i11);
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getZone();
        }
        return DateTimeZone.UTC;
    }

    public int hashCode() {
        return (getClass().getName().hashCode() * 11) + getZone().hashCode() + getMinimumDaysInFirstWeek();
    }

    public boolean isLeapDay(long j10) {
        return false;
    }

    public abstract boolean isLeapYear(int i10);

    public abstract long setYear(long j10, int i10);

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        sb2.append(name);
        sb2.append('[');
        DateTimeZone zone = getZone();
        if (zone != null) {
            sb2.append(zone.getID());
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            sb2.append(",mdfw=");
            sb2.append(getMinimumDaysInFirstWeek());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public int getDayOfYear(long j10, int i10) {
        return ((int) ((j10 - getYearMillis(i10)) / 86400000)) + 1;
    }

    public int getWeekOfWeekyear(long j10, int i10) {
        long firstWeekOfYearMillis = getFirstWeekOfYearMillis(i10);
        if (j10 < firstWeekOfYearMillis) {
            return getWeeksInYear(i10 - 1);
        }
        if (j10 >= getFirstWeekOfYearMillis(i10 + 1)) {
            return 1;
        }
        return ((int) ((j10 - firstWeekOfYearMillis) / bk.f9895d)) + 1;
    }

    public int getDayOfMonth(long j10, int i10) {
        return getDayOfMonth(j10, i10, getMonthOfYear(j10, i10));
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13, int i14, int i15, int i16) throws IllegalArgumentException {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16);
        }
        org.joda.time.field.e.o(DateTimeFieldType.hourOfDay(), i13, 0, 23);
        org.joda.time.field.e.o(DateTimeFieldType.minuteOfHour(), i14, 0, 59);
        org.joda.time.field.e.o(DateTimeFieldType.secondOfMinute(), i15, 0, 59);
        org.joda.time.field.e.o(DateTimeFieldType.millisOfSecond(), i16, 0, 999);
        return getDateTimeMillis0(i10, i11, i12, (i13 * 3600000) + (i14 * 60000) + (i15 * 1000) + i16);
    }

    public int getDayOfMonth(long j10, int i10, int i11) {
        return ((int) ((j10 - (getYearMillis(i10) + getTotalMillisByYearMonth(i10, i11))) / 86400000)) + 1;
    }
}
