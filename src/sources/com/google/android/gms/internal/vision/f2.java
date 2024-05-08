package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;
import com.google.android.gms.internal.vision.zzfi$zzg;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f2 extends x4<f2, a> implements e6 {
    private static final f2 zzj;
    private static volatile o6<f2> zzk;
    private int zzc;
    private long zze;
    private z1 zzf;
    private zzfi$zzg zzh;
    private a2 zzi;
    private String zzd = "";
    private String zzg = "";

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<f2, a> implements e6 {
        public a() {
            super(f2.zzj);
        }

        public final a l(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((f2) this.f25677c).y(j10);
            return this;
        }

        public final a m(z1 z1Var) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((f2) this.f25677c).z(z1Var);
            return this;
        }

        public final a n(zzfi$zzg.a aVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((f2) this.f25677c).A((zzfi$zzg) ((x4) aVar.zzf()));
            return this;
        }

        public final a o(String str) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((f2) this.f25677c).F(str);
            return this;
        }

        public final a p(String str) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((f2) this.f25677c).I(str);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        f2 f2Var = new f2();
        zzj = f2Var;
        x4.q(f2.class, f2Var);
    }

    public static a x() {
        return zzj.t();
    }

    public final void A(zzfi$zzg zzfi_zzg) {
        zzfi_zzg.getClass();
        this.zzh = zzfi_zzg;
        this.zzc |= 16;
    }

    public final void F(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    public final void I(String str) {
        str.getClass();
        this.zzc |= 8;
        this.zzg = str;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.f2>] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<f2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new f2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzj, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0006ဈ\u0003\u0010ဉ\u0004\u0011ဉ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                o6<f2> o6Var2 = zzk;
                o6<f2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (f2.class) {
                        o6<f2> o6Var4 = zzk;
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

    public final void y(long j10) {
        this.zzc |= 2;
        this.zze = j10;
    }

    public final void z(z1 z1Var) {
        z1Var.getClass();
        this.zzf = z1Var;
        this.zzc |= 4;
    }
}
