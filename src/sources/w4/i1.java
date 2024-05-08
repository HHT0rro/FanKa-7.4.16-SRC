package w4;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.util.FlagSet;
import java.io.IOException;
import java.util.List;

/* compiled from: AnalyticsListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface i1 {

    /* compiled from: AnalyticsListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f54167a;

        /* renamed from: b, reason: collision with root package name */
        public final Timeline f54168b;

        /* renamed from: c, reason: collision with root package name */
        public final int f54169c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final s.a f54170d;

        /* renamed from: e, reason: collision with root package name */
        public final long f54171e;

        /* renamed from: f, reason: collision with root package name */
        public final Timeline f54172f;

        /* renamed from: g, reason: collision with root package name */
        public final int f54173g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public final s.a f54174h;

        /* renamed from: i, reason: collision with root package name */
        public final long f54175i;

        /* renamed from: j, reason: collision with root package name */
        public final long f54176j;

        public a(long j10, Timeline timeline, int i10, @Nullable s.a aVar, long j11, Timeline timeline2, int i11, @Nullable s.a aVar2, long j12, long j13) {
            this.f54167a = j10;
            this.f54168b = timeline;
            this.f54169c = i10;
            this.f54170d = aVar;
            this.f54171e = j11;
            this.f54172f = timeline2;
            this.f54173g = i11;
            this.f54174h = aVar2;
            this.f54175i = j12;
            this.f54176j = j13;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f54167a == aVar.f54167a && this.f54169c == aVar.f54169c && this.f54171e == aVar.f54171e && this.f54173g == aVar.f54173g && this.f54175i == aVar.f54175i && this.f54176j == aVar.f54176j && com.google.common.base.l.a(this.f54168b, aVar.f54168b) && com.google.common.base.l.a(this.f54170d, aVar.f54170d) && com.google.common.base.l.a(this.f54172f, aVar.f54172f) && com.google.common.base.l.a(this.f54174h, aVar.f54174h);
        }

        public int hashCode() {
            return com.google.common.base.l.b(Long.valueOf(this.f54167a), this.f54168b, Integer.valueOf(this.f54169c), this.f54170d, Long.valueOf(this.f54171e), this.f54172f, Integer.valueOf(this.f54173g), this.f54174h, Long.valueOf(this.f54175i), Long.valueOf(this.f54176j));
        }
    }

    /* compiled from: AnalyticsListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final FlagSet f54177a;

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray<a> f54178b;

        public b(FlagSet flagSet, SparseArray<a> sparseArray) {
            this.f54177a = flagSet;
            SparseArray<a> sparseArray2 = new SparseArray<>(flagSet.d());
            for (int i10 = 0; i10 < flagSet.d(); i10++) {
                int c4 = flagSet.c(i10);
                sparseArray2.append(c4, (a) com.google.android.exoplayer2.util.a.e(sparseArray.get(c4)));
            }
            this.f54178b = sparseArray2;
        }
    }

    void A(a aVar, Exception exc);

    void B(a aVar, Metadata metadata);

    void C(a aVar, int i10);

    @Deprecated
    void D(a aVar, int i10, z4.d dVar);

    @Deprecated
    void E(a aVar, List<Metadata> list);

    void F(a aVar, boolean z10);

    void G(Player player, b bVar);

    void H(a aVar, String str, long j10, long j11);

    void I(a aVar, Player.f fVar, Player.f fVar2, int i10);

    void J(a aVar, int i10);

    void K(a aVar, Exception exc);

    void L(a aVar, z4.d dVar);

    void M(a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData);

    void N(a aVar, int i10);

    void O(a aVar, int i10, long j10, long j11);

    void P(a aVar, boolean z10);

    @Deprecated
    void Q(a aVar, Format format);

    void R(a aVar, int i10, int i11);

    void S(a aVar, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void T(a aVar);

    void U(a aVar, com.google.android.exoplayer2.f1 f1Var);

    void V(a aVar, String str, long j10, long j11);

    @Deprecated
    void W(a aVar, String str, long j10);

    void X(a aVar, int i10, long j10);

    @Deprecated
    void Y(a aVar, int i10);

    void Z(a aVar, boolean z10, int i10);

    void a(a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData);

    void a0(a aVar, boolean z10);

    void b(a aVar, int i10, long j10, long j11);

    @Deprecated
    void b0(a aVar);

    void c(a aVar, String str);

    void c0(a aVar);

    void d(a aVar);

    void d0(a aVar, boolean z10);

    @Deprecated
    void e(a aVar, int i10, String str, long j10);

    void e0(a aVar, z4.d dVar);

    void f(a aVar, String str);

    void f0(a aVar, q6.y yVar);

    void g(a aVar, Object obj, long j10);

    void g0(a aVar, MediaLoadData mediaLoadData);

    void h(a aVar);

    void h0(a aVar, Exception exc);

    void i(a aVar, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void i0(a aVar, z4.d dVar);

    @Deprecated
    void j(a aVar, Format format);

    void j0(a aVar, int i10);

    @Deprecated
    void k(a aVar, int i10, Format format);

    void k0(a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData, IOException iOException, boolean z10);

    void l(a aVar, long j10, int i10);

    void l0(a aVar, PlaybackException playbackException);

    void m(a aVar, MediaMetadata mediaMetadata);

    @Deprecated
    void m0(a aVar);

    @Deprecated
    void n(a aVar, int i10, int i11, int i12, float f10);

    @Deprecated
    void n0(a aVar, boolean z10);

    void o(a aVar, com.google.android.exoplayer2.source.m mVar, MediaLoadData mediaLoadData);

    void o0(a aVar, MediaLoadData mediaLoadData);

    void p(a aVar, TrackGroupArray trackGroupArray, n6.h hVar);

    void p0(a aVar, Player.b bVar);

    void q(a aVar, int i10);

    void q0(a aVar, Exception exc);

    @Deprecated
    void r(a aVar, boolean z10, int i10);

    @Deprecated
    void s(a aVar);

    void t(a aVar, @Nullable com.google.android.exoplayer2.w0 w0Var, int i10);

    @Deprecated
    void u(a aVar, String str, long j10);

    void v(a aVar);

    @Deprecated
    void w(a aVar, int i10, z4.d dVar);

    void x(a aVar, z4.d dVar);

    void y(a aVar, long j10);

    void z(a aVar, float f10);
}
