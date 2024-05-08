package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface KsImage {
    @KsAdSdkApi
    @Keep
    int getHeight();

    @KsAdSdkApi
    @Keep
    String getImageUrl();

    @KsAdSdkApi
    @Keep
    int getWidth();

    @KsAdSdkApi
    @Keep
    boolean isValid();
}
