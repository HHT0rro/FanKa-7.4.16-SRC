package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzj$zza implements a1 {
    UNKNOWN(0),
    AUTO_TIME_OFF(1),
    AUTO_TIME_ON(2);

    private static final b1<zzge$zzj$zza> zzbq = new b1<zzge$zzj$zza>() { // from class: com.google.android.gms.internal.clearcut.j4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzj$zza a(int i10) {
            return zzge$zzj$zza.zzat(i10);
        }
    };
    private final int value;

    zzge$zzj$zza(int i10) {
        this.value = i10;
    }

    public static zzge$zzj$zza zzat(int i10) {
        if (i10 == 0) {
            return UNKNOWN;
        }
        if (i10 == 1) {
            return AUTO_TIME_OFF;
        }
        if (i10 != 2) {
            return null;
        }
        return AUTO_TIME_ON;
    }

    public static b1<zzge$zzj$zza> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
