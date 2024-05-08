package com.wangmai.common.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.wangmai.common.utils.DebugLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CustomVideoView2 extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    public static final String TAG = CustomVideoView2.class.getSimpleName();
    public MediaPlayer.OnCompletionListener completionListener;
    public Context context;
    public MediaPlayer.OnErrorListener errorListener;
    public boolean isCompleted;
    public Surface mSurface;
    public int mVideoHeight;
    public int mVideoWidth;
    public MediaPlayer mediaPlayer;
    public MediaPlayer.OnPreparedListener preparedListener;
    public SurfaceTexture surfaceTexture;
    public String videoPath;
    public boolean volumeOff;

    public CustomVideoView2(Context context) {
        super(context);
        this.isCompleted = false;
        this.volumeOff = true;
        this.context = context;
        init();
    }

    private void init() {
        initTextureView();
    }

    private void initTextureView() {
        setSurfaceTextureListener(this);
    }

    private void removeViewFromParent() {
        if (getParent() == null || !(getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) getParent()).removeView(this);
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public boolean isVolumeOff() {
        return this.volumeOff;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.isCompleted = true;
        MediaPlayer.OnCompletionListener onCompletionListener = this.completionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(mediaPlayer);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        DebugLog.W(TAG, "视频播放错误！");
        MediaPlayer.OnErrorListener onErrorListener = this.errorListener;
        if (onErrorListener == null) {
            return false;
        }
        onErrorListener.onError(mediaPlayer, i10, i11);
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        try {
            setMeasuredDimension(TextureView.getDefaultSize(this.mVideoWidth, i10), TextureView.getDefaultSize(this.mVideoHeight, i11));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            this.isCompleted = false;
            MediaPlayer.OnPreparedListener onPreparedListener = this.preparedListener;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(mediaPlayer);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        try {
            this.surfaceTexture = surfaceTexture;
            this.mSurface = new Surface(this.surfaceTexture);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.reset();
            this.mediaPlayer.setSurface(this.mSurface);
            this.mediaPlayer.setDataSource(this.videoPath);
            this.mediaPlayer.setOnPreparedListener(this);
            this.mediaPlayer.setOnCompletionListener(this);
            this.mediaPlayer.setOnErrorListener(this);
            this.mediaPlayer.prepareAsync();
        } catch (Throwable th) {
            DebugLog.W(TAG, "onSurfaceTextureAvailable error:" + th.toString());
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        try {
            this.isCompleted = false;
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture2 = this.surfaceTexture;
            if (surfaceTexture2 != null) {
                surfaceTexture2.release();
                this.surfaceTexture = null;
            }
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null) {
                return true;
            }
            mediaPlayer.release();
            return true;
        } catch (Throwable th) {
            DebugLog.W(TAG, "TextureDestroyed " + th.toString());
            return true;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.mediaPlayer.pause();
        } catch (Throwable th) {
            DebugLog.W(TAG, "pause " + th.toString());
        }
    }

    public void release() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.mediaPlayer = null;
            }
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.surfaceTexture = null;
            }
            removeViewFromParent();
        } catch (Throwable th) {
            DebugLog.W(TAG, "release " + th.toString());
        }
    }

    public void seekTo(int i10) {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(i10);
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "seek " + th.toString());
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.completionListener = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.errorListener = onErrorListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.preparedListener = onPreparedListener;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVolume(int i10) {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                float f10 = i10;
                mediaPlayer.setVolume(f10, f10);
            }
            setVolumeOff(i10 == 0);
        } catch (Throwable th) {
            DebugLog.W(TAG, "setVolume " + th.toString());
        }
    }

    public void setVolumeOff(boolean z10) {
        this.volumeOff = z10;
    }

    public void startVideo() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null || mediaPlayer.isPlaying()) {
                return;
            }
            this.mediaPlayer.start();
        } catch (Throwable th) {
            DebugLog.W(TAG, "start " + th.toString());
        }
    }

    public void stopPlayback() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
        } catch (Throwable th) {
            DebugLog.W(TAG, "stop " + th.toString());
        }
    }

    public CustomVideoView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isCompleted = false;
        this.volumeOff = true;
        this.context = context;
        init();
    }

    public CustomVideoView2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.isCompleted = false;
        this.volumeOff = true;
        this.context = context;
        init();
    }
}
