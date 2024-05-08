package com.huawei.hianalytics.framework.constant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FrameworkConstant {
    public static final int AUTO_REPORT_INTERVAL = 30000;
    public static final long DAY = 86400000;
    public static final int DB_MAX_THRESHOLD = 5000;
    public static final int EVENT_NUMBER_PER_UPLOAD = 500;
    public static final String EX_COMMON = "commonEx";
    public static final String EX_HEADER_CONSTANT = "headerEx";
    public static final String HMSHI = "hmshi";
    public static final int HOUR_MILLISECONDS = 3600000;
    public static final int MINUTE_MILLISECONDS = 60000;
    public static final String QRT = "qrt";
    public static final int SAVE_KEY_TIME = 43200000;
    public static final int SERVICE_TAG_SIZE = 50;
    public static final String URL_PALCEHOLDER = "{url}";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface DataType {
        public static final String STRING_DIFFPRIVACY = "diffprivacy";
        public static final String STRING_MAINT = "maint";
        public static final String STRING_OPER = "oper";
        public static final String STRING_PREINS = "preins";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface HttpUrls {
        public static final String DIFFPRC_DATA_UPLOAD_URL = "{url}/common/common2";
        public static final String GET_PUB_KEY_URL = "{url}/getPublicKey?keytype=2";
        public static final String MAINT_DATA_UPLOAD_URL = "{url}/common/hmshimaintqrt";
        public static final String OPER_DATA_UPLOAD_URL = "{url}/common/hmshioperqrt";
        public static final String PREINS_DATA_UPLOAD_URL = "{url}/common/hmshioperbatch";
        public static final String SERVER_ADDR_GET_URL = "{url}/getServerInfo";
        public static final String SERVER_ADDR_GET_URL_BACKUP = "{url}/getServerInfoWithBackup";
    }
}
