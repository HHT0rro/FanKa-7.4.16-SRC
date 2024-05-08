package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzt$zza$zzb implements a1 {
    ARCH_UNKNOWN(0),
    ARCH_NON_NATIVE(1),
    ARCH_ARMV5(2),
    ARCH_ARMV7(4),
    ARCH_ARM64(5),
    ARCH_MIPS(6),
    ARCH_MIPS_64(7),
    ARCH_X86(8),
    ARCH_X86_64(9);

    private static final b1<zzt$zza$zzb> zzbq = new b1<zzt$zza$zzb>() { // from class: com.google.android.gms.internal.clearcut.h5
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzt$zza$zzb a(int i10) {
            return zzt$zza$zzb.zza(i10);
        }
    };
    private final int value;

    zzt$zza$zzb(int i10) {
        this.value = i10;
    }

    public static zzt$zza$zzb zza(int i10) {
        switch (i10) {
            case 0:
                return ARCH_UNKNOWN;
            case 1:
                return ARCH_NON_NATIVE;
            case 2:
                return ARCH_ARMV5;
            case 3:
            default:
                return null;
            case 4:
                return ARCH_ARMV7;
            case 5:
                return ARCH_ARM64;
            case 6:
                return ARCH_MIPS;
            case 7:
                return ARCH_MIPS_64;
            case 8:
                return ARCH_X86;
            case 9:
                return ARCH_X86_64;
        }
    }

    public static b1<zzt$zza$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
