package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h2 extends x4<h2, a> implements e6 {
    private static final h2 zzf;
    private static volatile o6<h2> zzg;
    private int zzc;
    private int zzd;
    private int zze;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<h2, a> implements e6 {
        public a() {
            super(h2.zzf);
        }

        public final a l(int i10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((h2) this.f25677c).y(i10);
            return this;
        }

        public final a m(int i10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((h2) this.f25677c).C(i10);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        h2 h2Var = new h2();
        zzf = h2Var;
        x4.q(h2.class, h2Var);
    }

    public static a x() {
        return zzf.t();
    }

    public final void C(int i10) {
        this.zzc |= 2;
        this.zze = i10;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.h2>] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<h2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new h2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                o6<h2> o6Var2 = zzg;
                o6<h2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (h2.class) {
                        o6<h2> o6Var4 = zzg;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzf);
                            zzg = aVar;
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
        this.zzc |= 1;
        this.zzd = i10;
    }
}
