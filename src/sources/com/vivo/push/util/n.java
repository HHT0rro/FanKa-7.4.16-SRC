package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    private static Method f46439f;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f46434a = ag.b("ro.vivo.product.overseas", "no").equals("yes");

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f46435b = b("rom_1.0");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f46436c = b("rom_2.0");

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f46437d = b("rom_2.5");

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f46438e = b("rom_3.0");

    /* renamed from: g, reason: collision with root package name */
    private static String f46440g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f46441h = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String b4 = ag.b("ro.vivo.rom", "");
        String b10 = ag.b("ro.vivo.rom.version", "");
        u.d("Device", "ro.vivo.rom = " + b4 + " ; ro.vivo.rom.version = " + b10);
        if (b4 == null || !b4.contains(str)) {
            return b10 != null && b10.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (n.class) {
            if (f46440g == null && f46441h == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
                    f46439f = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f46440g = (String) f46439f.invoke(null, "ro.vivo.rom", "@><@");
                    f46441h = (String) f46439f.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    u.b("Device", "getRomCode error");
                }
            }
            u.d("Device", "sRomProperty1 : " + f46440g + " ; sRomProperty2 : " + f46441h);
            String a10 = a(f46440g);
            if (!TextUtils.isEmpty(a10)) {
                return a10;
            }
            String a11 = a(f46441h);
            if (TextUtils.isEmpty(a11)) {
                return null;
            }
            return a11;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            u.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        u.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith(ADEvent.VIVO);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(matcher.group(1));
        sb2.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb2.toString();
    }
}
