package com.cupidapp.live.base.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetWorkDrawableHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ImageSizeModel {

    @Nullable
    private final Function0<kotlin.p> clickCallback;

    public ImageSizeModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ImageSizeModel(@Nullable Function0<kotlin.p> function0) {
        this.clickCallback = function0;
    }

    @Nullable
    public final Function0<kotlin.p> getClickCallback() {
        return this.clickCallback;
    }

    public /* synthetic */ ImageSizeModel(Function0 function0, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : function0);
    }
}
