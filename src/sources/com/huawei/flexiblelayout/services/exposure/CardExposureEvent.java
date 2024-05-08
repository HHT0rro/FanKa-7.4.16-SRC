package com.huawei.flexiblelayout.services.exposure;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.FLCardData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface CardExposureEvent {
    @NonNull
    FLCardData getData();

    int getId();

    int getPercent();

    long getTimeStamp();

    boolean isVisible();
}
