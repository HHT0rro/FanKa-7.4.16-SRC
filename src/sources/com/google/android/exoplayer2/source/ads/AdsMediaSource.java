package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.a;
import com.google.android.exoplayer2.source.ads.b;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o6.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AdsMediaSource extends e<s.a> {

    /* renamed from: w, reason: collision with root package name */
    public static final s.a f21181w = new s.a(new Object());

    /* renamed from: k, reason: collision with root package name */
    public final s f21182k;

    /* renamed from: l, reason: collision with root package name */
    public final a0 f21183l;

    /* renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.ads.b f21184m;

    /* renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.ui.b f21185n;

    /* renamed from: o, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f21186o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f21187p;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public c f21190s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public Timeline f21191t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.source.ads.a f21192u;

    /* renamed from: q, reason: collision with root package name */
    public final Handler f21188q = new Handler(Looper.getMainLooper());

    /* renamed from: r, reason: collision with root package name */
    public final Timeline.b f21189r = new Timeline.b();

    /* renamed from: v, reason: collision with root package name */
    public a[][] f21193v = new a[0];

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        private AdLoadException(int i10, Exception exc) {
            super(exc);
            this.type = i10;
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i10) {
            StringBuilder sb2 = new StringBuilder(35);
            sb2.append("Failed to load ad group ");
            sb2.append(i10);
            return new AdLoadException(1, new IOException(sb2.toString(), exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            com.google.android.exoplayer2.util.a.g(this.type == 3);
            return (RuntimeException) com.google.android.exoplayer2.util.a.e(getCause());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public final s.a f21194a;

        /* renamed from: b, reason: collision with root package name */
        public final List<n> f21195b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public Uri f21196c;

        /* renamed from: d, reason: collision with root package name */
        public s f21197d;

        /* renamed from: e, reason: collision with root package name */
        public Timeline f21198e;

        public a(s.a aVar) {
            this.f21194a = aVar;
        }

        public p a(s.a aVar, o6.b bVar, long j10) {
            n nVar = new n(aVar, bVar, j10);
            this.f21195b.add(nVar);
            s sVar = this.f21197d;
            if (sVar != null) {
                nVar.w(sVar);
                nVar.x(new b((Uri) com.google.android.exoplayer2.util.a.e(this.f21196c)));
            }
            Timeline timeline = this.f21198e;
            if (timeline != null) {
                nVar.a(new s.a(timeline.m(0), aVar.f21886d));
            }
            return nVar;
        }

        public long b() {
            Timeline timeline = this.f21198e;
            if (timeline == null) {
                return -9223372036854775807L;
            }
            return timeline.f(0, AdsMediaSource.this.f21189r).i();
        }

        public void c(Timeline timeline) {
            com.google.android.exoplayer2.util.a.a(timeline.i() == 1);
            if (this.f21198e == null) {
                Object m10 = timeline.m(0);
                for (int i10 = 0; i10 < this.f21195b.size(); i10++) {
                    n nVar = this.f21195b.get(i10);
                    nVar.a(new s.a(m10, nVar.f21811b.f21886d));
                }
            }
            this.f21198e = timeline;
        }

        public boolean d() {
            return this.f21197d != null;
        }

        public void e(s sVar, Uri uri) {
            this.f21197d = sVar;
            this.f21196c = uri;
            for (int i10 = 0; i10 < this.f21195b.size(); i10++) {
                n nVar = this.f21195b.get(i10);
                nVar.w(sVar);
                nVar.x(new b(uri));
            }
            AdsMediaSource.this.K(this.f21194a, sVar);
        }

        public boolean f() {
            return this.f21195b.isEmpty();
        }

        public void g() {
            if (d()) {
                AdsMediaSource.this.L(this.f21194a);
            }
        }

        public void h(n nVar) {
            this.f21195b.remove(nVar);
            nVar.v();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements n.a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f21200a;

        public b(Uri uri) {
            this.f21200a = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(s.a aVar) {
            AdsMediaSource.this.f21184m.e(AdsMediaSource.this, aVar.f21884b, aVar.f21885c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(s.a aVar, IOException iOException) {
            AdsMediaSource.this.f21184m.b(AdsMediaSource.this, aVar.f21884b, aVar.f21885c, iOException);
        }

        @Override // com.google.android.exoplayer2.source.n.a
        public void a(final s.a aVar, final IOException iOException) {
            AdsMediaSource.this.w(aVar).x(new m(m.a(), new com.google.android.exoplayer2.upstream.b(this.f21200a), SystemClock.elapsedRealtime()), 6, AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.f21188q.post(new Runnable() { // from class: w5.d
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.b.this.f(aVar, iOException);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.n.a
        public void b(final s.a aVar) {
            AdsMediaSource.this.f21188q.post(new Runnable() { // from class: w5.c
                @Override // java.lang.Runnable
                public final void run() {
                    AdsMediaSource.b.this.e(aVar);
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f21202a = j0.x();

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f21203b;

        public c() {
        }

        public void a() {
            this.f21203b = true;
            this.f21202a.removeCallbacksAndMessages(null);
        }
    }

    public AdsMediaSource(s sVar, com.google.android.exoplayer2.upstream.b bVar, Object obj, a0 a0Var, com.google.android.exoplayer2.source.ads.b bVar2, com.google.android.exoplayer2.ui.b bVar3) {
        this.f21182k = sVar;
        this.f21183l = a0Var;
        this.f21184m = bVar2;
        this.f21185n = bVar3;
        this.f21186o = bVar;
        this.f21187p = obj;
        bVar2.d(a0Var.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(c cVar) {
        this.f21184m.a(this, this.f21186o, this.f21187p, this.f21185n, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(c cVar) {
        this.f21184m.c(this, cVar);
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void B(@Nullable v vVar) {
        super.B(vVar);
        final c cVar = new c();
        this.f21190s = cVar;
        K(f21181w, this.f21182k);
        this.f21188q.post(new Runnable() { // from class: w5.a
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource.this.W(cVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.e, com.google.android.exoplayer2.source.a
    public void D() {
        super.D();
        final c cVar = (c) com.google.android.exoplayer2.util.a.e(this.f21190s);
        this.f21190s = null;
        cVar.a();
        this.f21191t = null;
        this.f21192u = null;
        this.f21193v = new a[0];
        this.f21188q.post(new Runnable() { // from class: w5.b
            @Override // java.lang.Runnable
            public final void run() {
                AdsMediaSource.this.X(cVar);
            }
        });
    }

    public final long[][] U() {
        long[][] jArr = new long[this.f21193v.length];
        int i10 = 0;
        while (true) {
            a[][] aVarArr = this.f21193v;
            if (i10 >= aVarArr.length) {
                return jArr;
            }
            jArr[i10] = new long[aVarArr[i10].length];
            int i11 = 0;
            while (true) {
                a[][] aVarArr2 = this.f21193v;
                if (i11 < aVarArr2[i10].length) {
                    a aVar = aVarArr2[i10][i11];
                    jArr[i10][i11] = aVar == null ? -9223372036854775807L : aVar.b();
                    i11++;
                }
            }
            i10++;
        }
    }

    @Override // com.google.android.exoplayer2.source.e
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public s.a F(s.a aVar, s.a aVar2) {
        return aVar.b() ? aVar : aVar2;
    }

    public final void Y() {
        Uri uri;
        w0.e eVar;
        com.google.android.exoplayer2.source.ads.a aVar = this.f21192u;
        if (aVar == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f21193v.length; i10++) {
            int i11 = 0;
            while (true) {
                a[][] aVarArr = this.f21193v;
                if (i11 < aVarArr[i10].length) {
                    a aVar2 = aVarArr[i10][i11];
                    a.C0193a a10 = aVar.a(i10);
                    if (aVar2 != null && !aVar2.d()) {
                        Uri[] uriArr = a10.f21217c;
                        if (i11 < uriArr.length && (uri = uriArr[i11]) != null) {
                            w0.c t2 = new w0.c().t(uri);
                            w0.g gVar = this.f21182k.d().f23163b;
                            if (gVar != null && (eVar = gVar.f23218c) != null) {
                                t2.j(eVar.f23201a);
                                t2.d(eVar.a());
                                t2.f(eVar.f23202b);
                                t2.c(eVar.f23206f);
                                t2.e(eVar.f23203c);
                                t2.g(eVar.f23204d);
                                t2.h(eVar.f23205e);
                                t2.i(eVar.f23207g);
                            }
                            aVar2.e(this.f21183l.b(t2.a()), uri);
                        }
                    }
                    i11++;
                }
            }
        }
    }

    public final void Z() {
        Timeline timeline = this.f21191t;
        com.google.android.exoplayer2.source.ads.a aVar = this.f21192u;
        if (aVar == null || timeline == null) {
            return;
        }
        if (aVar.f21209b == 0) {
            C(timeline);
        } else {
            this.f21192u = aVar.e(U());
            C(new w5.e(timeline, this.f21192u));
        }
    }

    @Override // com.google.android.exoplayer2.source.e
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void I(s.a aVar, s sVar, Timeline timeline) {
        if (aVar.b()) {
            ((a) com.google.android.exoplayer2.util.a.e(this.f21193v[aVar.f21884b][aVar.f21885c])).c(timeline);
        } else {
            com.google.android.exoplayer2.util.a.a(timeline.i() == 1);
            this.f21191t = timeline;
        }
        Z();
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21182k.d();
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        if (((com.google.android.exoplayer2.source.ads.a) com.google.android.exoplayer2.util.a.e(this.f21192u)).f21209b > 0 && aVar.b()) {
            int i10 = aVar.f21884b;
            int i11 = aVar.f21885c;
            a[][] aVarArr = this.f21193v;
            if (aVarArr[i10].length <= i11) {
                aVarArr[i10] = (a[]) Arrays.copyOf(aVarArr[i10], i11 + 1);
            }
            a aVar2 = this.f21193v[i10][i11];
            if (aVar2 == null) {
                aVar2 = new a(aVar);
                this.f21193v[i10][i11] = aVar2;
                Y();
            }
            return aVar2.a(aVar, bVar, j10);
        }
        n nVar = new n(aVar, bVar, j10);
        nVar.w(this.f21182k);
        nVar.a(aVar);
        return nVar;
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        n nVar = (n) pVar;
        s.a aVar = nVar.f21811b;
        if (aVar.b()) {
            a aVar2 = (a) com.google.android.exoplayer2.util.a.e(this.f21193v[aVar.f21884b][aVar.f21885c]);
            aVar2.h(nVar);
            if (aVar2.f()) {
                aVar2.g();
                this.f21193v[aVar.f21884b][aVar.f21885c] = null;
                return;
            }
            return;
        }
        nVar.v();
    }
}
