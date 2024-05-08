package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzfi$zzg extends x4<zzfi$zzg, a> implements e6 {
    private static final zzfi$zzg zzj;
    private static volatile o6<zzfi$zzg> zzk;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private float zzi;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<zzfi$zzg, a> implements e6 {
        public a() {
            super(zzfi$zzg.zzj);
        }

        public final a l(float f10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzg) this.f25677c).y(f10);
            return this;
        }

        public final a m(zzb zzbVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzg) this.f25677c).z(zzbVar);
            return this;
        }

        public final a n(zzc zzcVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzg) this.f25677c).A(zzcVar);
            return this;
        }

        public final a o(zzd zzdVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzg) this.f25677c).B(zzdVar);
            return this;
        }

        public final a p(boolean z10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzg) this.f25677c).H(z10);
            return this;
        }

        public final a q(boolean z10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzg) this.f25677c).K(z10);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum zzb implements a5 {
        CLASSIFICATION_UNKNOWN(0),
        CLASSIFICATION_NONE(1),
        CLASSIFICATION_ALL(2);

        private static final d5<zzb> zzd = new r2();
        private final int zze;

        zzb(int i10) {
            this.zze = i10;
        }

        public static c5 zzb() {
            return s2.f25630a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.a5
        public final int zza() {
            return this.zze;
        }

        public static zzb zza(int i10) {
            if (i10 == 0) {
                return CLASSIFICATION_UNKNOWN;
            }
            if (i10 == 1) {
                return CLASSIFICATION_NONE;
            }
            if (i10 != 2) {
                return null;
            }
            return CLASSIFICATION_ALL;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum zzc implements a5 {
        LANDMARK_UNKNOWN(0),
        LANDMARK_NONE(1),
        LANDMARK_ALL(2),
        LANDMARK_CONTOUR(3);

        private static final d5<zzc> zze = new u2();
        private final int zzf;

        zzc(int i10) {
            this.zzf = i10;
        }

        public static c5 zzb() {
            return t2.f25643a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.a5
        public final int zza() {
            return this.zzf;
        }

        public static zzc zza(int i10) {
            if (i10 == 0) {
                return LANDMARK_UNKNOWN;
            }
            if (i10 == 1) {
                return LANDMARK_NONE;
            }
            if (i10 == 2) {
                return LANDMARK_ALL;
            }
            if (i10 != 3) {
                return null;
            }
            return LANDMARK_CONTOUR;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum zzd implements a5 {
        MODE_UNKNOWN(0),
        MODE_ACCURATE(1),
        MODE_FAST(2),
        MODE_SELFIE(3);

        private static final d5<zzd> zze = new v2();
        private final int zzf;

        zzd(int i10) {
            this.zzf = i10;
        }

        public static c5 zzb() {
            return w2.f25667a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.a5
        public final int zza() {
            return this.zzf;
        }

        public static zzd zza(int i10) {
            if (i10 == 0) {
                return MODE_UNKNOWN;
            }
            if (i10 == 1) {
                return MODE_ACCURATE;
            }
            if (i10 == 2) {
                return MODE_FAST;
            }
            if (i10 != 3) {
                return null;
            }
            return MODE_SELFIE;
        }
    }

    static {
        zzfi$zzg zzfi_zzg = new zzfi$zzg();
        zzj = zzfi_zzg;
        x4.q(zzfi$zzg.class, zzfi_zzg);
    }

    public static a x() {
        return zzj.t();
    }

    public final void A(zzc zzcVar) {
        this.zze = zzcVar.zza();
        this.zzc |= 2;
    }

    public final void B(zzd zzdVar) {
        this.zzd = zzdVar.zza();
        this.zzc |= 1;
    }

    public final void H(boolean z10) {
        this.zzc |= 8;
        this.zzg = z10;
    }

    public final void K(boolean z10) {
        this.zzc |= 16;
        this.zzh = z10;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzfi$zzg>] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<zzfi$zzg> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new zzfi$zzg();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", zzb.zzb(), "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                o6<zzfi$zzg> o6Var2 = zzk;
                o6<zzfi$zzg> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (zzfi$zzg.class) {
                        o6<zzfi$zzg> o6Var4 = zzk;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzj);
                            zzk = aVar;
                            o6Var = aVar;
                        }
                    }
                    o6Var3 = o6Var;
                }
                return o6Var3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final void y(float f10) {
        this.zzc |= 32;
        this.zzi = f10;
    }

    public final void z(zzb zzbVar) {
        this.zzf = zzbVar.zza();
        this.zzc |= 4;
    }
}
