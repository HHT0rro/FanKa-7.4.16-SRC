package com.cupidapp.live.chat2.model;

import com.cupidapp.live.chat2.view.ChatEmojiType;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSendEmojiMessageEvent {

    @NotNull
    private final String textMessage;

    @NotNull
    private final ChatEmojiType type;

    public ChatSendEmojiMessageEvent(@NotNull ChatEmojiType type, @NotNull String textMessage) {
        s.i(type, "type");
        s.i(textMessage, "textMessage");
        this.type = type;
        this.textMessage = textMessage;
    }

    @NotNull
    public final String getTextMessage() {
        return this.textMessage;
    }

    @NotNull
    public final ChatEmojiType getType() {
        return this.type;
    }
}
