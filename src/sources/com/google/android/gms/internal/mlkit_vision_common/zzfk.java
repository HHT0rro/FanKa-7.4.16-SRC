package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzfk implements j {
    SOURCE_UNKNOWN(0),
    BITMAP(1),
    BYTEARRAY(2),
    BYTEBUFFER(3),
    FILEPATH(4),
    ANDROID_MEDIA_IMAGE(5);

    private final int zzg;

    zzfk(int i10) {
        this.zzg = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.j
    public final int zza() {
        return this.zzg;
    }
}
