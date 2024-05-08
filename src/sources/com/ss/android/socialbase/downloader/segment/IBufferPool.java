package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IBufferPool {
    @NonNull
    Buffer obtain() throws StreamClosedException, InterruptedException;

    void recycle(@NonNull Buffer buffer);
}
