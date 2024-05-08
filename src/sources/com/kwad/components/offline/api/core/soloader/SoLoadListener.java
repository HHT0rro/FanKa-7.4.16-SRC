package com.kwad.components.offline.api.core.soloader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface SoLoadListener {
    void onFailed(int i10, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
