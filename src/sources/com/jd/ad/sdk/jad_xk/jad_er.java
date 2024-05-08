package com.jd.ad.sdk.jad_xk;

import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_er {
    public final byte[] jad_an;

    public jad_er(byte[] bArr) {
        this(bArr, Charset.forName("UTF-8"));
    }

    public jad_er(byte[] bArr, Charset charset) {
        this(bArr, charset, "application/stream");
    }

    public jad_er(byte[] bArr, Charset charset, String str) {
        this.jad_an = bArr;
    }
}
