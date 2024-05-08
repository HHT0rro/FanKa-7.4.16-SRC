package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.os.Vibrator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IVibratorUtil {
    void cancelVibrate(Context context, Vibrator vibrator);

    void vibrate(Context context, Vibrator vibrator, long j10);
}
