package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMessageSendFailResendEvent {

    @NotNull
    private final ChatMessageModel failModel;

    public ChatMessageSendFailResendEvent(@NotNull ChatMessageModel failModel) {
        s.i(failModel, "failModel");
        this.failModel = failModel;
    }

    @NotNull
    public final ChatMessageModel getFailModel() {
        return this.failModel;
    }
}
