package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import android.os.Process;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UserTrackMethodJniBridge {

    /* renamed from: а, reason: contains not printable characters */
    private static Context f37;

    /* renamed from: б, reason: contains not printable characters */
    private static String f38;

    /* renamed from: в, reason: contains not printable characters */
    private static volatile int f39;

    /* renamed from: г, reason: contains not printable characters */
    private static volatile int f40;

    /* renamed from: д, reason: contains not printable characters */
    private static volatile int f41;

    /* renamed from: е, reason: contains not printable characters */
    private static volatile int f42;

    /* renamed from: ж, reason: contains not printable characters */
    private static Class f43;

    /* renamed from: з, reason: contains not printable characters */
    private static Class f44;

    /* renamed from: и, reason: contains not printable characters */
    private static Constructor f45;

    /* renamed from: й, reason: contains not printable characters */
    private static Method f46;

    /* renamed from: к, reason: contains not printable characters */
    private static Method f47;

    /* renamed from: л, reason: contains not printable characters */
    private static Method f48;

    /* renamed from: м, reason: contains not printable characters */
    private static Method f49;

    /* renamed from: н, reason: contains not printable characters */
    private static final char[] f50 = "0123456789abcdef".toCharArray();

    /* renamed from: ё, reason: contains not printable characters */
    private static Class f51;

    public static int addUtRecord(String str, int i10, int i11, String str2, long j10, String str3, String str4, String str5, String str6, String str7) {
        Map map;
        Object invoke;
        Object invoke2;
        if (utAvaiable() != 0 && str != null && str.length() != 0) {
            String str8 = str2 != null ? str2 : "";
            try {
                String valueOf = String.valueOf(i10);
                HashMap hashMap = new HashMap();
                hashMap.put("plugin", String.valueOf(i11));
                hashMap.put(ExposeManager.UtArgsNames.pid, String.valueOf(Process.myPid()));
                hashMap.put("tid", String.valueOf(Thread.currentThread().getId()));
                hashMap.put("time", String.valueOf(j10));
                if (f40 == 0) {
                    f39 = C0055.m1850(f37) ? 1 : 0;
                    f40 = 1;
                }
                hashMap.put("ui", String.valueOf(f39));
                hashMap.put("sid", m1816());
                hashMap.put(Constant.MAP_KEY_UUID, m1818());
                hashMap.put("msg", m1817(str3));
                hashMap.put("rsv1", m1817(str4));
                hashMap.put("rsv2", m1817(str5));
                hashMap.put("rsv3", m1817(str6));
                hashMap.put("rsv4", m1817(str7));
                Object newInstance = f45.newInstance("Page_SecurityGuardSDK", 19997, str, str8, valueOf, hashMap);
                if (newInstance != null && (map = (Map) f46.invoke(newInstance, new Object[0])) != null && map.size() != 0 && (invoke = f47.invoke(f43, new Object[0])) != null && (invoke2 = f48.invoke(invoke, new Object[0])) != null) {
                    f49.invoke(invoke2, map);
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            char[] cArr2 = f50;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
        }
        return new String(cArr);
    }

    public static String getStackTrace(int i10, int i11) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0 || i10 <= 0 || i11 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        for (int i13 = 0; i13 < stackTrace.length && i12 < i11 && sb2.length() < i10; i13++) {
            if (i13 > 1) {
                i12++;
                StackTraceElement stackTraceElement = stackTrace[i13];
                sb2.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                if (i13 < stackTrace.length - 1) {
                    sb2.append("#");
                }
            }
        }
        return sb2.toString();
    }

    public static void init(Context context) {
        if (context != null) {
            f37 = context;
        }
    }

    public static int utAvaiable() {
        if (f42 == 0) {
            synchronized (UserTrackMethodJniBridge.class) {
                if (f42 == 0) {
                    try {
                        f51 = Class.forName("com.ut.mini.internal.UTOriginalCustomHitBuilder");
                        f43 = Class.forName("com.ut.mini.UTAnalytics");
                        f44 = Class.forName("com.ut.mini.UTTracker");
                        f45 = f51.getConstructor(String.class, Integer.TYPE, String.class, String.class, String.class, Map.class);
                        f46 = f51.getMethod("build", new Class[0]);
                        f47 = f43.getMethod("getInstance", new Class[0]);
                        f48 = f43.getMethod("getDefaultTracker", new Class[0]);
                        f49 = f44.getMethod("send", Map.class);
                        f41 = 1;
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    }
                    f42 = 1;
                }
            }
        }
        return f41;
    }

    /* renamed from: а, reason: contains not printable characters */
    private static synchronized String m1816() {
        String substring;
        synchronized (UserTrackMethodJniBridge.class) {
            String str = f38;
            if (str == null || str.length() == 0) {
                f38 = m1818();
            }
            String str2 = f38;
            substring = str2.substring(0, str2.length() / 8);
        }
        return substring;
    }

    /* renamed from: а, reason: contains not printable characters */
    private static String m1817(String str) {
        if (str != null && str.length() != 0) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    /* renamed from: б, reason: contains not printable characters */
    private static String m1818() {
        try {
            String uuid = UUID.randomUUID().toString();
            String valueOf = String.valueOf(System.nanoTime());
            return bytesToHex(MessageDigest.getInstance("SHA-1").digest((uuid + valueOf).getBytes("UTF-8")));
        } catch (Exception unused) {
            return "";
        }
    }
}
