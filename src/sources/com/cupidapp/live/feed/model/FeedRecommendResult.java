package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedRecommendResult {

    @Nullable
    private final String callback;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final ImageModel labelImage;

    @Nullable
    private final FeedModel post;

    @Nullable
    private final List<FeedTabBtnModel> tabList;

    @Nullable
    private final String type;

    public FeedRecommendResult(@Nullable FeedModel feedModel, @Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable ImageModel imageModel2, @Nullable String str3, @Nullable List<FeedTabBtnModel> list) {
        this.post = feedModel;
        this.callback = str;
        this.labelImage = imageModel;
        this.type = str2;
        this.image = imageModel2;
        this.jumpUrl = str3;
        this.tabList = list;
    }

    @Nullable
    public final String getCallback() {
        return this.callback;
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
    public final ImageModel getLabelImage() {
        return this.labelImage;
    }

    @Nullable
    public final FeedModel getPost() {
        return this.post;
    }

    @Nullable
    public final List<FeedTabBtnModel> getTabList() {
        return this.tabList;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }
}
