package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f39906a = true;

    /* renamed from: b, reason: collision with root package name */
    public static List<o> f39907b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f39908c;

    /* renamed from: d, reason: collision with root package name */
    private static w f39909d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f39910e;

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (p.class) {
            if (f39910e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                String str = al.f39569b;
                return;
            }
            aa a10 = aa.a(context);
            if (a(a10)) {
                f39906a = false;
                return;
            }
            String e2 = a10.e();
            if (e2 == null) {
                String str2 = al.f39569b;
            } else {
                a(context, e2, a10.D, buglyStrategy);
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z10, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (p.class) {
            if (f39910e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                String str2 = al.f39569b;
                return;
            }
            if (str == null) {
                String str3 = al.f39569b;
                return;
            }
            f39910e = true;
            if (z10) {
                f39908c = true;
                al.f39570c = true;
                al.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                al.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                al.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                al.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                al.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                al.b("[init] Open debug mode of Bugly.", new Object[0]);
            }
            al.a(" crash report start initializing...", new Object[0]);
            al.b("[init] Bugly start initializing...", new Object[0]);
            al.a("[init] Bugly complete version: v%s", "4.1.9.2");
            Context a10 = ap.a(context);
            aa a11 = aa.a(a10);
            a11.o();
            ao.a(a10);
            f39909d = w.a(a10, f39907b);
            ai.a(a10);
            ac.a(a10, f39907b);
            u a12 = u.a(a10);
            if (a(a11)) {
                f39906a = false;
                return;
            }
            a11.f39488r = str;
            a11.b("APP_ID", str);
            al.a("[param] Set APP ID:%s", str);
            if (buglyStrategy != null) {
                String appVersion = buglyStrategy.getAppVersion();
                if (!TextUtils.isEmpty(appVersion)) {
                    if (appVersion.length() > 100) {
                        String substring = appVersion.substring(0, 100);
                        al.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                        appVersion = substring;
                    }
                    a11.f39485o = appVersion;
                    al.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                }
                try {
                    if (buglyStrategy.isReplaceOldChannel()) {
                        String appChannel = buglyStrategy.getAppChannel();
                        if (!TextUtils.isEmpty(appChannel)) {
                            if (appChannel.length() > 100) {
                                String substring2 = appChannel.substring(0, 100);
                                al.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                appChannel = substring2;
                            }
                            f39909d.a(MetricsProto.MetricsEvent.DIALOG_ZEN_TIMEPICKER, "app_channel", appChannel.getBytes(), false);
                            a11.f39489s = appChannel;
                        }
                    } else {
                        Map<String, byte[]> a13 = f39909d.a(MetricsProto.MetricsEvent.DIALOG_ZEN_TIMEPICKER, (v) null);
                        if (a13 != null && (bArr = a13.get("app_channel")) != null) {
                            a11.f39489s = new String(bArr);
                        }
                    }
                    al.a("[param] Set App channel: %s", a11.f39489s);
                } catch (Exception e2) {
                    if (f39908c) {
                        e2.printStackTrace();
                    }
                }
                String appPackageName = buglyStrategy.getAppPackageName();
                if (!TextUtils.isEmpty(appPackageName)) {
                    if (appPackageName.length() > 100) {
                        String substring3 = appPackageName.substring(0, 100);
                        al.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                        appPackageName = substring3;
                    }
                    a11.f39473c = appPackageName;
                    al.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                }
                String deviceID = buglyStrategy.getDeviceID();
                if (deviceID != null) {
                    if (deviceID.length() > 100) {
                        String substring4 = deviceID.substring(0, 100);
                        al.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                        deviceID = substring4;
                    }
                    a11.a(deviceID);
                    al.a("[param] Set device ID: %s", deviceID);
                }
                String deviceModel = buglyStrategy.getDeviceModel();
                if (deviceModel != null) {
                    a11.b(deviceModel);
                    al.a("[param] Set device model: %s", deviceModel);
                }
                a11.f39476f = buglyStrategy.isUploadProcess();
                ao.f39575b = buglyStrategy.isBuglyLogUpload();
            }
            for (int i10 = 0; i10 < f39907b.size(); i10++) {
                try {
                    if (a12.b(f39907b.get(i10).f39905id)) {
                        f39907b.get(i10).init(a10, z10, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            s.a(a10, buglyStrategy);
            long appReportDelay = buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L;
            final ac a14 = ac.a();
            a14.f39504c.a(new Thread() { // from class: com.tencent.bugly.idasc.proguard.ac.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    StrategyBean strategyBean;
                    String str4;
                    try {
                        Map<String, byte[]> a15 = w.a().a(ac.f39500a, (v) null);
                        if (a15 != null) {
                            byte[] bArr2 = a15.get(com.alipay.sdk.packet.e.f4642n);
                            byte[] bArr3 = a15.get("gateway");
                            if (bArr2 != null) {
                                aa.a(ac.this.f39508h).d(new String(bArr2));
                            }
                            if (bArr3 != null) {
                                aa.a(ac.this.f39508h).c(new String(bArr3));
                            }
                        }
                        ac.this.f39507g = ac.d();
                        if (ac.this.f39507g != null) {
                            if (ap.b(ac.f39503i) || !ap.d(ac.f39503i)) {
                                ac.this.f39507g.f39401q = StrategyBean.f39385a;
                                strategyBean = ac.this.f39507g;
                                str4 = StrategyBean.f39386b;
                            } else {
                                ac.this.f39507g.f39401q = ac.f39503i;
                                strategyBean = ac.this.f39507g;
                                str4 = ac.f39503i;
                            }
                            strategyBean.f39402r = str4;
                        }
                    } catch (Throwable th2) {
                        if (!al.a(th2)) {
                            th2.printStackTrace();
                        }
                    }
                    ac acVar = ac.this;
                    acVar.a(acVar.f39507g, false);
                }
            }, appReportDelay);
            al.b("[init] Bugly initialization finished.", new Object[0]);
        }
    }

    public static synchronized void a(o oVar) {
        synchronized (p.class) {
            if (!f39907b.contains(oVar)) {
                f39907b.add(oVar);
            }
        }
    }

    private static boolean a(aa aaVar) {
        List<String> list = aaVar.f39492v;
        return list != null && list.contains("bugly");
    }
}
