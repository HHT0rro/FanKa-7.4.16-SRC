package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.joda.time.DateTimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AssembledChronology extends BaseChronology {
    private static final long serialVersionUID = -6728465968995518215L;
    private final org.joda.time.a iBase;
    private transient int iBaseFlags;
    private transient org.joda.time.d iCenturies;
    private transient org.joda.time.b iCenturyOfEra;
    private transient org.joda.time.b iClockhourOfDay;
    private transient org.joda.time.b iClockhourOfHalfday;
    private transient org.joda.time.b iDayOfMonth;
    private transient org.joda.time.b iDayOfWeek;
    private transient org.joda.time.b iDayOfYear;
    private transient org.joda.time.d iDays;
    private transient org.joda.time.b iEra;
    private transient org.joda.time.d iEras;
    private transient org.joda.time.b iHalfdayOfDay;
    private transient org.joda.time.d iHalfdays;
    private transient org.joda.time.b iHourOfDay;
    private transient org.joda.time.b iHourOfHalfday;
    private transient org.joda.time.d iHours;
    private transient org.joda.time.d iMillis;
    private transient org.joda.time.b iMillisOfDay;
    private transient org.joda.time.b iMillisOfSecond;
    private transient org.joda.time.b iMinuteOfDay;
    private transient org.joda.time.b iMinuteOfHour;
    private transient org.joda.time.d iMinutes;
    private transient org.joda.time.b iMonthOfYear;
    private transient org.joda.time.d iMonths;
    private final Object iParam;
    private transient org.joda.time.b iSecondOfDay;
    private transient org.joda.time.b iSecondOfMinute;
    private transient org.joda.time.d iSeconds;
    private transient org.joda.time.b iWeekOfWeekyear;
    private transient org.joda.time.d iWeeks;
    private transient org.joda.time.b iWeekyear;
    private transient org.joda.time.b iWeekyearOfCentury;
    private transient org.joda.time.d iWeekyears;
    private transient org.joda.time.b iYear;
    private transient org.joda.time.b iYearOfCentury;
    private transient org.joda.time.b iYearOfEra;
    private transient org.joda.time.d iYears;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public org.joda.time.b A;
        public org.joda.time.b B;
        public org.joda.time.b C;
        public org.joda.time.b D;
        public org.joda.time.b E;
        public org.joda.time.b F;
        public org.joda.time.b G;
        public org.joda.time.b H;
        public org.joda.time.b I;

        /* renamed from: a, reason: collision with root package name */
        public org.joda.time.d f52449a;

        /* renamed from: b, reason: collision with root package name */
        public org.joda.time.d f52450b;

        /* renamed from: c, reason: collision with root package name */
        public org.joda.time.d f52451c;

        /* renamed from: d, reason: collision with root package name */
        public org.joda.time.d f52452d;

        /* renamed from: e, reason: collision with root package name */
        public org.joda.time.d f52453e;

        /* renamed from: f, reason: collision with root package name */
        public org.joda.time.d f52454f;

        /* renamed from: g, reason: collision with root package name */
        public org.joda.time.d f52455g;

        /* renamed from: h, reason: collision with root package name */
        public org.joda.time.d f52456h;

        /* renamed from: i, reason: collision with root package name */
        public org.joda.time.d f52457i;

        /* renamed from: j, reason: collision with root package name */
        public org.joda.time.d f52458j;

        /* renamed from: k, reason: collision with root package name */
        public org.joda.time.d f52459k;

        /* renamed from: l, reason: collision with root package name */
        public org.joda.time.d f52460l;

        /* renamed from: m, reason: collision with root package name */
        public org.joda.time.b f52461m;

        /* renamed from: n, reason: collision with root package name */
        public org.joda.time.b f52462n;

        /* renamed from: o, reason: collision with root package name */
        public org.joda.time.b f52463o;

        /* renamed from: p, reason: collision with root package name */
        public org.joda.time.b f52464p;

        /* renamed from: q, reason: collision with root package name */
        public org.joda.time.b f52465q;

        /* renamed from: r, reason: collision with root package name */
        public org.joda.time.b f52466r;

        /* renamed from: s, reason: collision with root package name */
        public org.joda.time.b f52467s;

        /* renamed from: t, reason: collision with root package name */
        public org.joda.time.b f52468t;

        /* renamed from: u, reason: collision with root package name */
        public org.joda.time.b f52469u;

        /* renamed from: v, reason: collision with root package name */
        public org.joda.time.b f52470v;

        /* renamed from: w, reason: collision with root package name */
        public org.joda.time.b f52471w;

        /* renamed from: x, reason: collision with root package name */
        public org.joda.time.b f52472x;

        /* renamed from: y, reason: collision with root package name */
        public org.joda.time.b f52473y;

        /* renamed from: z, reason: collision with root package name */
        public org.joda.time.b f52474z;

        public static boolean b(org.joda.time.b bVar) {
            if (bVar == null) {
                return false;
            }
            return bVar.isSupported();
        }

        public static boolean c(org.joda.time.d dVar) {
            if (dVar == null) {
                return false;
            }
            return dVar.isSupported();
        }

        public void a(org.joda.time.a aVar) {
            org.joda.time.d millis = aVar.millis();
            if (c(millis)) {
                this.f52449a = millis;
            }
            org.joda.time.d seconds = aVar.seconds();
            if (c(seconds)) {
                this.f52450b = seconds;
            }
            org.joda.time.d minutes = aVar.minutes();
            if (c(minutes)) {
                this.f52451c = minutes;
            }
            org.joda.time.d hours = aVar.hours();
            if (c(hours)) {
                this.f52452d = hours;
            }
            org.joda.time.d halfdays = aVar.halfdays();
            if (c(halfdays)) {
                this.f52453e = halfdays;
            }
            org.joda.time.d days = aVar.days();
            if (c(days)) {
                this.f52454f = days;
            }
            org.joda.time.d weeks = aVar.weeks();
            if (c(weeks)) {
                this.f52455g = weeks;
            }
            org.joda.time.d weekyears = aVar.weekyears();
            if (c(weekyears)) {
                this.f52456h = weekyears;
            }
            org.joda.time.d months = aVar.months();
            if (c(months)) {
                this.f52457i = months;
            }
            org.joda.time.d years = aVar.years();
            if (c(years)) {
                this.f52458j = years;
            }
            org.joda.time.d centuries = aVar.centuries();
            if (c(centuries)) {
                this.f52459k = centuries;
            }
            org.joda.time.d eras = aVar.eras();
            if (c(eras)) {
                this.f52460l = eras;
            }
            org.joda.time.b millisOfSecond = aVar.millisOfSecond();
            if (b(millisOfSecond)) {
                this.f52461m = millisOfSecond;
            }
            org.joda.time.b millisOfDay = aVar.millisOfDay();
            if (b(millisOfDay)) {
                this.f52462n = millisOfDay;
            }
            org.joda.time.b secondOfMinute = aVar.secondOfMinute();
            if (b(secondOfMinute)) {
                this.f52463o = secondOfMinute;
            }
            org.joda.time.b secondOfDay = aVar.secondOfDay();
            if (b(secondOfDay)) {
                this.f52464p = secondOfDay;
            }
            org.joda.time.b minuteOfHour = aVar.minuteOfHour();
            if (b(minuteOfHour)) {
                this.f52465q = minuteOfHour;
            }
            org.joda.time.b minuteOfDay = aVar.minuteOfDay();
            if (b(minuteOfDay)) {
                this.f52466r = minuteOfDay;
            }
            org.joda.time.b hourOfDay = aVar.hourOfDay();
            if (b(hourOfDay)) {
                this.f52467s = hourOfDay;
            }
            org.joda.time.b clockhourOfDay = aVar.clockhourOfDay();
            if (b(clockhourOfDay)) {
                this.f52468t = clockhourOfDay;
            }
            org.joda.time.b hourOfHalfday = aVar.hourOfHalfday();
            if (b(hourOfHalfday)) {
                this.f52469u = hourOfHalfday;
            }
            org.joda.time.b clockhourOfHalfday = aVar.clockhourOfHalfday();
            if (b(clockhourOfHalfday)) {
                this.f52470v = clockhourOfHalfday;
            }
            org.joda.time.b halfdayOfDay = aVar.halfdayOfDay();
            if (b(halfdayOfDay)) {
                this.f52471w = halfdayOfDay;
            }
            org.joda.time.b dayOfWeek = aVar.dayOfWeek();
            if (b(dayOfWeek)) {
                this.f52472x = dayOfWeek;
            }
            org.joda.time.b dayOfMonth = aVar.dayOfMonth();
            if (b(dayOfMonth)) {
                this.f52473y = dayOfMonth;
            }
            org.joda.time.b dayOfYear = aVar.dayOfYear();
            if (b(dayOfYear)) {
                this.f52474z = dayOfYear;
            }
            org.joda.time.b weekOfWeekyear = aVar.weekOfWeekyear();
            if (b(weekOfWeekyear)) {
                this.A = weekOfWeekyear;
            }
            org.joda.time.b weekyear = aVar.weekyear();
            if (b(weekyear)) {
                this.B = weekyear;
            }
            org.joda.time.b weekyearOfCentury = aVar.weekyearOfCentury();
            if (b(weekyearOfCentury)) {
                this.C = weekyearOfCentury;
            }
            org.joda.time.b monthOfYear = aVar.monthOfYear();
            if (b(monthOfYear)) {
                this.D = monthOfYear;
            }
            org.joda.time.b year = aVar.year();
            if (b(year)) {
                this.E = year;
            }
            org.joda.time.b yearOfEra = aVar.yearOfEra();
            if (b(yearOfEra)) {
                this.F = yearOfEra;
            }
            org.joda.time.b yearOfCentury = aVar.yearOfCentury();
            if (b(yearOfCentury)) {
                this.G = yearOfCentury;
            }
            org.joda.time.b centuryOfEra = aVar.centuryOfEra();
            if (b(centuryOfEra)) {
                this.H = centuryOfEra;
            }
            org.joda.time.b era = aVar.era();
            if (b(era)) {
                this.I = era;
            }
        }
    }

    public AssembledChronology(org.joda.time.a aVar, Object obj) {
        this.iBase = aVar;
        this.iParam = obj;
        setFields();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setFields();
    }

    private void setFields() {
        a aVar = new a();
        org.joda.time.a aVar2 = this.iBase;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        assemble(aVar);
        org.joda.time.d dVar = aVar.f52449a;
        if (dVar == null) {
            dVar = super.millis();
        }
        this.iMillis = dVar;
        org.joda.time.d dVar2 = aVar.f52450b;
        if (dVar2 == null) {
            dVar2 = super.seconds();
        }
        this.iSeconds = dVar2;
        org.joda.time.d dVar3 = aVar.f52451c;
        if (dVar3 == null) {
            dVar3 = super.minutes();
        }
        this.iMinutes = dVar3;
        org.joda.time.d dVar4 = aVar.f52452d;
        if (dVar4 == null) {
            dVar4 = super.hours();
        }
        this.iHours = dVar4;
        org.joda.time.d dVar5 = aVar.f52453e;
        if (dVar5 == null) {
            dVar5 = super.halfdays();
        }
        this.iHalfdays = dVar5;
        org.joda.time.d dVar6 = aVar.f52454f;
        if (dVar6 == null) {
            dVar6 = super.days();
        }
        this.iDays = dVar6;
        org.joda.time.d dVar7 = aVar.f52455g;
        if (dVar7 == null) {
            dVar7 = super.weeks();
        }
        this.iWeeks = dVar7;
        org.joda.time.d dVar8 = aVar.f52456h;
        if (dVar8 == null) {
            dVar8 = super.weekyears();
        }
        this.iWeekyears = dVar8;
        org.joda.time.d dVar9 = aVar.f52457i;
        if (dVar9 == null) {
            dVar9 = super.months();
        }
        this.iMonths = dVar9;
        org.joda.time.d dVar10 = aVar.f52458j;
        if (dVar10 == null) {
            dVar10 = super.years();
        }
        this.iYears = dVar10;
        org.joda.time.d dVar11 = aVar.f52459k;
        if (dVar11 == null) {
            dVar11 = super.centuries();
        }
        this.iCenturies = dVar11;
        org.joda.time.d dVar12 = aVar.f52460l;
        if (dVar12 == null) {
            dVar12 = super.eras();
        }
        this.iEras = dVar12;
        org.joda.time.b bVar = aVar.f52461m;
        if (bVar == null) {
            bVar = super.millisOfSecond();
        }
        this.iMillisOfSecond = bVar;
        org.joda.time.b bVar2 = aVar.f52462n;
        if (bVar2 == null) {
            bVar2 = super.millisOfDay();
        }
        this.iMillisOfDay = bVar2;
        org.joda.time.b bVar3 = aVar.f52463o;
        if (bVar3 == null) {
            bVar3 = super.secondOfMinute();
        }
        this.iSecondOfMinute = bVar3;
        org.joda.time.b bVar4 = aVar.f52464p;
        if (bVar4 == null) {
            bVar4 = super.secondOfDay();
        }
        this.iSecondOfDay = bVar4;
        org.joda.time.b bVar5 = aVar.f52465q;
        if (bVar5 == null) {
            bVar5 = super.minuteOfHour();
        }
        this.iMinuteOfHour = bVar5;
        org.joda.time.b bVar6 = aVar.f52466r;
        if (bVar6 == null) {
            bVar6 = super.minuteOfDay();
        }
        this.iMinuteOfDay = bVar6;
        org.joda.time.b bVar7 = aVar.f52467s;
        if (bVar7 == null) {
            bVar7 = super.hourOfDay();
        }
        this.iHourOfDay = bVar7;
        org.joda.time.b bVar8 = aVar.f52468t;
        if (bVar8 == null) {
            bVar8 = super.clockhourOfDay();
        }
        this.iClockhourOfDay = bVar8;
        org.joda.time.b bVar9 = aVar.f52469u;
        if (bVar9 == null) {
            bVar9 = super.hourOfHalfday();
        }
        this.iHourOfHalfday = bVar9;
        org.joda.time.b bVar10 = aVar.f52470v;
        if (bVar10 == null) {
            bVar10 = super.clockhourOfHalfday();
        }
        this.iClockhourOfHalfday = bVar10;
        org.joda.time.b bVar11 = aVar.f52471w;
        if (bVar11 == null) {
            bVar11 = super.halfdayOfDay();
        }
        this.iHalfdayOfDay = bVar11;
        org.joda.time.b bVar12 = aVar.f52472x;
        if (bVar12 == null) {
            bVar12 = super.dayOfWeek();
        }
        this.iDayOfWeek = bVar12;
        org.joda.time.b bVar13 = aVar.f52473y;
        if (bVar13 == null) {
            bVar13 = super.dayOfMonth();
        }
        this.iDayOfMonth = bVar13;
        org.joda.time.b bVar14 = aVar.f52474z;
        if (bVar14 == null) {
            bVar14 = super.dayOfYear();
        }
        this.iDayOfYear = bVar14;
        org.joda.time.b bVar15 = aVar.A;
        if (bVar15 == null) {
            bVar15 = super.weekOfWeekyear();
        }
        this.iWeekOfWeekyear = bVar15;
        org.joda.time.b bVar16 = aVar.B;
        if (bVar16 == null) {
            bVar16 = super.weekyear();
        }
        this.iWeekyear = bVar16;
        org.joda.time.b bVar17 = aVar.C;
        if (bVar17 == null) {
            bVar17 = super.weekyearOfCentury();
        }
        this.iWeekyearOfCentury = bVar17;
        org.joda.time.b bVar18 = aVar.D;
        if (bVar18 == null) {
            bVar18 = super.monthOfYear();
        }
        this.iMonthOfYear = bVar18;
        org.joda.time.b bVar19 = aVar.E;
        if (bVar19 == null) {
            bVar19 = super.year();
        }
        this.iYear = bVar19;
        org.joda.time.b bVar20 = aVar.F;
        if (bVar20 == null) {
            bVar20 = super.yearOfEra();
        }
        this.iYearOfEra = bVar20;
        org.joda.time.b bVar21 = aVar.G;
        if (bVar21 == null) {
            bVar21 = super.yearOfCentury();
        }
        this.iYearOfCentury = bVar21;
        org.joda.time.b bVar22 = aVar.H;
        if (bVar22 == null) {
            bVar22 = super.centuryOfEra();
        }
        this.iCenturyOfEra = bVar22;
        org.joda.time.b bVar23 = aVar.I;
        if (bVar23 == null) {
            bVar23 = super.era();
        }
        this.iEra = bVar23;
        org.joda.time.a aVar3 = this.iBase;
        int i10 = 0;
        if (aVar3 != null) {
            int i11 = ((this.iHourOfDay == aVar3.hourOfDay() && this.iMinuteOfHour == this.iBase.minuteOfHour() && this.iSecondOfMinute == this.iBase.secondOfMinute() && this.iMillisOfSecond == this.iBase.millisOfSecond()) ? 1 : 0) | (this.iMillisOfDay == this.iBase.millisOfDay() ? 2 : 0);
            if (this.iYear == this.iBase.year() && this.iMonthOfYear == this.iBase.monthOfYear() && this.iDayOfMonth == this.iBase.dayOfMonth()) {
                i10 = 4;
            }
            i10 |= i11;
        }
        this.iBaseFlags = i10;
    }

    public abstract void assemble(a aVar);

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d centuries() {
        return this.iCenturies;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b centuryOfEra() {
        return this.iCenturyOfEra;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b clockhourOfDay() {
        return this.iClockhourOfDay;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b clockhourOfHalfday() {
        return this.iClockhourOfHalfday;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b dayOfMonth() {
        return this.iDayOfMonth;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b dayOfWeek() {
        return this.iDayOfWeek;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b dayOfYear() {
        return this.iDayOfYear;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d days() {
        return this.iDays;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b era() {
        return this.iEra;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d eras() {
        return this.iEras;
    }

    public final org.joda.time.a getBase() {
        return this.iBase;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null && (this.iBaseFlags & 6) == 6) {
            return aVar.getDateTimeMillis(i10, i11, i12, i13);
        }
        return super.getDateTimeMillis(i10, i11, i12, i13);
    }

    public final Object getParam() {
        return this.iParam;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null) {
            return aVar.getZone();
        }
        return null;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b halfdayOfDay() {
        return this.iHalfdayOfDay;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d halfdays() {
        return this.iHalfdays;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b hourOfDay() {
        return this.iHourOfDay;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b hourOfHalfday() {
        return this.iHourOfHalfday;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d hours() {
        return this.iHours;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d millis() {
        return this.iMillis;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b millisOfDay() {
        return this.iMillisOfDay;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b millisOfSecond() {
        return this.iMillisOfSecond;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b minuteOfDay() {
        return this.iMinuteOfDay;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b minuteOfHour() {
        return this.iMinuteOfHour;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d minutes() {
        return this.iMinutes;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b monthOfYear() {
        return this.iMonthOfYear;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d months() {
        return this.iMonths;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b secondOfDay() {
        return this.iSecondOfDay;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b secondOfMinute() {
        return this.iSecondOfMinute;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d seconds() {
        return this.iSeconds;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b weekOfWeekyear() {
        return this.iWeekOfWeekyear;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d weeks() {
        return this.iWeeks;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b weekyear() {
        return this.iWeekyear;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b weekyearOfCentury() {
        return this.iWeekyearOfCentury;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d weekyears() {
        return this.iWeekyears;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b year() {
        return this.iYear;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b yearOfCentury() {
        return this.iYearOfCentury;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b yearOfEra() {
        return this.iYearOfEra;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.d years() {
        return this.iYears;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13, int i14, int i15, int i16) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null && (this.iBaseFlags & 5) == 5) {
            return aVar.getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16);
        }
        return super.getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(long j10, int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null && (this.iBaseFlags & 1) == 1) {
            return aVar.getDateTimeMillis(j10, i10, i11, i12, i13);
        }
        return super.getDateTimeMillis(j10, i10, i11, i12, i13);
    }
}
