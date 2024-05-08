package com.cupidapp.live.base.utils;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetWorkDrawableHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImageWithHeightModel extends ImageSizeModel {
    private final int height;

    @NotNull
    private final ImageModel imageModel;

    public /* synthetic */ ImageWithHeightModel(ImageModel imageModel, int i10, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageModel, i10, (i11 & 4) != 0 ? null : function0);
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final ImageModel getImageModel() {
        return this.imageModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithHeightModel(@NotNull ImageModel imageModel, int i10, @Nullable Function0<kotlin.p> function0) {
        super(function0);
        kotlin.jvm.internal.s.i(imageModel, "imageModel");
        this.imageModel = imageModel;
        this.height = i10;
    }
}
