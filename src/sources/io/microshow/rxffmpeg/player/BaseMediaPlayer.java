package io.microshow.rxffmpeg.player;

import android.view.TextureView;
import io.microshow.rxffmpeg.player.IMediaPlayer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseMediaPlayer implements IMediaPlayer {
    public IMediaPlayer.OnCompletionListener mOnCompletionListener;
    public IMediaPlayer.OnErrorListener mOnErrorListener;
    public IMediaPlayer.OnLoadingListener mOnLoadingListener;
    public IMediaPlayer.OnPreparedListener mOnPreparedListener;
    public IMediaPlayer.OnTimeUpdateListener mOnTimeUpdateListener;
    public IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    public abstract void play(String str, boolean z10);

    public abstract void repeatPlay();

    public void setOnCompleteListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnLoadingListener(IMediaPlayer.OnLoadingListener onLoadingListener) {
        this.mOnLoadingListener = onLoadingListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnTimeUpdateListener(IMediaPlayer.OnTimeUpdateListener onTimeUpdateListener) {
        this.mOnTimeUpdateListener = onTimeUpdateListener;
    }

    public void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public abstract void setTextureView(TextureView textureView);
}
