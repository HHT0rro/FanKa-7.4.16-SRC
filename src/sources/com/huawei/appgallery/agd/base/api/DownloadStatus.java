package com.huawei.appgallery.agd.base.api;

import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.utils.PackageKit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DownloadStatus {
    public static final int INSTALL_STATUS_DOWNLOADED = 7;
    public static final int INSTALL_STATUS_DOWNLOADING = 1;
    public static final int INSTALL_STATUS_DOWNLOAD_FAIL = 6;
    public static final int INSTALL_STATUS_DOWNLOAD_PAUSED = 2;
    public static final int INSTALL_STATUS_INSTALLED = 4;
    public static final int INSTALL_STATUS_INSTALLING = 3;
    public static final int INSTALL_STATUS_INSTALL_FAIL = 5;
    public static final int INSTALL_STATUS_NOT_INSTALL = 0;
    public static final int PROGRESS_0 = 0;
    public static final int PROGRESS_100 = 100;

    /* renamed from: a, reason: collision with root package name */
    public int f27318a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27319b;
    public String packageName;
    public int progress;
    public int status;

    public DownloadStatus(String str) {
        this.status = 0;
        this.f27318a = 1;
        this.packageName = str;
        if (PackageKit.checkApkInstall(ApplicationWrapper.getInstance().getContext(), str)) {
            this.status = 4;
            this.progress = 100;
            this.f27319b = 2;
        } else {
            this.status = 0;
            this.progress = 0;
            this.f27319b = -3;
        }
    }

    public final void a(int i10) {
        switch (i10) {
            case -1:
            case 6:
                this.status = 2;
                return;
            case 0:
            case 1:
            case 2:
            case 7:
            case 10:
                this.status = 1;
                return;
            case 3:
            case 8:
                this.status = 6;
                this.progress = 0;
                return;
            case 4:
                this.status = 7;
                this.progress = 100;
                return;
            case 5:
                if (PackageKit.checkApkInstall(ApplicationWrapper.getInstance().getContext(), this.packageName)) {
                    this.status = 4;
                    this.progress = 100;
                    return;
                } else {
                    this.status = 6;
                    this.progress = 0;
                    return;
                }
            case 9:
            default:
                return;
        }
    }

    public final void b(int i10) {
        if (i10 == -2 || i10 == -1) {
            this.progress = 0;
            this.status = 5;
        } else if (i10 == 0 || i10 == 1) {
            this.status = 3;
        } else if (i10 != 2) {
            this.status = 0;
            this.progress = 0;
        } else {
            this.status = 4;
            this.progress = 100;
        }
    }

    public int getAgAppStatus() {
        return this.f27319b;
    }

    public int getAgAppStatusType() {
        return this.f27318a;
    }

    public boolean isInstalled() {
        return this.status == 4;
    }

    public String toString() {
        return "DownloadStatus{packageName='" + this.packageName + "', status=" + l9.a.c(this.status) + ", progress=" + this.progress + ", agAppDownloadStatus=" + l9.a.a(this.f27319b) + ", agAppInstallStatus=" + l9.a.b(this.f27319b) + '}';
    }

    public DownloadStatus(String str, int i10, int i11, int i12) {
        this.status = 0;
        this.f27318a = i10;
        this.f27319b = i11;
        this.packageName = str;
        this.progress = i12;
        if (i10 == 2) {
            a(i11);
        } else if (i10 == 1) {
            b(i11);
        }
    }
}
