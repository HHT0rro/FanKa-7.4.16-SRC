package com.taobao.wireless.security.adapter.datareport;

import android.content.Context;
import android.util.Log;
import com.alimm.tanx.core.constant.AdType;
import com.taobao.wireless.security.adapter.common.C0595;
import com.taobao.wireless.security.adapter.common.C0596;
import com.taobao.wireless.security.adapter.common.C0597;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class DataReportJniBridge {

    /* renamed from: а, reason: contains not printable characters */
    private static volatile int f236;

    /* renamed from: б, reason: contains not printable characters */
    private static volatile int f237;

    /* renamed from: в, reason: contains not printable characters */
    private static Class f238;

    /* renamed from: г, reason: contains not printable characters */
    private static Method f239;

    /* renamed from: д, reason: contains not printable characters */
    private static volatile int f240;

    /* renamed from: е, reason: contains not printable characters */
    private static volatile int f241;

    /* renamed from: ж, reason: contains not printable characters */
    private static volatile int f242;

    /* renamed from: з, reason: contains not printable characters */
    private static Class f243;

    /* renamed from: и, reason: contains not printable characters */
    private static Class f244;

    /* renamed from: й, reason: contains not printable characters */
    private static Method f245;

    /* renamed from: к, reason: contains not printable characters */
    private static Method f246;

    /* renamed from: л, reason: contains not printable characters */
    private static Context f247;

    /* renamed from: ё, reason: contains not printable characters */
    private static volatile int f248;

    public static int accsAvaiableBridge() {
        if (f237 == 0) {
            synchronized (DataReportJniBridge.class) {
                if (f237 == 0) {
                    try {
                        f238 = Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.AccsAdapter");
                        Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.AccsListner");
                        f239 = f238.getMethod("registerListner", Context.class);
                        f236 = 1;
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    }
                    f237 = 1;
                }
            }
        }
        return f236;
    }

    public static void initialize(Context context) {
        f247 = context;
    }

    public static int orangeAvailableBridge() {
        if (f248 == 0) {
            synchronized (DataReportJniBridge.class) {
                if (f248 == 0) {
                    try {
                        f243 = Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeAdapter");
                        Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener");
                        f245 = f243.getMethod("registerListener", Context.class);
                        f240 = 1;
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    }
                    f248 = 1;
                }
            }
        }
        return f240;
    }

    public static int registerAccsListnerBridge() {
        try {
            if (accsAvaiableBridge() != 0 && f247 != null) {
                f239.invoke(f238, f247);
                return 1;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int registerOrangeListenerBridge() {
        try {
            if (orangeAvailableBridge() != 0 && f247 != null) {
                f245.invoke(f243, f247);
                return 1;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int registerWindVaneListenerBridge() {
        int i10 = 0;
        try {
            if (windVaneCallBackAvailableBridge() != 0 && f247 != null) {
                f246.invoke(f244, f247);
                try {
                    Log.e("DataReportJniBridge", "registerWindVaneListenerBridge invoke success !!!");
                    return 1;
                } catch (Exception e2) {
                    e = e2;
                    i10 = 1;
                    Log.e("DataReportJniBridge", e.toString());
                    return i10;
                }
            }
            return 0;
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static String sendReportBridge(String str, String str2, Map<String, String> map, byte[] bArr) {
        String str3;
        String str4;
        HashMap hashMap = new HashMap();
        if (C0595.m2878(str2)) {
            hashMap.put("keyindex", str2);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        C0596 m2881 = C0597.m2881(str, hashMap, bArr, null, AdType.NATIVE_EXPRESS, AdType.NATIVE_EXPRESS);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.valueOf(m2881.f210));
        sb2.append("|");
        int i10 = m2881.f210;
        if (i10 != 200) {
            if (i10 == 1002 && (str3 = m2881.f211) != null && str3.length() > 0) {
                str4 = m2881.f211;
            }
            return sb2.toString();
        }
        str4 = m2881.f209;
        sb2.append(str4);
        return sb2.toString();
    }

    public static String sendReportBridge(String str, String str2, byte[] bArr) {
        return sendReportBridge(str, str2, null, bArr);
    }

    public static String sendReportBridgeHttps(String str, String str2, byte[] bArr) {
        HashMap hashMap;
        String str3;
        String str4;
        if (C0595.m2878(str2)) {
            hashMap = new HashMap();
            hashMap.put("keyindex", str2);
        } else {
            hashMap = null;
        }
        C0596 m2881 = C0597.m2881(str, hashMap, bArr, null, AdType.NATIVE_EXPRESS, AdType.NATIVE_EXPRESS);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.valueOf(m2881.f210));
        sb2.append("|");
        int i10 = m2881.f210;
        if (i10 != 200) {
            if (i10 == 1002 && (str3 = m2881.f211) != null && str3.length() > 0) {
                str4 = m2881.f211;
            }
            return sb2.toString();
        }
        str4 = m2881.f209;
        sb2.append(str4);
        return sb2.toString();
    }

    public static int windVaneCallBackAvailableBridge() {
        if (f242 == 0) {
            synchronized (DataReportJniBridge.class) {
                if (f242 == 0) {
                    try {
                        f244 = Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.WindvaneAdapter");
                        Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.WindvaneListener");
                        f246 = f244.getMethod("registerWindVaneListener", Context.class);
                        f241 = 1;
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    }
                    f242 = 1;
                }
            }
        }
        return f241;
    }
}
