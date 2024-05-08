package x4;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: Sonic.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f54456a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54457b;

    /* renamed from: c, reason: collision with root package name */
    public final float f54458c;

    /* renamed from: d, reason: collision with root package name */
    public final float f54459d;

    /* renamed from: e, reason: collision with root package name */
    public final float f54460e;

    /* renamed from: f, reason: collision with root package name */
    public final int f54461f;

    /* renamed from: g, reason: collision with root package name */
    public final int f54462g;

    /* renamed from: h, reason: collision with root package name */
    public final int f54463h;

    /* renamed from: i, reason: collision with root package name */
    public final short[] f54464i;

    /* renamed from: j, reason: collision with root package name */
    public short[] f54465j;

    /* renamed from: k, reason: collision with root package name */
    public int f54466k;

    /* renamed from: l, reason: collision with root package name */
    public short[] f54467l;

    /* renamed from: m, reason: collision with root package name */
    public int f54468m;

    /* renamed from: n, reason: collision with root package name */
    public short[] f54469n;

    /* renamed from: o, reason: collision with root package name */
    public int f54470o;

    /* renamed from: p, reason: collision with root package name */
    public int f54471p;

    /* renamed from: q, reason: collision with root package name */
    public int f54472q;

    /* renamed from: r, reason: collision with root package name */
    public int f54473r;

    /* renamed from: s, reason: collision with root package name */
    public int f54474s;

    /* renamed from: t, reason: collision with root package name */
    public int f54475t;

    /* renamed from: u, reason: collision with root package name */
    public int f54476u;

    /* renamed from: v, reason: collision with root package name */
    public int f54477v;

    public x(int i10, int i11, float f10, float f11, int i12) {
        this.f54456a = i10;
        this.f54457b = i11;
        this.f54458c = f10;
        this.f54459d = f11;
        this.f54460e = i10 / i12;
        this.f54461f = i10 / 400;
        int i13 = i10 / 65;
        this.f54462g = i13;
        int i14 = i13 * 2;
        this.f54463h = i14;
        this.f54464i = new short[i14];
        this.f54465j = new short[i14 * i11];
        this.f54467l = new short[i14 * i11];
        this.f54469n = new short[i14 * i11];
    }

    public static void p(int i10, int i11, short[] sArr, int i12, short[] sArr2, int i13, short[] sArr3, int i14) {
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i12 * i11) + i15;
            int i17 = (i14 * i11) + i15;
            int i18 = (i13 * i11) + i15;
            for (int i19 = 0; i19 < i10; i19++) {
                sArr[i16] = (short) (((sArr2[i18] * (i10 - i19)) + (sArr3[i17] * i19)) / i10);
                i16 += i11;
                i18 += i11;
                i17 += i11;
            }
        }
    }

    public final void a(float f10, int i10) {
        int i11;
        int i12;
        if (this.f54468m == i10) {
            return;
        }
        int i13 = this.f54456a;
        int i14 = (int) (i13 / f10);
        while (true) {
            if (i14 <= 16384 && i13 <= 16384) {
                break;
            }
            i14 /= 2;
            i13 /= 2;
        }
        o(i10);
        int i15 = 0;
        while (true) {
            int i16 = this.f54470o;
            if (i15 < i16 - 1) {
                while (true) {
                    i11 = this.f54471p;
                    int i17 = (i11 + 1) * i14;
                    i12 = this.f54472q;
                    if (i17 <= i12 * i13) {
                        break;
                    }
                    this.f54467l = f(this.f54467l, this.f54468m, 1);
                    int i18 = 0;
                    while (true) {
                        int i19 = this.f54457b;
                        if (i18 < i19) {
                            this.f54467l[(this.f54468m * i19) + i18] = n(this.f54469n, (i19 * i15) + i18, i13, i14);
                            i18++;
                        }
                    }
                    this.f54472q++;
                    this.f54468m++;
                }
                int i20 = i11 + 1;
                this.f54471p = i20;
                if (i20 == i13) {
                    this.f54471p = 0;
                    com.google.android.exoplayer2.util.a.g(i12 == i14);
                    this.f54472q = 0;
                }
                i15++;
            } else {
                u(i16 - 1);
                return;
            }
        }
    }

    public final void b(float f10) {
        int m10;
        int i10 = this.f54466k;
        if (i10 < this.f54463h) {
            return;
        }
        int i11 = 0;
        do {
            if (this.f54473r > 0) {
                m10 = c(i11);
            } else {
                int g3 = g(this.f54465j, i11);
                if (f10 > 1.0d) {
                    m10 = g3 + w(this.f54465j, i11, f10, g3);
                } else {
                    m10 = m(this.f54465j, i11, f10, g3);
                }
            }
            i11 += m10;
        } while (this.f54463h + i11 <= i10);
        v(i11);
    }

    public final int c(int i10) {
        int min = Math.min(this.f54463h, this.f54473r);
        d(this.f54465j, i10, min);
        this.f54473r -= min;
        return min;
    }

    public final void d(short[] sArr, int i10, int i11) {
        short[] f10 = f(this.f54467l, this.f54468m, i11);
        this.f54467l = f10;
        int i12 = this.f54457b;
        System.arraycopy((Object) sArr, i10 * i12, (Object) f10, this.f54468m * i12, i12 * i11);
        this.f54468m += i11;
    }

    public final void e(short[] sArr, int i10, int i11) {
        int i12 = this.f54463h / i11;
        int i13 = this.f54457b;
        int i14 = i11 * i13;
        int i15 = i10 * i13;
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                i17 += sArr[(i16 * i14) + i15 + i18];
            }
            this.f54464i[i16] = (short) (i17 / i14);
        }
    }

    public final short[] f(short[] sArr, int i10, int i11) {
        int length = sArr.length;
        int i12 = this.f54457b;
        int i13 = length / i12;
        return i10 + i11 <= i13 ? sArr : Arrays.copyOf(sArr, (((i13 * 3) / 2) + i11) * i12);
    }

    public final int g(short[] sArr, int i10) {
        int i11;
        int i12 = this.f54456a;
        int i13 = i12 > 4000 ? i12 / 4000 : 1;
        if (this.f54457b == 1 && i13 == 1) {
            i11 = h(sArr, i10, this.f54461f, this.f54462g);
        } else {
            e(sArr, i10, i13);
            int h10 = h(this.f54464i, 0, this.f54461f / i13, this.f54462g / i13);
            if (i13 != 1) {
                int i14 = h10 * i13;
                int i15 = i13 * 4;
                int i16 = i14 - i15;
                int i17 = i14 + i15;
                int i18 = this.f54461f;
                if (i16 < i18) {
                    i16 = i18;
                }
                int i19 = this.f54462g;
                if (i17 > i19) {
                    i17 = i19;
                }
                if (this.f54457b == 1) {
                    i11 = h(sArr, i10, i16, i17);
                } else {
                    e(sArr, i10, 1);
                    i11 = h(this.f54464i, 0, i16, i17);
                }
            } else {
                i11 = h10;
            }
        }
        int i20 = q(this.f54476u, this.f54477v) ? this.f54474s : i11;
        this.f54475t = this.f54476u;
        this.f54474s = i11;
        return i20;
    }

    public final int h(short[] sArr, int i10, int i11, int i12) {
        int i13 = i10 * this.f54457b;
        int i14 = 1;
        int i15 = 255;
        int i16 = 0;
        int i17 = 0;
        while (i11 <= i12) {
            int i18 = 0;
            for (int i19 = 0; i19 < i11; i19++) {
                i18 += Math.abs(sArr[i13 + i19] - sArr[(i13 + i11) + i19]);
            }
            if (i18 * i16 < i14 * i11) {
                i16 = i11;
                i14 = i18;
            }
            if (i18 * i15 > i17 * i11) {
                i15 = i11;
                i17 = i18;
            }
            i11++;
        }
        this.f54476u = i14 / i16;
        this.f54477v = i17 / i15;
        return i16;
    }

    public void i() {
        this.f54466k = 0;
        this.f54468m = 0;
        this.f54470o = 0;
        this.f54471p = 0;
        this.f54472q = 0;
        this.f54473r = 0;
        this.f54474s = 0;
        this.f54475t = 0;
        this.f54476u = 0;
        this.f54477v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f54457b, this.f54468m);
        shortBuffer.put(this.f54467l, 0, this.f54457b * min);
        int i10 = this.f54468m - min;
        this.f54468m = i10;
        short[] sArr = this.f54467l;
        int i11 = this.f54457b;
        System.arraycopy((Object) sArr, min * i11, (Object) sArr, 0, i10 * i11);
    }

    public int k() {
        return this.f54468m * this.f54457b * 2;
    }

    public int l() {
        return this.f54466k * this.f54457b * 2;
    }

    public final int m(short[] sArr, int i10, float f10, int i11) {
        int i12;
        if (f10 < 0.5f) {
            i12 = (int) ((i11 * f10) / (1.0f - f10));
        } else {
            this.f54473r = (int) ((i11 * ((2.0f * f10) - 1.0f)) / (1.0f - f10));
            i12 = i11;
        }
        int i13 = i11 + i12;
        short[] f11 = f(this.f54467l, this.f54468m, i13);
        this.f54467l = f11;
        int i14 = this.f54457b;
        System.arraycopy((Object) sArr, i10 * i14, (Object) f11, this.f54468m * i14, i14 * i11);
        p(i12, this.f54457b, this.f54467l, this.f54468m + i11, sArr, i10 + i11, sArr, i10);
        this.f54468m += i13;
        return i12;
    }

    public final short n(short[] sArr, int i10, int i11, int i12) {
        short s2 = sArr[i10];
        short s10 = sArr[i10 + this.f54457b];
        int i13 = this.f54472q * i11;
        int i14 = this.f54471p;
        int i15 = i14 * i12;
        int i16 = (i14 + 1) * i12;
        int i17 = i16 - i13;
        int i18 = i16 - i15;
        return (short) (((s2 * i17) + ((i18 - i17) * s10)) / i18);
    }

    public final void o(int i10) {
        int i11 = this.f54468m - i10;
        short[] f10 = f(this.f54469n, this.f54470o, i11);
        this.f54469n = f10;
        short[] sArr = this.f54467l;
        int i12 = this.f54457b;
        System.arraycopy((Object) sArr, i10 * i12, (Object) f10, this.f54470o * i12, i12 * i11);
        this.f54468m = i10;
        this.f54470o += i11;
    }

    public final boolean q(int i10, int i11) {
        return i10 != 0 && this.f54474s != 0 && i11 <= i10 * 3 && i10 * 2 > this.f54475t * 3;
    }

    public final void r() {
        int i10 = this.f54468m;
        float f10 = this.f54458c;
        float f11 = this.f54459d;
        float f12 = f10 / f11;
        float f13 = this.f54460e * f11;
        double d10 = f12;
        if (d10 <= 1.00001d && d10 >= 0.99999d) {
            d(this.f54465j, 0, this.f54466k);
            this.f54466k = 0;
        } else {
            b(f12);
        }
        if (f13 != 1.0f) {
            a(f13, i10);
        }
    }

    public void s() {
        int i10;
        int i11 = this.f54466k;
        float f10 = this.f54458c;
        float f11 = this.f54459d;
        int i12 = this.f54468m + ((int) ((((i11 / (f10 / f11)) + this.f54470o) / (this.f54460e * f11)) + 0.5f));
        this.f54465j = f(this.f54465j, i11, (this.f54463h * 2) + i11);
        int i13 = 0;
        while (true) {
            i10 = this.f54463h;
            int i14 = this.f54457b;
            if (i13 >= i10 * 2 * i14) {
                break;
            }
            this.f54465j[(i14 * i11) + i13] = 0;
            i13++;
        }
        this.f54466k += i10 * 2;
        r();
        if (this.f54468m > i12) {
            this.f54468m = i12;
        }
        this.f54466k = 0;
        this.f54473r = 0;
        this.f54470o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i10 = this.f54457b;
        int i11 = remaining / i10;
        short[] f10 = f(this.f54465j, this.f54466k, i11);
        this.f54465j = f10;
        shortBuffer.get(f10, this.f54466k * this.f54457b, ((i10 * i11) * 2) / 2);
        this.f54466k += i11;
        r();
    }

    public final void u(int i10) {
        if (i10 == 0) {
            return;
        }
        short[] sArr = this.f54469n;
        int i11 = this.f54457b;
        System.arraycopy((Object) sArr, i10 * i11, (Object) sArr, 0, (this.f54470o - i10) * i11);
        this.f54470o -= i10;
    }

    public final void v(int i10) {
        int i11 = this.f54466k - i10;
        short[] sArr = this.f54465j;
        int i12 = this.f54457b;
        System.arraycopy((Object) sArr, i10 * i12, (Object) sArr, 0, i12 * i11);
        this.f54466k = i11;
    }

    public final int w(short[] sArr, int i10, float f10, int i11) {
        int i12;
        if (f10 >= 2.0f) {
            i12 = (int) (i11 / (f10 - 1.0f));
        } else {
            this.f54473r = (int) ((i11 * (2.0f - f10)) / (f10 - 1.0f));
            i12 = i11;
        }
        short[] f11 = f(this.f54467l, this.f54468m, i12);
        this.f54467l = f11;
        p(i12, this.f54457b, f11, this.f54468m, sArr, i10, sArr, i10 + i11);
        this.f54468m += i12;
        return i12;
    }
}
