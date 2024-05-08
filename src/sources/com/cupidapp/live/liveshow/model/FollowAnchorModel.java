package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FollowAnchorModel {

    @Nullable
    private final List<ImageModel> followAnchorAvatars;

    @Nullable
    private final String liveTabJumpUrl;

    @Nullable
    private final Integer newLiveShowCount;

    @Nullable
    private final Boolean redDot;

    public FollowAnchorModel(@Nullable Integer num, @Nullable String str, @Nullable List<ImageModel> list, @Nullable Boolean bool) {
        this.newLiveShowCount = num;
        this.liveTabJumpUrl = str;
        this.followAnchorAvatars = list;
        this.redDot = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FollowAnchorModel copy$default(FollowAnchorModel followAnchorModel, Integer num, String str, List list, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = followAnchorModel.newLiveShowCount;
        }
        if ((i10 & 2) != 0) {
            str = followAnchorModel.liveTabJumpUrl;
        }
        if ((i10 & 4) != 0) {
            list = followAnchorModel.followAnchorAvatars;
        }
        if ((i10 & 8) != 0) {
            bool = followAnchorModel.redDot;
        }
        return followAnchorModel.copy(num, str, list, bool);
    }

    @Nullable
    public final Integer component1() {
        return this.newLiveShowCount;
    }

    @Nullable
    public final String component2() {
        return this.liveTabJumpUrl;
    }

    @Nullable
    public final List<ImageModel> component3() {
        return this.followAnchorAvatars;
    }

    @Nullable
    public final Boolean component4() {
        return this.redDot;
    }

    @NotNull
    public final FollowAnchorModel copy(@Nullable Integer num, @Nullable String str, @Nullable List<ImageModel> list, @Nullable Boolean bool) {
        return new FollowAnchorModel(num, str, list, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowAnchorModel)) {
            return false;
        }
        FollowAnchorModel followAnchorModel = (FollowAnchorModel) obj;
        return s.d(this.newLiveShowCount, followAnchorModel.newLiveShowCount) && s.d(this.liveTabJumpUrl, followAnchorModel.liveTabJumpUrl) && s.d(this.followAnchorAvatars, followAnchorModel.followAnchorAvatars) && s.d(this.redDot, followAnchorModel.redDot);
    }

    @Nullable
    public final List<ImageModel> getFollowAnchorAvatars() {
        return this.followAnchorAvatars;
    }

    @Nullable
    public final String getLiveTabJumpUrl() {
        return this.liveTabJumpUrl;
    }

    @Nullable
    public final Integer getNewLiveShowCount() {
        return this.newLiveShowCount;
    }

    @Nullable
    public final Boolean getRedDot() {
        return this.redDot;
    }

    public int hashCode() {
        Integer num = this.newLiveShowCount;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.liveTabJumpUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<ImageModel> list = this.followAnchorAvatars;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.redDot;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.newLiveShowCount;
        return "FollowAnchorModel(newLiveShowCount=" + ((Object) num) + ", liveTabJumpUrl=" + this.liveTabJumpUrl + ", followAnchorAvatars=" + ((Object) this.followAnchorAvatars) + ", redDot=" + ((Object) this.redDot) + ")";
    }

    public /* synthetic */ FollowAnchorModel(Integer num, String str, List list, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i10 & 2) != 0 ? null : str, list, bool);
    }
}
