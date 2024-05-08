package com.cupidapp.live.feed.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TopCloseFriendEntranceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TopCloseFriendEntranceModel implements IBaseFeedModel {

    @Nullable
    private Integer closeFriendCount;

    public TopCloseFriendEntranceModel(@Nullable Integer num) {
        this.closeFriendCount = num;
    }

    @Nullable
    public final Integer getCloseFriendCount() {
        return this.closeFriendCount;
    }

    @Override // com.cupidapp.live.feed.model.IBaseFeedModel
    @NotNull
    public String getSensorFeedType() {
        return "TopCloseFriendManage";
    }

    public final void setCloseFriendCount(@Nullable Integer num) {
        this.closeFriendCount = num;
    }
}
