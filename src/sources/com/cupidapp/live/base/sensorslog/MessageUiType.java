package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogChat.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum MessageUiType {
    BigRich("大图文"),
    SmallRich("小图文"),
    SmallTitle("无图小标题"),
    OnlyText("纯文本");


    @NotNull
    private final String value;

    MessageUiType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
