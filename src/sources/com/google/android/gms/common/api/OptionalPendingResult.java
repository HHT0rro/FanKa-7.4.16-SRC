package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class OptionalPendingResult<R extends Result> extends PendingResult<R> {
    @RecentlyNonNull
    public abstract R get();

    @RecentlyNonNull
    public abstract boolean isDone();
}
