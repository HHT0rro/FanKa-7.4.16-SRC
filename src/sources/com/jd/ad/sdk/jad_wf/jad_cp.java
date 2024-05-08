package com.jd.ad.sdk.jad_wf;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_cp<T> {
    public final jad_bo<T> jad_an;

    @Nullable
    public T jad_bo;

    public jad_cp() {
        this.jad_an = new jad_bo<>();
        this.jad_bo = null;
    }

    public jad_cp(@Nullable T t2) {
        this.jad_an = new jad_bo<>();
        this.jad_bo = t2;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T jad_an(float f10, float f11, T t2, T t10, float f12, float f13, float f14) {
        jad_bo<T> jad_boVar = this.jad_an;
        jad_boVar.jad_an = t2;
        jad_boVar.jad_bo = t10;
        return jad_an(jad_boVar);
    }

    @Nullable
    public T jad_an(jad_bo<T> jad_boVar) {
        return this.jad_bo;
    }
}
