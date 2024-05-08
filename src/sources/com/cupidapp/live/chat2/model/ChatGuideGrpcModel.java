package com.cupidapp.live.chat2.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatGuideGrpcModel extends BaseChatGrpcModel {

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final Integer type;

    public ChatGuideGrpcModel(@Nullable String str, @Nullable Integer num, @Nullable String str2) {
        super(str);
        this.type = num;
        this.jumpUrl = str2;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }
}
