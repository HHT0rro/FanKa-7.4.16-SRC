package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatLeaveRoom extends MaskPartyChatConnectorMessageModel {

    @NotNull
    private final String userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatLeaveRoom(@NotNull String roomId, @NotNull String userId) {
        super(roomId);
        s.i(roomId, "roomId");
        s.i(userId, "userId");
        this.userId = userId;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }
}
