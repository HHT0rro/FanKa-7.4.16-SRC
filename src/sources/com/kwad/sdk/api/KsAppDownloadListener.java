package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface KsAppDownloadListener {
    @KsAdSdkApi
    @Keep
    void onDownloadFailed();

    @KsAdSdkApi
    @Keep
    void onDownloadFinished();

    @KsAdSdkApi
    @Keep
    void onDownloadStarted();

    @KsAdSdkApi
    @Keep
    void onIdle();

    @KsAdSdkApi
    @Keep
    void onInstalled();

    @KsAdSdkApi
    @Keep
    void onProgressUpdate(int i10);
}
