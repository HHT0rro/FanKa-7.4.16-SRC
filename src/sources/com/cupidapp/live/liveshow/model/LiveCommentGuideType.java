package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveCommentGuideType {
    AlohaType("COMMENT_FOLLOW_GUIDE"),
    AlohaAlertType("BOTTOM_FOLLOW_GUIDE"),
    ChatType("CHAT_GUIDE"),
    SendGiftType("GIFT_GUIDE"),
    CommentGuide("");


    @NotNull
    private String type;

    LiveCommentGuideType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final void setType(@NotNull String str) {
        s.i(str, "<set-?>");
        this.type = str;
    }
}
