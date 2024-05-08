package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import sun.security.util.SecurityConstants;

/* compiled from: MultiPersonPkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum MultiPkInviteStatus {
    None("none"),
    Wait("wait"),
    Accept(SecurityConstants.SOCKET_ACCEPT_ACTION),
    Refuse("refuse"),
    TimeOut("timeout");


    @NotNull
    private final String status;

    MultiPkInviteStatus(String str) {
        this.status = str;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }
}
