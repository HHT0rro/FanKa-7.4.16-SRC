package com.amazing.media;

import android.media.MediaPlayer;
import h0.a;
import java.io.IOException;

@a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AudioPlayer {

    /* renamed from: a, reason: collision with root package name */
    public MediaPlayer f9143a = new MediaPlayer();

    /* renamed from: b, reason: collision with root package name */
    public String f9144b;

    @a
    public AudioPlayer(String str) {
        this.f9144b = str;
    }

    @a
    public void destroy() {
        MediaPlayer mediaPlayer = this.f9143a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f9143a.release();
            this.f9143a = null;
        }
    }

    @a
    public boolean isPlaying() {
        return this.f9143a.isPlaying();
    }

    @a
    public void pause() {
        this.f9143a.pause();
    }

    @a
    public void play() {
        this.f9143a.reset();
        if (prepare()) {
            this.f9143a.start();
        }
    }

    @a
    public boolean prepare() {
        try {
            this.f9143a.setDataSource(this.f9144b);
            this.f9143a.setAudioStreamType(3);
            this.f9143a.prepare();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @a
    public void resume() {
        this.f9143a.start();
    }

    @a
    public void setLoop(boolean z10) {
        this.f9143a.setLooping(z10);
    }

    @a
    public void stop() {
        this.f9143a.stop();
    }
}
