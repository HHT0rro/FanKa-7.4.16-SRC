package com.cupidapp.live.maskparty.model;

import kotlin.d;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum HangUpPopupType {
    HangUpConfirm(1),
    KickRoom(2),
    OtherKickRoom(3);

    private final int type;

    HangUpPopupType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
