package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzt$zza$zzd implements a1 {
    DENSITY_UNKNOWN(0),
    DENSITY_ALLDPI(1),
    DENSITY_LDPI(2),
    DENSITY_MDPI(3),
    DENSITY_TVDPI(4),
    DENSITY_HDPI(5),
    DENSITY_XHDPI(7),
    DENSITY_DPI400(8),
    DENSITY_XXHDPI(9),
    DENSITY_XXXHDPI(10);

    private static final b1<zzt$zza$zzd> zzbq = new b1<zzt$zza$zzd>() { // from class: com.google.android.gms.internal.clearcut.j5
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzt$zza$zzd a(int i10) {
            return zzt$zza$zzd.zzd(i10);
        }
    };
    private final int value;

    zzt$zza$zzd(int i10) {
        this.value = i10;
    }

    public static b1<zzt$zza$zzd> zzd() {
        return zzbq;
    }

    public static zzt$zza$zzd zzd(int i10) {
        switch (i10) {
            case 0:
                return DENSITY_UNKNOWN;
            case 1:
                return DENSITY_ALLDPI;
            case 2:
                return DENSITY_LDPI;
            case 3:
                return DENSITY_MDPI;
            case 4:
                return DENSITY_TVDPI;
            case 5:
                return DENSITY_HDPI;
            case 6:
            default:
                return null;
            case 7:
                return DENSITY_XHDPI;
            case 8:
                return DENSITY_DPI400;
            case 9:
                return DENSITY_XXHDPI;
            case 10:
                return DENSITY_XXXHDPI;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
