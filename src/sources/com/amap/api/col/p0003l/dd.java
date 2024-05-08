package com.amap.api.col.p0003l;

import android.content.Context;

/* compiled from: AuthLogUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dd {

    /* renamed from: a, reason: collision with root package name */
    public static String f5326a;

    static {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 80; i10++) {
            sb2.append("=");
        }
        f5326a = sb2.toString();
    }

    public static void a() {
        c(f5326a);
        c("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        c(f5326a);
    }

    private static void b(String str) {
        if (str.length() < 78) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("|");
            sb2.append(str);
            for (int i10 = 0; i10 < 78 - str.length(); i10++) {
                sb2.append(" ");
            }
            sb2.append("|");
            c(sb2.toString());
            return;
        }
        c("|" + str.substring(0, 78) + "|");
        b(str.substring(78));
    }

    private static void c(String str) {
    }

    public static void a(String str) {
        c(f5326a);
        c(str);
        c(f5326a);
    }

    public static void a(Context context, String str) {
        c(f5326a);
        if (context != null) {
            b("key:" + fj.f(context));
        }
        c(str);
        c(f5326a);
    }
}
