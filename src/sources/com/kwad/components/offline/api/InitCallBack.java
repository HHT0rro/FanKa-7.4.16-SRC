package com.kwad.components.offline.api;

import androidx.annotation.WorkerThread;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface InitCallBack {
    @WorkerThread
    void onError(int i10);

    @WorkerThread
    void onSuccess(boolean z10);
}
