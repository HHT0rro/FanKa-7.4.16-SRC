package com.tencent.liteav.base.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static a f42742a;

    /* renamed from: b, reason: collision with root package name */
    private int f42743b = 60;

    /* renamed from: c, reason: collision with root package name */
    private int f42744c = 70;

    /* renamed from: d, reason: collision with root package name */
    private int f42745d = 80;

    /* renamed from: e, reason: collision with root package name */
    private int f42746e = 50;

    /* renamed from: f, reason: collision with root package name */
    private int f42747f = 10;

    public static a a() {
        if (f42742a == null) {
            synchronized (a.class) {
                if (f42742a == null) {
                    f42742a = new a();
                }
            }
        }
        return f42742a;
    }

    public final long a(String str, String str2) {
        int i10;
        if (!"Video".equals(str)) {
            return 0L;
        }
        if ("SWToHWThreshold_CheckCount".equals(str2)) {
            i10 = this.f42747f;
        } else if ("SWToHWThreshold_CPU".equals(str2)) {
            i10 = this.f42743b;
        } else if ("SWToHWThreshold_CPU_MAX".equals(str2)) {
            i10 = this.f42745d;
        } else if ("SWToHWThreshold_FPS".equals(str2)) {
            i10 = this.f42744c;
        } else {
            if (!"SWToHWThreshold_FPS_MIN".equals(str2)) {
                return 0L;
            }
            i10 = this.f42746e;
        }
        return i10;
    }
}
