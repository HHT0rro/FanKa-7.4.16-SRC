package com.cupidapp.live.club.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubEnterRequestConnectorMessageModel extends BaseClubChatConnectorMessageModel {

    @Nullable
    private final String userId;

    public ClubEnterRequestConnectorMessageModel(@Nullable String str, @Nullable String str2) {
        super(str);
        this.userId = str2;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }
}
