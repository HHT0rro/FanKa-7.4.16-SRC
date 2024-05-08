package com.xiaomi.push;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c4 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f47156a = b(1, 3);

    /* renamed from: b, reason: collision with root package name */
    public static final int f47157b = b(1, 4);

    /* renamed from: c, reason: collision with root package name */
    public static final int f47158c = b(2, 0);

    /* renamed from: d, reason: collision with root package name */
    public static final int f47159d = b(3, 2);

    public static int a(int i10) {
        return i10 & 7;
    }

    public static int b(int i10, int i11) {
        return (i10 << 3) | i11;
    }

    public static int c(int i10) {
        return i10 >>> 3;
    }
}
