package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.huawei.hms.api.HuaweiApiClientImpl;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Account f23639a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Scope> f23640b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Scope> f23641c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<com.google.android.gms.common.api.a<?>, C0216b> f23642d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23643e;

    /* renamed from: f, reason: collision with root package name */
    public final View f23644f;

    /* renamed from: g, reason: collision with root package name */
    public final String f23645g;

    /* renamed from: h, reason: collision with root package name */
    public final String f23646h;

    /* renamed from: i, reason: collision with root package name */
    public final n7.a f23647i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f23648j;

    /* renamed from: k, reason: collision with root package name */
    public Integer f23649k;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Account f23650a;

        /* renamed from: b, reason: collision with root package name */
        public ArraySet<Scope> f23651b;

        /* renamed from: d, reason: collision with root package name */
        public String f23653d;

        /* renamed from: e, reason: collision with root package name */
        public String f23654e;

        /* renamed from: c, reason: collision with root package name */
        public int f23652c = 0;

        /* renamed from: f, reason: collision with root package name */
        public n7.a f23655f = n7.a.f52146k;

        @RecentlyNonNull
        public final b a() {
            return new b(this.f23650a, this.f23651b, null, 0, null, this.f23653d, this.f23654e, this.f23655f, false);
        }

        @RecentlyNonNull
        public final a b(@RecentlyNonNull String str) {
            this.f23653d = str;
            return this;
        }

        @RecentlyNonNull
        public final a c(Account account) {
            this.f23650a = account;
            return this;
        }

        @RecentlyNonNull
        public final a d(@RecentlyNonNull String str) {
            this.f23654e = str;
            return this;
        }

        @RecentlyNonNull
        public final a e(@RecentlyNonNull Collection<Scope> collection) {
            if (this.f23651b == null) {
                this.f23651b = new ArraySet<>();
            }
            this.f23651b.addAll(collection);
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* renamed from: com.google.android.gms.common.internal.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0216b {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Scope> f23656a;
    }

    public b(Account account, @RecentlyNonNull Set<Scope> set, @RecentlyNonNull Map<com.google.android.gms.common.api.a<?>, C0216b> map, @RecentlyNonNull int i10, @RecentlyNonNull View view, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull n7.a aVar, @RecentlyNonNull boolean z10) {
        this.f23639a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f23640b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f23642d = map;
        this.f23644f = view;
        this.f23643e = i10;
        this.f23645g = str;
        this.f23646h = str2;
        this.f23647i = aVar;
        this.f23648j = false;
        HashSet hashSet = new HashSet(emptySet);
        Iterator<C0216b> iterator2 = map.values().iterator2();
        while (iterator2.hasNext()) {
            hashSet.addAll(iterator2.next().f23656a);
        }
        this.f23641c = Collections.unmodifiableSet(hashSet);
    }

    @RecentlyNullable
    public final Account a() {
        return this.f23639a;
    }

    @RecentlyNonNull
    public final Account b() {
        Account account = this.f23639a;
        return account != null ? account : new Account(HuaweiApiClientImpl.DEFAULT_ACCOUNT, "com.google");
    }

    @RecentlyNonNull
    public final Set<Scope> c() {
        return this.f23641c;
    }

    @RecentlyNullable
    public final String d() {
        return this.f23645g;
    }

    @RecentlyNonNull
    public final Set<Scope> e() {
        return this.f23640b;
    }

    public final void f(@RecentlyNonNull Integer num) {
        this.f23649k = num;
    }

    @RecentlyNullable
    public final String g() {
        return this.f23646h;
    }

    @RecentlyNonNull
    public final n7.a h() {
        return this.f23647i;
    }

    @RecentlyNullable
    public final Integer i() {
        return this.f23649k;
    }
}
