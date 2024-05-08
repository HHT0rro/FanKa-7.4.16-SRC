package com.huawei.openalliance.ad.download.app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.hq;
import com.huawei.hms.ads.hx;
import com.huawei.openalliance.ad.activity.AgProtocolActivity;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.download.DownloadListener;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e implements DownloadListener<AppDownloadTask>, com.huawei.openalliance.ad.download.e<AppDownloadTask>, NotifyCallback {
    private static Map<String, Method> B = new HashMap();
    private static final String Code = "ApDnDe";
    private Context V;
    private AppDownloadListener Z;
    private Map<String, Set<com.huawei.openalliance.ad.download.g>> I = new ConcurrentHashMap();
    private BroadcastReceiver C = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.1.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb2;
                    try {
                        String action = intent.getAction();
                        gl.Code(e.Code, "appRe action: %s", action);
                        e.this.Code(intent, action);
                    } catch (IllegalStateException e2) {
                        e = e2;
                        sb2 = new StringBuilder();
                        sb2.append("appRe ");
                        sb2.append(e.getClass().getSimpleName());
                        gl.I(e.Code, sb2.toString());
                    } catch (Exception e10) {
                        e = e10;
                        sb2 = new StringBuilder();
                        sb2.append("appRe ");
                        sb2.append(e.getClass().getSimpleName());
                        gl.I(e.Code, sb2.toString());
                    }
                }
            });
        }
    };
    private BroadcastReceiver S = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.e.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            Runnable runnable;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                gl.V(e.Code, "itRe action: %s", action);
                String dataString = intent.getDataString();
                if (TextUtils.isEmpty(dataString)) {
                    gl.I(e.Code, "itRe dataString is empty, " + action);
                    return;
                }
                final String substring = dataString.substring(8);
                e.this.Code(action, substring);
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.onAppInstalled(g.I().Code(substring));
                        }
                    });
                    return;
                }
                if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    e.this.Code(substring);
                    if (TextUtils.isEmpty(substring)) {
                        gl.V(e.Code, "a bad removed intent");
                        return;
                    } else if (!substring.equals(com.huawei.openalliance.ad.utils.e.I(context))) {
                        return;
                    } else {
                        runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                g.I().V();
                            }
                        };
                    }
                } else {
                    if (!"android.intent.action.PACKAGE_DATA_CLEARED".equals(action)) {
                        return;
                    }
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        gl.V(e.Code, "a bad intent");
                        return;
                    } else if (!schemeSpecificPart.equals(com.huawei.openalliance.ad.utils.e.I(context))) {
                        return;
                    } else {
                        runnable = new Runnable() { // from class: com.huawei.openalliance.ad.download.app.e.2.3
                            @Override // java.lang.Runnable
                            public void run() {
                                g.I().V();
                            }
                        };
                    }
                }
                ba.Code(runnable);
            } catch (IllegalStateException e2) {
                e = e2;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                gl.I(e.Code, sb2.toString());
            } catch (Exception e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("itRe:");
                sb2.append(e.getClass().getSimpleName());
                gl.I(e.Code, sb2.toString());
            }
        }
    };

    public e(Context context) {
        this.V = context.getApplicationContext();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(d.Code);
            intentFilter.addAction(d.V);
            intentFilter.addAction(d.I);
            intentFilter.addAction(d.f32413c);
            intentFilter.addAction(d.B);
            this.V.registerReceiver(this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (v.B(this.V)) {
                com.huawei.openalliance.ad.msgnotify.b.Code(context, d.f32419i, this);
            } else {
                com.huawei.openalliance.ad.msgnotify.b.V(context, d.f32419i, this);
            }
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
            intentFilter2.addDataScheme("package");
            this.V.registerReceiver(this.S, intentFilter2);
            hx.Code(context).Code();
            Code();
        } catch (Throwable th) {
            gl.I(Code, "registerReceiver " + th.getClass().getSimpleName());
        }
    }

    private synchronized Set<com.huawei.openalliance.ad.download.g> Code(AppInfo appInfo) {
        if (appInfo != null) {
            if (!TextUtils.isEmpty(appInfo.Code())) {
                return V(appInfo.Code());
            }
        }
        return null;
    }

    private static void Code() {
        try {
            for (Method method : e.class.getDeclaredMethods()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(AppDownloadTask.class)) {
                    B.put(method.getName(), method);
                }
            }
        } catch (Throwable th) {
            gl.Code(Code, "transport=%s", th.getMessage());
            gl.Z(Code, "transport=" + th.getClass().getSimpleName());
        }
    }

    private void Code(Intent intent) {
        try {
            if (d.I.equals(intent.getAction())) {
                AppInfo appInfo = (AppInfo) z.V(intent.getStringExtra("appInfo"), AppInfo.class, new Class[0]);
                if (appInfo == null) {
                    gl.V(Code, "appInfo is null");
                    return;
                }
                com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                if (Code2 != null) {
                    Code2.Code(appInfo);
                }
            }
        } catch (Throwable th) {
            gl.I(Code, "exception: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Intent intent, String str) {
        AppInfo appInfo;
        SafeIntent safeIntent = new SafeIntent(intent);
        if (!d.Code.equals(str)) {
            if (d.V.equals(str)) {
                String stringExtra = safeIntent.getStringExtra(d.F);
                AppDownloadListener appDownloadListener = this.Z;
                if (appDownloadListener != null) {
                    appDownloadListener.Code(stringExtra);
                    return;
                }
                return;
            }
            if (d.I.equals(str)) {
                Code(safeIntent);
                return;
            }
            if (d.f32413c.equals(str)) {
                gl.V(Code, "request intent");
                V(safeIntent);
                return;
            } else {
                if (d.B.equals(str)) {
                    I(safeIntent);
                    return;
                }
                return;
            }
        }
        String stringExtra2 = safeIntent.getStringExtra(d.F);
        AppDownloadTask Code2 = g.I().Code(stringExtra2);
        if (Code2 == null) {
            gl.V(Code, " task is null, pkg=" + stringExtra2);
            I(stringExtra2);
            return;
        }
        String stringExtra3 = safeIntent.getStringExtra("appInfo");
        if (!TextUtils.isEmpty(stringExtra3) && (appInfo = (AppInfo) z.V(stringExtra3, AppInfo.class, new Class[0])) != null) {
            gl.V(Code, "update appInfo from remote task.");
            Code2.Code(appInfo);
        }
        Code(Code2, safeIntent);
        String stringExtra4 = safeIntent.getStringExtra(d.L);
        if (TextUtils.isEmpty(stringExtra4)) {
            return;
        }
        if (stringExtra4.equals(d.f32411a)) {
            g.I().I((g) Code2);
            return;
        }
        Method method = B.get(stringExtra4);
        if (method != null) {
            try {
                gl.Code(Code, "methodName:%s", stringExtra4);
                method.invoke(this, Code2);
            } catch (IllegalAccessException unused) {
                gl.Code(Code, "ilex=%s", stringExtra4);
            } catch (InvocationTargetException unused2) {
                gl.Code(Code, "itex=%s", stringExtra4);
            }
        }
    }

    private void Code(AppDownloadTask appDownloadTask, int i10) {
        appDownloadTask.V((appDownloadTask.I() * i10) / 100);
    }

    private void Code(AppDownloadTask appDownloadTask, Intent intent) {
        SafeIntent safeIntent = new SafeIntent(intent);
        appDownloadTask.Code(safeIntent.getIntExtra(d.C, 0));
        appDownloadTask.I(safeIntent.getIntExtra(d.S, 0));
        appDownloadTask.Z(safeIntent.getIntExtra(d.D, 0));
        appDownloadTask.B(safeIntent.getIntExtra(d.f32421k, 0));
        Code(appDownloadTask, appDownloadTask.S());
    }

    private void Code(k kVar, AppDownloadTask appDownloadTask) {
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(kVar, appDownloadTask.L());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, String str2) {
        Set<com.huawei.openalliance.ad.download.g> V = V(str2);
        if (V != null && V.size() > 0) {
            if ("android.intent.action.PACKAGE_ADDED".equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar : V) {
                    if (gVar != null) {
                        gVar.V(str2);
                    }
                }
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(str)) {
                for (com.huawei.openalliance.ad.download.g gVar2 : V) {
                    if (gVar2 != null) {
                        gVar2.I(str2);
                    }
                }
            }
        }
        if (!"android.intent.action.PACKAGE_REMOVED".equals(str) || this.Z == null) {
            return;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.D(str2);
        this.Z.Code(k.DOWNLOAD, appInfo);
    }

    private void I(Intent intent) {
        String str;
        if (intent == null) {
            str = "msgData is empty!";
        } else {
            SafeIntent safeIntent = new SafeIntent(intent);
            String stringExtra = safeIntent.getStringExtra(ax.f32258ar);
            if (stringExtra == null || stringExtra.equals(this.V.getPackageName())) {
                String stringExtra2 = safeIntent.getStringExtra("contentRecord");
                if (gl.Code()) {
                    gl.Code(Code, "sendNotify content: %s", bc.Code(stringExtra2));
                }
                AdContentData adContentData = (AdContentData) z.V(stringExtra2, AdContentData.class, new Class[0]);
                if (adContentData != null) {
                    String stringExtra3 = safeIntent.getStringExtra("unique_id");
                    AppInfo u10 = adContentData.u();
                    if (u10 == null || u10.l() != 1 || TextUtils.isEmpty(u10.m())) {
                        return;
                    }
                    int intExtra = safeIntent.getIntExtra(ax.L, 1);
                    hq hqVar = new hq(this.V, adContentData, stringExtra3);
                    hqVar.Code(intExtra);
                    hqVar.I();
                    return;
                }
                str = " contentData is empty.";
            } else {
                str = "sourcePackageName not equals packageName.";
            }
        }
        gl.V(Code, str);
    }

    private void I(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> Code2 = Code(appDownloadTask.L());
        if (Code2 == null || Code2.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> iterator2 = Code2.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().V(appDownloadTask);
        }
    }

    private void I(String str) {
        if (TextUtils.isEmpty(str)) {
            gl.V(Code, " packageName is empty.");
            return;
        }
        Set<com.huawei.openalliance.ad.download.g> V = V(str);
        gl.Code(Code, " findAndRefreshTask list:%s", V);
        if (V == null || V.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> iterator2 = V.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(str);
        }
    }

    private synchronized Set<com.huawei.openalliance.ad.download.g> V(String str) {
        return this.I.get(str);
    }

    private void V(Intent intent) {
        String str;
        try {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(d.f32414d);
            int i10 = -1;
            String str2 = null;
            if (pendingIntent != null) {
                Intent intent2 = new Intent();
                intent2.setClass(this.V, AgProtocolActivity.class);
                intent2.putExtra(d.f32414d, pendingIntent);
                int intExtra = intent.getIntExtra(d.f32415e, 6);
                intent2.putExtra(d.f32415e, intExtra);
                str2 = intent.getStringExtra(d.f32416f);
                intent2.putExtra(d.f32416f, str2);
                str = intent.getStringExtra("ag_action_name");
                intent2.putExtra("ag_action_name", str);
                intent2.addFlags(268959744);
                intent2.setClipData(u.cG);
                this.V.startActivity(intent2);
                i10 = intExtra;
            } else {
                str = null;
            }
            eo.Code(this.V, i10, str2, str, a.Code);
        } catch (Throwable unused) {
            gl.V(Code, " requestAgProtocol error");
        }
    }

    private void V(AppDownloadTask appDownloadTask) {
        Set<com.huawei.openalliance.ad.download.g> Code2 = Code(appDownloadTask.L());
        if (Code2 == null || Code2.size() <= 0) {
            return;
        }
        Iterator<com.huawei.openalliance.ad.download.g> iterator2 = Code2.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(appDownloadTask);
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.Z = appDownloadListener;
    }

    public void Code(String str) {
        NotificationManager notificationManager;
        if (TextUtils.isEmpty(str) || (notificationManager = (NotificationManager) this.V.getSystemService("notification")) == null) {
            return;
        }
        notificationManager.cancel(str.hashCode());
    }

    public synchronized void Code(String str, com.huawei.openalliance.ad.download.g gVar) {
        Set<com.huawei.openalliance.ad.download.g> set = this.I.get(str);
        if (set == null) {
            set = new HashSet<>();
            this.I.put(str, set);
        }
        set.add(gVar);
    }

    @Override // com.huawei.openalliance.ad.download.e
    public boolean Code(AppDownloadTask appDownloadTask) {
        return g.I().Z(appDownloadTask);
    }

    public synchronized void V(String str, com.huawei.openalliance.ad.download.g gVar) {
        Set<com.huawei.openalliance.ad.download.g> set = this.I.get(str);
        if (set != null && set.size() > 0) {
            set.remove(gVar);
            if (set.size() <= 0) {
                this.I.remove(str);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onAppInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            appDownloadTask.Code(6);
            Code(k.INSTALLED, appDownloadTask);
            I(appDownloadTask);
            g.I().V((g) appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onAppUnInstalled(AppDownloadTask appDownloadTask) {
        if (appDownloadTask != null) {
            String Code2 = appDownloadTask.L().Code();
            Set<com.huawei.openalliance.ad.download.g> V = V(Code2);
            if (V != null && V.size() > 0) {
                Iterator<com.huawei.openalliance.ad.download.g> iterator2 = V.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().I(Code2);
                }
            }
            Code(k.DOWNLOAD, appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadDeleted(AppDownloadTask appDownloadTask) {
        appDownloadTask.I(0);
        appDownloadTask.V(0L);
        appDownloadTask.Code(4);
        I(appDownloadTask);
        Code(k.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadFail(AppDownloadTask appDownloadTask) {
        if (Code(appDownloadTask)) {
            return;
        }
        I(appDownloadTask);
        Code(k.DOWNLOADFAILED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadPaused(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.PAUSE, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadProgress(AppDownloadTask appDownloadTask) {
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.Z == null);
        gl.Code(Code, "onDownloadProgress: %s", objArr);
        V(appDownloadTask);
        AppDownloadListener appDownloadListener = this.Z;
        if (appDownloadListener != null) {
            appDownloadListener.Code(appDownloadTask.L(), appDownloadTask.S());
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadResumed(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.RESUME, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.DOWNLOADING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadSuccess(AppDownloadTask appDownloadTask) {
        Code(k.DOWNLOADED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onDownloadWaiting(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.WAITING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
    public void onMessageNotify(String str, Intent intent) {
        if (TextUtils.isEmpty(str) || intent == null) {
            gl.V(Code, "msgName or msgData is empty!");
        } else {
            gl.Code(Code, "onMessageNotify msgName:%s", str);
            this.C.onReceive(this.V, intent);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallFailed(AppDownloadTask appDownloadTask) {
        gl.I(Code, "install apk failed, reason: %s", Integer.valueOf(appDownloadTask.n()));
        if ((appDownloadTask.n() == 1) || !Code(appDownloadTask)) {
            I(appDownloadTask);
            Code(appDownloadTask.B() == 4 ? k.DOWNLOAD : k.INSTALL, appDownloadTask);
        }
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALLING, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSilentInstallSuccess(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALLED, appDownloadTask);
    }

    @Override // com.huawei.openalliance.ad.download.DownloadListener
    @AllApi
    public void onSystemInstallStart(AppDownloadTask appDownloadTask) {
        I(appDownloadTask);
        Code(k.INSTALL, appDownloadTask);
    }
}
