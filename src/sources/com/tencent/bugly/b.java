package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f39029a = true;

    /* renamed from: b, reason: collision with root package name */
    public static List<a> f39030b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f39031c;

    /* renamed from: d, reason: collision with root package name */
    private static p f39032d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f39033e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.f39107o;
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (f39033e) {
                x.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                String str = x.f40235a;
                return;
            }
            com.tencent.bugly.crashreport.common.info.a a10 = com.tencent.bugly.crashreport.common.info.a.a(context);
            if (a(a10)) {
                f39029a = false;
                return;
            }
            String f10 = a10.f();
            if (f10 == null) {
                String str2 = x.f40235a;
            } else {
                a(context, f10, a10.f39113u, buglyStrategy);
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z10, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (b.class) {
            if (f39033e) {
                x.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                String str2 = x.f40235a;
                return;
            }
            if (str == null) {
                String str3 = x.f40235a;
                return;
            }
            f39033e = true;
            if (z10) {
                f39031c = true;
                x.f40236b = true;
                x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                x.e("--------------------------------------------------------------------------------------------", new Object[0]);
                x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                x.e("--------------------------------------------------------------------------------------------", new Object[0]);
                x.b("[init] Open debug mode of Bugly.", new Object[0]);
            }
            x.a(" crash report start initializing...", new Object[0]);
            x.b("[init] Bugly start initializing...", new Object[0]);
            x.a("[init] Bugly complete version: v%s", "3.4.4");
            Context a10 = z.a(context);
            com.tencent.bugly.crashreport.common.info.a a11 = com.tencent.bugly.crashreport.common.info.a.a(a10);
            a11.p();
            y.a(a10);
            f39032d = p.a(a10, f39030b);
            u.a(a10);
            com.tencent.bugly.crashreport.common.strategy.a a12 = com.tencent.bugly.crashreport.common.strategy.a.a(a10, f39030b);
            n a13 = n.a(a10);
            if (a(a11)) {
                f39029a = false;
                return;
            }
            a11.a(str);
            x.a("[param] Set APP ID:%s", str);
            if (buglyStrategy != null) {
                String appVersion = buglyStrategy.getAppVersion();
                if (!TextUtils.isEmpty(appVersion)) {
                    if (appVersion.length() > 100) {
                        String substring = appVersion.substring(0, 100);
                        x.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                        appVersion = substring;
                    }
                    a11.f39102j = appVersion;
                    x.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                }
                try {
                    if (buglyStrategy.isReplaceOldChannel()) {
                        String appChannel = buglyStrategy.getAppChannel();
                        if (!TextUtils.isEmpty(appChannel)) {
                            if (appChannel.length() > 100) {
                                String substring2 = appChannel.substring(0, 100);
                                x.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                appChannel = substring2;
                            }
                            f39032d.a(MetricsProto.MetricsEvent.DIALOG_ZEN_TIMEPICKER, "app_channel", appChannel.getBytes(), (o) null, false);
                            a11.f39104l = appChannel;
                        }
                    } else {
                        Map<String, byte[]> a14 = f39032d.a(MetricsProto.MetricsEvent.DIALOG_ZEN_TIMEPICKER, (o) null, true);
                        if (a14 != null && (bArr = a14.get("app_channel")) != null) {
                            a11.f39104l = new String(bArr);
                        }
                    }
                    x.a("[param] Set App channel: %s", a11.f39104l);
                } catch (Exception e2) {
                    if (f39031c) {
                        e2.printStackTrace();
                    }
                }
                String appPackageName = buglyStrategy.getAppPackageName();
                if (!TextUtils.isEmpty(appPackageName)) {
                    if (appPackageName.length() > 100) {
                        String substring3 = appPackageName.substring(0, 100);
                        x.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                        appPackageName = substring3;
                    }
                    a11.f39095c = appPackageName;
                    x.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                }
                String deviceID = buglyStrategy.getDeviceID();
                if (deviceID != null) {
                    if (deviceID.length() > 100) {
                        String substring4 = deviceID.substring(0, 100);
                        x.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                        deviceID = substring4;
                    }
                    a11.c(deviceID);
                    x.a("[param] Set device ID: %s", deviceID);
                }
                String deviceModel = buglyStrategy.getDeviceModel();
                if (deviceModel != null) {
                    a11.d(deviceModel);
                    x.a("[param] Set device model: %s", deviceModel);
                }
                a11.f39097e = buglyStrategy.isUploadProcess();
                y.f40238a = buglyStrategy.isBuglyLogUpload();
            }
            for (int i10 = 0; i10 < f39030b.size(); i10++) {
                try {
                    if (a13.a(f39030b.get(i10).f39028id)) {
                        f39030b.get(i10).init(a10, z10, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            com.tencent.bugly.crashreport.biz.b.a(a10, buglyStrategy);
            a12.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
            x.b("[init] Bugly initialization finished.", new Object[0]);
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!f39030b.contains(aVar)) {
                f39030b.add(aVar);
            }
        }
    }
}
