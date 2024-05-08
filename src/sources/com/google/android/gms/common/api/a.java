package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.h;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a<O extends d> {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0213a<?, O> f23390a;

    /* renamed from: b, reason: collision with root package name */
    public final g<?> f23391b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23392c;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* renamed from: com.google.android.gms.common.api.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class AbstractC0213a<T extends f, O> extends e<T, O> {
        @RecentlyNonNull
        @Deprecated
        public T a(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull com.google.android.gms.common.internal.b bVar, @RecentlyNonNull O o10, @RecentlyNonNull GoogleApiClient.a aVar, @RecentlyNonNull GoogleApiClient.b bVar2) {
            return b(context, looper, bVar, o10, aVar, bVar2);
        }

        @RecentlyNonNull
        public T b(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull com.google.android.gms.common.internal.b bVar, @RecentlyNonNull O o10, @RecentlyNonNull com.google.android.gms.common.api.internal.f fVar, @RecentlyNonNull k kVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class c<C extends b> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface d {

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        /* renamed from: com.google.android.gms.common.api.a$d$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public interface InterfaceC0214a extends d {
            @RecentlyNonNull
            Account getAccount();
        }

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public interface b extends d {
            @RecentlyNonNull
            GoogleSignInAccount a();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class e<T extends b, O> {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface f extends b {
        void a(@RecentlyNonNull String str);

        void b(@RecentlyNonNull BaseGmsClient.c cVar);

        @RecentlyNonNull
        boolean c();

        void disconnect();

        @NonNull
        Set<Scope> e();

        void f(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set);

        @RecentlyNonNull
        int g();

        @RecentlyNonNull
        String h();

        @RecentlyNonNull
        boolean i();

        @RecentlyNonNull
        boolean isConnected();

        @RecentlyNonNull
        boolean isConnecting();

        void k(@RecentlyNonNull BaseGmsClient.e eVar);

        @RecentlyNonNull
        Feature[] l();

        @RecentlyNullable
        String m();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(@RecentlyNonNull String str, @RecentlyNonNull AbstractC0213a<C, O> abstractC0213a, @RecentlyNonNull g<C> gVar) {
        h.i(abstractC0213a, "Cannot construct an Api with a null ClientBuilder");
        h.i(gVar, "Cannot construct an Api with a null ClientKey");
        this.f23392c = str;
        this.f23390a = abstractC0213a;
        this.f23391b = gVar;
    }

    @RecentlyNonNull
    public final AbstractC0213a<?, O> a() {
        return this.f23390a;
    }

    @RecentlyNonNull
    public final c<?> b() {
        return this.f23391b;
    }

    @RecentlyNonNull
    public final String c() {
        return this.f23392c;
    }
}
