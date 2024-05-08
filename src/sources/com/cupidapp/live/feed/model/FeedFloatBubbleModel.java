package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedFloatBubbleModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedFloatBubbleModel {

    @Nullable
    private final FloatBubbleResult floatBubble;

    public FeedFloatBubbleModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public FeedFloatBubbleModel(@Nullable FloatBubbleResult floatBubbleResult) {
        this.floatBubble = floatBubbleResult;
    }

    public static /* synthetic */ FeedFloatBubbleModel copy$default(FeedFloatBubbleModel feedFloatBubbleModel, FloatBubbleResult floatBubbleResult, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            floatBubbleResult = feedFloatBubbleModel.floatBubble;
        }
        return feedFloatBubbleModel.copy(floatBubbleResult);
    }

    @Nullable
    public final FloatBubbleResult component1() {
        return this.floatBubble;
    }

    @NotNull
    public final FeedFloatBubbleModel copy(@Nullable FloatBubbleResult floatBubbleResult) {
        return new FeedFloatBubbleModel(floatBubbleResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FeedFloatBubbleModel) && s.d(this.floatBubble, ((FeedFloatBubbleModel) obj).floatBubble);
    }

    @Nullable
    public final FloatBubbleResult getFloatBubble() {
        return this.floatBubble;
    }

    public int hashCode() {
        FloatBubbleResult floatBubbleResult = this.floatBubble;
        if (floatBubbleResult == null) {
            return 0;
        }
        return floatBubbleResult.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedFloatBubbleModel(floatBubble=" + ((Object) this.floatBubble) + ")";
    }

    public /* synthetic */ FeedFloatBubbleModel(FloatBubbleResult floatBubbleResult, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : floatBubbleResult);
    }
}
