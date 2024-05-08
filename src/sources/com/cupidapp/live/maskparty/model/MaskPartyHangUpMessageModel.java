package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyHangUpMessageModel extends MaskPartyChatConnectorMessageModel {

    @Nullable
    private final Integer countDownSeconds;

    @NotNull
    private final String msg;
    private final int popupType;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyHangUpMessageModel(@NotNull String roomId, int i10, int i11, @NotNull String msg, @Nullable Integer num) {
        super(roomId);
        s.i(roomId, "roomId");
        s.i(msg, "msg");
        this.type = i10;
        this.popupType = i11;
        this.msg = msg;
        this.countDownSeconds = num;
    }

    @Nullable
    public final Integer getCountDownSeconds() {
        return this.countDownSeconds;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public final int getPopupType() {
        return this.popupType;
    }

    public final int getType() {
        return this.type;
    }
}
