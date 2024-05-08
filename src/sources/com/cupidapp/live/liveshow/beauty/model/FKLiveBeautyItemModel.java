package com.cupidapp.live.liveshow.beauty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveBeautyItemModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FKLiveBeautyItemModel {

    @NotNull
    private final FKLiveBeautyButtonEnum buttonType;

    public FKLiveBeautyItemModel(@NotNull FKLiveBeautyButtonEnum buttonType) {
        s.i(buttonType, "buttonType");
        this.buttonType = buttonType;
    }

    @NotNull
    public FKLiveBeautyButtonEnum getButtonType() {
        return this.buttonType;
    }
}
