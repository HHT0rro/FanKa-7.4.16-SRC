package com.cupidapp.live.maskparty.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MaskPartyChatMessageType {
    InboxMessageText("inboxMessageText"),
    InboxMessageImage("inboxMessageImage"),
    InboxMessageSnapImage("inboxMessageSnapImage"),
    InboxMessageNotice("inboxMessageNotice"),
    InboxMessageDice("inboxMessageDice");


    @NotNull
    private final String value;

    MaskPartyChatMessageType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
