package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IBundleService {
    void loadBundle(Context context, String str, IBundleLoadListener iBundleLoadListener);

    void loadBundleWithString(Context context, String str, IBundleLoadListener iBundleLoadListener);

    void unloadBundle(String str);
}
