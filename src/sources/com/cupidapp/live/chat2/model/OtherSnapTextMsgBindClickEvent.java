package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OtherSnapTextMsgBindClickEvent {

    @NotNull
    private final ChatMessageModel model;

    public OtherSnapTextMsgBindClickEvent(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        this.model = model;
    }

    @NotNull
    public final ChatMessageModel getModel() {
        return this.model;
    }
}
