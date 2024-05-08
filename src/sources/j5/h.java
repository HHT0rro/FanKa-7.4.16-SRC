package j5;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import d5.o;
import x4.v;

/* compiled from: VbriSeeker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f50329a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f50330b;

    /* renamed from: c, reason: collision with root package name */
    public final long f50331c;

    /* renamed from: d, reason: collision with root package name */
    public final long f50332d;

    public h(long[] jArr, long[] jArr2, long j10, long j11) {
        this.f50329a = jArr;
        this.f50330b = jArr2;
        this.f50331c = j10;
        this.f50332d = j11;
    }

    @Nullable
    public static h a(long j10, long j11, v.a aVar, ParsableByteArray parsableByteArray) {
        int D;
        parsableByteArray.Q(10);
        int n10 = parsableByteArray.n();
        if (n10 <= 0) {
            return null;
        }
        int i10 = aVar.f54452d;
        long H0 = j0.H0(n10, 1000000 * (i10 >= 32000 ? 1152 : MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT), i10);
        int J = parsableByteArray.J();
        int J2 = parsableByteArray.J();
        int J3 = parsableByteArray.J();
        parsableByteArray.Q(2);
        long j12 = j11 + aVar.f54451c;
        long[] jArr = new long[J];
        long[] jArr2 = new long[J];
        int i11 = 0;
        long j13 = j11;
        while (i11 < J) {
            int i12 = J2;
            long j14 = j12;
            jArr[i11] = (i11 * H0) / J;
            jArr2[i11] = Math.max(j13, j14);
            if (J3 == 1) {
                D = parsableByteArray.D();
            } else if (J3 == 2) {
                D = parsableByteArray.J();
            } else if (J3 == 3) {
                D = parsableByteArray.G();
            } else {
                if (J3 != 4) {
                    return null;
                }
                D = parsableByteArray.H();
            }
            j13 += D * i12;
            i11++;
            j12 = j14;
            J2 = i12;
        }
        if (j10 != -1 && j10 != j13) {
            StringBuilder sb2 = new StringBuilder(67);
            sb2.append("VBRI data size mismatch: ");
            sb2.append(j10);
            sb2.append(", ");
            sb2.append(j13);
            m.h("VbriSeeker", sb2.toString());
        }
        return new h(jArr, jArr2, H0, j13);
    }

    @Override // j5.g
    public long c(long j10) {
        return this.f50329a[j0.i(this.f50330b, j10, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        int i10 = j0.i(this.f50329a, j10, true, true);
        o oVar = new o(this.f50329a[i10], this.f50330b[i10]);
        if (oVar.f48644a < j10 && i10 != this.f50329a.length - 1) {
            int i11 = i10 + 1;
            return new i.a(oVar, new o(this.f50329a[i11], this.f50330b[i11]));
        }
        return new i.a(oVar);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return true;
    }

    @Override // j5.g
    public long h() {
        return this.f50332d;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f50331c;
    }
}
