package com.google.android.gms.internal.mlkit_vision_face;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i9 {
    public static p6 a(int i10, int i11) {
        zzie zzieVar;
        o6 o6Var = new o6();
        if (i10 == -1) {
            zzieVar = zzie.BITMAP;
        } else if (i10 == 35) {
            zzieVar = zzie.YUV_420_888;
        } else if (i10 == 842094169) {
            zzieVar = zzie.YV12;
        } else if (i10 == 16) {
            zzieVar = zzie.NV16;
        } else if (i10 != 17) {
            zzieVar = zzie.UNKNOWN_FORMAT;
        } else {
            zzieVar = zzie.NV21;
        }
        o6Var.a(zzieVar);
        o6Var.b(Integer.valueOf(i11));
        return o6Var.c();
    }
}
