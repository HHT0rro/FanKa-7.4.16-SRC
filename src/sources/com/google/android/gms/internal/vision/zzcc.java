package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzcc implements a5 {
    ROTATION_0(0),
    ROTATION_90(1),
    ROTATION_180(2),
    ROTATION_270(3);

    private static final d5<zzcc> zze = new d5<zzcc>() { // from class: com.google.android.gms.internal.vision.z
    };
    private final int zzf;

    zzcc(int i10) {
        this.zzf = i10;
    }

    public static c5 zzb() {
        return y.f25703a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.vision.a5
    public final int zza() {
        return this.zzf;
    }

    public static zzcc zza(int i10) {
        if (i10 == 0) {
            return ROTATION_0;
        }
        if (i10 == 1) {
            return ROTATION_90;
        }
        if (i10 == 2) {
            return ROTATION_180;
        }
        if (i10 != 3) {
            return null;
        }
        return ROTATION_270;
    }
}
