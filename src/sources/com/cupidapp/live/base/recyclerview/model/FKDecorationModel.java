package com.cupidapp.live.base.recyclerview.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FKDecorationModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKDecorationModel {
    private final int height;
    private final int lineColor;

    public FKDecorationModel(int i10, int i11) {
        this.height = i10;
        this.lineColor = i11;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLineColor() {
        return this.lineColor;
    }

    public /* synthetic */ FKDecorationModel(int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i12 & 2) != 0 ? -855310 : i11);
    }
}
