package com.jd.ad.sdk.jad_ra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_mz;
import com.jd.ad.sdk.jad_js.jad_na;
import com.jd.ad.sdk.jad_js.jad_re;
import com.jd.ad.sdk.jad_mv.jad_qd;
import java.io.IOException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_cp extends jad_an {
    public final Paint jad_do;
    public final Rect jad_ep;
    public final Rect jad_fq;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_gr;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Bitmap, Bitmap> jad_hs;

    public jad_cp(jad_mz jad_mzVar, jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
        this.jad_do = new com.jd.ad.sdk.jad_kt.jad_an(3);
        this.jad_ep = new Rect();
        this.jad_fq = new Rect();
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z10) {
        super.jad_an(rectF, matrix, z10);
        if (jad_ly() != null) {
            rectF.set(0.0f, 0.0f, com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * r3.getWidth(), com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * r3.getHeight());
            this.jad_mz.mapRect(rectF);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t2, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t2, jad_cpVar);
        if (t2 == jad_re.jad_mx) {
            if (jad_cpVar == null) {
                this.jad_gr = null;
                return;
            } else {
                this.jad_gr = new jad_qd(jad_cpVar, null);
                return;
            }
        }
        if (t2 == jad_re.jad_pa) {
            if (jad_cpVar == null) {
                this.jad_hs = null;
            } else {
                this.jad_hs = new jad_qd(jad_cpVar, null);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_bo(@NonNull Canvas canvas, Matrix matrix, int i10) {
        Bitmap jad_ly = jad_ly();
        if (jad_ly == null || jad_ly.isRecycled()) {
            return;
        }
        float jad_an = com.jd.ad.sdk.jad_ve.jad_hu.jad_an();
        this.jad_do.setAlpha(i10);
        com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_anVar = this.jad_gr;
        if (jad_anVar != null) {
            this.jad_do.setColorFilter(jad_anVar.jad_fs());
        }
        canvas.save();
        canvas.concat(matrix);
        this.jad_ep.set(0, 0, jad_ly.getWidth(), jad_ly.getHeight());
        this.jad_fq.set(0, 0, (int) (jad_ly.getWidth() * jad_an), (int) (jad_ly.getHeight() * jad_an));
        canvas.drawBitmap(jad_ly, this.jad_ep, this.jad_fq, this.jad_do);
        canvas.restore();
    }

    @Nullable
    public final Bitmap jad_ly() {
        com.jd.ad.sdk.jad_nw.jad_bo jad_boVar;
        String str;
        Bitmap bitmap;
        Bitmap jad_fs;
        com.jd.ad.sdk.jad_mv.jad_an<Bitmap, Bitmap> jad_anVar = this.jad_hs;
        if (jad_anVar != null && (jad_fs = jad_anVar.jad_fs()) != null) {
            return jad_fs;
        }
        String str2 = this.jad_ob.jad_jt;
        jad_mz jad_mzVar = this.jad_na;
        if (jad_mzVar.getCallback() == null) {
            jad_boVar = null;
        } else {
            com.jd.ad.sdk.jad_nw.jad_bo jad_boVar2 = jad_mzVar.jad_iv;
            if (jad_boVar2 != null) {
                Drawable.Callback callback = jad_mzVar.getCallback();
                Context context = (callback != null && (callback instanceof View)) ? ((View) callback).getContext() : null;
                if (!((context == null && jad_boVar2.jad_an == null) || jad_boVar2.jad_an.equals(context))) {
                    jad_mzVar.jad_iv = null;
                }
            }
            if (jad_mzVar.jad_iv == null) {
                jad_mzVar.jad_iv = new com.jd.ad.sdk.jad_nw.jad_bo(jad_mzVar.getCallback(), jad_mzVar.jad_jw, jad_mzVar.jad_kx, jad_mzVar.jad_bo.jad_dq);
            }
            jad_boVar = jad_mzVar.jad_iv;
        }
        if (jad_boVar != null) {
            jad_na jad_naVar = jad_boVar.jad_dq.get(str2);
            if (jad_naVar == null) {
                return null;
            }
            Bitmap bitmap2 = jad_naVar.jad_er;
            if (bitmap2 != null) {
                return bitmap2;
            }
            com.jd.ad.sdk.jad_js.jad_bo jad_boVar3 = jad_boVar.jad_cp;
            if (jad_boVar3 != null) {
                com.jd.ad.sdk.jad_hu.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_hu.jad_jt) jad_boVar3;
                String str3 = jad_naVar.jad_cp;
                Map map = jad_jtVar.jad_an;
                if (map != null && map.containsKey(str3)) {
                    bitmap = (Bitmap) jad_jtVar.jad_an.get(str3);
                } else {
                    Bitmap[] bitmapArr = {null};
                    try {
                        com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(jad_jtVar.jad_bo).jad_er().jad_an(jad_naVar.jad_dq).jad_an((com.jd.ad.sdk.jad_ep.jad_iv<Bitmap>) new com.jd.ad.sdk.jad_hu.jad_fs(jad_jtVar, jad_naVar, bitmapArr));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    bitmap = bitmapArr[0];
                }
                Bitmap bitmap3 = bitmap;
                if (bitmap3 == null) {
                    return bitmap3;
                }
                jad_boVar.jad_an(str2, bitmap3);
                return bitmap3;
            }
            String str4 = jad_naVar.jad_dq;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            if (str4.startsWith("data:") && str4.indexOf("base64,") > 0) {
                try {
                    byte[] decode = Base64.decode(str4.substring(str4.indexOf(44) + 1), 0);
                    return jad_boVar.jad_an(str2, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                } catch (IllegalArgumentException e10) {
                    com.jd.ad.sdk.jad_ve.jad_dq.jad_an("data URL did not have correct base64 format.", e10);
                    return null;
                }
            }
            try {
                if (TextUtils.isEmpty(jad_boVar.jad_bo)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(jad_boVar.jad_an.getAssets().open(jad_boVar.jad_bo + str4), null, options);
                    int i10 = jad_naVar.jad_an;
                    int i11 = jad_naVar.jad_bo;
                    ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_ve.jad_hu.jad_an;
                    if (decodeStream.getWidth() != i10 || decodeStream.getHeight() != i11) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i10, i11, true);
                        decodeStream.recycle();
                        decodeStream = createScaledBitmap;
                    }
                    return jad_boVar.jad_an(str2, decodeStream);
                } catch (IllegalArgumentException e11) {
                    e = e11;
                    str = "Unable to decode image.";
                    com.jd.ad.sdk.jad_ve.jad_dq.jad_an(str, e);
                    return null;
                }
            } catch (IOException e12) {
                e = e12;
                str = "Unable to open asset.";
            }
        } else {
            com.jd.ad.sdk.jad_js.jad_jt jad_jtVar2 = jad_mzVar.jad_bo;
            jad_na jad_naVar2 = jad_jtVar2 == null ? null : jad_jtVar2.jad_dq.get(str2);
            if (jad_naVar2 != null) {
                return jad_naVar2.jad_er;
            }
            return null;
        }
    }
}
