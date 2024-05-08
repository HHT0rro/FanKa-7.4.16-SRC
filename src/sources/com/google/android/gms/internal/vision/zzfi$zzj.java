package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzfi$zzj extends x4<zzfi$zzj, a> implements e6 {
    private static final zzfi$zzj zzi;
    private static volatile o6<zzfi$zzj> zzj;
    private int zzc;
    private int zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<zzfi$zzj, a> implements e6 {
        public a() {
            super(zzfi$zzj.zzi);
        }

        public final a l(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzj) this.f25677c).y(j10);
            return this;
        }

        public final a m(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzj) this.f25677c).B(j10);
            return this;
        }

        public final a n(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzj) this.f25677c).D(j10);
            return this;
        }

        public final a o(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzj) this.f25677c).F(j10);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum zza implements a5 {
        FORMAT_UNKNOWN(0),
        FORMAT_LUMINANCE(1),
        FORMAT_RGB8(2),
        FORMAT_MONOCHROME(3);

        private static final d5<zza> zze = new y2();
        private final int zzf;

        zza(int i10) {
            this.zzf = i10;
        }

        public static c5 zzb() {
            return x2.f25674a;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
        }

        @Override // com.google.android.gms.internal.vision.a5
        public final int zza() {
            return this.zzf;
        }

        public static zza zza(int i10) {
            if (i10 == 0) {
                return FORMAT_UNKNOWN;
            }
            if (i10 == 1) {
                return FORMAT_LUMINANCE;
            }
            if (i10 == 2) {
                return FORMAT_RGB8;
            }
            if (i10 != 3) {
                return null;
            }
            return FORMAT_MONOCHROME;
        }
    }

    static {
        zzfi$zzj zzfi_zzj = new zzfi$zzj();
        zzi = zzfi_zzj;
        x4.q(zzfi$zzj.class, zzfi_zzj);
    }

    public static a x() {
        return zzi.t();
    }

    public final void B(long j10) {
        this.zzc |= 4;
        this.zzf = j10;
    }

    public final void D(long j10) {
        this.zzc |= 8;
        this.zzg = j10;
    }

    public final void F(long j10) {
        this.zzc |= 16;
        this.zzh = j10;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzfi$zzj>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<zzfi$zzj> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new zzfi$zzj();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzh", "zzg"});
            case 4:
                return zzi;
            case 5:
                o6<zzfi$zzj> o6Var2 = zzj;
                o6<zzfi$zzj> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (zzfi$zzj.class) {
                        o6<zzfi$zzj> o6Var4 = zzj;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzi);
                            zzj = aVar;
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

    public final void y(long j10) {
        this.zzc |= 2;
        this.zze = j10;
    }
}
