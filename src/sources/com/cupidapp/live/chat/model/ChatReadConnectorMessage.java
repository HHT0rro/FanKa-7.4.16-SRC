package com.cupidapp.live.chat.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MessageModels.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatReadConnectorMessage {

    @NotNull
    private final List<String> messageIds;

    @NotNull
    private final String sessionId;

    public ChatReadConnectorMessage(@NotNull String sessionId, @NotNull List<String> messageIds) {
        s.i(sessionId, "sessionId");
        s.i(messageIds, "messageIds");
        this.sessionId = sessionId;
        this.messageIds = messageIds;
    }

    @NotNull
    public final List<String> getMessageIds() {
        return this.messageIds;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }
}
