package com.cupidapp.live.chat2.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatClickReEditBtnEvent {

    @Nullable
    private final String cancelMessage;

    public ChatClickReEditBtnEvent(@Nullable String str) {
        this.cancelMessage = str;
    }

    @Nullable
    public final String getCancelMessage() {
        return this.cancelMessage;
    }
}
