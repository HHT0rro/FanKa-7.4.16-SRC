package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatLookSnapImgInsertScreenShotNoticeEvent {

    @NotNull
    private final ChatMessageModel message;

    @NotNull
    private final String otherUserId;

    public ChatLookSnapImgInsertScreenShotNoticeEvent(@NotNull String otherUserId, @NotNull ChatMessageModel message) {
        s.i(otherUserId, "otherUserId");
        s.i(message, "message");
        this.otherUserId = otherUserId;
        this.message = message;
    }

    @NotNull
    public final ChatMessageModel getMessage() {
        return this.message;
    }

    @NotNull
    public final String getOtherUserId() {
        return this.otherUserId;
    }
}
