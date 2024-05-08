package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.addownload.dk.l;
import com.ss.android.downloadlib.addownload.dk.w;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.appdownloader.dk;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.turingface.sdk.mfa.ITuringIoTFeatureMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m implements com.ss.android.downloadad.api.m, dk.ej, AppStatusManager.AppStatusChangeListener, IOpenInstallerListener {

    /* renamed from: l, reason: collision with root package name */
    private static volatile m f38789l = null;

    /* renamed from: m, reason: collision with root package name */
    private static String f38790m = "m";
    private long dk;
    private dk ej;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class dk implements Runnable {
        private int dk;
        private long ej;

        /* renamed from: l, reason: collision with root package name */
        private int f38795l;

        /* renamed from: m, reason: collision with root package name */
        private long f38796m;
        private long np;

        /* JADX INFO: Access modifiers changed from: private */
        public void dk() {
            this.np = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (m()) {
                    m.m().m(this.f38796m, this.dk);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private dk(long j10, int i10, long j11, int i11) {
            this.f38796m = j10;
            this.dk = i10;
            this.ej = j11;
            this.f38795l = i11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        
            if (r9 < r1) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean m() {
            /*
                Method dump skipped, instructions count: 257
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.m.dk.m():boolean");
        }

        private int m(boolean z10, com.ss.android.downloadad.api.m.dk dkVar, DownloadInfo downloadInfo, boolean z11, JSONObject jSONObject) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            int i10 = 1;
            if (obtain.optInt("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!DownloadUtils.isMd5Valid(checkMd5Status)) {
                    return 2005;
                }
            }
            int i11 = this.f38795l;
            if (i11 != 2000) {
                return i11;
            }
            if (obtain.optInt("install_failed_check_signature", 1) == 1 && ve.np(c.getContext(), dkVar.np())) {
                if (!ve.m(ve.w(c.getContext(), downloadInfo.getTargetFilePath()), ve.e(c.getContext(), dkVar.np()))) {
                    return 2006;
                }
            }
            if (!z10) {
                return 2002;
            }
            long j10 = this.np;
            long j11 = this.ej;
            if (j10 <= j11) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j10 - j11);
                if (dkVar.ee() <= this.ej) {
                    i10 = 0;
                }
                jSONObject.put("install_again", i10);
            } catch (Throwable unused2) {
            }
            return !z11 ? 2003 : 2004;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ej implements Runnable {
        private final com.ss.android.downloadad.api.m.dk dk;

        public ej(com.ss.android.downloadad.api.m.dk dkVar) {
            this.dk = dkVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.dk.oa(true);
                    m.this.ej(this.dk);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.dk.oa(false);
            }
        }
    }

    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class RunnableC0582m implements Runnable {
        private final int dk;

        public RunnableC0582m(int i10) {
            this.dk = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.dk.n.m().dk();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.m.dk> ej = com.ss.android.downloadlib.addownload.dk.n.m().ej();
                if (ej == null || ej.isEmpty()) {
                    return;
                }
                m.this.m(ej, this.dk);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private m() {
        com.ss.android.socialbase.appdownloader.dk.m(this);
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static JSONObject dk(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long dk2 = ve.dk(0L);
            double d10 = dk2;
            jSONObject.put("available_space", d10 / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d11 = totalBytes;
            jSONObject.put("apk_size", d11 / 1048576.0d);
            if (dk2 > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d10 / d11);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private int l(com.ss.android.downloadad.api.m.dk dkVar) {
        int realStatus;
        double optDouble = DownloadSetting.obtain(dkVar.x()).optDouble("download_failed_finally_hours", 48.0d);
        if (optDouble <= ShadowDrawableWrapper.COS_45) {
            return -1;
        }
        if (System.currentTimeMillis() - dkVar.db() < optDouble * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (dkVar.f38458l.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(dkVar.x());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && dkVar.f38458l.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                m(jSONObject, downloadInfo);
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_STATUS, Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(dkVar.zk()));
                jSONObject.putOpt("fail_msg", dkVar.bm());
                jSONObject.put("download_failed_times", dkVar.s());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", dkVar.iy() ? 1 : 2);
                com.ss.android.downloadlib.l.m.m().m(dkVar.oa(), "download_failed_finally", jSONObject, dkVar);
                w.m().m(dkVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        Logger.d(f38790m, "onAppBackground()");
        m(6);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        Logger.d(f38790m, "onAppForeground()");
        dk();
        m(5);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.np.ej.m().m("info is null");
        } else if ((DownloadSetting.obtain(downloadInfo).optInt("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.dk.np.m().dk(new com.ss.android.downloadlib.dk.l() { // from class: com.ss.android.downloadlib.m.4
                @Override // com.ss.android.downloadlib.dk.l
                public void m(boolean z10) {
                    if (!z10) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.ej.m(c.getContext(), intent);
                            ve.m(jSONObject, "backup", (Object) 1);
                        } else {
                            ve.m(jSONObject, "backup", (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
                    if (m10 != null) {
                        com.ss.android.downloadlib.l.m.m().m(z10 ? "installer_delay_success" : "installer_delay_failed", jSONObject, m10);
                    } else {
                        com.ss.android.downloadlib.np.ej.m().dk("ah nativeModel=null");
                    }
                    if (z10) {
                        c.dh().m(c.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void ej(com.ss.android.downloadad.api.m.dk dkVar) {
        SystemClock.sleep(20000L);
        int i10 = 15;
        while (i10 > 0) {
            if (ve.dk(dkVar)) {
                m(dkVar.np());
                return;
            }
            i10--;
            if (i10 == 0) {
                return;
            } else {
                SystemClock.sleep(20000L);
            }
        }
    }

    public static m m() {
        if (f38789l == null) {
            synchronized (m.class) {
                if (f38789l == null) {
                    f38789l = new m();
                }
            }
        }
        return f38789l;
    }

    public static String ej(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.m.dk dkVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = c.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.ej.m());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            com.ss.android.downloadlib.l.m.m().m("embeded_ad", "package_name_error", jSONObject, dkVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    @WorkerThread
    public static synchronized void m(DownloadInfo downloadInfo, com.ss.android.downloadad.api.m.dk dkVar) {
        synchronized (m.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.np.ej.m().m("onDownloadFinish info null");
                return;
            }
            if (dkVar == null) {
                com.ss.android.downloadlib.np.ej.m().m("onDownloadFinish nativeModel null");
                return;
            }
            if (dkVar.ni() != 1) {
                return;
            }
            com.ss.android.downloadlib.ej.e.m().l(dkVar);
            String ej2 = ej(downloadInfo, dkVar);
            com.ss.android.downloadlib.addownload.dk.n.m().dk(downloadInfo.getUrl(), ej2);
            Map<Long, com.ss.android.downloadad.api.m.dk> m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo.getUrl(), ej2);
            dkVar.n(System.currentTimeMillis());
            dkVar.np(2);
            dkVar.dk(ej2);
            m10.put(Long.valueOf(dkVar.dk()), dkVar);
            w.m().m(m10.values());
            dk(dkVar);
            hc.m().m(downloadInfo, ej2);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                m().m(dkVar);
                m().dk(downloadInfo, dkVar);
                if (dkVar.d()) {
                    com.ss.android.downloadlib.addownload.m.m.m().m(downloadInfo.getId(), dkVar.dk(), dkVar.ve(), ej2, downloadInfo.getTitle(), dkVar.l(), downloadInfo.getTargetFilePath());
                }
                com.ss.android.downloadlib.addownload.np.m.m(downloadInfo, dkVar.dk(), dkVar.l(), ej2);
            }
        }
    }

    public void dk(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.m.dk dkVar) {
        if (downloadInfo == null || dkVar == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        l.m().dk(new Runnable() { // from class: com.ss.android.downloadlib.m.3
            @Override // java.lang.Runnable
            public void run() {
                String m10 = com.ss.android.downloadlib.hc.m.m(targetFilePath);
                if (TextUtils.isEmpty(m10)) {
                    return;
                }
                c.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(dkVar.dk()), m10).apply();
            }
        });
    }

    private static void dk(com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar == null) {
            return;
        }
        String ub2 = TextUtils.isEmpty(dkVar.ub()) ? "" : dkVar.ub();
        DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(dkVar.x());
        dkVar.ve("");
        w.m().m(dkVar);
        JSONObject m10 = m(new JSONObject(), downloadInfo);
        int i10 = 1;
        try {
            m10.putOpt("finish_reason", ub2);
            m10.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadad.api.m.dk m11 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
        com.ss.android.downloadlib.hc.n.m(m10, downloadInfo.getId());
        try {
            m10.put("download_failed_times", m11.s());
            m10.put("can_show_notification", com.ss.android.socialbase.appdownloader.np.l.m() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                m10.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            m10.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            m10.put("has_send_download_failed_finally", m11.f38458l.get() ? 1 : 2);
            if (!m11.iy()) {
                i10 = 2;
            }
            m10.put("is_update_download", i10);
            com.ss.android.downloadlib.hc.n.m(m11, m10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.l.m.m().dk("download_finish", m10, dkVar);
    }

    public synchronized void dk() {
        dk dkVar = this.ej;
        if (dkVar != null) {
            dkVar.dk();
            this.ej = null;
        }
    }

    @WorkerThread
    public synchronized void m(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!ve.dk()) {
            final com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(str);
            if (m10 == null) {
                com.ss.android.downloadlib.addownload.dk.l.m().m(str);
                return;
            }
            com.ss.android.downloadlib.addownload.np m11 = hc.m().m(m10.m());
            if (m11 != null) {
                m11.n();
            }
            if (m10.ej.get()) {
                return;
            }
            if (DownloadSetting.obtain(m10.x()).optInt("notification_opt_2") == 1) {
                DownloadNotificationManager.getInstance().cancelNotification(m10.x());
            }
            new com.ss.android.downloadlib.dk.dk().m(m10, new com.ss.android.downloadlib.dk.hc() { // from class: com.ss.android.downloadlib.m.1
                @Override // com.ss.android.downloadlib.dk.hc
                public void m(boolean z10) {
                    Logger.d(m.f38790m, "appBackForeground->" + z10);
                    if (z10) {
                        if (!(com.ss.android.downloadlib.dk.n.ej(m10) ? com.ss.android.downloadlib.dk.m.m(str, m10) : false) && com.ss.android.downloadlib.dk.n.l(m10) && m10.se() == 4) {
                            com.ss.android.downloadlib.addownload.m.m.m().m(m10);
                            return;
                        }
                        return;
                    }
                    if (com.ss.android.downloadlib.dk.m.m(str, m10) || m10.se() != 4) {
                        return;
                    }
                    com.ss.android.downloadlib.addownload.m.m.m().m(m10);
                }
            }, com.ss.android.downloadlib.hc.np.m(m10).optInt("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.ej.e.m().n(m10);
            m(str, m10);
            com.ss.android.downloadlib.addownload.m.m.m().dk(str);
            DownloadInfo m12 = m((List<DownloadInfo>) Downloader.getInstance(c.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
            if (m12 != null) {
                if (DownloadSetting.obtain(m12.getId()).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION) != 1) {
                    DownloadNotificationManager.getInstance().hideNotification(m12.getId());
                }
                hc.m().dk(m12, str);
                com.ss.android.downloadlib.addownload.ej.l.m(m12);
            } else {
                hc.m().dk(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    private JSONObject dk(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.m mVar) {
        com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
        if (m10 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        mVar.m(jSONObject);
        try {
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.hc.n.m(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.l.m.m().m("embeded_ad", "ah_result", jSONObject, m10);
        return jSONObject;
    }

    public void m(DownloadInfo downloadInfo, com.ss.android.downloadad.api.m.dk dkVar, int i10) {
        long max;
        if (downloadInfo == null || dkVar == null) {
            return;
        }
        dk();
        long currentTimeMillis = System.currentTimeMillis();
        dkVar.dk(currentTimeMillis);
        dkVar.hc(ve.m(Environment.getDataDirectory(), -1L));
        if (i10 != 2000) {
            max = 2000;
        } else {
            long optLong = DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_failed_delay_time", 120000L);
            if (optLong < 0) {
                return;
            } else {
                max = Math.max(optLong, 30000L);
            }
        }
        long j10 = max;
        dk dkVar2 = new dk(dkVar.dk(), downloadInfo.getId(), currentTimeMillis, i10);
        l.m().m(dkVar2, j10);
        this.ej = dkVar2;
        w.m().m(dkVar);
    }

    public void m(final long j10, int i10) {
        long optLong = DownloadSetting.obtain(i10).optLong("check_install_finish_hijack_delay_time", 900000L);
        if (optLong < 0) {
            return;
        }
        l.m().m(new Runnable() { // from class: com.ss.android.downloadlib.m.2
            @Override // java.lang.Runnable
            public void run() {
                m.m().m(j10);
            }
        }, Math.max(optLong, u.as));
    }

    public void m(long j10) {
        l.m m10;
        int i10;
        try {
            com.ss.android.downloadad.api.m.dk l10 = com.ss.android.downloadlib.addownload.dk.n.m().l(j10);
            if (l10 != null && !ve.dk(l10) && !l10.ej.get()) {
                Pair<l.m, Integer> dk2 = com.ss.android.downloadlib.addownload.dk.l.m().dk(l10);
                if (dk2 != null) {
                    m10 = (l.m) dk2.first;
                    i10 = ((Integer) dk2.second).intValue();
                } else {
                    m10 = com.ss.android.downloadlib.addownload.dk.l.m().m(l10);
                    i10 = -1;
                }
                if (m10 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.dk.l.m().dk(m10.f38575m);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", m10.f38574l);
                jSONObject.put("installed_pkg_name", m10.f38575m);
                if (i10 != -1) {
                    jSONObject.put("error_code", i10);
                    com.ss.android.downloadlib.hc.n.m(jSONObject, l10.x());
                    com.ss.android.downloadlib.l.m.m().dk("install_finish_hijack", jSONObject, l10);
                    return;
                }
                com.ss.android.downloadlib.l.m.m().dk("install_finish_may_hijack", jSONObject, l10);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.np.ej.m().m(th, "trySendInstallFinishHijack");
        }
    }

    public void m(String str, com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar != null && ve.dk(dkVar) && dkVar.ej.compareAndSet(false, true)) {
            com.ss.android.downloadlib.l.m.m().m(dkVar.oa(), "install_finish", m(dkVar, str, dkVar.se() != 4 ? 3 : 4), dkVar);
            w.m().m(dkVar);
        }
    }

    private static DownloadInfo m(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (ve.m(c.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject m(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i10 = 1;
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, downloadInfo.getTotalBytes());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.put(MonitorConstants.EXTRA_CUR_NETWORK_QUALITY, NetTrafficManager.getInstance().getCurrentNetworkQuality().name());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, downloadInfo.getRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadInfo.getCurRetryTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_HEAD_CONNECTION_ERROR_MSG, downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_TOTAL_RETRY_COUNT, downloadInfo.getTotalRetryCount());
                jSONObject.put(MonitorConstants.EXTRA_CUR_RETRY_TIME_IN_TOTAL, downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put(MonitorConstants.EXTRA_REAL_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put(MonitorConstants.EXTRA_CHUNK_DOWNGRADE_UESD, downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put(MonitorConstants.EXTRA_PRECONNECT_LEVEL, downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > ShadowDrawableWrapper.COS_45 && realDownloadTime > ShadowDrawableWrapper.COS_45) {
                    double d10 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put(MonitorConstants.DOWNLOAD_SPEED, d10);
                    } catch (Exception unused) {
                    }
                    Logger.d(f38790m, "download speed : " + d10 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(c.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadInfo.getBackUpUrls().size());
                    jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.ej.l.m().dk(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!DownloadUtils.isNetworkConnected(c.getContext())) {
                    i10 = 2;
                }
                jSONObject.put("network_available", i10);
                jSONObject.put(MonitorConstants.STATUS_CODE, downloadInfo.getHttpStatusCode());
                dk(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    private int m(com.ss.android.downloadad.api.m.dk dkVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int dk2 = com.ss.android.socialbase.appdownloader.ej.dk(c.getContext(), downloadInfo);
        int dk3 = ve.dk(c.getContext(), str);
        if (dk2 > 0 && dk3 > 0 && dk2 != dk3) {
            if (dk3 > dk2) {
                return 3011;
            }
            return ITuringIoTFeatureMap.RIOT_NEAR_BY_WIFI_SSID;
        }
        if (DownloadSetting.obtain(dkVar.x()).optInt("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = c.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(dkVar.dk()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.hc.m.m(downloadInfo.getTargetFilePath());
        }
        int m10 = com.ss.android.downloadlib.hc.m.m(string, com.ss.android.downloadlib.hc.m.dk(str));
        try {
            jSONObject.put("ttmd5_status", m10);
        } catch (Throwable unused) {
        }
        if (m10 == 0) {
            return 3000;
        }
        return m10 == 1 ? 3002 : 3001;
    }

    @Override // com.ss.android.downloadad.api.m
    public void m(int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dk < 120000) {
            return;
        }
        l.m().m(new RunnableC0582m(i10), this.dk > 0 ? 2000L : 8000L);
        this.dk = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void m(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.m.dk> concurrentHashMap, int i10) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.m.dk dkVar : concurrentHashMap.values()) {
            if (dkVar.ej.get()) {
                if (currentTimeMillis - dkVar.db() >= DownloadSetting.obtain(dkVar.x()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(dkVar.dk()));
                }
            } else if (dkVar.ni() == 1) {
                if (l(dkVar) <= 0 && currentTimeMillis - dkVar.db() >= DownloadSetting.obtain(dkVar.x()).optInt("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(dkVar.dk()));
                }
            } else if (dkVar.ni() == 2) {
                if (!dkVar.za()) {
                    if (ve.dk(dkVar)) {
                        if (dkVar.se() == 4) {
                            i10 = dkVar.se();
                        }
                        com.ss.android.downloadlib.l.m.m().m(m(dkVar, dkVar.np(), i10), dkVar);
                        arrayList.add(Long.valueOf(dkVar.dk()));
                        com.ss.android.downloadlib.addownload.ej.l.m(dkVar);
                    } else if (currentTimeMillis - dkVar.db() >= DownloadSetting.obtain(dkVar.x()).optInt("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(dkVar.dk()));
                    } else if (TextUtils.isEmpty(dkVar.np())) {
                        arrayList.add(Long.valueOf(dkVar.dk()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(dkVar.dk()));
            }
        }
        com.ss.android.downloadlib.addownload.dk.n.m().m(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.dk.ej
    public void m(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.m mVar) {
        JSONObject dk2;
        if (downloadInfo == null || mVar == null) {
            return;
        }
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray("ah_report_config");
        if (mVar.dk != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (optJSONArray == null || (dk2 = dk(downloadInfo, mVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", dk2);
    }

    public void m(com.ss.android.downloadad.api.m.dk dkVar) {
        l.m().m(new ej(dkVar));
    }

    private JSONObject m(com.ss.android.downloadad.api.m.dk dkVar, String str, int i10) {
        com.ss.android.socialbase.appdownloader.m m10;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(dkVar.x());
            jSONObject.putOpt("scene", Integer.valueOf(i10));
            com.ss.android.downloadlib.hc.n.m(jSONObject, dkVar.x());
            com.ss.android.downloadlib.hc.n.m(dkVar, jSONObject);
            jSONObject.put("is_update_download", dkVar.iy() ? 1 : 2);
            jSONObject.put("install_after_back_app", dkVar.am() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", dkVar.fb() ? "1" : "2");
            if (downloadInfo != null) {
                m(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (dkVar.ee() > 0) {
                        long currentTimeMillis = System.currentTimeMillis() - dkVar.ee();
                        jSONObject.put("install_time", currentTimeMillis);
                        if (currentTimeMillis > DownloadSetting.obtain(downloadInfo.getId()).optLong("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("ah_attempt"), null);
                if (!TextUtils.isEmpty(string) && (m10 = com.ss.android.socialbase.appdownloader.m.m(string)) != null) {
                    m10.m(jSONObject);
                }
            }
            int m11 = m(dkVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", m11);
            if (m11 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (m11 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void m(DownloadInfo downloadInfo, long j10, long j11, long j12, long j13, long j14, boolean z10) {
        com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
        if (m10 == null) {
            com.ss.android.downloadlib.np.ej.m().m("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j10 / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j11 - j10) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j13));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z10 ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j12));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j12 - j11) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j14));
            com.ss.android.downloadlib.hc.n.ej(downloadInfo, jSONObject);
            com.ss.android.downloadlib.l.m.m().m("cleanup", jSONObject, m10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
