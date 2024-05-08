package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzct implements a5 {
    MODE_TYPE_UNKNOWN(0),
    FAST(1),
    ACCURATE(2),
    SELFIE(3);

    private static final d5<zzct> zze = new d5<zzct>() { // from class: com.google.android.gms.internal.vision.h0
    };
    private final int zzf;

    zzct(int i10) {
        this.zzf = i10;
    }

    public static c5 zzb() {
        return i0.f25511a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzct.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.vision.a5
    public final int zza() {
        return this.zzf;
    }

    public static zzct zza(int i10) {
        if (i10 == 0) {
            return MODE_TYPE_UNKNOWN;
        }
        if (i10 == 1) {
            return FAST;
        }
        if (i10 == 2) {
            return ACCURATE;
        }
        if (i10 != 3) {
            return null;
        }
        return SELFIE;
    }
}
