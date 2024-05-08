package com.kuaishou.weapon.p0;

import android.os.Build;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    public static cq f35978a;

    /* renamed from: b, reason: collision with root package name */
    public static cq f35979b;

    /* renamed from: c, reason: collision with root package name */
    public static cq f35980c;

    /* renamed from: d, reason: collision with root package name */
    private long f35981d;

    /* renamed from: e, reason: collision with root package name */
    private a f35982e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum a {
        DWORD(4),
        QWORD(8);


        /* renamed from: c, reason: collision with root package name */
        public int f35986c;

        a(int i10) {
            this.f35986c = i10;
        }
    }

    static {
        c();
    }

    private static void c() {
        f35978a = new cq();
        f35979b = new cq();
        f35980c = new cq();
        cq cqVar = f35979b;
        a aVar = a.DWORD;
        cqVar.a(aVar);
        int i10 = Build.VERSION.SDK_INT;
        if (cr.a()) {
            cq cqVar2 = f35978a;
            a aVar2 = a.QWORD;
            cqVar2.a(aVar2);
            f35980c.a(aVar2);
            switch (i10) {
                case 22:
                    f35978a.a(52L);
                    f35980c.a(44L);
                    f35979b.a(20L);
                    return;
                case 23:
                    f35978a.a(48L);
                    f35980c.a(40L);
                    f35979b.a(12L);
                    return;
                case 24:
                case 25:
                    f35978a.a(48L);
                    f35980c.a(40L);
                    f35979b.a(4L);
                    return;
                case 26:
                case 27:
                    f35978a.a(40L);
                    f35980c.a(32L);
                    f35979b.a(4L);
                    return;
                case 28:
                case 29:
                    f35978a.a(32L);
                    f35980c.a(24L);
                    f35979b.a(4L);
                    return;
                default:
                    throw new RuntimeException("API LEVEL: " + i10 + " is not supported now : (");
            }
        }
        f35978a.a(aVar);
        f35980c.a(aVar);
        switch (i10) {
            case 22:
                f35978a.a(44L);
                f35980c.a(40L);
                f35979b.a(20L);
                return;
            case 23:
                f35978a.a(36L);
                f35980c.a(32L);
                f35979b.a(12L);
                return;
            case 24:
            case 25:
                f35978a.a(32L);
                f35980c.a(28L);
                f35979b.a(4L);
                return;
            case 26:
            case 27:
                f35978a.a(28L);
                f35980c.a(24L);
                f35979b.a(4L);
                return;
            case 28:
            case 29:
                f35978a.a(24L);
                f35980c.a(20L);
                f35979b.a(4L);
                return;
            default:
                throw new RuntimeException("API LEVEL: " + i10 + " is not supported now : (");
        }
    }

    public long a() {
        return this.f35981d;
    }

    public a b() {
        return this.f35982e;
    }

    public void a(long j10) {
        this.f35981d = j10;
    }

    public void a(a aVar) {
        this.f35982e = aVar;
    }
}
