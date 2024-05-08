package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.h;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BatchResult implements Result {
    private final Status zaa;
    private final PendingResult<?>[] zab;

    public BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.zaa = status;
        this.zab = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    @RecentlyNonNull
    public final Status getStatus() {
        return this.zaa;
    }

    @RecentlyNonNull
    public final <R extends Result> R take(@RecentlyNonNull BatchResultToken<R> batchResultToken) {
        h.b(batchResultToken.f23373a < this.zab.length, "The result token does not belong to this batch");
        return (R) this.zab[batchResultToken.f23373a].await(0L, TimeUnit.MILLISECONDS);
    }
}
