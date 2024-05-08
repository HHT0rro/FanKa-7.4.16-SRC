package com.huawei.flexiblelayout.services.exposure;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface CardExposureService {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface CardExposureHandler {
        void onCardExposureEvent(@NonNull CardExposureEvent cardExposureEvent);
    }

    void registerHandler(@NonNull CardExposureHandler cardExposureHandler);

    void setup(@NonNull FLayout fLayout, @NonNull ExposureParam exposureParam);

    void unregisterHandler(@NonNull CardExposureHandler cardExposureHandler);
}
