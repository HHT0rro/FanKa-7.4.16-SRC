package com.cupidapp.live.chat2.model;

import kotlin.d;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum SurveyChatMessageType {
    TextMessage(1),
    OptionsMessage(2),
    SystemMessage(3);

    private final int value;

    SurveyChatMessageType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
