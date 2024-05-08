package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzci {

    /* renamed from: a, reason: collision with root package name */
    public static final x4.e<zzmt, List<zzb>> f25742a = x4.h(zzmt.I(), zzb.A(), null, 202056002, zzml.zzk, false, zzb.class);

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4<a, C0218a> implements e6 {
        private static final a zzf;
        private static volatile o6<a> zzg;
        private int zzc;
        private f zzd;
        private f zze;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.vision.zzci$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class C0218a extends x4.b<a, C0218a> implements e6 {
            public C0218a() {
                super(a.zzf);
            }

            public final C0218a l(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((a) this.f25677c).z(fVar);
                return this;
            }

            public final C0218a m(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((a) this.f25677c).C(fVar);
                return this;
            }

            public /* synthetic */ C0218a(a0 a0Var) {
                this();
            }
        }

        static {
            a aVar = new a();
            zzf = aVar;
            x4.q(a.class, aVar);
        }

        public static C0218a x() {
            return zzf.t();
        }

        public final void C(f fVar) {
            fVar.getClass();
            this.zze = fVar;
            this.zzc |= 2;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$a>] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<a> o6Var;
            a0 a0Var = null;
            switch (a0.f25429a[i10 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0218a(a0Var);
                case 3:
                    return x4.o(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    o6<a> o6Var2 = zzg;
                    o6<a> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (a.class) {
                            o6<a> o6Var4 = zzg;
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

        public final void z(f fVar) {
            fVar.getClass();
            this.zzd = fVar;
            this.zzc |= 1;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends x4<b, a> implements e6 {
        private static final b zzf;
        private static volatile o6<b> zzg;
        private int zzc;
        private i8 zzd;
        private byte zze = 2;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<b, a> implements e6 {
            public a() {
                super(b.zzf);
            }

            public /* synthetic */ a(a0 a0Var) {
                this();
            }
        }

        static {
            b bVar = new b();
            zzf = bVar;
            x4.q(b.class, bVar);
        }

        public static b x(byte[] bArr, l4 l4Var) throws zzjk {
            return (b) x4.k(zzf, bArr, l4Var);
        }

        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$b>, com.google.android.gms.internal.vision.x4$a] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<b> o6Var;
            a0 a0Var = null;
            switch (a0.f25429a[i10 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(a0Var);
                case 3:
                    return x4.o(zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zzf;
                case 5:
                    o6<b> o6Var2 = zzg;
                    o6<b> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (b.class) {
                            o6<b> o6Var4 = zzg;
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
                    return Byte.valueOf(this.zze);
                case 7:
                    this.zze = (byte) (obj == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final i8 y() {
            i8 i8Var = this.zzd;
            return i8Var == null ? i8.A() : i8Var;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends x4<c, a> implements e6 {
        private static final c zzp;
        private static volatile o6<c> zzq;
        private int zzc;
        private boolean zzh;
        private boolean zzi;
        private boolean zzl;
        private d zzm;
        private a zzn;
        private e zzo;
        private float zzd = 0.1f;
        private int zze = 1;
        private int zzf = 1;
        private int zzg = 1;
        private float zzj = 45.0f;
        private float zzk = 0.5f;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<c, a> implements e6 {
            public a() {
                super(c.zzp);
            }

            public final a l(float f10) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).y(f10);
                return this;
            }

            public final a m(a.C0218a c0218a) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).z((a) ((x4) c0218a.zzf()));
                return this;
            }

            public final a n(d.a aVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).I((d) ((x4) aVar.zzf()));
                return this;
            }

            public final a o(e.a aVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).J((e) ((x4) aVar.zzf()));
                return this;
            }

            public final a p(zzck zzckVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).K(zzckVar);
                return this;
            }

            public final a q(zzcp zzcpVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).L(zzcpVar);
                return this;
            }

            public final a r(zzct zzctVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).M(zzctVar);
                return this;
            }

            public final a s(boolean z10) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).N(z10);
                return this;
            }

            public final a t(boolean z10) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).Q(z10);
                return this;
            }

            public final a u(boolean z10) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((c) this.f25677c).T(true);
                return this;
            }

            public /* synthetic */ a(a0 a0Var) {
                this();
            }
        }

        static {
            c cVar = new c();
            zzp = cVar;
            x4.q(c.class, cVar);
        }

        public static a R() {
            return zzp.t();
        }

        public final void I(d dVar) {
            dVar.getClass();
            this.zzm = dVar;
            this.zzc |= 512;
        }

        public final void J(e eVar) {
            eVar.getClass();
            this.zzo = eVar;
            this.zzc |= 2048;
        }

        public final void K(zzck zzckVar) {
            this.zzf = zzckVar.zza();
            this.zzc |= 4;
        }

        public final void L(zzcp zzcpVar) {
            this.zze = zzcpVar.zza();
            this.zzc |= 2;
        }

        public final void M(zzct zzctVar) {
            this.zzg = zzctVar.zza();
            this.zzc |= 8;
        }

        public final void N(boolean z10) {
            this.zzc |= 16;
            this.zzh = z10;
        }

        public final zzck O() {
            zzck zza = zzck.zza(this.zzf);
            return zza == null ? zzck.NO_CLASSIFICATION : zza;
        }

        public final void Q(boolean z10) {
            this.zzc |= 32;
            this.zzi = z10;
        }

        public final void T(boolean z10) {
            this.zzc |= 256;
            this.zzl = true;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$c>, com.google.android.gms.internal.vision.x4$a] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<c> o6Var;
            a0 a0Var = null;
            switch (a0.f25429a[i10 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a(a0Var);
                case 3:
                    return x4.o(zzp, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ခ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ခ\u0006\bခ\u0007\tဇ\b\nဉ\t\u000bဉ\n\fဉ\u000b", new Object[]{"zzc", "zzd", "zze", zzcp.zzb(), "zzf", zzck.zzb(), "zzg", zzct.zzb(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo"});
                case 4:
                    return zzp;
                case 5:
                    o6<c> o6Var2 = zzq;
                    o6<c> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (c.class) {
                            o6<c> o6Var4 = zzq;
                            o6Var = o6Var4;
                            if (o6Var4 == null) {
                                ?? aVar = new x4.a(zzp);
                                zzq = aVar;
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

        public final zzcp x() {
            zzcp zza = zzcp.zza(this.zze);
            return zza == null ? zzcp.NO_LANDMARK : zza;
        }

        public final void y(float f10) {
            this.zzc |= 1;
            this.zzd = f10;
        }

        public final void z(a aVar) {
            aVar.getClass();
            this.zzn = aVar;
            this.zzc |= 1024;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends x4<d, a> implements e6 {
        private static final d zzg;
        private static volatile o6<d> zzh;
        private int zzc;
        private f zzd;
        private f zze;
        private f zzf;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<d, a> implements e6 {
            public a() {
                super(d.zzg);
            }

            public final a l(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((d) this.f25677c).z(fVar);
                return this;
            }

            public final a m(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((d) this.f25677c).C(fVar);
                return this;
            }

            public final a n(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((d) this.f25677c).E(fVar);
                return this;
            }

            public /* synthetic */ a(a0 a0Var) {
                this();
            }
        }

        static {
            d dVar = new d();
            zzg = dVar;
            x4.q(d.class, dVar);
        }

        public static a x() {
            return zzg.t();
        }

        public final void C(f fVar) {
            fVar.getClass();
            this.zze = fVar;
            this.zzc |= 2;
        }

        public final void E(f fVar) {
            fVar.getClass();
            this.zzf = fVar;
            this.zzc |= 4;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$d>, com.google.android.gms.internal.vision.x4$a] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<d> o6Var;
            a0 a0Var = null;
            switch (a0.f25429a[i10 - 1]) {
                case 1:
                    return new d();
                case 2:
                    return new a(a0Var);
                case 3:
                    return x4.o(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    o6<d> o6Var2 = zzh;
                    o6<d> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (d.class) {
                            o6<d> o6Var4 = zzh;
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

        public final void z(f fVar) {
            fVar.getClass();
            this.zzd = fVar;
            this.zzc |= 1;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e extends x4<e, a> implements e6 {
        private static final e zzh;
        private static volatile o6<e> zzi;
        private int zzc;
        private f zzd;
        private f zze;
        private f zzf;
        private f zzg;

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<e, a> implements e6 {
            public a() {
                super(e.zzh);
            }

            public final a l(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((e) this.f25677c).z(fVar);
                return this;
            }

            public final a m(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((e) this.f25677c).C(fVar);
                return this;
            }

            public final a n(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((e) this.f25677c).E(fVar);
                return this;
            }

            public final a o(f fVar) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((e) this.f25677c).G(fVar);
                return this;
            }

            public /* synthetic */ a(a0 a0Var) {
                this();
            }
        }

        static {
            e eVar = new e();
            zzh = eVar;
            x4.q(e.class, eVar);
        }

        public static a x() {
            return zzh.t();
        }

        public final void C(f fVar) {
            fVar.getClass();
            this.zze = fVar;
            this.zzc |= 2;
        }

        public final void E(f fVar) {
            fVar.getClass();
            this.zzf = fVar;
            this.zzc |= 4;
        }

        public final void G(f fVar) {
            fVar.getClass();
            this.zzg = fVar;
            this.zzc |= 8;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$e>, com.google.android.gms.internal.vision.x4$a] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<e> o6Var;
            a0 a0Var = null;
            switch (a0.f25429a[i10 - 1]) {
                case 1:
                    return new e();
                case 2:
                    return new a(a0Var);
                case 3:
                    return x4.o(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    o6<e> o6Var2 = zzi;
                    o6<e> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (e.class) {
                            o6<e> o6Var4 = zzi;
                            o6Var = o6Var4;
                            if (o6Var4 == null) {
                                ?? aVar = new x4.a(zzh);
                                zzi = aVar;
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

        public final void z(f fVar) {
            fVar.getClass();
            this.zzd = fVar;
            this.zzc |= 1;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class f extends x4<f, a> implements e6 {
        private static final f zzf;
        private static volatile o6<f> zzg;
        private int zzc;
        private zzht zzd = zzht.zza;
        private String zze = "";

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<f, a> implements e6 {
            public a() {
                super(f.zzf);
            }

            public final a l(String str) {
                if (this.f25678d) {
                    i();
                    this.f25678d = false;
                }
                ((f) this.f25677c).z(str);
                return this;
            }

            public /* synthetic */ a(a0 a0Var) {
                this();
            }
        }

        static {
            f fVar = new f();
            zzf = fVar;
            x4.q(f.class, fVar);
        }

        public static a x() {
            return zzf.t();
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$f>, com.google.android.gms.internal.vision.x4$a] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<f> o6Var;
            a0 a0Var = null;
            switch (a0.f25429a[i10 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a(a0Var);
                case 3:
                    return x4.o(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    o6<f> o6Var2 = zzg;
                    o6<f> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (f.class) {
                            o6<f> o6Var4 = zzg;
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
            this.zzc |= 2;
            this.zze = str;
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class zzb extends x4<zzb, a> implements e6 {
        private static final zzb zzf;
        private static volatile o6<zzb> zzg;
        private int zzc;
        private int zzd;
        private g5<b> zze = x4.w();

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x4.b<zzb, a> implements e6 {
            public a() {
                super(zzb.zzf);
            }

            public /* synthetic */ a(a0 a0Var) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class b extends x4<b, a> implements e6 {
            private static final b zzg;
            private static volatile o6<b> zzh;
            private int zzc;
            private float zzd;
            private float zze;
            private float zzf;

            /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public static final class a extends x4.b<b, a> implements e6 {
                public a() {
                    super(b.zzg);
                }

                public /* synthetic */ a(a0 a0Var) {
                    this();
                }
            }

            static {
                b bVar = new b();
                zzg = bVar;
                x4.q(b.class, bVar);
            }

            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$zzb$b>, com.google.android.gms.internal.vision.x4$a] */
            @Override // com.google.android.gms.internal.vision.x4
            public final Object n(int i10, Object obj, Object obj2) {
                o6<b> o6Var;
                a0 a0Var = null;
                switch (a0.f25429a[i10 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a(a0Var);
                    case 3:
                        return x4.o(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        o6<b> o6Var2 = zzh;
                        o6<b> o6Var3 = o6Var2;
                        if (o6Var2 == null) {
                            synchronized (b.class) {
                                o6<b> o6Var4 = zzh;
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

            public final float x() {
                return this.zzd;
            }

            public final float y() {
                return this.zze;
            }
        }

        /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public enum zzc implements a5 {
            CONTOUR_UNKNOWN(0),
            FACE_OVAL(1),
            LEFT_EYEBROW_TOP(2),
            LEFT_EYEBROW_BOTTOM(3),
            RIGHT_EYEBROW_TOP(4),
            RIGHT_EYEBROW_BOTTOM(5),
            LEFT_EYE(6),
            RIGHT_EYE(7),
            UPPER_LIP_TOP(8),
            UPPER_LIP_BOTTOM(9),
            LOWER_LIP_TOP(10),
            LOWER_LIP_BOTTOM(11),
            NOSE_BRIDGE(12),
            NOSE_BOTTOM(13),
            LEFT_CHEEK_CENTER(14),
            RIGHT_CHEEK_CENTER(15);

            private static final d5<zzc> zzq = new d0();
            private final int zzr;

            zzc(int i10) {
                this.zzr = i10;
            }

            public static c5 zzb() {
                return e0.f25453a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzr + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.a5
            public final int zza() {
                return this.zzr;
            }

            public static zzc zza(int i10) {
                switch (i10) {
                    case 0:
                        return CONTOUR_UNKNOWN;
                    case 1:
                        return FACE_OVAL;
                    case 2:
                        return LEFT_EYEBROW_TOP;
                    case 3:
                        return LEFT_EYEBROW_BOTTOM;
                    case 4:
                        return RIGHT_EYEBROW_TOP;
                    case 5:
                        return RIGHT_EYEBROW_BOTTOM;
                    case 6:
                        return LEFT_EYE;
                    case 7:
                        return RIGHT_EYE;
                    case 8:
                        return UPPER_LIP_TOP;
                    case 9:
                        return UPPER_LIP_BOTTOM;
                    case 10:
                        return LOWER_LIP_TOP;
                    case 11:
                        return LOWER_LIP_BOTTOM;
                    case 12:
                        return NOSE_BRIDGE;
                    case 13:
                        return NOSE_BOTTOM;
                    case 14:
                        return LEFT_CHEEK_CENTER;
                    case 15:
                        return RIGHT_CHEEK_CENTER;
                    default:
                        return null;
                }
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzf = zzbVar;
            x4.q(zzb.class, zzbVar);
        }

        public static zzb A() {
            return zzf;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.x4$a, com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.zzci$zzb>] */
        @Override // com.google.android.gms.internal.vision.x4
        public final Object n(int i10, Object obj, Object obj2) {
            o6<zzb> o6Var;
            a0 a0Var = null;
            switch (a0.f25429a[i10 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new a(a0Var);
                case 3:
                    return x4.o(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zzc.zzb(), "zze", b.class});
                case 4:
                    return zzf;
                case 5:
                    o6<zzb> o6Var2 = zzg;
                    o6<zzb> o6Var3 = o6Var2;
                    if (o6Var2 == null) {
                        synchronized (zzb.class) {
                            o6<zzb> o6Var4 = zzg;
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

        public final zzc x() {
            zzc zza = zzc.zza(this.zzd);
            return zza == null ? zzc.CONTOUR_UNKNOWN : zza;
        }

        public final List<b> y() {
            return this.zze;
        }

        public final int z() {
            return this.zze.size();
        }
    }
}
