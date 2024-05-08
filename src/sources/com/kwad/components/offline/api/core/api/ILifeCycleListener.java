package com.kwad.components.offline.api.core.api;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Keep;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ILifeCycleListener {
    @Keep
    void onActivityCreated(Activity activity, Bundle bundle);

    @Keep
    void onActivityDestroyed(Activity activity);

    @Keep
    void onActivityPaused(Activity activity);

    @Keep
    void onActivityResumed(Activity activity);

    @Keep
    void onBackToBackground();

    @Keep
    void onBackToForeground();
}