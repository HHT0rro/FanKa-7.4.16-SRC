package com.ss.android.socialbase.downloader.constants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadStatus {
    public static final int CANCELED = -4;
    public static final int CONNECTED = 3;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int FIRST_START = 6;
    public static final int FIRST_SUCCESS = -6;
    public static final int IDLE_STATUS = 0;
    public static final int INTERCEPT = -7;
    public static final int PAUSED = -2;
    public static final int PAUSED_BY_DB_INIT = -5;
    public static final int PREPARE = 1;
    public static final int PROGRESS = 4;
    public static final int RETRY = 5;
    public static final int RETRY_DELAY = 7;
    public static final int SINGLE_CHUNK_DELAY_RETRY = 10;
    public static final int SINGLE_CHUNK_RETRY = 9;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int WAITING_ASYNC_HANDLER = 8;

    public static boolean isDownloadOver(int i10) {
        return (i10 >= 0 || i10 == -2 || i10 == -5) ? false : true;
    }

    public static boolean isDownloading(int i10) {
        return (i10 <= 0 || i10 == 7 || i10 == 8 || i10 == 10) ? false : true;
    }

    public static boolean isFailedStatus(int i10) {
        return i10 == -1 || i10 == -7;
    }

    public static boolean isMonitorStatus(int i10) {
        return i10 == 2 || i10 == -3 || i10 == -1 || i10 == -4 || i10 == -2 || i10 == 6 || i10 == 0;
    }

    public static boolean isRealTimeUploadStatus(int i10) {
        return i10 == -3 || i10 == -1 || i10 == -4 || i10 == -2 || i10 == 5 || i10 == 7 || i10 == 8;
    }

    public static boolean isTimeUploadStatus(int i10) {
        return i10 == -3 || i10 == -1 || i10 == -4;
    }

    public static boolean isUnCompletedStatus(int i10) {
        return i10 == -1 || i10 == -2 || i10 == -7 || i10 == -4 || i10 == -5;
    }
}
