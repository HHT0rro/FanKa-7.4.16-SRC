package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d2 extends x4<d2, a> implements e6 {
    private static final d2 zzj;
    private static volatile o6<d2> zzk;
    private int zzc;
    private float zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<d2, a> implements e6 {
        public a() {
            super(d2.zzj);
        }

        public final a l(float f10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((d2) this.f25677c).y(f10);
            return this;
        }

        public final a m(float f10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((d2) this.f25677c).B(f10);
            return this;
        }

        public final a n(float f10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((d2) this.f25677c).D(f10);
            return this;
        }

        public final a o(float f10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((d2) this.f25677c).F(f10);
            return this;
        }

        public final a p(float f10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((d2) this.f25677c).H(f10);
            return this;
        }

        public final a q(float f10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((d2) this.f25677c).J(f10);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        d2 d2Var = new d2();
        zzj = d2Var;
        x4.q(d2.class, d2Var);
    }

    public static a x() {
        return zzj.t();
    }

    public final void B(float f10) {
        this.zzc |= 2;
        this.zze = f10;
    }

    public final void D(float f10) {
        this.zzc |= 4;
        this.zzf = f10;
    }

    public final void F(float f10) {
        this.zzc |= 8;
        this.zzg = f10;
    }

    public final void H(float f10) {
        this.zzc |= 16;
        this.zzh = f10;
    }

    public final void J(float f10) {
        this.zzc |= 32;
        this.zzi = f10;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.d2>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<d2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new d2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                o6<d2> o6Var2 = zzk;
                o6<d2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (d2.class) {
                        o6<d2> o6Var4 = zzk;
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
        this.zzc |= 1;
        this.zzd = f10;
    }
}
