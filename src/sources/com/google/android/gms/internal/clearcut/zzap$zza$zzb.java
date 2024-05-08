package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzap$zza$zzb implements a1 {
    UNKNOWN(0),
    ON(1),
    OFF(2);

    private static final b1<zzap$zza$zzb> zzbq = new b1<zzap$zza$zzb>() { // from class: com.google.android.gms.internal.clearcut.p
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzap$zza$zzb a(int i10) {
            return zzap$zza$zzb.zze(i10);
        }
    };
    private final int value;

    zzap$zza$zzb(int i10) {
        this.value = i10;
    }

    public static b1<zzap$zza$zzb> zzd() {
        return zzbq;
    }

    public static zzap$zza$zzb zze(int i10) {
        if (i10 == 0) {
            return UNKNOWN;
        }
        if (i10 == 1) {
            return ON;
        }
        if (i10 != 2) {
            return null;
        }
        return OFF;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
