package com.google.android.gms.vision.clearcut;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class LoggingConnectionCallbacks implements GoogleApiClient.a, GoogleApiClient.b {
    @Override // com.google.android.gms.common.api.internal.f
    public void onConnected(@RecentlyNonNull Bundle bundle) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.api.internal.k
    public void onConnectionFailed(@RecentlyNonNull ConnectionResult connectionResult) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.api.internal.f
    public void onConnectionSuspended(int i10) {
        throw new NoSuchMethodError();
    }
}
