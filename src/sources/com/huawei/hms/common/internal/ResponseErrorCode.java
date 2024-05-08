package com.huawei.hms.common.internal;

import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ResponseErrorCode {
    int getErrorCode();

    String getErrorReason();

    Parcelable getParcelable();

    String getResolution();

    int getStatusCode();

    String getTransactionId();

    boolean hasResolution();
}
