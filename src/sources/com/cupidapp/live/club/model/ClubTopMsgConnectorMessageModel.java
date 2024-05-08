package com.cupidapp.live.club.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubTopMsgConnectorMessageModel extends BaseClubChatConnectorMessageModel {

    @Nullable
    private final String msg;

    public ClubTopMsgConnectorMessageModel(@Nullable String str, @Nullable String str2) {
        super(str);
        this.msg = str2;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }
}
