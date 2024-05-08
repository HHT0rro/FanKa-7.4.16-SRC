package com.cupidapp.live.chat2.model;

import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatBundleData implements Serializable {

    @Nullable
    private final FeedModel feedModel;
    private final boolean inLiveShow;
    private final boolean isFromStoryLabel;
    private final boolean isLimitTimeSendMsg;
    private final boolean isShowKeyboard;
    private final boolean isShowMineEmojiSvga;

    @NotNull
    private User otherUser;

    @NotNull
    private final FKSensorContext sensorContext;

    @NotNull
    private final String sessionId;

    public ChatBundleData(@NotNull User otherUser, @NotNull String sessionId, @NotNull FKSensorContext sensorContext, @Nullable FeedModel feedModel, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        s.i(otherUser, "otherUser");
        s.i(sessionId, "sessionId");
        s.i(sensorContext, "sensorContext");
        this.otherUser = otherUser;
        this.sessionId = sessionId;
        this.sensorContext = sensorContext;
        this.feedModel = feedModel;
        this.isFromStoryLabel = z10;
        this.isShowMineEmojiSvga = z11;
        this.isShowKeyboard = z12;
        this.inLiveShow = z13;
        this.isLimitTimeSendMsg = z14;
    }

    @NotNull
    public final User component1() {
        return this.otherUser;
    }

    @NotNull
    public final String component2() {
        return this.sessionId;
    }

    @NotNull
    public final FKSensorContext component3() {
        return this.sensorContext;
    }

    @Nullable
    public final FeedModel component4() {
        return this.feedModel;
    }

    public final boolean component5() {
        return this.isFromStoryLabel;
    }

    public final boolean component6() {
        return this.isShowMineEmojiSvga;
    }

    public final boolean component7() {
        return this.isShowKeyboard;
    }

    public final boolean component8() {
        return this.inLiveShow;
    }

    public final boolean component9() {
        return this.isLimitTimeSendMsg;
    }

    @NotNull
    public final ChatBundleData copy(@NotNull User otherUser, @NotNull String sessionId, @NotNull FKSensorContext sensorContext, @Nullable FeedModel feedModel, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        s.i(otherUser, "otherUser");
        s.i(sessionId, "sessionId");
        s.i(sensorContext, "sensorContext");
        return new ChatBundleData(otherUser, sessionId, sensorContext, feedModel, z10, z11, z12, z13, z14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatBundleData)) {
            return false;
        }
        ChatBundleData chatBundleData = (ChatBundleData) obj;
        return s.d(this.otherUser, chatBundleData.otherUser) && s.d(this.sessionId, chatBundleData.sessionId) && s.d(this.sensorContext, chatBundleData.sensorContext) && s.d(this.feedModel, chatBundleData.feedModel) && this.isFromStoryLabel == chatBundleData.isFromStoryLabel && this.isShowMineEmojiSvga == chatBundleData.isShowMineEmojiSvga && this.isShowKeyboard == chatBundleData.isShowKeyboard && this.inLiveShow == chatBundleData.inLiveShow && this.isLimitTimeSendMsg == chatBundleData.isLimitTimeSendMsg;
    }

    @Nullable
    public final FeedModel getFeedModel() {
        return this.feedModel;
    }

    public final boolean getInLiveShow() {
        return this.inLiveShow;
    }

    @NotNull
    public final User getOtherUser() {
        return this.otherUser;
    }

    @NotNull
    public final FKSensorContext getSensorContext() {
        return this.sensorContext;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.otherUser.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.sensorContext.hashCode()) * 31;
        FeedModel feedModel = this.feedModel;
        int hashCode2 = (hashCode + (feedModel == null ? 0 : feedModel.hashCode())) * 31;
        boolean z10 = this.isFromStoryLabel;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        boolean z11 = this.isShowMineEmojiSvga;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.isShowKeyboard;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.inLiveShow;
        int i16 = z13;
        if (z13 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z14 = this.isLimitTimeSendMsg;
        return i17 + (z14 ? 1 : z14 ? 1 : 0);
    }

    public final boolean isCardStyle() {
        return false;
    }

    public final boolean isFromStoryLabel() {
        return this.isFromStoryLabel;
    }

    public final boolean isLimitTimeSendMsg() {
        return this.isLimitTimeSendMsg;
    }

    public final boolean isShowKeyboard() {
        return this.isShowKeyboard;
    }

    public final boolean isShowMineEmojiSvga() {
        return this.isShowMineEmojiSvga;
    }

    public final void setOtherUser(@NotNull User user) {
        s.i(user, "<set-?>");
        this.otherUser = user;
    }

    @NotNull
    public String toString() {
        User user = this.otherUser;
        String str = this.sessionId;
        FKSensorContext fKSensorContext = this.sensorContext;
        FeedModel feedModel = this.feedModel;
        return "ChatBundleData(otherUser=" + ((Object) user) + ", sessionId=" + str + ", sensorContext=" + ((Object) fKSensorContext) + ", feedModel=" + ((Object) feedModel) + ", isFromStoryLabel=" + this.isFromStoryLabel + ", isShowMineEmojiSvga=" + this.isShowMineEmojiSvga + ", isShowKeyboard=" + this.isShowKeyboard + ", inLiveShow=" + this.inLiveShow + ", isLimitTimeSendMsg=" + this.isLimitTimeSendMsg + ")";
    }

    public /* synthetic */ ChatBundleData(User user, String str, FKSensorContext fKSensorContext, FeedModel feedModel, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, fKSensorContext, (i10 & 8) != 0 ? null : feedModel, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11, (i10 & 64) != 0 ? false : z12, (i10 & 128) != 0 ? false : z13, (i10 & 256) != 0 ? false : z14);
    }
}
