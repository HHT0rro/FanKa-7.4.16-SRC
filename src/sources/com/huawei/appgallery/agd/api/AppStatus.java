package com.huawei.appgallery.agd.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface AppStatus {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface AppStatusType {
        public static final int DOWNLOAD_STATUS_TYPE = 2;
        public static final int INSTALL_STATUS_TYPE = 1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface DownloadStatus {
        public static final int CANCEL_DOWNLOAD = 3;
        public static final int DOWNLOAD = 2;
        public static final int DOWNLOADED = 4;
        public static final int DOWNLOAD_EXCEPTION = 8;
        public static final int DOWNLOAD_FAILED = 5;
        public static final int DOWNLOAD_MERGE = 7;
        public static final int DOWNLOAD_PAUSED = 6;
        public static final int PRE_DOWNLOAD = 1;
        public static final int REDOWNLOAD_START_IN_HTTPS = 10;
        public static final int WAIT_DOWNLOAD = 0;
        public static final int WAIT_FOR_WIFI = -1;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface DownloadStatusReason {
        public static final int LOCAL_SPACE_NOT_ENOUGH = 121;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InstallStatus {
        public static final int INSTALL_SERVICE_INSTALLING = 1;
        public static final int INSTALL_SERVICE_INSTALL_FAILED = -1;
        public static final int INSTALL_SERVICE_INSTALL_SUCCESS = 2;
        public static final int INSTALL_SERVICE_NOT_INSTALL = -3;
        public static final int INSTALL_SERVICE_SILENT_INSTALL_FAILED = -2;
        public static final int INSTALL_SERVICE_WAIT_INSTALL = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InstallStatusReason {
        public static final int INSTALL_FAILED_INSUFFICIENT_STORAGE = -4;
    }
}
