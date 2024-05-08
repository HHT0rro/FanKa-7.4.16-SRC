package com.jd.ad.sdk.jad_ox;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_bo {
    public final String jad_an;
    public final String jad_bo;
    public final float jad_cp;
    public final int jad_dq;
    public final int jad_er;
    public final float jad_fs;

    @ColorInt
    public final int jad_hu;

    @ColorInt
    public final int jad_iv;
    public final float jad_jt;
    public final float jad_jw;
    public final boolean jad_kx;

    public jad_bo(String str, String str2, float f10, int i10, int i11, float f11, float f12, @ColorInt int i12, @ColorInt int i13, float f13, boolean z10) {
        this.jad_an = str;
        this.jad_bo = str2;
        this.jad_cp = f10;
        this.jad_dq = i10;
        this.jad_er = i11;
        this.jad_fs = f11;
        this.jad_jt = f12;
        this.jad_hu = i12;
        this.jad_iv = i13;
        this.jad_jw = f13;
        this.jad_kx = z10;
    }

    public int hashCode() {
        int jad_an = ((com.jd.ad.sdk.jad_jt.jad_fs.jad_an(this.jad_dq) + (((int) (((this.jad_bo.hashCode() + (this.jad_an.hashCode() * 31)) * 31) + this.jad_cp)) * 31)) * 31) + this.jad_er;
        long floatToRawIntBits = Float.floatToRawIntBits(this.jad_fs);
        return (((jad_an * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.jad_hu;
    }
}
