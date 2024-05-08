package com.cupidapp.live.setting.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKCropImageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKCropImageModel implements Serializable {
    private final boolean cropSquare;

    @Nullable
    private final String mediaContentPath;

    public FKCropImageModel(@Nullable String str, boolean z10) {
        this.mediaContentPath = str;
        this.cropSquare = z10;
    }

    public final boolean getCropSquare() {
        return this.cropSquare;
    }

    @Nullable
    public final String getMediaContentPath() {
        return this.mediaContentPath;
    }

    public /* synthetic */ FKCropImageModel(String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? false : z10);
    }
}
