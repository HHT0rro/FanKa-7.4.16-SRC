package com.cupidapp.live.base.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.android.internal.os.PowerProfile;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioControlManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public AudioManager f12301a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AudioFocusRequest f12302b;

    public d(@Nullable Context context) {
        Object systemService = context != null ? context.getSystemService(PowerProfile.POWER_AUDIO) : null;
        this.f12301a = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f12302b = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).build();
        }
    }

    public final void a() {
        AudioManager audioManager;
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.f12302b;
            if (audioFocusRequest == null || (audioManager = this.f12301a) == null) {
                return;
            }
            audioManager.abandonAudioFocusRequest(audioFocusRequest);
            return;
        }
        AudioManager audioManager2 = this.f12301a;
        if (audioManager2 != null) {
            audioManager2.abandonAudioFocus(null);
        }
    }

    public final void b() {
        AudioManager audioManager;
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.f12302b;
            if (audioFocusRequest == null || (audioManager = this.f12301a) == null) {
                return;
            }
            audioManager.requestAudioFocus(audioFocusRequest);
            return;
        }
        AudioManager audioManager2 = this.f12301a;
        if (audioManager2 != null) {
            audioManager2.requestAudioFocus(null, 3, 1);
        }
    }
}
