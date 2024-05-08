package com.cupidapp.live.base.grpc;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum NotifyMessageType {
    SystemMessage(0),
    CommentGuideMessage(1);

    private final int type;

    NotifyMessageType(int i10) {
        this.type = i10;
    }

    public final int getType() {
        return this.type;
    }
}
