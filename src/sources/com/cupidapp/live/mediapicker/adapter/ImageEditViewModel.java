package com.cupidapp.live.mediapicker.adapter;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ImageEditAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageEditViewModel implements Serializable {
    private float frameSize;

    @NotNull
    private String path;

    public ImageEditViewModel(@NotNull String path, float f10) {
        s.i(path, "path");
        this.path = path;
        this.frameSize = f10;
    }

    public final float getFrameSize() {
        return this.frameSize;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final void setFrameSize(float f10) {
        this.frameSize = f10;
    }

    public final void setPath(@NotNull String str) {
        s.i(str, "<set-?>");
        this.path = str;
    }
}
