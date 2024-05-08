package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.f2;
import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j2 extends x4<j2, a> implements e6 {
    private static final j2 zzi;
    private static volatile o6<j2> zzj;
    private int zzc;
    private zzfi$zze zzd;
    private f2 zze;
    private e2 zzf;
    private int zzg;
    private boolean zzh;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<j2, a> implements e6 {
        public a() {
            super(j2.zzi);
        }

        public final a l(e2 e2Var) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((j2) this.f25677c).y(e2Var);
            return this;
        }

        public final a m(f2.a aVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((j2) this.f25677c).z((f2) ((x4) aVar.zzf()));
            return this;
        }

        public final a n(boolean z10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((j2) this.f25677c).D(true);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        j2 j2Var = new j2();
        zzi = j2Var;
        x4.q(j2.class, j2Var);
    }

    public static a x() {
        return zzi.t();
    }

    public final void D(boolean z10) {
        this.zzc |= 16;
        this.zzh = true;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.j2>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<j2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new j2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003\u0005ဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                o6<j2> o6Var2 = zzj;
                o6<j2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (j2.class) {
                        o6<j2> o6Var4 = zzj;
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

    public final void y(e2 e2Var) {
        e2Var.getClass();
        this.zzf = e2Var;
        this.zzc |= 4;
    }

    public final void z(f2 f2Var) {
        f2Var.getClass();
        this.zze = f2Var;
        this.zzc |= 2;
    }
}
