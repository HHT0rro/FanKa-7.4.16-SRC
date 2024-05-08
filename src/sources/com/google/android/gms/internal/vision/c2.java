package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.h2;
import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c2 extends x4<c2, a> implements e6 {
    private static final c2 zzd;
    private static volatile o6<c2> zze;
    private g5<h2> zzc = x4.w();

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<c2, a> implements e6 {
        public a() {
            super(c2.zzd);
        }

        public final a l(h2.a aVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((c2) this.f25677c).z((h2) ((x4) aVar.zzf()));
            return this;
        }

        public final a m(h2 h2Var) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((c2) this.f25677c).z(h2Var);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        c2 c2Var = new c2();
        zzd = c2Var;
        x4.q(c2.class, c2Var);
    }

    public static a x() {
        return zzd.t();
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.c2>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<c2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new c2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", h2.class});
            case 4:
                return zzd;
            case 5:
                o6<c2> o6Var2 = zze;
                o6<c2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (c2.class) {
                        o6<c2> o6Var4 = zze;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzd);
                            zze = aVar;
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

    public final void z(h2 h2Var) {
        h2Var.getClass();
        g5<h2> g5Var = this.zzc;
        if (!g5Var.zza()) {
            this.zzc = x4.m(g5Var);
        }
        this.zzc.add(h2Var);
    }
}
