package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.Context;
import android.os.Build;
import com.hailiang.advlib.core.ADEvent;
import com.ishumei.smantifraud.SmAntiFraud;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l1111llIl {
    private static final long l1111l111111Il = 2000;
    private static boolean l111l11111Il = false;
    private static boolean l111l1111l1Il = false;
    private static String l111l1111lI1l = "build1";
    private static String l111l1111lIl = "android";
    private static String l111l1111llIl = "3.7.3";
    private static final String l11l1111I11l = "fp-it.fengkongcloud.com";
    private static final String l11l1111I1l = "api-fp-retry-bj.fengkongcloud.com";
    private static final String l11l1111I1ll = "fp-sa-it.fengkongcloud.com";
    private static final String l11l1111Il = "api-fp-retry-sa.fengkongcloud.com";
    private static final String l11l1111Il1l = "fp-na-it-acc.fengkongcloud.com";
    private static final String l11l1111Ill = "api-fp-retry-na.fengkongcloud.com";
    private static int l11l1111lIIl = 30;
    private static final String l11l111l11Il = "/v3/cloudconf";
    private static final String l11l11IlIIll = "/deviceprofile/v4";
    private l111l1111lI1l l111l11111I1l;
    private final Context l111l11111lIl;

    public l111l1111llIl() {
    }

    public l111l1111llIl(Context context) {
        l111l1111lI1l l111l1111li1l;
        this.l111l11111lIl = context;
        if (context != null) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains("asus")) {
                l111l1111li1l = new l1111l111111Il(context);
            } else if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
                l111l1111li1l = new l111l11111lIl(context);
            } else if (lowerCase.contains("lenovo")) {
                l111l1111li1l = new l111l11111I1l(context);
            } else if (lowerCase.contains("meizu")) {
                l111l1111li1l = new l111l11111Il(context);
            } else if (lowerCase.contains("nubia")) {
                l111l1111li1l = new l111l1111l1Il(context);
            } else if (lowerCase.contains("oneplus")) {
                l111l1111li1l = new l111l1111lIl(context);
            } else if (lowerCase.contains("oppo")) {
                l111l1111li1l = new l11l1111lIIl(context);
            } else if (lowerCase.contains("samsung")) {
                l111l1111li1l = new l11l1111I11l(context);
            } else if (lowerCase.contains(ADEvent.VIVO)) {
                l111l1111li1l = new l11l1111I1l(context);
            } else if (lowerCase.contains(ADEvent.XIAOMI)) {
                l111l1111li1l = new l11l1111I1ll(context);
            } else if (lowerCase.contains("zte")) {
                l111l1111li1l = new l11l1111Il(context);
            }
            this.l111l11111I1l = l111l1111li1l;
        }
        l111l1111li1l = null;
        this.l111l11111I1l = l111l1111li1l;
    }

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
        return l1111l111111Il(z10) + l111l11111Il(str, false) + l11l11IlIIll;
    }

    private static String l1111l111111Il(boolean z10) {
        return z10 ? "https://" : "http://";
    }

    public static String l111l11111I1l(String str, boolean z10) {
        return l1111l111111Il(z10) + l111l11111Il(str, false) + l11l111l11Il;
    }

    private static String l111l11111Il(String str, boolean z10) {
        str.hashCode();
        return !str.equals(SmAntiFraud.AREA_XJP) ? !str.equals(SmAntiFraud.AREA_FJNY) ? z10 ? l11l1111I1l : l11l1111I11l : z10 ? l11l1111Ill : l11l1111Il1l : z10 ? l11l1111Il : l11l1111I1ll;
    }

    private l111l1111lI1l l111l11111lIl() {
        if (this.l111l11111lIl == null) {
            return null;
        }
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        if (lowerCase.contains("asus")) {
            return new l1111l111111Il(this.l111l11111lIl);
        }
        if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
            return new l111l11111lIl(this.l111l11111lIl);
        }
        if (lowerCase.contains("lenovo")) {
            return new l111l11111I1l(this.l111l11111lIl);
        }
        if (lowerCase.contains("meizu")) {
            return new l111l11111Il(this.l111l11111lIl);
        }
        if (lowerCase.contains("nubia")) {
            return new l111l1111l1Il(this.l111l11111lIl);
        }
        if (lowerCase.contains("oneplus")) {
            return new l111l1111lIl(this.l111l11111lIl);
        }
        if (lowerCase.contains("oppo")) {
            return new l11l1111lIIl(this.l111l11111lIl);
        }
        if (lowerCase.contains("samsung")) {
            return new l11l1111I11l(this.l111l11111lIl);
        }
        if (lowerCase.contains(ADEvent.VIVO)) {
            return new l11l1111I1l(this.l111l11111lIl);
        }
        if (lowerCase.contains(ADEvent.XIAOMI)) {
            return new l11l1111I1ll(this.l111l11111lIl);
        }
        if (lowerCase.contains("zte")) {
            return new l11l1111Il(this.l111l11111lIl);
        }
        return null;
    }

    public static String l111l11111lIl(String str, boolean z10) {
        return l1111l111111Il(z10) + l111l11111Il(str, true) + l11l11IlIIll;
    }

    public final String l1111l111111Il() {
        l111l1111lI1l l111l1111li1l = this.l111l11111I1l;
        return l111l1111li1l == null ? "" : l111l1111li1l.l1111l111111Il(l1111l111111Il);
    }
}
