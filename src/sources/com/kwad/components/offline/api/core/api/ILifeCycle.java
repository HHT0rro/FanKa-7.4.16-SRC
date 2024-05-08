package com.kwad.components.offline.api.core.api;

import android.app.Activity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ILifeCycle {
    Activity getCurrentActivity();

    boolean isAppOnForeground();

    int registerLifeCycleListener(ILifeCycleListener iLifeCycleListener);

    void unregisterLifeCycleListener(int i10);
}
