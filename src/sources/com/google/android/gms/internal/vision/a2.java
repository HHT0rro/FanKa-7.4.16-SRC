package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a2 extends x4<a2, a> implements e6 {
    private static final e5<Integer, zzgz> zzd = new m2();
    private static final a2 zze;
    private static volatile o6<a2> zzf;
    private f5 zzc = x4.v();

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<a2, a> implements e6 {
        public a() {
            super(a2.zze);
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.m2, com.google.android.gms.internal.vision.e5<java.lang.Integer, com.google.android.gms.internal.vision.zzgz>] */
    static {
        a2 a2Var = new a2();
        zze = a2Var;
        x4.q(a2.class, a2Var);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.a2>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<a2> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new a2();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzgz.zzb()});
            case 4:
                return zze;
            case 5:
                o6<a2> o6Var2 = zzf;
                o6<a2> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (a2.class) {
                        o6<a2> o6Var4 = zzf;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zze);
                            zzf = aVar;
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
