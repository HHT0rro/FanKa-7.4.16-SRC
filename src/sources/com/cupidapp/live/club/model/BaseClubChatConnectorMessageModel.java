package com.cupidapp.live.club.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseClubChatConnectorMessageModel implements Serializable {

    @Nullable
    private final String groupId;

    public BaseClubChatConnectorMessageModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseClubChatConnectorMessageModel(@Nullable String str) {
        this.groupId = str;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    public /* synthetic */ BaseClubChatConnectorMessageModel(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str);
    }
}
