package io.microshow.rxffmpeg.player;

import android.view.Surface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IMediaPlayer {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnErrorListener {
        void onError(IMediaPlayer iMediaPlayer, int i10, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnLoadingListener {
        void onLoading(IMediaPlayer iMediaPlayer, boolean z10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer iMediaPlayer);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnTimeUpdateListener {
        void onTimeUpdate(IMediaPlayer iMediaPlayer, int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i10, int i11, float f10);
    }

    int getDuration();

    int getMuteSolo();

    int getVolume();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    void prepare();

    void release();

    void resume();

    void seekTo(int i10);

    void setDataSource(String str);

    void setLooping(boolean z10);

    void setMuteSolo(int i10);

    void setSurface(Surface surface);

    void setVolume(int i10);

    void start();

    void stop();
}
