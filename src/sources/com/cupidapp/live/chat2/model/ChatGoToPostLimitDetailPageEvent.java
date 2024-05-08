package com.cupidapp.live.chat2.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTotalEventFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatGoToPostLimitDetailPageEvent {

    @Nullable
    private final String msgId;

    @Nullable
    private final String postId;

    @Nullable
    private final String postLimitUserId;

    public ChatGoToPostLimitDetailPageEvent(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.postId = str;
        this.msgId = str2;
        this.postLimitUserId = str3;
    }

    @Nullable
    public final String getMsgId() {
        return this.msgId;
    }

    @Nullable
    public final String getPostId() {
        return this.postId;
    }

    @Nullable
    public final String getPostLimitUserId() {
        return this.postLimitUserId;
    }
}
