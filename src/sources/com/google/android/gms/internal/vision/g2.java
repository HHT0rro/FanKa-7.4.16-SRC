package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g2 extends x4<g2, a> implements e6 {
    private static final g2 zzf;
    private static volatile o6<g2> zzg;
    private int zzc;
    private long zzd;
    private long zze;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<g2, a> implements e6 {
        public a() {
            super(g2.zzf);
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        g2 g2Var = new g2();
        zzf = g2Var;
        x4.q(g2.class, g2Var);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.g2>] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<g2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new g2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                o6<g2> o6Var2 = zzg;
                o6<g2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (g2.class) {
                        o6<g2> o6Var4 = zzg;
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
}
