package com.google.android.gms.internal.clearcut;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b5 extends y3<b5> implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static volatile b5[] f23827f;

    /* renamed from: d, reason: collision with root package name */
    public String f23828d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f23829e = "";

    public b5() {
        this.f24111c = null;
        this.f23837b = -1;
    }

    public static b5[] i() {
        if (f23827f == null) {
            synchronized (b4.f23826c) {
                if (f23827f == null) {
                    f23827f = new b5[0];
                }
            }
        }
        return f23827f;
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final void a(x3 x3Var) throws IOException {
        String str = this.f23828d;
        if (str != null && !str.equals("")) {
            x3Var.c(1, this.f23828d);
        }
        String str2 = this.f23829e;
        if (str2 != null && !str2.equals("")) {
            x3Var.c(2, this.f23829e);
        }
        super.a(x3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final int e() {
        int e2 = super.e();
        String str = this.f23828d;
        if (str != null && !str.equals("")) {
            e2 += x3.h(1, this.f23828d);
        }
        String str2 = this.f23829e;
        return (str2 == null || str2.equals("")) ? e2 : e2 + x3.h(2, this.f23829e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b5)) {
            return false;
        }
        b5 b5Var = (b5) obj;
        String str = this.f23828d;
        if (str == null) {
            if (b5Var.f23828d != null) {
                return false;
            }
        } else if (!str.equals(b5Var.f23828d)) {
            return false;
        }
        String str2 = this.f23829e;
        if (str2 == null) {
            if (b5Var.f23829e != null) {
                return false;
            }
        } else if (!str2.equals(b5Var.f23829e)) {
            return false;
        }
        z3 z3Var = this.f24111c;
        if (z3Var != null && !z3Var.a()) {
            return this.f24111c.equals(b5Var.f24111c);
        }
        z3 z3Var2 = b5Var.f24111c;
        return z3Var2 == null || z3Var2.a();
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: g */
    public final /* synthetic */ c4 clone() throws CloneNotSupportedException {
        return (b5) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.y3
    /* renamed from: h */
    public final /* synthetic */ b5 clone() throws CloneNotSupportedException {
        return (b5) clone();
    }

    public final int hashCode() {
        int hashCode = (b5.class.getName().hashCode() + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31;
        String str = this.f23828d;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f23829e;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        z3 z3Var = this.f24111c;
        if (z3Var != null && !z3Var.a()) {
            i10 = this.f24111c.hashCode();
        }
        return hashCode3 + i10;
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final b5 clone() {
        try {
            return (b5) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
