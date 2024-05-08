package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.c2;
import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i2 extends x4<i2, a> implements e6 {
    private static final i2 zzh;
    private static volatile o6<i2> zzi;
    private int zzc;
    private c2 zzd;
    private int zze;
    private d2 zzf;
    private b2 zzg;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<i2, a> implements e6 {
        public a() {
            super(i2.zzh);
        }

        public final a l(int i10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((i2) this.f25677c).y(i10);
            return this;
        }

        public final a m(c2.a aVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((i2) this.f25677c).z((c2) ((x4) aVar.zzf()));
            return this;
        }

        public final a n(c2 c2Var) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((i2) this.f25677c).z(c2Var);
            return this;
        }

        public final a o(d2 d2Var) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((i2) this.f25677c).A(d2Var);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        i2 i2Var = new i2();
        zzh = i2Var;
        x4.q(i2.class, i2Var);
    }

    public static a x() {
        return zzh.t();
    }

    public final void A(d2 d2Var) {
        d2Var.getClass();
        this.zzf = d2Var;
        this.zzc |= 4;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.i2>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<i2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new i2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzh, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                o6<i2> o6Var2 = zzi;
                o6<i2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (i2.class) {
                        o6<i2> o6Var4 = zzi;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzh);
                            zzi = aVar;
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

    public final void y(int i10) {
        this.zzc |= 2;
        this.zze = i10;
    }

    public final void z(c2 c2Var) {
        c2Var.getClass();
        this.zzd = c2Var;
        this.zzc |= 1;
    }
}
