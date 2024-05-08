package com.huawei.appgallery.agd.base.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface BaseInstallCallback {
    public static final int REASON_ERROR_UNSPECIFIED = 1;
    public static final int REASON_SUCCESS = 0;
    public static final int REASON_USER_CANCEL = 2;

    void onInstallResult(int i10);
}
