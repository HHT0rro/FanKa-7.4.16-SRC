package com.alimm.tanx.core.view.player.core.audio;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IAudioManager {
    void abandonAudioFocus();

    int getMaxVolume();

    int getVolume();

    void mute();

    void requestAudioFocus();

    void setVolume(int i10);
}
