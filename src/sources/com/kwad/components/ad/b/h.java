package com.kwad.components.ad.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface h extends com.kwad.sdk.components.a {
    List<String> R();

    void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener);
}
