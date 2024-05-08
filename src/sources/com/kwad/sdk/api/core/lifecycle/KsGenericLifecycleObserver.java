package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class KsGenericLifecycleObserver extends KsLifecycleObserver {
    @Keep
    public abstract void onStateChanged(KsLifecycle.KsLifeEvent ksLifeEvent);
}
