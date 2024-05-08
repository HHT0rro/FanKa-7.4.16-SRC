package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMessageModel extends MaskPartyChatConnectorMessageModel {

    @NotNull
    private final String messageId;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyMessageModel(@NotNull String roomId, @NotNull String messageId, int i10) {
        super(roomId);
        s.i(roomId, "roomId");
        s.i(messageId, "messageId");
        this.messageId = messageId;
        this.type = i10;
    }

    @NotNull
    public final String getMessageId() {
        return this.messageId;
    }

    public final int getType() {
        return this.type;
    }
}
