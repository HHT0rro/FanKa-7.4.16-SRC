package com.jd.ad.sdk.jad_fs;

import androidx.annotation.NonNull;

/* compiled from: MoveEntity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_dq implements Cloneable {
    public final long jad_an;
    public final int jad_bo;
    public final int jad_cp;

    public jad_dq(int i10, int i11, long j10) {
        this.jad_bo = i10;
        this.jad_cp = i11;
        this.jad_an = j10;
    }

    @NonNull
    public Object clone() {
        return new jad_dq(this.jad_bo, this.jad_cp, this.jad_an);
    }
}
