package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum zzge$zzq$zzc implements a1 {
    UNKNOWN_SCHEDULER(0),
    ASAP(1),
    DEFAULT_PERIODIC(2),
    QOS_FAST_ONEOFF(3),
    QOS_DEFAULT_PERIODIC(4),
    QOS_UNMETERED_PERIODIC(5);

    private static final b1<zzge$zzq$zzc> zzbq = new b1<zzge$zzq$zzc>() { // from class: com.google.android.gms.internal.clearcut.o4
        @Override // com.google.android.gms.internal.clearcut.b1
        public final /* synthetic */ zzge$zzq$zzc a(int i10) {
            return zzge$zzq$zzc.zzay(i10);
        }
    };
    private final int value;

    zzge$zzq$zzc(int i10) {
        this.value = i10;
    }

    public static zzge$zzq$zzc zzay(int i10) {
        if (i10 == 0) {
            return UNKNOWN_SCHEDULER;
        }
        if (i10 == 1) {
            return ASAP;
        }
        if (i10 == 2) {
            return DEFAULT_PERIODIC;
        }
        if (i10 == 3) {
            return QOS_FAST_ONEOFF;
        }
        if (i10 == 4) {
            return QOS_DEFAULT_PERIODIC;
        }
        if (i10 != 5) {
            return null;
        }
        return QOS_UNMETERED_PERIODIC;
    }

    public static b1<zzge$zzq$zzc> zzd() {
        return zzbq;
    }

    @Override // com.google.android.gms.internal.clearcut.a1
    public final int zzc() {
        return this.value;
    }
}
