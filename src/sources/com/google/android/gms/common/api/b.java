package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.WorkerThread;
import b7.k;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.a0;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.zacb;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.h;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b<O extends a.d> implements c<O> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f23393a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f23394b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.a<O> f23395c;

    /* renamed from: d, reason: collision with root package name */
    public final O f23396d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.common.api.internal.b<O> f23397e;

    /* renamed from: f, reason: collision with root package name */
    public final Looper f23398f;

    /* renamed from: g, reason: collision with root package name */
    public final int f23399g;

    /* renamed from: h, reason: collision with root package name */
    public final GoogleApiClient f23400h;

    /* renamed from: i, reason: collision with root package name */
    public final l f23401i;

    /* renamed from: j, reason: collision with root package name */
    public final g f23402j;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        @RecentlyNonNull
        public static final a f23403c = new C0215a().a();

        /* renamed from: a, reason: collision with root package name */
        @RecentlyNonNull
        public final l f23404a;

        /* renamed from: b, reason: collision with root package name */
        @RecentlyNonNull
        public final Looper f23405b;

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        /* renamed from: com.google.android.gms.common.api.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static class C0215a {

            /* renamed from: a, reason: collision with root package name */
            public l f23406a;

            /* renamed from: b, reason: collision with root package name */
            public Looper f23407b;

            @RecentlyNonNull
            public a a() {
                if (this.f23406a == null) {
                    this.f23406a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f23407b == null) {
                    this.f23407b = Looper.getMainLooper();
                }
                return new a(this.f23406a, this.f23407b);
            }

            @RecentlyNonNull
            public C0215a b(@RecentlyNonNull l lVar) {
                h.i(lVar, "StatusExceptionMapper must not be null.");
                this.f23406a = lVar;
                return this;
            }
        }

        public a(l lVar, Account account, Looper looper) {
            this.f23404a = lVar;
            this.f23405b = looper;
        }
    }

    public b(@RecentlyNonNull Context context, @RecentlyNonNull com.google.android.gms.common.api.a<O> aVar, @RecentlyNonNull O o10, @RecentlyNonNull a aVar2) {
        h.i(context, "Null context is not permitted.");
        h.i(aVar, "Api must not be null.");
        h.i(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.f23393a = applicationContext;
        this.f23394b = k(context);
        this.f23395c = aVar;
        this.f23396d = o10;
        this.f23398f = aVar2.f23405b;
        this.f23397e = com.google.android.gms.common.api.internal.b.b(aVar, o10);
        this.f23400h = new a0(this);
        g c4 = g.c(applicationContext);
        this.f23402j = c4;
        this.f23399g = c4.g();
        this.f23401i = aVar2.f23404a;
        c4.d(this);
    }

    @Nullable
    public static String k(Object obj) {
        if (!k.i()) {
            return null;
        }
        try {
            return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.c
    @RecentlyNonNull
    public com.google.android.gms.common.api.internal.b<O> b() {
        return this.f23397e;
    }

    @RecentlyNonNull
    public GoogleApiClient c() {
        return this.f23400h;
    }

    @RecentlyNonNull
    public b.a d() {
        Account account;
        Set<Scope> emptySet;
        GoogleSignInAccount a10;
        GoogleSignInAccount a11;
        b.a aVar = new b.a();
        O o10 = this.f23396d;
        if ((o10 instanceof a.d.b) && (a11 = ((a.d.b) o10).a()) != null) {
            account = a11.getAccount();
        } else {
            O o11 = this.f23396d;
            account = o11 instanceof a.d.InterfaceC0214a ? ((a.d.InterfaceC0214a) o11).getAccount() : null;
        }
        b.a c4 = aVar.c(account);
        O o12 = this.f23396d;
        if ((o12 instanceof a.d.b) && (a10 = ((a.d.b) o12).a()) != null) {
            emptySet = a10.r();
        } else {
            emptySet = Collections.emptySet();
        }
        return c4.e(emptySet).d(this.f23393a.getClass().getName()).b(this.f23393a.getPackageName());
    }

    @RecentlyNonNull
    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends Result, A>> T e(@RecentlyNonNull T t2) {
        return (T) i(2, t2);
    }

    @RecentlyNonNull
    public Looper f() {
        return this.f23398f;
    }

    @RecentlyNonNull
    public final int g() {
        return this.f23399g;
    }

    @WorkerThread
    public final a.f h(Looper looper, g.a<O> aVar) {
        return ((a.AbstractC0213a) h.h(this.f23395c.a())).a(this.f23393a, looper, d().a(), this.f23396d, aVar, aVar);
    }

    public final <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends Result, A>> T i(int i10, @NonNull T t2) {
        t2.zab();
        this.f23402j.e(this, i10, t2);
        return t2;
    }

    public final zacb j(Context context, Handler handler) {
        return new zacb(context, handler, d().a());
    }

    @Deprecated
    public b(@RecentlyNonNull Context context, @RecentlyNonNull com.google.android.gms.common.api.a<O> aVar, @RecentlyNonNull O o10, @RecentlyNonNull l lVar) {
        this(context, aVar, o10, new a.C0215a().b(lVar).a());
    }
}
