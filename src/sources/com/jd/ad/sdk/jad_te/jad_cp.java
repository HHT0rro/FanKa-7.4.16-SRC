package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_gp.jad_kx;
import com.jd.ad.sdk.jad_kv.jad_tg;
import com.jd.ad.sdk.jad_kv.jad_xk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class jad_cp<T extends Drawable> implements jad_xk<T>, jad_tg {
    public final T jad_an;

    public jad_cp(T t2) {
        this.jad_an = (T) jad_kx.jad_an(t2);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    @NonNull
    public Object get() {
        Drawable.ConstantState constantState = this.jad_an.getConstantState();
        return constantState == null ? this.jad_an : constantState.newDrawable();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_tg
    public void jad_an() {
        Bitmap jad_bo;
        T t2 = this.jad_an;
        if (t2 instanceof BitmapDrawable) {
            jad_bo = ((BitmapDrawable) t2).getBitmap();
        } else if (!(t2 instanceof com.jd.ad.sdk.jad_vg.jad_cp)) {
            return;
        } else {
            jad_bo = ((com.jd.ad.sdk.jad_vg.jad_cp) t2).jad_bo();
        }
        jad_bo.prepareToDraw();
    }
}
