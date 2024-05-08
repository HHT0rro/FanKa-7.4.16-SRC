package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveFunctionMenuModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveFunctionMenuType {
    RectangleType("rectangle"),
    SquareType("square");


    @NotNull
    private final String type;

    LiveFunctionMenuType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
