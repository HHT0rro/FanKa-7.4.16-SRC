package com.alimm.tanx.core.view.player.core.audio;

import android.content.Context;
import android.media.AudioManager;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.android.internal.os.PowerProfile;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DefaultAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
    public final WeakReference<Context> contextReference;
    public final IAudioManager iAudioManager;
    public final ITanxPlayer iTanxPlayer;
    public boolean playOnAudioFocus = true;

    public DefaultAudioFocusChangeListener(WeakReference<Context> weakReference, IAudioManager iAudioManager, ITanxPlayer iTanxPlayer) {
        this.contextReference = weakReference;
        this.iAudioManager = iAudioManager;
        this.iTanxPlayer = iTanxPlayer;
    }

    public int getCurrentVolume(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
        return (int) ((audioManager.getStreamVolume(3) * 1.0f) / audioManager.getStreamMaxVolume(3));
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i10) {
        Context context;
        if (this.iTanxPlayer == null || (context = this.contextReference.get()) == null) {
            return;
        }
        if (1 == i10) {
            if (this.playOnAudioFocus && !this.iTanxPlayer.isPlaying()) {
                this.iTanxPlayer.start();
            } else if (this.iTanxPlayer.isPlaying()) {
                this.iTanxPlayer.setVolume(getCurrentVolume(context));
            }
            this.playOnAudioFocus = false;
            return;
        }
        if (-3 == i10) {
            this.iTanxPlayer.setVolume(getCurrentVolume(context) * 0.8f);
            return;
        }
        if (-2 == i10) {
            if (this.iTanxPlayer.isPlaying()) {
                this.playOnAudioFocus = true;
                this.iTanxPlayer.pause();
                return;
            }
            return;
        }
        if (-1 == i10) {
            this.iAudioManager.abandonAudioFocus();
            this.playOnAudioFocus = false;
            this.iTanxPlayer.stop();
        }
    }
}
