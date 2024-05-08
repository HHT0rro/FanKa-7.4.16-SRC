package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zze$zzb implements a1 {
    CLIENT_UNKNOWN(0),
    CHIRP(1),
    WAYMO(2),
    GV_ANDROID(3),
    GV_IOS(4);

    private static final b1<zzge$zze$zzb> zzbq = new b1<zzge$zze$zzb>() { // from class: com.google.android.gms.internal.clearcut.h4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zze$zzb a(int i10) {
            return zzge$zze$zzb.zzar(i10);
        }
    };
    private final int value;

    zzge$zze$zzb(int i10) {
        this.value = i10;
    }

    public static zzge$zze$zzb zzar(int i10) {
        if (i10 == 0) {
            return CLIENT_UNKNOWN;
        }
        if (i10 == 1) {
            return CHIRP;
        }
        if (i10 == 2) {
            return WAYMO;
        }
        if (i10 == 3) {
            return GV_ANDROID;
        }
        if (i10 != 4) {
            return null;
        }
        return GV_IOS;
    }

    public static b1<zzge$zze$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
