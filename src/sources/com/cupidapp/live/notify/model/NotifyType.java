package com.cupidapp.live.notify.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: PostNotifyModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum NotifyType {
    PostComment("PostComment"),
    Announce("Announce"),
    PostLike("PostLike"),
    PostTag("PostTag"),
    PostCommentReplyOnMyPost("PostCommentReplyOnMyPost"),
    PostCommentReplyOnOthersPost("PostCommentReplyOnOthersPost"),
    PostCommentLike("PostCommentLike"),
    PostAt("PostAt"),
    PostCommentAt("PostCommentAt"),
    NewCloseFriend("NewCloseFriend"),
    PraiseLike("PraiseLike"),
    NewPraise("NewPraise");


    @NotNull
    private final String type;

    NotifyType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
