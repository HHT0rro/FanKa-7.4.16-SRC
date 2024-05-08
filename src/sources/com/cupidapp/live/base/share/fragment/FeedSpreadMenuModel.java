package com.cupidapp.live.base.share.fragment;

import com.cupidapp.live.base.share.model.SpreadMenuType;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedSpreadMenuBottomFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedSpreadMenuModel implements Serializable {

    @Nullable
    private final String feedId;

    @Nullable
    private final List<SpreadMenuType> shareMenus;

    @Nullable
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public FeedSpreadMenuModel(@Nullable String str, @Nullable String str2, @Nullable List<? extends SpreadMenuType> list) {
        this.userId = str;
        this.feedId = str2;
        this.shareMenus = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedSpreadMenuModel copy$default(FeedSpreadMenuModel feedSpreadMenuModel, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedSpreadMenuModel.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = feedSpreadMenuModel.feedId;
        }
        if ((i10 & 4) != 0) {
            list = feedSpreadMenuModel.shareMenus;
        }
        return feedSpreadMenuModel.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final String component2() {
        return this.feedId;
    }

    @Nullable
    public final List<SpreadMenuType> component3() {
        return this.shareMenus;
    }

    @NotNull
    public final FeedSpreadMenuModel copy(@Nullable String str, @Nullable String str2, @Nullable List<? extends SpreadMenuType> list) {
        return new FeedSpreadMenuModel(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedSpreadMenuModel)) {
            return false;
        }
        FeedSpreadMenuModel feedSpreadMenuModel = (FeedSpreadMenuModel) obj;
        return s.d(this.userId, feedSpreadMenuModel.userId) && s.d(this.feedId, feedSpreadMenuModel.feedId) && s.d(this.shareMenus, feedSpreadMenuModel.shareMenus);
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    public final List<SpreadMenuType> getShareMenus() {
        return this.shareMenus;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.feedId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<SpreadMenuType> list = this.shareMenus;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FeedSpreadMenuModel(userId=" + this.userId + ", feedId=" + this.feedId + ", shareMenus=" + ((Object) this.shareMenus) + ")";
    }

    public /* synthetic */ FeedSpreadMenuModel(String str, String str2, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, list);
    }
}
