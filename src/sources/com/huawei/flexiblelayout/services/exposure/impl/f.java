package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer;

/* compiled from: FLayoutContainer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final /* synthetic */ class f {
    @NonNull
    public static FLayoutContainer.BoundFLayout a(final FLayoutContainer fLayoutContainer) {
        return new FLayoutContainer.BoundFLayout() { // from class: com.huawei.flexiblelayout.services.exposure.impl.e
            @Override // com.huawei.flexiblelayout.services.exposure.impl.FLayoutContainer.BoundFLayout
            public final void whenBound(FLayoutContainer.BoundFLayout.Listener listener) {
                listener.onBind(FLayoutContainer.this.getFLayout());
            }
        };
    }
}
