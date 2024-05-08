package com.google.android.gms.internal.clearcut;

import android.net.Uri;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o {

    /* renamed from: a */
    public final String f23963a;

    /* renamed from: b */
    public final Uri f23964b;

    /* renamed from: c */
    public final String f23965c;

    /* renamed from: d */
    public final String f23966d;

    /* renamed from: e */
    public final boolean f23967e;

    /* renamed from: f */
    public final boolean f23968f;

    public o(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    public o(String str, Uri uri, String str2, String str3, boolean z10, boolean z11) {
        this.f23963a = str;
        this.f23964b = uri;
        this.f23965c = str2;
        this.f23966d = str3;
        this.f23967e = z10;
        this.f23968f = z11;
    }

    public final <T> e<T> a(String str, T t2, n<T> nVar) {
        e<T> c4;
        c4 = e.c(this, str, t2, nVar);
        return c4;
    }

    public final e<String> b(String str, String str2) {
        e<String> d10;
        d10 = e.d(this, str, null);
        return d10;
    }

    public final e<Boolean> e(String str, boolean z10) {
        e<Boolean> e2;
        e2 = e.e(this, str, false);
        return e2;
    }

    public final o f(String str) {
        boolean z10 = this.f23967e;
        if (z10) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new o(this.f23963a, this.f23964b, str, this.f23966d, z10, this.f23968f);
    }

    public final o h(String str) {
        return new o(this.f23963a, this.f23964b, this.f23965c, str, this.f23967e, this.f23968f);
    }
}
