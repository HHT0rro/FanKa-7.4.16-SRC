package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogShare.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ShareBtnPos {
    ShareTopBtn("头部更多按钮"),
    ShareBottomBtn("操作区分享按钮");


    @NotNull
    private final String value;

    ShareBtnPos(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
