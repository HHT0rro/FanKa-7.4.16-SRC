package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import b6.a0;
import b6.p;
import b6.q;
import b6.t;
import b6.u;
import b6.v;
import b6.w;
import b6.x;
import b6.y;
import b6.z;
import com.alibaba.security.realidentity.build.cs;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.d;
import com.google.android.exoplayer2.source.rtsp.e;
import com.google.android.exoplayer2.source.rtsp.f;
import com.google.android.exoplayer2.source.rtsp.g;
import com.google.android.exoplayer2.source.rtsp.h;
import com.google.android.exoplayer2.util.j0;
import com.google.common.base.s;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.g0;
import com.huawei.quickcard.base.Attributes;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.SocketFactory;

/* compiled from: RtspClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public final f f21914b;

    /* renamed from: c, reason: collision with root package name */
    public final e f21915c;

    /* renamed from: d, reason: collision with root package name */
    public final Uri f21916d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final h.a f21917e;

    /* renamed from: f, reason: collision with root package name */
    public final String f21918f;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public String f21923k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public b f21924l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.source.rtsp.c f21925m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21926n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21927o;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque<f.d> f21919g = new ArrayDeque<>();

    /* renamed from: h, reason: collision with root package name */
    public final SparseArray<v> f21920h = new SparseArray<>();

    /* renamed from: i, reason: collision with root package name */
    public final C0201d f21921i = new C0201d();

    /* renamed from: p, reason: collision with root package name */
    public long f21928p = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public g f21922j = new g(new c());

    /* compiled from: RtspClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements Runnable, Closeable {

        /* renamed from: b, reason: collision with root package name */
        public final Handler f21929b = j0.x();

        /* renamed from: c, reason: collision with root package name */
        public final long f21930c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f21931d;

        public b(long j10) {
            this.f21930c = j10;
        }

        public void a() {
            if (this.f21931d) {
                return;
            }
            this.f21931d = true;
            this.f21929b.postDelayed(this, this.f21930c);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f21931d = false;
            this.f21929b.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f21921i.d(d.this.f21916d, d.this.f21923k);
            this.f21929b.postDelayed(this, this.f21930c);
        }
    }

    /* compiled from: RtspClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements g.d {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f21933a = j0.x();

        public c() {
        }

        @Override // com.google.android.exoplayer2.source.rtsp.g.d
        public /* synthetic */ void a(List list, Exception exc) {
            q.b(this, list, exc);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.g.d
        public void b(final List<String> list) {
            this.f21933a.post(new Runnable() { // from class: b6.j
                @Override // java.lang.Runnable
                public final void run() {
                    d.c.this.f(list);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.rtsp.g.d
        public /* synthetic */ void c(Exception exc) {
            q.a(this, exc);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final void f(List<String> list) {
            x d10;
            ImmutableList<y> a10;
            w h10 = h.h(list);
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(h10.f1368b.d("CSeq")));
            v vVar = (v) d.this.f21920h.get(parseInt);
            if (vVar == null) {
                return;
            }
            d.this.f21920h.remove(parseInt);
            int i10 = vVar.f1364b;
            try {
                int i11 = h10.f1367a;
                if (i11 != 200) {
                    if (i11 == 401 && d.this.f21917e != null && !d.this.f21927o) {
                        String d11 = h10.f1368b.d("WWW-Authenticate");
                        if (d11 != null) {
                            d.this.f21925m = h.k(d11);
                            d.this.f21921i.b();
                            d.this.f21927o = true;
                            return;
                        }
                        throw ParserException.createForMalformedManifest("Missing WWW-Authenticate header in a 401 response.", null);
                    }
                    d dVar = d.this;
                    String o10 = h.o(i10);
                    int i12 = h10.f1367a;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(o10).length() + 12);
                    sb2.append(o10);
                    sb2.append(" ");
                    sb2.append(i12);
                    dVar.I(new RtspMediaSource.RtspPlaybackException(sb2.toString()));
                    return;
                }
                switch (i10) {
                    case 1:
                    case 3:
                    case 7:
                    case 8:
                    case 9:
                    case 11:
                    case 12:
                        return;
                    case 2:
                        g(new b6.k(i11, a0.b(h10.f1369c)));
                        return;
                    case 4:
                        h(new t(i11, h.g(h10.f1368b.d("Public"))));
                        return;
                    case 5:
                        i();
                        return;
                    case 6:
                        String d12 = h10.f1368b.d("Range");
                        if (d12 == null) {
                            d10 = x.f1370c;
                        } else {
                            d10 = x.d(d12);
                        }
                        String d13 = h10.f1368b.d("RTP-Info");
                        if (d13 == null) {
                            a10 = ImmutableList.of();
                        } else {
                            a10 = y.a(d13, d.this.f21916d);
                        }
                        j(new u(h10.f1367a, d10, a10));
                        return;
                    case 10:
                        String d14 = h10.f1368b.d("Session");
                        String d15 = h10.f1368b.d("Transport");
                        if (d14 != null && d15 != null) {
                            k(new i(h10.f1367a, h.i(d14), d15));
                            return;
                        }
                        throw ParserException.createForMalformedManifest("Missing mandatory session or transport header", null);
                    default:
                        throw new IllegalStateException();
                }
            } catch (ParserException e2) {
                d.this.I(new RtspMediaSource.RtspPlaybackException(e2));
            }
        }

        public final void g(b6.k kVar) {
            x xVar = x.f1370c;
            String str = kVar.f1347b.f1377a.get(Attributes.Style.RANGE);
            if (str != null) {
                try {
                    xVar = x.d(str);
                } catch (ParserException e2) {
                    d.this.f21914b.b("SDP format error.", e2);
                    return;
                }
            }
            ImmutableList<p> G = d.G(kVar.f1347b, d.this.f21916d);
            if (G.isEmpty()) {
                d.this.f21914b.b("No playable track.", null);
            } else {
                d.this.f21914b.f(xVar, G);
                d.this.f21926n = true;
            }
        }

        public final void h(t tVar) {
            if (d.this.f21924l != null) {
                return;
            }
            if (d.N(tVar.f1359b)) {
                d.this.f21921i.c(d.this.f21916d, d.this.f21923k);
            } else {
                d.this.f21914b.b("DESCRIBE not supported.", null);
            }
        }

        public final void i() {
            if (d.this.f21928p != -9223372036854775807L) {
                d dVar = d.this;
                dVar.Q(com.google.android.exoplayer2.h.e(dVar.f21928p));
            }
        }

        public final void j(u uVar) {
            if (d.this.f21924l == null) {
                d dVar = d.this;
                dVar.f21924l = new b(30000L);
                d.this.f21924l.a();
            }
            d.this.f21915c.e(com.google.android.exoplayer2.h.d(uVar.f1361b.f1372a), uVar.f1362c);
            d.this.f21928p = -9223372036854775807L;
        }

        public final void k(i iVar) {
            d.this.f21923k = iVar.f22006b.f22003a;
            d.this.H();
        }
    }

    /* compiled from: RtspClient.java */
    /* renamed from: com.google.android.exoplayer2.source.rtsp.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class C0201d {

        /* renamed from: a, reason: collision with root package name */
        public int f21935a;

        /* renamed from: b, reason: collision with root package name */
        public v f21936b;

        public C0201d() {
        }

        public final v a(int i10, @Nullable String str, Map<String, String> map, Uri uri) {
            e.b bVar = new e.b();
            int i11 = this.f21935a;
            this.f21935a = i11 + 1;
            bVar.b("CSeq", String.valueOf(i11));
            bVar.b("User-Agent", d.this.f21918f);
            if (str != null) {
                bVar.b("Session", str);
            }
            if (d.this.f21925m != null) {
                com.google.android.exoplayer2.util.a.i(d.this.f21917e);
                try {
                    bVar.b(cs.K, d.this.f21925m.a(d.this.f21917e, uri, i10));
                } catch (ParserException e2) {
                    d.this.I(new RtspMediaSource.RtspPlaybackException(e2));
                }
            }
            bVar.d(map);
            return new v(uri, i10, bVar.e(), "");
        }

        public void b() {
            com.google.android.exoplayer2.util.a.i(this.f21936b);
            ImmutableListMultimap<String, String> b4 = this.f21936b.f1365c.b();
            HashMap hashMap = new HashMap();
            for (String str : b4.keySet()) {
                if (!str.equals("CSeq") && !str.equals("User-Agent") && !str.equals("Session") && !str.equals(cs.K)) {
                    hashMap.put(str, (String) g0.f(b4.get((ImmutableListMultimap<String, String>) str)));
                }
            }
            g(a(this.f21936b.f1364b, d.this.f21923k, hashMap, this.f21936b.f1363a));
        }

        public void c(Uri uri, @Nullable String str) {
            g(a(2, str, ImmutableMap.of(), uri));
        }

        public void d(Uri uri, @Nullable String str) {
            g(a(4, str, ImmutableMap.of(), uri));
        }

        public void e(Uri uri, String str) {
            g(a(5, str, ImmutableMap.of(), uri));
        }

        public void f(Uri uri, long j10, String str) {
            g(a(6, str, ImmutableMap.of("Range", x.b(j10)), uri));
        }

        public final void g(v vVar) {
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(vVar.f1365c.d("CSeq")));
            com.google.android.exoplayer2.util.a.g(d.this.f21920h.get(parseInt) == null);
            d.this.f21920h.append(parseInt, vVar);
            d.this.f21922j.g(h.m(vVar));
            this.f21936b = vVar;
        }

        public void h(Uri uri, String str, @Nullable String str2) {
            g(a(10, str2, ImmutableMap.of("Transport", str), uri));
        }

        public void i(Uri uri, String str) {
            g(a(12, str, ImmutableMap.of(), uri));
        }
    }

    /* compiled from: RtspClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface e {
        void d();

        void e(long j10, ImmutableList<y> immutableList);

        void g(RtspMediaSource.RtspPlaybackException rtspPlaybackException);
    }

    /* compiled from: RtspClient.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface f {
        void b(String str, @Nullable Throwable th);

        void f(x xVar, ImmutableList<p> immutableList);
    }

    public d(f fVar, e eVar, String str, Uri uri) {
        this.f21914b = fVar;
        this.f21915c = eVar;
        this.f21916d = h.l(uri);
        this.f21917e = h.j(uri);
        this.f21918f = str;
    }

    public static ImmutableList<p> G(z zVar, Uri uri) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i10 = 0; i10 < zVar.f1378b.size(); i10++) {
            b6.a aVar2 = zVar.f1378b.get(i10);
            if (b6.h.b(aVar2)) {
                aVar.a(new p(aVar2, uri));
            }
        }
        return aVar.k();
    }

    public static Socket J(Uri uri) throws IOException {
        com.google.android.exoplayer2.util.a.a(uri.getHost() != null);
        return SocketFactory.getDefault().createSocket((String) com.google.android.exoplayer2.util.a.e(uri.getHost()), uri.getPort() > 0 ? uri.getPort() : MetricsProto.MetricsEvent.DIALOG_ZEN_ACCESS_GRANT);
    }

    public static boolean N(List<Integer> list) {
        return list.isEmpty() || list.contains(2);
    }

    public final void H() {
        f.d pollFirst = this.f21919g.pollFirst();
        if (pollFirst == null) {
            this.f21915c.d();
        } else {
            this.f21921i.h(pollFirst.c(), pollFirst.d(), this.f21923k);
        }
    }

    public final void I(Throwable th) {
        RtspMediaSource.RtspPlaybackException rtspPlaybackException;
        if (th instanceof RtspMediaSource.RtspPlaybackException) {
            rtspPlaybackException = (RtspMediaSource.RtspPlaybackException) th;
        } else {
            rtspPlaybackException = new RtspMediaSource.RtspPlaybackException(th);
        }
        if (this.f21926n) {
            this.f21915c.g(rtspPlaybackException);
        } else {
            this.f21914b.b(s.e(th.getMessage()), th);
        }
    }

    public void K(int i10, g.b bVar) {
        this.f21922j.f(i10, bVar);
    }

    public void L() {
        try {
            close();
            g gVar = new g(new c());
            this.f21922j = gVar;
            gVar.e(J(this.f21916d));
            this.f21923k = null;
            this.f21927o = false;
            this.f21925m = null;
        } catch (IOException e2) {
            this.f21915c.g(new RtspMediaSource.RtspPlaybackException(e2));
        }
    }

    public void M(long j10) {
        this.f21921i.e(this.f21916d, (String) com.google.android.exoplayer2.util.a.e(this.f21923k));
        this.f21928p = j10;
    }

    public void O(List<f.d> list) {
        this.f21919g.addAll(list);
        H();
    }

    public void P() throws IOException {
        try {
            this.f21922j.e(J(this.f21916d));
            this.f21921i.d(this.f21916d, this.f21923k);
        } catch (IOException e2) {
            j0.o(this.f21922j);
            throw e2;
        }
    }

    public void Q(long j10) {
        this.f21921i.f(this.f21916d, j10, (String) com.google.android.exoplayer2.util.a.e(this.f21923k));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b bVar = this.f21924l;
        if (bVar != null) {
            bVar.close();
            this.f21924l = null;
            this.f21921i.i(this.f21916d, (String) com.google.android.exoplayer2.util.a.e(this.f21923k));
        }
        this.f21922j.close();
    }
}
