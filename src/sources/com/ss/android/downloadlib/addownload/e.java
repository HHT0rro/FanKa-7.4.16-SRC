package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.config.mj;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.hc.oa;
import com.ss.android.downloadlib.hc.sy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e implements sy.m {
    private long dk;
    private boolean ej = false;

    /* renamed from: l, reason: collision with root package name */
    private np f38590l;

    /* renamed from: m, reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.dk.np f38591m;
    private dk np;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface dk {
        void m(DownloadInfo downloadInfo);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class m extends AbsDownloadExtListener {

        /* renamed from: m, reason: collision with root package name */
        private com.ss.android.downloadlib.hc.sy f38595m;

        public m(com.ss.android.downloadlib.hc.sy syVar) {
            this.f38595m = syVar;
        }

        private void m(DownloadInfo downloadInfo, int i10) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i10;
            this.f38595m.sendMessage(obtain);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            m(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            m(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            m(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            m(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            m(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            m(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            m(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener, com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
            m(downloadInfo, 11);
        }
    }

    public e(np npVar) {
        this.f38590l = npVar;
    }

    private boolean ej() {
        return l() && np();
    }

    private boolean l() {
        DownloadModel downloadModel = this.f38591m.dk;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f38591m.dk.getDownloadUrl())) ? false : true;
    }

    private boolean n() {
        return com.ss.android.downloadlib.hc.ve.m(this.f38591m.dk) && w.m(this.f38591m.f38585l.getLinkMode());
    }

    private boolean np() {
        return this.f38591m.f38585l.isAddToDownloadManage();
    }

    public void dk(@Nullable DownloadInfo downloadInfo) {
        dk dkVar = this.np;
        if (dkVar != null) {
            dkVar.m(downloadInfo);
            this.np = null;
        }
    }

    @Override // com.ss.android.downloadlib.hc.sy.m
    public void m(Message message) {
    }

    private boolean n(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && DownloadUtils.isFileExist(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean np(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.hc.ve.m(this.f38591m.dk) && n(downloadInfo);
    }

    public void ej(DownloadInfo downloadInfo) {
        if (!w.m(this.f38591m.dk) || this.ej) {
            return;
        }
        com.ss.android.downloadlib.l.m.m().m("file_status", (downloadInfo == null || !com.ss.android.downloadlib.hc.ve.dk(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f38591m);
        this.ej = true;
    }

    public void m(long j10) {
        this.dk = j10;
        com.ss.android.downloadlib.addownload.dk.np np = com.ss.android.downloadlib.addownload.dk.n.m().np(j10);
        this.f38591m = np;
        if (np.s()) {
            com.ss.android.downloadlib.np.ej.m().m("setAdId ModelBox notValid");
        }
    }

    private void dk(final mj mjVar) {
        if (com.ss.android.downloadlib.hc.oa.dk(g.f36124j)) {
            if (mjVar != null) {
                mjVar.m();
                return;
            }
            return;
        }
        String str = "android.permission.READ_MEDIA_IMAGES";
        if (!com.ss.android.downloadlib.hc.ve.m()) {
            str = g.f36123i;
        } else if (com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_VIDEO")) {
            if (mjVar != null) {
                mjVar.m();
                return;
            }
            return;
        }
        com.ss.android.downloadlib.hc.oa.m(new String[]{str}, new oa.m() { // from class: com.ss.android.downloadlib.addownload.e.2
            @Override // com.ss.android.downloadlib.hc.oa.m
            public void m() {
                mj mjVar2 = mjVar;
                if (mjVar2 != null) {
                    mjVar2.m();
                }
            }

            @Override // com.ss.android.downloadlib.hc.oa.m
            public void m(String str2) {
                mj mjVar2 = mjVar;
                if (mjVar2 != null) {
                    mjVar2.m(str2);
                }
            }
        });
    }

    public boolean l(DownloadInfo downloadInfo) {
        return n() || np(downloadInfo);
    }

    public void m(DownloadInfo downloadInfo) {
        this.ej = false;
        dk(downloadInfo);
    }

    public boolean m(Context context, int i10, boolean z10) {
        if (com.ss.android.downloadlib.hc.ve.m(this.f38591m.dk)) {
            com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(this.f38591m.f38586m);
            if (l10 != null) {
                DownloadNotificationManager.getInstance().cancelNotification(l10.x());
            }
            return com.ss.android.downloadlib.dk.m.m(this.f38591m);
        }
        if (m(i10) && !TextUtils.isEmpty(this.f38591m.dk.getPackageName()) && c.w().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.dk.m.m(this.f38591m, i10)) {
                return true;
            }
            return this.f38590l.w() && this.f38590l.l(true);
        }
        if (!z10 || this.f38591m.f38585l.getDownloadMode() != 4 || this.f38590l.np()) {
            return false;
        }
        this.f38590l.ej(true);
        return true;
    }

    @Nullable
    public String dk() {
        File externalFilesDir = c.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.m> dk(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.m) {
                    arrayList.add((com.ss.android.download.api.download.m) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.m) {
                            arrayList.add((com.ss.android.download.api.download.m) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.m) {
                            arrayList.add((com.ss.android.download.api.download.m) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean m(int i10) {
        if (this.f38591m.f38585l.getDownloadMode() == 2 && i10 == 2) {
            return true;
        }
        return this.f38591m.f38585l.getDownloadMode() == 2 && i10 == 1 && c.w().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean m(int i10, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.n.np.ej() && m(i10) && !com.ss.android.downloadlib.hc.ve.m(downloadModel);
    }

    public boolean m(boolean z10) {
        return !z10 && this.f38591m.f38585l.getDownloadMode() == 1;
    }

    public void m(@NonNull final mj mjVar) {
        if (!TextUtils.isEmpty(this.f38591m.dk.getFilePath())) {
            String filePath = this.f38591m.dk.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                mjVar.m();
                return;
            } else {
                try {
                    if (filePath.startsWith(c.getContext().getExternalCacheDir().getParent())) {
                        mjVar.m();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        dk(new mj() { // from class: com.ss.android.downloadlib.addownload.e.1
            @Override // com.ss.android.download.api.config.mj
            public void m() {
                mjVar.m();
            }

            @Override // com.ss.android.download.api.config.mj
            public void m(String str) {
                c.ej().m(1, c.getContext(), e.this.f38591m.dk, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.l.m.m().dk(e.this.dk, 1);
                mjVar.m(str);
            }
        });
    }

    public void m(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        dk dkVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i10 = message.arg1;
        if (i10 != 1 && i10 != 6 && i10 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.hc m10 = com.ss.android.downloadlib.hc.m();
                com.ss.android.downloadlib.addownload.dk.np npVar = this.f38591m;
                m10.m(npVar.dk, npVar.f38585l, npVar.ej);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.l.m.m().m(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        oa.m(downloadShortInfo);
        int m11 = com.ss.android.socialbase.appdownloader.ej.m(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) && (dkVar = this.np) != null) {
            dkVar.m(downloadInfo);
            this.np = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : m(map)) {
            if (m11 != 1) {
                if (m11 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, oa.m(downloadInfo.getId(), curBytes));
                } else if (m11 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.hc.ve.m(this.f38591m.dk)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, oa.m(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.m> iterator2 = dk(map).iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().m(downloadInfo);
                }
            }
        }
    }

    public void m() {
        if (this.np == null) {
            this.np = new dk() { // from class: com.ss.android.downloadlib.addownload.e.3
                @Override // com.ss.android.downloadlib.addownload.e.dk
                public void m(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.l.m.m().m(e.this.dk, 2, downloadInfo);
                }
            };
        }
    }

    public int m(Context context, IDownloadListener iDownloadListener) {
        HttpHeader m10;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f38591m.dk.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (c.w().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.f38591m.dk.getLogExtra()) && (m10 = m(this.f38591m.dk.getLogExtra())) != null) {
            arrayList.add(m10);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new HttpHeader(entry.getKey(), entry.getValue()));
                }
            }
        }
        String m11 = com.ss.android.downloadlib.hc.l.m(String.valueOf(this.f38591m.dk.getId()), this.f38591m.dk.getNotificationJumpUrl(), this.f38591m.dk.isShowToast(), String.valueOf(this.f38591m.dk.getModelType()));
        DownloadSetting dk2 = com.ss.android.downloadlib.hc.np.dk(this.f38591m.dk);
        JSONObject m12 = com.ss.android.downloadlib.hc.np.m(this.f38591m.dk);
        if (!this.f38591m.f38585l.enableAH()) {
            m12 = com.ss.android.downloadlib.hc.ve.m(m12);
            com.ss.android.downloadlib.hc.ve.m(m12, DownloadSettingKeys.KEY_AH_PLANS, new JSONArray());
        }
        int executorGroup = this.f38591m.dk.getExecutorGroup();
        if (this.f38591m.dk.isAd() || w.dk(this.f38591m.dk)) {
            executorGroup = 4;
        }
        String m13 = m(dk2);
        DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(DownloadComponentManager.getDownloadId(this.f38591m.dk.getDownloadUrl(), m13));
        if (downloadInfo != null && 3 == this.f38591m.dk.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.n q10 = new com.ss.android.socialbase.appdownloader.n(context, this.f38591m.dk.getDownloadUrl()).dk(this.f38591m.dk.getBackupUrls()).m(this.f38591m.dk.getName()).np(m11).m(arrayList).m(this.f38591m.dk.isShowNotification()).ej(this.f38591m.dk.isNeedWifi()).dk(this.f38591m.dk.getFileName()).ej(m13).c(this.f38591m.dk.getAppIcon()).e(this.f38591m.dk.getMd5()).oa(this.f38591m.dk.getSdkMonitorScene()).m(this.f38591m.dk.getExpectFileLength()).m(iDownloadListener).ve(this.f38591m.dk.needIndependentProcess() || dk2.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, 0) == 1).m(this.f38591m.dk.getDownloadFileUriProvider()).dk(this.f38591m.dk.autoInstallWithoutNotification()).hc(this.f38591m.dk.getPackageName()).l(1000).np(100).m(m12).w(true).oa(true).dk(dk2.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, 5)).ej(dk2.optInt("backup_url_retry_count", 0)).oa(true).sy(dk2.optInt("need_head_connection", 0) == 1).l(dk2.optInt("need_https_to_http_retry", 0) == 1).e(dk2.optInt(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, 1) == 1).hc(dk2.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, 0) == 1).w(dk2.optString("retry_delay_time_array")).c(dk2.optInt("need_reuse_runnable", 0) == 1).n(executorGroup).k(this.f38591m.dk.isAutoInstall()).q(this.f38591m.dk.distinctDir());
        if (!TextUtils.isEmpty(this.f38591m.dk.getMimeType())) {
            q10.n(this.f38591m.dk.getMimeType());
        } else {
            q10.n("application/vnd.android.package-archive");
        }
        if (dk2.optInt("notification_opt_2", 0) == 1) {
            q10.m(false);
            q10.dk(true);
        }
        com.ss.android.downloadlib.addownload.ej.m mVar = null;
        if (dk2.optInt("clear_space_use_disk_handler", 0) == 1) {
            mVar = new com.ss.android.downloadlib.addownload.ej.m();
            q10.m(mVar);
        }
        DownloadModel downloadModel = this.f38591m.dk;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            q10.l(((AdDownloadModel) this.f38591m.dk).getTaskKey());
        }
        int m14 = w.m(this.f38591m, ej(), q10);
        if (mVar != null) {
            mVar.m(m14);
        }
        return m14;
    }

    private String m(DownloadSetting downloadSetting) {
        boolean z10;
        if (!TextUtils.isEmpty(this.f38591m.dk.getFilePath())) {
            return this.f38591m.dk.getFilePath();
        }
        DownloadInfo m10 = com.ss.android.socialbase.appdownloader.l.oa().m(c.getContext(), this.f38591m.dk.getDownloadUrl());
        if (!com.ss.android.downloadlib.hc.ve.m()) {
            z10 = com.ss.android.downloadlib.hc.oa.dk(g.f36124j);
        } else {
            z10 = com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.hc.oa.dk("android.permission.READ_MEDIA_VIDEO");
        }
        String dk2 = dk();
        if (m10 != null && !TextUtils.isEmpty(m10.getSavePath())) {
            String savePath = m10.getSavePath();
            if (z10 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(dk2)) {
                    if (savePath.startsWith(dk2)) {
                        return savePath;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(m10.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(z10 ? 1 : 2));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().m("label_external_permission", jSONObject, this.f38591m);
        String str = null;
        try {
            str = com.ss.android.socialbase.appdownloader.ej.dk();
        } catch (Exception unused) {
        }
        int m11 = com.ss.android.downloadlib.hc.np.m(downloadSetting);
        if (m11 != 0) {
            if (m11 != 4 && (z10 || m11 != 2)) {
                if ((m11 == 3 || (!z10 && m11 == 1)) && !TextUtils.isEmpty(dk2)) {
                    return dk2;
                }
            } else {
                File filesDir = c.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return str;
    }

    public void m(DownloadInfo downloadInfo, boolean z10) {
        if (this.f38591m.dk == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (w.m(this.f38591m.dk)) {
                com.ss.android.downloadlib.l.m.m().m(this.dk, 2);
            } else if (z10 && com.ss.android.downloadlib.l.ej.m().ej() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.l.m.m().m(this.dk, 2);
            }
        } else {
            com.ss.android.downloadlib.l.m.m().m(this.dk, 2);
        }
        switch (status) {
            case -4:
            case -1:
                m();
                com.ss.android.downloadlib.addownload.dk.n m10 = com.ss.android.downloadlib.addownload.dk.n.m();
                com.ss.android.downloadlib.addownload.dk.np npVar = this.f38591m;
                m10.m(new com.ss.android.downloadad.api.m.dk(npVar.dk, npVar.ej, npVar.f38585l, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.hc.ve.m(this.f38591m.dk)) {
                    com.ss.android.downloadlib.np.ej.m().dk("SUCCESSED isInstalledApp");
                    return;
                }
                com.ss.android.downloadlib.l.m.m().m(this.dk, 5, downloadInfo);
                if (z10 && com.ss.android.downloadlib.l.ej.m().dk() && !com.ss.android.downloadlib.l.ej.m().dk(this.dk, this.f38591m.dk.getLogExtra())) {
                    com.ss.android.downloadlib.l.m.m().m(this.dk, 2);
                    return;
                }
                return;
            case -2:
                com.ss.android.downloadlib.l.m.m().m(this.dk, 4, downloadInfo);
                if (z10 && com.ss.android.downloadlib.l.ej.m().dk() && !com.ss.android.downloadlib.l.ej.m().dk(this.dk, this.f38591m.dk.getLogExtra())) {
                    com.ss.android.downloadlib.l.m.m().m(this.dk, 2);
                    return;
                }
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.l.m.m().m(this.dk, 3, downloadInfo);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(com.ss.android.socialbase.downloader.model.DownloadInfo r7, com.ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r9) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L7
            return
        L7:
            if (r7 == 0) goto La8
            if (r8 != 0) goto Ld
            goto La8
        Ld:
            r0 = 0
            long r1 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L2b
            long r1 = r7.getCurBytes()     // Catch: java.lang.Exception -> L27
            r3 = 100
            long r1 = r1 * r3
            long r3 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            long r1 = r1 / r3
            int r2 = (int) r1
            goto L2c
        L27:
            r1 = move-exception
            r1.printStackTrace()
        L2b:
            r2 = 0
        L2c:
            if (r2 >= 0) goto L2f
            goto L30
        L2f:
            r0 = r2
        L30:
            r8.updateFromNewDownloadInfo(r7)
            com.ss.android.downloadlib.addownload.oa.m(r8)
            java.util.Iterator r9 = r9.iterator2()
        L3a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto La7
            java.lang.Object r1 = r9.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r1 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r1
            int r2 = r7.getStatus()
            switch(r2) {
                case -4: goto L92;
                case -3: goto L80;
                case -2: goto L74;
                case -1: goto L70;
                case 0: goto L92;
                case 1: goto L64;
                case 2: goto L64;
                case 3: goto L64;
                case 4: goto L64;
                case 5: goto L64;
                case 6: goto L4d;
                case 7: goto L64;
                case 8: goto L64;
                case 9: goto L4d;
                case 10: goto L4d;
                case 11: goto L4e;
                default: goto L4d;
            }
        L4d:
            goto L3a
        L4e:
            boolean r2 = r1 instanceof com.ss.android.download.api.download.m
            if (r2 == 0) goto L58
            com.ss.android.download.api.download.m r1 = (com.ss.android.download.api.download.m) r1
            r1.m(r7)
            goto L3a
        L58:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.oa.m(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L64:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.oa.m(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L70:
            r1.onDownloadFailed(r8)
            goto L3a
        L74:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.oa.m(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3a
        L80:
            com.ss.android.downloadlib.addownload.dk.np r2 = r6.f38591m
            com.ss.android.download.api.download.DownloadModel r2 = r2.dk
            boolean r2 = com.ss.android.downloadlib.hc.ve.m(r2)
            if (r2 == 0) goto L8e
            r1.onInstalled(r8)
            goto L3a
        L8e:
            r1.onDownloadFinished(r8)
            goto L3a
        L92:
            com.ss.android.downloadlib.addownload.dk.np r2 = r6.f38591m
            com.ss.android.download.api.download.DownloadModel r2 = r2.dk
            boolean r2 = com.ss.android.downloadlib.hc.ve.m(r2)
            if (r2 == 0) goto La3
            r2 = -3
            r8.status = r2
            r1.onInstalled(r8)
            goto L3a
        La3:
            r1.onIdle()
            goto L3a
        La7:
            return
        La8:
            java.util.Iterator r7 = r9.iterator2()
        Lac:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lbc
            java.lang.Object r8 = r7.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r8 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r8
            r8.onIdle()
            goto Lac
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.e.m(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List):void");
    }

    @NonNull
    public static List<DownloadStatusChangeListener> m(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private HttpHeader m(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new HttpHeader("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e2) {
            c.mj().m(e2, "parseLogExtra Error");
            return null;
        }
    }
}
