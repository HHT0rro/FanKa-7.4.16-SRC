package com.cupidapp.live.mediapicker.newmediapicker.util.thread;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadExecutor.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f17362b;

    public a(@Nullable String str) {
        this.f17362b = str;
    }

    @NotNull
    public String toString() {
        return "Thread [name:" + this.f17362b + "]";
    }
}
