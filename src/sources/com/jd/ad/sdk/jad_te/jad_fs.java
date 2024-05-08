package com.jd.ad.sdk.jad_te;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_hs.jad_ly;
import com.jd.ad.sdk.jad_kv.jad_xk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_fs implements jad_ly<Drawable, Drawable> {
    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    @Nullable
    public jad_xk<Drawable> jad_an(@NonNull Drawable drawable, int i10, int i11, @NonNull jad_jw jad_jwVar) {
        Drawable drawable2 = drawable;
        if (drawable2 != null) {
            return new jad_dq(drawable2);
        }
        return null;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull Drawable drawable, @NonNull jad_jw jad_jwVar) {
        return true;
    }
}
