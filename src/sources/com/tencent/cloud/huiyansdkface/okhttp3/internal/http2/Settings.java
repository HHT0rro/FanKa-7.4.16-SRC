package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Settings {

    /* renamed from: a, reason: collision with root package name */
    private int f41983a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f41984b = new int[10];

    public Settings a(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f41984b;
            if (i10 < iArr.length) {
                this.f41983a = (1 << i10) | this.f41983a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public void a() {
        this.f41983a = 0;
        Arrays.fill(this.f41984b, 0);
    }

    public void a(Settings settings) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (settings.a(i10)) {
                a(i10, settings.b(i10));
            }
        }
    }

    public boolean a(int i10) {
        return ((1 << i10) & this.f41983a) != 0;
    }

    public int b() {
        return Integer.bitCount(this.f41983a);
    }

    public int b(int i10) {
        return this.f41984b[i10];
    }

    public int c() {
        if ((this.f41983a & 2) != 0) {
            return this.f41984b[1];
        }
        return -1;
    }

    public int c(int i10) {
        return (this.f41983a & 16) != 0 ? this.f41984b[4] : i10;
    }

    public int d() {
        if ((this.f41983a & 128) != 0) {
            return this.f41984b[7];
        }
        return 65535;
    }

    public int d(int i10) {
        return (this.f41983a & 32) != 0 ? this.f41984b[5] : i10;
    }
}
