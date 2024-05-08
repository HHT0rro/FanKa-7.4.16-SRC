package com.huawei.hms.mlsdk.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MLException extends Exception {
    public static final int ANALYSIS_FAILURE = 11;
    public static final int AUTHENTICATION_REQUIRED = 15;
    public static final int DATA_MISSING = 14;
    public static final int DISCARDED = 1;
    public static final int DUPLICATE_FOUND = 8;
    public static final int EXCEED_RANGE = 13;
    public static final int HASH_MISS = 18;
    public static final int ILLEGAL_PARAMETER = 5;
    public static final int INACTIVE = 3;
    public static final int INNER = 2;
    public static final int INSUFFICIENT_RESOURCE = 10;
    public static final int INSUFFICIENT_SPACE = 17;
    public static final int INTERRUPTED = 12;
    public static final int NOT_SUPPORTED = 4;
    public static final int NO_FOUND = 7;
    public static final int NO_PERMISSION = 9;
    public static final int OVERDUE = 6;
    public static final int SUCCESS = 0;
    public static final int TFLITE_NOT_COMPATIBLE = 16;
    public static final int TOKEN_INVALID = 19;
    public static final int UNKNOWN = -1;
    private final int code;

    public MLException(String str, int i10) {
        super(str);
        this.code = i10;
    }

    public int getErrCode() {
        return this.code;
    }

    public MLException(String str, int i10, Throwable th) {
        super(str, th);
        this.code = i10;
    }
}
