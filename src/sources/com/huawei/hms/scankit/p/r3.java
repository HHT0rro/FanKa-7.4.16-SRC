package com.huawei.hms.scankit.p;

import java.util.Stack;

/* compiled from: GlobalVariable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r3 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f31446a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f31447b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f31448c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f31449d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f31450e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f31451f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f31452g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f31453h = false;

    /* renamed from: i, reason: collision with root package name */
    public static float f31454i = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    public static int f31455j;

    /* renamed from: k, reason: collision with root package name */
    public static int f31456k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f31457l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f31458m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f31459n;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f31460o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f31461p;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f31462q;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f31463r;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f31464s;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f31465t;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f31466u;

    /* renamed from: v, reason: collision with root package name */
    public static boolean[] f31467v = new boolean[8];

    /* renamed from: w, reason: collision with root package name */
    public static Stack<Integer> f31468w = new Stack<>();

    /* renamed from: x, reason: collision with root package name */
    public static boolean f31469x = true;

    /* renamed from: y, reason: collision with root package name */
    public static float[] f31470y = new float[4];

    /* renamed from: z, reason: collision with root package name */
    public static int f31471z = 0;
    public static boolean A = false;

    public static void a() {
        f31453h = false;
        f31454i = -1.0f;
        f31455j = 0;
        f31461p = false;
        f31462q = false;
        f31463r = false;
        f31465t = false;
        f31458m = false;
        f31459n = false;
        f31460o = false;
        f31464s = false;
        f31467v = new boolean[8];
        f31468w = new Stack<>();
        f31469x = true;
        f31450e = false;
        f31449d = false;
    }

    public static void a(int i10) {
        if (i10 % 2 == 1) {
            f31461p = true;
        }
        if (i10 % 3 == 2) {
            f31462q = true;
        }
        if (i10 % 5 == 4) {
            f31463r = true;
        }
    }

    public static void a(x6 x6Var) {
        a();
        boolean z10 = x6Var.f31726e;
        f31448c = z10;
        f31469x = x6Var.f31728g;
        if (!z10) {
            a(x6Var.f31727f);
        } else {
            a(1);
        }
    }
}
