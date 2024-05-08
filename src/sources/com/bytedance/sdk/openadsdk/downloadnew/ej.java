package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.downloadnew.dk;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.f;
import com.ss.android.download.api.config.hc;
import com.ss.android.download.api.config.mj;
import com.ss.android.download.api.config.oa;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.config.ve;
import com.ss.android.download.api.config.w;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.dk;
import com.ss.android.download.api.model.m;
import com.ss.android.downloadlib.addownload.dk.n;
import com.ss.android.downloadlib.addownload.m.m;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej {
    public static ITTDownloadVisitor ej;

    /* renamed from: hc, reason: collision with root package name */
    private static final com.ss.android.download.api.download.m.m f11145hc;

    /* renamed from: m, reason: collision with root package name */
    public static volatile String f11147m;

    /* renamed from: n, reason: collision with root package name */
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f11148n;
    private static Context np;

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicBoolean f11146l = new AtomicBoolean(false);
    public static boolean dk = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class np implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public IDownloadHttpConnection downloadWithConnection(int i10, String str, List<HttpHeader> list) throws IOException {
            final dk.m m10 = com.bytedance.sdk.openadsdk.downloadnew.dk.m(str, list);
            if (m10 != null) {
                return new IDownloadHttpConnection() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.np.1
                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public void cancel() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public void end() {
                        try {
                            m10.f11143l.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public InputStream getInputStream() {
                        return m10.f11144m;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public int getResponseCode() {
                        return m10.ej;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public String getResponseHeaderField(String str2) {
                        Map<String, String> map = m10.dk;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    static {
        try {
            f11147m = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f11145hc = new com.ss.android.download.api.download.m.m() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.6
            @Override // com.ss.android.download.api.download.m.m
            public void dk(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.ej.dk("TTDownloadVisitor", "completeListener: onInstalled");
                ej.ej(str);
            }

            @Override // com.ss.android.download.api.download.m.m
            public void m(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.ej.dk("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.m.m
            public void m(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.ej.dk("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.m.m
            public void m(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.ej.dk("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.m.m
            public void m(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.ej.dk("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ej(String str) {
        com.ss.android.downloadad.api.m.dk m10;
        JSONObject hc2;
        if (TextUtils.isEmpty(str) || (m10 = n.m().m(str)) == null || (hc2 = m10.hc()) == null || np() == null) {
            return;
        }
        np().checkAutoControl(hc2, str);
    }

    private static Context getContext() {
        Context context = np;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    public static /* synthetic */ ITTDownloadVisitor l() {
        return np();
    }

    private static boolean n() {
        return false;
    }

    private static ITTDownloadVisitor np() {
        ITTDownloadVisitor iTTDownloadVisitor = ej;
        if (iTTDownloadVisitor != null) {
            return iTTDownloadVisitor;
        }
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager == null) {
            return null;
        }
        return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.m.m(1));
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.ej$ej, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0128ej implements w {
        @Override // com.ss.android.download.api.config.w
        public void m(Activity activity, int i10, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.w
        public void m(Activity activity, String[] strArr, final mj mjVar) {
            if (ej.l() != null) {
                ej.l().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.ej.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        mj mjVar2 = mjVar;
                        if (mjVar2 != null) {
                            mjVar2.m(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        mj mjVar2 = mjVar;
                        if (mjVar2 != null) {
                            mjVar2.m();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.w
        public boolean m(Context context, String str) {
            if (ej.l() != null) {
                return ej.l().hasPermission(context, str);
            }
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class m implements hc {
        private void ej(com.ss.android.download.api.model.ej ejVar) {
            if (ejVar == null) {
                return;
            }
            Object ve = ejVar.ve();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(ejVar.dk()).setExtJson(ejVar.e()).setMaterialMeta(ve instanceof JSONObject ? (JSONObject) ve : null).setLabel(ejVar.ej());
            boolean z10 = "download_notification".equals(ejVar.dk()) || "landing_h5_download_ad_button".equals(ejVar.dk());
            if (ej.l() != null) {
                ej.l().executeLogUpload(label, z10);
            }
        }

        @Override // com.ss.android.download.api.config.hc
        public void dk(com.ss.android.download.api.model.ej ejVar) {
            com.bytedance.sdk.openadsdk.api.ej.dk("LibEventLogger", "onEvent called");
            m(ejVar, false);
            ej(ejVar);
        }

        @Override // com.ss.android.download.api.config.hc
        public void m(com.ss.android.download.api.model.ej ejVar) {
            com.bytedance.sdk.openadsdk.api.ej.dk("LibEventLogger", "onV3Event");
            m(ejVar, true);
        }

        private void m(com.ss.android.download.api.model.ej ejVar, boolean z10) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (ej.l() == null || (tTDownloadEventLogger = ej.l().getTTDownloadEventLogger()) == null || ejVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && ej.l().isOpenSdkEvent(ejVar.toString())) {
                return;
            }
            if (z10) {
                tTDownloadEventLogger.onV3Event(ej.dk(ejVar));
            } else {
                tTDownloadEventLogger.onEvent(ej.dk(ejVar));
            }
        }
    }

    public static void dk() {
        m().hc();
        if (np() != null) {
            np().clearAllData(f11147m);
        }
    }

    public static void m(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = f11146l;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (ej.class) {
            if (!atomicBoolean.get()) {
                np = context.getApplicationContext();
                if (np() != null) {
                    String initPath = np().initPath(dk);
                    if (!TextUtils.isEmpty(initPath)) {
                        f11147m = initPath;
                    }
                }
                atomicBoolean.set(dk(np));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class dk implements e {
        private dk() {
        }

        @Override // com.ss.android.download.api.config.e
        public void m(String str, String str2, Map<String, Object> map, final f fVar) {
            str.hashCode();
            int i10 = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i10 = 1;
            }
            if (ej.l() != null) {
                ej.l().execute(i10, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.dk.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        f fVar2 = fVar;
                        if (fVar2 != null) {
                            fVar2.m(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        f fVar2 = fVar;
                        if (fVar2 != null) {
                            fVar2.m(str3);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.e
        public void m(String str, byte[] bArr, String str2, int i10, final f fVar) {
            if (ej.l() != null) {
                ej.l().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.dk.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        f fVar2 = fVar;
                        if (fVar2 != null) {
                            fVar2.m(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        f fVar2 = fVar;
                        if (fVar2 != null) {
                            fVar2.m(str3);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class l implements ve {

        /* renamed from: m, reason: collision with root package name */
        private final WeakReference<Context> f11153m;

        public l(Context context) {
            this.f11153m = new WeakReference<>(context);
        }

        private DialogBuilder ej(final com.ss.android.download.api.model.dk dkVar) {
            return DialogBuilder.builder().setTitle(dkVar.dk).setMessage(dkVar.ej).setNegativeBtnText(dkVar.np).setPositiveBtnText(dkVar.f38405l).setIcon(dkVar.f38404hc).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.l.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    dk.InterfaceC0572dk interfaceC0572dk = dkVar.f38403e;
                    if (interfaceC0572dk != null) {
                        interfaceC0572dk.ej(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    dk.InterfaceC0572dk interfaceC0572dk = dkVar.f38403e;
                    if (interfaceC0572dk != null) {
                        try {
                            interfaceC0572dk.dk(dialogInterface);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    dk.InterfaceC0572dk interfaceC0572dk = dkVar.f38403e;
                    if (interfaceC0572dk != null) {
                        interfaceC0572dk.m(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.ve
        public void m(int i10, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i11) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e2) {
                Logger.e("LibUIFactory", "showToastWithDuration e " + e2.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.ve
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public AlertDialog dk(com.ss.android.download.api.model.dk dkVar) {
            if (dkVar != null && ej.l() != null) {
                Context context = dkVar.f38406m;
                if (context != null && (context instanceof Activity)) {
                    return ej.l().showDialogBySelf((Activity) dkVar.f38406m, dkVar.f38408oa == 1, ej(dkVar));
                }
                ej.l().showDialogByDelegate(this.f11153m, dkVar.f38408oa == 1, ej(dkVar));
            }
            return null;
        }
    }

    private static boolean dk(Context context) {
        com.ss.android.download.api.m m10;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (n()) {
            try {
                m10 = com.ss.android.downloadlib.e.m(applicationContext).m("pangolin");
            } catch (Throwable unused) {
                m10 = com.ss.android.downloadlib.e.m(applicationContext).m();
            }
        } else {
            m10 = com.ss.android.downloadlib.e.m(applicationContext).m();
        }
        if (m10 == null) {
            return false;
        }
        m10.m(new C0128ej()).m(new m()).m(new l(applicationContext)).m(new dk()).m(new oa() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.3
            @Override // com.ss.android.download.api.config.oa
            public JSONObject m() {
                if (ej.l() != null) {
                    return ej.l().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).m(new com.ss.android.download.api.config.dk() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.2
            @Override // com.ss.android.download.api.config.dk
            public boolean m() {
                if (ej.l() != null) {
                    return ej.l().getAppIsBackground();
                }
                return false;
            }
        }).m(new m.C0573m().dk("143").m("open_news").ej("5.6.0.3").l(String.valueOf(5603)).m()).m(new t() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.1
            @Override // com.ss.android.download.api.config.t
            public byte[] m(byte[] bArr, int i10) {
                return new byte[0];
            }
        }).m(packageName + ".TTFileProvider").m(m(applicationContext, np() != null ? np().getDownloadSettings() : new JSONObject())).m();
        com.ss.android.downloadlib.hc.m.m();
        com.ss.android.downloadlib.e.m(applicationContext).l().m(1);
        com.ss.android.downloadlib.e.m(applicationContext).m(f11145hc);
        com.ss.android.socialbase.appdownloader.l.oa().m(new IInstallAppHandler() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.4
            @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
            public boolean installApp(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = np() != null ? np().getTTDownloadEventLogger() : null;
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
        }
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> ej() {
        return f11148n;
    }

    public static void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f11147m = str;
    }

    public static com.ss.android.downloadlib.e m() {
        m(getContext());
        return com.ss.android.downloadlib.e.m(getContext());
    }

    public static boolean m(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return m().np().m(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean m(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return m().np().m(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean m(Uri uri) {
        return com.ss.android.downloadlib.dk.oa.m(uri);
    }

    public static void m(int i10) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = f11148n;
        if (map != null) {
            map.remove(Integer.valueOf(i10));
        }
    }

    public static void m(int i10, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (f11148n == null) {
                f11148n = Collections.synchronizedMap(new WeakHashMap());
            }
            f11148n.put(Integer.valueOf(i10), onEventLogHandler);
        }
    }

    public static boolean m(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> ej2;
        boolean z10 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (ej2 = ej()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : ej2.entrySet()) {
                int intValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                    if (!z10 && !onEventLog) {
                        z10 = true;
                    }
                }
            }
        }
        return z10;
    }

    private static DownloaderBuilder m(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new IDownloadSettings() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.5
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
            public JSONObject get() {
                if (ej.l() != null) {
                    return ej.l().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new np());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject dk(com.ss.android.download.api.model.ej ejVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(u.ck, ejVar.m());
            jSONObject.put("tag", ejVar.dk());
            jSONObject.put("label", ejVar.ej());
            jSONObject.put(TTDownloadField.TT_IS_AD, ejVar.l());
            jSONObject.put("adId", ejVar.np());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, ejVar.n());
            jSONObject.put("extValue", ejVar.hc());
            jSONObject.put("extJson", ejVar.e());
            jSONObject.put(TTDownloadField.TT_PARAMS_JSON, ejVar.w());
            jSONObject.put("eventSource", ejVar.c());
            jSONObject.put(TTDownloadField.TT_EXTRA_OBJECT, ejVar.ve());
            jSONObject.put(TTDownloadField.TT_CLICK_TRACK_URL, ejVar.oa());
            jSONObject.put("isV3", ejVar.sy());
            jSONObject.put("V3EventName", ejVar.r());
            jSONObject.put("V3EventParams", ejVar.q());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean m(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> dk2 = com.ss.android.socialbase.appdownloader.l.oa().dk(context);
            if (!dk2.isEmpty()) {
                for (DownloadInfo downloadInfo : dk2) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean m(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.m.m.m().m(activity, false, new m.InterfaceC0575m() { // from class: com.bytedance.sdk.openadsdk.downloadnew.ej.7
            @Override // com.ss.android.downloadlib.addownload.m.m.InterfaceC0575m
            public void m() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
