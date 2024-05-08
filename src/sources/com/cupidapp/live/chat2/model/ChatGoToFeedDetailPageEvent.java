package com.cupidapp.live.chat2.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatGoToFeedDetailPageEvent {

    @Nullable
    private final String postId;

    public ChatGoToFeedDetailPageEvent(@Nullable String str) {
        this.postId = str;
    }

    @Nullable
    public final String getPostId() {
        return this.postId;
    }
}
