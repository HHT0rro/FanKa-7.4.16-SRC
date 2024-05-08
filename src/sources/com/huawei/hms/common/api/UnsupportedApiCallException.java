package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature feature;

    public UnsupportedApiCallException(Feature feature) {
        this.feature = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return ((Object) this.feature) + " is unsupported";
    }
}
