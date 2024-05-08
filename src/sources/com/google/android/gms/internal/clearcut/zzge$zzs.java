package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.x0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzge$zzs extends x0<zzge$zzs, a> implements c2 {
    private static final zzge$zzs zzbfc;
    private static volatile k2<zzge$zzs> zzbg;
    private int zzbb;
    private int zzbfa = -1;
    private int zzbfb;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x0.a<zzge$zzs, a> implements c2 {
        public a() {
            super(zzge$zzs.zzbfc);
        }

        public /* synthetic */ a(g4 g4Var) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum zzb implements a1 {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);

        private static final b1<zzb> zzbq = new p4();
        private final int value;

        zzb(int i10) {
            this.value = i10;
        }

        public static zzb zzaz(int i10) {
            if (i10 == 100) {
                return COMBINED;
            }
            switch (i10) {
                case 0:
                    return UNKNOWN_MOBILE_SUBTYPE;
                case 1:
                    return GPRS;
                case 2:
                    return EDGE;
                case 3:
                    return UMTS;
                case 4:
                    return CDMA;
                case 5:
                    return EVDO_0;
                case 6:
                    return EVDO_A;
                case 7:
                    return RTT;
                case 8:
                    return HSDPA;
                case 9:
                    return HSUPA;
                case 10:
                    return HSPA;
                case 11:
                    return IDEN;
                case 12:
                    return EVDO_B;
                case 13:
                    return LTE;
                case 14:
                    return EHRPD;
                case 15:
                    return HSPAP;
                case 16:
                    return GSM;
                case 17:
                    return TD_SCDMA;
                case 18:
                    return IWLAN;
                case 19:
                    return LTE_CA;
                default:
                    return null;
            }
        }

        public static b1<zzb> zzd() {
            return zzbq;
        }

        @Override // com.google.android.gms.internal.clearcut.a1
        public final int zzc() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum zzc implements a1 {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);

        private static final b1<zzc> zzbq = new q4();
        private final int value;

        zzc(int i10) {
            this.value = i10;
        }

        public static zzc zzba(int i10) {
            switch (i10) {
                case -1:
                    return NONE;
                case 0:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 2:
                    return MOBILE_MMS;
                case 3:
                    return MOBILE_SUPL;
                case 4:
                    return MOBILE_DUN;
                case 5:
                    return MOBILE_HIPRI;
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 8:
                    return DUMMY;
                case 9:
                    return ETHERNET;
                case 10:
                    return MOBILE_FOTA;
                case 11:
                    return MOBILE_IMS;
                case 12:
                    return MOBILE_CBS;
                case 13:
                    return WIFI_P2P;
                case 14:
                    return MOBILE_IA;
                case 15:
                    return MOBILE_EMERGENCY;
                case 16:
                    return PROXY;
                case 17:
                    return VPN;
                default:
                    return null;
            }
        }

        public static b1<zzc> zzd() {
            return zzbq;
        }

        @Override // com.google.android.gms.internal.clearcut.a1
        public final int zzc() {
            return this.value;
        }
    }

    static {
        zzge$zzs zzge_zzs = new zzge$zzs();
        zzbfc = zzge_zzs;
        x0.l(zzge$zzs.class, zzge_zzs);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.x0$b, com.google.android.gms.internal.clearcut.k2<com.google.android.gms.internal.clearcut.zzge$zzs>] */
    @Override // com.google.android.gms.internal.clearcut.x0
    public final Object i(int i10, Object obj, Object obj2) {
        k2<zzge$zzs> k2Var;
        g4 g4Var = null;
        switch (g4.f23908a[i10 - 1]) {
            case 1:
                return new zzge$zzs();
            case 2:
                return new a(g4Var);
            case 3:
                return x0.j(zzbfc, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzbb", "zzbfa", zzc.zzd(), "zzbfb", zzb.zzd()});
            case 4:
                return zzbfc;
            case 5:
                k2<zzge$zzs> k2Var2 = zzbg;
                k2<zzge$zzs> k2Var3 = k2Var2;
                if (k2Var2 == null) {
                    synchronized (zzge$zzs.class) {
                        k2<zzge$zzs> k2Var4 = zzbg;
                        k2Var = k2Var4;
                        if (k2Var4 == null) {
                            ?? bVar = new x0.b(zzbfc);
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
