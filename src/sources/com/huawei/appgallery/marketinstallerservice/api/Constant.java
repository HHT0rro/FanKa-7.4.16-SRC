package com.huawei.appgallery.marketinstallerservice.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Constant {
    public static final int INSTALL_FAILED_FILE_NOT_FOUND = -10001;
    public static final int INSTALL_FAILED_SHA256_EEROR = -10002;
    public static final int INSTALL_FAILED_UNKNOW = -10000;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface RequestResultCode {
        public static final int CAN_NOT_GET_INFO = -4;
        public static final int DOWNLOAD_FAIL = -3;
        public static final int INSTALL_FAIL = -2;
        public static final int NETWORK_ERROR = -1;
        public static final int SUCCEED = 0;
        public static final int USER_CANCEL = -5;
    }
}
