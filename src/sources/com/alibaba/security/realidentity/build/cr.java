package com.alibaba.security.realidentity.build;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: DateUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cr {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3358a = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";

    /* renamed from: b, reason: collision with root package name */
    private static final String f3359b = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /* renamed from: c, reason: collision with root package name */
    private static final String f3360c = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /* renamed from: d, reason: collision with root package name */
    private static volatile long f3361d;

    public static String a(Date date) {
        return c().format(date);
    }

    private static String b(Date date) {
        return d().format(date);
    }

    private static DateFormat c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f3358a, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZones.GMT_ID));
        return simpleDateFormat;
    }

    private static DateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f3359b, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZones.GMT_ID));
        return simpleDateFormat;
    }

    private static DateFormat e() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f3360c, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZones.GMT_ID));
        return simpleDateFormat;
    }

    public static Date a(String str) throws ParseException {
        return c().parse(str);
    }

    public static Date b(String str) throws ParseException {
        try {
            return d().parse(str);
        } catch (ParseException unused) {
            return e().parse(str);
        }
    }

    public static long a() {
        return System.currentTimeMillis() + f3361d;
    }

    private static String c(Date date) {
        return e().format(date);
    }

    public static synchronized void a(long j10) {
        synchronized (cr.class) {
            f3361d = j10 - System.currentTimeMillis();
        }
    }

    public static synchronized String b() {
        String format;
        synchronized (cr.class) {
            format = c().format(new Date(System.currentTimeMillis() + f3361d));
        }
        return format;
    }
}
