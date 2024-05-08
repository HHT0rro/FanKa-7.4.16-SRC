package com.kwad.components.ad.j;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class a<L extends h> {
    public AdTemplate mAdTemplate;

    public a(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public abstract void a(L l10);

    @MainThread
    public abstract void b(L l10);

    public long getPlayDuration() {
        return 0L;
    }

    public boolean jH() {
        return false;
    }

    public abstract void pause();

    @WorkerThread
    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z10, boolean z11) {
    }

    public void skipToEnd() {
    }
}
