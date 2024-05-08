package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r0 {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f24196d;

    /* renamed from: a, reason: collision with root package name */
    public final String f24197a;

    /* renamed from: b, reason: collision with root package name */
    public final q0 f24198b;

    /* renamed from: c, reason: collision with root package name */
    public q0 f24199c;

    public /* synthetic */ r0(String str, p0 p0Var) {
        q0 q0Var = new q0(null);
        this.f24198b = q0Var;
        this.f24199c = q0Var;
        if (!f24196d) {
            synchronized (r0.class) {
                if (!f24196d) {
                    f24196d = true;
                }
            }
        }
        Objects.requireNonNull(str);
        this.f24197a = str;
    }

    public final r0 a(String str, @NullableDecl Object obj) {
        c(str, obj);
        return this;
    }

    public final r0 b(String str, boolean z10) {
        c("isManifestFile", String.valueOf(z10));
        return this;
    }

    public final r0 c(String str, @NullableDecl Object obj) {
        q0 q0Var = new q0(null);
        this.f24199c.f24194c = q0Var;
        this.f24199c = q0Var;
        q0Var.f24193b = obj;
        q0Var.f24192a = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.f24197a);
        sb2.append('{');
        q0 q0Var = this.f24198b.f24194c;
        String str = "";
        while (q0Var != null) {
            Object obj = q0Var.f24193b;
            sb2.append(str);
            String str2 = q0Var.f24192a;
            if (str2 != null) {
                sb2.append(str2);
                sb2.append('=');
            }
            if (obj != null && obj.getClass().isArray()) {
                sb2.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            } else {
                sb2.append(obj);
            }
            q0Var = q0Var.f24194c;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }
}
