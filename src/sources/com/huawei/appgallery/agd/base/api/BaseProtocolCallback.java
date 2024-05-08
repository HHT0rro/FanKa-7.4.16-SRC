package com.huawei.appgallery.agd.base.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface BaseProtocolCallback {
    public static final int PROTOCOL_AGREE = 0;
    public static final int PROTOCOL_NOT_AGREE = 1;
    public static final int REASON_ERROR_UNSPECIFIED = 102;
    public static final int REASON_NORMAL = 100;
    public static final int REASON_USER_CANCEL = 101;

    void onGuideProtocolResult(int i10, int i11);
}
