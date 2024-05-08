package com.mobile.auth.n;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.irisdt.util.NetworkUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static j f37520b;

    /* renamed from: a, reason: collision with root package name */
    private final Context f37521a;

    private j(Context context) {
        this.f37521a = context;
    }

    public static j a() {
        return f37520b;
    }

    public static void a(Context context) {
        f37520b = new j(context);
    }

    private String b(String str) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 49679470:
                if (str.equals("46000")) {
                    c4 = 0;
                    break;
                }
                break;
            case 49679471:
                if (str.equals("46001")) {
                    c4 = 1;
                    break;
                }
                break;
            case 49679472:
                if (str.equals("46002")) {
                    c4 = 2;
                    break;
                }
                break;
            case 49679473:
                if (str.equals("46003")) {
                    c4 = 3;
                    break;
                }
                break;
            case 49679474:
                if (str.equals("46004")) {
                    c4 = 4;
                    break;
                }
                break;
            case 49679475:
                if (str.equals("46005")) {
                    c4 = 5;
                    break;
                }
                break;
            case 49679476:
                if (str.equals("46006")) {
                    c4 = 6;
                    break;
                }
                break;
            case 49679477:
                if (str.equals("46007")) {
                    c4 = 7;
                    break;
                }
                break;
            case 49679479:
                if (str.equals("46009")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 49679502:
                if (str.equals("46011")) {
                    c4 = '\t';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 2:
            case 4:
            case 7:
                c.a("SIMUtils", NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_MOBILE);
                return "1";
            case 1:
            case 6:
            case '\b':
                c.a("SIMUtils", NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_UNICOM);
                return "2";
            case 3:
            case 5:
            case '\t':
                c.a("SIMUtils", NetworkUtils.NETWORK_CHINA_OPERATOR.CHINA_TELECOM);
                return "3";
            default:
                return "0";
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        return b(str);
    }

    public String b() {
        try {
            int a10 = com.mobile.auth.h.a.a().b().a();
            return a10 >= 0 ? Integer.toString(a10) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String c() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f37521a.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String simOperator = telephonyManager.getSimOperator();
        c.b("SIMUtils", "SysOperator= " + simOperator);
        return simOperator;
    }
}
