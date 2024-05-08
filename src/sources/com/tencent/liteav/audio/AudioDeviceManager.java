package com.tencent.liteav.audio;

import android.media.AudioManager;
import com.android.internal.os.PowerProfile;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::audio")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AudioDeviceManager {
    private static final String TAG = "AudioDeviceManager";
    private AudioManager mAudioManager;

    @CalledByNative
    public AudioDeviceManager() {
    }

    private synchronized AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(PowerProfile.POWER_AUDIO);
        }
        return this.mAudioManager;
    }

    @CalledByNative
    private int getAudioMode() {
        try {
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                return audioManager.getMode();
            }
            return -1;
        } catch (Exception e2) {
            Log.i(TAG, "Exception occurs in getAudioMode " + e2.getMessage(), new Object[0]);
            return -1;
        }
    }

    @CalledByNative
    private int getStreamMaxVolume(int i10) {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(i10);
        }
        return 0;
    }

    @CalledByNative
    private int getStreamVolume(int i10) {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            return audioManager.getStreamVolume(i10);
        }
        return 0;
    }

    @CalledByNative
    private int getSystemVolume() {
        try {
            int i10 = getAudioMode() == 0 ? 3 : 0;
            AudioManager audioManager = getAudioManager();
            if (audioManager != null) {
                return audioManager.getStreamVolume(i10);
            }
            return -1;
        } catch (Exception e2) {
            Log.i(TAG, "Exception occurs in getSystemVolume " + e2.getMessage(), new Object[0]);
            return -1;
        }
    }

    @CalledByNative
    private void setStreamVolume(int i10, int i11, int i12) {
        AudioManager audioManager = getAudioManager();
        if (audioManager != null) {
            audioManager.setStreamVolume(i10, i11, i12);
        }
    }
}
