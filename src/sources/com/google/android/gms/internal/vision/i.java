package com.google.android.gms.internal.vision;

import android.content.Context;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i extends q {

    /* renamed from: a, reason: collision with root package name */
    public final Context f25509a;

    /* renamed from: b, reason: collision with root package name */
    public final q0<zzcy<k>> f25510b;

    public i(Context context, q0<zzcy<k>> q0Var) {
        Objects.requireNonNull(context, "Null context");
        this.f25509a = context;
        this.f25510b = q0Var;
    }

    @Override // com.google.android.gms.internal.vision.q
    public final Context a() {
        return this.f25509a;
    }

    @Override // com.google.android.gms.internal.vision.q
    public final q0<zzcy<k>> b() {
        return this.f25510b;
    }

    public final boolean equals(Object obj) {
        q0<zzcy<k>> q0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f25509a.equals(qVar.a()) && ((q0Var = this.f25510b) != null ? q0Var.equals(qVar.b()) : qVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f25509a.hashCode() ^ 1000003) * 1000003;
        q0<zzcy<k>> q0Var = this.f25510b;
        return hashCode ^ (q0Var == null ? 0 : q0Var.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f25509a);
        String valueOf2 = String.valueOf(this.f25510b);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 46 + valueOf2.length());
        sb2.append("FlagsContext{context=");
        sb2.append(valueOf);
        sb2.append(", hermeticFileOverrides=");
        sb2.append(valueOf2);
        sb2.append(com.alipay.sdk.util.i.f4738d);
        return sb2.toString();
    }
}
