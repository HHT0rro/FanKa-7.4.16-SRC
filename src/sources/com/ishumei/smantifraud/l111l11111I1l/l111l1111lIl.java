package com.ishumei.smantifraud.l111l11111I1l;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.g;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111lIl {
    private static final int l1111l111111Il = -1;
    private static final int l111l11111lIl = -101;
    private Context l111l11111I1l;
    private Object l111l11111Il = null;

    public l111l1111lIl() {
        this.l111l11111I1l = null;
        try {
            this.l111l11111I1l = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        } catch (Exception unused) {
        }
    }

    public static String l1111l111111Il() {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (TextUtils.isEmpty(property2)) {
                property2 = "-1";
            }
            if (TextUtils.isEmpty(property)) {
                return "";
            }
            return property + u.bD + property2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String l1111l111111Il(int i10) {
        if (i10 == -101) {
            return "wifi";
        }
        switch (i10) {
            case -1:
                return "nil";
            case 0:
                return "unknown";
            case 1:
                return "2g.gprs";
            case 2:
                return "2g.edge";
            case 3:
                return "3g.umts";
            case 4:
                return "2g.cdma";
            case 5:
                return "3g.evdo_0";
            case 6:
                return "3g.evdo_a";
            case 7:
                return "2g.1xrtt";
            case 8:
                return "3g.hsdpa";
            case 9:
                return "3g.hsupa";
            case 10:
                return "3g.hspa";
            case 11:
                return "2g.iden";
            case 12:
                return "3g.evdo_b";
            case 13:
                return "4g.lte";
            case 14:
                return "3g.ehrpd";
            case 15:
                return "3g.hspap";
            default:
                return String.format(Locale.US, "%d", Integer.valueOf(i10));
        }
    }

    public static Map<String, Long> l111l11111lIl() {
        HashMap hashMap = new HashMap(5);
        hashMap.put("mr", Long.valueOf(TrafficStats.getMobileRxBytes()));
        hashMap.put("mt", Long.valueOf(TrafficStats.getMobileTxBytes()));
        hashMap.put("tr", Long.valueOf(TrafficStats.getTotalRxBytes()));
        hashMap.put("tt", Long.valueOf(TrafficStats.getTotalTxBytes()));
        return hashMap;
    }

    private void l111l1111lI1l() {
        Object l1111l111111Il2;
        try {
            Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
            if (context == null || (l1111l111111Il2 = com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(context, "getSystemService", new Class[]{String.class}, new Object[]{"wifi"})) == null || this.l111l11111Il != null) {
                return;
            }
            this.l111l11111Il = com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(l1111l111111Il2, "getConnectionInfo");
        } catch (Exception unused) {
        }
    }

    private String l111l1111lIl() {
        int i10;
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.l111l11111I1l.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                i10 = -101;
            } else {
                if (type == 0) {
                    i10 = ((TelephonyManager) this.l111l11111I1l.getSystemService("phone")).getNetworkType();
                }
                i10 = 0;
            }
        } else {
            i10 = -1;
        }
        if (i10 == -101) {
            return "wifi";
        }
        switch (i10) {
            case -1:
                return "nil";
            case 0:
                return "unknown";
            case 1:
                return "2g.gprs";
            case 2:
                return "2g.edge";
            case 3:
                return "3g.umts";
            case 4:
                return "2g.cdma";
            case 5:
                return "3g.evdo_0";
            case 6:
                return "3g.evdo_a";
            case 7:
                return "2g.1xrtt";
            case 8:
                return "3g.hsdpa";
            case 9:
                return "3g.hsupa";
            case 10:
                return "3g.hspa";
            case 11:
                return "2g.iden";
            case 12:
                return "3g.evdo_b";
            case 13:
                return "4g.lte";
            case 14:
                return "3g.ehrpd";
            case 15:
                return "3g.hspap";
            default:
                return String.format(Locale.US, "%d", Integer.valueOf(i10));
        }
    }

    public final String l111l11111I1l() {
        try {
            if (!com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l11111lIl(g.f36118d)) {
                return "";
            }
            l111l1111lI1l();
            Object obj = this.l111l11111Il;
            if (obj == null) {
                return "";
            }
            String str = (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "getSSID");
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String l111l11111Il() {
        try {
            if (!com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l111l11111lIl(g.f36118d)) {
                return "";
            }
            l111l1111lI1l();
            Object obj = this.l111l11111Il;
            if (obj == null) {
                return "";
            }
            String str = (String) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "getBSSID");
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String l111l1111l1Il() {
        try {
            l111l1111lI1l();
            Object obj = this.l111l11111Il;
            if (obj == null) {
                return "";
            }
            String formatIpAddress = Formatter.formatIpAddress(((Integer) com.ishumei.smantifraud.l111l1111llIl.l111l11111I1l.l1111l111111Il(obj, "getIpAddress")).intValue());
            return formatIpAddress == null ? "" : formatIpAddress;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String l111l1111llIl() {
        try {
            if (this.l111l11111I1l == null) {
                return "";
            }
            String l111l1111lIl = l111l1111lIl();
            return l111l1111lIl == null ? "" : l111l1111lIl;
        } catch (Exception unused) {
            return "";
        }
    }
}
