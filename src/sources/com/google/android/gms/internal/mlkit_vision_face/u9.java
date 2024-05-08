package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u9 {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f25248d;

    /* renamed from: a, reason: collision with root package name */
    public final String f25249a;

    /* renamed from: b, reason: collision with root package name */
    public final t9 f25250b;

    /* renamed from: c, reason: collision with root package name */
    public t9 f25251c;

    public /* synthetic */ u9(String str, s9 s9Var) {
        t9 t9Var = new t9(null);
        this.f25250b = t9Var;
        this.f25251c = t9Var;
        if (!f25248d) {
            synchronized (u9.class) {
                if (!f25248d) {
                    f25248d = true;
                }
            }
        }
        this.f25249a = str;
    }

    public final u9 a(String str, @NullableDecl Object obj) {
        e(str, obj);
        return this;
    }

    public final u9 b(String str, boolean z10) {
        e("trackingEnabled", String.valueOf(z10));
        return this;
    }

    public final u9 c(String str, float f10) {
        e(str, String.valueOf(f10));
        return this;
    }

    public final u9 d(String str, int i10) {
        e(str, String.valueOf(i10));
        return this;
    }

    public final u9 e(String str, @NullableDecl Object obj) {
        t9 t9Var = new t9(null);
        this.f25251c.f25232c = t9Var;
        this.f25251c = t9Var;
        t9Var.f25231b = obj;
        Objects.requireNonNull(str);
        t9Var.f25230a = str;
        return this;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.f25249a);
        sb2.append('{');
        t9 t9Var = this.f25250b.f25232c;
        String str = "";
        while (t9Var != null) {
            Object obj = t9Var.f25231b;
            sb2.append(str);
            String str2 = t9Var.f25230a;
            if (str2 != null) {
                sb2.append(str2);
                sb2.append('=');
            }
            if (obj != null && obj.getClass().isArray()) {
                sb2.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            } else {
                sb2.append(obj);
            }
            t9Var = t9Var.f25232c;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }
}
