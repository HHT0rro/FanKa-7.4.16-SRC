package com.huawei.appgallery.coreservice.api;

import androidx.annotation.NonNull;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ApiCode {
    public static final int DEAD_CLIENT = 12;
    public static final int DEVELOPER_ERROR = 9;
    public static final int INTERNAL_ERROR = 8;
    public static final int LACK_OF_REQUEST_ERROR = 14;
    public static final int METHOD_UNSUPPORT = 5;
    public static final int NETWORK_ERROR = 7;
    public static final int PROTOCOL_ERROR = 15;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESPONSE_ERROR = 13;
    public static final int SERVICE_INVALID = 4;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 10;

    public static String a(int i10) {
        switch (i10) {
            case 9:
                return "DEVELOPER_ERROR";
            case 10:
                return "TIMEOUT";
            case 11:
            default:
                return "unknown status code: " + i10;
            case 12:
                return "DEAD_CLIENT";
            case 13:
                return "RESPONSE_ERROR";
            case 14:
                return "LACK_OF_REQUEST_ERROR";
            case 15:
                return "PROTOCOL_ERROR";
        }
    }

    @NonNull
    public static String getStatusCodeString(int i10) {
        if (i10 == 0) {
            return MonitorResult.SUCCESS;
        }
        if (i10 == 2) {
            return "SERVICE_VERSION_UPDATE_REQUIRED";
        }
        switch (i10) {
            case 4:
                return "SERVICE_INVALID";
            case 5:
                return "METHOD_UNSUPPORT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            default:
                return a(i10);
        }
    }
}
