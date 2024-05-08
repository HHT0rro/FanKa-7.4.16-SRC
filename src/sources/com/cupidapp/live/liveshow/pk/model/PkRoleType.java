package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PkRoleType {
    Initiator(1),
    Invitee(2);

    private final int type;

    PkRoleType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
