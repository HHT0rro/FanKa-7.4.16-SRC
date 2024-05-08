package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;
import com.huawei.flexiblelayout.services.exposure.impl.ChainExecutor;
import com.huawei.flexiblelayout.services.exposure.impl.ExposureTaskBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposureContainerInterceptor implements ChainExecutor.Interceptor<ExposureTaskBuilder.Param, ExposureTaskImpl> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.flexiblelayout.services.exposure.impl.ChainExecutor.Interceptor
    @Nullable
    public ExposureTaskImpl intercept(@NonNull ChainExecutor.Chain<ExposureTaskBuilder.Param, ExposureTaskImpl> chain) {
        FLayout fLayout = chain.getParam().getFLayout();
        ExposureParam param = chain.getParam().getParam();
        if (!(fLayout.getLayoutView() instanceof ExposureContainer)) {
            return chain.proceed(chain.getParam());
        }
        ExposureContainer exposureContainer = (ExposureContainer) fLayout.getLayoutView();
        CardAttachStateOwner attachStateOwner = exposureContainer.getAttachStateOwner();
        ExposureTaskImpl exposureTaskImpl = new ExposureTaskImpl(new ExposureContainerHelper(fLayout, param, exposureContainer));
        exposureTaskImpl.monitor(attachStateOwner);
        exposureTaskImpl.monitor(param.getLifecycleOwner());
        return exposureTaskImpl;
    }
}
