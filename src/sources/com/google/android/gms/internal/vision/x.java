package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x extends x4<x, a> implements e6 {
    private static final x zzk;
    private static volatile o6<x> zzl;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private String zzj = "";

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<x, a> implements e6 {
        public a() {
            super(x.zzk);
        }

        public final a l(int i10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((x) this.f25677c).y(i10);
            return this;
        }

        public final a m(long j10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((x) this.f25677c).z(j10);
            return this;
        }

        public final a n(zzbw zzbwVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((x) this.f25677c).A(zzbwVar);
            return this;
        }

        public final a o(zzcc zzccVar) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((x) this.f25677c).F(zzccVar);
            return this;
        }

        public final a p(int i10) {
            if (this.f25678d) {
                i();
                this.f25678d = false;
            }
            ((x) this.f25677c).I(i10);
            return this;
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    static {
        x xVar = new x();
        zzk = xVar;
        x4.q(x.class, xVar);
    }

    public static a x() {
        return zzk.t();
    }

    public final void A(zzbw zzbwVar) {
        this.zzf = zzbwVar.zza();
        this.zzc |= 4;
    }

    public final void F(zzcc zzccVar) {
        this.zzg = zzccVar.zza();
        this.zzc |= 8;
    }

    public final void I(int i10) {
        this.zzc |= 2;
        this.zze = i10;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.x>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<x> o6Var;
        w wVar = null;
        switch (w.f25665a[i10 - 1]) {
            case 1:
                return new x();
            case 2:
                return new a(wVar);
            case 3:
                return x4.o(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ဂ\u0005\u0007ဈ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzbw.zzb(), "zzg", zzcc.zzb(), "zzh", "zzi", "zzj"});
            case 4:
                return zzk;
            case 5:
                o6<x> o6Var2 = zzl;
                o6<x> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (x.class) {
                        o6<x> o6Var4 = zzl;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zzk);
                            zzl = aVar;
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

    public final void z(long j10) {
        this.zzc |= 32;
        this.zzi = j10;
    }
}
