package com.cupidapp.live.feed.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedPostLimitGuideModel {
    private boolean isFirstDisplay;
    private int showPosition;

    public FeedPostLimitGuideModel() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public FeedPostLimitGuideModel(boolean z10, int i10) {
        this.isFirstDisplay = z10;
        this.showPosition = i10;
    }

    public static /* synthetic */ FeedPostLimitGuideModel copy$default(FeedPostLimitGuideModel feedPostLimitGuideModel, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = feedPostLimitGuideModel.isFirstDisplay;
        }
        if ((i11 & 2) != 0) {
            i10 = feedPostLimitGuideModel.showPosition;
        }
        return feedPostLimitGuideModel.copy(z10, i10);
    }

    public final boolean component1() {
        return this.isFirstDisplay;
    }

    public final int component2() {
        return this.showPosition;
    }

    @NotNull
    public final FeedPostLimitGuideModel copy(boolean z10, int i10) {
        return new FeedPostLimitGuideModel(z10, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedPostLimitGuideModel)) {
            return false;
        }
        FeedPostLimitGuideModel feedPostLimitGuideModel = (FeedPostLimitGuideModel) obj;
        return this.isFirstDisplay == feedPostLimitGuideModel.isFirstDisplay && this.showPosition == feedPostLimitGuideModel.showPosition;
    }

    public final int getShowPosition() {
        return this.showPosition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.isFirstDisplay;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.showPosition;
    }

    public final boolean isFirstDisplay() {
        return this.isFirstDisplay;
    }

    public final void setFirstDisplay(boolean z10) {
        this.isFirstDisplay = z10;
    }

    public final void setShowPosition(int i10) {
        this.showPosition = i10;
    }

    @NotNull
    public String toString() {
        return "FeedPostLimitGuideModel(isFirstDisplay=" + this.isFirstDisplay + ", showPosition=" + this.showPosition + ")";
    }

    public /* synthetic */ FeedPostLimitGuideModel(boolean z10, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? -1 : i10);
    }
}
