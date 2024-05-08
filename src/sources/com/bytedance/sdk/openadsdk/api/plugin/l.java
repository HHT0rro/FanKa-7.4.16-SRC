package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import o0.a;
import o0.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l {

    /* renamed from: l, reason: collision with root package name */
    private static volatile BaseDexClassLoader f11117l;
    private static volatile TTPluginListener ve;

    /* renamed from: w, reason: collision with root package name */
    private final Context f11124w;

    /* renamed from: m, reason: collision with root package name */
    private static final String f11118m = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> dk = new HashMap<>();
    private static final HashMap<String, Handler> ej = new HashMap<>();
    private static volatile l np = null;

    /* renamed from: n, reason: collision with root package name */
    private final CountDownLatch f11122n = new CountDownLatch(1);

    /* renamed from: hc, reason: collision with root package name */
    private volatile boolean f11121hc = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile String f11120e = "none";

    /* renamed from: oa, reason: collision with root package name */
    private JSONObject f11123oa = new JSONObject();

    /* renamed from: c, reason: collision with root package name */
    private EventListener f11119c = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class dk implements IZeusLogger {
        private dk() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.ej.ej(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.ej.ej(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.ej.m(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.ej.l(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.ej.dk(str, str2, th);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ej implements EventListener, Serializable {
        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i10, Result result) {
            a b4 = a.b();
            if (i10 == 1) {
                ValueSet values = result.values();
                if (values == null) {
                    return null;
                }
                String stringValue = values.stringValue(3);
                int code = result.code();
                if (result.isSuccess()) {
                    m ej = l.ej(values.stringValue(2));
                    if (ej != null && !TextUtils.isEmpty(ej.mPackageName)) {
                        com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "plugin update received: " + ej.mPackageName);
                        if (!ej.isRevert()) {
                            if (l.dk(ej)) {
                                b4.j(4, true);
                            }
                        } else {
                            Zeus.unInstallPlugin(ej.mPackageName);
                        }
                    } else {
                        com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                } else {
                    com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "plugin update received failed");
                    l.ej(stringValue, code);
                    return null;
                }
            }
            return b4.a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class m extends PluginDownloadBean {

        /* renamed from: m, reason: collision with root package name */
        public String f11130m = "";
        public File dk = null;

        public m() {
            this.mBackupUrlList = null;
        }
    }

    private l(Context context) {
        this.f11124w = context.getApplicationContext();
        GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        dk(context.getApplicationContext());
    }

    private static File ej(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle.m"), f11118m);
    }

    private void dk(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.l.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if (LandingPageUtHelper.XAD_UT_LP_LOAD_FINISH.equals(str) && jSONObject != null && "com.byted.pangle.m".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            l.this.f11123oa.put("zeus", jSONObject2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        com.bytedance.sdk.openadsdk.api.plugin.dk.m(str, jSONObject);
                    } else {
                        com.bytedance.sdk.openadsdk.api.plugin.dk.dk(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(ej(context));
            globalParam.setLogger(new dk());
            globalParam.setSignature("com.byted.pangle.m", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.l.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(final String str, final int i10, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", str + " state changed, " + i10);
                    if (i10 == 7) {
                        l.this.dk(str, i10);
                    } else if (i10 == 6) {
                        com.bytedance.sdk.openadsdk.np.m.m().dk(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.l.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                l.this.dk(str, i10);
                                if (l.this.f11119c != null && "com.byted.pangle.m".equals(str)) {
                                    l.this.f11119c.onEvent(0, b.b().f(true).a());
                                } else {
                                    com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "no main pl");
                                }
                            }
                        });
                    }
                }
            });
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context, true);
            this.f11121hc = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "Unexpected error for init zeus.", th);
            this.f11120e = th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static m ej(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.ej.np("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    public static l m(Context context) {
        if (np == null) {
            synchronized (l.class) {
                if (np == null) {
                    np = new l(context);
                }
            }
        }
        return np;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ej(String str, int i10) {
        com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i10);
        TTPluginListener tTPluginListener = dk.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public JSONObject m() {
        return this.f11123oa;
    }

    public BaseDexClassLoader m(com.bytedance.sdk.openadsdk.api.plugin.ej ejVar) throws Exception {
        return m(ejVar, 60000);
    }

    public BaseDexClassLoader m(com.bytedance.sdk.openadsdk.api.plugin.ej ejVar, int i10) throws Exception {
        if (this.f11121hc) {
            if (!Zeus.isPluginInstalled("com.byted.pangle.m")) {
                try {
                    com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "wait start");
                    this.f11122n.await(i10, TimeUnit.MILLISECONDS);
                    com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "wait done");
                    ejVar.dk("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.m(8, "install wait timeout");
                }
            }
            boolean z10 = false;
            if (Zeus.isPluginLoaded("com.byted.pangle.m") || Zeus.loadPlugin("com.byted.pangle.m")) {
                f11117l = Zeus.getPlugin("com.byted.pangle.m").mClassLoader;
                z10 = true;
            }
            ejVar.dk("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (f11117l == null) {
                if (this.f11122n.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.m(8, "install wait timeout");
                }
                if (z10) {
                    com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "Get null after load");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.m(9, "Get null after load");
                }
            }
            ejVar.dk("get_classloader_done");
            return f11117l;
        }
        com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "Zeus init failed.");
        throw new com.bytedance.sdk.openadsdk.api.plugin.m(4, this.f11120e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str, int i10) {
        if ("com.byted.pangle.m".equals(str) && i10 == 6) {
            com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "notify to end wait");
            this.f11122n.countDown();
        }
        m(i10 == 6, str);
    }

    public void dk(final TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.np.m.m().dk(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.l.4
            @Override // java.lang.Runnable
            public void run() {
                String packageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Find plugin:");
                sb2.append(plugin != null);
                com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", sb2.toString());
                if (plugin == null) {
                    TTPluginListener unused = l.ve = tTPluginListener;
                } else {
                    l.dk(plugin);
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, m(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dk(m mVar) {
        File file;
        if (mVar != null && (file = mVar.dk) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(mVar.mPackageName, file.getAbsolutePath());
            m(syncInstallPlugin, mVar.mPackageName);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "plugin config is null");
        return false;
    }

    public Bundle m(String str, Bundle bundle) {
        String m10 = m(str);
        if (!TextUtils.isEmpty(m10)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, m10);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String m(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return m(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void m(final TTPluginListener tTPluginListener) {
        if (!this.f11121hc) {
            com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.l.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Find plugin:");
        sb2.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", sb2.toString());
        if (plugin != null) {
            dk(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            dk.put(packageName, tTPluginListener);
            ej.put(packageName, handler);
        }
    }

    private static m m(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        m mVar = new m();
        mVar.mPackageName = jSONObject.optString("package_name");
        mVar.mVersionCode = jSONObject.optInt("version_code");
        mVar.mUrl = jSONObject.optString("download_url");
        mVar.mMd5 = jSONObject.optString("md5");
        mVar.mApiVersionMin = jSONObject.optInt("min_version");
        mVar.mApiVersionMax = jSONObject.optInt("max_version");
        mVar.f11130m = jSONObject.optString(CardUriUtils.PARAM_SIGN);
        mVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        mVar.dk = new File(jSONObject.optString("plugin_file"));
        return mVar;
    }

    public static String m(int i10) {
        char[] charArray = String.valueOf(i10).toCharArray();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            sb2.append(charArray[i11]);
            if (i11 < charArray.length - 1) {
                sb2.append(".");
            }
        }
        return sb2.toString();
    }

    private static boolean m(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void m(boolean z10, String str) {
        HashMap<String, TTPluginListener> hashMap = dk;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Install dl plugin ");
        sb2.append(str);
        sb2.append(z10 ? " success" : " failed");
        sb2.append(", need notify: ");
        sb2.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", sb2.toString());
        HashMap<String, Handler> hashMap2 = ej;
        Handler handler = hashMap2.get(str);
        if (z10) {
            TTPluginListener tTPluginListener2 = ve;
            if (!m(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                dk(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (m(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    ve = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "handle installed, load failed");
                ej(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.ej.dk("TTPluginManager", "handle installed failed");
            ej(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void m(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle.m");
            com.bytedance.sdk.openadsdk.api.ej.l("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
