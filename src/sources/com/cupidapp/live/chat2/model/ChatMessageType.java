package com.cupidapp.live.chat2.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ChatMessageType {
    InboxMessageText("inboxMessageText"),
    InboxMessageSnapText("inboxMessageSnapText"),
    InboxMessageImage("inboxMessageImage"),
    InboxMessageSnapImage("inboxMessageSnapImage"),
    InboxMessageNotice("inboxMessageNotice"),
    InboxMessagePostReferer("inboxMessagePostReferer"),
    InboxMessageRich("inboxMessageRich"),
    InboxMessageScreenCaptureNotice("inboxMessageScreenCaptureNotice"),
    InboxMessageUserLabel("inboxMessageUserLabel"),
    InboxMessageChatStatusGreet("inboxMessageChatStatusGreet"),
    InboxMessagePostLimitReferer("inboxMessagePostLimitReferer"),
    InboxMessageMarket("marketingMessage");


    @NotNull
    private final String value;

    ChatMessageType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
