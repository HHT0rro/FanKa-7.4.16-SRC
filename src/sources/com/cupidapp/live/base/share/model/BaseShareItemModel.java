package com.cupidapp.live.base.share.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKShareModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseShareItemModel {

    @NotNull
    private final ShareBaseType type;

    public BaseShareItemModel(@NotNull ShareBaseType type) {
        s.i(type, "type");
        this.type = type;
    }

    @NotNull
    public final ShareBaseType getType() {
        return this.type;
    }
}
