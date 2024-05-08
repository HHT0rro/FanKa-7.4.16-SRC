package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedShowCaseViewModel {

    @NotNull
    private final FeedModel feedModel;

    public FeedShowCaseViewModel(@NotNull FeedModel feedModel) {
        s.i(feedModel, "feedModel");
        this.feedModel = feedModel;
    }

    @NotNull
    public final FeedModel getFeedModel() {
        return this.feedModel;
    }
}
