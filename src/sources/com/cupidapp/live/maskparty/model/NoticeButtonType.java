package com.cupidapp.live.maskparty.model;

import kotlin.d;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum NoticeButtonType {
    Ordinary(0),
    Agree(1),
    Aloha(2),
    Reedit(3);

    private final int type;

    NoticeButtonType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
