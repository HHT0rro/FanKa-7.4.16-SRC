package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;
import com.huawei.flexiblelayout.services.exposure.impl.ChainExecutor;
import com.huawei.flexiblelayout.services.exposure.impl.ExposureTaskBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RecyclerViewInterceptor implements ChainExecutor.Interceptor<ExposureTaskBuilder.Param, ExposureTaskImpl> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.flexiblelayout.services.exposure.impl.ChainExecutor.Interceptor
    @Nullable
    public ExposureTaskImpl intercept(@NonNull ChainExecutor.Chain<ExposureTaskBuilder.Param, ExposureTaskImpl> chain) {
        FLayout fLayout = chain.getParam().getFLayout();
        ExposureParam param = chain.getParam().getParam();
        if (fLayout.getLayoutView() != null && (fLayout.getLayoutView().getView() instanceof RecyclerView)) {
            RecyclerView recyclerView = (RecyclerView) fLayout.getLayoutView().getView();
            RecyclerViewVHAttachStateOwner recyclerViewVHAttachStateOwner = new RecyclerViewVHAttachStateOwner(recyclerView);
            ExposureTaskImpl exposureTaskImpl = new ExposureTaskImpl(new RecyclerViewExposureHelper(fLayout, param, recyclerView));
            exposureTaskImpl.monitor(recyclerViewVHAttachStateOwner);
            exposureTaskImpl.monitor(param.getLifecycleOwner());
            return exposureTaskImpl;
        }
        return chain.proceed(chain.getParam());
    }
}
