package com.cupidapp.live.feed.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedResultModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedResultModel implements Serializable {

    @Nullable
    private Integer closeFriendCount;

    @Nullable
    private Integer focusCount;

    @Nullable
    private List<FeedModel> list;

    @Nullable
    private String nextCursorId;

    @Nullable
    private List<List<FeedRecommendResult>> recoList;

    @Nullable
    private Boolean redDot;

    public FeedResultModel(@Nullable List<FeedModel> list, @Nullable List<List<FeedRecommendResult>> list2, @Nullable String str, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2) {
        this.list = list;
        this.recoList = list2;
        this.nextCursorId = str;
        this.redDot = bool;
        this.focusCount = num;
        this.closeFriendCount = num2;
    }

    public static /* synthetic */ FeedResultModel copy$default(FeedResultModel feedResultModel, List list, List list2, String str, Boolean bool, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = feedResultModel.list;
        }
        if ((i10 & 2) != 0) {
            list2 = feedResultModel.recoList;
        }
        List list3 = list2;
        if ((i10 & 4) != 0) {
            str = feedResultModel.nextCursorId;
        }
        String str2 = str;
        if ((i10 & 8) != 0) {
            bool = feedResultModel.redDot;
        }
        Boolean bool2 = bool;
        if ((i10 & 16) != 0) {
            num = feedResultModel.focusCount;
        }
        Integer num3 = num;
        if ((i10 & 32) != 0) {
            num2 = feedResultModel.closeFriendCount;
        }
        return feedResultModel.copy(list, list3, str2, bool2, num3, num2);
    }

    @Nullable
    public final List<FeedModel> component1() {
        return this.list;
    }

    @Nullable
    public final List<List<FeedRecommendResult>> component2() {
        return this.recoList;
    }

    @Nullable
    public final String component3() {
        return this.nextCursorId;
    }

    @Nullable
    public final Boolean component4() {
        return this.redDot;
    }

    @Nullable
    public final Integer component5() {
        return this.focusCount;
    }

    @Nullable
    public final Integer component6() {
        return this.closeFriendCount;
    }

    @NotNull
    public final FeedResultModel copy(@Nullable List<FeedModel> list, @Nullable List<List<FeedRecommendResult>> list2, @Nullable String str, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2) {
        return new FeedResultModel(list, list2, str, bool, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedResultModel)) {
            return false;
        }
        FeedResultModel feedResultModel = (FeedResultModel) obj;
        return s.d(this.list, feedResultModel.list) && s.d(this.recoList, feedResultModel.recoList) && s.d(this.nextCursorId, feedResultModel.nextCursorId) && s.d(this.redDot, feedResultModel.redDot) && s.d(this.focusCount, feedResultModel.focusCount) && s.d(this.closeFriendCount, feedResultModel.closeFriendCount);
    }

    @Nullable
    public final Integer getCloseFriendCount() {
        return this.closeFriendCount;
    }

    @Nullable
    public final Integer getFocusCount() {
        return this.focusCount;
    }

    @Nullable
    public final List<FeedModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<List<FeedRecommendResult>> getRecoList() {
        return this.recoList;
    }

    @Nullable
    public final Boolean getRedDot() {
        return this.redDot;
    }

    public int hashCode() {
        List<FeedModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<List<FeedRecommendResult>> list2 = this.recoList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.nextCursorId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.redDot;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.focusCount;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.closeFriendCount;
        return hashCode5 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCloseFriendCount(@Nullable Integer num) {
        this.closeFriendCount = num;
    }

    public final void setFocusCount(@Nullable Integer num) {
        this.focusCount = num;
    }

    public final void setList(@Nullable List<FeedModel> list) {
        this.list = list;
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    public final void setRecoList(@Nullable List<List<FeedRecommendResult>> list) {
        this.recoList = list;
    }

    public final void setRedDot(@Nullable Boolean bool) {
        this.redDot = bool;
    }

    @NotNull
    public String toString() {
        List<FeedModel> list = this.list;
        List<List<FeedRecommendResult>> list2 = this.recoList;
        return "FeedResultModel(list=" + ((Object) list) + ", recoList=" + ((Object) list2) + ", nextCursorId=" + this.nextCursorId + ", redDot=" + ((Object) this.redDot) + ", focusCount=" + ((Object) this.focusCount) + ", closeFriendCount=" + ((Object) this.closeFriendCount) + ")";
    }

    public /* synthetic */ FeedResultModel(List list, List list2, String str, Boolean bool, Integer num, Integer num2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, str, (i10 & 8) != 0 ? Boolean.FALSE : bool, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? null : num2);
    }
}
