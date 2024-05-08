package j5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import d5.o;
import x4.v;

/* compiled from: XingSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements g {

    /* renamed from: a, reason: collision with root package name */
    public final long f50333a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50334b;

    /* renamed from: c, reason: collision with root package name */
    public final long f50335c;

    /* renamed from: d, reason: collision with root package name */
    public final long f50336d;

    /* renamed from: e, reason: collision with root package name */
    public final long f50337e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final long[] f50338f;

    public i(long j10, int i10, long j11) {
        this(j10, i10, j11, -1L, null);
    }

    @Nullable
    public static i a(long j10, long j11, v.a aVar, ParsableByteArray parsableByteArray) {
        int H;
        int i10 = aVar.f54455g;
        int i11 = aVar.f54452d;
        int n10 = parsableByteArray.n();
        if ((n10 & 1) != 1 || (H = parsableByteArray.H()) == 0) {
            return null;
        }
        long H0 = j0.H0(H, i10 * 1000000, i11);
        if ((n10 & 6) != 6) {
            return new i(j11, aVar.f54451c, H0);
        }
        long F = parsableByteArray.F();
        long[] jArr = new long[100];
        for (int i12 = 0; i12 < 100; i12++) {
            jArr[i12] = parsableByteArray.D();
        }
        if (j10 != -1) {
            long j12 = j11 + F;
            if (j10 != j12) {
                StringBuilder sb2 = new StringBuilder(67);
                sb2.append("XING data size mismatch: ");
                sb2.append(j10);
                sb2.append(", ");
                sb2.append(j12);
                m.h("XingSeeker", sb2.toString());
            }
        }
        return new i(j11, aVar.f54451c, H0, F, jArr);
    }

    public final long b(int i10) {
        return (this.f50335c * i10) / 100;
    }

    @Override // j5.g
    public long c(long j10) {
        long j11 = j10 - this.f50333a;
        if (!e() || j11 <= this.f50334b) {
            return 0L;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.a.i(this.f50338f);
        double d10 = (j11 * 256.0d) / this.f50336d;
        int i10 = j0.i(jArr, (long) d10, true, true);
        long b4 = b(i10);
        long j12 = jArr[i10];
        int i11 = i10 + 1;
        long b10 = b(i11);
        return b4 + Math.round((j12 == (i10 == 99 ? 256L : jArr[i11]) ? ShadowDrawableWrapper.COS_45 : (d10 - j12) / (r0 - j12)) * (b10 - b4));
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        if (!e()) {
            return new i.a(new o(0L, this.f50333a + this.f50334b));
        }
        long s2 = j0.s(j10, 0L, this.f50335c);
        double d10 = (s2 * 100.0d) / this.f50335c;
        double d11 = ShadowDrawableWrapper.COS_45;
        if (d10 > ShadowDrawableWrapper.COS_45) {
            if (d10 >= 100.0d) {
                d11 = 256.0d;
            } else {
                int i10 = (int) d10;
                double d12 = ((long[]) com.google.android.exoplayer2.util.a.i(this.f50338f))[i10];
                d11 = d12 + ((d10 - i10) * ((i10 == 99 ? 256.0d : r3[i10 + 1]) - d12));
            }
        }
        return new i.a(new o(s2, this.f50333a + j0.s(Math.round((d11 / 256.0d) * this.f50336d), this.f50334b, this.f50336d - 1)));
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return this.f50338f != null;
    }

    @Override // j5.g
    public long h() {
        return this.f50337e;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f50335c;
    }

    public i(long j10, int i10, long j11, long j12, @Nullable long[] jArr) {
        this.f50333a = j10;
        this.f50334b = i10;
        this.f50335c = j11;
        this.f50338f = jArr;
        this.f50336d = j12;
        this.f50337e = j12 != -1 ? j10 + j12 : -1L;
    }
}
