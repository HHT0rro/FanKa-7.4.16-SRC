package org.joda.time.chrono;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class BasicGJChronology extends BasicChronology {
    private static final long FEB_29 = 5097600000L;
    private static final long serialVersionUID = 538276888268L;
    private static final int[] MIN_DAYS_PER_MONTH_ARRAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] MAX_DAYS_PER_MONTH_ARRAY = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final long[] MIN_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
    private static final long[] MAX_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];

    static {
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        while (i10 < 11) {
            j10 += MIN_DAYS_PER_MONTH_ARRAY[i10] * 86400000;
            int i11 = i10 + 1;
            MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i11] = j10;
            j11 += MAX_DAYS_PER_MONTH_ARRAY[i10] * 86400000;
            MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i11] = j11;
            i10 = i11;
        }
    }

    public BasicGJChronology(org.joda.time.a aVar, Object obj, int i10) {
        super(aVar, obj, i10);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInMonthMax(int i10) {
        return MAX_DAYS_PER_MONTH_ARRAY[i10 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInMonthMaxForSet(long j10, int i10) {
        if (i10 > 28 || i10 < 1) {
            return getDaysInMonthMax(j10);
        }
        return 28;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInYearMonth(int i10, int i11) {
        if (isLeapYear(i10)) {
            return MAX_DAYS_PER_MONTH_ARRAY[i11 - 1];
        }
        return MIN_DAYS_PER_MONTH_ARRAY[i11 - 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0072 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0082 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6 A[RETURN, SYNTHETIC] */
    @Override // org.joda.time.chrono.BasicChronology
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getMonthOfYear(long r13, int r15) {
        /*
            r12 = this;
            long r0 = r12.getYearMillis(r15)
            long r13 = r13 - r0
            r0 = 10
            long r13 = r13 >> r0
            int r14 = (int) r13
            boolean r13 = r12.isLeapYear(r15)
            r15 = 2
            r1 = 3
            r2 = 5
            r3 = 6
            r4 = 8
            r5 = 9
            r6 = 11
            r7 = 12
            r8 = 1
            r9 = 4
            r10 = 7
            r11 = 2615625(0x27e949, float:3.665271E-39)
            if (r13 == 0) goto L5d
            r13 = 15356250(0xea515a, float:2.151869E-38)
            if (r14 >= r13) goto L40
            r13 = 7678125(0x7528ad, float:1.0759345E-38)
            if (r14 >= r13) goto L34
            if (r14 >= r11) goto L2e
            goto L69
        L2e:
            r13 = 5062500(0x4d3f64, float:7.094073E-39)
            if (r14 >= r13) goto L72
            goto L70
        L34:
            r13 = 10209375(0x9bc85f, float:1.4306382E-38)
            if (r14 >= r13) goto L3a
            goto L79
        L3a:
            r13 = 12825000(0xc3b1a8, float:1.7971653E-38)
            if (r14 >= r13) goto L82
            goto L80
        L40:
            r13 = 23118750(0x160c39e, float:4.128265E-38)
            if (r14 >= r13) goto L51
            r13 = 17971875(0x1123aa3, float:2.6858035E-38)
            if (r14 >= r13) goto L4b
            goto L8e
        L4b:
            r13 = 20587500(0x13a23ec, float:3.4188577E-38)
            if (r14 >= r13) goto L98
            goto L95
        L51:
            r13 = 25734375(0x188ace7, float:5.020661E-38)
            if (r14 >= r13) goto L57
            goto Lab
        L57:
            r13 = 28265625(0x1af4c99, float:6.439476E-38)
            if (r14 >= r13) goto La9
            goto La6
        L5d:
            r13 = 15271875(0xe907c3, float:2.1400455E-38)
            if (r14 >= r13) goto L84
            r13 = 7593750(0x73df16, float:1.064111E-38)
            if (r14 >= r13) goto L74
            if (r14 >= r11) goto L6b
        L69:
            r0 = 1
            goto Lab
        L6b:
            r13 = 4978125(0x4bf5cd, float:6.975839E-39)
            if (r14 >= r13) goto L72
        L70:
            r0 = 2
            goto Lab
        L72:
            r0 = 3
            goto Lab
        L74:
            r13 = 10125000(0x9a7ec8, float:1.4188147E-38)
            if (r14 >= r13) goto L7b
        L79:
            r0 = 4
            goto Lab
        L7b:
            r13 = 12740625(0xc26811, float:1.7853418E-38)
            if (r14 >= r13) goto L82
        L80:
            r0 = 5
            goto Lab
        L82:
            r0 = 6
            goto Lab
        L84:
            r13 = 23034375(0x15f7a07, float:4.1046182E-38)
            if (r14 >= r13) goto L9b
            r13 = 17887500(0x110f10c, float:2.6621566E-38)
            if (r14 >= r13) goto L90
        L8e:
            r0 = 7
            goto Lab
        L90:
            r13 = 20503125(0x138da55, float:3.3952108E-38)
            if (r14 >= r13) goto L98
        L95:
            r0 = 8
            goto Lab
        L98:
            r0 = 9
            goto Lab
        L9b:
            r13 = 25650000(0x1876350, float:4.9733674E-38)
            if (r14 >= r13) goto La1
            goto Lab
        La1:
            r13 = 28181250(0x1ae0302, float:6.392182E-38)
            if (r14 >= r13) goto La9
        La6:
            r0 = 11
            goto Lab
        La9:
            r0 = 12
        Lab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.BasicGJChronology.getMonthOfYear(long, int):int");
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getTotalMillisByYearMonth(int i10, int i11) {
        if (isLeapYear(i10)) {
            return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i11 - 1];
        }
        return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i11 - 1];
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getYearDifference(long j10, long j11) {
        int year = getYear(j10);
        int year2 = getYear(j11);
        long yearMillis = j10 - getYearMillis(year);
        long yearMillis2 = j11 - getYearMillis(year2);
        if (yearMillis2 >= FEB_29) {
            if (isLeapYear(year2)) {
                if (!isLeapYear(year)) {
                    yearMillis2 -= 86400000;
                }
            } else if (yearMillis >= FEB_29 && isLeapYear(year)) {
                yearMillis -= 86400000;
            }
        }
        int i10 = year - year2;
        if (yearMillis < yearMillis2) {
            i10--;
        }
        return i10;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public boolean isLeapDay(long j10) {
        return dayOfMonth().get(j10) == 29 && monthOfYear().isLeap(j10);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long setYear(long j10, int i10) {
        int year = getYear(j10);
        int dayOfYear = getDayOfYear(j10, year);
        int millisOfDay = getMillisOfDay(j10);
        if (dayOfYear > 59) {
            if (isLeapYear(year)) {
                if (!isLeapYear(i10)) {
                    dayOfYear--;
                }
            } else if (isLeapYear(i10)) {
                dayOfYear++;
            }
        }
        return getYearMonthDayMillis(i10, 1, dayOfYear) + millisOfDay;
    }
}
