package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzg$zzb implements a1 {
    UNKNOWN(0),
    JS(1),
    DESKTOP(2),
    IOS(3),
    IOS_V2(10),
    ANDROID(4),
    PLAY_CE(5),
    PYTHON(6),
    VR(7),
    PANCETTA(8),
    DRIVE_FS(9),
    YETI(11),
    MAC(12),
    PLAY_GOOGLE_HOME(13),
    BIRDSONG(14),
    IOS_FIREBASE(15),
    GO(16);

    private static final b1<zzge$zzg$zzb> zzbq = new b1<zzge$zzg$zzb>() { // from class: com.google.android.gms.internal.clearcut.i4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzg$zzb a(int i10) {
            return zzge$zzg$zzb.zzas(i10);
        }
    };
    private final int value;

    zzge$zzg$zzb(int i10) {
        this.value = i10;
    }

    public static zzge$zzg$zzb zzas(int i10) {
        switch (i10) {
            case 0:
                return UNKNOWN;
            case 1:
                return JS;
            case 2:
                return DESKTOP;
            case 3:
                return IOS;
            case 4:
                return ANDROID;
            case 5:
                return PLAY_CE;
            case 6:
                return PYTHON;
            case 7:
                return VR;
            case 8:
                return PANCETTA;
            case 9:
                return DRIVE_FS;
            case 10:
                return IOS_V2;
            case 11:
                return YETI;
            case 12:
                return MAC;
            case 13:
                return PLAY_GOOGLE_HOME;
            case 14:
                return BIRDSONG;
            case 15:
                return IOS_FIREBASE;
            case 16:
                return GO;
            default:
                return null;
        }
    }

    public static b1<zzge$zzg$zzb> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
