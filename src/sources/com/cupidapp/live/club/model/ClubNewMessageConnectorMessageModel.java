package com.cupidapp.live.club.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubNewMessageConnectorMessageModel extends BaseClubChatConnectorMessageModel {

    @Nullable
    private final String fromUserId;

    @Nullable
    private final String messageId;

    public ClubNewMessageConnectorMessageModel(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(str);
        this.messageId = str2;
        this.fromUserId = str3;
    }

    @Nullable
    public final String getFromUserId() {
        return this.fromUserId;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }
}
