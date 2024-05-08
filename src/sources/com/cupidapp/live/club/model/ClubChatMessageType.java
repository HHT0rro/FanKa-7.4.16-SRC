package com.cupidapp.live.club.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ClubChatMessageType {
    InboxMessageText("inboxMessageText"),
    InboxMessageImage("inboxMessageImage"),
    InboxMessageNotice("inboxMessageNotice"),
    InboxMessageRedPacket("inboxMessageRedPacket"),
    InboxMessageActivity("inboxMessageActivity");


    @NotNull
    private final String value;

    ClubChatMessageType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
