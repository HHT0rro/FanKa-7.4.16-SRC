package com.ss.android.downloadlib.addownload.ej;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.hc.c;
import com.ss.android.downloadlib.hc.ve;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m implements IDownloadDiskSpaceHandler {

    /* renamed from: m, reason: collision with root package name */
    private int f38603m;

    private long dk(DownloadSetting downloadSetting) {
        long optLong = downloadSetting.optLong("clear_space_sleep_time", 0L);
        if (optLong <= 0) {
            return 0L;
        }
        if (optLong > 5000) {
            optLong = 5000;
        }
        c.dk("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + optLong, null);
        try {
            Thread.sleep(optLong);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        c.dk("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return optLong;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
    public boolean cleanUpDisk(long j10, long j11, IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
        long j12;
        DownloadSetting obtain = DownloadSetting.obtain(this.f38603m);
        if (!m(obtain)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l.m().ej();
        long dk = ve.dk(0L);
        m();
        long dk2 = ve.dk(0L);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (dk2 < j11) {
            long dk3 = dk(obtain);
            if (dk3 > 0) {
                dk2 = ve.dk(0L);
            }
            j12 = dk3;
        } else {
            j12 = 0;
        }
        c.dk("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j11 + ", byteAvailableAfter = " + dk2 + ", cleaned = " + (dk2 - dk), null);
        long j13 = dk2;
        m(dk, dk2, j11, currentTimeMillis2, j12);
        if (j13 < j11) {
            return false;
        }
        if (iDownloadDiskSpaceCallback == null) {
            return true;
        }
        iDownloadDiskSpaceCallback.onDiskCleaned();
        return true;
    }

    public void m(int i10) {
        this.f38603m = i10;
    }

    private boolean m(DownloadSetting downloadSetting) {
        if (downloadSetting.optInt("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - l.m().dk() >= downloadSetting.optLong("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
    }

    private void m() {
        com.ss.android.download.api.config.np k10 = com.ss.android.downloadlib.addownload.c.k();
        if (k10 != null) {
            k10.m();
        }
        ej.m();
        ej.dk();
    }

    private void m(long j10, long j11, long j12, long j13, long j14) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.c.getContext()).getDownloadInfo(this.f38603m);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.m.m().m(downloadInfo, j10, j11, j12, j13, j14, j11 > j12);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
