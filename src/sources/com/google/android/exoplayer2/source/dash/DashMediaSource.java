package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import b5.u;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.w0;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.datepicker.UtcDates;
import com.google.common.math.LongMath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o6.r;
import o6.v;
import z5.j;
import z5.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DashMediaSource extends com.google.android.exoplayer2.source.a {
    public Loader A;

    @Nullable
    public v B;
    public IOException C;
    public Handler D;
    public w0.f E;
    public Uri F;
    public Uri G;
    public z5.c H;
    public boolean I;
    public long J;
    public long K;
    public long L;
    public int M;
    public long N;
    public int O;

    /* renamed from: h, reason: collision with root package name */
    public final w0 f21250h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f21251i;

    /* renamed from: j, reason: collision with root package name */
    public final a.InterfaceC0208a f21252j;

    /* renamed from: k, reason: collision with root package name */
    public final a.InterfaceC0194a f21253k;

    /* renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.g f21254l;

    /* renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f21255m;

    /* renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21256n;

    /* renamed from: o, reason: collision with root package name */
    public final y5.b f21257o;

    /* renamed from: p, reason: collision with root package name */
    public final long f21258p;

    /* renamed from: q, reason: collision with root package name */
    public final z.a f21259q;

    /* renamed from: r, reason: collision with root package name */
    public final i.a<? extends z5.c> f21260r;

    /* renamed from: s, reason: collision with root package name */
    public final e f21261s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f21262t;

    /* renamed from: u, reason: collision with root package name */
    public final SparseArray<com.google.android.exoplayer2.source.dash.b> f21263u;

    /* renamed from: v, reason: collision with root package name */
    public final Runnable f21264v;

    /* renamed from: w, reason: collision with root package name */
    public final Runnable f21265w;

    /* renamed from: x, reason: collision with root package name */
    public final d.b f21266x;

    /* renamed from: y, reason: collision with root package name */
    public final r f21267y;

    /* renamed from: z, reason: collision with root package name */
    public com.google.android.exoplayer2.upstream.a f21268z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Factory implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0194a f21269a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final a.InterfaceC0208a f21270b;

        /* renamed from: c, reason: collision with root package name */
        public u f21271c;

        /* renamed from: d, reason: collision with root package name */
        public com.google.android.exoplayer2.source.g f21272d;

        /* renamed from: e, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.h f21273e;

        /* renamed from: f, reason: collision with root package name */
        public long f21274f;

        /* renamed from: g, reason: collision with root package name */
        public long f21275g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public i.a<? extends z5.c> f21276h;

        /* renamed from: i, reason: collision with root package name */
        public List<StreamKey> f21277i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public Object f21278j;

        public Factory(a.InterfaceC0208a interfaceC0208a) {
            this(new c.a(interfaceC0208a), interfaceC0208a);
        }

        @Override // com.google.android.exoplayer2.source.a0
        public int[] a() {
            return new int[]{0};
        }

        @Override // com.google.android.exoplayer2.source.a0
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public DashMediaSource b(w0 w0Var) {
            List<StreamKey> list;
            w0 w0Var2 = w0Var;
            com.google.android.exoplayer2.util.a.e(w0Var2.f23163b);
            i.a aVar = this.f21276h;
            if (aVar == null) {
                aVar = new z5.d();
            }
            if (w0Var2.f23163b.f23220e.isEmpty()) {
                list = this.f21277i;
            } else {
                list = w0Var2.f23163b.f23220e;
            }
            i.a eVar = !list.isEmpty() ? new u5.e(aVar, list) : aVar;
            w0.g gVar = w0Var2.f23163b;
            boolean z10 = gVar.f23223h == null && this.f21278j != null;
            boolean z11 = gVar.f23220e.isEmpty() && !list.isEmpty();
            boolean z12 = w0Var2.f23164c.f23211a == -9223372036854775807L && this.f21274f != -9223372036854775807L;
            if (z10 || z11 || z12) {
                w0.c a10 = w0Var.a();
                if (z10) {
                    a10.s(this.f21278j);
                }
                if (z11) {
                    a10.q(list);
                }
                if (z12) {
                    a10.o(this.f21274f);
                }
                w0Var2 = a10.a();
            }
            w0 w0Var3 = w0Var2;
            return new DashMediaSource(w0Var3, null, this.f21270b, eVar, this.f21269a, this.f21272d, this.f21271c.a(w0Var3), this.f21273e, this.f21275g, null);
        }

        public Factory(a.InterfaceC0194a interfaceC0194a, @Nullable a.InterfaceC0208a interfaceC0208a) {
            this.f21269a = (a.InterfaceC0194a) com.google.android.exoplayer2.util.a.e(interfaceC0194a);
            this.f21270b = interfaceC0208a;
            this.f21271c = new com.google.android.exoplayer2.drm.a();
            this.f21273e = new com.google.android.exoplayer2.upstream.f();
            this.f21274f = -9223372036854775807L;
            this.f21275g = 30000L;
            this.f21272d = new com.google.android.exoplayer2.source.h();
            this.f21277i = Collections.emptyList();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements b0.b {
        public a() {
        }

        @Override // com.google.android.exoplayer2.util.b0.b
        public void a(IOException iOException) {
            DashMediaSource.this.Z(iOException);
        }

        @Override // com.google.android.exoplayer2.util.b0.b
        public void b() {
            DashMediaSource.this.a0(b0.h());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends Timeline {

        /* renamed from: c, reason: collision with root package name */
        public final long f21280c;

        /* renamed from: d, reason: collision with root package name */
        public final long f21281d;

        /* renamed from: e, reason: collision with root package name */
        public final long f21282e;

        /* renamed from: f, reason: collision with root package name */
        public final int f21283f;

        /* renamed from: g, reason: collision with root package name */
        public final long f21284g;

        /* renamed from: h, reason: collision with root package name */
        public final long f21285h;

        /* renamed from: i, reason: collision with root package name */
        public final long f21286i;

        /* renamed from: j, reason: collision with root package name */
        public final z5.c f21287j;

        /* renamed from: k, reason: collision with root package name */
        public final w0 f21288k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        public final w0.f f21289l;

        public b(long j10, long j11, long j12, int i10, long j13, long j14, long j15, z5.c cVar, w0 w0Var, @Nullable w0.f fVar) {
            com.google.android.exoplayer2.util.a.g(cVar.f54892d == (fVar != null));
            this.f21280c = j10;
            this.f21281d = j11;
            this.f21282e = j12;
            this.f21283f = i10;
            this.f21284g = j13;
            this.f21285h = j14;
            this.f21286i = j15;
            this.f21287j = cVar;
            this.f21288k = w0Var;
            this.f21289l = fVar;
        }

        public static boolean t(z5.c cVar) {
            return cVar.f54892d && cVar.f54893e != -9223372036854775807L && cVar.f54890b == -9223372036854775807L;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int b(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f21283f) >= 0 && intValue < i()) {
                return intValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.b g(int i10, Timeline.b bVar, boolean z10) {
            com.google.android.exoplayer2.util.a.c(i10, 0, i());
            return bVar.q(z10 ? this.f21287j.d(i10).f54922a : null, z10 ? Integer.valueOf(this.f21283f + i10) : null, 0, this.f21287j.g(i10), com.google.android.exoplayer2.h.d(this.f21287j.d(i10).f54923b - this.f21287j.d(0).f54923b) - this.f21284g);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int i() {
            return this.f21287j.e();
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object m(int i10) {
            com.google.android.exoplayer2.util.a.c(i10, 0, i());
            return Integer.valueOf(this.f21283f + i10);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.c o(int i10, Timeline.c cVar, long j10) {
            com.google.android.exoplayer2.util.a.c(i10, 0, 1);
            long s2 = s(j10);
            Object obj = Timeline.c.f19663r;
            w0 w0Var = this.f21288k;
            z5.c cVar2 = this.f21287j;
            return cVar.g(obj, w0Var, cVar2, this.f21280c, this.f21281d, this.f21282e, true, t(cVar2), this.f21289l, s2, this.f21285h, 0, i() - 1, this.f21284g);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int p() {
            return 1;
        }

        public final long s(long j10) {
            y5.e l10;
            long j11 = this.f21286i;
            if (!t(this.f21287j)) {
                return j11;
            }
            if (j10 > 0) {
                j11 += j10;
                if (j11 > this.f21285h) {
                    return -9223372036854775807L;
                }
            }
            long j12 = this.f21284g + j11;
            long g3 = this.f21287j.g(0);
            int i10 = 0;
            while (i10 < this.f21287j.e() - 1 && j12 >= g3) {
                j12 -= g3;
                i10++;
                g3 = this.f21287j.g(i10);
            }
            z5.g d10 = this.f21287j.d(i10);
            int a10 = d10.a(2);
            return (a10 == -1 || (l10 = d10.f54924c.get(a10).f54881c.get(0).l()) == null || l10.f(g3) == 0) ? j11 : (j11 + l10.c(l10.e(j12, g3))) - j12;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements d.b {
        public c() {
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void a(long j10) {
            DashMediaSource.this.S(j10);
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void b() {
            DashMediaSource.this.T();
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements i.a<Long> {

        /* renamed from: a, reason: collision with root package name */
        public static final Pattern f21291a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // com.google.android.exoplayer2.upstream.i.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, com.google.common.base.c.f25961c)).readLine();
            try {
                Matcher matcher = f21291a.matcher(readLine);
                if (!matcher.matches()) {
                    String valueOf = String.valueOf(readLine);
                    throw ParserException.createForMalformedManifest(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new String("Couldn't parse timestamp: "), null);
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j10 = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX.equals(matcher.group(4)) ? 1L : -1L;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= j10 * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0L : Long.parseLong(group2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e2) {
                throw ParserException.createForMalformedManifest(null, e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class e implements Loader.b<i<z5.c>> {
        public e() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void n(i<z5.c> iVar, long j10, long j11, boolean z10) {
            DashMediaSource.this.U(iVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void o(i<z5.c> iVar, long j10, long j11) {
            DashMediaSource.this.V(iVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c q(i<z5.c> iVar, long j10, long j11, IOException iOException, int i10) {
            return DashMediaSource.this.W(iVar, j10, j11, iOException, i10);
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class f implements r {
        public f() {
        }

        @Override // o6.r
        public void a() throws IOException {
            DashMediaSource.this.A.a();
            b();
        }

        public final void b() throws IOException {
            if (DashMediaSource.this.C != null) {
                throw DashMediaSource.this.C;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class g implements Loader.b<i<Long>> {
        public g() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void n(i<Long> iVar, long j10, long j11, boolean z10) {
            DashMediaSource.this.U(iVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void o(i<Long> iVar, long j10, long j11) {
            DashMediaSource.this.X(iVar, j10, j11);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c q(i<Long> iVar, long j10, long j11, IOException iOException, int i10) {
            return DashMediaSource.this.Y(iVar, j10, j11, iOException);
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class h implements i.a<Long> {
        public h() {
        }

        @Override // com.google.android.exoplayer2.upstream.i.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(j0.C0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        r0.a("goog.exo.dash");
    }

    public /* synthetic */ DashMediaSource(w0 w0Var, z5.c cVar, a.InterfaceC0208a interfaceC0208a, i.a aVar, a.InterfaceC0194a interfaceC0194a, com.google.android.exoplayer2.source.g gVar, com.google.android.exoplayer2.drm.c cVar2, com.google.android.exoplayer2.upstream.h hVar, long j10, a aVar2) {
        this(w0Var, cVar, interfaceC0208a, aVar, interfaceC0194a, gVar, cVar2, hVar, j10);
    }

    public static long K(z5.g gVar, long j10, long j11) {
        long d10 = com.google.android.exoplayer2.h.d(gVar.f54923b);
        boolean O = O(gVar);
        long j12 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < gVar.f54924c.size(); i10++) {
            z5.a aVar = gVar.f54924c.get(i10);
            List<j> list = aVar.f54881c;
            if ((!O || aVar.f54880b != 3) && !list.isEmpty()) {
                y5.e l10 = list.get(0).l();
                if (l10 == null) {
                    return d10 + j10;
                }
                long j13 = l10.j(j10, j11);
                if (j13 == 0) {
                    return d10;
                }
                long b4 = (l10.b(j10, j11) + j13) - 1;
                j12 = Math.min(j12, l10.a(b4, j10) + l10.c(b4) + d10);
            }
        }
        return j12;
    }

    public static long L(z5.g gVar, long j10, long j11) {
        long d10 = com.google.android.exoplayer2.h.d(gVar.f54923b);
        boolean O = O(gVar);
        long j12 = d10;
        for (int i10 = 0; i10 < gVar.f54924c.size(); i10++) {
            z5.a aVar = gVar.f54924c.get(i10);
            List<j> list = aVar.f54881c;
            if ((!O || aVar.f54880b != 3) && !list.isEmpty()) {
                y5.e l10 = list.get(0).l();
                if (l10 == null || l10.j(j10, j11) == 0) {
                    return d10;
                }
                j12 = Math.max(j12, l10.c(l10.b(j10, j11)) + d10);
            }
        }
        return j12;
    }

    public static long M(z5.c cVar, long j10) {
        y5.e l10;
        int e2 = cVar.e() - 1;
        z5.g d10 = cVar.d(e2);
        long d11 = com.google.android.exoplayer2.h.d(d10.f54923b);
        long g3 = cVar.g(e2);
        long d12 = com.google.android.exoplayer2.h.d(j10);
        long d13 = com.google.android.exoplayer2.h.d(cVar.f54889a);
        long d14 = com.google.android.exoplayer2.h.d(5000L);
        for (int i10 = 0; i10 < d10.f54924c.size(); i10++) {
            List<j> list = d10.f54924c.get(i10).f54881c;
            if (!list.isEmpty() && (l10 = list.get(0).l()) != null) {
                long d15 = ((d13 + d11) + l10.d(g3, d12)) - d12;
                if (d15 < d14 - 100000 || (d15 > d14 && d15 < d14 + 100000)) {
                    d14 = d15;
                }
            }
        }
        return LongMath.c(d14, 1000L, RoundingMode.CEILING);
    }

    public static boolean O(z5.g gVar) {
        for (int i10 = 0; i10 < gVar.f54924c.size(); i10++) {
            int i11 = gVar.f54924c.get(i10).f54880b;
            if (i11 == 1 || i11 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean P(z5.g gVar) {
        for (int i10 = 0; i10 < gVar.f54924c.size(); i10++) {
            y5.e l10 = gVar.f54924c.get(i10).f54881c.get(0).l();
            if (l10 == null || l10.i()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        b0(false);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable v vVar) {
        this.B = vVar;
        this.f21255m.prepare();
        if (this.f21251i) {
            b0(false);
            return;
        }
        this.f21268z = this.f21252j.a();
        this.A = new Loader("DashMediaSource");
        this.D = j0.x();
        h0();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.I = false;
        this.f21268z = null;
        Loader loader = this.A;
        if (loader != null) {
            loader.l();
            this.A = null;
        }
        this.J = 0L;
        this.K = 0L;
        this.H = this.f21251i ? this.H : null;
        this.F = this.G;
        this.C = null;
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.D = null;
        }
        this.L = -9223372036854775807L;
        this.M = 0;
        this.N = -9223372036854775807L;
        this.O = 0;
        this.f21263u.clear();
        this.f21257o.i();
        this.f21255m.release();
    }

    public final long N() {
        return Math.min((this.M - 1) * 1000, 5000);
    }

    public final void R() {
        b0.j(this.A, new a());
    }

    public void S(long j10) {
        long j11 = this.N;
        if (j11 == -9223372036854775807L || j11 < j10) {
            this.N = j10;
        }
    }

    public void T() {
        this.D.removeCallbacks(this.f21265w);
        h0();
    }

    public void U(i<?> iVar, long j10, long j11) {
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        this.f21256n.c(iVar.f22896a);
        this.f21259q.q(mVar, iVar.f22898c);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void V(com.google.android.exoplayer2.upstream.i<z5.c> r19, long r20, long r22) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.V(com.google.android.exoplayer2.upstream.i, long, long):void");
    }

    public Loader.c W(i<z5.c> iVar, long j10, long j11, IOException iOException, int i10) {
        Loader.c h10;
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        long a10 = this.f21256n.a(new h.c(mVar, new MediaLoadData(iVar.f22898c), iOException, i10));
        if (a10 == -9223372036854775807L) {
            h10 = Loader.f22733g;
        } else {
            h10 = Loader.h(false, a10);
        }
        boolean z10 = !h10.c();
        this.f21259q.x(mVar, iVar.f22898c, iOException, z10);
        if (z10) {
            this.f21256n.c(iVar.f22896a);
        }
        return h10;
    }

    public void X(i<Long> iVar, long j10, long j11) {
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        this.f21256n.c(iVar.f22896a);
        this.f21259q.t(mVar, iVar.f22898c);
        a0(iVar.d().longValue() - j10);
    }

    public Loader.c Y(i<Long> iVar, long j10, long j11, IOException iOException) {
        this.f21259q.x(new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a()), iVar.f22898c, iOException, true);
        this.f21256n.c(iVar.f22896a);
        Z(iOException);
        return Loader.f22732f;
    }

    public final void Z(IOException iOException) {
        com.google.android.exoplayer2.util.m.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        b0(true);
    }

    public final void a0(long j10) {
        this.L = j10;
        b0(true);
    }

    public final void b0(boolean z10) {
        z5.g gVar;
        long j10;
        long j11;
        for (int i10 = 0; i10 < this.f21263u.size(); i10++) {
            int keyAt = this.f21263u.keyAt(i10);
            if (keyAt >= this.O) {
                this.f21263u.valueAt(i10).K(this.H, keyAt - this.O);
            }
        }
        z5.g d10 = this.H.d(0);
        int e2 = this.H.e() - 1;
        z5.g d11 = this.H.d(e2);
        long g3 = this.H.g(e2);
        long d12 = com.google.android.exoplayer2.h.d(j0.X(this.L));
        long L = L(d10, this.H.g(0), d12);
        long K = K(d11, g3, d12);
        boolean z11 = this.H.f54892d && !P(d11);
        if (z11) {
            long j12 = this.H.f54894f;
            if (j12 != -9223372036854775807L) {
                L = Math.max(L, K - com.google.android.exoplayer2.h.d(j12));
            }
        }
        long j13 = K - L;
        z5.c cVar = this.H;
        if (cVar.f54892d) {
            com.google.android.exoplayer2.util.a.g(cVar.f54889a != -9223372036854775807L);
            long d13 = (d12 - com.google.android.exoplayer2.h.d(this.H.f54889a)) - L;
            i0(d13, j13);
            long e10 = this.H.f54889a + com.google.android.exoplayer2.h.e(L);
            long d14 = d13 - com.google.android.exoplayer2.h.d(this.E.f23211a);
            long min = Math.min(5000000L, j13 / 2);
            j10 = e10;
            j11 = d14 < min ? min : d14;
            gVar = d10;
        } else {
            gVar = d10;
            j10 = -9223372036854775807L;
            j11 = 0;
        }
        long d15 = L - com.google.android.exoplayer2.h.d(gVar.f54923b);
        z5.c cVar2 = this.H;
        C(new b(cVar2.f54889a, j10, this.L, this.O, d15, j13, j11, cVar2, this.f21250h, cVar2.f54892d ? this.E : null));
        if (this.f21251i) {
            return;
        }
        this.D.removeCallbacks(this.f21265w);
        if (z11) {
            this.D.postDelayed(this.f21265w, M(this.H, j0.X(this.L)));
        }
        if (this.I) {
            h0();
            return;
        }
        if (z10) {
            z5.c cVar3 = this.H;
            if (cVar3.f54892d) {
                long j14 = cVar3.f54893e;
                if (j14 != -9223372036854775807L) {
                    if (j14 == 0) {
                        j14 = 5000;
                    }
                    f0(Math.max(0L, (this.J + j14) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    public final void c0(o oVar) {
        String str = oVar.f54975a;
        if (!j0.c(str, "urn:mpeg:dash:utc:direct:2014") && !j0.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            if (!j0.c(str, "urn:mpeg:dash:utc:http-iso:2014") && !j0.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                if (!j0.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !j0.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                    if (!j0.c(str, "urn:mpeg:dash:utc:ntp:2014") && !j0.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
                        Z(new IOException("Unsupported UTC timing scheme"));
                        return;
                    } else {
                        R();
                        return;
                    }
                }
                e0(oVar, new h(null));
                return;
            }
            e0(oVar, new d());
            return;
        }
        d0(oVar);
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21250h;
    }

    public final void d0(o oVar) {
        try {
            a0(j0.C0(oVar.f54976b) - this.K);
        } catch (ParserException e2) {
            Z(e2);
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        int intValue = ((Integer) aVar.f21883a).intValue() - this.O;
        z.a x10 = x(aVar, this.H.d(intValue).f54923b);
        com.google.android.exoplayer2.source.dash.b bVar2 = new com.google.android.exoplayer2.source.dash.b(intValue + this.O, this.H, this.f21257o, intValue, this.f21253k, this.B, this.f21255m, u(aVar), this.f21256n, x10, this.L, this.f21267y, bVar, this.f21254l, this.f21266x);
        this.f21263u.put(bVar2.f21297b, bVar2);
        return bVar2;
    }

    public final void e0(o oVar, i.a<Long> aVar) {
        g0(new i(this.f21268z, Uri.parse(oVar.f54976b), 5, aVar), new g(this, null), 1);
    }

    @Override // com.google.android.exoplayer2.source.s
    public void f() throws IOException {
        this.f21267y.a();
    }

    public final void f0(long j10) {
        this.D.postDelayed(this.f21264v, j10);
    }

    public final <T> void g0(i<T> iVar, Loader.b<i<T>> bVar, int i10) {
        this.f21259q.z(new m(iVar.f22896a, iVar.f22897b, this.A.n(iVar, bVar, i10)), iVar.f22898c);
    }

    public final void h0() {
        Uri uri;
        this.D.removeCallbacks(this.f21264v);
        if (this.A.i()) {
            return;
        }
        if (this.A.j()) {
            this.I = true;
            return;
        }
        synchronized (this.f21262t) {
            uri = this.F;
        }
        this.I = false;
        g0(new i(this.f21268z, uri, 4, this.f21260r), this.f21261s, this.f21256n.d(4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0038, code lost:
    
        if (r5 != (-9223372036854775807L)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r1 != (-9223372036854775807L)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i0(long r15, long r17) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.i0(long, long):void");
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) pVar;
        bVar.G();
        this.f21263u.remove(bVar.f21297b);
    }

    public DashMediaSource(w0 w0Var, @Nullable z5.c cVar, @Nullable a.InterfaceC0208a interfaceC0208a, @Nullable i.a<? extends z5.c> aVar, a.InterfaceC0194a interfaceC0194a, com.google.android.exoplayer2.source.g gVar, com.google.android.exoplayer2.drm.c cVar2, com.google.android.exoplayer2.upstream.h hVar, long j10) {
        this.f21250h = w0Var;
        this.E = w0Var.f23164c;
        this.F = ((w0.g) com.google.android.exoplayer2.util.a.e(w0Var.f23163b)).f23216a;
        this.G = w0Var.f23163b.f23216a;
        this.H = cVar;
        this.f21252j = interfaceC0208a;
        this.f21260r = aVar;
        this.f21253k = interfaceC0194a;
        this.f21255m = cVar2;
        this.f21256n = hVar;
        this.f21258p = j10;
        this.f21254l = gVar;
        this.f21257o = new y5.b();
        boolean z10 = cVar != null;
        this.f21251i = z10;
        a aVar2 = null;
        this.f21259q = w(null);
        this.f21262t = new Object();
        this.f21263u = new SparseArray<>();
        this.f21266x = new c(this, aVar2);
        this.N = -9223372036854775807L;
        this.L = -9223372036854775807L;
        if (z10) {
            com.google.android.exoplayer2.util.a.g(true ^ cVar.f54892d);
            this.f21261s = null;
            this.f21264v = null;
            this.f21265w = null;
            this.f21267y = new r.a();
            return;
        }
        this.f21261s = new e(this, aVar2);
        this.f21267y = new f();
        this.f21264v = new Runnable() { // from class: y5.c
            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource.this.h0();
            }
        };
        this.f21265w = new Runnable() { // from class: y5.d
            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource.this.Q();
            }
        };
    }
}
