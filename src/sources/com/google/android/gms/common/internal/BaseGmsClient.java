package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.d;
import com.huawei.hms.api.HuaweiApiClientImpl;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BaseGmsClient<T extends IInterface> {
    public static final Feature[] C = new Feature[0];

    @RecentlyNonNull
    public static final String[] D = {"service_esmobile", "service_googleme"};

    /* renamed from: a, reason: collision with root package name */
    public int f23565a;

    /* renamed from: b, reason: collision with root package name */
    public long f23566b;

    /* renamed from: c, reason: collision with root package name */
    public long f23567c;

    /* renamed from: d, reason: collision with root package name */
    public int f23568d;

    /* renamed from: e, reason: collision with root package name */
    public long f23569e;

    /* renamed from: g, reason: collision with root package name */
    public d0 f23571g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f23572h;

    /* renamed from: i, reason: collision with root package name */
    public final Looper f23573i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.gms.common.internal.d f23574j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.gms.common.b f23575k;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f23576l;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public IGmsServiceBroker f23579o;

    /* renamed from: p, reason: collision with root package name */
    @RecentlyNonNull
    public c f23580p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public T f23581q;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public i f23583s;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public final a f23585u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public final b f23586v;

    /* renamed from: w, reason: collision with root package name */
    public final int f23587w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public final String f23588x;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public volatile String f23570f = null;

    /* renamed from: m, reason: collision with root package name */
    public final Object f23577m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public final Object f23578n = new Object();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList<h<?>> f23582r = new ArrayList<>();

    /* renamed from: t, reason: collision with root package name */
    public int f23584t = 1;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public ConnectionResult f23589y = null;

    /* renamed from: z, reason: collision with root package name */
    public boolean f23590z = false;

    @Nullable
    public volatile zzc A = null;

    @RecentlyNonNull
    public AtomicInteger B = new AtomicInteger(0);

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(@RecentlyNonNull int i10);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void onConnectionFailed(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void a(@RecentlyNonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class d implements c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.c
        public void a(@RecentlyNonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.f(null, baseGmsClient.w());
            } else if (BaseGmsClient.this.f23586v != null) {
                BaseGmsClient.this.f23586v.onConnectionFailed(connectionResult);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface e {
        void a();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public abstract class f extends h<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        public final int f23592d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public final Bundle f23593e;

        @BinderThread
        public f(int i10, @Nullable Bundle bundle) {
            super(Boolean.TRUE);
            this.f23592d = i10;
            this.f23593e = bundle;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.h
        public final /* synthetic */ void a(Boolean bool) {
            if (bool == null) {
                BaseGmsClient.this.P(1, null);
                return;
            }
            if (this.f23592d == 0) {
                if (g()) {
                    return;
                }
                BaseGmsClient.this.P(1, null);
                f(new ConnectionResult(8, null));
                return;
            }
            BaseGmsClient.this.P(1, null);
            Bundle bundle = this.f23593e;
            f(new ConnectionResult(this.f23592d, bundle != null ? (PendingIntent) bundle.getParcelable(com.huawei.openalliance.ad.download.app.d.f32414d) : null));
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.h
        public final void b() {
        }

        public abstract void f(ConnectionResult connectionResult);

        public abstract boolean g();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class g extends i7.c {
        public g(Looper looper) {
            super(looper);
        }

        public static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.b();
            hVar.d();
        }

        public static boolean b(Message message) {
            int i10 = message.what;
            return i10 == 2 || i10 == 1 || i10 == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (BaseGmsClient.this.B.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            int i10 = message.what;
            if ((i10 == 1 || i10 == 7 || ((i10 == 4 && !BaseGmsClient.this.p()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                a(message);
                return;
            }
            int i11 = message.what;
            if (i11 == 4) {
                BaseGmsClient.this.f23589y = new ConnectionResult(message.arg2);
                if (BaseGmsClient.this.Y() && !BaseGmsClient.this.f23590z) {
                    BaseGmsClient.this.P(3, null);
                    return;
                }
                if (BaseGmsClient.this.f23589y != null) {
                    connectionResult2 = BaseGmsClient.this.f23589y;
                } else {
                    connectionResult2 = new ConnectionResult(8);
                }
                BaseGmsClient.this.f23580p.a(connectionResult2);
                BaseGmsClient.this.D(connectionResult2);
                return;
            }
            if (i11 == 5) {
                if (BaseGmsClient.this.f23589y != null) {
                    connectionResult = BaseGmsClient.this.f23589y;
                } else {
                    connectionResult = new ConnectionResult(8);
                }
                BaseGmsClient.this.f23580p.a(connectionResult);
                BaseGmsClient.this.D(connectionResult);
                return;
            }
            if (i11 == 3) {
                Object obj = message.obj;
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                BaseGmsClient.this.f23580p.a(connectionResult3);
                BaseGmsClient.this.D(connectionResult3);
                return;
            }
            if (i11 == 6) {
                BaseGmsClient.this.P(5, null);
                if (BaseGmsClient.this.f23585u != null) {
                    BaseGmsClient.this.f23585u.onConnectionSuspended(message.arg2);
                }
                BaseGmsClient.this.E(message.arg2);
                BaseGmsClient.this.U(5, 1, null);
                return;
            }
            if (i11 == 2 && !BaseGmsClient.this.isConnected()) {
                a(message);
                return;
            }
            if (b(message)) {
                ((h) message.obj).c();
                return;
            }
            int i12 = message.what;
            StringBuilder sb2 = new StringBuilder(45);
            sb2.append("Don't know how to handle message: ");
            sb2.append(i12);
            Log.wtf("GmsClient", sb2.toString(), new Exception());
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public abstract class h<TListener> {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public TListener f23596a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f23597b = false;

        public h(TListener tlistener) {
            this.f23596a = tlistener;
        }

        public abstract void a(TListener tlistener);

        public abstract void b();

        public final void c() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f23596a;
                if (this.f23597b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 47);
                    sb2.append("Callback proxy ");
                    sb2.append(valueOf);
                    sb2.append(" being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e2) {
                    b();
                    throw e2;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.f23597b = true;
            }
            d();
        }

        public final void d() {
            e();
            synchronized (BaseGmsClient.this.f23582r) {
                BaseGmsClient.this.f23582r.remove(this);
            }
        }

        public final void e() {
            synchronized (this) {
                this.f23596a = null;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class i implements ServiceConnection {

        /* renamed from: b, reason: collision with root package name */
        public final int f23599b;

        public i(int i10) {
            this.f23599b = i10;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker zzaVar;
            if (iBinder == null) {
                BaseGmsClient.this.N(16);
                return;
            }
            synchronized (BaseGmsClient.this.f23578n) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface != null && (queryLocalInterface instanceof IGmsServiceBroker)) {
                    zzaVar = (IGmsServiceBroker) queryLocalInterface;
                } else {
                    zzaVar = new IGmsServiceBroker.Stub.zza(iBinder);
                }
                baseGmsClient.f23579o = zzaVar;
            }
            BaseGmsClient.this.O(0, null, this.f23599b);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.f23578n) {
                BaseGmsClient.this.f23579o = null;
            }
            Handler handler = BaseGmsClient.this.f23576l;
            handler.sendMessage(handler.obtainMessage(6, this.f23599b, 1));
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class j extends f {

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public final IBinder f23601g;

        @BinderThread
        public j(int i10, @Nullable IBinder iBinder, @Nullable Bundle bundle) {
            super(i10, bundle);
            this.f23601g = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.f
        public final void f(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.f23586v != null) {
                BaseGmsClient.this.f23586v.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.D(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.f
        public final boolean g() {
            try {
                String interfaceDescriptor = ((IBinder) com.google.android.gms.common.internal.h.h(this.f23601g)).getInterfaceDescriptor();
                if (!BaseGmsClient.this.y().equals(interfaceDescriptor)) {
                    String y10 = BaseGmsClient.this.y();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(y10).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb2.append("service descriptor mismatch: ");
                    sb2.append(y10);
                    sb2.append(" vs. ");
                    sb2.append(interfaceDescriptor);
                    return false;
                }
                IInterface o10 = BaseGmsClient.this.o(this.f23601g);
                if (o10 == null) {
                    return false;
                }
                if (!BaseGmsClient.this.U(2, 4, o10) && !BaseGmsClient.this.U(3, 4, o10)) {
                    return false;
                }
                BaseGmsClient.this.f23589y = null;
                Bundle s2 = BaseGmsClient.this.s();
                if (BaseGmsClient.this.f23585u != null) {
                    BaseGmsClient.this.f23585u.onConnected(s2);
                }
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class k extends f {
        @BinderThread
        public k(int i10, @Nullable Bundle bundle) {
            super(i10, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.f
        public final void f(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.p() && BaseGmsClient.this.Y()) {
                BaseGmsClient.this.N(16);
            } else {
                BaseGmsClient.this.f23580p.a(connectionResult);
                BaseGmsClient.this.D(connectionResult);
            }
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.f
        public final boolean g() {
            BaseGmsClient.this.f23580p.a(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class zze extends IGmsCallbacks.zza {

        @Nullable
        private BaseGmsClient zza;
        private final int zzb;

        public zze(@NonNull BaseGmsClient baseGmsClient, int i10) {
            this.zza = baseGmsClient;
            this.zzb = i10;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        public final void onPostInitComplete(int i10, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            com.google.android.gms.common.internal.h.i(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zza.F(i10, iBinder, bundle, this.zzb);
            this.zza = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        public final void zza(int i10, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        public final void zza(int i10, @NonNull IBinder iBinder, @NonNull zzc zzcVar) {
            BaseGmsClient baseGmsClient = this.zza;
            com.google.android.gms.common.internal.h.i(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            com.google.android.gms.common.internal.h.h(zzcVar);
            baseGmsClient.T(zzcVar);
            onPostInitComplete(i10, iBinder, zzcVar.f23714b);
        }
    }

    public BaseGmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull com.google.android.gms.common.internal.d dVar, @RecentlyNonNull com.google.android.gms.common.b bVar, @RecentlyNonNull int i10, @Nullable a aVar, @Nullable b bVar2, @Nullable String str) {
        this.f23572h = (Context) com.google.android.gms.common.internal.h.i(context, "Context must not be null");
        this.f23573i = (Looper) com.google.android.gms.common.internal.h.i(looper, "Looper must not be null");
        this.f23574j = (com.google.android.gms.common.internal.d) com.google.android.gms.common.internal.h.i(dVar, "Supervisor must not be null");
        this.f23575k = (com.google.android.gms.common.b) com.google.android.gms.common.internal.h.i(bVar, "API availability must not be null");
        this.f23576l = new g(looper);
        this.f23587w = i10;
        this.f23585u = aVar;
        this.f23586v = bVar2;
        this.f23588x = str;
    }

    @RecentlyNonNull
    public String A() {
        return "com.google.android.gms";
    }

    @RecentlyNonNull
    public boolean B() {
        return false;
    }

    @CallSuper
    public void C(@RecentlyNonNull T t2) {
        this.f23567c = System.currentTimeMillis();
    }

    @CallSuper
    public void D(@RecentlyNonNull ConnectionResult connectionResult) {
        this.f23568d = connectionResult.getErrorCode();
        this.f23569e = System.currentTimeMillis();
    }

    @CallSuper
    public void E(@RecentlyNonNull int i10) {
        this.f23565a = i10;
        this.f23566b = System.currentTimeMillis();
    }

    public void F(@RecentlyNonNull int i10, @Nullable IBinder iBinder, @Nullable Bundle bundle, @RecentlyNonNull int i11) {
        Handler handler = this.f23576l;
        handler.sendMessage(handler.obtainMessage(1, i11, -1, new j(i10, iBinder, bundle)));
    }

    @RecentlyNonNull
    public boolean G() {
        return false;
    }

    public void H(@RecentlyNonNull int i10) {
        Handler handler = this.f23576l;
        handler.sendMessage(handler.obtainMessage(6, this.B.get(), i10));
    }

    @RecentlyNonNull
    public boolean I() {
        return false;
    }

    public final String M() {
        String str = this.f23588x;
        return str == null ? this.f23572h.getClass().getName() : str;
    }

    public final void N(int i10) {
        int i11;
        if (W()) {
            i11 = 5;
            this.f23590z = true;
        } else {
            i11 = 4;
        }
        Handler handler = this.f23576l;
        handler.sendMessage(handler.obtainMessage(i11, this.B.get(), 16));
    }

    public final void O(@RecentlyNonNull int i10, @Nullable Bundle bundle, @RecentlyNonNull int i11) {
        Handler handler = this.f23576l;
        handler.sendMessage(handler.obtainMessage(7, i11, -1, new k(i10, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P(int i10, @Nullable T t2) {
        d0 d0Var;
        d0 d0Var2;
        com.google.android.gms.common.internal.h.a((i10 == 4) == (t2 != null));
        synchronized (this.f23577m) {
            this.f23584t = i10;
            this.f23581q = t2;
            if (i10 == 1) {
                i iVar = this.f23583s;
                if (iVar != null) {
                    this.f23574j.c((String) com.google.android.gms.common.internal.h.h(this.f23571g.a()), this.f23571g.b(), this.f23571g.c(), iVar, M(), this.f23571g.d());
                    this.f23583s = null;
                }
            } else if (i10 == 2 || i10 == 3) {
                i iVar2 = this.f23583s;
                if (iVar2 != null && (d0Var2 = this.f23571g) != null) {
                    String a10 = d0Var2.a();
                    String b4 = this.f23571g.b();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(a10).length() + 70 + String.valueOf(b4).length());
                    sb2.append("Calling connect() while still connected, missing disconnect() for ");
                    sb2.append(a10);
                    sb2.append(" on ");
                    sb2.append(b4);
                    this.f23574j.c((String) com.google.android.gms.common.internal.h.h(this.f23571g.a()), this.f23571g.b(), this.f23571g.c(), iVar2, M(), this.f23571g.d());
                    this.B.incrementAndGet();
                }
                i iVar3 = new i(this.B.get());
                this.f23583s = iVar3;
                if (this.f23584t == 3 && v() != null) {
                    d0Var = new d0(t().getPackageName(), v(), true, com.google.android.gms.common.internal.d.a(), false);
                } else {
                    d0Var = new d0(A(), z(), false, com.google.android.gms.common.internal.d.a(), B());
                }
                this.f23571g = d0Var;
                if (d0Var.d() && g() < 17895000) {
                    String valueOf = String.valueOf(this.f23571g.a());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
                if (!this.f23574j.d(new d.a((String) com.google.android.gms.common.internal.h.h(this.f23571g.a()), this.f23571g.b(), this.f23571g.c(), this.f23571g.d()), iVar3, M())) {
                    String a11 = this.f23571g.a();
                    String b10 = this.f23571g.b();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(a11).length() + 34 + String.valueOf(b10).length());
                    sb3.append("unable to connect to service: ");
                    sb3.append(a11);
                    sb3.append(" on ");
                    sb3.append(b10);
                    O(16, null, this.B.get());
                }
            } else if (i10 == 4) {
                C((IInterface) com.google.android.gms.common.internal.h.h(t2));
            }
        }
    }

    public final void T(zzc zzcVar) {
        this.A = zzcVar;
    }

    public final boolean U(int i10, int i11, @Nullable T t2) {
        synchronized (this.f23577m) {
            if (this.f23584t != i10) {
                return false;
            }
            P(i11, t2);
            return true;
        }
    }

    public final boolean W() {
        boolean z10;
        synchronized (this.f23577m) {
            z10 = this.f23584t == 3;
        }
        return z10;
    }

    public final boolean Y() {
        if (this.f23590z || TextUtils.isEmpty(y()) || TextUtils.isEmpty(v())) {
            return false;
        }
        try {
            Class.forName(y());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void a(@RecentlyNonNull String str) {
        this.f23570f = str;
        disconnect();
    }

    public void b(@RecentlyNonNull c cVar) {
        this.f23580p = (c) com.google.android.gms.common.internal.h.i(cVar, "Connection progress callbacks cannot be null.");
        P(2, null);
    }

    @RecentlyNonNull
    public boolean c() {
        return false;
    }

    public void disconnect() {
        this.B.incrementAndGet();
        synchronized (this.f23582r) {
            int size = this.f23582r.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f23582r.get(i10).e();
            }
            this.f23582r.clear();
        }
        synchronized (this.f23578n) {
            this.f23579o = null;
        }
        P(1, null);
    }

    @WorkerThread
    public void f(@Nullable IAccountAccessor iAccountAccessor, @RecentlyNonNull Set<Scope> set) {
        Bundle u10 = u();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.f23587w);
        getServiceRequest.f23617e = this.f23572h.getPackageName();
        getServiceRequest.f23620h = u10;
        if (set != null) {
            getServiceRequest.f23619g = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (c()) {
            Account q10 = q();
            if (q10 == null) {
                q10 = new Account(HuaweiApiClientImpl.DEFAULT_ACCOUNT, "com.google");
            }
            getServiceRequest.f23621i = q10;
            if (iAccountAccessor != null) {
                getServiceRequest.f23618f = iAccountAccessor.asBinder();
            }
        } else if (G()) {
            getServiceRequest.f23621i = q();
        }
        getServiceRequest.f23622j = C;
        getServiceRequest.f23623k = r();
        if (I()) {
            getServiceRequest.f23626n = true;
        }
        try {
            try {
                synchronized (this.f23578n) {
                    IGmsServiceBroker iGmsServiceBroker = this.f23579o;
                    if (iGmsServiceBroker != null) {
                        iGmsServiceBroker.getService(new zze(this, this.B.get()), getServiceRequest);
                    }
                }
            } catch (DeadObjectException unused) {
                H(3);
            } catch (SecurityException e2) {
                throw e2;
            }
        } catch (RemoteException | RuntimeException unused2) {
            F(8, null, null, this.B.get());
        }
    }

    @RecentlyNonNull
    public abstract int g();

    @RecentlyNonNull
    public String h() {
        d0 d0Var;
        if (isConnected() && (d0Var = this.f23571g) != null) {
            return d0Var.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @RecentlyNonNull
    public boolean i() {
        return true;
    }

    @RecentlyNonNull
    public boolean isConnected() {
        boolean z10;
        synchronized (this.f23577m) {
            z10 = this.f23584t == 4;
        }
        return z10;
    }

    @RecentlyNonNull
    public boolean isConnecting() {
        boolean z10;
        synchronized (this.f23577m) {
            int i10 = this.f23584t;
            z10 = i10 == 2 || i10 == 3;
        }
        return z10;
    }

    public void k(@RecentlyNonNull e eVar) {
        eVar.a();
    }

    @RecentlyNullable
    public final Feature[] l() {
        zzc zzcVar = this.A;
        if (zzcVar == null) {
            return null;
        }
        return zzcVar.f23715c;
    }

    @RecentlyNullable
    public String m() {
        return this.f23570f;
    }

    public final void n() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @RecentlyNullable
    public abstract T o(@RecentlyNonNull IBinder iBinder);

    @RecentlyNonNull
    public boolean p() {
        return false;
    }

    @RecentlyNullable
    public abstract Account q();

    @RecentlyNonNull
    public Feature[] r() {
        return C;
    }

    @RecentlyNullable
    public Bundle s() {
        return null;
    }

    @RecentlyNonNull
    public final Context t() {
        return this.f23572h;
    }

    @RecentlyNonNull
    public Bundle u() {
        return new Bundle();
    }

    @RecentlyNullable
    public String v() {
        return null;
    }

    @RecentlyNonNull
    public abstract Set<Scope> w();

    @RecentlyNonNull
    public final T x() throws DeadObjectException {
        T t2;
        synchronized (this.f23577m) {
            if (this.f23584t != 5) {
                n();
                t2 = (T) com.google.android.gms.common.internal.h.i(this.f23581q, "Client is connected but service is null");
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    @NonNull
    public abstract String y();

    @NonNull
    public abstract String z();
}
