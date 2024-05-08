package com.cupidapp.live.maskparty.model;

import kotlin.d;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum RemoveMessageType {
    Cancel(1),
    Destroy(2);

    private final int type;

    RemoveMessageType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
