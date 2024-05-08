package com.mobile.auth.h;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.mobile.auth.n.c;
import com.mobile.auth.n.g;
import com.mobile.auth.n.m;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f37404a;

    /* renamed from: b, reason: collision with root package name */
    private static long f37405b;

    /* renamed from: c, reason: collision with root package name */
    private C0561a f37406c = null;

    /* renamed from: com.mobile.auth.h.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0561a {

        /* renamed from: a, reason: collision with root package name */
        private int f37407a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f37408b = -1;

        public int a() {
            return this.f37408b;
        }
    }

    private a() {
    }

    public static a a() {
        if (f37404a == null) {
            f37404a = new a();
        }
        return f37404a;
    }

    private void a(Context context, boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        SubscriptionManager from = SubscriptionManager.from(context.getApplicationContext());
        if (from != null) {
            try {
                if (this.f37406c.f37407a == -1 && i10 >= 24) {
                    this.f37406c.f37408b = SubscriptionManager.getDefaultDataSubscriptionId();
                    c.b("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配成功: dataSubId = " + this.f37406c.f37408b);
                    return;
                }
            } catch (Exception unused) {
                c.a("UMCTelephonyManagement", "android 7.0及以上手机getDefaultDataSubscriptionId适配失败");
            }
            try {
                Object invoke = from.getClass().getMethod("getDefaultDataSubId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke instanceof Integer) || (invoke instanceof Long)) {
                    this.f37406c.f37408b = ((Integer) invoke).intValue();
                    c.b("UMCTelephonyManagement", "android 7.0以下手机getDefaultDataSubId适配成功: dataSubId = " + this.f37406c.f37408b);
                    return;
                }
            } catch (Exception unused2) {
                c.a("UMCTelephonyManagement", "readDefaultDataSubId-->getDefaultDataSubId 反射出错");
            }
            try {
                Object invoke2 = from.getClass().getMethod("getDefaultDataSubscriptionId", new Class[0]).invoke(from, new Object[0]);
                if ((invoke2 instanceof Integer) || (invoke2 instanceof Long)) {
                    this.f37406c.f37408b = ((Integer) invoke2).intValue();
                    c.b("UMCTelephonyManagement", "反射getDefaultDataSubscriptionId适配成功: dataSubId = " + this.f37406c.f37408b);
                }
            } catch (Exception unused3) {
                c.a("UMCTelephonyManagement", "getDefaultDataSubscriptionId-->getDefaultDataSubscriptionId 反射出错");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        if (r11 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        com.mobile.auth.n.c.b("UMCTelephonyManagement", "readSimInfoDbEnd");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0089, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        if (r11 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "sim_id"
            java.lang.String r1 = "_id"
            java.lang.String r2 = "UMCTelephonyManagement"
            java.lang.String r3 = "readSimInfoDbStart"
            com.mobile.auth.n.c.b(r2, r3)
            java.lang.String r3 = "content://telephony/siminfo"
            android.net.Uri r5 = android.net.Uri.parse(r3)
            android.content.ContentResolver r4 = r11.getContentResolver()
            r11 = 0
            java.lang.String[] r6 = new java.lang.String[]{r1, r0}     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            java.lang.String r7 = "sim_id>=?"
            java.lang.String r3 = "0"
            java.lang.String[] r8 = new java.lang.String[]{r3}     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            r9 = 0
            android.database.Cursor r11 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            if (r11 == 0) goto L7f
        L29:
            boolean r3 = r11.moveToNext()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            if (r3 == 0) goto L7f
            int r3 = r11.getColumnIndex(r0)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            int r3 = r11.getInt(r3)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            int r4 = r11.getColumnIndex(r1)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            int r4 = r11.getInt(r4)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            com.mobile.auth.h.a$a r5 = r10.f37406c     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            int r5 = com.mobile.auth.h.a.C0561a.b(r5)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            r6 = -1
            if (r5 != r6) goto L71
            com.mobile.auth.h.a$a r5 = r10.f37406c     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            int r5 = com.mobile.auth.h.a.C0561a.a(r5)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            if (r5 == r6) goto L71
            com.mobile.auth.h.a$a r5 = r10.f37406c     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            int r5 = com.mobile.auth.h.a.C0561a.a(r5)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            if (r5 != r4) goto L71
            com.mobile.auth.h.a$a r5 = r10.f37406c     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            com.mobile.auth.h.a.C0561a.a(r5, r3)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            r5.<init>()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            java.lang.String r6 = "通过读取sim db获取数据流量卡的卡槽值："
            r5.append(r6)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            r5.append(r3)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            com.mobile.auth.n.c.b(r2, r5)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
        L71:
            com.mobile.auth.h.a$a r5 = r10.f37406c     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            int r5 = com.mobile.auth.h.a.C0561a.b(r5)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            if (r5 != r3) goto L29
            com.mobile.auth.h.a$a r3 = r10.f37406c     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            com.mobile.auth.h.a.C0561a.b(r3, r4)     // Catch: java.lang.Exception -> L82 java.lang.Throwable -> L92
            goto L29
        L7f:
            if (r11 == 0) goto L8c
            goto L89
        L82:
            java.lang.String r0 = "readSimInfoDb error"
            com.mobile.auth.n.c.a(r2, r0)     // Catch: java.lang.Throwable -> L92
            if (r11 == 0) goto L8c
        L89:
            r11.close()
        L8c:
            java.lang.String r11 = "readSimInfoDbEnd"
            com.mobile.auth.n.c.b(r2, r11)
            return
        L92:
            r0 = move-exception
            if (r11 == 0) goto L98
            r11.close()
        L98:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.h.a.b(android.content.Context):void");
    }

    private int c(Context context) {
        TelephonyManager telephonyManager;
        if (!g.a(context, com.kuaishou.weapon.p0.g.f36117c) || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone")) == null) {
            return -1;
        }
        if (!m.d()) {
            return telephonyManager.getDataNetworkType();
        }
        try {
            Method method = telephonyManager.getClass().getMethod("getDataNetworkType", Integer.TYPE);
            c.b("UMCTelephonyManagement", "data dataNetworkType defaultDataSubId = " + this.f37406c.f37408b);
            int intValue = ((Integer) method.invoke(telephonyManager, Integer.valueOf(this.f37406c.f37408b))).intValue();
            c.b("UMCTelephonyManagement", "data dataNetworkType ---------" + intValue);
            if (intValue != 0 || Build.VERSION.SDK_INT < 24) {
                return intValue;
            }
            c.b("UMCTelephonyManagement", "data dataNetworkType ---->=N " + intValue);
            return telephonyManager.getDataNetworkType();
        } catch (Exception e2) {
            c.a("UMCTelephonyManagement", "data dataNetworkType ----反射出错-----");
            e2.printStackTrace();
            return -1;
        }
    }

    public String a(Context context) {
        switch (c(context)) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "1";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "2";
            case 13:
            case 18:
            case 19:
                return "3";
            case 20:
                return "4";
            default:
                return "0";
        }
    }

    public void a(Context context, boolean z10, boolean z11) {
        long currentTimeMillis = System.currentTimeMillis() - f37405b;
        if (currentTimeMillis >= 5000 || currentTimeMillis <= 0) {
            this.f37406c = new C0561a();
            if (z11) {
                a(context, z10);
                if (m.e() && m.d()) {
                    c.b("UMCTelephonyManagement", "华为手机兼容性处理");
                    if (this.f37406c.f37408b == 0 || this.f37406c.f37408b == 1) {
                        if (this.f37406c.f37407a == -1) {
                            C0561a c0561a = this.f37406c;
                            c0561a.f37407a = c0561a.f37408b;
                        }
                        this.f37406c.f37408b = -1;
                    }
                    if (this.f37406c.f37407a != -1 || this.f37406c.f37408b != -1) {
                        b(context);
                    }
                }
                f37405b = System.currentTimeMillis();
            }
        }
    }

    public C0561a b() {
        C0561a c0561a = this.f37406c;
        return c0561a == null ? new C0561a() : c0561a;
    }
}
