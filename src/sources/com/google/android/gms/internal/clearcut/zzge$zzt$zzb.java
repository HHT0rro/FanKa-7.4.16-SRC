package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzt$zzb implements a1 {
    OS_TYPE_UNKNOWN(0),
    OS_TYPE_MAC(1),
    OS_TYPE_WINDOWS(2),
    OS_TYPE_ANDROID(3),
    OS_TYPE_CROS(4),
    OS_TYPE_LINUX(5),
    OS_TYPE_OPENBSD(6);

    private static final b1<zzge$zzt$zzb> zzbq = new b1<zzge$zzt$zzb>() { // from class: com.google.android.gms.internal.clearcut.r4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzt$zzb a(int i10) {
            return zzge$zzt$zzb.zzbb(i10);
        }
    };
    private final int value;

    zzge$zzt$zzb(int i10) {
        this.value = i10;
    }

    public static zzge$zzt$zzb zzbb(int i10) {
        switch (i10) {
            case 0:
                return OS_TYPE_UNKNOWN;
            case 1:
                return OS_TYPE_MAC;
            case 2:
                return OS_TYPE_WINDOWS;
            case 3:
                return OS_TYPE_ANDROID;
            case 4:
                return OS_TYPE_CROS;
            case 5:
                return OS_TYPE_LINUX;
            case 6:
                return OS_TYPE_OPENBSD;
            default:
                return null;
        }
    }

    public static b1<zzge$zzt$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
