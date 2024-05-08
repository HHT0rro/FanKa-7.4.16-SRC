package com.huawei.flexiblelayout.services.exposure.impl;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposureContainerHelper extends AbsExposureHelper {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final ExposureContainer f28548d;

    public ExposureContainerHelper(@NonNull FLayout fLayout, @NonNull ExposureParam exposureParam, @NonNull ExposureContainer exposureContainer) {
        super(fLayout, exposureParam);
        this.f28548d = exposureContainer;
        fLayout.getView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.huawei.flexiblelayout.services.exposure.impl.ExposureContainerHelper.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                ExposureContainerHelper.this.onVisibilityChanged(true);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ExposureContainerHelper.this.onVisibilityChanged(false);
            }
        });
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper
    public void dispatchLayoutVisibility(boolean z10) {
        Iterator<Visit> iterator2 = this.f28548d.getExposureItems().iterator2();
        while (iterator2.hasNext()) {
            dispatchVisibilityEvent(iterator2.next(), z10);
        }
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper
    public void dispatchScroll(int i10) {
    }

    @Override // com.huawei.flexiblelayout.services.exposure.impl.AbsExposureHelper
    public boolean needCalArea(boolean z10, @NonNull FLCardData fLCardData) {
        return TextUtils.equals(getExposureMode(fLCardData), "custom");
    }
}
