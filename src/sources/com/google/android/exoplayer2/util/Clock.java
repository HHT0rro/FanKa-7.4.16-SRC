package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface Clock {

    /* renamed from: a, reason: collision with root package name */
    public static final Clock f22902a = new d0();

    long a();

    long b();

    void c();

    HandlerWrapper d(Looper looper, @Nullable Handler.Callback callback);
}
