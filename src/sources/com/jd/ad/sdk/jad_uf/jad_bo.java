package com.jd.ad.sdk.jad_uf;

import com.jd.ad.sdk.jad_kv.jad_xk;
import java.io.File;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_bo implements jad_xk<File> {
    public final File jad_an;

    public jad_bo(File file) {
        Objects.requireNonNull(file, "Argument must not be null");
        this.jad_an = file;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public final File get() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public final /* bridge */ /* synthetic */ int jad_bo() {
        return 1;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public Class<File> jad_cp() {
        return this.jad_an.getClass();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_xk
    public /* bridge */ /* synthetic */ void jad_dq() {
    }
}
