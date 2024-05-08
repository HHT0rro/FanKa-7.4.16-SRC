package io.microshow.rxffmpeg.player;

import android.media.MediaPlayer;
import android.os.Build;
import android.view.Surface;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class SystemMediaPlayer extends BaseMediaPlayer {
    private Disposable mTimeUpdateDisposable;
    public String path;
    public int volumePercent = -1;
    public MediaPlayer mMediaPlayer = new MediaPlayer();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private void cancelTimeUpdateDisposable() {
        Disposable disposable = this.mTimeUpdateDisposable;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.mTimeUpdateDisposable.dispose();
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public int getMuteSolo() {
        return 0;
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public int getVolume() {
        return this.volumePercent;
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public boolean isLooping() {
        return this.mMediaPlayer.isLooping();
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void pause() {
        this.mMediaPlayer.pause();
        cancelTimeUpdateDisposable();
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void prepare() {
        this.mMediaPlayer.prepareAsync();
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void release() {
        setOnPreparedListener(null);
        setOnVideoSizeChangedListener(null);
        setOnLoadingListener(null);
        setOnTimeUpdateListener(null);
        setOnErrorListener(null);
        setOnCompleteListener(null);
        cancelTimeUpdateDisposable();
        CompositeDisposable compositeDisposable = this.mCompositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
            this.mCompositeDisposable = null;
        }
        this.mMediaPlayer.release();
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void repeatPlay() {
        play(this.path, this.mMediaPlayer.isLooping());
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void resume() {
        start();
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void seekTo(int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mMediaPlayer.seekTo(i10, 3);
        } else {
            this.mMediaPlayer.seekTo(i10);
        }
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void setDataSource(String str) {
        try {
            this.path = str;
            this.mMediaPlayer.setDataSource(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void setLooping(boolean z10) {
        this.mMediaPlayer.setLooping(z10);
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void setMuteSolo(int i10) {
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void setOnCompleteListener(final IMediaPlayer.OnCompletionListener onCompletionListener) {
        super.setOnCompleteListener(onCompletionListener);
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: io.microshow.rxffmpeg.player.SystemMediaPlayer.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                IMediaPlayer.OnCompletionListener onCompletionListener2 = onCompletionListener;
                if (onCompletionListener2 != null) {
                    onCompletionListener2.onCompletion(SystemMediaPlayer.this);
                }
            }
        });
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void setOnErrorListener(final IMediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: io.microshow.rxffmpeg.player.SystemMediaPlayer.3
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
                IMediaPlayer.OnErrorListener onErrorListener2 = onErrorListener;
                if (onErrorListener2 == null || i10 == -38) {
                    return true;
                }
                onErrorListener2.onError(SystemMediaPlayer.this, i10, i11 + "");
                return true;
            }
        });
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void setOnLoadingListener(IMediaPlayer.OnLoadingListener onLoadingListener) {
        super.setOnLoadingListener(onLoadingListener);
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void setOnPreparedListener(final IMediaPlayer.OnPreparedListener onPreparedListener) {
        super.setOnPreparedListener(onPreparedListener);
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: io.microshow.rxffmpeg.player.SystemMediaPlayer.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                IMediaPlayer.OnPreparedListener onPreparedListener2 = onPreparedListener;
                if (onPreparedListener2 != null) {
                    onPreparedListener2.onPrepared(SystemMediaPlayer.this);
                }
            }
        });
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void setOnTimeUpdateListener(IMediaPlayer.OnTimeUpdateListener onTimeUpdateListener) {
        super.setOnTimeUpdateListener(onTimeUpdateListener);
        this.mMediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: io.microshow.rxffmpeg.player.SystemMediaPlayer.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
                if (i10 == 3 || i10 == 700) {
                    SystemMediaPlayer systemMediaPlayer = SystemMediaPlayer.this;
                    IMediaPlayer.OnLoadingListener onLoadingListener = systemMediaPlayer.mOnLoadingListener;
                    if (onLoadingListener != null) {
                        onLoadingListener.onLoading(systemMediaPlayer, false);
                    }
                    return true;
                }
                if (i10 != 701) {
                    return false;
                }
                SystemMediaPlayer systemMediaPlayer2 = SystemMediaPlayer.this;
                IMediaPlayer.OnLoadingListener onLoadingListener2 = systemMediaPlayer2.mOnLoadingListener;
                if (onLoadingListener2 != null) {
                    onLoadingListener2.onLoading(systemMediaPlayer2, true);
                }
                return true;
            }
        });
    }

    @Override // io.microshow.rxffmpeg.player.BaseMediaPlayer
    public void setOnVideoSizeChangedListener(final IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        super.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        this.mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: io.microshow.rxffmpeg.player.SystemMediaPlayer.2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i10, int i11) {
                IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener2 = onVideoSizeChangedListener;
                if (onVideoSizeChangedListener2 != null) {
                    onVideoSizeChangedListener2.onVideoSizeChanged(SystemMediaPlayer.this, i10, i11, i10 / i11);
                }
            }
        });
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void setSurface(Surface surface) {
        if (surface != null) {
            this.mMediaPlayer.setSurface(surface);
        }
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void setVolume(int i10) {
        this.volumePercent = i10;
        float f10 = i10 / 100.0f;
        this.mMediaPlayer.setVolume(f10, f10);
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void start() {
        this.mMediaPlayer.start();
        startTimeUpdateDisposable();
    }

    public void startTimeUpdateDisposable() {
        cancelTimeUpdateDisposable();
        Disposable subscribe = Flowable.interval(200L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() { // from class: io.microshow.rxffmpeg.player.SystemMediaPlayer.6
            @Override // io.reactivex.functions.Consumer
            public void accept(Long l10) throws Exception {
                SystemMediaPlayer systemMediaPlayer = SystemMediaPlayer.this;
                IMediaPlayer.OnTimeUpdateListener onTimeUpdateListener = systemMediaPlayer.mOnTimeUpdateListener;
                if (onTimeUpdateListener != null) {
                    onTimeUpdateListener.onTimeUpdate(systemMediaPlayer, systemMediaPlayer.mMediaPlayer.getCurrentPosition() / 1000, SystemMediaPlayer.this.getDuration() / 1000);
                }
            }
        });
        this.mTimeUpdateDisposable = subscribe;
        this.mCompositeDisposable.add(subscribe);
    }

    @Override // io.microshow.rxffmpeg.player.IMediaPlayer
    public void stop() {
        this.mMediaPlayer.stop();
    }
}
