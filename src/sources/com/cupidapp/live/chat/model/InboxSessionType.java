package com.cupidapp.live.chat.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: InboxSessionType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum InboxSessionType {
    InboxSession("inboxSession"),
    UrlSession("urlSession"),
    VisitorSession("visitorSession"),
    ChatStatusSession("chatStatusSession"),
    MarketingSession("marketingSession"),
    GroupSession("groupSession"),
    NearBySession("nearbySession"),
    OperationSession("operationSession");


    @NotNull
    private final String type;

    InboxSessionType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
