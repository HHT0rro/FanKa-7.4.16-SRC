package com.cupidapp.live.mediapicker.helper;

import io.microshow.rxffmpeg.RxFFmpegSubscriber;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKFFmpegSubscriber.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends RxFFmpegSubscriber {
    public void onCancel() {
    }

    public void onError(@NotNull String message) {
        s.i(message, "message");
    }

    public void onFinish() {
    }

    public void onProgress(int i10, long j10) {
    }
}
