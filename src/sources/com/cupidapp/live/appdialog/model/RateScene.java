package com.cupidapp.live.appdialog.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppDialogModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum RateScene {
    LeaveMessageDetail("LeaveMessageDetail", "LEAVE_CHAT_ROOM"),
    FeedPraise("FeedPraise", "FEED_LIKE"),
    LeaveNotify("LeaveNotify", "LEAVE_NOTICE_CENTER"),
    LeaveNearbyFollow("LeaveNearbyFollow", "LEAVE_NEARBY_AFTER_ALOHA"),
    PublishNewFeed("PublishNewFeed", "AFTER_PUBLISH_FEED");


    @NotNull
    private final String scene;

    @NotNull
    private final String triggerMode;

    RateScene(String str, String str2) {
        this.scene = str;
        this.triggerMode = str2;
    }

    @NotNull
    public final String getScene() {
        return this.scene;
    }

    @NotNull
    public final String getTriggerMode() {
        return this.triggerMode;
    }
}
