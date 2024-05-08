package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzfi$zzf extends x4<zzfi$zzf, a> implements e6 {
    private static final zzfi$zzf zzl;
    private static volatile o6<zzfi$zzf> zzm;
    private int zzc;
    private int zzg;
    private long zzi;
    private long zzj;
    private String zzd = "";
    private String zze = "";
    private g5<String> zzf = x4.w();
    private String zzh = "";
    private g5<i2> zzk = x4.w();

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<zzfi$zzf, a> implements e6 {
        public a() {
            super(zzfi$zzf.zzl);
        }

        public final a l(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzf) this.f25677c).y(j10);
            return this;
        }

        public final a m(Iterable<? extends i2> iterable) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzf) this.f25677c).C(iterable);
            return this;
        }

        public final a n(String str) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzf) this.f25677c).D(str);
            return this;
        }

        public final a o(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((zzfi$zzf) this.f25677c).F(j10);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum zza implements a5 {
        RESULT_UNKNOWN(0),
        RESULT_SUCCESS(1),
        RESULT_FAIL(2),
        RESULT_SKIPPED(3);

        private static final d5<zza> zze = new q2();
        private final int zzf;

        zza(int i10) {
            this.zzf = i10;
        }

        public static c5 zzb() {
            return p2.f25579a;
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
                return RESULT_UNKNOWN;
            }
            if (i10 == 1) {
                return RESULT_SUCCESS;
            }
            if (i10 == 2) {
                return RESULT_FAIL;
            }
            if (i10 != 3) {
                return null;
            }
            return RESULT_SKIPPED;
        }
    }

    static {
        zzfi$zzf zzfi_zzf = new zzfi$zzf();
        zzl = zzfi_zzf;
        x4.q(zzfi$zzf.class, zzfi_zzf);
    }

    public static a x() {
        return zzl.t();
    }

    public final void C(Iterable<? extends i2> iterable) {
        g5<i2> g5Var = this.zzk;
        if (!g5Var.zza()) {
            this.zzk = x4.m(g5Var);
        }
        l3.b(iterable, this.zzk);
    }

    public final void D(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    public final void F(long j10) {
        this.zzc |= 32;
        this.zzj = j10;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzfi$zzf>] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<zzfi$zzf> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new zzfi$zzf();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zza.zzb(), "zzh", "zzi", "zzj", "zzk", i2.class});
            case 4:
                return zzl;
            case 5:
                o6<zzfi$zzf> o6Var2 = zzm;
                o6<zzfi$zzf> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (zzfi$zzf.class) {
                        o6<zzfi$zzf> o6Var4 = zzm;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzl);
                            zzm = aVar;
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
        this.zzc |= 16;
        this.zzi = j10;
    }
}
