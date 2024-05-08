package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLayoutContainer {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface BoundFLayout {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public interface Listener {
            void onBind(@NonNull FLayout fLayout);
        }

        void whenBound(@NonNull Listener listener);
    }

    @NonNull
    BoundFLayout getBoundFLayout();

    @NonNull
    FLayout getFLayout();
}
