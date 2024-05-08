package com.cupidapp.live.push.model;

import kotlin.d;

/* compiled from: FKPushTokenModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum PushAlertScene {
    FocusManageListScene(1),
    FeedScene(2),
    ChatDetailScene(3),
    CloseFriendManageScene(4);

    private final int value;

    PushAlertScene(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
