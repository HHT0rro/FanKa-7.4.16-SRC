package com.alimm.tanx.core.view.player.core;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxPlayer {
    ITanxPlayer create();

    int getBufferPercent();

    long getCurrentPosition();

    long getDuration();

    PlayerState getState();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    boolean isPlayWhenReady();

    boolean isPlaying();

    void pause();

    void prepare();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(long j10);

    void setDataSource(Context context, Uri uri);

    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(Context context, String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z10);

    void setOnVideoBufferingStateChangeListener(OnVideoBufferingListener onVideoBufferingListener);

    void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener);

    void setOnVideoSizeChangeListener(OnVideoSizeChangeListener onVideoSizeChangeListener);

    void setOnVideoStateChangeListener(OnVideoStateChangeListener onVideoStateChangeListener);

    void setPlayWhenReady(boolean z10);

    void setSurface(Surface surface);

    void setVolume(float f10);

    void start();

    void stop();
}
