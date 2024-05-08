package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class ConcatenatingMediaSource$MessageData<T> {
    public final T customData;
    public final int index;

    @Nullable
    public final ConcatenatingMediaSource$HandlerAndRunnable onCompletionAction;

    public ConcatenatingMediaSource$MessageData(int i10, T t2, @Nullable ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable) {
        this.index = i10;
        this.customData = t2;
        this.onCompletionAction = concatenatingMediaSource$HandlerAndRunnable;
    }
}
