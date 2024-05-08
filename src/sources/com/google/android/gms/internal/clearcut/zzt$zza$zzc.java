package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzt$zza$zzc implements a1 {
    BUILD_TYPE_UNKNOWN(0),
    BUILD_TYPE_PROD(1),
    BUILD_TYPE_INTERNAL(2),
    BUILD_TYPE_PRODLMP(3),
    BUILD_TYPE_THINGS(4),
    BUILD_TYPE_PRODMNC(5),
    BUILD_TYPE_WEARABLE(6),
    BUILD_TYPE_AUTO(7),
    BUILD_TYPE_SIDEWINDERMNC(8),
    BUILD_TYPE_ATV(9),
    BUILD_TYPE_PRODPIX(10),
    BUILD_TYPE_PRODPI(11);

    private static final b1<zzt$zza$zzc> zzbq = new b1<zzt$zza$zzc>() { // from class: com.google.android.gms.internal.clearcut.i5
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzt$zza$zzc a(int i10) {
            return zzt$zza$zzc.zzc(i10);
        }
    };
    private final int value;

    zzt$zza$zzc(int i10) {
        this.value = i10;
    }

    public static zzt$zza$zzc zzc(int i10) {
        switch (i10) {
            case 0:
                return BUILD_TYPE_UNKNOWN;
            case 1:
                return BUILD_TYPE_PROD;
            case 2:
                return BUILD_TYPE_INTERNAL;
            case 3:
                return BUILD_TYPE_PRODLMP;
            case 4:
                return BUILD_TYPE_THINGS;
            case 5:
                return BUILD_TYPE_PRODMNC;
            case 6:
                return BUILD_TYPE_WEARABLE;
            case 7:
                return BUILD_TYPE_AUTO;
            case 8:
                return BUILD_TYPE_SIDEWINDERMNC;
            case 9:
                return BUILD_TYPE_ATV;
            case 10:
                return BUILD_TYPE_PRODPIX;
            case 11:
                return BUILD_TYPE_PRODPI;
            default:
                return null;
        }
    }

    public static b1<zzt$zza$zzc> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
