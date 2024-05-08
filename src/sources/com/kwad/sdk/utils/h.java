package com.kwad.sdk.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.android.internal.os.PowerProfile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    private AudioManager aBv;
    private AudioManager.OnAudioFocusChangeListener aOx = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i10) {
            if (h.this.hq == null) {
                return;
            }
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i10 < 0) {
                        h.this.hq.onAudioBeOccupied();
                    } else {
                        h.this.hq.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a hq;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public h(Context context) {
        this.aBv = (AudioManager) context.getSystemService(PowerProfile.POWER_AUDIO);
    }

    private AudioFocusRequest Lf() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.aOx).build();
    }

    public final boolean Le() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.aOx;
        if (onAudioFocusChangeListener != null && (audioManager = this.aBv) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 1 == audioManager.requestAudioFocus(Lf());
            }
            if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }

    public final void c(a aVar) {
        this.hq = aVar;
    }
}
