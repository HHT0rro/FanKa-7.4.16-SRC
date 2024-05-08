package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.dh;
import com.ss.android.download.api.config.oa;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.config.ve;
import com.ss.android.download.api.config.w;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np implements com.ss.android.download.api.m {
    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(@NonNull w wVar) {
        c.m(wVar);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(@NonNull com.ss.android.download.api.config.hc hcVar) {
        c.m(hcVar);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(@NonNull ve veVar) {
        c.m(veVar);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(@NonNull com.ss.android.download.api.config.e eVar) {
        c.m(eVar);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(@NonNull oa oaVar) {
        c.m(oaVar);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(@NonNull com.ss.android.download.api.model.m mVar) {
        c.m(mVar);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(String str) {
        c.m(str);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(@NonNull final com.ss.android.download.api.config.dk dkVar) {
        c.m(dkVar);
        AppStatusManager.getInstance().setInnerAppStatusChangeCaller(new AppStatusManager.InnerAppStatusChangeCaller() { // from class: com.ss.android.downloadlib.np.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
            public boolean isAppInBackground() {
                return dkVar.m();
            }
        });
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new INotificationClickCallback() { // from class: com.ss.android.downloadlib.np.2
                private boolean m(DownloadInfo downloadInfo) {
                    String m10;
                    dh x10 = c.x();
                    if (x10 == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.m.dk m11 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
                    if (m11 != null && m11.ej()) {
                        m10 = DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
                    } else {
                        m10 = com.ss.android.downloadlib.addownload.w.m(downloadInfo);
                    }
                    if (TextUtils.isEmpty(m10)) {
                        return false;
                    }
                    return x10.m(c.getContext(), m10);
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.m.dk m10 = com.ss.android.downloadlib.addownload.dk.n.m().m(downloadInfo);
                    if (m10 != null) {
                        com.ss.android.downloadlib.dk.m.m(m10);
                    } else {
                        com.ss.android.downloadlib.hc.w.dk(c.getContext(), downloadInfo.getPackageName());
                    }
                    DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
                    DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
                    if (obtain.optInt("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.m(c.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.l.oa().dk(), Downloader.getInstance(c.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean m10 = m(downloadInfo);
                    if (obtain.optInt("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return m10;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.ej.ej());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public com.ss.android.download.api.m m(t tVar) {
        c.m(tVar);
        return this;
    }

    @Override // com.ss.android.download.api.m
    public void m() {
        if (!c.v()) {
            com.ss.android.downloadlib.np.ej.m().m("ttdownloader init error");
        }
        c.m(com.ss.android.downloadlib.np.ej.m());
        try {
            com.ss.android.socialbase.appdownloader.l.oa().dk(c.li());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.l.oa().m(m.m());
        l.m().dk(new Runnable() { // from class: com.ss.android.downloadlib.np.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.n.np.m("");
                if (com.ss.android.socialbase.appdownloader.n.np.q()) {
                    DownloadComponentManager.setNotAutoRebootService(true);
                }
                if (DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.n.n.m(c.getContext());
                }
            }
        });
    }
}
