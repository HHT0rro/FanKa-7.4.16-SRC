package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import androidx.core.content.PermissionChecker;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class e<T> {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f23839h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static Context f23840i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f23841j;

    /* renamed from: k, reason: collision with root package name */
    public static volatile Boolean f23842k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile Boolean f23843l;

    /* renamed from: a, reason: collision with root package name */
    public final o f23844a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23845b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23846c;

    /* renamed from: d, reason: collision with root package name */
    public final T f23847d;

    /* renamed from: e, reason: collision with root package name */
    public T f23848e;

    /* renamed from: f, reason: collision with root package name */
    public volatile b f23849f;

    /* renamed from: g, reason: collision with root package name */
    public volatile SharedPreferences f23850g;

    public e(o oVar, String str, T t2) {
        this.f23848e = null;
        this.f23849f = null;
        this.f23850g = null;
        if (o.c(oVar) == null && o.d(oVar) == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (o.c(oVar) != null && o.d(oVar) != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.f23844a = oVar;
        String valueOf = String.valueOf(o.g(oVar));
        String valueOf2 = String.valueOf(str);
        this.f23846c = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        String valueOf3 = String.valueOf(o.i(oVar));
        String valueOf4 = String.valueOf(str);
        this.f23845b = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        this.f23847d = t2;
    }

    public /* synthetic */ e(o oVar, String str, Object obj, i iVar) {
        this(oVar, str, obj);
    }

    public static void b(Context context) {
        Context applicationContext;
        if (f23840i == null) {
            synchronized (f23839h) {
                if ((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) && (applicationContext = context.getApplicationContext()) != null) {
                    context = applicationContext;
                }
                if (f23840i != context) {
                    f23842k = null;
                }
                f23840i = context;
            }
            f23841j = false;
        }
    }

    public static <T> e<T> c(o oVar, String str, T t2, n<T> nVar) {
        return new l(oVar, str, t2, nVar);
    }

    public static e<String> d(o oVar, String str, String str2) {
        return new k(oVar, str, str2);
    }

    public static e<Boolean> e(o oVar, String str, boolean z10) {
        return new j(oVar, str, Boolean.valueOf(z10));
    }

    public static <V> V g(m<V> mVar) {
        try {
            return mVar.zzp();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return mVar.zzp();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public static boolean h(final String str, boolean z10) {
        final boolean z11 = false;
        if (p()) {
            return ((Boolean) g(new m(str, z11) { // from class: com.google.android.gms.internal.clearcut.h

                /* renamed from: a, reason: collision with root package name */
                public final String f23909a;

                /* renamed from: b, reason: collision with root package name */
                public final boolean f23910b = false;

                {
                    this.f23909a = str;
                }

                @Override // com.google.android.gms.internal.clearcut.m
                public final Object zzp() {
                    Boolean valueOf;
                    valueOf = Boolean.valueOf(k5.h(e.f23840i.getContentResolver(), this.f23909a, this.f23910b));
                    return valueOf;
                }
            })).booleanValue();
        }
        return false;
    }

    public static boolean p() {
        if (f23842k == null) {
            Context context = f23840i;
            if (context == null) {
                return false;
            }
            f23842k = Boolean.valueOf(PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f23842k.booleanValue();
    }

    public final T a() {
        if (f23840i == null) {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
        if (o.j(this.f23844a)) {
            T o10 = o();
            if (o10 != null) {
                return o10;
            }
            T n10 = n();
            if (n10 != null) {
                return n10;
            }
        } else {
            T n11 = n();
            if (n11 != null) {
                return n11;
            }
            T o11 = o();
            if (o11 != null) {
                return o11;
            }
        }
        return this.f23847d;
    }

    public abstract T f(SharedPreferences sharedPreferences);

    public abstract T m(String str);

    public final T n() {
        boolean z10;
        if (h("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String valueOf = String.valueOf(this.f23845b);
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            }
        } else if (o.d(this.f23844a) != null) {
            if (this.f23849f == null) {
                this.f23849f = b.a(f23840i.getContentResolver(), o.d(this.f23844a));
            }
            final b bVar = this.f23849f;
            String str = (String) g(new m(this, bVar) { // from class: com.google.android.gms.internal.clearcut.f

                /* renamed from: a, reason: collision with root package name */
                public final e f23890a;

                /* renamed from: b, reason: collision with root package name */
                public final b f23891b;

                {
                    this.f23890a = this;
                    this.f23891b = bVar;
                }

                @Override // com.google.android.gms.internal.clearcut.m
                public final Object zzp() {
                    return this.f23891b.c().get(this.f23890a.f23845b);
                }
            });
            if (str != null) {
                return m(str);
            }
        } else if (o.c(this.f23844a) != null) {
            if (Build.VERSION.SDK_INT < 24 || f23840i.isDeviceProtectedStorage()) {
                z10 = true;
            } else {
                if (f23843l == null || !f23843l.booleanValue()) {
                    f23843l = Boolean.valueOf(((UserManager) f23840i.getSystemService(UserManager.class)).isUserUnlocked());
                }
                z10 = f23843l.booleanValue();
            }
            if (!z10) {
                return null;
            }
            if (this.f23850g == null) {
                this.f23850g = f23840i.getSharedPreferences(o.c(this.f23844a), 0);
            }
            SharedPreferences sharedPreferences = this.f23850g;
            if (sharedPreferences.contains(this.f23845b)) {
                return f(sharedPreferences);
            }
        }
        return null;
    }

    public final T o() {
        String str;
        if (o.k(this.f23844a) || !p() || (str = (String) g(new m(this) { // from class: com.google.android.gms.internal.clearcut.g

            /* renamed from: a, reason: collision with root package name */
            public final e f23898a;

            {
                this.f23898a = this;
            }

            @Override // com.google.android.gms.internal.clearcut.m
            public final Object zzp() {
                return this.f23898a.q();
            }
        })) == null) {
            return null;
        }
        return m(str);
    }

    public final /* synthetic */ String q() {
        return k5.c(f23840i.getContentResolver(), this.f23846c, null);
    }
}
