package com.bef.effectsdk;

import android.media.MediaPlayer;
import h0.a;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AudioPlayer {
    public static final String TAG = "AudioPlayer";
    private long mNativePtr;
    private MediaPlayer mMediaPlayer = null;
    private boolean mIsPrepared = false;
    private String mFilename = null;

    @a
    public AudioPlayer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @a
    public native void nativeOnCompletion(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    @a
    public native void nativeOnError(long j10, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    @a
    public native void nativeOnInfo(long j10, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    @a
    public native void nativeOnPrepared(long j10);

    @a
    public float getCurrentPlayTime() {
        if (this.mMediaPlayer == null) {
            return 0.0f;
        }
        return r0.getCurrentPosition() / 1000.0f;
    }

    @a
    public float getTotalPlayTime() {
        if (this.mMediaPlayer == null) {
            return 0.0f;
        }
        return r0.getDuration() / 1000.0f;
    }

    @a
    public int init() {
        this.mIsPrepared = false;
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
        }
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mMediaPlayer = mediaPlayer2;
        mediaPlayer2.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.bef.effectsdk.AudioPlayer.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer3, int i10, int i11) {
                String str = AudioPlayer.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MediaPlayer onInfo: [what, extra] = [");
                sb2.append(i10);
                sb2.append(", ");
                sb2.append(i11);
                sb2.append("]");
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnInfo(audioPlayer.mNativePtr, i10, i11);
                return false;
            }
        });
        this.mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.bef.effectsdk.AudioPlayer.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer3, int i10, int i11) {
                String str = AudioPlayer.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MediaPlayer onError: [what, extra] = [");
                sb2.append(i10);
                sb2.append(", ");
                sb2.append(i11);
                sb2.append("]");
                try {
                    AudioPlayer.this.mMediaPlayer.stop();
                    AudioPlayer.this.mMediaPlayer.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    String str2 = AudioPlayer.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("MediaPlayer stop exception on error ");
                    sb3.append(e2.toString());
                }
                AudioPlayer.this.mMediaPlayer = null;
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnError(audioPlayer.mNativePtr, i10, i11);
                return false;
            }
        });
        this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bef.effectsdk.AudioPlayer.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer3) {
                String str = AudioPlayer.TAG;
                AudioPlayer.this.mIsPrepared = true;
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnPrepared(audioPlayer.mNativePtr);
            }
        });
        this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.bef.effectsdk.AudioPlayer.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer3) {
                String str = AudioPlayer.TAG;
                AudioPlayer audioPlayer = AudioPlayer.this;
                audioPlayer.nativeOnCompletion(audioPlayer.mNativePtr);
            }
        });
        return 0;
    }

    @a
    public boolean isPlaying() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !this.mIsPrepared) {
            return false;
        }
        try {
            return mediaPlayer.isPlaying();
        } catch (Exception e2) {
            e2.printStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MediaPlayer isPlaying exception. ");
            sb2.append(e2.toString());
            return false;
        }
    }

    @a
    public boolean pause() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !this.mIsPrepared) {
            return false;
        }
        mediaPlayer.pause();
        return true;
    }

    @a
    public int release() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return 0;
        }
        try {
            mediaPlayer.stop();
            this.mMediaPlayer.release();
        } catch (Exception e2) {
            e2.printStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MediaPlayer stop exception on release ");
            sb2.append(e2.toString());
        }
        this.mMediaPlayer = null;
        return 0;
    }

    @a
    public boolean resume() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !this.mIsPrepared) {
            return false;
        }
        mediaPlayer.start();
        return true;
    }

    @a
    public boolean seek(int i10) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !this.mIsPrepared) {
            return false;
        }
        try {
            mediaPlayer.seekTo(i10);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MediaPlayer seek exception. ");
            sb2.append(e2.toString());
            return true;
        }
    }

    @a
    public void setDataSource(String str) {
        if (this.mMediaPlayer == null) {
            init();
        }
        if (str.equals(this.mFilename) && this.mIsPrepared && this.mMediaPlayer.isPlaying()) {
            return;
        }
        try {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.setDataSource(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MediaPlayer setDataSource exception. ");
            sb2.append(e2.toString());
        }
        this.mFilename = str;
    }

    @a
    public boolean setLoop(boolean z10) {
        if (this.mMediaPlayer == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set isLoop ");
        sb2.append(z10);
        this.mMediaPlayer.setLooping(z10);
        return true;
    }

    @a
    public void setNativePtr(long j10) {
        this.mNativePtr = j10;
    }

    @a
    public boolean setVolume(float f10) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null || !this.mIsPrepared) {
            return false;
        }
        mediaPlayer.setVolume(f10, f10);
        return true;
    }

    @a
    public void startPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        try {
            if (!this.mIsPrepared) {
                mediaPlayer.prepare();
                this.mIsPrepared = true;
            }
            this.mMediaPlayer.start();
        } catch (Exception e2) {
            e2.printStackTrace();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MediaPlayer setDataSource exception. ");
            sb2.append(e2.toString());
        }
    }

    @a
    public void stopPlay() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && this.mIsPrepared) {
            try {
                mediaPlayer.stop();
                this.mMediaPlayer.release();
            } catch (Exception e2) {
                e2.printStackTrace();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MediaPlayer stop exception on stop ");
                sb2.append(e2.toString());
            }
            this.mMediaPlayer = null;
            this.mIsPrepared = false;
        }
    }
}
