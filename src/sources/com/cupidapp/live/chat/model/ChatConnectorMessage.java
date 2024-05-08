package com.cupidapp.live.chat.model;

import com.cupidapp.live.push.FKPushType;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageModels.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatConnectorMessage {

    @NotNull
    private final String messageId;

    @NotNull
    private final String sessionId;

    @NotNull
    private final FKPushType type;

    public ChatConnectorMessage(@NotNull FKPushType type, @NotNull String sessionId, @NotNull String messageId) {
        s.i(type, "type");
        s.i(sessionId, "sessionId");
        s.i(messageId, "messageId");
        this.type = type;
        this.sessionId = sessionId;
        this.messageId = messageId;
    }

    public static /* synthetic */ ChatConnectorMessage copy$default(ChatConnectorMessage chatConnectorMessage, FKPushType fKPushType, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKPushType = chatConnectorMessage.type;
        }
        if ((i10 & 2) != 0) {
            str = chatConnectorMessage.sessionId;
        }
        if ((i10 & 4) != 0) {
            str2 = chatConnectorMessage.messageId;
        }
        return chatConnectorMessage.copy(fKPushType, str, str2);
    }

    @NotNull
    public final FKPushType component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.sessionId;
    }

    @NotNull
    public final String component3() {
        return this.messageId;
    }

    @NotNull
    public final ChatConnectorMessage copy(@NotNull FKPushType type, @NotNull String sessionId, @NotNull String messageId) {
        s.i(type, "type");
        s.i(sessionId, "sessionId");
        s.i(messageId, "messageId");
        return new ChatConnectorMessage(type, sessionId, messageId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatConnectorMessage)) {
            return false;
        }
        ChatConnectorMessage chatConnectorMessage = (ChatConnectorMessage) obj;
        return this.type == chatConnectorMessage.type && s.d(this.sessionId, chatConnectorMessage.sessionId) && s.d(this.messageId, chatConnectorMessage.messageId);
    }

    @NotNull
    public final String getMessageId() {
        return this.messageId;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public final FKPushType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.messageId.hashCode();
    }

    @NotNull
    public String toString() {
        FKPushType fKPushType = this.type;
        return "ChatConnectorMessage(type=" + ((Object) fKPushType) + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ")";
    }
}
