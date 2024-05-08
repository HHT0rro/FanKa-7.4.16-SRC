package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.InputStream;

@RequiresApi(api = 28)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_pc implements com.jd.ad.sdk.jad_hs.jad_ly<InputStream, Bitmap> {
    public final jad_dq jad_an = new jad_dq();

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(@NonNull InputStream inputStream, int i10, int i11, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return this.jad_an.jad_an(ImageDecoder.createSource(com.jd.ad.sdk.jad_gp.jad_an.jad_an(inputStream)), i10, i11, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull InputStream inputStream, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return true;
    }
}
