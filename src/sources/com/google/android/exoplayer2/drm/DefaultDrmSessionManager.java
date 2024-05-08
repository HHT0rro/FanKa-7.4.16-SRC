package com.google.android.exoplayer2.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b5.v;
import b5.w;
import b5.z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.q;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.i1;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequiresApi(18)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DefaultDrmSessionManager implements com.google.android.exoplayer2.drm.c {

    /* renamed from: c, reason: collision with root package name */
    public final UUID f19924c;

    /* renamed from: d, reason: collision with root package name */
    public final g.c f19925d;

    /* renamed from: e, reason: collision with root package name */
    public final j f19926e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap<String, String> f19927f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f19928g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f19929h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f19930i;

    /* renamed from: j, reason: collision with root package name */
    public final f f19931j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f19932k;

    /* renamed from: l, reason: collision with root package name */
    public final g f19933l;

    /* renamed from: m, reason: collision with root package name */
    public final long f19934m;

    /* renamed from: n, reason: collision with root package name */
    public final List<DefaultDrmSession> f19935n;

    /* renamed from: o, reason: collision with root package name */
    public final Set<e> f19936o;

    /* renamed from: p, reason: collision with root package name */
    public final Set<DefaultDrmSession> f19937p;

    /* renamed from: q, reason: collision with root package name */
    public int f19938q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.drm.g f19939r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f19940s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f19941t;

    /* renamed from: u, reason: collision with root package name */
    public Looper f19942u;

    /* renamed from: v, reason: collision with root package name */
    public Handler f19943v;

    /* renamed from: w, reason: collision with root package name */
    public int f19944w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public byte[] f19945x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public volatile d f19946y;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private MissingSchemeDataException(java.util.UUID r3) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                int r0 = r0 + 29
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Media does not support uuid: "
                r1.append(r0)
                r1.append(r3)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MissingSchemeDataException.<init>(java.util.UUID):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        public boolean f19950d;

        /* renamed from: f, reason: collision with root package name */
        public boolean f19952f;

        /* renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f19947a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        public UUID f19948b = com.google.android.exoplayer2.h.f20707d;

        /* renamed from: c, reason: collision with root package name */
        public g.c f19949c = h.f19983d;

        /* renamed from: g, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.h f19953g = new com.google.android.exoplayer2.upstream.f();

        /* renamed from: e, reason: collision with root package name */
        public int[] f19951e = new int[0];

        /* renamed from: h, reason: collision with root package name */
        public long f19954h = u.as;

        public DefaultDrmSessionManager a(j jVar) {
            return new DefaultDrmSessionManager(this.f19948b, this.f19949c, jVar, this.f19947a, this.f19950d, this.f19951e, this.f19952f, this.f19953g, this.f19954h);
        }

        public b b(boolean z10) {
            this.f19950d = z10;
            return this;
        }

        public b c(boolean z10) {
            this.f19952f = z10;
            return this;
        }

        public b d(int... iArr) {
            for (int i10 : iArr) {
                boolean z10 = true;
                if (i10 != 2 && i10 != 1) {
                    z10 = false;
                }
                com.google.android.exoplayer2.util.a.a(z10);
            }
            this.f19951e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, g.c cVar) {
            this.f19948b = (UUID) com.google.android.exoplayer2.util.a.e(uuid);
            this.f19949c = (g.c) com.google.android.exoplayer2.util.a.e(cVar);
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c implements g.b {
        public c() {
        }

        @Override // com.google.android.exoplayer2.drm.g.b
        public void a(com.google.android.exoplayer2.drm.g gVar, @Nullable byte[] bArr, int i10, int i11, @Nullable byte[] bArr2) {
            ((d) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f19946y)).obtainMessage(i10, bArr).sendToTarget();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f19935n) {
                if (defaultDrmSession.o(bArr)) {
                    defaultDrmSession.w(message.what);
                    return;
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class e implements c.b {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final b.a f19957b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public DrmSession f19958c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f19959d;

        public e(@Nullable b.a aVar) {
            this.f19957b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Format format) {
            if (DefaultDrmSessionManager.this.f19938q == 0 || this.f19959d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.f19958c = defaultDrmSessionManager.r((Looper) com.google.android.exoplayer2.util.a.e(defaultDrmSessionManager.f19942u), this.f19957b, format, false);
            DefaultDrmSessionManager.this.f19936o.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (this.f19959d) {
                return;
            }
            DrmSession drmSession = this.f19958c;
            if (drmSession != null) {
                drmSession.a(this.f19957b);
            }
            DefaultDrmSessionManager.this.f19936o.remove(this);
            this.f19959d = true;
        }

        public void c(final Format format) {
            ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f19943v)).post(new Runnable() { // from class: b5.h
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.d(format);
                }
            });
        }

        @Override // com.google.android.exoplayer2.drm.c.b
        public void release() {
            j0.E0((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f19943v), new Runnable() { // from class: b5.g
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.e();
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class f implements DefaultDrmSession.a {

        /* renamed from: a, reason: collision with root package name */
        public final Set<DefaultDrmSession> f19961a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public DefaultDrmSession f19962b;

        public f(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void a(Exception exc, boolean z10) {
            this.f19962b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f19961a);
            this.f19961a.clear();
            i1 iterator2 = copyOf.iterator2();
            while (iterator2.hasNext()) {
                ((DefaultDrmSession) iterator2.next()).y(exc, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void b(DefaultDrmSession defaultDrmSession) {
            this.f19961a.add(defaultDrmSession);
            if (this.f19962b != null) {
                return;
            }
            this.f19962b = defaultDrmSession;
            defaultDrmSession.C();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void c() {
            this.f19962b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f19961a);
            this.f19961a.clear();
            i1 iterator2 = copyOf.iterator2();
            while (iterator2.hasNext()) {
                ((DefaultDrmSession) iterator2.next()).x();
            }
        }

        public void d(DefaultDrmSession defaultDrmSession) {
            this.f19961a.remove(defaultDrmSession);
            if (this.f19962b == defaultDrmSession) {
                this.f19962b = null;
                if (this.f19961a.isEmpty()) {
                    return;
                }
                DefaultDrmSession next = this.f19961a.iterator2().next();
                this.f19962b = next;
                next.C();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class g implements DefaultDrmSession.b {
        public g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void a(final DefaultDrmSession defaultDrmSession, int i10) {
            if (i10 == 1 && DefaultDrmSessionManager.this.f19938q > 0 && DefaultDrmSessionManager.this.f19934m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f19937p.add(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f19943v)).postAtTime(new Runnable() { // from class: b5.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultDrmSession.this.a(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f19934m);
            } else if (i10 == 0) {
                DefaultDrmSessionManager.this.f19935n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f19940s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f19940s = null;
                }
                if (DefaultDrmSessionManager.this.f19941t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f19941t = null;
                }
                DefaultDrmSessionManager.this.f19931j.d(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f19934m != -9223372036854775807L) {
                    ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f19943v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f19937p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.A();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void b(DefaultDrmSession defaultDrmSession, int i10) {
            if (DefaultDrmSessionManager.this.f19934m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f19937p.remove(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f19943v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }
    }

    public static boolean s(DrmSession drmSession) {
        return drmSession.getState() == 1 && (j0.f22990a < 19 || (((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(drmSession.getError())).getCause() instanceof ResourceBusyException));
    }

    public static List<DrmInitData.SchemeData> w(DrmInitData drmInitData, UUID uuid, boolean z10) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i10 = 0; i10 < drmInitData.schemeDataCount; i10++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i10);
            if ((schemeData.matches(uuid) || (com.google.android.exoplayer2.h.f20706c.equals(uuid) && schemeData.matches(com.google.android.exoplayer2.h.f20705b))) && (schemeData.data != null || z10)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    public final void A() {
        if (this.f19939r != null && this.f19938q == 0 && this.f19935n.isEmpty() && this.f19936o.isEmpty()) {
            ((com.google.android.exoplayer2.drm.g) com.google.android.exoplayer2.util.a.e(this.f19939r)).release();
            this.f19939r = null;
        }
    }

    public final void B() {
        i1 iterator2 = ImmutableSet.copyOf((Collection) this.f19937p).iterator2();
        while (iterator2.hasNext()) {
            ((DrmSession) iterator2.next()).a(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C() {
        i1 iterator2 = ImmutableSet.copyOf((Collection) this.f19936o).iterator2();
        while (iterator2.hasNext()) {
            ((e) iterator2.next()).release();
        }
    }

    public void D(int i10, @Nullable byte[] bArr) {
        com.google.android.exoplayer2.util.a.g(this.f19935n.isEmpty());
        if (i10 == 1 || i10 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f19944w = i10;
        this.f19945x = bArr;
    }

    public final void E(DrmSession drmSession, @Nullable b.a aVar) {
        drmSession.a(aVar);
        if (this.f19934m != -9223372036854775807L) {
            drmSession.a(null);
        }
    }

    @Override // com.google.android.exoplayer2.drm.c
    @Nullable
    public DrmSession a(Looper looper, @Nullable b.a aVar, Format format) {
        com.google.android.exoplayer2.util.a.g(this.f19938q > 0);
        x(looper);
        return r(looper, aVar, format, true);
    }

    @Override // com.google.android.exoplayer2.drm.c
    public c.b b(Looper looper, @Nullable b.a aVar, Format format) {
        com.google.android.exoplayer2.util.a.g(this.f19938q > 0);
        x(looper);
        e eVar = new e(aVar);
        eVar.c(format);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.drm.c
    @Nullable
    public Class<? extends v> c(Format format) {
        Class<? extends v> a10 = ((com.google.android.exoplayer2.drm.g) com.google.android.exoplayer2.util.a.e(this.f19939r)).a();
        DrmInitData drmInitData = format.f19547p;
        if (drmInitData != null) {
            return t(drmInitData) ? a10 : z.class;
        }
        if (j0.t0(this.f19929h, q.l(format.f19544m)) != -1) {
            return a10;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.c
    public final void prepare() {
        int i10 = this.f19938q;
        this.f19938q = i10 + 1;
        if (i10 != 0) {
            return;
        }
        if (this.f19939r == null) {
            com.google.android.exoplayer2.drm.g a10 = this.f19925d.a(this.f19924c);
            this.f19939r = a10;
            a10.f(new c());
        } else if (this.f19934m != -9223372036854775807L) {
            for (int i11 = 0; i11 < this.f19935n.size(); i11++) {
                this.f19935n.get(i11).d(null);
            }
        }
    }

    @Nullable
    public final DrmSession r(Looper looper, @Nullable b.a aVar, Format format, boolean z10) {
        List<DrmInitData.SchemeData> list;
        z(looper);
        DrmInitData drmInitData = format.f19547p;
        if (drmInitData == null) {
            return y(q.l(format.f19544m), z10);
        }
        DefaultDrmSession defaultDrmSession = null;
        byte b4 = 0;
        if (this.f19945x == null) {
            list = w((DrmInitData) com.google.android.exoplayer2.util.a.e(drmInitData), this.f19924c, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f19924c);
                m.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new com.google.android.exoplayer2.drm.f(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            list = null;
        }
        if (!this.f19928g) {
            defaultDrmSession = this.f19941t;
        } else {
            Iterator<DefaultDrmSession> iterator2 = this.f19935n.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                DefaultDrmSession next = iterator2.next();
                if (j0.c(next.f19893a, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = v(list, false, aVar, z10);
            if (!this.f19928g) {
                this.f19941t = defaultDrmSession;
            }
            this.f19935n.add(defaultDrmSession);
        } else {
            defaultDrmSession.d(aVar);
        }
        return defaultDrmSession;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.drm.c
    public final void release() {
        int i10 = this.f19938q - 1;
        this.f19938q = i10;
        if (i10 != 0) {
            return;
        }
        if (this.f19934m != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f19935n);
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                ((DefaultDrmSession) arrayList.get(i11)).a(null);
            }
        }
        C();
        A();
    }

    public final boolean t(DrmInitData drmInitData) {
        if (this.f19945x != null) {
            return true;
        }
        if (w(drmInitData, this.f19924c, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(com.google.android.exoplayer2.h.f20705b)) {
                return false;
            }
            String valueOf = String.valueOf(this.f19924c);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 72);
            sb2.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
            sb2.append(valueOf);
            m.h("DefaultDrmSessionMgr", sb2.toString());
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? j0.f22990a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    public final DefaultDrmSession u(@Nullable List<DrmInitData.SchemeData> list, boolean z10, @Nullable b.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f19939r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f19924c, this.f19939r, this.f19931j, this.f19933l, list, this.f19944w, this.f19930i | z10, z10, this.f19945x, this.f19927f, this.f19926e, (Looper) com.google.android.exoplayer2.util.a.e(this.f19942u), this.f19932k);
        defaultDrmSession.d(aVar);
        if (this.f19934m != -9223372036854775807L) {
            defaultDrmSession.d(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession v(@Nullable List<DrmInitData.SchemeData> list, boolean z10, @Nullable b.a aVar, boolean z11) {
        DefaultDrmSession u10 = u(list, z10, aVar);
        if (s(u10) && !this.f19937p.isEmpty()) {
            B();
            E(u10, aVar);
            u10 = u(list, z10, aVar);
        }
        if (!s(u10) || !z11 || this.f19936o.isEmpty()) {
            return u10;
        }
        C();
        if (!this.f19937p.isEmpty()) {
            B();
        }
        E(u10, aVar);
        return u(list, z10, aVar);
    }

    public final synchronized void x(Looper looper) {
        Looper looper2 = this.f19942u;
        if (looper2 == null) {
            this.f19942u = looper;
            this.f19943v = new Handler(looper);
        } else {
            com.google.android.exoplayer2.util.a.g(looper2 == looper);
            com.google.android.exoplayer2.util.a.e(this.f19943v);
        }
    }

    @Nullable
    public final DrmSession y(int i10, boolean z10) {
        com.google.android.exoplayer2.drm.g gVar = (com.google.android.exoplayer2.drm.g) com.google.android.exoplayer2.util.a.e(this.f19939r);
        if ((w.class.equals(gVar.a()) && w.f1264d) || j0.t0(this.f19929h, i10) == -1 || z.class.equals(gVar.a())) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f19940s;
        if (defaultDrmSession == null) {
            DefaultDrmSession v2 = v(ImmutableList.of(), true, null, z10);
            this.f19935n.add(v2);
            this.f19940s = v2;
        } else {
            defaultDrmSession.d(null);
        }
        return this.f19940s;
    }

    public final void z(Looper looper) {
        if (this.f19946y == null) {
            this.f19946y = new d(looper);
        }
    }

    public DefaultDrmSessionManager(UUID uuid, g.c cVar, j jVar, HashMap<String, String> hashMap, boolean z10, int[] iArr, boolean z11, com.google.android.exoplayer2.upstream.h hVar, long j10) {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.h.f20705b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f19924c = uuid;
        this.f19925d = cVar;
        this.f19926e = jVar;
        this.f19927f = hashMap;
        this.f19928g = z10;
        this.f19929h = iArr;
        this.f19930i = z11;
        this.f19932k = hVar;
        this.f19931j = new f(this);
        this.f19933l = new g();
        this.f19944w = 0;
        this.f19935n = new ArrayList();
        this.f19936o = Sets.f();
        this.f19937p = Sets.f();
        this.f19934m = j10;
    }
}
