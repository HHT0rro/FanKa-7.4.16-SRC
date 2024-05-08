package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzgt$zza$zzb implements a1 {
    NO_RESTRICTION(0),
    SIDEWINDER_DEVICE(1),
    LATCHSKY_DEVICE(2);

    private static final b1<zzgt$zza$zzb> zzbq = new b1<zzgt$zza$zzb>() { // from class: com.google.android.gms.internal.clearcut.u4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzgt$zza$zzb a(int i10) {
            return zzgt$zza$zzb.zzbe(i10);
        }
    };
    private final int value;

    zzgt$zza$zzb(int i10) {
        this.value = i10;
    }

    public static zzgt$zza$zzb zzbe(int i10) {
        if (i10 == 0) {
            return NO_RESTRICTION;
        }
        if (i10 == 1) {
            return SIDEWINDER_DEVICE;
        }
        if (i10 != 2) {
            return null;
        }
        return LATCHSKY_DEVICE;
    }

    public static b1<zzgt$zza$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
