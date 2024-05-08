package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.alibaba.security.realidentity.build.cb;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.j0;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import o6.i;
import o6.s;
import o6.u;
import o6.v;
import p6.e;
import p6.f;
import p6.k;

/* compiled from: CacheDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements com.google.android.exoplayer2.upstream.a {

    /* renamed from: a, reason: collision with root package name */
    public final Cache f22812a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f22813b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.upstream.a f22814c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f22815d;

    /* renamed from: e, reason: collision with root package name */
    public final e f22816e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final b f22817f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f22818g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f22819h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f22820i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Uri f22821j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.b f22822k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.b f22823l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.a f22824m;

    /* renamed from: n, reason: collision with root package name */
    public long f22825n;

    /* renamed from: o, reason: collision with root package name */
    public long f22826o;

    /* renamed from: p, reason: collision with root package name */
    public long f22827p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public f f22828q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f22829r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f22830s;

    /* renamed from: t, reason: collision with root package name */
    public long f22831t;

    /* renamed from: u, reason: collision with root package name */
    public long f22832u;

    /* compiled from: CacheDataSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(int i10);

        void b(long j10, long j11);
    }

    /* compiled from: CacheDataSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements a.InterfaceC0208a {

        /* renamed from: a, reason: collision with root package name */
        public Cache f22833a;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public i.a f22835c;

        /* renamed from: e, reason: collision with root package name */
        public boolean f22837e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public a.InterfaceC0208a f22838f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public PriorityTaskManager f22839g;

        /* renamed from: h, reason: collision with root package name */
        public int f22840h;

        /* renamed from: i, reason: collision with root package name */
        public int f22841i;

        /* renamed from: j, reason: collision with root package name */
        @Nullable
        public b f22842j;

        /* renamed from: b, reason: collision with root package name */
        public a.InterfaceC0208a f22834b = new FileDataSource.a();

        /* renamed from: d, reason: collision with root package name */
        public e f22836d = e.f52866a;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0208a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a() {
            a.InterfaceC0208a interfaceC0208a = this.f22838f;
            return c(interfaceC0208a != null ? interfaceC0208a.a() : null, this.f22841i, this.f22840h);
        }

        public final a c(@Nullable com.google.android.exoplayer2.upstream.a aVar, int i10, int i11) {
            i iVar;
            Cache cache = (Cache) com.google.android.exoplayer2.util.a.e(this.f22833a);
            if (this.f22837e || aVar == null) {
                iVar = null;
            } else {
                i.a aVar2 = this.f22835c;
                if (aVar2 != null) {
                    iVar = aVar2.a();
                } else {
                    iVar = new CacheDataSink.a().b(cache).a();
                }
            }
            return new a(cache, aVar, this.f22834b.a(), iVar, this.f22836d, i10, this.f22839g, i11, this.f22842j);
        }

        public c d(Cache cache) {
            this.f22833a = cache;
            return this;
        }

        public c e(int i10) {
            this.f22841i = i10;
            return this;
        }

        public c f(@Nullable a.InterfaceC0208a interfaceC0208a) {
            this.f22838f = interfaceC0208a;
            return this;
        }
    }

    public static Uri t(Cache cache, String str, Uri uri) {
        Uri b4 = p6.i.b(cache.a(str));
        return b4 != null ? b4 : uri;
    }

    public final void A(int i10) {
        b bVar = this.f22817f;
        if (bVar != null) {
            bVar.a(i10);
        }
    }

    public final void B(com.google.android.exoplayer2.upstream.b bVar, boolean z10) throws IOException {
        f c4;
        long j10;
        com.google.android.exoplayer2.upstream.b a10;
        com.google.android.exoplayer2.upstream.a aVar;
        String str = (String) j0.j(bVar.f22775i);
        if (this.f22830s) {
            c4 = null;
        } else if (this.f22818g) {
            try {
                c4 = this.f22812a.c(str, this.f22826o, this.f22827p);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            c4 = this.f22812a.e(str, this.f22826o, this.f22827p);
        }
        if (c4 == null) {
            aVar = this.f22815d;
            a10 = bVar.a().h(this.f22826o).g(this.f22827p).a();
        } else if (c4.f52870e) {
            Uri fromFile = Uri.fromFile((File) j0.j(c4.f52871f));
            long j11 = c4.f52868c;
            long j12 = this.f22826o - j11;
            long j13 = c4.f52869d - j12;
            long j14 = this.f22827p;
            if (j14 != -1) {
                j13 = Math.min(j13, j14);
            }
            a10 = bVar.a().i(fromFile).k(j11).h(j12).g(j13).a();
            aVar = this.f22813b;
        } else {
            if (c4.c()) {
                j10 = this.f22827p;
            } else {
                j10 = c4.f52869d;
                long j15 = this.f22827p;
                if (j15 != -1) {
                    j10 = Math.min(j10, j15);
                }
            }
            a10 = bVar.a().h(this.f22826o).g(j10).a();
            aVar = this.f22814c;
            if (aVar == null) {
                aVar = this.f22815d;
                this.f22812a.b(c4);
                c4 = null;
            }
        }
        this.f22832u = (this.f22830s || aVar != this.f22815d) ? Long.MAX_VALUE : this.f22826o + cb.f3266l;
        if (z10) {
            com.google.android.exoplayer2.util.a.g(v());
            if (aVar == this.f22815d) {
                return;
            }
            try {
                n();
            } finally {
            }
        }
        if (c4 != null && c4.b()) {
            this.f22828q = c4;
        }
        this.f22824m = aVar;
        this.f22823l = a10;
        this.f22825n = 0L;
        long a11 = aVar.a(a10);
        k kVar = new k();
        if (a10.f22774h == -1 && a11 != -1) {
            this.f22827p = a11;
            k.g(kVar, this.f22826o + a11);
        }
        if (x()) {
            Uri i10 = aVar.i();
            this.f22821j = i10;
            k.h(kVar, bVar.f22767a.equals(i10) ^ true ? this.f22821j : null);
        }
        if (y()) {
            this.f22812a.i(str, kVar);
        }
    }

    public final void C(String str) throws IOException {
        this.f22827p = 0L;
        if (y()) {
            k kVar = new k();
            k.g(kVar, this.f22826o);
            this.f22812a.i(str, kVar);
        }
    }

    public final int D(com.google.android.exoplayer2.upstream.b bVar) {
        if (this.f22819h && this.f22829r) {
            return 0;
        }
        return (this.f22820i && bVar.f22774h == -1) ? 1 : -1;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        try {
            String a10 = this.f22816e.a(bVar);
            com.google.android.exoplayer2.upstream.b a11 = bVar.a().f(a10).a();
            this.f22822k = a11;
            this.f22821j = t(this.f22812a, a10, a11.f22767a);
            this.f22826o = bVar.f22773g;
            int D = D(bVar);
            boolean z10 = D != -1;
            this.f22830s = z10;
            if (z10) {
                A(D);
            }
            if (this.f22830s) {
                this.f22827p = -1L;
            } else {
                long a12 = p6.i.a(this.f22812a.a(a10));
                this.f22827p = a12;
                if (a12 != -1) {
                    long j10 = a12 - bVar.f22773g;
                    this.f22827p = j10;
                    if (j10 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long j11 = bVar.f22774h;
            if (j11 != -1) {
                long j12 = this.f22827p;
                if (j12 != -1) {
                    j11 = Math.min(j12, j11);
                }
                this.f22827p = j11;
            }
            long j13 = this.f22827p;
            if (j13 > 0 || j13 == -1) {
                B(a11, false);
            }
            long j14 = bVar.f22774h;
            return j14 != -1 ? j14 : this.f22827p;
        } catch (Throwable th) {
            u(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f22822k = null;
        this.f22821j = null;
        this.f22826o = 0L;
        z();
        try {
            n();
        } catch (Throwable th) {
            u(th);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        this.f22813b.d(vVar);
        this.f22815d.d(vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        if (x()) {
            return this.f22815d.e();
        }
        return Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f22821j;
    }

    public final void n() throws IOException {
        com.google.android.exoplayer2.upstream.a aVar = this.f22824m;
        if (aVar == null) {
            return;
        }
        try {
            aVar.close();
        } finally {
            this.f22823l = null;
            this.f22824m = null;
            f fVar = this.f22828q;
            if (fVar != null) {
                this.f22812a.b(fVar);
                this.f22828q = null;
            }
        }
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        if (this.f22827p == 0) {
            return -1;
        }
        com.google.android.exoplayer2.upstream.b bVar = (com.google.android.exoplayer2.upstream.b) com.google.android.exoplayer2.util.a.e(this.f22822k);
        com.google.android.exoplayer2.upstream.b bVar2 = (com.google.android.exoplayer2.upstream.b) com.google.android.exoplayer2.util.a.e(this.f22823l);
        try {
            if (this.f22826o >= this.f22832u) {
                B(bVar, true);
            }
            int read = ((com.google.android.exoplayer2.upstream.a) com.google.android.exoplayer2.util.a.e(this.f22824m)).read(bArr, i10, i11);
            if (read != -1) {
                if (w()) {
                    this.f22831t += read;
                }
                long j10 = read;
                this.f22826o += j10;
                this.f22825n += j10;
                long j11 = this.f22827p;
                if (j11 != -1) {
                    this.f22827p = j11 - j10;
                }
            } else {
                if (x()) {
                    long j12 = bVar2.f22774h;
                    if (j12 == -1 || this.f22825n < j12) {
                        C((String) j0.j(bVar.f22775i));
                    }
                }
                long j13 = this.f22827p;
                if (j13 <= 0) {
                    if (j13 == -1) {
                    }
                }
                n();
                B(bVar, false);
                return read(bArr, i10, i11);
            }
            return read;
        } catch (Throwable th) {
            u(th);
            throw th;
        }
    }

    public final void u(Throwable th) {
        if (w() || (th instanceof Cache.CacheException)) {
            this.f22829r = true;
        }
    }

    public final boolean v() {
        return this.f22824m == this.f22815d;
    }

    public final boolean w() {
        return this.f22824m == this.f22813b;
    }

    public final boolean x() {
        return !w();
    }

    public final boolean y() {
        return this.f22824m == this.f22814c;
    }

    public final void z() {
        b bVar = this.f22817f;
        if (bVar == null || this.f22831t <= 0) {
            return;
        }
        bVar.b(this.f22812a.g(), this.f22831t);
        this.f22831t = 0L;
    }

    public a(Cache cache, @Nullable com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.a aVar2, @Nullable i iVar, @Nullable e eVar, int i10, @Nullable PriorityTaskManager priorityTaskManager, int i11, @Nullable b bVar) {
        this.f22812a = cache;
        this.f22813b = aVar2;
        this.f22816e = eVar == null ? e.f52866a : eVar;
        this.f22818g = (i10 & 1) != 0;
        this.f22819h = (i10 & 2) != 0;
        this.f22820i = (i10 & 4) != 0;
        if (aVar != null) {
            aVar = priorityTaskManager != null ? new s(aVar, priorityTaskManager, i11) : aVar;
            this.f22815d = aVar;
            this.f22814c = iVar != null ? new u(aVar, iVar) : null;
        } else {
            this.f22815d = g.f22884a;
            this.f22814c = null;
        }
        this.f22817f = bVar;
    }
}
