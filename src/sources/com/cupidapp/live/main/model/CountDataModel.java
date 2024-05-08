package com.cupidapp.live.main.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CountDataModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CountDataModel {
    private final int greetMessageCount;
    private final int inboxNewMatchCount;

    @Nullable
    private final String liveTabJumpUrl;
    private final int messageCount;
    private boolean newFeed;
    private int newLiveShowCount;
    private final int newMatchCount;
    private final int notifyAlohaCount;
    private final int notifyPostLikeCount;
    private final int notifyWithoutAlohaPostLikeCount;
    private boolean noviceTask;

    public CountDataModel() {
        this(false, false, 0, null, 0, 0, 0, 0, 0, 0, 0, 2047, null);
    }

    public CountDataModel(boolean z10, boolean z11, int i10, @Nullable String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.newFeed = z10;
        this.noviceTask = z11;
        this.newLiveShowCount = i10;
        this.liveTabJumpUrl = str;
        this.greetMessageCount = i11;
        this.messageCount = i12;
        this.notifyAlohaCount = i13;
        this.notifyPostLikeCount = i14;
        this.notifyWithoutAlohaPostLikeCount = i15;
        this.newMatchCount = i16;
        this.inboxNewMatchCount = i17;
    }

    public final boolean component1() {
        return this.newFeed;
    }

    public final int component10() {
        return this.newMatchCount;
    }

    public final int component11() {
        return this.inboxNewMatchCount;
    }

    public final boolean component2() {
        return this.noviceTask;
    }

    public final int component3() {
        return this.newLiveShowCount;
    }

    @Nullable
    public final String component4() {
        return this.liveTabJumpUrl;
    }

    public final int component5() {
        return this.greetMessageCount;
    }

    public final int component6() {
        return this.messageCount;
    }

    public final int component7() {
        return this.notifyAlohaCount;
    }

    public final int component8() {
        return this.notifyPostLikeCount;
    }

    public final int component9() {
        return this.notifyWithoutAlohaPostLikeCount;
    }

    @NotNull
    public final CountDataModel copy(boolean z10, boolean z11, int i10, @Nullable String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return new CountDataModel(z10, z11, i10, str, i11, i12, i13, i14, i15, i16, i17);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountDataModel)) {
            return false;
        }
        CountDataModel countDataModel = (CountDataModel) obj;
        return this.newFeed == countDataModel.newFeed && this.noviceTask == countDataModel.noviceTask && this.newLiveShowCount == countDataModel.newLiveShowCount && s.d(this.liveTabJumpUrl, countDataModel.liveTabJumpUrl) && this.greetMessageCount == countDataModel.greetMessageCount && this.messageCount == countDataModel.messageCount && this.notifyAlohaCount == countDataModel.notifyAlohaCount && this.notifyPostLikeCount == countDataModel.notifyPostLikeCount && this.notifyWithoutAlohaPostLikeCount == countDataModel.notifyWithoutAlohaPostLikeCount && this.newMatchCount == countDataModel.newMatchCount && this.inboxNewMatchCount == countDataModel.inboxNewMatchCount;
    }

    public final int getGreetMessageCount() {
        return this.greetMessageCount;
    }

    public final int getInboxNewMatchCount() {
        return this.inboxNewMatchCount;
    }

    @Nullable
    public final String getLiveTabJumpUrl() {
        return this.liveTabJumpUrl;
    }

    public final int getMessageCount() {
        return this.messageCount;
    }

    public final boolean getNewFeed() {
        return this.newFeed;
    }

    public final int getNewLiveShowCount() {
        return this.newLiveShowCount;
    }

    public final int getNewMatchCount() {
        return this.newMatchCount;
    }

    public final int getNotifyAlohaCount() {
        return this.notifyAlohaCount;
    }

    public final int getNotifyPostLikeCount() {
        return this.notifyPostLikeCount;
    }

    public final int getNotifyWithoutAlohaPostLikeCount() {
        return this.notifyWithoutAlohaPostLikeCount;
    }

    public final boolean getNoviceTask() {
        return this.noviceTask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    public int hashCode() {
        boolean z10 = this.newFeed;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.noviceTask;
        int i11 = (((i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31) + this.newLiveShowCount) * 31;
        String str = this.liveTabJumpUrl;
        return ((((((((((((((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.greetMessageCount) * 31) + this.messageCount) * 31) + this.notifyAlohaCount) * 31) + this.notifyPostLikeCount) * 31) + this.notifyWithoutAlohaPostLikeCount) * 31) + this.newMatchCount) * 31) + this.inboxNewMatchCount;
    }

    public final void setNewFeed(boolean z10) {
        this.newFeed = z10;
    }

    public final void setNewLiveShowCount(int i10) {
        this.newLiveShowCount = i10;
    }

    public final void setNoviceTask(boolean z10) {
        this.noviceTask = z10;
    }

    @NotNull
    public String toString() {
        return "CountDataModel(newFeed=" + this.newFeed + ", noviceTask=" + this.noviceTask + ", newLiveShowCount=" + this.newLiveShowCount + ", liveTabJumpUrl=" + this.liveTabJumpUrl + ", greetMessageCount=" + this.greetMessageCount + ", messageCount=" + this.messageCount + ", notifyAlohaCount=" + this.notifyAlohaCount + ", notifyPostLikeCount=" + this.notifyPostLikeCount + ", notifyWithoutAlohaPostLikeCount=" + this.notifyWithoutAlohaPostLikeCount + ", newMatchCount=" + this.newMatchCount + ", inboxNewMatchCount=" + this.inboxNewMatchCount + ")";
    }

    public /* synthetic */ CountDataModel(boolean z10, boolean z11, int i10, String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? false : z10, (i18 & 2) != 0 ? false : z11, (i18 & 4) != 0 ? 0 : i10, (i18 & 8) != 0 ? null : str, (i18 & 16) != 0 ? 0 : i11, (i18 & 32) != 0 ? 0 : i12, (i18 & 64) != 0 ? 0 : i13, (i18 & 128) != 0 ? 0 : i14, (i18 & 256) != 0 ? 0 : i15, (i18 & 512) != 0 ? 0 : i16, (i18 & 1024) == 0 ? i17 : 0);
    }
}
