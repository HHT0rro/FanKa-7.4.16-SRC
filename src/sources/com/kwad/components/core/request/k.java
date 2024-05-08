package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface k<T extends AdResultData> {
    @WorkerThread
    void a(@NonNull T t2);

    @WorkerThread
    void onError(int i10, String str);
}
