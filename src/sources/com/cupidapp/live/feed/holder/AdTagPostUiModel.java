package com.cupidapp.live.feed.holder;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.feed.model.FeedTabBtnModel;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AdTagPostViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdTagPostUiModel {

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final List<FeedTabBtnModel> tabList;

    public AdTagPostUiModel(@Nullable ImageModel imageModel, @Nullable List<FeedTabBtnModel> list, @Nullable String str) {
        this.image = imageModel;
        this.tabList = list;
        this.jumpUrl = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdTagPostUiModel copy$default(AdTagPostUiModel adTagPostUiModel, ImageModel imageModel, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = adTagPostUiModel.image;
        }
        if ((i10 & 2) != 0) {
            list = adTagPostUiModel.tabList;
        }
        if ((i10 & 4) != 0) {
            str = adTagPostUiModel.jumpUrl;
        }
        return adTagPostUiModel.copy(imageModel, list, str);
    }

    @Nullable
    public final ImageModel component1() {
        return this.image;
    }

    @Nullable
    public final List<FeedTabBtnModel> component2() {
        return this.tabList;
    }

    @Nullable
    public final String component3() {
        return this.jumpUrl;
    }

    @NotNull
    public final AdTagPostUiModel copy(@Nullable ImageModel imageModel, @Nullable List<FeedTabBtnModel> list, @Nullable String str) {
        return new AdTagPostUiModel(imageModel, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdTagPostUiModel)) {
            return false;
        }
        AdTagPostUiModel adTagPostUiModel = (AdTagPostUiModel) obj;
        return s.d(this.image, adTagPostUiModel.image) && s.d(this.tabList, adTagPostUiModel.tabList) && s.d(this.jumpUrl, adTagPostUiModel.jumpUrl);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final List<FeedTabBtnModel> getTabList() {
        return this.tabList;
    }

    public int hashCode() {
        ImageModel imageModel = this.image;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        List<FeedTabBtnModel> list = this.tabList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.jumpUrl;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.image;
        List<FeedTabBtnModel> list = this.tabList;
        return "AdTagPostUiModel(image=" + ((Object) imageModel) + ", tabList=" + ((Object) list) + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
