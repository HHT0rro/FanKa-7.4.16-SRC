package com.jd.ad.sdk.jad_bm;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_al.jad_jw;
import com.jd.ad.sdk.jad_gp.jad_ly;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class jad_an<T> implements jad_er<T> {
    public final int jad_an;
    public final int jad_bo;

    @Nullable
    public com.jd.ad.sdk.jad_al.jad_dq jad_cp;

    public jad_an() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public jad_an(int i10, int i11) {
        if (jad_ly.jad_bo(i10, i11)) {
            this.jad_an = i10;
            this.jad_bo = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_an() {
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public final void jad_an(@Nullable com.jd.ad.sdk.jad_al.jad_dq jad_dqVar) {
        this.jad_cp = jad_dqVar;
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public final void jad_an(@NonNull jad_dq jad_dqVar) {
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    @Nullable
    public final com.jd.ad.sdk.jad_al.jad_dq jad_bo() {
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public void jad_bo(@Nullable Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public final void jad_bo(@NonNull jad_dq jad_dqVar) {
        ((jad_jw) jad_dqVar).jad_an(this.jad_an, this.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_cp() {
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public void jad_cp(@Nullable Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_xi.jad_mz
    public void jad_dq() {
    }
}
