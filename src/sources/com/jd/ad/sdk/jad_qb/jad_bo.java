package com.jd.ad.sdk.jad_qb;

import android.content.Context;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_hs.jad_na;
import com.jd.ad.sdk.jad_kv.jad_xk;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_bo<T> implements jad_na<T> {
    public static final jad_na<?> jad_bo = new jad_bo();

    @Override // com.jd.ad.sdk.jad_hs.jad_na
    @NonNull
    public jad_xk<T> jad_an(@NonNull Context context, @NonNull jad_xk<T> jad_xkVar, int i10, int i11) {
        return jad_xkVar;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
    }
}
