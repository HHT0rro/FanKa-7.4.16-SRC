package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b2 extends x4<b2, a> implements e6 {
    private static final b2 zzg;
    private static volatile o6<b2> zzh;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<b2, a> implements e6 {
        public a() {
            super(b2.zzg);
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        b2 b2Var = new b2();
        zzg = b2Var;
        x4.q(b2.class, b2Var);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.b2>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<b2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new b2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"zzc", "zzd", zzgz.zzb(), "zze", zzha.zzb(), "zzf"});
            case 4:
                return zzg;
            case 5:
                o6<b2> o6Var2 = zzh;
                o6<b2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (b2.class) {
                        o6<b2> o6Var4 = zzh;
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
