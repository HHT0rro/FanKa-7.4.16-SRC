package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzo$zzb implements a1 {
    NONE(0),
    WALL_CLOCK_SET(1),
    DEVICE_BOOT(2);

    private static final b1<zzge$zzo$zzb> zzbq = new b1<zzge$zzo$zzb>() { // from class: com.google.android.gms.internal.clearcut.m4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzo$zzb a(int i10) {
            return zzge$zzo$zzb.zzaw(i10);
        }
    };
    private final int value;

    zzge$zzo$zzb(int i10) {
        this.value = i10;
    }

    public static zzge$zzo$zzb zzaw(int i10) {
        if (i10 == 0) {
            return NONE;
        }
        if (i10 == 1) {
            return WALL_CLOCK_SET;
        }
        if (i10 != 2) {
            return null;
        }
        return DEVICE_BOOT;
    }

    public static b1<zzge$zzo$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
