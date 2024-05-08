package com.huawei.flexiblelayout.services.exposure.impl;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateListener;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposureTaskImpl {

    /* renamed from: c, reason: collision with root package name */
    private static final String f28560c = "EXPOSURE_TASK_TAG";

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final AbsExposureHelper f28561a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private ViewVisibilityOwner f28562b;

    public ExposureTaskImpl(@NonNull AbsExposureHelper absExposureHelper) {
        this.f28561a = absExposureHelper;
    }

    @Nullable
    public static ExposureTaskImpl findTask(@NonNull FLayout fLayout) {
        View view = fLayout.getView();
        if (view == null) {
            return null;
        }
        return (ExposureTaskImpl) com.huawei.flexiblelayout.common.d.a(view, f28560c, ExposureTaskImpl.class);
    }

    @NonNull
    public AbsExposureHelper getHelper() {
        return this.f28561a;
    }

    @Nullable
    public ViewVisibilityOwner getViewVisibilityOwner() {
        return this.f28562b;
    }

    public void monitor(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            ViewVisibilityOwner viewVisibilityOwner = new ViewVisibilityOwner(lifecycleOwner.getLifecycle());
            this.f28562b = viewVisibilityOwner;
            viewVisibilityOwner.addVisibilityObserver(this.f28561a);
            return;
        }
        this.f28562b = null;
    }

    public static void a(@NonNull FLayout fLayout, @NonNull ExposureTaskImpl exposureTaskImpl) {
        View view = fLayout.getView();
        if (view == null) {
            return;
        }
        com.huawei.flexiblelayout.common.d.a(view, f28560c, exposureTaskImpl);
    }

    public void monitor(@NonNull CardAttachStateOwner cardAttachStateOwner) {
        cardAttachStateOwner.addListener(new CardAttachStateListener() { // from class: com.huawei.flexiblelayout.services.exposure.impl.ExposureTaskImpl.1
            @Override // com.huawei.flexiblelayout.services.exposure.CardAttachStateListener
            public void onViewAttachedToWindow(@NonNull Visit visit) {
                if (ExposureTaskImpl.this.f28561a.isLayoutVisible()) {
                    ExposureTaskImpl.this.f28561a.dispatchVisibilityEvent(visit, true);
                }
            }

            @Override // com.huawei.flexiblelayout.services.exposure.CardAttachStateListener
            public void onViewDetachedFromWindow(@NonNull Visit visit) {
                if (ExposureTaskImpl.this.f28561a.isLayoutVisible()) {
                    ExposureTaskImpl.this.f28561a.dispatchVisibilityEvent(visit, false);
                }
            }
        });
    }
}
