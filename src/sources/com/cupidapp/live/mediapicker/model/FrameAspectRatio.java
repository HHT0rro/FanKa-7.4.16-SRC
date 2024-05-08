package com.cupidapp.live.mediapicker.model;

import org.jetbrains.annotations.Nullable;

/* compiled from: FrameViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum FrameAspectRatio {
    DEFAULT(0.0f, null),
    THREE_TO_FOUR(0.75f, "3:4"),
    ONE_TO_ONE(1.0f, "1:1"),
    FOUR_TO_THREE(1.3333334f, "4:3"),
    SIXTEEN_TO_NINE(1.7777778f, "16:9");

    private float ratio;

    @Nullable
    private final String scale;

    FrameAspectRatio(float f10, String str) {
        this.ratio = f10;
        this.scale = str;
    }

    public final float getRatio() {
        return this.ratio;
    }

    @Nullable
    public final String getScale() {
        return this.scale;
    }

    public final void setRatio(float f10) {
        this.ratio = f10;
    }
}
