package c6;

import b6.h;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.u;

/* compiled from: RtpAacReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final h f1532a;

    /* renamed from: b, reason: collision with root package name */
    public final u f1533b = new u();

    /* renamed from: c, reason: collision with root package name */
    public final int f1534c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1535d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1536e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1537f;

    /* renamed from: g, reason: collision with root package name */
    public long f1538g;

    /* renamed from: h, reason: collision with root package name */
    public TrackOutput f1539h;

    /* renamed from: i, reason: collision with root package name */
    public long f1540i;

    public b(h hVar) {
        this.f1532a = hVar;
        this.f1534c = hVar.f1341b;
        String str = (String) com.google.android.exoplayer2.util.a.e(hVar.f1343d.get("mode"));
        if (com.google.common.base.a.a(str, "AAC-hbr")) {
            this.f1535d = 13;
            this.f1536e = 3;
        } else if (com.google.common.base.a.a(str, "AAC-lbr")) {
            this.f1535d = 6;
            this.f1536e = 2;
        } else {
            throw new UnsupportedOperationException("AAC mode not supported");
        }
        this.f1537f = this.f1536e + this.f1535d;
    }

    public static void e(TrackOutput trackOutput, long j10, int i10) {
        trackOutput.d(j10, 1, i10, 0, null);
    }

    public static long f(long j10, long j11, long j12, int i10) {
        return j10 + j0.H0(j11 - j12, 1000000L, i10);
    }

    @Override // c6.e
    public void a(long j10, long j11) {
        this.f1538g = j10;
        this.f1540i = j11;
    }

    @Override // c6.e
    public void b(long j10, int i10) {
        this.f1538g = j10;
    }

    @Override // c6.e
    public void c(d5.e eVar, int i10) {
        TrackOutput c4 = eVar.c(i10, 1);
        this.f1539h = c4;
        c4.b(this.f1532a.f1342c);
    }

    @Override // c6.e
    public void d(ParsableByteArray parsableByteArray, long j10, int i10, boolean z10) {
        com.google.android.exoplayer2.util.a.e(this.f1539h);
        short z11 = parsableByteArray.z();
        int i11 = z11 / this.f1537f;
        long f10 = f(this.f1540i, j10, this.f1538g, this.f1534c);
        this.f1533b.m(parsableByteArray);
        if (i11 == 1) {
            int h10 = this.f1533b.h(this.f1535d);
            this.f1533b.r(this.f1536e);
            this.f1539h.a(parsableByteArray, parsableByteArray.a());
            if (z10) {
                e(this.f1539h, f10, h10);
                return;
            }
            return;
        }
        parsableByteArray.Q((z11 + 7) / 8);
        for (int i12 = 0; i12 < i11; i12++) {
            int h11 = this.f1533b.h(this.f1535d);
            this.f1533b.r(this.f1536e);
            this.f1539h.a(parsableByteArray, h11);
            e(this.f1539h, f10, h11);
            f10 += j0.H0(i11, 1000000L, this.f1534c);
        }
    }
}
