package com.jd.ad.sdk.jad_lw;

import com.alimm.tanx.ui.image.glide.util.ByteArrayPool;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_jt implements jad_an<byte[]> {
    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public int jad_an(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public String jad_an() {
        return ByteArrayPool.TAG;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public int jad_bo() {
        return 1;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public byte[] newArray(int i10) {
        return new byte[i10];
    }
}
