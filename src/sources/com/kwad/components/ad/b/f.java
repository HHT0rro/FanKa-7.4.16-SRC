package com.kwad.components.ad.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface f extends com.kwad.sdk.components.a {
    void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener);

    void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener);
}
