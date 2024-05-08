package com.google.android.gms.internal.clearcut;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y4 extends y3<y4> implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public byte[] f24112d = e4.f23880h;

    /* renamed from: e, reason: collision with root package name */
    public String f24113e = "";

    /* renamed from: f, reason: collision with root package name */
    public byte[][] f24114f = e4.f23879g;

    /* renamed from: g, reason: collision with root package name */
    public boolean f24115g = false;

    public y4() {
        this.f24111c = null;
        this.f23837b = -1;
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final void a(x3 x3Var) throws IOException {
        if (!Arrays.equals(this.f24112d, e4.f23880h)) {
            x3Var.d(1, this.f24112d);
        }
        byte[][] bArr = this.f24114f;
        if (bArr != null && bArr.length > 0) {
            int i10 = 0;
            while (true) {
                byte[][] bArr2 = this.f24114f;
                if (i10 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i10];
                if (bArr3 != null) {
                    x3Var.d(2, bArr3);
                }
                i10++;
            }
        }
        String str = this.f24113e;
        if (str != null && !str.equals("")) {
            x3Var.c(4, this.f24113e);
        }
        super.a(x3Var);
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    public final int e() {
        int e2 = super.e();
        if (!Arrays.equals(this.f24112d, e4.f23880h)) {
            e2 += x3.i(1, this.f24112d);
        }
        byte[][] bArr = this.f24114f;
        if (bArr != null && bArr.length > 0) {
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                byte[][] bArr2 = this.f24114f;
                if (i10 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i10];
                if (bArr3 != null) {
                    i12++;
                    i11 += x3.s(bArr3);
                }
                i10++;
            }
            e2 = e2 + i11 + (i12 * 1);
        }
        String str = this.f24113e;
        return (str == null || str.equals("")) ? e2 : e2 + x3.h(4, this.f24113e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y4)) {
            return false;
        }
        y4 y4Var = (y4) obj;
        if (!Arrays.equals(this.f24112d, y4Var.f24112d)) {
            return false;
        }
        String str = this.f24113e;
        if (str == null) {
            if (y4Var.f24113e != null) {
                return false;
            }
        } else if (!str.equals(y4Var.f24113e)) {
            return false;
        }
        if (!b4.i(this.f24114f, y4Var.f24114f)) {
            return false;
        }
        z3 z3Var = this.f24111c;
        if (z3Var != null && !z3Var.a()) {
            return this.f24111c.equals(y4Var.f24111c);
        }
        z3 z3Var2 = y4Var.f24111c;
        return z3Var2 == null || z3Var2.a();
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: g */
    public final /* synthetic */ c4 clone() throws CloneNotSupportedException {
        return (y4) clone();
    }

    @Override // com.google.android.gms.internal.clearcut.y3
    /* renamed from: h */
    public final /* synthetic */ y4 clone() throws CloneNotSupportedException {
        return (y4) clone();
    }

    public final int hashCode() {
        int hashCode = (((y4.class.getName().hashCode() + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE) * 31) + Arrays.hashCode(this.f24112d)) * 31;
        String str = this.f24113e;
        int i10 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + b4.g(this.f24114f)) * 31) + MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT) * 31;
        z3 z3Var = this.f24111c;
        if (z3Var != null && !z3Var.a()) {
            i10 = this.f24111c.hashCode();
        }
        return hashCode2 + i10;
    }

    @Override // com.google.android.gms.internal.clearcut.y3, com.google.android.gms.internal.clearcut.c4
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final y4 clone() {
        try {
            y4 y4Var = (y4) super.clone();
            byte[][] bArr = this.f24114f;
            if (bArr != null && bArr.length > 0) {
                y4Var.f24114f = (byte[][]) bArr.clone();
            }
            return y4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
