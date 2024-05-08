package com.cupidapp.live.base.utils;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetWorkDrawableHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImageWithWidthModel extends ImageSizeModel {

    @NotNull
    private final ImageModel imageModel;
    private final int width;

    public /* synthetic */ ImageWithWidthModel(ImageModel imageModel, int i10, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageModel, i10, (i11 & 4) != 0 ? null : function0);
    }

    @NotNull
    public final ImageModel getImageModel() {
        return this.imageModel;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithWidthModel(@NotNull ImageModel imageModel, int i10, @Nullable Function0<kotlin.p> function0) {
        super(function0);
        kotlin.jvm.internal.s.i(imageModel, "imageModel");
        this.imageModel = imageModel;
        this.width = i10;
    }
}
