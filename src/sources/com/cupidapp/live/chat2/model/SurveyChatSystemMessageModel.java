package com.cupidapp.live.chat2.model;

import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SurveyChatSystemMessageModel extends BaseSurveyChatMessageModel {

    @NotNull
    private final String content;

    @Nullable
    private final KeyMsgModel linkDict;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurveyChatSystemMessageModel(@NotNull String id2, @NotNull User sender, @NotNull String content, @Nullable KeyMsgModel keyMsgModel) {
        super(id2, sender);
        s.i(id2, "id");
        s.i(sender, "sender");
        s.i(content, "content");
        this.content = content;
        this.linkDict = keyMsgModel;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final KeyMsgModel getLinkDict() {
        return this.linkDict;
    }
}
