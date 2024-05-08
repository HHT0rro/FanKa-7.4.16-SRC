package com.cupidapp.live.mediapicker.model;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FrameViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    @NotNull
    public static final String a(@Nullable Float f10) {
        return s.b(f10, 0.75f) ? "3:4" : s.b(f10, 1.0f) ? "1:1" : s.b(f10, 1.3333334f) ? "4:3" : s.b(f10, 1.7777778f) ? "16:9" : "其他";
    }
}
