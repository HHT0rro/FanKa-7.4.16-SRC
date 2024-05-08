package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.dw;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class g extends com.huawei.openalliance.ad.download.b<AppDownloadTask> {
    private static final byte[] B = new byte[0];
    private static g C = null;
    private static final String Z = "ApDnMgr";
    private e F;
    private Context S;

    private g(Context context) {
        super(context);
        super.Code();
        this.S = context.getApplicationContext();
        e eVar = new e(context);
        this.F = eVar;
        super.Code(eVar);
    }

    private boolean B(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return false;
        }
        while (appDownloadTask.l()) {
            gl.V(Z, "switch next install way succ, curInstallWay:%s", appDownloadTask.j());
            if (!appDownloadTask.m() || v.S(this.Code)) {
                return true;
            }
        }
        gl.V(Z, "switch next install way fail, curInstallWay:%s", appDownloadTask.j());
        return false;
    }

    private boolean C(AppDownloadTask appDownloadTask) {
        AdContentData f10 = appDownloadTask.f();
        if (f10 != null) {
            return new com.huawei.openalliance.ad.uriaction.b(this.Code, f10).Code();
        }
        return false;
    }

    public static void Code(Context context) {
        synchronized (B) {
            if (C == null) {
                C = new g(context);
            }
        }
    }

    public static g I() {
        g gVar;
        synchronized (B) {
            gVar = C;
            if (gVar == null) {
                throw new RuntimeException("AppDownloadManager instance is not init!");
            }
        }
        return gVar;
    }

    private static boolean I(AppInfo appInfo) {
        return appInfo == null || TextUtils.isEmpty(appInfo.Code());
    }

    @Override // com.huawei.openalliance.ad.download.b
    public void Code(final AppDownloadTask appDownloadTask) {
        if (!appDownloadTask.k()) {
            c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() != -1) {
                        g.super.Code((g) appDownloadTask);
                    }
                }
            }, String.class);
            return;
        }
        AppInfo L = appDownloadTask.L();
        if (L == null || TextUtils.isEmpty(L.h()) || !C(appDownloadTask)) {
            gl.V(Z, "can not open Ag detail");
            Z(appDownloadTask);
        }
    }

    public void Code(AppInfo appInfo) {
        if (I(appInfo)) {
            return;
        }
        final AppDownloadTask V = V(appInfo);
        if (V != null) {
            c.I(this.S, V, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.4
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() == 200 && String.valueOf(Boolean.TRUE).equals(callResult.getData())) {
                        g.super.I((g) V);
                        gl.V(g.Z, " removeTask task is success:" + V.F());
                    }
                }
            }, String.class);
            return;
        }
        gl.V(Z, " removeTask failed:" + appInfo.Code());
    }

    public void Code(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!I(appInfo)) {
            this.F.Code(appInfo.Code(), gVar);
        }
        if (dw.Code(appInfo)) {
            b.Code(this.Code).Code(appInfo.G(), gVar);
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        this.F.Code(appDownloadListener);
    }

    public void I(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.Code(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.3
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    gl.V(g.Z, " resume task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    public AppDownloadTask V(AppInfo appInfo) {
        RemoteAppDownloadTask remoteAppDownloadTask;
        if (I(appInfo)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.Code(appInfo.Code());
        if (appDownloadTask != null || (remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, RemoteAppDownloadTask.class)) == null) {
            return appDownloadTask;
        }
        gl.Code(Z, " remote task is exist, create proxy task by appInfo");
        gl.V(Z, " remote task is exist, create proxy task");
        AppDownloadTask Code = remoteAppDownloadTask.Code(appInfo);
        super.Code((g) Code);
        return Code;
    }

    @Override // com.huawei.openalliance.ad.download.b
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public AppDownloadTask Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AppDownloadTask appDownloadTask = (AppDownloadTask) super.Code(str);
        if (appDownloadTask == null) {
            AppInfo appInfo = new AppInfo();
            appInfo.D(str);
            appInfo.I("5");
            RemoteAppDownloadTask remoteAppDownloadTask = (RemoteAppDownloadTask) c.Code(this.S, appInfo, RemoteAppDownloadTask.class);
            if (remoteAppDownloadTask != null) {
                gl.V(Z, " remote task is exist, create proxy task");
                AppDownloadTask Code = remoteAppDownloadTask.Code(appInfo);
                super.Code((g) Code);
                return Code;
            }
        }
        return appDownloadTask;
    }

    public void V(final AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null) {
            return;
        }
        c.V(this.S, appDownloadTask, new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.download.app.g.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                if (callResult.getCode() != -1) {
                    gl.V(g.Z, " pause task is success:" + appDownloadTask.F());
                }
            }
        }, String.class);
    }

    public void V(AppInfo appInfo, com.huawei.openalliance.ad.download.g gVar) {
        if (!I(appInfo)) {
            this.F.V(appInfo.Code(), gVar);
        }
        if (dw.Code(appInfo)) {
            b.Code(this.Code).V(appInfo.G(), gVar);
        }
    }

    public boolean Z(AppDownloadTask appDownloadTask) {
        if (!B(appDownloadTask)) {
            return false;
        }
        V((g) appDownloadTask);
        Code(appDownloadTask);
        return true;
    }
}
