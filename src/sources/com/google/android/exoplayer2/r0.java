package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

/* compiled from: ExoPlayerLibraryInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final String f21118a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f21119b;

    /* renamed from: c, reason: collision with root package name */
    public static String f21120c;

    static {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 57);
        sb2.append("ExoPlayerLib/2.15.1 (Linux; Android ");
        sb2.append(str);
        sb2.append(") ");
        sb2.append("ExoPlayerLib/2.15.1");
        f21118a = sb2.toString();
        f21119b = new HashSet<>();
        f21120c = "goog.exo.core";
    }

    public static synchronized void a(String str) {
        synchronized (r0.class) {
            if (f21119b.add(str)) {
                String str2 = f21120c;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
                sb2.append(str2);
                sb2.append(", ");
                sb2.append(str);
                f21120c = sb2.toString();
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (r0.class) {
            str = f21120c;
        }
        return str;
    }
}
