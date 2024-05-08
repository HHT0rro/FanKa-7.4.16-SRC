package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzn$zzc implements a1 {
    OS_UNKNOWN(0),
    MAC(1),
    WINDOWS(2),
    ANDROID(3),
    LINUX(4),
    CHROME_OS(5),
    IPAD(6),
    IPHONE(7),
    IPOD(8),
    CHROMECAST(9);

    private static final b1<zzge$zzn$zzc> zzbq = new b1<zzge$zzn$zzc>() { // from class: com.google.android.gms.internal.clearcut.l4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzn$zzc a(int i10) {
            return zzge$zzn$zzc.zzav(i10);
        }
    };
    private final int value;

    zzge$zzn$zzc(int i10) {
        this.value = i10;
    }

    public static zzge$zzn$zzc zzav(int i10) {
        switch (i10) {
            case 0:
                return OS_UNKNOWN;
            case 1:
                return MAC;
            case 2:
                return WINDOWS;
            case 3:
                return ANDROID;
            case 4:
                return LINUX;
            case 5:
                return CHROME_OS;
            case 6:
                return IPAD;
            case 7:
                return IPHONE;
            case 8:
                return IPOD;
            case 9:
                return CHROMECAST;
            default:
                return null;
        }
    }

    public static b1<zzge$zzn$zzc> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
