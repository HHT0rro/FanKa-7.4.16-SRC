package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b5.a0;
import b5.v;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiresApi(18)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DefaultDrmSession implements DrmSession {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final List<DrmInitData.SchemeData> f19893a;

    /* renamed from: b, reason: collision with root package name */
    public final g f19894b;

    /* renamed from: c, reason: collision with root package name */
    public final a f19895c;

    /* renamed from: d, reason: collision with root package name */
    public final b f19896d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19897e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19898f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f19899g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap<String, String> f19900h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.f<b.a> f19901i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f19902j;

    /* renamed from: k, reason: collision with root package name */
    public final j f19903k;

    /* renamed from: l, reason: collision with root package name */
    public final UUID f19904l;

    /* renamed from: m, reason: collision with root package name */
    public final e f19905m;

    /* renamed from: n, reason: collision with root package name */
    public int f19906n;

    /* renamed from: o, reason: collision with root package name */
    public int f19907o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public HandlerThread f19908p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public c f19909q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public v f19910r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public DrmSession.DrmSessionException f19911s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public byte[] f19912t;

    /* renamed from: u, reason: collision with root package name */
    public byte[] f19913u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public g.a f19914v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public g.d f19915w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(Exception exc, boolean z10);

        void b(DefaultDrmSession defaultDrmSession);

        void c();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i10);

        void b(DefaultDrmSession defaultDrmSession, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        @GuardedBy("this")
        public boolean f19916a;

        public c(Looper looper) {
            super(looper);
        }

        public final boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            IOException unexpectedDrmSessionException;
            d dVar = (d) message.obj;
            if (!dVar.f19919b) {
                return false;
            }
            int i10 = dVar.f19922e + 1;
            dVar.f19922e = i10;
            if (i10 > DefaultDrmSession.this.f19902j.d(3)) {
                return false;
            }
            m mVar = new m(dVar.f19918a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f19920c, mediaDrmCallbackException.bytesLoaded);
            MediaLoadData mediaLoadData = new MediaLoadData(3);
            if (mediaDrmCallbackException.getCause() instanceof IOException) {
                unexpectedDrmSessionException = (IOException) mediaDrmCallbackException.getCause();
            } else {
                unexpectedDrmSessionException = new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause());
            }
            long a10 = DefaultDrmSession.this.f19902j.a(new h.c(mVar, mediaLoadData, unexpectedDrmSessionException, dVar.f19922e));
            if (a10 == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.f19916a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), a10);
                return true;
            }
        }

        public void b(int i10, Object obj, boolean z10) {
            obtainMessage(i10, new d(m.a(), z10, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f19916a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Throwable th;
            d dVar = (d) message.obj;
            try {
                int i10 = message.what;
                if (i10 == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    th = defaultDrmSession.f19903k.b(defaultDrmSession.f19904l, (g.d) dVar.f19921d);
                } else if (i10 == 1) {
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    th = defaultDrmSession2.f19903k.a(defaultDrmSession2.f19904l, (g.a) dVar.f19921d);
                } else {
                    throw new RuntimeException();
                }
            } catch (MediaDrmCallbackException e2) {
                boolean a10 = a(message, e2);
                th = e2;
                if (a10) {
                    return;
                }
            } catch (Exception e10) {
                com.google.android.exoplayer2.util.m.i("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e10);
                th = e10;
            }
            DefaultDrmSession.this.f19902j.c(dVar.f19918a);
            synchronized (this) {
                if (!this.f19916a) {
                    DefaultDrmSession.this.f19905m.obtainMessage(message.what, Pair.create(dVar.f19921d, th)).sendToTarget();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f19918a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f19919b;

        /* renamed from: c, reason: collision with root package name */
        public final long f19920c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f19921d;

        /* renamed from: e, reason: collision with root package name */
        public int f19922e;

        public d(long j10, boolean z10, long j11, Object obj) {
            this.f19918a = j10;
            this.f19919b = z10;
            this.f19920c = j11;
            this.f19921d = obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i10 = message.what;
            if (i10 == 0) {
                DefaultDrmSession.this.z(obj, obj2);
            } else {
                if (i10 != 1) {
                    return;
                }
                DefaultDrmSession.this.t(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, g gVar, a aVar, b bVar, @Nullable List<DrmInitData.SchemeData> list, int i10, boolean z10, boolean z11, @Nullable byte[] bArr, HashMap<String, String> hashMap, j jVar, Looper looper, com.google.android.exoplayer2.upstream.h hVar) {
        if (i10 == 1 || i10 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f19904l = uuid;
        this.f19895c = aVar;
        this.f19896d = bVar;
        this.f19894b = gVar;
        this.f19897e = i10;
        this.f19898f = z10;
        this.f19899g = z11;
        if (bArr != null) {
            this.f19913u = bArr;
            this.f19893a = null;
        } else {
            this.f19893a = Collections.unmodifiableList((List) com.google.android.exoplayer2.util.a.e(list));
        }
        this.f19900h = hashMap;
        this.f19903k = jVar;
        this.f19901i = new com.google.android.exoplayer2.util.f<>();
        this.f19902j = hVar;
        this.f19906n = 2;
        this.f19905m = new e(looper);
    }

    public final boolean A() {
        if (p()) {
            return true;
        }
        try {
            byte[] d10 = this.f19894b.d();
            this.f19912t = d10;
            this.f19910r = this.f19894b.h(d10);
            final int i10 = 3;
            this.f19906n = 3;
            l(new Consumer() { // from class: b5.b
                @Override // com.google.android.exoplayer2.util.Consumer
                public final void accept(Object obj) {
                    ((b.a) obj).k(i10);
                }
            });
            com.google.android.exoplayer2.util.a.e(this.f19912t);
            return true;
        } catch (NotProvisionedException unused) {
            this.f19895c.b(this);
            return false;
        } catch (Exception e2) {
            s(e2, 1);
            return false;
        }
    }

    public final void B(byte[] bArr, int i10, boolean z10) {
        try {
            this.f19914v = this.f19894b.k(bArr, this.f19893a, i10, this.f19900h);
            ((c) j0.j(this.f19909q)).b(1, com.google.android.exoplayer2.util.a.e(this.f19914v), z10);
        } catch (Exception e2) {
            u(e2, true);
        }
    }

    public void C() {
        this.f19915w = this.f19894b.c();
        ((c) j0.j(this.f19909q)).b(0, com.google.android.exoplayer2.util.a.e(this.f19915w), true);
    }

    public final boolean D() {
        try {
            this.f19894b.e(this.f19912t, this.f19913u);
            return true;
        } catch (Exception e2) {
            s(e2, 1);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable b.a aVar) {
        com.google.android.exoplayer2.util.a.g(this.f19907o > 0);
        int i10 = this.f19907o - 1;
        this.f19907o = i10;
        if (i10 == 0) {
            this.f19906n = 0;
            ((e) j0.j(this.f19905m)).removeCallbacksAndMessages(null);
            ((c) j0.j(this.f19909q)).c();
            this.f19909q = null;
            ((HandlerThread) j0.j(this.f19908p)).quit();
            this.f19908p = null;
            this.f19910r = null;
            this.f19911s = null;
            this.f19914v = null;
            this.f19915w = null;
            byte[] bArr = this.f19912t;
            if (bArr != null) {
                this.f19894b.j(bArr);
                this.f19912t = null;
            }
        }
        if (aVar != null) {
            this.f19901i.c(aVar);
            if (this.f19901i.count(aVar) == 0) {
                aVar.m();
            }
        }
        this.f19896d.a(this, this.f19907o);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean b() {
        return this.f19898f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> c() {
        byte[] bArr = this.f19912t;
        if (bArr == null) {
            return null;
        }
        return this.f19894b.b(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void d(@Nullable b.a aVar) {
        com.google.android.exoplayer2.util.a.g(this.f19907o >= 0);
        if (aVar != null) {
            this.f19901i.b(aVar);
        }
        int i10 = this.f19907o + 1;
        this.f19907o = i10;
        if (i10 == 1) {
            com.google.android.exoplayer2.util.a.g(this.f19906n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f19908p = handlerThread;
            handlerThread.start();
            this.f19909q = new c(this.f19908p.getLooper());
            if (A()) {
                m(true);
            }
        } else if (aVar != null && p() && this.f19901i.count(aVar) == 1) {
            aVar.k(this.f19906n);
        }
        this.f19896d.b(this, this.f19907o);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID e() {
        return this.f19904l;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final v f() {
        return this.f19910r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException getError() {
        if (this.f19906n == 1) {
            return this.f19911s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.f19906n;
    }

    public final void l(Consumer<b.a> consumer) {
        Iterator<b.a> iterator2 = this.f19901i.elementSet().iterator2();
        while (iterator2.hasNext()) {
            consumer.accept(iterator2.next());
        }
    }

    public final void m(boolean z10) {
        if (this.f19899g) {
            return;
        }
        byte[] bArr = (byte[]) j0.j(this.f19912t);
        int i10 = this.f19897e;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2) {
                if (this.f19913u == null || D()) {
                    B(bArr, 2, z10);
                    return;
                }
                return;
            }
            if (i10 != 3) {
                return;
            }
            com.google.android.exoplayer2.util.a.e(this.f19913u);
            com.google.android.exoplayer2.util.a.e(this.f19912t);
            B(this.f19913u, 3, z10);
            return;
        }
        if (this.f19913u == null) {
            B(bArr, 1, z10);
            return;
        }
        if (this.f19906n == 4 || D()) {
            long n10 = n();
            if (this.f19897e != 0 || n10 > 60) {
                if (n10 <= 0) {
                    s(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.f19906n = 4;
                    l(new Consumer() { // from class: b5.f
                        @Override // com.google.android.exoplayer2.util.Consumer
                        public final void accept(Object obj) {
                            ((b.a) obj).j();
                        }
                    });
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder(88);
            sb2.append("Offline license has expired or will expire soon. Remaining seconds: ");
            sb2.append(n10);
            com.google.android.exoplayer2.util.m.b("DefaultDrmSession", sb2.toString());
            B(bArr, 2, z10);
        }
    }

    public final long n() {
        if (!com.google.android.exoplayer2.h.f20707d.equals(this.f19904l)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) com.google.android.exoplayer2.util.a.e(a0.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    public boolean o(byte[] bArr) {
        return Arrays.equals(this.f19912t, bArr);
    }

    public final boolean p() {
        int i10 = this.f19906n;
        return i10 == 3 || i10 == 4;
    }

    public final void s(final Exception exc, int i10) {
        this.f19911s = new DrmSession.DrmSessionException(exc, com.google.android.exoplayer2.drm.d.a(exc, i10));
        com.google.android.exoplayer2.util.m.d("DefaultDrmSession", "DRM session error", exc);
        l(new Consumer() { // from class: b5.c
            @Override // com.google.android.exoplayer2.util.Consumer
            public final void accept(Object obj) {
                ((b.a) obj).l(Exception.this);
            }
        });
        if (this.f19906n != 4) {
            this.f19906n = 1;
        }
    }

    public final void t(Object obj, Object obj2) {
        if (obj == this.f19914v && p()) {
            this.f19914v = null;
            if (obj2 instanceof Exception) {
                u((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f19897e == 3) {
                    this.f19894b.g((byte[]) j0.j(this.f19913u), bArr);
                    l(new Consumer() { // from class: b5.e
                        @Override // com.google.android.exoplayer2.util.Consumer
                        public final void accept(Object obj3) {
                            ((b.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] g3 = this.f19894b.g(this.f19912t, bArr);
                int i10 = this.f19897e;
                if ((i10 == 2 || (i10 == 0 && this.f19913u != null)) && g3 != null && g3.length != 0) {
                    this.f19913u = g3;
                }
                this.f19906n = 4;
                l(new Consumer() { // from class: b5.d
                    @Override // com.google.android.exoplayer2.util.Consumer
                    public final void accept(Object obj3) {
                        ((b.a) obj3).h();
                    }
                });
            } catch (Exception e2) {
                u(e2, true);
            }
        }
    }

    public final void u(Exception exc, boolean z10) {
        if (exc instanceof NotProvisionedException) {
            this.f19895c.b(this);
        } else {
            s(exc, z10 ? 1 : 2);
        }
    }

    public final void v() {
        if (this.f19897e == 0 && this.f19906n == 4) {
            j0.j(this.f19912t);
            m(false);
        }
    }

    public void w(int i10) {
        if (i10 != 2) {
            return;
        }
        v();
    }

    public void x() {
        if (A()) {
            m(true);
        }
    }

    public void y(Exception exc, boolean z10) {
        s(exc, z10 ? 1 : 3);
    }

    public final void z(Object obj, Object obj2) {
        if (obj == this.f19915w) {
            if (this.f19906n == 2 || p()) {
                this.f19915w = null;
                if (obj2 instanceof Exception) {
                    this.f19895c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f19894b.i((byte[]) obj2);
                    this.f19895c.c();
                } catch (Exception e2) {
                    this.f19895c.a(e2, true);
                }
            }
        }
    }
}
