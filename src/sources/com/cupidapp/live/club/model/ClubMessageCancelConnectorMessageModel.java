package com.cupidapp.live.club.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubMessageCancelConnectorMessageModel extends BaseClubChatConnectorMessageModel {

    @Nullable
    private final String messageId;

    @Nullable
    private final String nickname;

    public ClubMessageCancelConnectorMessageModel(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(str);
        this.messageId = str2;
        this.nickname = str3;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }
}
