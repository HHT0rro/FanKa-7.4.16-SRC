package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4697a = "00:00:00:00:00:00";

    /* renamed from: e, reason: collision with root package name */
    private static a f4698e;

    /* renamed from: b, reason: collision with root package name */
    private String f4699b;

    /* renamed from: c, reason: collision with root package name */
    private String f4700c;

    /* renamed from: d, reason: collision with root package name */
    private String f4701d;

    private a(Context context) {
        try {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                b(telephonyManager.getDeviceId());
                a(telephonyManager.getSubscriberId());
                String macAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
                this.f4701d = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!TextUtils.isEmpty(this.f4701d)) {
                    return;
                }
            }
            this.f4701d = f4697a;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f4701d)) {
                this.f4701d = f4697a;
            }
            throw th;
        }
    }

    public static a a(Context context) {
        if (f4698e == null) {
            f4698e = new a(context);
        }
        return f4698e;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f4700c)) {
            this.f4700c = "000000000000000";
        }
        return this.f4700c;
    }

    public String c() {
        String str = b() + "|";
        String a10 = a();
        if (TextUtils.isEmpty(a10)) {
            return str + "000000000000000";
        }
        return str + a10;
    }

    public String d() {
        return this.f4701d;
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f4699b)) {
            this.f4699b = "000000000000000";
        }
        return this.f4699b;
    }

    public void b(String str) {
        if (str != null) {
            byte[] bytes = str.getBytes();
            for (int i10 = 0; i10 < bytes.length; i10++) {
                if (bytes[i10] < 48 || bytes[i10] > 57) {
                    bytes[i10] = 48;
                }
            }
            str = (new String(bytes) + "000000000000000").substring(0, 15);
        }
        this.f4700c = str;
    }

    public static String c(Context context) {
        return a(context).c().substring(0, 8);
    }

    public void a(String str) {
        if (str != null) {
            str = (str + "000000000000000").substring(0, 15);
        }
        this.f4699b = str;
    }

    public static d b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                return d.a(activeNetworkInfo.getSubtype());
            }
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                return d.WIFI;
            }
            return d.NONE;
        } catch (Exception unused) {
            return d.NONE;
        }
    }
}
