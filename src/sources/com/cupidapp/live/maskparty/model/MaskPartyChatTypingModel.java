package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatTypingModel extends MaskPartyChatConnectorMessageModel {

    @NotNull
    private final String msg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatTypingModel(@NotNull String roomId, @NotNull String msg) {
        super(roomId);
        s.i(roomId, "roomId");
        s.i(msg, "msg");
        this.msg = msg;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }
}
