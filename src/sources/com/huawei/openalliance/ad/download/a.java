package com.huawei.openalliance.ad.download;

import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements AppDownloadListener {
    private static final String Code = "AppDownloadListenerRegister";
    private static final String I = "outer_listener_key";
    private static final String Z = "jsb_listener_key";
    private Map<String, AppDownloadListener> V;

    /* renamed from: com.huawei.openalliance.ad.download.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0329a {
        private static a Code = new a();

        private C0329a() {
        }
    }

    private a() {
        this.V = new ConcurrentHashMap();
        com.huawei.openalliance.ad.download.app.g.I().Code(this);
    }

    public static a Code() {
        return C0329a.Code;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(k kVar, AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(kVar, appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(AppInfo appInfo, int i10) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(appInfo, i10);
            }
        }
    }

    public void Code(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(I);
        } else {
            this.V.put(I, appDownloadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
    public void Code(String str) {
        for (AppDownloadListener appDownloadListener : this.V.values()) {
            if (appDownloadListener != null) {
                appDownloadListener.Code(str);
            }
        }
    }

    public void V(AppDownloadListener appDownloadListener) {
        if (appDownloadListener == null) {
            this.V.remove(Z);
        } else {
            this.V.put(Z, appDownloadListener);
        }
    }
}
