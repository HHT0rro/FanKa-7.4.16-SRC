package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzgn {
    UNKNOWN(0),
    TRANSLATE(1);

    private final int zzc;

    zzgn(int i10) {
        this.zzc = i10;
    }

    public static zzgn zzb(int i10) {
        for (zzgn zzgnVar : values()) {
            if (zzgnVar.zzc == i10) {
                return zzgnVar;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.zzc;
    }
}
