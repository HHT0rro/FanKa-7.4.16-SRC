package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzw$zzb implements a1 {
    UNKNOWN(0),
    ANDROID_CARDBOARD_SDK(1),
    IOS_CARDBOARD_SDK(2),
    ANDROID_UNITY_SDK(3),
    IOS_UNITY_SDK(4),
    WINDOWS(5);

    private static final b1<zzge$zzw$zzb> zzbq = new b1<zzge$zzw$zzb>() { // from class: com.google.android.gms.internal.clearcut.t4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzw$zzb a(int i10) {
            return zzge$zzw$zzb.zzbd(i10);
        }
    };
    private final int value;

    zzge$zzw$zzb(int i10) {
        this.value = i10;
    }

    public static zzge$zzw$zzb zzbd(int i10) {
        if (i10 == 0) {
            return UNKNOWN;
        }
        if (i10 == 1) {
            return ANDROID_CARDBOARD_SDK;
        }
        if (i10 == 2) {
            return IOS_CARDBOARD_SDK;
        }
        if (i10 == 3) {
            return ANDROID_UNITY_SDK;
        }
        if (i10 == 4) {
            return IOS_UNITY_SDK;
        }
        if (i10 != 5) {
            return null;
        }
        return WINDOWS;
    }

    public static b1<zzge$zzw$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
