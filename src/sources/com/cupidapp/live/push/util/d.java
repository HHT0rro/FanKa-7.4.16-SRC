package com.cupidapp.live.push.util;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PushSoundUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f17905a = new d();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Ringtone f17906b;

    public final void a(@NotNull Context context, boolean z10, boolean z11, @Nullable Uri uri) {
        s.i(context, "context");
        if (z11) {
            c(context, z10, uri);
        }
    }

    public final void b(@NotNull Context context, boolean z10) {
        s.i(context, "context");
        if (z10) {
            Object systemService = context.getSystemService("vibrator");
            s.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            AudioAttributes build = new AudioAttributes.Builder().setContentType(4).setUsage(4).build();
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createWaveform(new long[]{0, 200, 200, 200}, -1), build);
            } else {
                vibrator.vibrate(new long[]{0, 200, 200, 200}, -1, build);
            }
        }
    }

    public final void c(Context context, boolean z10, Uri uri) {
        Ringtone ringtone;
        try {
            if (!z10 && uri != null) {
                ringtone = RingtoneManager.getRingtone(context, uri);
            } else {
                ringtone = RingtoneManager.getRingtone(context, RingtoneManager.getActualDefaultRingtoneUri(context, 2));
            }
            f17906b = ringtone;
            if (ringtone != null) {
                ringtone.play();
            }
        } catch (Exception unused) {
        }
    }
}
