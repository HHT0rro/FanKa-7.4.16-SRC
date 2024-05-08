package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzie implements h1 {
    UNKNOWN_FORMAT(0),
    NV16(1),
    NV21(2),
    YV12(3),
    YUV_420_888(7),
    JPEG(8),
    BITMAP(4),
    CM_SAMPLE_BUFFER_REF(5),
    UI_IMAGE(6);

    private final int zzj;

    zzie(int i10) {
        this.zzj = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.h1
    public final int zza() {
        return this.zzj;
    }
}
