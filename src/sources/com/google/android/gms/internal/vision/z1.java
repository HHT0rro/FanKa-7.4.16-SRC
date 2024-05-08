package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z1 extends x4<z1, a> implements e6 {
    private static final z1 zzf;
    private static volatile o6<z1> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<z1, a> implements e6 {
        public a() {
            super(z1.zzf);
        }

        public final a l(String str) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((z1) this.f25677c).z(str);
            return this;
        }

        public final a m(String str) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((z1) this.f25677c).C(str);
            return this;
        }

        public /* synthetic */ a(l2 l2Var) {
            this();
        }
    }

    static {
        z1 z1Var = new z1();
        zzf = z1Var;
        x4.q(z1.class, z1Var);
    }

    public static a x() {
        return zzf.t();
    }

    public final void C(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.z1>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<z1> o6Var;
        l2 l2Var = null;
        switch (l2.f25529a[i10 - 1]) {
            case 1:
                return new z1();
            case 2:
                return new a(l2Var);
            case 3:
                return x4.o(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                o6<z1> o6Var2 = zzg;
                o6<z1> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (z1.class) {
                        o6<z1> o6Var4 = zzg;
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

    public final void z(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }
}
