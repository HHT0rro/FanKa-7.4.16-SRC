package com.tencent.open.log;

import com.baidu.mobads.sdk.internal.bk;
import com.tencent.connect.common.Constants;
import java.io.File;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f45250a = 60;

    /* renamed from: b, reason: collision with root package name */
    public static int f45251b = 60;

    /* renamed from: c, reason: collision with root package name */
    public static String f45252c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d, reason: collision with root package name */
    public static String f45253d;

    /* renamed from: e, reason: collision with root package name */
    public static String f45254e;

    /* renamed from: f, reason: collision with root package name */
    public static long f45255f;

    /* renamed from: g, reason: collision with root package name */
    public static int f45256g;

    /* renamed from: h, reason: collision with root package name */
    public static int f45257h;

    /* renamed from: i, reason: collision with root package name */
    public static int f45258i;

    /* renamed from: j, reason: collision with root package name */
    public static String f45259j;

    /* renamed from: k, reason: collision with root package name */
    public static String f45260k;

    /* renamed from: l, reason: collision with root package name */
    public static String f45261l;

    /* renamed from: m, reason: collision with root package name */
    public static int f45262m;

    /* renamed from: n, reason: collision with root package name */
    public static long f45263n;

    /* renamed from: o, reason: collision with root package name */
    public static String f45264o;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tencent");
        String str = File.separator;
        sb2.append(str);
        sb2.append("msflogs");
        sb2.append(str);
        sb2.append("com");
        sb2.append(str);
        sb2.append("tencent");
        sb2.append(str);
        sb2.append("mobileqq");
        sb2.append(str);
        f45253d = sb2.toString();
        f45254e = ".log";
        f45255f = 8388608L;
        f45256g = 262144;
        f45257h = 1024;
        f45258i = 10000;
        f45259j = "debug.file.blockcount";
        f45260k = "debug.file.keepperiod";
        f45261l = "debug.file.tracelevel";
        f45262m = 24;
        f45263n = bk.f9895d;
        f45264o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
