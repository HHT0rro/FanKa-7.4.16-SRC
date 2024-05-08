package com.huawei.quickcard.video;

import android.widget.MediaController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ITextureVideoView extends MediaController.MediaPlayerControl {
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface AudioFocusListener {
        void onAudioFocusChange(int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface VideoStateListener {
        void onCompletion();

        boolean onError(int i10, int i11);

        void onIdle();

        void onInfo(int i10);

        void onPause();

        void onPlaying();

        void onPrepared();

        void onPreparing();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface VideoSurfaceTextureListener {
        void onVideoSurfaceTextureAvailable();

        void onVideoSurfaceTextureDestroyed();
    }

    boolean canSeek();

    void destroy();

    int getCurrentState();

    int getTargetState();

    String getVideoURI();

    void openVideoURI(String str);

    void resume();

    void setAudioFocusListener(AudioFocusListener audioFocusListener);

    void setMuted(boolean z10);

    void setObjectFitType(String str);

    void setShouldReleaseSurface(boolean z10);

    void setVideoStateListener(VideoStateListener videoStateListener);

    void setVideoSurfaceTextureListener(VideoSurfaceTextureListener videoSurfaceTextureListener);

    void setVideoURI(String str);

    void stopPlayback();

    void suspend();
}
