package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e2 extends x4<e2, a> implements e6 {
    private static final e2 zzg;
    private static volatile o6<e2> zzh;
    private int zzc;
    private zzfi$zzj zzd;
    private g2 zze;
    private g5<zzfi$zzf> zzf = x4.w();

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<e2, a> implements e6 {
        public a() {
            super(e2.zzg);
        }

        public final a l(zzfi$zzj zzfi_zzj) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((e2) this.f25677c).A(zzfi_zzj);
            return this;
        }

        public final a m(Iterable<? extends zzfi$zzf> iterable) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((e2) this.f25677c).B(iterable);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        e2 e2Var = new e2();
        zzg = e2Var;
        x4.q(e2.class, e2Var);
    }

    public static a x() {
        return zzg.t();
    }

    public final void A(zzfi$zzj zzfi_zzj) {
        zzfi_zzj.getClass();
        this.zzd = zzfi_zzj;
        this.zzc |= 1;
    }

    public final void B(Iterable<? extends zzfi$zzf> iterable) {
        D();
        l3.b(iterable, this.zzf);
    }

    public final void D() {
        g5<zzfi$zzf> g5Var = this.zzf;
        if (g5Var.zza()) {
            return;
        }
        this.zzf = x4.m(g5Var);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.e2>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<e2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new e2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", zzfi$zzf.class});
            case 4:
                return zzg;
            case 5:
                o6<e2> o6Var2 = zzh;
                o6<e2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (e2.class) {
                        o6<e2> o6Var4 = zzh;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzg);
                            zzh = aVar;
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
}
