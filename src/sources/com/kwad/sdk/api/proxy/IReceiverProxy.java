package com.kwad.sdk.api.proxy;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IReceiverProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    @Keep
    void onReceive(Context context, Intent intent);
}
