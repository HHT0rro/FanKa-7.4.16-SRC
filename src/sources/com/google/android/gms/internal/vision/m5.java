package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class m5 {

    /* renamed from: d, reason: collision with root package name */
    public static final l4 f25551d = l4.d();

    /* renamed from: a, reason: collision with root package name */
    public zzht f25552a;

    /* renamed from: b, reason: collision with root package name */
    public volatile c6 f25553b;

    /* renamed from: c, reason: collision with root package name */
    public volatile zzht f25554c;

    public final c6 a(c6 c6Var) {
        c6 c6Var2 = this.f25553b;
        this.f25552a = null;
        this.f25554c = null;
        this.f25553b = c6Var;
        return c6Var2;
    }

    public final int b() {
        if (this.f25554c != null) {
            return this.f25554c.zza();
        }
        if (this.f25553b != null) {
            return this.f25553b.zzm();
        }
        return 0;
    }

    public final c6 c(c6 c6Var) {
        if (this.f25553b == null) {
            synchronized (this) {
                if (this.f25553b == null) {
                    try {
                        this.f25553b = c6Var;
                        this.f25554c = zzht.zza;
                    } catch (zzjk unused) {
                        this.f25553b = c6Var;
                        this.f25554c = zzht.zza;
                    }
                }
            }
        }
        return this.f25553b;
    }

    public final zzht d() {
        if (this.f25554c != null) {
            return this.f25554c;
        }
        synchronized (this) {
            if (this.f25554c != null) {
                return this.f25554c;
            }
            if (this.f25553b == null) {
                this.f25554c = zzht.zza;
            } else {
                this.f25554c = this.f25553b.zzg();
            }
            return this.f25554c;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m5)) {
            return false;
        }
        m5 m5Var = (m5) obj;
        c6 c6Var = this.f25553b;
        c6 c6Var2 = m5Var.f25553b;
        if (c6Var == null && c6Var2 == null) {
            return d().equals(m5Var.d());
        }
        if (c6Var != null && c6Var2 != null) {
            return c6Var.equals(c6Var2);
        }
        if (c6Var != null) {
            return c6Var.equals(m5Var.c(c6Var.zzr()));
        }
        return c(c6Var2.zzr()).equals(c6Var2);
    }

    public int hashCode() {
        return 1;
    }
}
