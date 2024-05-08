package com.ss.android.socialbase.downloader.setting;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface DownloadSettingValues {
    public static final int DEFAULT_304_MAX_AGE = 300;
    public static final int DNS_EXPIRE_MIN = 10;
    public static final int RW_CONCURRENT_MAX_BUFFER_COUNT = 4;
    public static final int SPACE_FILL_MIN_KEEP_MB = 100;
    public static final int SYNC_INTERVAL_MS_BG = 1000;
    public static final int SYNC_INTERVAL_MS_FG = 5000;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface RetryScheduleConfig {
        public static final int INTERVAL_SEC = 60;
        public static final int INTERVAL_SEC_ACCELERATION = 60;
        public static final int MAX_COUNT = 60;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface SegmentConfig {
        public static final int BUFFER_COUNT = 512;
        public static final int BUFFER_SIZE = 8192;
        public static final int CONNECT_TIMEOUT = -1;
        public static final int IP_STRATEGY = 0;
        public static final int READ_TIMEOUT = -1;
        public static final int SEGMENT_MIN_INIT_MB = 10;
        public static final int SEGMENT_MIN_KB = 512;
        public static final int THREAD_COUNT = 4;
        public static final int URL_BALANCE = 2;
    }
}
