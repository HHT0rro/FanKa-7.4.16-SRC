package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatMessageSendFailResendEvent {

    @NotNull
    private final ClubChatMsgModel failModel;

    public ClubChatMessageSendFailResendEvent(@NotNull ClubChatMsgModel failModel) {
        s.i(failModel, "failModel");
        this.failModel = failModel;
    }

    @NotNull
    public final ClubChatMsgModel getFailModel() {
        return this.failModel;
    }
}
