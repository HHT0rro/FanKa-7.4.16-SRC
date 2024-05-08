package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static volatile h f10816d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f10817a;

    /* renamed from: b, reason: collision with root package name */
    public final List<ZeusPluginStateListener> f10818b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final List<ZeusPluginEventCallback> f10819c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final Handler f10820e = new Handler(Looper.getMainLooper());

    public static h a() {
        if (f10816d == null) {
            synchronized (h.class) {
                if (f10816d == null) {
                    f10816d = new h();
                }
            }
        }
        return f10816d;
    }

    private static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(u.bD)) {
                                str = providerInfo.processName.split(u.bD)[1];
                                if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                    Zeus.getServerManagerHashMap().put(str, providerInfo);
                                }
                            }
                            str = "main";
                            if (Zeus.getServerManagerHashMap().get(str) != null) {
                            }
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.f10819c) {
            array = !this.f10819c.isEmpty() ? this.f10819c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public final synchronized void a(Application application, boolean z10) {
        if (this.f10817a) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        a(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + ((Object) application) + ", hParam = " + ((Object) globalParam));
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    j.b();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.bytedance.pangle.e.f.a();
            }
            if (z10) {
                Zeus.onPrivacyAgreed();
            }
            com.bytedance.pangle.c.b a10 = com.bytedance.pangle.c.b.a();
            com.bytedance.pangle.c.a aVar = new com.bytedance.pangle.c.a() { // from class: com.bytedance.pangle.h.2
                @Override // com.bytedance.pangle.c.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    String str2 = null;
                    if (Zeus.getAppApplication() != null) {
                        Zeus.getAppApplication();
                        str2 = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    if (str2 == null) {
                        str2 = "unknown";
                    }
                    try {
                        jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(str2));
                        jSONObject.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                        jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                        jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.115-bugfix.6-pangle"));
                        ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                        IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                        if (reporter != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject4.putOpt(next, jSONObject.opt(next));
                            }
                            Iterator<String> keys2 = jSONObject2.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                            }
                            Iterator<String> keys3 = jSONObject3.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                            }
                            reporter.report(str, jSONObject4);
                        }
                        ApmUtils.getApmInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (JSONException e2) {
                        ZeusLogger.w(ZeusLogger.TAG_REPORTER, e2.getMessage(), e2);
                    }
                }
            };
            synchronized (a10.f10647a) {
                a10.f10647a.add(aVar);
            }
            if (!globalParam.isCloseFlipped()) {
                b.a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.h.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            if (i.j()) {
                try {
                    FieldUtils.writeField(com.bytedance.pangle.d.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e2);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            if (!globalParam.closeHookHuaweiOnInit()) {
                Zeus.hookHuaWeiVerifier(application);
            }
            this.f10817a = true;
            a(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
            return;
        }
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public final void a(final int i10, final int i11, @Nullable final String str, final int i12, @Nullable final Throwable th) {
        for (final Object obj : c()) {
            this.f10820e.post(new Runnable() { // from class: com.bytedance.pangle.h.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i10, i11, str, i12, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
