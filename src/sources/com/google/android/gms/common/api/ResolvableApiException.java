package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(@RecentlyNonNull Status status) {
        super(status);
    }

    @RecentlyNonNull
    public PendingIntent getResolution() {
        return getStatus().getResolution();
    }

    public void startResolutionForResult(@RecentlyNonNull Activity activity, @RecentlyNonNull int i10) throws IntentSender.SendIntentException {
        getStatus().startResolutionForResult(activity, i10);
    }
}
