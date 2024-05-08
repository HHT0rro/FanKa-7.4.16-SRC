package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v4 extends x0<v4, a> implements c2 {
    private static volatile k2<v4> zzbg;
    private static final v4 zzbir;
    private c1<b> zzbiq = x0.n();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x0.a<v4, a> implements c2 {
        public a() {
            super(v4.zzbir);
        }

        public /* synthetic */ a(w4 w4Var) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends x0<b, a> implements c2 {
        private static volatile k2<b> zzbg;
        private static final b zzbiv;
        private int zzbb;
        private String zzbis = "";
        private long zzbit;
        private long zzbiu;
        private int zzya;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static final class a extends x0.a<b, a> implements c2 {
            public a() {
                super(b.zzbiv);
            }

            public /* synthetic */ a(w4 w4Var) {
                this();
            }

            public final a n(String str) {
                k();
                ((b) this.f24076c).z(str);
                return this;
            }

            public final a o(long j10) {
                k();
                ((b) this.f24076c).A(j10);
                return this;
            }

            public final a p(long j10) {
                k();
                ((b) this.f24076c).B(j10);
                return this;
            }
        }

        static {
            b bVar = new b();
            zzbiv = bVar;
            x0.l(b.class, bVar);
        }

        public static a x() {
            return (a) ((x0.a) zzbiv.i(x0.e.f24085e, null, null));
        }

        public final void A(long j10) {
            this.zzbb |= 4;
            this.zzbit = j10;
        }

        public final void B(long j10) {
            this.zzbb |= 8;
            this.zzbiu = j10;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.k2<com.google.android.gms.internal.clearcut.v4$b>, com.google.android.gms.internal.clearcut.x0$b] */
        @Override // com.google.android.gms.internal.clearcut.x0
        public final Object i(int i10, Object obj, Object obj2) {
            k2<b> k2Var;
            w4 w4Var = null;
            switch (w4.f24071a[i10 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a(w4Var);
                case 3:
                    return x0.j(zzbiv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003", new Object[]{"zzbb", "zzya", "zzbis", "zzbit", "zzbiu"});
                case 4:
                    return zzbiv;
                case 5:
                    k2<b> k2Var2 = zzbg;
                    k2<b> k2Var3 = k2Var2;
                    if (k2Var2 == null) {
                        synchronized (b.class) {
                            k2<b> k2Var4 = zzbg;
                            k2Var = k2Var4;
                            if (k2Var4 == null) {
                                ?? bVar = new x0.b(zzbiv);
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

        public final int p() {
            return this.zzya;
        }

        public final boolean t() {
            return (this.zzbb & 1) == 1;
        }

        public final String u() {
            return this.zzbis;
        }

        public final long v() {
            return this.zzbit;
        }

        public final long w() {
            return this.zzbiu;
        }

        public final void z(String str) {
            Objects.requireNonNull(str);
            this.zzbb |= 2;
            this.zzbis = str;
        }
    }

    static {
        v4 v4Var = new v4();
        zzbir = v4Var;
        x0.l(v4.class, v4Var);
    }

    public static v4 q() {
        return zzbir;
    }

    public static v4 s(byte[] bArr) throws zzco {
        return (v4) x0.m(zzbir, bArr);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.x0$b, com.google.android.gms.internal.clearcut.k2<com.google.android.gms.internal.clearcut.v4>] */
    @Override // com.google.android.gms.internal.clearcut.x0
    public final Object i(int i10, Object obj, Object obj2) {
        k2<v4> k2Var;
        w4 w4Var = null;
        switch (w4.f24071a[i10 - 1]) {
            case 1:
                return new v4();
            case 2:
                return new a(w4Var);
            case 3:
                return x0.j(zzbir, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbiq", b.class});
            case 4:
                return zzbir;
            case 5:
                k2<v4> k2Var2 = zzbg;
                k2<v4> k2Var3 = k2Var2;
                if (k2Var2 == null) {
                    synchronized (v4.class) {
                        k2<v4> k2Var4 = zzbg;
                        k2Var = k2Var4;
                        if (k2Var4 == null) {
                            ?? bVar = new x0.b(zzbir);
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

    public final List<b> p() {
        return this.zzbiq;
    }
}
