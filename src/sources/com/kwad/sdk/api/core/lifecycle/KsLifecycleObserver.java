package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.LifecycleObserver;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class KsLifecycleObserver {
    public LifecycleObserver mBase;

    public LifecycleObserver getBase() {
        return this.mBase;
    }

    public void setBase(LifecycleObserver lifecycleObserver) {
        this.mBase = lifecycleObserver;
    }
}
