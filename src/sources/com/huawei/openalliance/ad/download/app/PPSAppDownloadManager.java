package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.dw;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fc;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.ku;
import com.huawei.hms.ads.kv;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ae;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.u;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.HashMap;
import java.util.Map;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSAppDownloadManager implements IAppDownloadManager {
    private String D;
    private boolean L;
    private final fc B = new fb();
    private int C = 2;
    private Integer S = 6;
    public g Code = g.I();

    @AllApi
    public PPSAppDownloadManager() {
    }

    private AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        AppDownloadTask Code = new AppDownloadTask.a().Code(true).Code(dVar.v()).Code();
        if (Code != null) {
            Code.C(dVar.D());
            Code.Z(dVar.m());
            AdContentData l10 = dVar.l();
            Code.Code(l10);
            if (l10 != null) {
                Code.B(l10.s());
                Code.I(l10.B());
                Code.D(l10.E());
                Code.a(l10.az());
                Code.C(l10.aA());
            }
        }
        return Code;
    }

    private void Code(Context context, AdContentData adContentData, AppInfo appInfo, String str) {
        if (adContentData != null) {
            kv.Code(context, adContentData, 0, 0, V(appInfo) ? t.F : "download", 6, str);
        }
    }

    private void Code(Context context, AdContentData adContentData, String str) {
        if (adContentData != null) {
            kv.Code(context, adContentData, 0, 0, "app", 6, str);
        }
    }

    public static void Code(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            gl.V("PPSAppDownloadManager", "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code = com.huawei.openalliance.ad.download.a.Code();
                    if (Code != null) {
                        Code.Code(AppInfo.this.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.2
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code = com.huawei.openalliance.ad.download.a.Code();
                    if (Code != null) {
                        Code.Code(AppInfo.this);
                    }
                }
            });
        }
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        RewardVerifyConfig H = dVar.H();
        if (H != null) {
            appDownloadTask.S(H.getData());
            appDownloadTask.F(H.getUserId());
        }
        appDownloadTask.C(dVar.D());
        appDownloadTask.Code(this.S);
        appDownloadTask.V((Integer) (-1));
        appDownloadTask.I(Integer.valueOf(this.C));
    }

    private boolean Code() {
        return this.S.intValue() == 14;
    }

    private boolean Code(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        return appInfo.o();
    }

    private int D(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (a(context, dVar)) {
            gl.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        }
        AppInfo v2 = dVar.v();
        AppDownloadTask V = this.Code.V(v2);
        if (V == null) {
            AppDownloadTask Code = Code(dVar);
            if (Code == null) {
                gl.V("PPSAppDownloadManager", "failed when create task");
                return -1;
            }
            Code(dVar, Code);
            if (!Code()) {
                V(context, null, dVar);
                Code(context, dVar.l(), v2, com.huawei.openalliance.ad.utils.b.Code(context));
            }
            this.Code.Code(Code);
        } else {
            V(dVar, V);
            Code(dVar, V);
            this.Code.I(V);
        }
        return 0;
    }

    private boolean I(AppInfo appInfo) {
        String str;
        if (appInfo == null) {
            str = " download app info is empty";
        } else if (TextUtils.isEmpty(appInfo.Code())) {
            str = "app packageName is empty";
        } else if (!Code(appInfo) && !dw.Code(appInfo) && (TextUtils.isEmpty(appInfo.Z()) || Z(appInfo) || appInfo.B() <= 0)) {
            str = " download app info is invalid";
        } else {
            if (this.Code != null) {
                return true;
            }
            str = " download manager is not init";
        }
        gl.V("PPSAppDownloadManager", str);
        return false;
    }

    private boolean I(com.huawei.openalliance.ad.inter.data.d dVar) {
        return (dVar instanceof n) || (dVar instanceof u);
    }

    private boolean L(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        AppInfo v2 = dVar.v();
        if (!com.huawei.openalliance.ad.utils.e.Code(context, v2.Code()) && com.huawei.openalliance.ad.utils.e.Code()) {
            str = "app not installed, need download";
        } else {
            if (com.huawei.openalliance.ad.utils.e.Code(context, v2.Code(), v2.D())) {
                Code(context, v2);
                kv.Code(context, dVar.l(), "intentSuccess", (Integer) 1, (Integer) null);
                if (!Code()) {
                    V(context, null, dVar);
                    Code(context, dVar.l(), com.huawei.openalliance.ad.utils.b.Code(context));
                }
                return true;
            }
            gl.V("PPSAppDownloadManager", "handleClick, openAppIntent failed");
            kv.Code(context, dVar.l(), ae.D, (Integer) 1, (Integer) 2);
            if (com.huawei.openalliance.ad.utils.e.I(context, v2.Code())) {
                Code(context, v2);
                kv.Code(context, dVar.l(), (Integer) 6);
                if (!Code()) {
                    V(context, null, dVar);
                    Code(context, dVar.l(), com.huawei.openalliance.ad.utils.b.Code(context));
                }
                return true;
            }
            str = "handleClick, openAppMainPage failed";
        }
        gl.V("PPSAppDownloadManager", str);
        return false;
    }

    private void V(Context context, View view, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (view != null && (view instanceof PPSNativeView)) {
            ((PPSNativeView) view).Code((Integer) 6, true);
            return;
        }
        if (dVar != null) {
            String B = dVar instanceof u ? ((u) dVar).l().B() : null;
            if (B == null || !B.equals(this.D)) {
                this.D = B;
                ku.a aVar = new ku.a();
                aVar.V(Long.valueOf(v.Code())).Code(Long.valueOf(dVar.r())).Code(Integer.valueOf(dVar.s())).V((Integer) 6).Code(com.huawei.openalliance.ad.utils.b.Code(context));
                kv.Code(context, dVar.l(), aVar.Code());
            }
        }
    }

    private void V(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        AdContentData l10 = dVar.l();
        if (l10 != null) {
            appDownloadTask.I(l10.B());
        }
    }

    private boolean V(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        String r10 = appInfo.r();
        return (TextUtils.isEmpty(r10) || TextUtils.isEmpty(appInfo.Code()) || !r10.equals("6")) ? false : true;
    }

    private boolean V(com.huawei.openalliance.ad.inter.data.d dVar) {
        return I(dVar) && I(dVar.v());
    }

    private boolean Z(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.S() && TextUtils.isEmpty(appInfo.C());
    }

    private boolean a(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        AppInfo v2;
        boolean z10 = dVar instanceof u;
        if (!this.L || !z10 || (v2 = dVar.v()) == null || aa.Code(v2.t()) || !com.huawei.openalliance.ad.uriaction.d.Code(context, dVar.l(), Code(dVar.l()), v2.t()).Code()) {
            return false;
        }
        V(context, null, dVar);
        Code(context, dVar.l(), com.huawei.openalliance.ad.utils.b.Code(context));
        return true;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void B(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (V(context, dVar) != null) {
            str = "ad is invalid ad when pause";
        } else {
            if (this.B.Code(context, dVar, false)) {
                AppDownloadTask V = this.Code.V(dVar.v());
                if (V != null) {
                    V(dVar, V);
                    Code(dVar, V);
                    this.Code.V(V);
                    return;
                }
                return;
            }
            str = "pauseDownload has not permission, please add white list";
        }
        gl.V("PPSAppDownloadManager", str);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void C(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (V(context, dVar) != null) {
            str = "ad is invalid ad when cancel";
        } else {
            if (this.B.Code(context, dVar, false)) {
                AppInfo v2 = dVar.v();
                AppDownloadTask V = this.Code.V(v2);
                if (V != null) {
                    V(dVar, V);
                    Code(dVar, V);
                    this.Code.Code(v2);
                    return;
                }
                return;
            }
            str = "cancelDownload has not permission, please add white list";
        }
        gl.V("PPSAppDownloadManager", str);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer V = V(context, dVar);
        if (V != null) {
            return V.intValue();
        }
        if (!this.B.Code(context, dVar, true)) {
            gl.V("PPSAppDownloadManager", "download has not permission, please add white list");
            return -2;
        }
        if (!L(context, dVar)) {
            return D(context, dVar);
        }
        gl.V("PPSAppDownloadManager", "app is installed, open it.");
        return 0;
    }

    public Map<String, String> Code(AdContentData adContentData) {
        HashMap hashMap = new HashMap();
        if (adContentData != null) {
            MetaData Z = adContentData.Z();
            hashMap.put("appId", Z == null ? "" : Z.L());
            hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, Z != null ? Z.D() : "");
            if (adContentData.p() == null) {
                return hashMap;
            }
            com.huawei.openalliance.ad.inter.data.v vVar = new com.huawei.openalliance.ad.inter.data.v(adContentData.p());
            hashMap.put(ax.f32270m, adContentData.B());
            int L = vVar.L();
            gl.V("PPSAppDownloadManager", "buildLinkedAdConfig, set progress from native view " + L);
            hashMap.put(ax.f32271n, String.valueOf(adContentData.z()));
            hashMap.put(ax.f32274q, adContentData.y() ? "true" : "false");
            hashMap.put(ax.f32273p, vVar.a());
            hashMap.put(ax.f32272o, String.valueOf(L));
        }
        return hashMap;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(Integer num) {
        this.S = num;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(boolean z10) {
        this.L = z10;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int F(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (dVar == null) {
            str = "ad is empty";
        } else if (V(dVar)) {
            AppDownloadTask V = this.Code.V(dVar.v());
            if (V != null) {
                return V.S();
            }
            str = "task is not exist.";
        } else {
            str = "ad is not native ad";
        }
        gl.V("PPSAppDownloadManager", str);
        return 0;
    }

    public Integer I(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        return (context == null || dVar == null) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public k S(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            return k.DOWNLOAD;
        }
        if (!V(dVar)) {
            gl.V("PPSAppDownloadManager", "this ad is not a native ad");
            return k.DOWNLOAD;
        }
        AppInfo v2 = dVar.v();
        if (com.huawei.openalliance.ad.utils.e.Code(context, v2.Code())) {
            gl.V("PPSAppDownloadManager", "app installed");
            return k.INSTALLED;
        }
        AppDownloadTask V = this.Code.V(v2);
        if (V == null) {
            return k.DOWNLOAD;
        }
        V.C(dVar.D());
        return dw.Code(V);
    }

    public Integer V(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer I = I(context, dVar);
        return I != null ? I : !V(dVar) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Z(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer V = V(context, dVar);
        if (V != null) {
            return V.intValue();
        }
        if (!this.B.Code(context, dVar, true)) {
            gl.V("PPSAppDownloadManager", "resumeDownload has not permission, please add white list");
            return -2;
        }
        if (L(context, dVar)) {
            gl.V("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        }
        if (a(context, dVar)) {
            gl.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        }
        AppDownloadTask V2 = this.Code.V(dVar.v());
        if (V2 == null) {
            gl.V("PPSAppDownloadManager", "app download info is empty, must first invoke startDownload method");
            return -1;
        }
        V(dVar, V2);
        Code(dVar, V2);
        this.Code.I(V2);
        return 0;
    }
}
