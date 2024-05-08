package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class j<T> {
    public boolean Jd;
    public boolean aOB = false;

    public j(boolean z10) {
        this.Jd = z10;
    }

    @Nullable
    public final T bO(Context context) {
        if (!this.Jd || this.aOB) {
            return null;
        }
        try {
            return bP(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    @Nullable
    public abstract T bP(Context context);

    public final void bQ(boolean z10) {
        this.Jd = z10;
    }
}
