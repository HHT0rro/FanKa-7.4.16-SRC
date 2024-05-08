package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzff implements j {
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

    zzff(int i10) {
        this.zzj = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.j
    public final int zza() {
        return this.zzj;
    }
}
