package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogMiniLiveShow.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum MiniWindowCloseMethod {
    CloseMethodClickMiniLive("小窗回到直播"),
    CloseMethodClickClose("点击小窗关闭按钮"),
    CloseMethodEnterLive("进入其他直播间"),
    CloseMethodEnterMatch("进入匹配页面"),
    CloseMethodOther("其他被动关闭");


    @NotNull
    private final String value;

    MiniWindowCloseMethod(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
