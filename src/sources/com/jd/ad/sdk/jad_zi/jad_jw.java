package com.jd.ad.sdk.jad_zi;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_jw {
    public final byte[] jad_an;
    public int jad_bo;
    public int jad_cp;
    public boolean jad_dq;
    public boolean jad_er;
    public jad_jw jad_fs;
    public jad_jw jad_jt;

    public jad_jw() {
        this.jad_an = new byte[8192];
        this.jad_er = true;
        this.jad_dq = false;
    }

    public jad_jw(byte[] bArr, int i10, int i11, boolean z10, boolean z11) {
        this.jad_an = bArr;
        this.jad_bo = i10;
        this.jad_cp = i11;
        this.jad_dq = z10;
        this.jad_er = z11;
    }

    @Nullable
    public final jad_jw jad_an() {
        jad_jw jad_jwVar = this.jad_fs;
        jad_jw jad_jwVar2 = jad_jwVar != this ? jad_jwVar : null;
        jad_jw jad_jwVar3 = this.jad_jt;
        jad_jwVar3.jad_fs = jad_jwVar;
        this.jad_fs.jad_jt = jad_jwVar3;
        this.jad_fs = null;
        this.jad_jt = null;
        return jad_jwVar2;
    }

    public final jad_jw jad_an(jad_jw jad_jwVar) {
        jad_jwVar.jad_jt = this;
        jad_jwVar.jad_fs = this.jad_fs;
        this.jad_fs.jad_jt = jad_jwVar;
        this.jad_fs = jad_jwVar;
        return jad_jwVar;
    }

    public final void jad_an(jad_jw jad_jwVar, int i10) {
        if (!jad_jwVar.jad_er) {
            throw new IllegalArgumentException();
        }
        int i11 = jad_jwVar.jad_cp;
        int i12 = i11 + i10;
        if (i12 > 8192) {
            if (jad_jwVar.jad_dq) {
                throw new IllegalArgumentException();
            }
            int i13 = jad_jwVar.jad_bo;
            if (i12 - i13 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jad_jwVar.jad_an;
            System.arraycopy((Object) bArr, i13, (Object) bArr, 0, i11 - i13);
            jad_jwVar.jad_cp -= jad_jwVar.jad_bo;
            jad_jwVar.jad_bo = 0;
        }
        System.arraycopy((Object) this.jad_an, this.jad_bo, (Object) jad_jwVar.jad_an, jad_jwVar.jad_cp, i10);
        jad_jwVar.jad_cp += i10;
        this.jad_bo += i10;
    }

    public final jad_jw jad_bo() {
        this.jad_dq = true;
        return new jad_jw(this.jad_an, this.jad_bo, this.jad_cp, true, false);
    }
}
