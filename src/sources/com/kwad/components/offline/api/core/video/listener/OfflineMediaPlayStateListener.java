package com.kwad.components.offline.api.core.video.listener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface OfflineMediaPlayStateListener {
    void onMediaPlayCompleted();

    void onMediaPlayError(int i10, int i11);

    void onMediaPlayPaused();

    void onMediaPlayProgress(long j10, long j11);

    void onMediaPlayStart();

    void onMediaPlaying();

    void onMediaPrepared();

    void onMediaPreparing();
}
