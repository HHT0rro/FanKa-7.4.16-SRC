package com.huawei.quickcard.framework.configuration.device;

import androidx.annotation.NonNull;
import com.huawei.quickcard.h0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IManufacturerDeviceInfo {
    public static final String OS_ANDROID = "android";
    public static final String OS_HARMONY = "harmony";

    @NonNull
    h0 getFoldedState();

    boolean isFoldable();

    String manufacturerName();

    String osType();
}
