package com.jd.ad.sdk.jad_it;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface jad_dq<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface jad_an<T> {
        void jad_an(@NonNull Exception exc);

        void jad_an(@Nullable T t2);
    }

    @NonNull
    Class<T> jad_an();

    void jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, @NonNull jad_an<? super T> jad_anVar);

    void jad_bo();

    void jad_cp();

    @NonNull
    com.jd.ad.sdk.jad_hs.jad_an jad_dq();
}
