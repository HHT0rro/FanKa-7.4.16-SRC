package com.bytedance.sdk.openadsdk.api.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import o0.a;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements Bridge {

    /* renamed from: m, reason: collision with root package name */
    private DownloadModel f11080m;

    public ej(DownloadModel downloadModel) {
        this.f11080m = downloadModel;
    }

    public IDownloadFileUriProvider b() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public int bm() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    public boolean bz() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public boolean c() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        switch (i10) {
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_WIFI /* 223417 */:
                f();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_TOAST /* 223419 */:
                mj();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_NOTIFICATION /* 223420 */:
                dh();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) m((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public int d() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public boolean db() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public void dh() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public List<String> dk() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public String e() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    public DeepLink ee() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public String ej() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    public void f() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public String fr() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public String gw() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public long hc() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    public List<String> hr() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public String k() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public String ks() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    public long l() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    public boolean lf() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public boolean li() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    public String m() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    public void mj() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public long n() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public com.ss.android.download.api.model.l ni() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    public String np() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    public Map<String, String> oa() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public boolean q() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public boolean qx() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    public boolean r() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public String s() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public int se() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public boolean sy() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public String t() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public boolean u() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public boolean ub() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public String un() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public int v() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return a.b().i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_URL, m()).h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_BACKUP_URLS, dk()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NOTIFICATION_JUMP_URL, ej()).g(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_ID, l()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MD5, np()).g(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXPECT_FILE_LENGTH, n()).g(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXTRA_VALUE, hc()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NAME, e()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MIME_TYPE, w()).h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_HEADERS, oa()).j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_TOAST, c()).j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_NOTIFICATION, ve()).j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_NEED_WIFI, sy()).j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_IN_EXTERNAL_PUBLIC_DIR, r()).j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_VISIBLE_IN_DOWNLOADS_UI, q()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_PATH, k()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_NAME, t()).h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_SETTINGS, x()).j(ValueSetConstants.VALUE_DOWNLOAD_MODE_NEED_INDEPENDENT_PROCESS, li()).f(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_CODE, v()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_NAME, s()).j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_AD, u()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_LOG_EXTRA, fr()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_PACKAGE_NAME, gw()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_APP_ICON, ks()).h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DEEP_LINK, ee()).h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_CLICK_TRACK_URL, hr()).h(223430, zk()).f(223431, bm()).h(223432, ni()).j(223433, db()).h(223434, b()).j(223435, lf()).f(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXECUTOR_GROUP, se()).f(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FUNNEL_TYPE, d()).i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_START_TOAST, z()).i(223432, un()).j(223433, bz()).j(223434, ub()).j(223435, qx()).a();
    }

    public boolean ve() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public String w() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public JSONObject x() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public String z() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public JSONObject zk() {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public DownloadModel m(String str) {
        DownloadModel downloadModel = this.f11080m;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }
}
