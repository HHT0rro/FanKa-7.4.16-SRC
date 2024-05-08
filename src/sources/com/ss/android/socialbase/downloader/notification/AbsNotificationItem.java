package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbsNotificationItem {
    private int clickInstallTimes;
    private long curBytes;
    private String description;
    private long firstShowTime;

    /* renamed from: id, reason: collision with root package name */
    private int f38979id;
    public Notification notification;
    private boolean ongoing;
    private int status = 0;
    private String title;
    private long totalBytes;

    public AbsNotificationItem(int i10, String str) {
        this.f38979id = i10;
        this.title = str;
    }

    public void cancel() {
        if (this.f38979id == 0) {
            return;
        }
        DownloadNotificationManager.getInstance().cancel(this.f38979id);
    }

    public int getClickInstallTimes() {
        return this.clickInstallTimes;
    }

    public long getCurBytes() {
        return this.curBytes;
    }

    public String getDescription() {
        return this.description;
    }

    public long getFirstShowTime() {
        if (this.firstShowTime == 0) {
            this.firstShowTime = System.currentTimeMillis();
        }
        return this.firstShowTime;
    }

    public int getId() {
        return this.f38979id;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public boolean isOngoing() {
        return this.ongoing;
    }

    public void notify(Notification notification) {
        if (this.f38979id == 0 || notification == null) {
            return;
        }
        DownloadNotificationManager.getInstance().notifyByService(this.f38979id, this.status, notification);
    }

    public synchronized void recordClickInstall() {
        this.clickInstallTimes++;
    }

    public void refreshProgress(long j10, long j11) {
        this.curBytes = j10;
        this.totalBytes = j11;
        this.status = 4;
        updateNotification(null, false);
    }

    public void refreshStatus(int i10, BaseException baseException, boolean z10) {
        refreshStatus(i10, baseException, z10, false);
    }

    public void setCurBytes(long j10) {
        this.curBytes = j10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(int i10) {
        this.f38979id = i10;
    }

    public void setOngoing(boolean z10) {
        this.ongoing = z10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalBytes(long j10) {
        this.totalBytes = j10;
    }

    public abstract void updateNotification(BaseException baseException, boolean z10);

    public void updateNotificationItem(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f38979id = downloadInfo.getId();
        this.title = downloadInfo.getTitle();
    }

    public void refreshStatus(int i10, BaseException baseException, boolean z10, boolean z11) {
        if (z11 || this.status != i10) {
            this.status = i10;
            updateNotification(baseException, z10);
        }
    }
}
