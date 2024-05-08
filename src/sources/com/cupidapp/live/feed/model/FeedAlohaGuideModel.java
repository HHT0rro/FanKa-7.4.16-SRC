package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedAlohaGuideModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedAlohaGuideModel {

    @NotNull
    private final FeedModel feedModel;

    public FeedAlohaGuideModel(@NotNull FeedModel feedModel) {
        s.i(feedModel, "feedModel");
        this.feedModel = feedModel;
    }

    public static /* synthetic */ FeedAlohaGuideModel copy$default(FeedAlohaGuideModel feedAlohaGuideModel, FeedModel feedModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            feedModel = feedAlohaGuideModel.feedModel;
        }
        return feedAlohaGuideModel.copy(feedModel);
    }

    @NotNull
    public final FeedModel component1() {
        return this.feedModel;
    }

    @NotNull
    public final FeedAlohaGuideModel copy(@NotNull FeedModel feedModel) {
        s.i(feedModel, "feedModel");
        return new FeedAlohaGuideModel(feedModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedAlohaGuideModel) && s.d(this.feedModel, ((FeedAlohaGuideModel) obj).feedModel);
    }

    @NotNull
    public final FeedModel getFeedModel() {
        return this.feedModel;
    }

    public int hashCode() {
        return this.feedModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedAlohaGuideModel(feedModel=" + ((Object) this.feedModel) + ")";
    }
}
