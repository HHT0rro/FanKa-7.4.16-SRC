package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DataHolderResult implements u6.c, Result {

    @RecentlyNonNull
    public final DataHolder mDataHolder;

    @RecentlyNonNull
    public final Status mStatus;

    public DataHolderResult(@RecentlyNonNull DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.g()));
    }

    @Override // com.google.android.gms.common.api.Result
    @RecentlyNonNull
    public Status getStatus() {
        return this.mStatus;
    }

    @Override // u6.c
    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public DataHolderResult(@RecentlyNonNull DataHolder dataHolder, @RecentlyNonNull Status status) {
        this.mStatus = status;
        this.mDataHolder = dataHolder;
    }
}
