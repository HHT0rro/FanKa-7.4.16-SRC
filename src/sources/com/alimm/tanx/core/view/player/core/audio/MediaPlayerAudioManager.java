package com.alimm.tanx.core.view.player.core.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.android.internal.os.PowerProfile;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MediaPlayerAudioManager implements IAudioManager {
    public final AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
    public AudioFocusRequest audioFocusRequest;
    public final AudioManager audioManager;
    public final Context context;
    public final ITanxPlayer iTanxPlayer;
    public final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    public MediaPlayerAudioManager(Context context, ITanxPlayer iTanxPlayer) {
        this.context = context;
        this.iTanxPlayer = iTanxPlayer;
        this.audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
        this.onAudioFocusChangeListener = new DefaultAudioFocusChangeListener(new WeakReference(context), this, iTanxPlayer);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void abandonAudioFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
            if (audioFocusRequest != null) {
                this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
                return;
            }
            return;
        }
        this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getVolume() {
        return this.audioManager.getStreamVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void mute() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(0.0f);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void requestAudioFocus() {
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest build = new AudioFocusRequest.Builder(1).setAudioAttributes(this.audioAttributes).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.onAudioFocusChangeListener).build();
            this.audioFocusRequest = build;
            this.audioManager.requestAudioFocus(build);
            return;
        }
        this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void setVolume(int i10) {
        if (i10 >= 1) {
            this.iTanxPlayer.setVolume(1.0f);
        } else {
            this.iTanxPlayer.setVolume(i10);
        }
    }
}
