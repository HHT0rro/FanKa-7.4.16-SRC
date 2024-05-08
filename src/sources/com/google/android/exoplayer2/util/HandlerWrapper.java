package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface HandlerWrapper {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface Message {
        HandlerWrapper getTarget();

        void sendToTarget();
    }

    Message a(int i10);

    boolean b(int i10);

    Message c(int i10, @Nullable Object obj);

    void d(@Nullable Object obj);

    Message e(int i10, int i11, int i12);

    boolean f(Message message);

    Message g(int i10, int i11, int i12, @Nullable Object obj);

    boolean h(int i10);

    boolean i(int i10, long j10);

    void j(int i10);

    boolean post(Runnable runnable);
}
