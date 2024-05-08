package com.cupidapp.live.maskparty.model;

import kotlin.d;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MessageActionType {
    Ordinary(0),
    Prepare(1),
    Question(2),
    AutoInsertSysMessage(4);

    private final int type;

    MessageActionType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
