package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMeReadOtherMessageEvent {

    @NotNull
    private final ChatMessageModel message;

    public ChatMeReadOtherMessageEvent(@NotNull ChatMessageModel message) {
        s.i(message, "message");
        this.message = message;
    }

    @NotNull
    public final ChatMessageModel getMessage() {
        return this.message;
    }
}
