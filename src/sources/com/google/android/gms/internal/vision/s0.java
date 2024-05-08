package com.google.android.gms.internal.vision;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s0 {
    public static <T> q0<T> a(q0<T> q0Var) {
        if ((q0Var instanceof t0) || (q0Var instanceof zzdh)) {
            return q0Var;
        }
        if (q0Var instanceof Serializable) {
            return new zzdh(q0Var);
        }
        return new t0(q0Var);
    }
}
