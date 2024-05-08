package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class g implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    @RecentlyNonNull
    public static final Status f23428o = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: p, reason: collision with root package name */
    public static final Status f23429p = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: q, reason: collision with root package name */
    public static final Object f23430q = new Object();

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public static g f23431r;

    /* renamed from: e, reason: collision with root package name */
    public final Context f23435e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.common.a f23436f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.common.internal.o f23437g;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f23443m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f23444n;

    /* renamed from: b, reason: collision with root package name */
    public long f23432b = 5000;

    /* renamed from: c, reason: collision with root package name */
    public long f23433c = 120000;

    /* renamed from: d, reason: collision with root package name */
    public long f23434d = 10000;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f23438h = new AtomicInteger(1);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f23439i = new AtomicInteger(0);

    /* renamed from: j, reason: collision with root package name */
    public final Map<com.google.android.gms.common.api.internal.b<?>, a<?>> f23440j = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: k, reason: collision with root package name */
    public final Set<com.google.android.gms.common.api.internal.b<?>> f23441k = new ArraySet();

    /* renamed from: l, reason: collision with root package name */
    public final Set<com.google.android.gms.common.api.internal.b<?>> f23442l = new ArraySet();

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a<O extends a.d> implements GoogleApiClient.a, GoogleApiClient.b {

        /* renamed from: c, reason: collision with root package name */
        public final a.f f23446c;

        /* renamed from: d, reason: collision with root package name */
        public final com.google.android.gms.common.api.internal.b<O> f23447d;

        /* renamed from: e, reason: collision with root package name */
        public final s0 f23448e;

        /* renamed from: h, reason: collision with root package name */
        public final int f23451h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public final zacb f23452i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f23453j;

        /* renamed from: b, reason: collision with root package name */
        public final Queue<e0> f23445b = new LinkedList();

        /* renamed from: f, reason: collision with root package name */
        public final Set<o0> f23449f = new HashSet();

        /* renamed from: g, reason: collision with root package name */
        public final Map<j<?>, c0> f23450g = new HashMap();

        /* renamed from: k, reason: collision with root package name */
        public final List<b> f23454k = new ArrayList();

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        public ConnectionResult f23455l = null;

        @WorkerThread
        public a(com.google.android.gms.common.api.b<O> bVar) {
            a.f h10 = bVar.h(g.this.f23443m.getLooper(), this);
            this.f23446c = h10;
            this.f23447d = bVar.b();
            this.f23448e = new s0();
            this.f23451h = bVar.g();
            if (h10.c()) {
                this.f23452i = bVar.j(g.this.f23435e, g.this.f23443m);
            } else {
                this.f23452i = null;
            }
        }

        public final Status A(ConnectionResult connectionResult) {
            return g.i(this.f23447d, connectionResult);
        }

        @WorkerThread
        public final void B() {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            this.f23455l = null;
        }

        @Nullable
        @WorkerThread
        public final ConnectionResult C() {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            return this.f23455l;
        }

        @WorkerThread
        public final void D() {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            if (this.f23453j) {
                G();
            }
        }

        @WorkerThread
        public final void E() {
            Status status;
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            if (this.f23453j) {
                M();
                if (g.this.f23436f.g(g.this.f23435e) == 18) {
                    status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
                } else {
                    status = new Status(22, "API failed to connect while resuming due to an unknown error.");
                }
                g(status);
                this.f23446c.a("Timing out connection while resuming.");
            }
        }

        @WorkerThread
        public final boolean F() {
            return p(true);
        }

        @WorkerThread
        public final void G() {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            if (this.f23446c.isConnected() || this.f23446c.isConnecting()) {
                return;
            }
            try {
                int a10 = g.this.f23437g.a(g.this.f23435e, this.f23446c);
                if (a10 != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(a10, null);
                    String name = this.f23446c.getClass().getName();
                    String valueOf = String.valueOf(connectionResult);
                    StringBuilder sb2 = new StringBuilder(name.length() + 35 + valueOf.length());
                    sb2.append("The service for ");
                    sb2.append(name);
                    sb2.append(" is not available: ");
                    sb2.append(valueOf);
                    onConnectionFailed(connectionResult);
                    return;
                }
                c cVar = new c(this.f23446c, this.f23447d);
                if (this.f23446c.c()) {
                    ((zacb) com.google.android.gms.common.internal.h.h(this.f23452i)).zaa(cVar);
                }
                try {
                    this.f23446c.b(cVar);
                } catch (SecurityException e2) {
                    f(new ConnectionResult(10), e2);
                }
            } catch (IllegalStateException e10) {
                f(new ConnectionResult(10), e10);
            }
        }

        public final boolean H() {
            return this.f23446c.isConnected();
        }

        public final boolean I() {
            return this.f23446c.c();
        }

        public final int J() {
            return this.f23451h;
        }

        @WorkerThread
        public final void K() {
            B();
            y(ConnectionResult.RESULT_SUCCESS);
            M();
            Iterator<c0> iterator2 = this.f23450g.values().iterator2();
            if (!iterator2.hasNext()) {
                L();
                N();
            } else {
                Objects.requireNonNull(iterator2.next());
                throw null;
            }
        }

        @WorkerThread
        public final void L() {
            ArrayList arrayList = new ArrayList(this.f23445b);
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                e0 e0Var = (e0) obj;
                if (!this.f23446c.isConnected()) {
                    return;
                }
                if (v(e0Var)) {
                    this.f23445b.remove(e0Var);
                }
            }
        }

        @WorkerThread
        public final void M() {
            if (this.f23453j) {
                g.this.f23443m.removeMessages(11, this.f23447d);
                g.this.f23443m.removeMessages(9, this.f23447d);
                this.f23453j = false;
            }
        }

        public final void N() {
            g.this.f23443m.removeMessages(12, this.f23447d);
            g.this.f23443m.sendMessageDelayed(g.this.f23443m.obtainMessage(12, this.f23447d), g.this.f23434d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        @WorkerThread
        public final Feature a(@Nullable Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] l10 = this.f23446c.l();
                if (l10 == null) {
                    l10 = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(l10.length);
                for (Feature feature : l10) {
                    arrayMap.put(feature.f(), Long.valueOf(feature.g()));
                }
                for (Feature feature2 : featureArr) {
                    Long l11 = (Long) arrayMap.get(feature2.f());
                    if (l11 == null || l11.longValue() < feature2.g()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        @WorkerThread
        public final void c() {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            g(g.f23428o);
            this.f23448e.f();
            for (j jVar : (j[]) this.f23450g.h().toArray(new j[0])) {
                m(new n0(jVar, new p7.g()));
            }
            y(new ConnectionResult(4));
            if (this.f23446c.isConnected()) {
                this.f23446c.k(new x(this));
            }
        }

        @WorkerThread
        public final void d(int i10) {
            B();
            this.f23453j = true;
            this.f23448e.b(i10, this.f23446c.m());
            g.this.f23443m.sendMessageDelayed(Message.obtain(g.this.f23443m, 9, this.f23447d), g.this.f23432b);
            g.this.f23443m.sendMessageDelayed(Message.obtain(g.this.f23443m, 11, this.f23447d), g.this.f23433c);
            g.this.f23437g.b();
            Iterator<c0> iterator2 = this.f23450g.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().f23422a.run();
            }
        }

        @WorkerThread
        public final void e(@NonNull ConnectionResult connectionResult) {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            a.f fVar = this.f23446c;
            String name = fVar.getClass().getName();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb2 = new StringBuilder(name.length() + 25 + valueOf.length());
            sb2.append("onSignInFailed for ");
            sb2.append(name);
            sb2.append(" with ");
            sb2.append(valueOf);
            fVar.a(sb2.toString());
            onConnectionFailed(connectionResult);
        }

        @WorkerThread
        public final void f(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            zacb zacbVar = this.f23452i;
            if (zacbVar != null) {
                zacbVar.zaa();
            }
            B();
            g.this.f23437g.b();
            y(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                g(g.f23429p);
                return;
            }
            if (this.f23445b.isEmpty()) {
                this.f23455l = connectionResult;
                return;
            }
            if (exc != null) {
                com.google.android.gms.common.internal.h.d(g.this.f23443m);
                h(null, exc, false);
                return;
            }
            if (!g.this.f23444n) {
                g(A(connectionResult));
                return;
            }
            h(A(connectionResult), null, true);
            if (this.f23445b.isEmpty() || u(connectionResult) || g.this.f(connectionResult, this.f23451h)) {
                return;
            }
            if (connectionResult.getErrorCode() == 18) {
                this.f23453j = true;
            }
            if (this.f23453j) {
                g.this.f23443m.sendMessageDelayed(Message.obtain(g.this.f23443m, 9, this.f23447d), g.this.f23432b);
            } else {
                g(A(connectionResult));
            }
        }

        @WorkerThread
        public final void g(Status status) {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            h(status, null, false);
        }

        @WorkerThread
        public final void h(@Nullable Status status, @Nullable Exception exc, boolean z10) {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            if ((status == null) != (exc == null)) {
                Iterator<e0> it = this.f23445b.iterator2();
                while (it.hasNext()) {
                    e0 next = it.next();
                    if (!z10 || next.f23426a == 2) {
                        if (status != null) {
                            next.b(status);
                        } else {
                            next.d(exc);
                        }
                        it.remove();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Status XOR exception should be null");
        }

        @WorkerThread
        public final void l(b bVar) {
            if (this.f23454k.contains(bVar) && !this.f23453j) {
                if (!this.f23446c.isConnected()) {
                    G();
                } else {
                    L();
                }
            }
        }

        @WorkerThread
        public final void m(e0 e0Var) {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            if (this.f23446c.isConnected()) {
                if (v(e0Var)) {
                    N();
                    return;
                } else {
                    this.f23445b.add(e0Var);
                    return;
                }
            }
            this.f23445b.add(e0Var);
            ConnectionResult connectionResult = this.f23455l;
            if (connectionResult != null && connectionResult.hasResolution()) {
                onConnectionFailed(this.f23455l);
            } else {
                G();
            }
        }

        @WorkerThread
        public final void n(o0 o0Var) {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            this.f23449f.add(o0Var);
        }

        @Override // com.google.android.gms.common.api.internal.f
        public final void onConnected(@Nullable Bundle bundle) {
            if (Looper.myLooper() == g.this.f23443m.getLooper()) {
                K();
            } else {
                g.this.f23443m.post(new w(this));
            }
        }

        @Override // com.google.android.gms.common.api.internal.k
        @WorkerThread
        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            f(connectionResult, null);
        }

        @Override // com.google.android.gms.common.api.internal.f
        public final void onConnectionSuspended(int i10) {
            if (Looper.myLooper() == g.this.f23443m.getLooper()) {
                d(i10);
            } else {
                g.this.f23443m.post(new v(this, i10));
            }
        }

        @WorkerThread
        public final boolean p(boolean z10) {
            com.google.android.gms.common.internal.h.d(g.this.f23443m);
            if (!this.f23446c.isConnected() || this.f23450g.size() != 0) {
                return false;
            }
            if (!this.f23448e.e()) {
                this.f23446c.a("Timing out service connection.");
                return true;
            }
            if (z10) {
                N();
            }
            return false;
        }

        public final a.f q() {
            return this.f23446c;
        }

        @WorkerThread
        public final void t(b bVar) {
            Feature[] g3;
            if (this.f23454k.remove(bVar)) {
                g.this.f23443m.removeMessages(15, bVar);
                g.this.f23443m.removeMessages(16, bVar);
                Feature feature = bVar.f23458b;
                ArrayList arrayList = new ArrayList(this.f23445b.size());
                for (e0 e0Var : this.f23445b) {
                    if ((e0Var instanceof s) && (g3 = ((s) e0Var).g(this)) != null && b7.a.a(g3, feature)) {
                        arrayList.add(e0Var);
                    }
                }
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    e0 e0Var2 = (e0) obj;
                    this.f23445b.remove(e0Var2);
                    e0Var2.d(new UnsupportedApiCallException(feature));
                }
            }
        }

        @WorkerThread
        public final boolean u(@NonNull ConnectionResult connectionResult) {
            synchronized (g.f23430q) {
                g.r(g.this);
            }
            return false;
        }

        @WorkerThread
        public final boolean v(e0 e0Var) {
            if (!(e0Var instanceof s)) {
                z(e0Var);
                return true;
            }
            s sVar = (s) e0Var;
            Feature a10 = a(sVar.g(this));
            if (a10 == null) {
                z(e0Var);
                return true;
            }
            String name = this.f23446c.getClass().getName();
            String f10 = a10.f();
            long g3 = a10.g();
            StringBuilder sb2 = new StringBuilder(name.length() + 77 + String.valueOf(f10).length());
            sb2.append(name);
            sb2.append(" could not execute call because it requires feature (");
            sb2.append(f10);
            sb2.append(", ");
            sb2.append(g3);
            sb2.append(").");
            if (g.this.f23444n && sVar.h(this)) {
                b bVar = new b(this.f23447d, a10, null);
                int indexOf = this.f23454k.indexOf(bVar);
                if (indexOf >= 0) {
                    b bVar2 = this.f23454k.get(indexOf);
                    g.this.f23443m.removeMessages(15, bVar2);
                    g.this.f23443m.sendMessageDelayed(Message.obtain(g.this.f23443m, 15, bVar2), g.this.f23432b);
                    return false;
                }
                this.f23454k.add(bVar);
                g.this.f23443m.sendMessageDelayed(Message.obtain(g.this.f23443m, 15, bVar), g.this.f23432b);
                g.this.f23443m.sendMessageDelayed(Message.obtain(g.this.f23443m, 16, bVar), g.this.f23433c);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (u(connectionResult)) {
                    return false;
                }
                g.this.f(connectionResult, this.f23451h);
                return false;
            }
            sVar.d(new UnsupportedApiCallException(a10));
            return true;
        }

        public final Map<j<?>, c0> x() {
            return this.f23450g;
        }

        @WorkerThread
        public final void y(ConnectionResult connectionResult) {
            for (o0 o0Var : this.f23449f) {
                String str = null;
                if (com.google.android.gms.common.internal.g.a(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.f23446c.h();
                }
                o0Var.b(this.f23447d, connectionResult, str);
            }
            this.f23449f.clear();
        }

        @WorkerThread
        public final void z(e0 e0Var) {
            e0Var.c(this.f23448e, I());
            try {
                e0Var.f(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f23446c.a("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.f23446c.getClass().getName()), th);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class c implements i0, BaseGmsClient.c {

        /* renamed from: a, reason: collision with root package name */
        public final a.f f23459a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.android.gms.common.api.internal.b<?> f23460b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public IAccountAccessor f23461c = null;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public Set<Scope> f23462d = null;

        /* renamed from: e, reason: collision with root package name */
        public boolean f23463e = false;

        public c(a.f fVar, com.google.android.gms.common.api.internal.b<?> bVar) {
            this.f23459a = fVar;
            this.f23460b = bVar;
        }

        public static /* synthetic */ boolean f(c cVar, boolean z10) {
            cVar.f23463e = true;
            return true;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.c
        public final void a(@NonNull ConnectionResult connectionResult) {
            g.this.f23443m.post(new z(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.i0
        @WorkerThread
        public final void b(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set) {
            if (iAccountAccessor != null && set != null) {
                this.f23461c = iAccountAccessor;
                this.f23462d = set;
                e();
            } else {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                c(new ConnectionResult(4));
            }
        }

        @Override // com.google.android.gms.common.api.internal.i0
        @WorkerThread
        public final void c(ConnectionResult connectionResult) {
            a aVar = (a) g.this.f23440j.get(this.f23460b);
            if (aVar != null) {
                aVar.e(connectionResult);
            }
        }

        @WorkerThread
        public final void e() {
            IAccountAccessor iAccountAccessor;
            if (!this.f23463e || (iAccountAccessor = this.f23461c) == null) {
                return;
            }
            this.f23459a.f(iAccountAccessor, this.f23462d);
        }
    }

    public g(Context context, Looper looper, com.google.android.gms.common.a aVar) {
        this.f23444n = true;
        this.f23435e = context;
        h7.g gVar = new h7.g(looper, this);
        this.f23443m = gVar;
        this.f23436f = aVar;
        this.f23437g = new com.google.android.gms.common.internal.o(aVar);
        if (b7.g.a(context)) {
            this.f23444n = false;
        }
        gVar.sendMessage(gVar.obtainMessage(6));
    }

    @RecentlyNonNull
    public static g c(@RecentlyNonNull Context context) {
        g gVar;
        synchronized (f23430q) {
            if (f23431r == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f23431r = new g(context.getApplicationContext(), handlerThread.getLooper(), com.google.android.gms.common.a.m());
            }
            gVar = f23431r;
        }
        return gVar;
    }

    public static Status i(com.google.android.gms.common.api.internal.b<?> bVar, ConnectionResult connectionResult) {
        String a10 = bVar.a();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 63 + valueOf.length());
        sb2.append("API: ");
        sb2.append(a10);
        sb2.append(" is not available on this device. Connection failed with: ");
        sb2.append(valueOf);
        return new Status(connectionResult, sb2.toString());
    }

    public static /* synthetic */ t0 r(g gVar) {
        Objects.requireNonNull(gVar);
        return null;
    }

    public final void d(@RecentlyNonNull com.google.android.gms.common.api.b<?> bVar) {
        Handler handler = this.f23443m;
        handler.sendMessage(handler.obtainMessage(7, bVar));
    }

    public final <O extends a.d> void e(@RecentlyNonNull com.google.android.gms.common.api.b<O> bVar, @RecentlyNonNull int i10, @RecentlyNonNull d<? extends Result, a.b> dVar) {
        l0 l0Var = new l0(i10, dVar);
        Handler handler = this.f23443m;
        handler.sendMessage(handler.obtainMessage(4, new b0(l0Var, this.f23439i.get(), bVar)));
    }

    public final boolean f(ConnectionResult connectionResult, int i10) {
        return this.f23436f.u(this.f23435e, connectionResult, i10);
    }

    @RecentlyNonNull
    public final int g() {
        return this.f23438h.getAndIncrement();
    }

    @Override // android.os.Handler.Callback
    @RecentlyNonNull
    @WorkerThread
    public boolean handleMessage(@RecentlyNonNull Message message) {
        int i10 = message.what;
        long j10 = com.huawei.openalliance.ad.constant.u.as;
        a<?> aVar = null;
        switch (i10) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j10 = 10000;
                }
                this.f23434d = j10;
                this.f23443m.removeMessages(12);
                for (com.google.android.gms.common.api.internal.b<?> bVar : this.f23440j.h()) {
                    Handler handler = this.f23443m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.f23434d);
                }
                return true;
            case 2:
                o0 o0Var = (o0) message.obj;
                Iterator<com.google.android.gms.common.api.internal.b<?>> iterator2 = o0Var.a().iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        com.google.android.gms.common.api.internal.b<?> next = iterator2.next();
                        a<?> aVar2 = this.f23440j.get(next);
                        if (aVar2 == null) {
                            o0Var.b(next, new ConnectionResult(13), null);
                        } else if (aVar2.H()) {
                            o0Var.b(next, ConnectionResult.RESULT_SUCCESS, aVar2.q().h());
                        } else {
                            ConnectionResult C = aVar2.C();
                            if (C != null) {
                                o0Var.b(next, C, null);
                            } else {
                                aVar2.n(o0Var);
                                aVar2.G();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (a<?> aVar3 : this.f23440j.values()) {
                    aVar3.B();
                    aVar3.G();
                }
                return true;
            case 4:
            case 8:
            case 13:
                b0 b0Var = (b0) message.obj;
                a<?> aVar4 = this.f23440j.get(b0Var.f23416c.b());
                if (aVar4 == null) {
                    aVar4 = l(b0Var.f23416c);
                }
                if (aVar4.I() && this.f23439i.get() != b0Var.f23415b) {
                    b0Var.f23414a.b(f23428o);
                    aVar4.c();
                } else {
                    aVar4.m(b0Var.f23414a);
                }
                return true;
            case 5:
                int i11 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> iterator22 = this.f23440j.values().iterator2();
                while (true) {
                    if (iterator22.hasNext()) {
                        a<?> next2 = iterator22.next();
                        if (next2.J() == i11) {
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    if (connectionResult.getErrorCode() == 13) {
                        String e2 = this.f23436f.e(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(e2).length() + 69 + String.valueOf(errorMessage).length());
                        sb2.append("Error resolution was canceled by the user, original error message: ");
                        sb2.append(e2);
                        sb2.append(": ");
                        sb2.append(errorMessage);
                        aVar.g(new Status(17, sb2.toString()));
                    } else {
                        aVar.g(i(aVar.f23447d, connectionResult));
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder(76);
                    sb3.append("Could not find API instance ");
                    sb3.append(i11);
                    sb3.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb3.toString(), new Exception());
                }
                return true;
            case 6:
                if (this.f23435e.getApplicationContext() instanceof Application) {
                    com.google.android.gms.common.api.internal.c.c((Application) this.f23435e.getApplicationContext());
                    com.google.android.gms.common.api.internal.c.b().a(new u(this));
                    if (!com.google.android.gms.common.api.internal.c.b().e(true)) {
                        this.f23434d = com.huawei.openalliance.ad.constant.u.as;
                    }
                }
                return true;
            case 7:
                l((com.google.android.gms.common.api.b) message.obj);
                return true;
            case 9:
                if (this.f23440j.containsKey(message.obj)) {
                    this.f23440j.get(message.obj).D();
                }
                return true;
            case 10:
                Iterator<com.google.android.gms.common.api.internal.b<?>> iterator23 = this.f23442l.iterator2();
                while (iterator23.hasNext()) {
                    a<?> remove = this.f23440j.remove(iterator23.next());
                    if (remove != null) {
                        remove.c();
                    }
                }
                this.f23442l.clear();
                return true;
            case 11:
                if (this.f23440j.containsKey(message.obj)) {
                    this.f23440j.get(message.obj).E();
                }
                return true;
            case 12:
                if (this.f23440j.containsKey(message.obj)) {
                    this.f23440j.get(message.obj).F();
                }
                return true;
            case 14:
                n nVar = (n) message.obj;
                com.google.android.gms.common.api.internal.b<?> a10 = nVar.a();
                if (!this.f23440j.containsKey(a10)) {
                    nVar.b().c(Boolean.FALSE);
                } else {
                    nVar.b().c(Boolean.valueOf(this.f23440j.get(a10).p(false)));
                }
                return true;
            case 15:
                b bVar2 = (b) message.obj;
                if (this.f23440j.containsKey(bVar2.f23457a)) {
                    this.f23440j.get(bVar2.f23457a).l(bVar2);
                }
                return true;
            case 16:
                b bVar3 = (b) message.obj;
                if (this.f23440j.containsKey(bVar3.f23457a)) {
                    this.f23440j.get(bVar3.f23457a).t(bVar3);
                }
                return true;
            default:
                StringBuilder sb4 = new StringBuilder(31);
                sb4.append("Unknown message id: ");
                sb4.append(i10);
                return false;
        }
    }

    public final void j(@RecentlyNonNull ConnectionResult connectionResult, @RecentlyNonNull int i10) {
        if (f(connectionResult, i10)) {
            return;
        }
        Handler handler = this.f23443m;
        handler.sendMessage(handler.obtainMessage(5, i10, 0, connectionResult));
    }

    @WorkerThread
    public final a<?> l(com.google.android.gms.common.api.b<?> bVar) {
        com.google.android.gms.common.api.internal.b<?> b4 = bVar.b();
        a<?> aVar = this.f23440j.get(b4);
        if (aVar == null) {
            aVar = new a<>(bVar);
            this.f23440j.put(b4, aVar);
        }
        if (aVar.I()) {
            this.f23442l.add(b4);
        }
        aVar.G();
        return aVar;
    }

    public final void m() {
        Handler handler = this.f23443m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.gms.common.api.internal.b<?> f23457a;

        /* renamed from: b, reason: collision with root package name */
        public final Feature f23458b;

        public b(com.google.android.gms.common.api.internal.b<?> bVar, Feature feature) {
            this.f23457a = bVar;
            this.f23458b = feature;
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (com.google.android.gms.common.internal.g.a(this.f23457a, bVar.f23457a) && com.google.android.gms.common.internal.g.a(this.f23458b, bVar.f23458b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return com.google.android.gms.common.internal.g.b(this.f23457a, this.f23458b);
        }

        public final String toString() {
            return com.google.android.gms.common.internal.g.c(this).a("key", this.f23457a).a("feature", this.f23458b).toString();
        }

        public /* synthetic */ b(com.google.android.gms.common.api.internal.b bVar, Feature feature, u uVar) {
            this(bVar, feature);
        }
    }
}
