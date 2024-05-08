package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f4 extends x0<f4, a> implements c2 {
    private static volatile k2<f4> zzbg;
    private static final f4 zztx;
    private int zzbb;
    private int zztu;
    private String zztv = "";
    private String zztw = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x0.a<f4, a> implements c2 {
        public a() {
            super(f4.zztx);
        }

        public /* synthetic */ a(g4 g4Var) {
            this();
        }
    }

    static {
        f4 f4Var = new f4();
        zztx = f4Var;
        x0.l(f4.class, f4Var);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.x0$b, com.google.android.gms.internal.clearcut.k2<com.google.android.gms.internal.clearcut.f4>] */
    @Override // com.google.android.gms.internal.clearcut.x0
    public final Object i(int i10, Object obj, Object obj2) {
        k2<f4> k2Var;
        g4 g4Var = null;
        switch (g4.f23908a[i10 - 1]) {
            case 1:
                return new f4();
            case 2:
                return new a(g4Var);
            case 3:
                return x0.j(zztx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzbb", "zztu", "zztv", "zztw"});
            case 4:
                return zztx;
            case 5:
                k2<f4> k2Var2 = zzbg;
                k2<f4> k2Var3 = k2Var2;
                if (k2Var2 == null) {
                    synchronized (f4.class) {
                        k2<f4> k2Var4 = zzbg;
                        k2Var = k2Var4;
                        if (k2Var4 == null) {
                            ?? bVar = new x0.b(zztx);
                            zzbg = bVar;
                            k2Var = bVar;
                        }
                    }
                    k2Var3 = k2Var;
                }
                return k2Var3;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
