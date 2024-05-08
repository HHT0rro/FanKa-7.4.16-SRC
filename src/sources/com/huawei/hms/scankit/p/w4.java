package com.huawei.hms.scankit.p;

import com.android.internal.logging.nano.MetricsProto;

/* compiled from: ModulusGF.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class w4 {

    /* renamed from: f, reason: collision with root package name */
    public static final w4 f31683f = new w4(MetricsProto.MetricsEvent.ACTION_QS_MORE_SETTINGS, 3);

    /* renamed from: a, reason: collision with root package name */
    private final int[] f31684a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f31685b;

    /* renamed from: c, reason: collision with root package name */
    private final x4 f31686c;

    /* renamed from: d, reason: collision with root package name */
    private final x4 f31687d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31688e;

    private w4(int i10, int i11) {
        this.f31688e = i10;
        this.f31684a = new int[i10];
        this.f31685b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f31684a[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f31685b[this.f31684a[i14]] = i14;
        }
        this.f31686c = new x4(this, new int[]{0});
        this.f31687d = new x4(this, new int[]{1});
    }

    public x4 a() {
        return this.f31687d;
    }

    public x4 b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f31686c;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new x4(this, iArr);
    }

    public x4 c() {
        return this.f31686c;
    }

    public int d(int i10, int i11) {
        int i12 = this.f31688e;
        return ((i10 + i12) - i11) % i12;
    }

    public int a(int i10, int i11) {
        return (i10 + i11) % this.f31688e;
    }

    public int c(int i10) {
        if (i10 != 0) {
            return this.f31685b[i10];
        }
        throw new IllegalArgumentException();
    }

    public int a(int i10) {
        return this.f31684a[i10];
    }

    public int c(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            return 0;
        }
        int[] iArr = this.f31684a;
        int[] iArr2 = this.f31685b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f31688e - 1)];
    }

    public int b(int i10) {
        if (i10 != 0) {
            return this.f31684a[(this.f31688e - this.f31685b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int b() {
        return this.f31688e;
    }
}
