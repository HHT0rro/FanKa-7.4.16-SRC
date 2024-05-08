package com.cupidapp.live.base.utils;

import androidx.annotation.DrawableRes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetWorkDrawableHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LocalImageModel extends ImageSizeModel {
    private final int resource;

    public /* synthetic */ LocalImageModel(int i10, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? null : function0);
    }

    public final int getResource() {
        return this.resource;
    }

    public LocalImageModel(@DrawableRes int i10, @Nullable Function0<kotlin.p> function0) {
        super(function0);
        this.resource = i10;
    }
}
