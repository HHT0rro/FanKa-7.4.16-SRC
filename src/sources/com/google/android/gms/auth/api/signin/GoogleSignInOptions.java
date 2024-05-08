package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r6.b;
import r6.c;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d, ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* renamed from: m, reason: collision with root package name */
    @RecentlyNonNull
    public static final Scope f23277m = new Scope("profile");

    /* renamed from: n, reason: collision with root package name */
    @RecentlyNonNull
    public static final Scope f23278n = new Scope("email");

    /* renamed from: o, reason: collision with root package name */
    @RecentlyNonNull
    public static final Scope f23279o = new Scope("openid");

    /* renamed from: p, reason: collision with root package name */
    @RecentlyNonNull
    public static final Scope f23280p;

    /* renamed from: q, reason: collision with root package name */
    @RecentlyNonNull
    public static final Scope f23281q;

    /* renamed from: r, reason: collision with root package name */
    @RecentlyNonNull
    public static final GoogleSignInOptions f23282r;

    /* renamed from: s, reason: collision with root package name */
    @RecentlyNonNull
    public static final GoogleSignInOptions f23283s;

    /* renamed from: t, reason: collision with root package name */
    public static Comparator<Scope> f23284t;

    /* renamed from: b, reason: collision with root package name */
    public final int f23285b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<Scope> f23286c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Account f23287d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23288e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f23289f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f23290g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f23291h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public String f23292i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> f23293j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public String f23294k;

    /* renamed from: l, reason: collision with root package name */
    public Map<Integer, GoogleSignInOptionsExtensionParcelable> f23295l;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public boolean f23297b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f23298c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f23299d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public String f23300e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public Account f23301f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public String f23302g;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public String f23304i;

        /* renamed from: a, reason: collision with root package name */
        public Set<Scope> f23296a = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        public Map<Integer, GoogleSignInOptionsExtensionParcelable> f23303h = new HashMap();

        @RecentlyNonNull
        public final GoogleSignInOptions a() {
            if (this.f23296a.contains(GoogleSignInOptions.f23281q)) {
                Set<Scope> set = this.f23296a;
                Scope scope = GoogleSignInOptions.f23280p;
                if (set.contains(scope)) {
                    this.f23296a.remove(scope);
                }
            }
            if (this.f23299d && (this.f23301f == null || !this.f23296a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f23296a), this.f23301f, this.f23299d, this.f23297b, this.f23298c, this.f23300e, this.f23302g, this.f23303h, this.f23304i, null);
        }

        @RecentlyNonNull
        public final a b() {
            this.f23296a.add(GoogleSignInOptions.f23279o);
            return this;
        }

        @RecentlyNonNull
        public final a c() {
            this.f23296a.add(GoogleSignInOptions.f23277m);
            return this;
        }

        @RecentlyNonNull
        public final a d(@RecentlyNonNull Scope scope, @RecentlyNonNull Scope... scopeArr) {
            this.f23296a.add(scope);
            this.f23296a.addAll(Arrays.asList(scopeArr));
            return this;
        }
    }

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f23280p = scope;
        f23281q = new Scope("https://www.googleapis.com/auth/games");
        f23282r = new a().b().c().a();
        f23283s = new a().d(scope, new Scope[0]).a();
        CREATOR = new c();
        f23284t = new b();
    }

    public GoogleSignInOptions(int i10, ArrayList<Scope> arrayList, @Nullable Account account, boolean z10, boolean z11, boolean z12, @Nullable String str, @Nullable String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, @Nullable String str3) {
        this(i10, arrayList, account, z10, z11, z12, str, str2, r(arrayList2), str3);
    }

    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> r(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.f()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
    
        if (r3.f23291h.equals(r4.j()) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0048, code lost:
    
        if (r1.equals(r4.getAccount()) != false) goto L22;
     */
    @androidx.annotation.RecentlyNonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.f23293j     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 > 0) goto L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.f23293j     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 <= 0) goto L18
            goto L8f
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f23286c     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.i()     // Catch: java.lang.ClassCastException -> L8f
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f23286c     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.i()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L35
            goto L8f
        L35:
            android.accounts.Account r1 = r3.f23287d     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L8f
            goto L4a
        L40:
            android.accounts.Account r2 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L4a:
            java.lang.String r1 = r3.f23291h     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.j()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
            goto L69
        L5d:
            java.lang.String r1 = r3.f23291h     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r2 = r4.j()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L69:
            boolean r1 = r3.f23290g     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.k()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.f23288e     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.l()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.f23289f     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.m()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.lang.String r1 = r3.f23294k     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r4 = r4.g()     // Catch: java.lang.ClassCastException -> L8f
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L8f
            if (r4 == 0) goto L8f
            r4 = 1
            return r4
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @RecentlyNonNull
    public ArrayList<GoogleSignInOptionsExtensionParcelable> f() {
        return this.f23293j;
    }

    @RecentlyNullable
    public String g() {
        return this.f23294k;
    }

    @RecentlyNullable
    public Account getAccount() {
        return this.f23287d;
    }

    @RecentlyNonNull
    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f23286c;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Scope scope = arrayList2.get(i10);
            i10++;
            arrayList.add(scope.f());
        }
        Collections.sort(arrayList);
        return new s6.a().a(arrayList).a(this.f23287d).a(this.f23291h).c(this.f23290g).c(this.f23288e).c(this.f23289f).a(this.f23294k).b();
    }

    @RecentlyNonNull
    public ArrayList<Scope> i() {
        return new ArrayList<>(this.f23286c);
    }

    @RecentlyNullable
    public String j() {
        return this.f23291h;
    }

    @RecentlyNonNull
    public boolean k() {
        return this.f23290g;
    }

    @RecentlyNonNull
    public boolean l() {
        return this.f23288e;
    }

    @RecentlyNonNull
    public boolean m() {
        return this.f23289f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23285b);
        w6.a.s(parcel, 2, i(), false);
        w6.a.n(parcel, 3, getAccount(), i10, false);
        w6.a.c(parcel, 4, l());
        w6.a.c(parcel, 5, m());
        w6.a.c(parcel, 6, k());
        w6.a.o(parcel, 7, j(), false);
        w6.a.o(parcel, 8, this.f23292i, false);
        w6.a.s(parcel, 9, f(), false);
        w6.a.o(parcel, 10, g(), false);
        w6.a.b(parcel, a10);
    }

    public GoogleSignInOptions(int i10, ArrayList<Scope> arrayList, @Nullable Account account, boolean z10, boolean z11, boolean z12, @Nullable String str, @Nullable String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @Nullable String str3) {
        this.f23285b = i10;
        this.f23286c = arrayList;
        this.f23287d = account;
        this.f23288e = z10;
        this.f23289f = z11;
        this.f23290g = z12;
        this.f23291h = str;
        this.f23292i = str2;
        this.f23293j = new ArrayList<>(map.values());
        this.f23295l = map;
        this.f23294k = str3;
    }

    public /* synthetic */ GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, String str3, b bVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z10, z11, z12, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }
}
