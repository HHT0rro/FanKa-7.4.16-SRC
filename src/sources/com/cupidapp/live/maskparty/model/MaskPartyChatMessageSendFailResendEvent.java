package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatMessageSendFailResendEvent {

    @NotNull
    private final MaskPartyChatMessageModel failModel;

    public MaskPartyChatMessageSendFailResendEvent(@NotNull MaskPartyChatMessageModel failModel) {
        s.i(failModel, "failModel");
        this.failModel = failModel;
    }

    @NotNull
    public final MaskPartyChatMessageModel getFailModel() {
        return this.failModel;
    }
}
