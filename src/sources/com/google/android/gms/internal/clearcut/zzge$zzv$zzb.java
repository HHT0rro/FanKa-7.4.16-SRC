package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzv$zzb implements a1 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4);

    private static final b1<zzge$zzv$zzb> zzbq = new b1<zzge$zzv$zzb>() { // from class: com.google.android.gms.internal.clearcut.s4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzv$zzb a(int i10) {
            return zzge$zzv$zzb.zzbc(i10);
        }
    };
    private final int value;

    zzge$zzv$zzb(int i10) {
        this.value = i10;
    }

    public static zzge$zzv$zzb zzbc(int i10) {
        if (i10 == 0) {
            return DEFAULT;
        }
        if (i10 == 1) {
            return UNMETERED_ONLY;
        }
        if (i10 == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i10 == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i10 != 4) {
            return null;
        }
        return NEVER;
    }

    public static b1<zzge$zzv$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
