package com.ss.android.socialbase.downloader.utils;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadExpSwitchCode {
    public static final int BACK_BUGFIX_SIGBUS = 67108864;
    public static final int BACK_CLEAR_DATA = 33554432;
    public static final int BACK_PARTIAL = 16777216;
    public static final int BUGFIX_DOWNLOAD_RUNNABLE_POOL_ERROR = 524288;
    public static final int BUGFIX_FIX_ADD_LISTENER = 32768;
    public static final int BUGFIX_FIX_CANCEL_THEN_UODATE = 65536;
    public static final int BUGFIX_FIX_MULTI_CHUNK_RESTART_BE_CLEARED = 8192;
    public static final int BUGFIX_FIX_START_DOWNLOAD_SERVICE_ERROR = 262144;
    public static final int BUGFIX_GETPACKAGEINFO_BY_UNZIP = 268435456;
    public static final int BUGFIX_ONLY_WIFI = 1048576;
    public static final int BUGFIX_SIGBUS_24_25 = 134217728;
    public static final int CHUNK_REVERT_OPT = 32;
    public static final int CONTENT_LENGTH_FALLBACK = 1;
    public static final int DOWNLOAD_CACHE_UPDATE_BUGFIX = 4096;
    public static final int ENSURE_FIRST_CHUNK_DOWNLOAD = 64;
    public static final int FIX_CANCEL_DELETE_FILE_ERROR = 8388608;
    public static final int FIX_CLOSED_HEAD_REQUEST = 2097152;
    public static final int FIX_DOWNLOADER_ISDOWNLOADING_SETMULTIPROCESS_DEADLOCK = 4194304;
    public static final int FIX_SQL_CACHE_INIT_BUG = 2048;
    public static final int GET_TOTAL_BYTES_CHANGE = 2;
    public static final int IS_CHUNKED_CHANGE = 8;
    public static final int SINGLE_CHUNK_RETRY = 16;

    public static boolean isSwitchEnable(int i10) {
        return (DownloadComponentManager.getDownloadExpSwitchCode() & i10) == i10;
    }
}
