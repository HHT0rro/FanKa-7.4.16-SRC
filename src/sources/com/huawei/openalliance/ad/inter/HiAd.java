package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.huawei.hag.abilitykit.api.KitSdkManager;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.ep;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kr;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.inter.listeners.ExtensionActionListener;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.an;
import com.huawei.openalliance.ad.utils.ar;
import com.huawei.openalliance.ad.utils.as;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.v;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class HiAd implements IHiAd {
    private static HiAd I = null;
    private static final String V = "HiAd";
    private static final byte[] Z = new byte[0];
    private Context B;
    private fr C;
    private AppDownloadListener D;
    private IMultiMediaPlayingManager F;
    private IAppDownloadManager L;

    /* renamed from: a, reason: collision with root package name */
    private ExtensionActionListener f32438a;

    /* renamed from: c, reason: collision with root package name */
    private Integer f32440c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32441d;
    private Map<BroadcastReceiver, IntentFilter> S = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private int f32439b = -1;

    /* renamed from: e, reason: collision with root package name */
    private BroadcastReceiver f32442e = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if (intent.getExtras() != null) {
                        if (intent.getExtras().getBoolean(u.bf)) {
                            HiAd.this.f32441d = true;
                            kr.Code();
                        } else {
                            HiAd.this.f32441d = false;
                        }
                    }
                } catch (Throwable th) {
                    gl.I(HiAd.V, "onReceive error:" + th.getClass().getSimpleName());
                }
            }
        }
    };

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f32443f = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.inter.HiAd.10
        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.10.1
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    for (Map.Entry entry : HiAd.this.S.entrySet()) {
                        BroadcastReceiver broadcastReceiver = (BroadcastReceiver) entry.getKey();
                        IntentFilter intentFilter = (IntentFilter) entry.getValue();
                        if (intentFilter != null && intentFilter.matchAction(action)) {
                            broadcastReceiver.onReceive(context, intent);
                        }
                    }
                }
            });
        }
    };
    public RequestOptions Code = new RequestOptions.Builder().build();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() == 200) {
                gl.Code(HiAd.V, "success: set install permission in hms, %s", str);
            } else {
                gl.I(HiAd.V, "error: set install permission in hms, %s", str);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements Runnable {
        private final AppDownloadListener Code;

        public b(AppDownloadListener appDownloadListener) {
            this.Code = appDownloadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.openalliance.ad.download.a.Code().Code(this.Code);
        }
    }

    private HiAd(Context context) {
        this.B = context.getApplicationContext();
        D();
        L();
        this.C = fr.Code(this.B);
        a();
        as.Code(this.B);
        B();
        if (isEnableUserInfo()) {
            F();
        }
        S();
        C();
    }

    private void B() {
        if (v.C()) {
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.5
                @Override // java.lang.Runnable
                public void run() {
                    Consent.getInstance(HiAd.this.B).getNpaAccordingToServerConsent();
                }
            });
        }
    }

    private void C() {
        if (q.Code()) {
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.6
                @Override // java.lang.Runnable
                public void run() {
                    gl.V(HiAd.V, "init abilitySDK retCode is %s", Integer.valueOf(KitSdkManager.getInstance().initSync(HiAd.this.B)));
                }
            });
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public static HiAd Code(Context context) {
        return V(context);
    }

    private void Code(final String str) {
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.11
            @Override // java.lang.Runnable
            public void run() {
                Object Code;
                Class Code2 = an.Code(u.f32355ae);
                if (Code2 == null || (Code = an.Code(null, Code2, "getInstance", new Class[]{Context.class}, new Object[]{HiAd.this.B})) == null) {
                    return;
                }
                an.Code(Code, Code2, str, null, null);
            }
        });
    }

    private void D() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.B.registerReceiver(this.f32443f, intentFilter);
    }

    private void F() {
        com.huawei.openalliance.ad.utils.f.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.8
            @Override // java.lang.Runnable
            public void run() {
                int ad2 = HiAd.this.C.ad();
                boolean V2 = l.V(HiAd.this.B);
                gl.V(HiAd.V, "preRequest, type: %s, isTv: %s", Integer.valueOf(ad2), Boolean.valueOf(V2));
                if (ad2 != 0 || V2) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ax.f32257ae, ad2);
                        jSONObject.put(ax.af, V2);
                        com.huawei.openalliance.ad.ipc.g.V(HiAd.this.B.getApplicationContext()).Code(com.huawei.openalliance.ad.constant.q.f32338u, jSONObject.toString(), null, null);
                    } catch (JSONException unused) {
                        gl.I(HiAd.V, "preRequest error.");
                    }
                }
            }
        });
    }

    private void I(Context context) {
        boolean a10 = ay.a(context);
        gl.Code(V, "has install permission is: %s", Boolean.valueOf(a10));
        com.huawei.openalliance.ad.download.app.c.V(context.getApplicationContext(), a10, new a(), String.class);
    }

    private void L() {
        gl.Code(V, "registerUSBObserver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(u.f32362be);
        this.B.registerReceiver(this.f32442e, intentFilter);
    }

    private void S() {
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.7
            @Override // java.lang.Runnable
            public void run() {
                ep.Code(HiAd.this.B);
                com.huawei.hms.ads.f.Code(HiAd.this.B);
            }
        });
    }

    private static HiAd V(Context context) {
        HiAd hiAd;
        synchronized (Z) {
            if (I == null) {
                I = new HiAd(context);
            }
            hiAd = I;
        }
        return hiAd;
    }

    private void a() {
        com.huawei.openalliance.ad.download.app.g.Code(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        d();
    }

    private void c() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ar.Z(this.B));
        String str = File.separator;
        sb2.append(str);
        sb2.append(u.f32375i);
        sb2.append(str);
        String sb3 = sb2.toString();
        if (au.Code(sb3)) {
            return;
        }
        com.huawei.openalliance.ad.utils.p.Code(sb3);
    }

    private void d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ar.B(this.B));
        String str = File.separator;
        sb2.append(str);
        sb2.append(u.f32375i);
        sb2.append(str);
        String sb3 = sb2.toString();
        if (au.Code(sb3)) {
            return;
        }
        com.huawei.openalliance.ad.utils.p.Code(sb3);
    }

    @AllApi
    public static void disableUserInfo(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("disableUserInfo, context ");
        sb2.append(context == null ? "is null" : "not null");
        if (context == null) {
            return;
        }
        fr.Code(context).Code(false);
        getInstance(context).enableUserInfo(false);
    }

    @AllApi
    public static IHiAd getInstance(Context context) {
        return V(context);
    }

    @com.huawei.openalliance.ad.annotations.b
    public AppDownloadListener Code() {
        return this.D;
    }

    public void Code(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        this.S.remove(broadcastReceiver);
    }

    public void Code(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null) {
            return;
        }
        this.S.put(broadcastReceiver, intentFilter);
    }

    @com.huawei.openalliance.ad.annotations.b
    public Integer I() {
        return this.f32440c;
    }

    public IMultiMediaPlayingManager V() {
        IMultiMediaPlayingManager iMultiMediaPlayingManager = this.F;
        return iMultiMediaPlayingManager != null ? iMultiMediaPlayingManager : com.huawei.openalliance.ad.media.d.Code(this.B);
    }

    public boolean Z() {
        return this.f32441d;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableSharePd(boolean z10) {
        if (v.Code(this.B)) {
            this.C.V(z10);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void enableUserInfo(boolean z10) {
        if (v.Code(this.B)) {
            this.C.Code(z10);
            if (z10) {
                return;
            }
            com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.9
                @Override // java.lang.Runnable
                public void run() {
                    HiAd.this.b();
                }
            });
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public int getAppActivateStyle() {
        return fr.Code(this.B).Y();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public IAppDownloadManager getAppDownloadManager() {
        if (this.L == null) {
            this.L = (IAppDownloadManager) an.V(u.f32354ad);
        }
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public ExtensionActionListener getExtensionActionListener() {
        return this.f32438a;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public RequestOptions getRequestConfiguration() {
        return this.Code;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void informReady() {
        e.Code(this.B).V();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str) {
        try {
            gl.V(V, "initGrs, appName: %s", str);
            Class<?> cls = Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig");
            an.Code(null, cls, "setGrsAppName", new Class[]{String.class}, new Object[]{str});
            an.Code(null, cls, "init", new Class[]{Context.class}, new Object[]{this.B});
        } catch (Throwable unused) {
            gl.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initGrs(String str, String str2) {
        initGrs(str);
        try {
            gl.V(V, "initGrs, appName: %s, countryCode: %s", str, str2);
            an.Code(null, Class.forName("com.huawei.openalliance.ad.ppskit.utils.ServerConfig"), "setRouterCountryCode", new Class[]{String.class}, new Object[]{str2});
            this.C.Z(str2);
        } catch (Throwable unused) {
            gl.I(V, "fail to find ServerConfig in adscore");
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z10, int i10) {
        initLog(z10, i10, null);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void initLog(boolean z10, int i10, String str) {
        if (v.Code(this.B) && z10) {
            ad.Code(this.B, i10, str);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppAutoOpenForbidden() {
        return fr.Code(this.B).ac();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isAppInstalledNotify() {
        return fr.Code(this.B).X();
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isEnableUserInfo() {
        if (v.Code(this.B)) {
            return this.C.f();
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public boolean isNewProcess() {
        boolean z10 = this.f32439b != Process.myPid();
        if (z10) {
            this.f32439b = Process.myPid();
        }
        gl.V(V, "isNewProcess:" + z10);
        return z10;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onBackground() {
        Code("stopTimer");
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void onForeground() {
        Code("startTimer");
        Context context = this.B;
        if (context != null) {
            I(context);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppActivateStyle(final int i10) {
        com.huawei.openalliance.ad.download.app.c.Code(this.B, isAppInstalledNotify(), i10, ax.U, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    fr.Code(HiAd.this.B).F(i10);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppAutoOpenForbidden(final boolean z10) {
        gl.V(V, "set app AutoOpenForbidden: " + z10);
        com.huawei.openalliance.ad.download.app.c.Code(this.B, z10, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.4
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    gl.V(HiAd.V, "set app AutoOpenForbidden: " + z10);
                    fr.Code(HiAd.this.B).Z(z10);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppDownloadListener(AppDownloadListener appDownloadListener) {
        this.D = appDownloadListener;
        ba.Code(new b(appDownloadListener));
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppInstalledNotify(final boolean z10) {
        gl.Code(V, "set app installed notify: " + z10);
        com.huawei.openalliance.ad.download.app.c.Code(this.B, z10, getAppActivateStyle(), ax.T, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAd.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() == 200) {
                    fr.Code(HiAd.this.B).I(z10);
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppMuted(boolean z10) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setAppVolume(float f10) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setApplicationCode(String str) {
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setBrand(int i10) {
        this.f32440c = Integer.valueOf(i10);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setConsent(final String str) {
        gl.V(V, "set TCF consent string");
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAd.12
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.d.Code(HiAd.this.B).Code(com.huawei.openalliance.ad.constant.q.f32331n, str, null, null);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setCountryCode(String str) {
        this.C.Code(str);
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setExtensionActionListener(ExtensionActionListener extensionActionListener) {
        this.f32438a = extensionActionListener;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setMultiMediaPlayingManager(IMultiMediaPlayingManager iMultiMediaPlayingManager) {
        this.F = iMultiMediaPlayingManager;
    }

    @Override // com.huawei.openalliance.ad.inter.IHiAd
    public void setRequestConfiguration(RequestOptions requestOptions) {
        this.Code = requestOptions;
    }
}
