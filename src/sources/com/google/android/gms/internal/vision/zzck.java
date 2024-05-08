package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzck implements a5 {
    CLASSIFICATION_TYPE_UNKNOWN(0),
    NO_CLASSIFICATION(1),
    ALL_CLASSIFICATIONS(2);

    private static final d5<zzck> zzd = new d5<zzck>() { // from class: com.google.android.gms.internal.vision.c0
    };
    private final int zze;

    zzck(int i10) {
        this.zze = i10;
    }

    public static c5 zzb() {
        return b0.f25432a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzck.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.vision.a5
    public final int zza() {
        return this.zze;
    }

    public static zzck zza(int i10) {
        if (i10 == 0) {
            return CLASSIFICATION_TYPE_UNKNOWN;
        }
        if (i10 == 1) {
            return NO_CLASSIFICATION;
        }
        if (i10 != 2) {
            return null;
        }
        return ALL_CLASSIFICATIONS;
    }
}
