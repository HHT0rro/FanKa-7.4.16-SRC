package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m2 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile m2 f47966b;

    /* renamed from: a, reason: collision with root package name */
    public l2 f47967a;

    public static m2 b() {
        if (f47966b == null) {
            synchronized (m2.class) {
                if (f47966b == null) {
                    f47966b = new m2();
                }
            }
        }
        return f47966b;
    }

    public l2 a() {
        return this.f47967a;
    }

    public void c(l2 l2Var) {
        this.f47967a = l2Var;
    }
}
