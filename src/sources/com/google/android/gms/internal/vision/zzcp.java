package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzcp implements a5 {
    LANDMARK_TYPE_UNKNOWN(0),
    NO_LANDMARK(1),
    ALL_LANDMARKS(2),
    CONTOUR_LANDMARKS(3);

    private static final d5<zzcp> zze = new d5<zzcp>() { // from class: com.google.android.gms.internal.vision.g0
    };
    private final int zzf;

    zzcp(int i10) {
        this.zzf = i10;
    }

    public static c5 zzb() {
        return f0.f25460a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcp.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.vision.a5
    public final int zza() {
        return this.zzf;
    }

    public static zzcp zza(int i10) {
        if (i10 == 0) {
            return LANDMARK_TYPE_UNKNOWN;
        }
        if (i10 == 1) {
            return NO_LANDMARK;
        }
        if (i10 == 2) {
            return ALL_LANDMARKS;
        }
        if (i10 != 3) {
            return null;
        }
        return CONTOUR_LANDMARKS;
    }
}
