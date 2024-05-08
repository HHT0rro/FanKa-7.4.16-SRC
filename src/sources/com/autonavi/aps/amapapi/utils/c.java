package com.autonavi.aps.amapapi.utils;

import java.util.Calendar;
import java.util.Date;

/* compiled from: DateUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {
    public static long a(long j10, long j11, int i10) {
        if (i10 <= 0) {
            return j10;
        }
        try {
            return Math.abs(j10 - j11) > ((long) i10) * 31536000000L ? a(j10, j11) : j10;
        } catch (Throwable unused) {
            return j10;
        }
    }

    private static long b(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j10));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long a(long j10, long j11) {
        long b4 = b(j11) + a(j10);
        long abs = Math.abs(b4 - j11);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(b4));
        int i10 = calendar.get(11);
        if (i10 == 23 && abs >= 82800000) {
            b4 -= 86400000;
        }
        return (i10 != 0 || abs < 82800000) ? b4 : b4 + 86400000;
    }

    private static long a(long j10) {
        return j10 - b(j10);
    }
}
