package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzn$zzb implements a1 {
    UNKNOWN(0),
    MOBILE(1),
    TABLET(2),
    DESKTOP(3),
    GOOGLE_HOME(4);

    private static final b1<zzge$zzn$zzb> zzbq = new b1<zzge$zzn$zzb>() { // from class: com.google.android.gms.internal.clearcut.k4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzn$zzb a(int i10) {
            return zzge$zzn$zzb.zzau(i10);
        }
    };
    private final int value;

    zzge$zzn$zzb(int i10) {
        this.value = i10;
    }

    public static zzge$zzn$zzb zzau(int i10) {
        if (i10 == 0) {
            return UNKNOWN;
        }
        if (i10 == 1) {
            return MOBILE;
        }
        if (i10 == 2) {
            return TABLET;
        }
        if (i10 == 3) {
            return DESKTOP;
        }
        if (i10 != 4) {
            return null;
        }
        return GOOGLE_HOME;
    }

    public static b1<zzge$zzn$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
