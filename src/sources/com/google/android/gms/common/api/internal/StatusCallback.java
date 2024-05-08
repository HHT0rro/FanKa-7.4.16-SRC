package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class StatusCallback extends IStatusCallback.Stub {
    private final e<Status> mResultHolder;

    public StatusCallback(@RecentlyNonNull e<Status> eVar) {
        this.mResultHolder = eVar;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public void onResult(@RecentlyNonNull Status status) {
        this.mResultHolder.a(status);
    }
}
