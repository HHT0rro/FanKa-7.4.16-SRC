package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzbw implements a5 {
    RGBA(0),
    NV12(5),
    NV21(1),
    YV12(6),
    YV21(7),
    RGB(2),
    GRAY(3),
    GRAY16(4);

    private static final d5<zzbw> zzi = new d5<zzbw>() { // from class: com.google.android.gms.internal.vision.u
    };
    private final int zzj;

    zzbw(int i10) {
        this.zzj = i10;
    }

    public static c5 zzb() {
        return t.f25639a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzbw.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzj + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.vision.a5
    public final int zza() {
        return this.zzj;
    }

    public static zzbw zza(int i10) {
        switch (i10) {
            case 0:
                return RGBA;
            case 1:
                return NV21;
            case 2:
                return RGB;
            case 3:
                return GRAY;
            case 4:
                return GRAY16;
            case 5:
                return NV12;
            case 6:
                return YV12;
            case 7:
                return YV21;
            default:
                return null;
        }
    }
}
