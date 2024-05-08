package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.a.r;
import com.kwad.components.core.webview.tachikoma.a.s;
import com.kwad.components.core.webview.tachikoma.a.t;
import com.kwad.components.core.webview.tachikoma.a.v;
import com.kwad.components.core.webview.tachikoma.a.x;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.v;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class i implements com.kwad.components.core.e.e.f, n, com.kwad.sdk.core.view.b, com.kwad.sdk.core.webview.d.a.a {
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.tachikoma.c.e>> Zb = new HashMap();
    private long EW;
    private StyleTemplate SA;
    private com.kwad.sdk.core.download.d VB;
    private com.kwad.components.core.webview.tachikoma.c.e YI;
    public j YJ;
    private com.kwad.sdk.core.webview.c.g YK;
    private com.kwad.components.core.n.a.d.c YL;
    private Future<?> YM;
    private q YN;
    private p YO;
    private av YP;
    private com.kwad.sdk.core.view.d YQ;
    private boolean YR;
    private boolean YS;
    private boolean YT;
    private boolean YU;
    private boolean YV;
    private int YW;
    private long YX;
    private long YY;
    private long YZ;
    private Map<String, Object> Za;
    private int Zc;
    private int Zd;
    private boolean Ze;
    private String Zf;
    private String Zg;
    public com.kwad.sdk.core.webview.e Zh;
    private a Zi;
    private o Zj;
    private com.kwad.sdk.components.j Zk;
    private final Runnable Zl;
    private final Runnable Zm;
    private aw cQ;
    private final l gO;

    @Nullable
    private Activity mActivity;
    private AdResultData mAdResultData;
    public final Context mContext;
    private final y wp;
    public long xs;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onFailed();

        void onSuccess();
    }

    public i(Context context) {
        this(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.sdk.components.i aB(final AdTemplate adTemplate) {
        final com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(adTemplate);
        cVar.ob();
        return new com.kwad.sdk.components.i() { // from class: com.kwad.components.core.webview.tachikoma.i.24
            @Override // com.kwad.sdk.components.i
            public final void a(final com.kwad.sdk.components.h hVar) {
                cVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.24.1
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        hVar.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        hVar.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        hVar.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        hVar.onIdle();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        hVar.onInstalled();
                    }

                    @Override // com.kwad.sdk.core.download.a.a
                    public final void onPaused(int i10) {
                        hVar.onPaused(i10);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i10) {
                        hVar.onProgressUpdate(i10);
                    }
                });
            }

            @Override // com.kwad.sdk.components.i
            public final void cancelDownload() {
                com.kwad.sdk.core.download.a.dx(com.kwad.sdk.core.response.b.e.dT(adTemplate));
            }

            @Override // com.kwad.sdk.components.i
            public final void installApp() {
                cVar.og();
            }

            @Override // com.kwad.sdk.components.i
            public final void openApp() {
                cVar.oe();
            }

            @Override // com.kwad.sdk.components.i
            public final void pauseDownload() {
                cVar.oi();
            }

            @Override // com.kwad.sdk.components.i
            public final void resumeDownload() {
                cVar.oj();
            }

            @Override // com.kwad.sdk.components.i
            public final void setCustomReportParam(String str) {
                try {
                    cVar.d(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }

            @Override // com.kwad.sdk.components.i
            public final void startDownload() {
                cVar.oh();
            }

            @Override // com.kwad.sdk.components.i
            public final void stopDownload() {
                cVar.oi();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(String str) {
        b(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        aR(str);
    }

    private static StyleTemplate aQ(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return null;
    }

    private void aR(String str) {
        f(this.YJ.getTkTemplateId(), str);
        StyleTemplate sH = sH();
        if (sH == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YW).setRenderState(4).setErrorReason(str).setTemplateId(this.YJ.getTkTemplateId()).setVersionCode(String.valueOf(sH.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str) {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.YJ.getTkTemplateId());
        g(this.YJ.getTkTemplateId(), str);
        if (!this.YT || this.YU) {
            return;
        }
        this.YU = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YW).setRenderState(2).setErrorReason(str).setTemplateId(this.YJ.getTkTemplateId()).setVersionCode(String.valueOf(this.SA.templateVersionCode)).toJson());
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    private void sE() {
        this.YT = false;
        this.YU = false;
        this.YR = false;
        this.YS = false;
        this.YV = false;
        this.EW = 0L;
        this.YY = 0L;
        this.YZ = 0L;
        this.YX = 0L;
    }

    private void sF() {
        if (isLocalDebugEnable()) {
            this.Zc = 2000;
            this.Zd = 3000;
        }
        bn.runOnUiThreadDelay(this.Zl, this.Zc);
        int i10 = this.Zd;
        if (i10 > 0) {
            bn.runOnUiThreadDelay(this.Zm, i10);
        }
        this.YM = GlobalThreadPools.FH().submit(new ay() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                i.this.EW = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.e.c.d("TKLoadController", "开始读取模板 id: " + i.this.YJ.getTkTemplateId());
                i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.1.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        i.this.aP(str);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        i.this.b(styleTemplate);
                    }
                });
            }
        });
    }

    private static boolean sG() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    private StyleTemplate sH() {
        String tkTemplateId = this.YJ.getTkTemplateId();
        StyleTemplate styleTemplate = this.SA;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate aQ = aQ(tkTemplateId);
        if (aQ != null) {
            return aQ;
        }
        if (isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = new StyleTemplate();
            styleTemplate2.templateId = tkTemplateId;
            styleTemplate2.templateVersion = "1.0.4";
            styleTemplate2.templateVersionCode = 104;
            if (sG()) {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.coverage.zip";
            } else {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.zip";
            }
            return styleTemplate2;
        }
        StyleTemplate styleTemplate3 = this.SA;
        if (styleTemplate3 != null) {
            return styleTemplate3;
        }
        AdMatrixInfo.MatrixTemplate k10 = com.kwad.sdk.core.response.b.b.k(sJ(), this.YJ.getTkTemplateId());
        if (k10 == null) {
            return null;
        }
        com.kwad.components.core.n.a.d.c cVar = this.YL;
        if (cVar == null) {
            StyleTemplate styleTemplate4 = new StyleTemplate();
            styleTemplate4.templateId = k10.templateId;
            styleTemplate4.templateMd5 = k10.templateMd5;
            styleTemplate4.templateUrl = k10.templateUrl;
            styleTemplate4.templateVersionCode = (int) k10.templateVersionCode;
            styleTemplate4.tkSouce = 0;
            return styleTemplate4;
        }
        return cVar.checkStyleTemplateById(this.mContext, k10.templateId, k10.templateMd5, k10.templateUrl, (int) k10.templateVersionCode);
    }

    private void sI() {
        this.Zh.a(!ai.LZ() ? 1 : 0, this.YJ.getTouchCoordsView(), this.YJ.getTKContainer(), this.YJ.getTkTemplateId());
    }

    private void sK() {
        StyleTemplate sH = sH();
        if (sH == null) {
            return;
        }
        this.YW = sH.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.YW).setRenderState(-1).setTemplateId(this.YJ.getTkTemplateId()).setVersionCode(String.valueOf(sH.templateVersionCode)).toJson());
    }

    private void sL() {
        this.YT = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.YW).setRenderState(0).setTemplateId(this.YJ.getTkTemplateId()).setVersionCode(String.valueOf(this.SA.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM() {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderSuccess, templateId = " + this.YJ.getTkTemplateId());
        if (!this.YT || this.YU) {
            return;
        }
        this.YU = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.YW).setRenderState(1).setRenderTime(this.YX > 0 ? SystemClock.elapsedRealtime() - this.YX : 0L).setTemplateId(this.YJ.getTkTemplateId()).setLoadTime(this.YY - this.EW).setInitTime(this.YZ).setVersionCode(String.valueOf(this.SA.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN() {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.YJ.getTkTemplateId());
        StyleTemplate sH = sH();
        if (sH == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YW).setRenderState(3).setErrorReason("timeout").setTemplateId(this.YJ.getTkTemplateId()).setVersionCode(String.valueOf(sH.templateVersionCode)).toJson());
    }

    private Map<String, Object> sO() {
        if (this.Za == null) {
            HashMap hashMap = new HashMap();
            this.Za = hashMap;
            hashMap.put("TKVersion", "5.1.7");
            this.Za.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.Za.put(ALBiometricsKeys.KEY_SDK_TYPE, 1);
        }
        return this.Za;
    }

    private void sP() {
        if (this.YL == null || this.YN == null) {
            return;
        }
        File file = new File(new File(this.YL.getJsBaseDir(this.mContext, this.YJ.getTkTemplateId())), "kcov.json");
        if (file.exists()) {
            try {
                String V = com.kwad.sdk.utils.q.V(file);
                if (TextUtils.isEmpty(V)) {
                    return;
                }
                com.kwad.sdk.core.e.c.d("TKLoadController", "kcov.json:" + V);
                JSONObject jSONObject = new JSONObject(V);
                final String string = jSONObject.getString("gitHeadCommit");
                final String string2 = jSONObject.getString("coverageApi");
                final String string3 = jSONObject.getString("coverageTaskId");
                final String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    StringBuilder sb2 = new StringBuilder("尝试获取覆盖率统计... ");
                    sb2.append((Object) this.SA);
                    com.kwad.sdk.core.e.c.d("TKLoadController", sb2.toString() != null ? this.SA.templateId : "");
                    Object execute = this.YN.execute("JSON.stringify(this.__coverage__)");
                    if (execute instanceof String) {
                        final String str = (String) execute;
                        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.19
                            @Override // java.lang.Runnable
                            public final void run() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                    jSONObject2.put(UserData.NAME, "");
                                    jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
                                    jSONObject2.put("branch_name", string4);
                                    jSONObject2.put("version", BuildConfig.VERSION_NAME);
                                    jSONObject2.put("tk_version", String.valueOf(i.this.SA.templateVersionCode));
                                    jSONObject2.put("tk_template_ids", i.this.SA.templateId);
                                } catch (JSONException e2) {
                                    com.kwad.sdk.core.e.c.printStackTrace(e2);
                                }
                                com.kwad.sdk.core.network.c doPost = com.kwad.sdk.f.xT().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                                if (doPost.DM()) {
                                    com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + doPost.avs);
                                } else {
                                    com.kwad.sdk.core.e.c.d("TKLoadController", "上传覆盖率pkg失败");
                                }
                                com.kwad.sdk.core.network.c doPost2 = com.kwad.sdk.f.xT().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.19.1
                                    @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                    public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                        adHttpFormDataBuilder.addFormDataPart(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, string3);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                        adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                        adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                                        adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                        adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                        adHttpFormDataBuilder.addFormDataPart("uid", "");
                                        adHttpFormDataBuilder.addFormDataPart("did", com.kwad.sdk.utils.av.getDeviceId());
                                        adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                        adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                        try {
                                            adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                                        } catch (UnsupportedEncodingException e10) {
                                            com.kwad.sdk.core.e.c.printStackTrace(e10);
                                        }
                                    }
                                });
                                if (doPost2.DM()) {
                                    com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率完成:" + doPost2.avs);
                                    return;
                                }
                                com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率失败");
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.e.c.d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    public void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, q qVar, ViewGroup viewGroup) {
    }

    @Override // com.kwad.sdk.components.n
    public final void callJS(String str) {
        q qVar = this.YN;
        if (qVar != null) {
            qVar.a(str, null, null);
        }
    }

    @Override // com.kwad.components.core.e.e.f
    public void dismiss() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sv();
        }
    }

    public void f(String str, String str2) {
    }

    public void g(String str, String str2) {
    }

    public final String getTkTemplateId() {
        j jVar = this.YJ;
        if (jVar == null) {
            return null;
        }
        return jVar.getTkTemplateId();
    }

    public void jp() {
        com.kwad.sdk.core.view.d dVar = this.YQ;
        if (dVar != null) {
            dVar.getWindowFocusChangeHelper().b(this);
            this.YQ = null;
        }
        Future<?> future = this.YM;
        if (future != null) {
            future.cancel(true);
        }
        bn.c(this.Zl);
        bn.c(this.Zm);
        com.kwad.components.core.e.e.g.or().b(this);
        if (this.VB != null) {
            com.kwad.sdk.core.download.b.De().a(this.VB);
        }
        com.kwad.components.core.webview.tachikoma.c.e eVar = this.YI;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (com.kwad.components.core.a.f36624md.booleanValue()) {
            sP();
        }
        com.kwad.components.core.n.a.d.c cVar = this.YL;
        if (cVar != null) {
            cVar.onDestroy();
        }
        final q qVar = this.YN;
        if (qVar != null) {
            this.YN = null;
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.18
                @Override // java.lang.Runnable
                public final void run() {
                    q qVar2 = qVar;
                    if (qVar2 != null) {
                        qVar2.onDestroy();
                    }
                }
            });
        }
    }

    public boolean nk() {
        return false;
    }

    public final com.kwad.sdk.core.webview.b sD() {
        return this.Zh;
    }

    public final AdTemplate sJ() {
        return this.Zh.getAdTemplate();
    }

    @Override // com.kwad.components.core.e.e.f
    public void show() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sw();
        }
    }

    public i(Context context, boolean z10) {
        this.YR = false;
        this.YS = false;
        this.YT = false;
        this.YU = false;
        this.YV = false;
        this.YW = 0;
        this.xs = -1L;
        this.Zc = 1000;
        this.Zd = 0;
        this.Ze = true;
        this.Zh = new com.kwad.sdk.core.webview.e();
        this.Zi = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.Zj = new o() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.o
            public final void a(com.kwad.sdk.components.k kVar) {
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.DD();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = kVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(kVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            kVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(kVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final m a(Object... objArr) {
                                if (i.this.YN != null) {
                                    return i.this.YN.aY(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b4 = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b4.show(activity.getFragmentManager(), "");
                    i.Zb.put(Integer.valueOf(kVar.getDialogId()), new WeakReference(b4));
                    return;
                }
                kVar.callbackPageStatus(false, "no host activity");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.components.o
            public final void b(com.kwad.sdk.components.k kVar) {
                WeakReference weakReference = (WeakReference) i.Zb.get(Integer.valueOf(kVar.getDialogId()));
                if (weakReference == null || weakReference.get() == 0) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
            
                if (r0 != com.kwad.sdk.core.c.b.getCurrentActivity()) goto L6;
             */
            @Override // com.kwad.sdk.components.o
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(com.kwad.sdk.components.l r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.DD()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.DD()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r4 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r3, r4)
                    int r4 = com.kwad.components.core.r.a.a.qR()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.mE()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.c(r6)
                    int r5 = r5.i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.e.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass22.a(com.kwad.sdk.components.l):void");
            }
        };
        this.Zk = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aS(int i10) {
                return i.this.aB(com.kwad.sdk.core.response.b.c.n(com.kwad.components.core.n.a.d.a.a.at(i10)));
            }

            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aT(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aB(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.Zl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.YJ.getTkTemplateId());
                i.this.sN();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.Zm = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d10) {
                i.this.wp.aax = false;
                i.this.wp.aat = false;
                i.this.wp.nE = (int) ((d10 / 1000.0d) + 0.5d);
                iU();
            }

            private void iU() {
                if (i.this.YO == null || i.this.wp == null) {
                    return;
                }
                i.this.YO.a(i.this.wp);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wp.aat = true;
                i.this.wp.aax = false;
                i.this.wp.nE = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dQ(i.this.sJ()));
                iU();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                i.this.wp.aax = true;
                i.this.wp.aat = false;
                iU();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j10, long j11) {
                g(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(ShadowDrawableWrapper.COS_45);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(ShadowDrawableWrapper.COS_45);
            }
        };
        this.mContext = context;
        this.xs = -1L;
        this.Zc = 1000;
        this.Ze = z10;
        this.wp = new y();
    }

    public static /* synthetic */ boolean c(i iVar, boolean z10) {
        iVar.YV = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : " + ((Object) th) + ", templateId = " + this.YJ.getTkTemplateId());
        String tkTemplateId = this.YJ.getTkTemplateId();
        StringBuilder sb2 = new StringBuilder("error:");
        sb2.append(th.toString());
        g(tkTemplateId, sb2.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YW).setRenderState(3).setErrorReason(th.toString()).setTemplateId(this.YJ.getTkTemplateId()).setVersionCode(String.valueOf(this.SA.templateVersionCode)).toJson());
    }

    @Override // com.kwad.sdk.core.view.b
    public final void i(View view, boolean z10) {
        av avVar;
        FrameLayout tKContainer = this.YJ.getTKContainer();
        if (tKContainer == null || !tKContainer.equals(view) || (avVar = this.YP) == null) {
            return;
        }
        avVar.aU(z10);
    }

    public static /* synthetic */ boolean b(i iVar, boolean z10) {
        iVar.YS = true;
        return true;
    }

    public ak c(com.kwad.sdk.core.webview.b bVar) {
        return new ak(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.i.e("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.e.c.d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.EW) + ", 读取成功" + styleTemplate.templateId);
        if (this.YR) {
            return;
        }
        com.kwad.sdk.core.e.c.d("TKLoadController", "没有超时");
        bn.c(this.Zl);
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.i.12
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                i iVar = i.this;
                iVar.a(styleTemplate, iVar.Zi);
            }
        });
        ViewParent tKContainer = this.YJ.getTKContainer();
        if (tKContainer instanceof com.kwad.sdk.core.view.d) {
            com.kwad.sdk.core.view.d dVar = (com.kwad.sdk.core.view.d) tKContainer;
            this.YQ = dVar;
            dVar.getWindowFocusChangeHelper().a(this);
        }
    }

    public static /* synthetic */ boolean a(i iVar, boolean z10) {
        iVar.YR = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final TKRenderFailReason tKRenderFailReason) {
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                if (i.this.YV) {
                    return;
                }
                i.c(i.this, true);
                i.this.YJ.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.or().b(i.this);
                com.kwad.components.core.webview.tachikoma.d.b.tc().s(i.this.Zf, i.this.Zg);
            }
        });
    }

    public final void a(StyleTemplate styleTemplate) {
        this.SA = styleTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(aj.a aVar) {
        FrameLayout tKContainer = this.YJ.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.d.a.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.d.a.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.d.a.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.d.a.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    public void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        this.mActivity = activity;
        this.mAdResultData = adResultData;
        this.Zh.d(adResultData);
        this.YJ = jVar;
        this.Zf = jVar.getTkTemplateId();
        this.Zg = this.YJ.getTKReaderScene();
        sE();
        FrameLayout tKContainer = this.YJ.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.d.BV()) {
            b(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.YL = (com.kwad.components.core.n.a.d.c) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.c.class);
        sK();
        com.kwad.sdk.core.e.c.d("TKLoadController", "bind mTKPlugin: " + ((Object) this.YL));
        if (TextUtils.isEmpty(this.Zf)) {
            com.kwad.sdk.commercial.e.a.e(sJ(), this.Zg);
        }
        if (this.YL != null) {
            sF();
            return;
        }
        b(TKRenderFailReason.PLUGIN_NOT_READY);
        f(this.Zf, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.YW).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.Zf).toJson());
    }

    public i(long j10, Context context) {
        this.YR = false;
        this.YS = false;
        this.YT = false;
        this.YU = false;
        this.YV = false;
        this.YW = 0;
        this.xs = -1L;
        this.Zc = 1000;
        this.Zd = 0;
        this.Ze = true;
        this.Zh = new com.kwad.sdk.core.webview.e();
        this.Zi = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.Zj = new o() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.o
            public final void a(com.kwad.sdk.components.k kVar) {
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.DD();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = kVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(kVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            kVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(kVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final m a(Object... objArr) {
                                if (i.this.YN != null) {
                                    return i.this.YN.aY(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b4 = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b4.show(activity.getFragmentManager(), "");
                    i.Zb.put(Integer.valueOf(kVar.getDialogId()), new WeakReference(b4));
                    return;
                }
                kVar.callbackPageStatus(false, "no host activity");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.components.o
            public final void b(com.kwad.sdk.components.k kVar) {
                WeakReference weakReference = (WeakReference) i.Zb.get(Integer.valueOf(kVar.getDialogId()));
                if (weakReference == null || weakReference.get() == 0) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
            }

            @Override // com.kwad.sdk.components.o
            public final void a(com.kwad.sdk.components.l lVar) {
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                    	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    */
                /*
                    this = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.DD()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.DD()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r4 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r3, r4)
                    int r4 = com.kwad.components.core.r.a.a.qR()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.mE()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.c(r6)
                    int r5 = r5.i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.e.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass22.a(com.kwad.sdk.components.l):void");
            }
        };
        this.Zk = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aS(int i10) {
                return i.this.aB(com.kwad.sdk.core.response.b.c.n(com.kwad.components.core.n.a.d.a.a.at(i10)));
            }

            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aT(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aB(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.Zl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.YJ.getTkTemplateId());
                i.this.sN();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.Zm = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d10) {
                i.this.wp.aax = false;
                i.this.wp.aat = false;
                i.this.wp.nE = (int) ((d10 / 1000.0d) + 0.5d);
                iU();
            }

            private void iU() {
                if (i.this.YO == null || i.this.wp == null) {
                    return;
                }
                i.this.YO.a(i.this.wp);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wp.aat = true;
                i.this.wp.aax = false;
                i.this.wp.nE = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dQ(i.this.sJ()));
                iU();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
                i.this.wp.aax = true;
                i.this.wp.aat = false;
                iU();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j102, long j11) {
                g(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(ShadowDrawableWrapper.COS_45);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(ShadowDrawableWrapper.COS_45);
            }
        };
        this.mContext = context;
        this.xs = j10;
        this.wp = new y();
    }

    public final void a(com.kwad.sdk.core.webview.c.g gVar) {
        this.YK = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TKDownloadListener tKDownloadListener) {
        StyleTemplate sH = sH();
        if (sH == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String o10 = h.sB().o(sH.templateId, sH.templateVersionCode);
            if (!TextUtils.isEmpty(o10) && !isLocalDebugEnable()) {
                sH.jsStr = o10;
                sH.tkSouce = 4;
                com.kwad.sdk.core.e.c.d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(sH);
                return;
            }
        }
        this.YL.loadTkFileByTemplateId(this.mContext, sH.templateId, sH.templateMd5, sH.templateUrl, sH.templateVersionCode, tKDownloadListener);
    }

    public i(Context context, int i10, int i11) {
        this.YR = false;
        this.YS = false;
        this.YT = false;
        this.YU = false;
        this.YV = false;
        this.YW = 0;
        this.xs = -1L;
        this.Zc = 1000;
        this.Zd = 0;
        this.Ze = true;
        this.Zh = new com.kwad.sdk.core.webview.e();
        this.Zi = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.Zj = new o() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.o
            public final void a(com.kwad.sdk.components.k kVar) {
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.DD();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = kVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(kVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            kVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(kVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final m a(Object... objArr) {
                                if (i.this.YN != null) {
                                    return i.this.YN.aY(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b4 = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b4.show(activity.getFragmentManager(), "");
                    i.Zb.put(Integer.valueOf(kVar.getDialogId()), new WeakReference(b4));
                    return;
                }
                kVar.callbackPageStatus(false, "no host activity");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.components.o
            public final void b(com.kwad.sdk.components.k kVar) {
                WeakReference weakReference = (WeakReference) i.Zb.get(Integer.valueOf(kVar.getDialogId()));
                if (weakReference == null || weakReference.get() == 0) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
            }

            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                */
            @Override // com.kwad.sdk.components.o
            public final void a(com.kwad.sdk.components.l r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.DD()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.DD()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r4 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r3, r4)
                    int r4 = com.kwad.components.core.r.a.a.qR()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.mE()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.c(r6)
                    int r5 = r5.i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.e.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass22.a(com.kwad.sdk.components.l):void");
            }
        };
        this.Zk = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aS(int i102) {
                return i.this.aB(com.kwad.sdk.core.response.b.c.n(com.kwad.components.core.n.a.d.a.a.at(i102)));
            }

            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aT(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aB(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.Zl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.YJ.getTkTemplateId());
                i.this.sN();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.Zm = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d10) {
                i.this.wp.aax = false;
                i.this.wp.aat = false;
                i.this.wp.nE = (int) ((d10 / 1000.0d) + 0.5d);
                iU();
            }

            private void iU() {
                if (i.this.YO == null || i.this.wp == null) {
                    return;
                }
                i.this.YO.a(i.this.wp);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wp.aat = true;
                i.this.wp.aax = false;
                i.this.wp.nE = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dQ(i.this.sJ()));
                iU();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i102, int i112) {
                i.this.wp.aax = true;
                i.this.wp.aat = false;
                iU();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j102, long j11) {
                g(j11);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(ShadowDrawableWrapper.COS_45);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(ShadowDrawableWrapper.COS_45);
            }
        };
        this.mContext = context;
        this.Zc = i10;
        this.wp = new y();
        this.Zd = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, final a aVar) {
        this.SA = styleTemplate;
        com.kwad.sdk.core.e.c.w("TKLoadController", "addTKView mTKPlugin.getState(): " + ((Object) this.YL.getState()));
        if (this.YL.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            aR(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            aS(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            sL();
            this.YY = SystemClock.elapsedRealtime();
            q a10 = this.YL.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.Ze);
            com.kwad.components.core.n.a.d.a.a.a(a10.getUniqId(), this.mAdResultData);
            a10.a(this.Zj);
            a10.a(this.Zk);
            AdResultData adResultData = this.mAdResultData;
            if (adResultData != null && com.kwad.sdk.core.response.b.c.n(adResultData).mAdScene != null) {
                sO().put("adStyle", Integer.valueOf(com.kwad.sdk.core.response.b.c.n(this.mAdResultData).mAdScene.getAdStyle()));
                sO().put("adScene", com.kwad.sdk.core.response.b.c.n(this.mAdResultData).mAdScene.toJson().toString());
            }
            if (this.SA != null) {
                sO().put("styleTemplate", this.SA.toJson().toString());
            }
            sO().put("adCacheId", Integer.valueOf(a10.getUniqId()));
            sO().put("appId", ServiceProvider.getAppId());
            sO().put("isDebug", com.kwad.components.core.a.f36624md);
            a10.setCustomEnv(sO());
            this.YN = a10;
            com.kwad.sdk.core.c.b.DD();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null) {
                ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
                sO().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.d.a.a.C(viewGroup) && com.kwad.sdk.d.a.a.aI(currentActivity) == viewGroup.getHeight()));
            }
            a10.setCustomEnv(sO());
            com.kwad.sdk.core.webview.c.g gVar = this.YK;
            if (gVar != null) {
                a10.b(gVar);
            }
            this.YZ = SystemClock.elapsedRealtime() - this.YY;
            this.YX = SystemClock.elapsedRealtime();
            sI();
            a(a10);
            File file = new File(this.YL.getJsBaseDir(this.mContext, this.YJ.getTkTemplateId()));
            a10.a(styleTemplate.jsStr, file.getAbsolutePath() + "/", new com.kwad.sdk.components.p() { // from class: com.kwad.components.core.webview.tachikoma.i.21
                @Override // com.kwad.sdk.components.p
                public final void onFailed(Throwable th) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onFailed();
                    }
                    i.this.f(th);
                }

                @Override // com.kwad.sdk.components.p
                public final void onSuccess() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onSuccess();
                    }
                }
            });
            FrameLayout tKContainer = this.YJ.getTKContainer();
            if (tKContainer == null || !this.Ze) {
                return;
            }
            View view = a10.getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            tKContainer.addView(view);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            f(th);
            if (aVar != null) {
                aVar.onFailed();
            }
        }
    }

    private void a(q qVar) {
        com.kwad.components.core.e.d.c cVar = sJ() != null ? new com.kwad.components.core.e.d.c(sJ()) : null;
        this.YJ.a(qVar, this.Zh);
        a(qVar, new com.kwad.components.core.webview.jshandler.o());
        a(qVar, new com.kwad.components.core.webview.jshandler.p());
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            @Override // com.kwad.components.core.webview.tachikoma.a.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar2) {
                if (TextUtils.isEmpty(sVar2.message)) {
                    return;
                }
                v.d(i.this.mContext, sVar2.message, 0L);
            }
        });
        a(qVar, sVar);
        a(qVar, c(this.Zh));
        a(qVar, new com.kwad.components.core.webview.jshandler.l(this.Zh));
        a(qVar, new com.kwad.components.core.webview.jshandler.m(this.Zh));
        a(qVar, new com.kwad.sdk.core.webview.d.a());
        a(qVar, new com.kwad.components.core.webview.tachikoma.a.f());
        a(qVar, new x());
        if (nk()) {
            com.kwad.components.core.webview.jshandler.x xVar = new com.kwad.components.core.webview.jshandler.x(this.Zh, cVar, this);
            if (!this.Zf.equals(com.kwad.sdk.core.response.b.b.cP(this.Zh.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.or().a(this);
            }
            a(qVar, xVar);
        } else {
            a(qVar, new aa(this.Zh, cVar, this, (byte) 0));
        }
        a(qVar, new z());
        a(qVar, new com.kwad.components.core.webview.tachikoma.a.k());
        a(qVar, new ad(this.Zh));
        a(qVar, new ag(this.Zh));
        a(qVar, new ap(this.mContext, sJ()));
        ac acVar = new ac(this.Zh);
        acVar.a(new ac.b() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.components.core.webview.jshandler.ac.b
            public final void c(ac.a aVar) {
                i.this.YJ.b(aVar);
            }
        });
        a(qVar, acVar);
        a(qVar, new aj(this.Zh, new aj.b() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.components.core.webview.jshandler.aj.b
            public final void a(aj.a aVar) {
                i.this.b(aVar);
            }
        }));
        a(qVar, new aq(new aq.b() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar) {
                if (aVar.status == 1) {
                    if (!i.this.YS) {
                        bn.c(i.this.Zm);
                        i.this.sM();
                        if (i.this.YJ != null) {
                            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.6.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    i.this.YJ.bF();
                                }
                            });
                            com.kwad.components.core.webview.tachikoma.d.b.tc().c(i.this.YJ.getTkTemplateId(), i.this.YY - i.this.EW, i.this.YZ, i.this.YX > 0 ? SystemClock.elapsedRealtime() - i.this.YX : 0L);
                            return;
                        }
                        return;
                    }
                    i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
                    return;
                }
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                i.this.aS(aVar.errorMsg);
            }
        }));
        aw awVar = new aw();
        this.cQ = awVar;
        a(qVar, awVar);
        this.YJ.a(this.cQ);
        av avVar = new av();
        this.YP = avVar;
        a(qVar, avVar);
        a(qVar, new az(this.Zh, cVar));
        p pVar = new p();
        this.YO = pVar;
        a(qVar, pVar);
        this.YJ.a(this.YO);
        a(qVar, new com.kwad.components.core.webview.jshandler.a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // com.kwad.components.core.webview.jshandler.a.b
            public final void c(a.C0481a c0481a) {
                i.this.YJ.a(c0481a);
            }
        }));
        if (sJ() != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(sJ()))) {
            final com.kwad.components.core.webview.tachikoma.a.l lVar = new com.kwad.components.core.webview.tachikoma.a.l();
            a(qVar, lVar);
            this.VB = new com.kwad.sdk.core.download.d(sJ()) { // from class: com.kwad.components.core.webview.tachikoma.i.8
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.b.b bVar = new com.kwad.components.core.webview.tachikoma.b.b();
                    bVar.aaf = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.De().a(this.VB, sJ());
        }
        t tVar = new t();
        tVar.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            @Override // com.kwad.components.core.webview.tachikoma.a.t.a
            public final void b(com.kwad.components.core.webview.tachikoma.b.t tVar2) {
                i.this.YJ.a(tVar2);
            }
        });
        a(qVar, tVar);
        com.kwad.components.core.webview.tachikoma.a.v vVar = new com.kwad.components.core.webview.tachikoma.a.v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.10
            @Override // com.kwad.components.core.webview.tachikoma.a.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.b.m mVar) {
                i.this.YJ.a(mVar);
            }
        });
        a(qVar, vVar);
        com.kwad.components.core.webview.tachikoma.a.o oVar = new com.kwad.components.core.webview.tachikoma.a.o();
        a(qVar, oVar);
        this.YJ.a(oVar);
        a(qVar, new r() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            @Override // com.kwad.components.core.webview.tachikoma.a.r
            public final void a(com.kwad.components.core.webview.tachikoma.b.r rVar) {
                super.a(rVar);
                if (i.this.mActivity == null) {
                    i iVar = i.this;
                    com.kwad.sdk.core.c.b.DD();
                    iVar.mActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (i.this.mActivity == null || i.this.mActivity.isFinishing()) {
                    return;
                }
                if (i.this.YI != null) {
                    i.this.YI.dismiss();
                }
                e.b bVar = new e.b();
                bVar.d(i.this.mAdResultData);
                bVar.aU(rVar.templateId);
                i.this.YI = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                i.this.YI.show(i.this.mActivity.getFragmentManager(), "");
            }
        });
        a(qVar, new com.kwad.components.core.webview.tachikoma.a.c() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            @Override // com.kwad.components.core.webview.tachikoma.a.c
            public final void iX() {
                super.iX();
                if (i.this.YI != null) {
                    i.this.YI.dismiss();
                }
                j jVar = i.this.YJ;
                if (jVar != null) {
                    jVar.bG();
                }
            }
        });
        a(qVar, new com.kwad.components.core.webview.jshandler.y(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.YJ.a(webCloseStatus);
            }
        }));
        a(qVar, new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final void a(com.kwad.components.core.webview.tachikoma.b.g gVar) {
                int i10 = gVar.VN;
                AdTemplate a10 = i10 >= 0 ? com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(i10), gVar.Jj) : null;
                if (a10 == null) {
                    a10 = i.this.sJ();
                }
                com.kwad.components.core.o.a.qi().a(gVar.actionType, a10, gVar.KG);
            }
        });
        a(qVar, new com.kwad.components.core.webview.tachikoma.a.j() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            @Override // com.kwad.components.core.webview.tachikoma.a.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0472a().as(nVar.title).at(nVar.url).aE(!nVar.aap).m(i.this.mAdResultData).pl());
            }
        });
        a(qVar, new com.kwad.components.core.webview.tachikoma.a.a(sJ()));
        a(qVar, new com.kwad.components.core.webview.tachikoma.a(sJ()));
        a(this.Zh, cVar, qVar, this.YJ.getTKContainer());
    }

    private static void a(q qVar, com.kwad.sdk.core.webview.c.a aVar) {
        qVar.c(aVar);
    }

    public final void a(String str, Object obj) {
        sO().put(str, obj);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        j jVar = this.YJ;
        if (jVar != null) {
            jVar.a(aVar);
        }
    }
}
