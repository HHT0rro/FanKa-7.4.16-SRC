package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.m.hc;
import com.bytedance.sdk.openadsdk.api.m.n;
import com.bytedance.sdk.openadsdk.api.m.np;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.l;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o0.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class l implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private static volatile l f11156m;
    private final Context dk;

    /* renamed from: e, reason: collision with root package name */
    private AdDownloadEventConfig f11157e;
    private AdDownloadModel.Builder ej;

    /* renamed from: hc, reason: collision with root package name */
    private AdDownloadEventConfig.Builder f11158hc;

    /* renamed from: l, reason: collision with root package name */
    private AdDownloadModel f11159l;

    /* renamed from: n, reason: collision with root package name */
    private AdDownloadController f11160n;
    private AdDownloadController.Builder np;

    private l(Context context) {
        this.dk = context;
    }

    private void dk(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder m10 = m(((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_APP_ICON), ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON), (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS), (String) map.get("filePath"), (String) map.get(TTDownloadField.TT_DOWNLOAD_URL), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue(), (String) map.get(TTDownloadField.TT_OPEN_URL), (String) map.get(TTDownloadField.TT_WEB_TITLE), (String) map.get(TTDownloadField.TT_WEB_URL));
        this.ej = m10;
        this.f11159l = m10.build();
    }

    private OnItemClickListener e(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new hc((EventListener) obj);
        }
        return null;
    }

    private DownloadStatusChangeListener ej(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new np((EventListener) obj);
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private int h() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    private ExitInstallListener hc(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private DownloadModel l(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    public static l m(Context context) {
        if (f11156m == null) {
            synchronized (l.class) {
                if (f11156m == null) {
                    f11156m = new l(context);
                }
            }
        }
        return f11156m;
    }

    private static boolean m(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private DownloadController n(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private DownloadEventConfig np(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private IDownloadButtonClickListener w(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new n((EventListener) obj);
        }
        return null;
    }

    public boolean aa() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    public int am() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    public long b() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    public long bm() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    public String by() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getLogExtra();
    }

    public Map<String, String> bz() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    public boolean c() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        Map<String, Object> hashMap;
        if (i10 == 20) {
            m((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (valueSet != null && valueSet.objectValue(0, Map.class) != null) {
            hashMap = (Map) valueSet.objectValue(0, Map.class);
        } else {
            hashMap = new HashMap<>();
        }
        return (T) m(cls, i10, hashMap);
    }

    public String ch() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getPackageName();
    }

    public JSONObject cm() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    public String d() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getNotificationJumpUrl();
    }

    public long db() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    public String dh() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickStartLabel();
    }

    public JSONObject dp() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    public boolean ee() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    public int es() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    public String f() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickButtonTag();
    }

    public boolean fb() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    public boolean fh() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public Object fr() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    public com.ss.android.download.api.model.l fz() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    public DeepLink g() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    public boolean gg() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    public int gw() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    public String gx() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getAppIcon();
    }

    public JSONObject hr() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    public void i() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    public String iy() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getFileName();
    }

    public String iz() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getFilePath();
    }

    public int jf() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    public boolean jl() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    public int jt() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    public boolean k() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    public boolean ks() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }

    public String lf() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getDownloadUrl();
    }

    public String li() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public String mj() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickLabel();
    }

    public String ni() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getMd5();
    }

    public boolean o() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public Object oa() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    public void p() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    public boolean q() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    public boolean qx() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    public boolean r() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    public String s() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickInstallLabel();
    }

    public boolean sa() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    public List<String> se() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    public List<String> su() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    public String sw() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public boolean sy() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    public String t() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getRefer();
    }

    public boolean tq() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    public String u() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getStorageDenyLabel();
    }

    public boolean ub() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    public boolean um() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    public String un() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getMimeType();
    }

    public String v() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.b().i(0, ej.f11147m).h(1, Boolean.valueOf(ej.dk)).f(10000, 3).a();
    }

    public boolean ve() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    public String x() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickItemTag();
    }

    public String xg() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public boolean y() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return com.ss.android.download.api.ej.dk.m(DownloadSetting.obtain(cm()), un());
        }
        return adDownloadModel.shouldDownloadWithPatchApply();
    }

    public String yy() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getVersionName();
    }

    public String z() {
        AdDownloadModel adDownloadModel = this.f11159l;
        return adDownloadModel == null ? "" : adDownloadModel.getName();
    }

    public void za() {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    public JSONObject zk() {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    private void l(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str4 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.f11158hc = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.f11157e = this.f11158hc.build();
    }

    private void n(int i10) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i10);
    }

    private void np(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_CLICK_LABEL);
        int intValue = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue();
        String str4 = (String) map.get(TTDownloadField.TT_REFER);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str8 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str9 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.f11158hc = paramsJson;
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.f11157e = this.f11158hc.build();
    }

    private void oa(boolean z10) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z10);
        } catch (Throwable unused) {
        }
    }

    public AdDownloadModel c(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    public boolean hc() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    public AdDownloadModel k(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    public AdDownloadModel q(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    public AdDownloadModel r(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    public AdDownloadModel sy(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    public AdDownloadModel t(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    public AdDownloadModel ve(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    private void ej(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue();
        int intValue2 = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_BACK_DIALOG)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ADD_TO_DOWNLOAD_MANAGE)).booleanValue();
        Object obj = map.get(TTDownloadField.TT_EXTRA_OPERATION);
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_SHOULD_USE_NEW_WEB_VIEW)).booleanValue();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_INTERCEPT_FLAG)).intValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        Object obj2 = map.get(TTDownloadField.TT_EXTRA_OBJECT);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue();
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(intValue).setDownloadMode(intValue2).setIsEnableBackDialog(booleanValue).setIsAddToDownloadManage(booleanValue2).setExtraOperation(obj).setShouldUseNewWebView(booleanValue3).setInterceptFlag(intValue3).setExtraJson(jSONObject).setExtraObject(obj2).setEnableShowComplianceDialog(booleanValue4).setIsAutoDownloadOnCardShow(booleanValue5).setEnableNewActivity(booleanValue6).setEnableAH(booleanValue7).setEnableAM(booleanValue8).setEnableOppoAutoDownload(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
        this.np = enableOppoAutoDownload;
        this.f11160n = enableOppoAutoDownload.build();
    }

    public int e() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    public void hc(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    public int n() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    public AdDownloadModel oa(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    public JSONObject w() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    private void n(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue();
        String str = (String) map.get("md5");
        long longValue2 = ((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue();
        int intValue = ((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue();
        List<String> list = (List) map.get(TTDownloadField.TT_CLICK_TRACK_URL);
        List<String> list2 = (List) map.get(TTDownloadField.TT_BACK_UP_URLS);
        String str2 = (String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL);
        String str3 = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get(TTDownloadField.TT_HEADERS);
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue();
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue();
        String str4 = (String) map.get("fileName");
        int intValue2 = ((Integer) map.get("versionCode")).intValue();
        String str5 = (String) map.get(TTDownloadField.TT_VERSION_NAME);
        String str6 = (String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL);
        com.ss.android.download.api.model.l m10 = new l.m().m(str6).dk((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).m();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_EXECUTOR_GROUP)).intValue();
        String str7 = (String) map.get(TTDownloadField.TT_START_TOAST);
        String str8 = (String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_AUTO_INSTALL)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_DISTINCT_DIR)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_PAUSE)).booleanValue();
        long longValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get(TTDownloadField.TT_APP_ICON);
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue();
        String str10 = (String) map.get(TTDownloadField.TT_LOG_EXTRA);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS);
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get(TTDownloadField.TT_DOWNLOAD_URL);
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get("packageName");
        boolean booleanValue9 = ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue();
        String str15 = (String) map.get(TTDownloadField.TT_OPEN_URL);
        String str16 = (String) map.get(TTDownloadField.TT_WEB_TITLE);
        String str17 = (String) map.get(TTDownloadField.TT_WEB_URL);
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5(str).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str4).setVersionCode(intValue2).setVersionName(str5).setQuickAppModel(m10).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.l.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(booleanValue9);
        fileUriProvider.setDeepLink(m(longValue3, str15, str16, str17));
        this.f11159l = this.ej.build();
    }

    public void e(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    public AdDownloadModel hc(boolean z10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z10);
    }

    public <T> T m(Class<T> cls, int i10, Map<String, Object> map) {
        DownloadModel l10;
        DownloadModel l11;
        DownloadEventConfig np;
        DownloadController n10;
        DownloadModel l12;
        DownloadEventConfig np2;
        DownloadController n11;
        DownloadEventConfig np3;
        DownloadController n12;
        DownloadEventConfig np4;
        DownloadController n13;
        switch (i10) {
            case 0:
                return (T) Boolean.valueOf(ej.m(getActivity(map.get("activity")), hc(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) ej.m().n();
            case 2:
                try {
                    return (T) Boolean.valueOf(ej.m((String) map.get(TTDownloadField.TT_TAG_INTERCEPT), (String) map.get("label"), new JSONObject((String) map.get(TTDownloadField.TT_META)), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                ej.m(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                return null;
            case 4:
                AdDownloadModel adDownloadModel = this.f11159l;
                ej.m().m(adDownloadModel == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel.getDownloadUrl(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                return null;
            case 5:
                int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                AdDownloadModel adDownloadModel2 = this.f11159l;
                if (adDownloadModel2 == null) {
                    l10 = l(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    l10 = l(adDownloadModel2);
                }
                ej.m().m(this.dk, intValue, ej(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), l10);
                return null;
            case 6:
                AdDownloadModel adDownloadModel3 = this.f11159l;
                return (T) Boolean.valueOf(ej.m(this.dk, adDownloadModel3 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel3.getDownloadUrl()));
            case 7:
                ej.dk();
                return null;
            case 8:
                AdDownloadModel adDownloadModel4 = this.f11159l;
                ej.m().m(adDownloadModel4 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel4.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                ej.m(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                return null;
            case 10:
                ej.m((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case 126:
            case 138:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get("uri");
                AdDownloadModel adDownloadModel5 = this.f11159l;
                if (adDownloadModel5 == null) {
                    l11 = l(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    l11 = l(adDownloadModel5);
                }
                AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
                if (adDownloadEventConfig == null) {
                    np = np(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    np = np(adDownloadEventConfig);
                }
                AdDownloadController adDownloadController = this.f11160n;
                if (adDownloadController == null) {
                    n10 = n(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    n10 = n(adDownloadController);
                }
                IDownloadButtonClickListener w3 = w(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (m(w3)) {
                    return (T) Boolean.valueOf(ej.m(this.dk, uri, l11, np, n10, w3));
                }
                return (T) Boolean.valueOf(ej.m(this.dk, uri, l11, np, n10));
            case 13:
                int intValue2 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                AdDownloadModel adDownloadModel6 = this.f11159l;
                if (adDownloadModel6 == null) {
                    l12 = l(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    l12 = l(adDownloadModel6);
                }
                DownloadModel downloadModel = l12;
                AdDownloadEventConfig adDownloadEventConfig2 = this.f11157e;
                if (adDownloadEventConfig2 == null) {
                    np2 = np(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    np2 = np(adDownloadEventConfig2);
                }
                DownloadEventConfig downloadEventConfig = np2;
                AdDownloadController adDownloadController2 = this.f11160n;
                if (adDownloadController2 == null) {
                    n11 = n(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    n11 = n(adDownloadController2);
                }
                DownloadController downloadController = n11;
                DownloadStatusChangeListener ej = ej(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener w10 = w(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (m(w10)) {
                    ej.m().np().m(this.dk, str, booleanValue, downloadModel, downloadEventConfig, downloadController, ej, intValue2, w10);
                    return null;
                }
                ej.m().np().m(this.dk, str, booleanValue, downloadModel, downloadEventConfig, downloadController, ej, intValue2);
                return null;
            case 14:
                AdDownloadModel adDownloadModel7 = this.f11159l;
                long longValue = adDownloadModel7 == null ? ((Long) map.get("id")).longValue() : adDownloadModel7.getId();
                AdDownloadModel adDownloadModel8 = this.f11159l;
                return (T) Boolean.valueOf(ej.m().np().m(this.dk, longValue, adDownloadModel8 == null ? (String) map.get(TTDownloadField.TT_LOG_EXTRA) : adDownloadModel8.getLogExtra(), (DownloadStatusChangeListener) null, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 15:
                return (T) Boolean.valueOf(ej.m((Uri) map.get("uri")));
            case 16:
                AdDownloadModel adDownloadModel9 = this.f11159l;
                String downloadUrl = adDownloadModel9 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel9.getDownloadUrl();
                AdDownloadModel adDownloadModel10 = this.f11159l;
                long longValue2 = adDownloadModel10 == null ? ((Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int intValue3 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig3 = this.f11157e;
                if (adDownloadEventConfig3 == null) {
                    np3 = np(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    np3 = np(adDownloadEventConfig3);
                }
                DownloadEventConfig downloadEventConfig2 = np3;
                AdDownloadController adDownloadController3 = this.f11160n;
                if (adDownloadController3 == null) {
                    n12 = n(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    n12 = n(adDownloadController3);
                }
                ej.m().m(downloadUrl, longValue2, intValue3, downloadEventConfig2, n12);
                return null;
            case 17:
                AdDownloadModel adDownloadModel11 = this.f11159l;
                String downloadUrl2 = adDownloadModel11 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel11.getDownloadUrl();
                long longValue3 = ((Long) map.get("id")).longValue();
                int intValue4 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig4 = this.f11157e;
                if (adDownloadEventConfig4 == null) {
                    np4 = np(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    np4 = np(adDownloadEventConfig4);
                }
                DownloadEventConfig downloadEventConfig3 = np4;
                AdDownloadController adDownloadController4 = this.f11160n;
                if (adDownloadController4 == null) {
                    n13 = n(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    n13 = n(adDownloadController4);
                }
                ej.m().m(downloadUrl2, longValue3, intValue4, downloadEventConfig3, n13, e(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), w(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                return null;
            case 18:
                AdDownloadModel adDownloadModel12 = this.f11159l;
                return (T) Boolean.valueOf(ej.m().np().m(adDownloadModel12 == null ? ((Long) map.get("id")).longValue() : adDownloadModel12.getId(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 19:
                AdDownloadModel adDownloadModel13 = this.f11159l;
                return (T) Boolean.valueOf(ej.m().np().m(adDownloadModel13 == null ? ((Long) map.get("id")).longValue() : adDownloadModel13.getId()));
            case 23:
                if (((Boolean) map.get(TTDownloadField.TT_MATE_IS_EMPTY)).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.ej = builder;
                    this.f11159l = builder.build();
                    return null;
                }
                dk(map);
                return null;
            case 24:
                m((String) map.get(TTDownloadField.TT_APP_ICON), (String) map.get("appName"), (String) map.get("packageName"));
                return null;
            case 25:
                m(((Integer) map.get(TTDownloadField.TT_AUTO_OPEN)).intValue(), ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue(), ((Boolean) map.get(TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue());
                return null;
            case 26:
                n(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(h());
            case 28:
                oa(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
                return null;
            case 29:
                l(map);
                return null;
            case 30:
                dk(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue());
                return null;
            case 31:
                np(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue());
                return null;
            case 32:
                ej(map);
                return null;
            case 33:
                return (T) Integer.valueOf(m());
            case 34:
                return (T) Boolean.valueOf(dk());
            case 35:
                return (T) Boolean.valueOf(ej());
            case 36:
                return (T) l();
            case 37:
                return (T) Boolean.valueOf(np());
            case 38:
                return (T) Integer.valueOf(n());
            case 39:
                return (T) Boolean.valueOf(hc());
            case 40:
                return (T) Integer.valueOf(e());
            case 41:
                return (T) w();
            case 42:
                return (T) oa();
            case 44:
                m(((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(c());
            case 46:
                m(((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(ve());
            case 48:
                return (T) Boolean.valueOf(sy());
            case 49:
                dk(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue());
                return null;
            case 50:
                ej(((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(r());
            case 52:
                return (T) Boolean.valueOf(q());
            case 53:
                m(map.get(TTDownloadField.TT_EXTRA_OBJECT));
                return null;
            case 54:
                m((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case 55:
                return (T) Boolean.valueOf(k());
            case 56:
                np(map);
                return null;
            case 57:
                return (T) String.valueOf(t());
            case 58:
                return (T) String.valueOf(f());
            case 59:
                return (T) String.valueOf(x());
            case 60:
                return (T) String.valueOf(mj());
            case 61:
                return (T) String.valueOf(dh());
            case 62:
                return (T) String.valueOf(li());
            case 63:
                return (T) String.valueOf(v());
            case 64:
                return (T) String.valueOf(s());
            case 65:
                return (T) String.valueOf(u());
            case 66:
                return (T) fr();
            case 67:
                return (T) Integer.valueOf(gw());
            case 68:
                return (T) Boolean.valueOf(ks());
            case 69:
                return (T) Boolean.valueOf(ee());
            case 70:
                return (T) hr();
            case 71:
                return (T) zk();
            case 72:
                dk(map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT));
                return null;
            case 73:
                m((String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG));
                return null;
            case 74:
                dk((JSONObject) map.get(TTDownloadField.TT_EVENT_CONFIG_EXTRA_JSON));
                return null;
            case 75:
                ej((JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON));
                return null;
            case 76:
                dk((String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG));
                return null;
            case 78:
                ej((String) map.get(TTDownloadField.TT_REFER));
                return null;
            case 79:
                l((String) map.get(TTDownloadField.TT_QUICK_APP_EVENT_TAG));
                return null;
            case 80:
                n(map);
                return null;
            case 81:
                return (T) Long.valueOf(bm());
            case 82:
                return (T) String.valueOf(ni());
            case 83:
                return (T) Long.valueOf(db());
            case 84:
                return (T) Long.valueOf(b());
            case 85:
                return (T) String.valueOf(lf());
            case 86:
                return (T) se();
            case 87:
                return (T) String.valueOf(d());
            case 88:
                return (T) String.valueOf(z());
            case 89:
                return (T) String.valueOf(un());
            case 90:
                return (T) bz();
            case 91:
                return (T) Boolean.valueOf(ub());
            case 92:
                return (T) Boolean.valueOf(qx());
            case 93:
                return (T) Boolean.valueOf(fb());
            case 94:
                return (T) Boolean.valueOf(o());
            case 95:
                return (T) Boolean.valueOf(fh());
            case 96:
                return (T) String.valueOf(iz());
            case 97:
                return (T) String.valueOf(iy());
            case 98:
                i();
                return null;
            case 99:
                return (T) cm();
            case 100:
                za();
                return null;
            case 101:
                p();
                return null;
            case 102:
                return (T) Boolean.valueOf(sa());
            case 103:
                return (T) Integer.valueOf(am());
            case 104:
                return (T) String.valueOf(yy());
            case 105:
                return (T) Boolean.valueOf(gg());
            case 106:
                return (T) String.valueOf(by());
            case 107:
                return (T) String.valueOf(ch());
            case 108:
                return (T) String.valueOf(gx());
            case 109:
                return (T) g();
            case 110:
                return (T) su();
            case 111:
                return (T) dp();
            case 112:
                return (T) Integer.valueOf(jt());
            case 113:
                return (T) fz();
            case 114:
                return (T) Boolean.valueOf(tq());
            case 115:
                return (T) Boolean.valueOf(y());
            case 116:
                return (T) Integer.valueOf(jf());
            case 117:
                return (T) Integer.valueOf(es());
            case 118:
                return (T) String.valueOf(sw());
            case 119:
                return (T) String.valueOf(xg());
            case 120:
                return (T) Boolean.valueOf(jl());
            case 121:
                return (T) Boolean.valueOf(um());
            case 122:
                return (T) Boolean.valueOf(aa());
            case 123:
                np((String) map.get("md5"));
                return null;
            case 124:
                m(((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue());
                return null;
            case 125:
                l(((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue());
                return null;
            case 127:
                dk(((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue());
                return null;
            case 128:
                n((String) map.get("appName"));
                return null;
            case 129:
                l((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case 130:
                hc((String) map.get(TTDownloadField.TT_START_TOAST));
                return null;
            case 131:
                e((String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE));
                return null;
            case 132:
                ej(((Long) map.get("id")).longValue());
                return null;
            case 133:
                n(((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue());
                return null;
            case 134:
                ej(((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue());
                return null;
            case 135:
                w((String) map.get(TTDownloadField.TT_LOG_EXTRA));
                return null;
            case 136:
                oa((String) map.get("packageName"));
                return null;
            case 137:
                c((String) map.get(TTDownloadField.TT_APP_ICON));
                return null;
            case 139:
                m((List<String>) map.get(TTDownloadField.TT_CLICK_TRACK_URL));
                return null;
            case 140:
                ve((String) map.get(TTDownloadField.TT_DOWNLOAD_URL));
                return null;
            case 141:
                dk((List<String>) map.get(TTDownloadField.TT_BACK_UP_URLS));
                return null;
            case 142:
                sy((String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL));
                return null;
            case 143:
                r((String) map.get("mimeType"));
                return null;
            case 144:
                m((Map<String, String>) map.get(TTDownloadField.TT_HEADERS));
                return null;
            case 145:
                hc(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue());
                return null;
            case 146:
                q((String) map.get("filePath"));
                return null;
            case 147:
                k((String) map.get("fileName"));
                return null;
            case 148:
                e(((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue());
                return null;
            case 149:
                l(((Integer) map.get("versionCode")).intValue());
                return null;
            case 150:
                t((String) map.get(TTDownloadField.TT_VERSION_NAME));
                return null;
            case 151:
                m(new l.m().m((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).dk((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).m());
                return null;
            case 152:
                w(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue());
                return null;
            case 153:
                np(((Integer) map.get(TTDownloadField.TT_FUNNEL_TYPE)).intValue());
                return null;
        }
    }

    public AdDownloadModel w(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    public AdDownloadModel e(boolean z10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z10);
    }

    public AdDownloadModel w(boolean z10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z10);
    }

    public boolean dk() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    public void dk(boolean z10) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z10);
    }

    public void dk(Object obj) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    public void dk(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    public Object l() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    public void dk(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    public void l(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    public void dk(int i10) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i10);
    }

    public void l(boolean z10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z10);
    }

    public void dk(long j10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j10);
    }

    public void l(JSONObject jSONObject) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    public AdDownloadModel dk(List<String> list) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    public AdDownloadModel l(int i10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i10);
    }

    public boolean np() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    public boolean ej() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    public void np(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    public void ej(boolean z10) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z10);
    }

    public void np(boolean z10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z10);
    }

    public void ej(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    public AdDownloadModel np(int i10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i10);
    }

    public void ej(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    public AdDownloadModel ej(long j10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j10);
    }

    public AdDownloadModel ej(int i10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i10);
    }

    public void n(String str) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    public AdDownloadModel n(boolean z10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z10);
    }

    public void m(Bundle bundle) {
        ej.m(this.dk);
    }

    private AdDownloadModel.Builder m(long j10, String str, boolean z10, boolean z11, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z12, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j10).setAppIcon(str).setIsShowNotification(z10).setAutoInstallWithoutNotification(z11).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.l.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z12);
        fileUriProvider.setDeepLink(m(j10, str7, str8, str9));
        return fileUriProvider;
    }

    private DeepLink m(long j10, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j10);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void m(String str, String str2, String str3) {
        AdDownloadModel.Builder builder = this.ej;
        if (builder == null) {
            return;
        }
        this.f11159l = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    private void m(int i10, int i11, boolean z10, boolean z11, boolean z12) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i10).setDownloadMode(i11).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.np = isAddToDownloadManage;
        if (z10) {
            isAddToDownloadManage.setEnableAH(z11);
            this.np.setEnableAM(z12);
        }
        this.f11160n = this.np.build();
    }

    public int m() {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    public void m(int i10) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i10);
    }

    public void m(boolean z10) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z10);
    }

    public void m(Object obj) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    public void m(JSONObject jSONObject) {
        AdDownloadController adDownloadController = this.f11160n;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    public void m(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f11157e;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    public void m(long j10) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j10);
    }

    public AdDownloadModel m(List<String> list) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    public AdDownloadModel m(Map<String, String> map) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    public AdDownloadModel m(com.ss.android.download.api.model.l lVar) {
        AdDownloadModel adDownloadModel = this.f11159l;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(lVar);
    }
}
