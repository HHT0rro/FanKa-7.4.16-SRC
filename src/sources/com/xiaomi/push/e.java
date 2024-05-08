package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f47186a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f47187b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f47188c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f47189d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f47190e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f47191f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f47192g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f47193h;

    /* renamed from: i, reason: collision with root package name */
    public static int f47194i;

    static {
        int i10;
        String str = i.f47502a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f47186a = str;
        boolean contains = str.contains("2A2FE0D7");
        f47187b = contains;
        f47188c = contains || "DEBUG".equalsIgnoreCase(str);
        f47189d = "LOGABLE".equalsIgnoreCase(str);
        f47190e = str.contains("YY");
        f47191f = str.equalsIgnoreCase("TEST");
        f47192g = "BETA".equalsIgnoreCase(str);
        f47193h = str.startsWith("RC");
        f47194i = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            i10 = 2;
        } else {
            if (!str.equalsIgnoreCase("ONEBOX")) {
                f47194i = 1;
                return;
            }
            i10 = 3;
        }
        f47194i = i10;
    }

    public static int a() {
        return f47194i;
    }

    public static void b(int i10) {
        f47194i = i10;
    }

    public static boolean c() {
        return f47194i == 2;
    }

    public static boolean d() {
        return f47194i == 3;
    }
}
