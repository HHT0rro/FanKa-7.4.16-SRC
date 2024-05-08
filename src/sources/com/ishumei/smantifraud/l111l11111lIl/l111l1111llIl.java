package com.ishumei.smantifraud.l111l11111lIl;

import com.ishumei.smantifraud.SmAntiFraud;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111llIl {
    private static boolean l1111l111111Il = false;
    private static String l111l11111I1l = "3.7.3";
    private static String l111l11111Il = "build1";
    private static boolean l111l11111lIl = false;
    private static String l111l1111l1Il = "android";
    private static final String l111l1111lI1l = "fp-it.fengkongcloud.com";
    private static final String l111l1111lIl = "api-fp-retry-bj.fengkongcloud.com";
    private static int l111l1111llIl = 30;
    private static final String l11l1111I11l = "api-fp-retry-sa.fengkongcloud.com";
    private static final String l11l1111I1l = "fp-na-it-acc.fengkongcloud.com";
    private static final String l11l1111I1ll = "api-fp-retry-na.fengkongcloud.com";
    private static final String l11l1111Il = "/deviceprofile/v4";
    private static final String l11l1111Il1l = "/v3/cloudconf";
    private static final String l11l1111lIIl = "fp-sa-it.fengkongcloud.com";

    public static String l1111l111111Il(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 3144:
                if (str.equals(SmAntiFraud.AREA_BJ)) {
                    c4 = 0;
                    break;
                }
                break;
            case 118718:
                if (str.equals(SmAntiFraud.AREA_XJP)) {
                    c4 = 1;
                    break;
                }
                break;
            case 3144079:
                if (str.equals(SmAntiFraud.AREA_FJNY)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "001";
            case 1:
                return "010";
            case 2:
                return "011";
            default:
                return str;
        }
    }

    public static String l1111l111111Il(String str, boolean z10) {
        return l1111l111111Il(z10) + l111l11111Il(str, false) + l11l1111Il;
    }

    private static String l1111l111111Il(boolean z10) {
        return z10 ? "https://" : "http://";
    }

    public static String l111l11111I1l(String str, boolean z10) {
        return l1111l111111Il(z10) + l111l11111Il(str, false) + l11l1111Il1l;
    }

    private static String l111l11111Il(String str, boolean z10) {
        str.hashCode();
        return !str.equals(SmAntiFraud.AREA_XJP) ? !str.equals(SmAntiFraud.AREA_FJNY) ? z10 ? l111l1111lIl : l111l1111lI1l : z10 ? l11l1111I1ll : l11l1111I1l : z10 ? l11l1111I11l : l11l1111lIIl;
    }

    public static String l111l11111lIl(String str, boolean z10) {
        return l1111l111111Il(z10) + l111l11111Il(str, true) + l11l1111Il;
    }
}
