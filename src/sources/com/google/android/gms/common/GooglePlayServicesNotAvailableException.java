package com.google.android.gms.common;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class GooglePlayServicesNotAvailableException extends Exception {

    @RecentlyNonNull
    public final int errorCode;

    public GooglePlayServicesNotAvailableException(@RecentlyNonNull int i10) {
        this.errorCode = i10;
    }
}
