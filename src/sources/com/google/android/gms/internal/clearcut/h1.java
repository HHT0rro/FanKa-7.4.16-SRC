package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class h1 {

    /* renamed from: d, reason: collision with root package name */
    public static final l0 f23911d = l0.b();

    /* renamed from: a, reason: collision with root package name */
    public zzbb f23912a;

    /* renamed from: b, reason: collision with root package name */
    public volatile a2 f23913b;

    /* renamed from: c, reason: collision with root package name */
    public volatile zzbb f23914c;

    public final int a() {
        if (this.f23914c != null) {
            return this.f23914c.size();
        }
        if (this.f23913b != null) {
            return this.f23913b.g();
        }
        return 0;
    }

    public final a2 b(a2 a2Var) {
        if (this.f23913b == null) {
            synchronized (this) {
                if (this.f23913b == null) {
                    try {
                        this.f23913b = a2Var;
                        this.f23914c = zzbb.zzfi;
                    } catch (zzco unused) {
                        this.f23913b = a2Var;
                        this.f23914c = zzbb.zzfi;
                    }
                }
            }
        }
        return this.f23913b;
    }

    public final a2 c(a2 a2Var) {
        a2 a2Var2 = this.f23913b;
        this.f23912a = null;
        this.f23914c = null;
        this.f23913b = a2Var;
        return a2Var2;
    }

    public final zzbb d() {
        if (this.f23914c != null) {
            return this.f23914c;
        }
        synchronized (this) {
            if (this.f23914c != null) {
                return this.f23914c;
            }
            this.f23914c = this.f23913b == null ? zzbb.zzfi : this.f23913b.zzr();
            return this.f23914c;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        a2 a2Var = this.f23913b;
        a2 a2Var2 = h1Var.f23913b;
        return (a2Var == null && a2Var2 == null) ? d().equals(h1Var.d()) : (a2Var == null || a2Var2 == null) ? a2Var != null ? a2Var.equals(h1Var.b(a2Var.d())) : b(a2Var2.d()).equals(a2Var2) : a2Var.equals(a2Var2);
    }

    public int hashCode() {
        return 1;
    }
}
